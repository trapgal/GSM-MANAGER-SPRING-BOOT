package org.sid.service.Impl;

import java.util.List;

import org.sid.dao.EntiteDao;
import org.sid.entities.Entite;
import org.sid.entities.Personnel;
import org.sid.service.IEntiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class EntiteServiceImpl implements IEntiteService {
@Autowired
public EntiteDao entiteDao;
	@Override
	public List<Entite> listEntites() {
		return entiteDao.findAll();
	}

	@Override
	public Entite creerEntite(String nomEntite, String typeEntite, Entite entiteMere) {
Entite e = new Entite(nomEntite,typeEntite,entiteMere);
entiteDao.save(e);
return e;	
		}

	
	/*
	 * @Override public Entite supprimerEntite(Long id) {
	 * entiteDao.delete(entiteDao.findOne(id)); return null; }
	 */
	

	@Override
	public Entite creerEntite2(String nomEntite, String typeEntite, String entiteMere) {
Entite 	em = new Entite();
em.setNomEntite(entiteMere);
em.setEntiteMere(entiteDao.findOne(new Long(9)));
entiteDao.save(em);
Entite e = new Entite(nomEntite,typeEntite,em);
entiteDao.save(e);
return e;
	}

	@Override
	public Entite modifierEntite(Long idE, String nomEntite, String typeEntite, String entiteMere) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int supprimerEntite(Long id) {
		Entite e =entiteDao.findOne(id);
		List<Entite> entites = entiteDao.findByEntiteMere(e);
		if(entites.isEmpty()) {
			entiteDao.delete(e);
			System.out.println("ghadi tms7");
return 1;
		}else {
			System.out.println("maghadich tms7");

return 0;
}
	}

	

	

	/*
	 * @Override public Entite modifierEntite(Long idE, String nomEntite, String
	 * typeEntite, String entiteMere) { Entite e = new Entite(idE, nomEntite,
	 * typeEntite); if(e.getEntiteMere() == null) {
	 * e.getEntiteMere().setNomEntite(entiteMere);
	 * System.out.println("hahya"+e.getEntiteMere().getNomEntite());
	 * entiteDao.save(e);
	 * 
	 * return e; }
	 * 
	 * 
	 * }
	 */
}
	

	
