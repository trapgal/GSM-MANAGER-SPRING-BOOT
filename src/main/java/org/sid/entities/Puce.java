package org.sid.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;

import javax.persistence.Id;
@Entity
public class Puce implements Serializable {
	
	@Id @GeneratedValue
    private Long id;
    private String numero;
    private Long code;
    private String type_puce;
    private String etat;
    private String observation;
    @OneToMany(mappedBy = "puce")
    private Collection<Dotation> dotations;
    @OneToMany(mappedBy = "puce")
    private Collection<PersonnelPuce> personnelPuces;
    
	public Puce() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Puce(Long id, String numero, Long code, String type_puce, String etat, String observation,
			Collection<Dotation> dotations, Collection<PersonnelPuce> personnelPuces) {
		super();
		this.id = id;
		this.numero = numero;
		this.code = code;
		this.type_puce = type_puce;
		this.etat = etat;
		this.observation = observation;
		this.dotations = dotations;
		this.personnelPuces = personnelPuces;
	}

	public Puce(String numero, Long code, String type_puce, String etat, String observation) {
		super();
		this.numero = numero;
		this.code = code;
		this.type_puce = type_puce;
		this.etat = etat;
		this.observation = observation;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getType_puce() {
		return type_puce;
	}
	public void setType_puce(String type_puce) {
		this.type_puce = type_puce;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public Collection<Dotation> getDotations() {
		return dotations;
	}
	public void setDotations(Collection<Dotation> dotations) {
		this.dotations = dotations;
	}
	public Collection<PersonnelPuce> getPersonnelPuces() {
		return personnelPuces;
	}
	public void setPersonnelPuces(Collection<PersonnelPuce> personnelPuces) {
		this.personnelPuces = personnelPuces;
	}

}
