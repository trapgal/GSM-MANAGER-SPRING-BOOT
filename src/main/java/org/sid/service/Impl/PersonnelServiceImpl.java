package org.sid.service.Impl;

import java.util.List;

import org.sid.dao.EntiteDao;
import org.sid.dao.PersonnelDao;
import org.sid.entities.Entite;
import org.sid.entities.Personnel;
import org.sid.service.IPersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class PersonnelServiceImpl implements IPersonnelService {
@Autowired
	private PersonnelDao personnelDao;
@Autowired
private EntiteDao entitedao;

@Override
public List<Personnel> listPersonnels() {
	return personnelDao.findAll();
}

@Override
public Personnel creerPersonnel(Long matricule, String nom, String prenom, String observation, Long id) {
	Personnel p = new Personnel(matricule, nom, prenom, observation, entitedao.findOne(id));
	personnelDao.save(p);
	return p;	
}


	



@Override
public Personnel findPersonnel(Long id) {
return personnelDao.findOne(id);
}

@Override
public Personnel findPersonnelByMatricule(Long mat) {
	return personnelDao.findByMatricule(mat)	;
}

@Override
public Personnel modifierPersonnel(Long idPer, Long matricule, String nom, String prenom, String observation, Long id) {
	Personnel pers= new Personnel(matricule, nom, prenom, observation);
	pers.setId(idPer);
	pers.setEntite(entitedao.findOne(id));
	personnelDao.save(pers);
		return pers;
	
}

@Override
public Personnel supprimerPersonnel(Long idPer) {
personnelDao.delete(idPer);
	return null;
}



}
