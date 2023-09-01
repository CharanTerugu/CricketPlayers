package com.cricket.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cricket.project.entity.Cricketer;
@Repository
public interface CricketerRepository extends JpaRepository<Cricketer, Integer>  {

	@Query("select p from cricketer p where p.teams.id=?1")
	List<Cricketer> getPlayers(int id);
	@Query("select p from cricketer p where p.name=?1")
	Cricketer getByName(String name);
	@Query("select sum(p.bidPrice) from cricketer p where p.teams.id=?1")
	Double getTotalSpends(int id);
	@Query("select p from cricketer p where p.teams.id=null")
	List<Cricketer> getUnAssigned();
}
