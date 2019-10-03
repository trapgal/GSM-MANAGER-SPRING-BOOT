package org.sid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;

@Entity
public class Dotation implements Serializable {
	
	@Id @GeneratedValue
    private Long id;
    private Double solde;
private Date dateDotation;
    private String observation;
    @ManyToOne
    private Puce puce;
    
    
	public Dotation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Dotation(Long id, Double solde, Date dateDotation, String observation) {
		super();
		this.id = id;
		this.solde = solde;
		this.dateDotation = dateDotation;
		this.observation = observation;
	}
	

	public Dotation( Double solde, Date dateDotation, String observation, Puce puce) {
		super();
		this.solde = solde;
		this.dateDotation = dateDotation;
		this.observation = observation;
		this.puce = puce;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getSolde() {
		return solde;
	}
	public void setSolde(Double solde) {
		this.solde = solde;
	}
	public Date getDateDotation() {
		return dateDotation;
	}
	public void setDateDotation(Date dateDotation) {
		this.dateDotation = dateDotation;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public Puce getPuce() {
		return puce;
	}
	public void setPuce(Puce puce) {
		this.puce = puce;
	}
    
}
