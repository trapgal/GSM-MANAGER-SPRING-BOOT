package org.sid.service;

import java.util.List;

import org.sid.entities.Personnel;


public interface IPersonnelService {
	public List<Personnel> listPersonnels();
	public Personnel creerPersonnel(Long matricule,String nom, String prenom, String observation, Long id);
public Personnel findPersonnel(Long id);
public Personnel findPersonnelByMatricule(Long mat);
public Personnel modifierPersonnel(Long idPer,Long matricule, String nom, String prenom, String observation, Long id);
public Personnel supprimerPersonnel(Long idPer);

}
