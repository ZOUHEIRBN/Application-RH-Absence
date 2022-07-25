package com.pepsi.rh.repo;

import java.util.List;

import com.pepsi.rh.entities.Collaborator;
import com.pepsi.rh.entities.Discipline;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IDiscipline extends JpaRepository<Discipline, Integer>{
  
	public List<Discipline> findByCollaborateur(Collaborator collaborateur);
	
	
}
