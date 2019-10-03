package org.sid.service.Impl;

import java.util.Date;

import org.sid.dao.PersonnelDao;
import org.sid.dao.PersonnelPuceDao;
import org.sid.dao.PuceDao;
import org.sid.entities.Personnel;
import org.sid.entities.PersonnelPuce;
import org.sid.service.IPersonnelPuceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonnelPuceServiceImpl implements IPersonnelPuceService{
	@Autowired
PersonnelPuceDao personnelPuceDao;
	@Autowired
	PersonnelDao personnelDao;
	@Autowired
	PuceDao puceDao;
	DateUtil dateUtil;
	
	@Override
	public PersonnelPuce creerPersonnelPuce(Long idPuce, Long idPersonnel, Date dateAffectation, Date dateDesaffectation) {
PersonnelPuce pp =  new PersonnelPuce(dateAffectation, dateDesaffectation, personnelDao.findOne(idPersonnel), puceDao.findOne(idPuce));
personnelPuceDao.save(pp);
		return pp;
	}

	@Override
	public PersonnelPuce modifierPersonnelPuce2(Long idA, Long idPuce, Long idPersonnel, String dateAffectation,
			String dateDesaffectation) {
		Date d1 =dateUtil.convert(dateAffectation);
		Date d2 = dateUtil.convert(dateDesaffectation);
		PersonnelPuce personnelPuce = new PersonnelPuce(d1,d2, personnelDao.findOne(idPersonnel),puceDao.findOne(idPuce));
				  personnelPuce.setId(idA); personnelPuceDao.save(personnelPuce); 
				  return  personnelPuce;		
	}

	@Override
	public PersonnelPuce modifierPersonnelPuce(Long idA, Long idPuce, Long idPersonnel, Date dateAffectation,
			Date dateDesaffectation) {
		PersonnelPuce personnelPuce = new PersonnelPuce(dateAffectation,dateDesaffectation, personnelDao.findOne(idPersonnel),puceDao.findOne(idPuce));
		  personnelPuce.setId(idA); 
		  personnelPuceDao.save(personnelPuce); 

		return personnelPuce;
	}

	
	
}
