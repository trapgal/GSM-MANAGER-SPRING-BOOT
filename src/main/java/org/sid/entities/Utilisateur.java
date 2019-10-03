package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;

import javax.persistence.Id;
@Entity
public class Utilisateur implements Serializable {
	    
	
	    @Id 
	    private String username;
	    private String password;
	    private String profil;
	    private String observation;
	    private Boolean active;
	    
		public Utilisateur() {
			super();
			// TODO Auto-generated constructor stub
		}
		

		public Utilisateur(String username, String password, String profil, String observation) {
			super();
			this.username = username;
			this.password = password;
			this.profil = profil;
			this.observation = observation;
		}


		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getProfil() {
			return profil;
		}

		public void setProfil(String profil) {
			this.profil = profil;
		}

		public String getObservation() {
			return observation;
		}

		public void setObservation(String observation) {
			this.observation = observation;
		}

		public Boolean getActive() {
			return active;
		}

		public void setActive(Boolean active) {
			this.active = active;
		}
		
		
	    
}
