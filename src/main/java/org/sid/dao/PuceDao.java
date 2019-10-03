package org.sid.dao;

import java.util.List;

import org.sid.entities.Puce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PuceDao extends JpaRepository<Puce, Long>{
	@Query("Select p FROM Puce p WHERE p.etat LIKE 'enStock'")
	public List<Puce> listEnStock();
	//public List<Puce> findByType_puce(String type_puce);
	public List<Puce> findByEtat(String etat );	
}
