package org.sid.dao;

import java.util.List;

import org.sid.entities.Entite;
import org.sid.entities.PersonnelPuce;
import org.sid.entities.Puce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EntiteDao extends JpaRepository<Entite, Long>{
List<Entite> findByNomEntiteContainingIgnoreCase(String nomEntite);

List<Entite> findByEntiteMere(Entite entite);

@Query("Select e FROM Entite e WHERE e.entiteMere.id=x")
public List<Entite> findAllEntites(@Param("x")Long id);

}
