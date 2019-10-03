package org.sid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;

@Entity
public class PersonnelPuce implements Serializable {
	    
	@Id @GeneratedValue
	    private Long id;
	private Date dateAffectation;
	    private Date dateDesaffectation;
	    @ManyToOne
	    private Personnel personnel;
	    @ManyToOne
	    private Puce puce;
	    
		public PersonnelPuce() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public PersonnelPuce(Long id, Date dateAffectation, Date dateDesaffectation) {
			super();
			this.id = id;
			this.dateAffectation = dateAffectation;
			this.dateDesaffectation = dateDesaffectation;
		}

		public PersonnelPuce( Date dateAffectation, Date dateDesaffectation, Personnel personnel, Puce puce) {
			super();
			this.dateAffectation = dateAffectation;
			this.dateDesaffectation = dateDesaffectation;
			this.personnel = personnel;
			this.puce = puce;
		}

		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Date getDateAffectation() {
			return dateAffectation;
		}
		public void setDateAffectation(Date dateAffectation) {
			this.dateAffectation = dateAffectation;
		}
		public Date getDateDesaffectation() {
			return dateDesaffectation;
		}
		public void setDateDesaffectation(Date dateDesaffectation) {
			this.dateDesaffectation = dateDesaffectation;
		}
		public Personnel getPersonnel() {
			return personnel;
		}
		public void setPersonnel(Personnel personnel) {
			this.personnel = personnel;
		}
		public Puce getPuce() {
			return puce;
		}
		public void setPuce(Puce puce) {
			this.puce = puce;
		}
	    

}
