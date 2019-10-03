package org.sid.controller;



import java.io.IOException;

import javax.servlet.http.HttpServletResponse;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.sid.dao.DotationDao;
import org.sid.dao.EntiteDao;
import org.sid.dao.PersonnelDao;
import org.sid.dao.PersonnelPuceDao;
import org.sid.dao.PuceDao;
import org.sid.entities.Dotation;
import org.sid.entities.Entite;
import org.sid.entities.Personnel;
import org.sid.entities.PersonnelPuce;
import org.sid.entities.Puce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import groovy.util.logging.Log4j2;

@Controller
@Log4j2
public class ExcelReportController {
	
	

	    private static final String EXCEL_FILE_NAME = "dotations.xls";
	    @Autowired
	    DotationDao dotationDao;
	    @Autowired
		private PersonnelDao personnelDao;
		@Autowired
		private EntiteDao entiteDao;
		@Autowired
		private PuceDao puceDao;
		@Autowired
		private PersonnelPuceDao personnelPuceDao;
	   


	    @GetMapping(value = "/download")
	    public void buildNDownload(HttpServletResponse response) throws IOException {
	        response.setHeader("Content-disposition", "attachment; filename=liste_dotations.xlsx");
	        Iterable<Dotation> dotations = dotationDao.findAll();
	        //build a file from scratch and then download
	        Workbook workbook = new XSSFWorkbook();
	        Sheet sheet = workbook.createSheet("Liste des dotations");
	        Row header = sheet.createRow(0);
	        header.createCell(0).setCellValue("ID");
	        header.createCell(1).setCellValue("Puce");
	        header.createCell(2).setCellValue("Solde");
	        header.createCell(3).setCellValue("Observation");

	        int rowNum = 1;
	        for (Dotation d : dotations) {
	            Row row = sheet.createRow(rowNum++);
	            row.createCell(0).setCellValue(d.getId());
	            row.createCell(1).setCellValue(d.getPuce().getNumero());
	            row.createCell(2).setCellValue(d.getSolde());
	            row.createCell(3).setCellValue(d.getObservation());
	            
	        }
	        workbook.write(response.getOutputStream());
	    }
	     @GetMapping(value = "/downloadP")
	    public void buildNDownloadP(HttpServletResponse response) throws IOException {
	        response.setHeader("Content-disposition", "attachment; filename=liste_personnels.xlsx");
	        Iterable<Personnel> personnels = personnelDao.findAll();
	        //build a file from scratch and then download
	        Workbook workbook = new XSSFWorkbook();
	        Sheet sheet = workbook.createSheet("Liste des personnels");
	        Row header = sheet.createRow(0);
	        header.createCell(0).setCellValue("Matricule");
	        header.createCell(1).setCellValue("Nom");
	        header.createCell(2).setCellValue("Prenom");
	        header.createCell(3).setCellValue("Nom Entite");
	        header.createCell(4).setCellValue("Observation");

	        int rowNum = 1;
	        for (Personnel d : personnels) {
	            Row row = sheet.createRow(rowNum++);
	            row.createCell(0).setCellValue(d.getMatricule());
	            row.createCell(1).setCellValue(d.getNom());
	            row.createCell(2).setCellValue(d.getPrenom());
	            row.createCell(3).setCellValue(d.getEntite().getNomEntite());
	            row.createCell(4).setCellValue(d.getObservation());
	            
	        }
	        workbook.write(response.getOutputStream());
	    }
	     @GetMapping(value = "/downloadE")
		    public void buildNDownloadE(HttpServletResponse response) throws IOException {
		        response.setHeader("Content-disposition", "attachment; filename=liste_entites.xlsx");
		        Iterable<Entite> entites = entiteDao.findAll();
		        //build a file from scratch and then download
		        Workbook workbook = new XSSFWorkbook();
		        Sheet sheet = workbook.createSheet("Liste des entites");
		        Row header = sheet.createRow(0);
		        header.createCell(0).setCellValue("Nom Entite");
		        header.createCell(1).setCellValue("Type Entite");
		        header.createCell(2).setCellValue("Entite Mere");
		        

		        int rowNum = 1;
		        for (Entite d : entites) {
		            Row row = sheet.createRow(rowNum++);
		            row.createCell(0).setCellValue(d.getNomEntite());
		            row.createCell(1).setCellValue(d.getTypeEntite());
		            row.createCell(2).setCellValue(d.getEntiteMere().getNomEntite());
		            
		            
		        }
		        workbook.write(response.getOutputStream());
		    }
	     @GetMapping(value = "/downloadA")
		    public void buildNDownloadA(HttpServletResponse response) throws IOException {
		        response.setHeader("Content-disposition", "attachment; filename=liste_affectations.xlsx");
		        Iterable<PersonnelPuce> p = personnelPuceDao.findAll();
		        //build a file from scratch and then download
		        Workbook workbook = new XSSFWorkbook();
		        Sheet sheet = workbook.createSheet("Liste des affectations");
		        Row header = sheet.createRow(0);
		        header.createCell(0).setCellValue("Matricule");
		        header.createCell(1).setCellValue("Nom");
		        header.createCell(2).setCellValue("Prenom");
		        header.createCell(3).setCellValue("Numero");
		        header.createCell(4).setCellValue("Etat");
		        header.createCell(5).setCellValue("type de puce");

		        

		        int rowNum = 1;
		        for (PersonnelPuce d : p) {
		            Row row = sheet.createRow(rowNum++);
		            row.createCell(0).setCellValue(d.getPersonnel().getMatricule());
		            row.createCell(1).setCellValue(d.getPersonnel().getNom());
		            row.createCell(2).setCellValue(d.getPersonnel().getPrenom());
		            row.createCell(3).setCellValue(d.getPuce().getNumero());
		            row.createCell(4).setCellValue(d.getPuce().getEtat());
		            row.createCell(5).setCellValue(d.getPuce().getType_puce());


		            
		            
		        }
		        workbook.write(response.getOutputStream());
		    }
	     @GetMapping(value = "/downloadC")
		    public void buildNDownloadC(HttpServletResponse response) throws IOException {
		        response.setHeader("Content-disposition", "attachment; filename=liste_puces.xlsx");
		        Iterable<Puce> puces = puceDao.findAll();
		        //build a file from scratch and then download
		        Workbook workbook = new XSSFWorkbook();
		        Sheet sheet = workbook.createSheet("Liste des puces");
		        Row header = sheet.createRow(0);
		        header.createCell(0).setCellValue("Numero");
		        header.createCell(1).setCellValue("Code");
		        header.createCell(2).setCellValue("Etat");
		        header.createCell(3).setCellValue("Type de puce");
		        header.createCell(4).setCellValue("Observation");

		        

		        int rowNum = 1;
		        for (Puce d : puces) {
		            Row row = sheet.createRow(rowNum++);
		            row.createCell(0).setCellValue(d.getNumero());
		            row.createCell(1).setCellValue(d.getCode());
		            row.createCell(2).setCellValue(d.getEtat());
		            row.createCell(3).setCellValue(d.getType_puce());
		            row.createCell(4).setCellValue(d.getObservation());


		            
		            
		        }
		        workbook.write(response.getOutputStream());
		    }

}
