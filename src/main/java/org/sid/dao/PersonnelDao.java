package org.sid.dao;

import java.util.List;

import org.sid.entities.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonnelDao extends JpaRepository<Personnel, Long>{
public Personnel findByMatricule(Long matricule);
public List<Personnel> findByNomContainingIgnoreCase(String mc);

public List<Personnel> findByMatriculeContaining(Long mat);
}
