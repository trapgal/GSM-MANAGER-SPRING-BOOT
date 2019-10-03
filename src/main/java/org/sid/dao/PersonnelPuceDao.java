package org.sid.dao;

import java.util.List;

import org.sid.entities.Entite;
import org.sid.entities.PersonnelPuce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonnelPuceDao extends JpaRepository<PersonnelPuce, Long>{
	
	
	  @Query("Select p from  PersonnelPuce p where p.puce.type_puce like :x order by p.dateAffectation desc"
	  ) public List<PersonnelPuce> listPP(@Param("x")String type_puce);
	 

}
