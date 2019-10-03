package org.sid.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Personnel implements Serializable {
	
	@Id @GeneratedValue
    private Long id;
    private Long matricule;
    private String nom;
    private String prenom;
    private String observation;
    @OneToMany(mappedBy = "personnel")
    private Collection<PersonnelPuce> personnelPuces;
   @ManyToOne
    private Entite entite;
	public Personnel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Personnel(Long matricule, String nom, String prenom, String observation) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.observation = observation;
	}

	

	public Personnel(Long matricule, String nom, String prenom, String observation, Entite entite) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.observation = observation;
		this.entite = entite;
	}


	public Personnel(Long matricule, String nom, String prenom, String observation,
			Collection<PersonnelPuce> personnelPuces, Entite entite) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.observation = observation;
		this.personnelPuces = personnelPuces;
		this.entite = entite;
	}


	public Long getId() {
		return id;
	}
	
	public Entite getEntite() {
		return entite;
	}

	public void setEntite(Entite entite) {
		this.entite = entite;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getMatricule() {
		return matricule;
	}
	public void setMatricule(Long matricule) {
		this.matricule = matricule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public Collection<PersonnelPuce> getPersonnelPuces() {
		return personnelPuces;
	}
	public void setPersonnelPuces(Collection<PersonnelPuce> personnelPuces) {
		this.personnelPuces = personnelPuces;
	}
    
}
