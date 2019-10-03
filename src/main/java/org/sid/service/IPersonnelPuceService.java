package org.sid.service;

import java.util.Date;

import org.sid.entities.PersonnelPuce;

public interface IPersonnelPuceService {
public PersonnelPuce creerPersonnelPuce(Long idPuce, Long idPersonnel, Date dateAffectation,Date dateDesaffectation);
public PersonnelPuce modifierPersonnelPuce2(Long idA,Long idPuce, Long idPersonnel, String dateAffectation, String dateDesaffectation);
public PersonnelPuce modifierPersonnelPuce(Long idA,Long idPuce, Long idPersonnel, Date dateAffectation, Date dateDesaffectation);

}
