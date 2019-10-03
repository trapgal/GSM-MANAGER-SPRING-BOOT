package org.sid.dao;

import java.util.List;

import org.sid.entities.Dotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DotationDao extends JpaRepository<Dotation, Long>{
	@Query("Select d FROM Dotation d WHERE d.puce.numero=x")
	public List<Dotation> findP(@Param("x")Long numero);

}
