package org.sid.service.Impl;

import java.util.Date;

import org.sid.dao.DotationDao;
import org.sid.entities.Dotation;
import org.sid.entities.Puce;
import org.sid.service.IDotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DotationServiceImpl implements IDotationService{
@Autowired
private DotationDao dotationDao;

@Override
public Dotation creerDotation(Double solde, String observation, Date dateDotation, Puce puce) {
Dotation dotation =  new Dotation(solde, dateDotation,observation,  puce);
dotationDao.save(dotation);
		return dotation;
}

@Override
public Dotation modifierDotation(Long id, Double solde, String observation, Date dateDotation, Puce puce) {
Dotation d = new Dotation(solde, dateDotation, observation, puce);
d.setId(id);
dotationDao.save(d);
	return null;
}

@Override
public Dotation supprimerDotation(Long id) {
dotationDao.delete(dotationDao.findOne(id));	return null;
}

}
