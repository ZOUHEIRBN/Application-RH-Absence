package com.pepsi.rh.repo;

import java.util.List;

import com.pepsi.rh.entities.Collaborator;
import com.pepsi.rh.entities.Departs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IDepart extends JpaRepository<Departs, Long>{
	   List<Departs> findByCollaborateur(Collaborator collaborateur);
      
	
}
