package org.sid.controller;

import java.lang.String;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.sid.dao.DotationDao;
import org.sid.dao.EntiteDao;
import org.sid.dao.PersonnelDao;
import org.sid.dao.PersonnelPuceDao;
import org.sid.dao.PuceDao;
import org.sid.dao.UtilisateurDao;
import org.sid.entities.Dotation;
import org.sid.entities.Entite;
import org.sid.entities.Personnel;
import org.sid.entities.PersonnelPuce;
import org.sid.entities.Puce;
import org.sid.entities.Utilisateur;
import org.sid.service.IDotationService;
import org.sid.service.IEntiteService;
import org.sid.service.IPersonnelPuceService;
import org.sid.service.IPersonnelService;
import org.sid.service.IPuceService;
import org.sid.service.Impl.DateUtil;
import org.sid.service.Impl.DateUtil1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GsmManagerController {
	@Autowired
	private IPersonnelService iPersonnelService;

	@Autowired
	private IEntiteService ientiteService;
	@Autowired
	private IPersonnelPuceService iPersonnelPuceService;
	@Autowired
	private IDotationService iDotationService;
	@Autowired
	private IPuceService iPuceService;
	@Autowired
	private PersonnelDao personnelDao;
	@Autowired
	private EntiteDao entiteDao;
	@Autowired
	private PuceDao puceDao;
	@Autowired
	private PersonnelPuceDao personnelPuceDao;

	@Autowired
	private DotationDao dotationDao;
	@Autowired
	private UtilisateurDao utilisateurDao;
	@Autowired
	private DateUtil1 dateUtil1;
	/* PERSONNELS */

	@RequestMapping("/index")
	public String index() {
		return "index";

	}

	@RequestMapping("/Personnels")
	public String AllPersonnels(Model model) {
		System.out.println("welcome to personnels");

		// List<Puce> listp= puceDao.listEnStock();
		// listp.forEach(p -> { System.out.println(p.getEtat()); });
		model.addAttribute("lsPersonnels", iPersonnelService.listPersonnels());
		model.addAttribute("entites", ientiteService.listEntites());
		return "index";
	}

	@RequestMapping(value = "/creerPersonnels", method = RequestMethod.POST)
	public String creerPersonnels(Model model, Long matricule, String nom, String prenom, String observation, Long id) {
		System.out.println("i am in creer personnel");

		Personnel p = iPersonnelService.creerPersonnel(matricule, nom, prenom, observation, id);

		model.addAttribute("personnel", p);

		return "redirect:/Personnels";
	}

	@RequestMapping(value = "/editPersonnel", method = RequestMethod.POST)
	public String editP(Long idPer, Long matricule, String nom, String prenom, String observation, Long id) {
		iPersonnelService.modifierPersonnel(idPer, matricule, nom, prenom, observation, id);

		return "redirect:/Personnels";
	}

	@PostMapping("/deletePersonnel")
	public String deleteP(Long idP) {
		iPersonnelService.supprimerPersonnel(idP);

		return "redirect:/Personnels";
	}

	@RequestMapping("/recherchePer")
	public String recherchePers(Model model, @RequestParam(name = "motCle", defaultValue = "") String mc) {
		System.out.println("salam");
		model.addAttribute("entites", ientiteService.listEntites());
		List<Personnel> personnels = personnelDao.findByNomContainingIgnoreCase(mc);

		// System.out.println("taille de la liste:"+personnels .size());
		// personnels.forEach( p -> { System.out.println("ha nom lowl :"+p.getNom());
		// });
		model.addAttribute("lsPersonnels", personnels);

		return "index";
	}
	/* ENTITES */

	@RequestMapping("/entites")
	public String allEntites(Model model) {

		model.addAttribute("lsEntites", entiteDao.findAll());
		model.addAttribute("entites", ientiteService.listEntites());
		return "entites";
	}

	@RequestMapping(value = "/creerEntite", method = RequestMethod.POST)
	public String creerEntite(Model model, String nomEntite, String typeEntite, Long id) {

		Entite e = ientiteService.creerEntite(nomEntite, typeEntite, entiteDao.findOne(id));
		model.addAttribute("entite", e);

		return "redirect:/entites";
	}

	@RequestMapping(value = "/editEntite", method = RequestMethod.POST)
	public String editE(Long idE, String nomEntite, String typeEntite, String entiteMere) {
		ientiteService.modifierEntite(idE, nomEntite, typeEntite, entiteMere);

		return "redirect:/entites";
	}

	@PostMapping("/deleteEntite")
	public String deleteE(Model model, Long idE) {

		ientiteService.supprimerEntite(idE);

		return "redirect:/entites";
	}

	@RequestMapping("/rechercheEntite")
	public String rechercheEntite(Model model, @RequestParam(name = "motCle", defaultValue = "") String mc) {
		List<Entite> es = entiteDao.findByNomEntiteContainingIgnoreCase(mc);
		model.addAttribute("lsEntites", entiteDao.findAll());
		model.addAttribute("entites", ientiteService.listEntites());
		model.addAttribute("lsEntites", es);
		return "entites";
	}

	/* AFFECTATIONS */
	@RequestMapping("/affectations")
	public String AllAffectations(Model model) {

		model.addAttribute("lsAffectations", personnelPuceDao.findAll());
		model.addAttribute("lsEnstock", puceDao.listEnStock());
		model.addAttribute("lsPersonnel", personnelDao.findAll());

		return "affectations";
	}

	@RequestMapping(value = "/creerAffectation", method = RequestMethod.POST)
	public String creerAffectation(Model model, Long idPuce, Long idPersonnel, String dateAffectation)
			throws ParseException {
	

		Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(dateAffectation);
		Date d1 = dateUtil1.parse(dateAffectation);
		
		PersonnelPuce personnelPuce = iPersonnelPuceService.creerPersonnelPuce(idPuce, idPersonnel, d1, null);


		return "redirect:/affectations";
	}
	@RequestMapping(value = "/editAffectation", method = RequestMethod.POST)
	public String editAffectation(Long idA, Model model, Long idPuce, Long idPersonnel, String dateAffectation,String dateDesaffectation) {
		Date d1 = dateUtil1.parse(dateAffectation);
		Date d2 = dateUtil1.parse(dateAffectation);
iPersonnelPuceService.modifierPersonnelPuce(idA, idPuce, idPersonnel, d1, d2);
		return "redirect:/entites";
	}
	@PostMapping("/deleteAffectation")
	public String deleteA(Model model, Long idA) {

		personnelPuceDao.delete(personnelPuceDao.findOne(idA));

		return "redirect:/affectations";
	}

	@RequestMapping("/rechercheAffectation")
	public String rechercheAffectation(Model model,

			@RequestParam(name = "type_puce", defaultValue = "") String type_puce) {
		model.addAttribute("lsEnstock", puceDao.listEnStock());
		model.addAttribute("lsPersonnel", personnelDao.findAll());
		List<PersonnelPuce> listP = personnelPuceDao.listPP(type_puce);
		model.addAttribute("lsAffectations", listP);
		return "affectations";
	}

	/* DOTATIONS */
	@RequestMapping("/dotations")
	public String AllDotations(Model model) {

		model.addAttribute("lsDotations", dotationDao.findAll());
		model.addAttribute("lsEnstock", puceDao.listEnStock());
		model.addAttribute("lsPuces", iPuceService.listPuces());

		// model.addAttribute("entites",ientiteService.listEntites() );
		return "dotations";
	}

	@RequestMapping(value = "/creerDotation", method = RequestMethod.POST)
	public String creerDotation(Model model, Double solde, String observation, String dateDotation, Long idPu)
			throws ParseException {
		Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(dateDotation);

		Dotation dotation = iDotationService.creerDotation(solde, observation, date1, puceDao.findOne(idPu));
		model.addAttribute("dotation", dotation);

		return "redirect:/dotations";
	}

	@RequestMapping(value = "/editDotation", method = RequestMethod.POST)
	public String editD(Model model, Long idD, Long idPuce, Double solde, String dateDotation, String observation)
			throws ParseException {

		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

		// String todayAsString = df.format(pp.getDateAffectation());
		// model.addAttribute("val", todayAsString);
		Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(dateDotation);

		Dotation dotation = iDotationService.modifierDotation(idD, solde, observation, date1, puceDao.findOne(idPuce));
		return "redirect:/dotations";
	}

	@PostMapping("/deleteDotations")
	public String deleteD(Model model, Long idD) {

		dotationDao.delete(dotationDao.findOne(idD));

		return "redirect:/dotations";
	}

	/*
	 * @RequestMapping("/rechercheDotation")
	 * 
	 * String rechercheD(Model model, @RequestParam(name = "numero", defaultValue =
	 * "") String numero) { model.addAttribute("lsPuces", iPuceService.listPuces());
	 * 
	 * System.out.println("hello "+numero); Long num2 = Long.parseLong(numero);
	 * 
	 * System.out.println(num2+"3iw");
	 * 
	 * 
	 * model.addAttribute("lsDotations", dts);
	 * 
	 * return "dotations"; }
	 */
	/* PUCES */
	@RequestMapping("/puces")
	public String AllPuces(Model model) {

		model.addAttribute("lsPuces", iPuceService.listPuces());

		return "puces";
	}

	@RequestMapping(value = "/creerPuce", method = RequestMethod.POST)
	public String creerP(Model model, String numero, Long code, String type_puce, String etat, String observation) {
		Puce p = iPuceService.creerPuce(numero, code, type_puce, etat, observation);
		model.addAttribute("puce", p);

		return "redirect:/puces";
	}

	@RequestMapping(value = "/editPuce", method = RequestMethod.POST)
	public String editP(Model model, Long idP, String numero, Long code, String type_puce, String etat,
			String observation) {

		Puce p = iPuceService.modifierPuce(idP, numero, code, type_puce, etat, observation);
		return "redirect:/puces";
	}

	@PostMapping("/deletePuces")
	public String deleteP(Model model, Long idPu) {

		iPuceService.supprimerPuce(idPu);

		return "redirect:/puces";
	}

	@RequestMapping("/recherchePuce")
	public String recherchePuce(Model model, @RequestParam(name = "etat", defaultValue = "") String etat) {
		List<Puce> pucess = puceDao.findByEtat(etat);
		model.addAttribute("lsPuces", pucess);

		return "puces";
	}
	/* CHART */
	
	

	
	/*
	 * @RequestMapping(value="/annulerAffectations", method=RequestMethod.POST,
	 * params="action=cancel") public String annulerDotations() {
	 * 
	 * return "dotations"; }
	 */

}