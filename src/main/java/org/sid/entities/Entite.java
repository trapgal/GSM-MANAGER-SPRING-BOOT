package org.sid.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Id;

@Entity
public class Entite implements Serializable {
	
	@Id @GeneratedValue
    private Long id;
    private String nomEntite;
    private String typeEntite;
    @OneToMany(mappedBy="entite")
    private Collection<Personnel> personnels;
    @ManyToOne
    private Entite entiteMere;
    
	public Entite() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Entite(Long id) {
		super();
		this.id = id;
	}


	public Entite(String nomEntite, String typeEntite, Entite entiteMere) {
		super();
		this.nomEntite = nomEntite;
		this.typeEntite = typeEntite;
		this.entiteMere = entiteMere;
	}

	public Entite(Long id, String nomEntite, String typeEntite, Entite entiteMere) {
		super();
		this.id = id;
		this.nomEntite = nomEntite;
		this.typeEntite = typeEntite;
		this.entiteMere = entiteMere;
	}
	

	public Entite(Long id, String nomEntite, String typeEntite) {
		super();
		this.id = id;
		this.nomEntite = nomEntite;
		this.typeEntite = typeEntite;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomEntite() {
		return nomEntite;
	}
	public void setNomEntite(String nomEntite) {
		this.nomEntite = nomEntite;
	}
	public String getTypeEntite() {
		return typeEntite;
	}
	public void setTypeEntite(String typeEntite) {
		this.typeEntite = typeEntite;
	}
	public Entite getEntiteMere() {
		return entiteMere;
	}
	public void setEntiteMere(Entite entiteMere) {
		this.entiteMere = entiteMere;
	}
	
	
    
}
