package org.sid.service;

import java.util.List;

import org.sid.entities.Entite;

public interface IEntiteService {
	public List<Entite> listEntites();
	public Entite creerEntite(String nomEntite, String typeEntite,  Entite entiteMere);
	public Entite creerEntite2(String nomEntite, String typeEntite,  String entiteMere);
	
	public Entite modifierEntite(Long idE, String nomEntite, String typeEntite,
			  String entiteMere ) ;
	public int supprimerEntite(Long id);

}
