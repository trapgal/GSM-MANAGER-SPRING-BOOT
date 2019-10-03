package org.sid.service;

import java.util.List;

import org.sid.entities.Puce;

public interface IPuceService {
	public List<Puce> listPuces();
	public Puce creerPuce(String numero,Long code,String type_puce,String etat,String observation);
    
	/*
	 * public List<Puce> findPuceByType_puce(String type_puce);
	 */public List<Puce> findPuceByEtat(String etat );
public Puce modifierPuce(Long idPuce,String numero,Long code,String type_puce,String etat,String observation);
public void supprimerPuce(Long idPuce);
}
