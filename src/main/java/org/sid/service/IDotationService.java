package org.sid.service;

import java.util.Date;
import java.util.List;

import org.sid.entities.Dotation;
import org.sid.entities.Entite;
import org.sid.entities.Puce;

public interface IDotationService {
	
	  public Dotation creerDotation(
	  Double solde, String observation,Date dateDotation, Puce puce); 
	  
	  public Dotation  modifierDotation(Long id, Double solde, String observation,Date dateDotation, Puce puce ) ;
	  public Dotation supprimerDotation(Long id);
	 
}
