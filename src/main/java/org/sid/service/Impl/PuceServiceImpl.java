package org.sid.service.Impl;

import java.util.List;

import org.sid.dao.PuceDao;
import org.sid.entities.Puce;
import org.sid.service.IPuceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PuceServiceImpl implements IPuceService{
@Autowired
PuceDao puceDao;



@Override
public Puce creerPuce(String numero, Long code, String type_puce, String etat, String observation) {
Puce p =  new Puce(numero, code, type_puce, etat, observation);
puceDao.save(p);
	return p;
}

	/*
	 * @Override public List<Puce> findPuceByType_puce(String type_puce) { return
	 * new List<Puce>() ; //return puceDao.findByType_puce(type_puce); }
	 */


@Override
public List<Puce> findPuceByEtat(String etat) {
return puceDao.findByEtat(etat);
}



@Override
public List<Puce> listPuces() {
	 	return puceDao.findAll();

}

@Override
public Puce modifierPuce(Long idPuce, String numero, Long code, String type_puce, String etat, String observation) {
	Puce p = new Puce(numero, code, type_puce, etat, observation);
	p.setId(idPuce);
	puceDao.save(p);
		return p;
}

@Override
public void supprimerPuce(Long idPuce) {
	puceDao.delete(puceDao.findOne(idPuce));	
}
}
