package com.pepsi.rh.repo;

import com.pepsi.rh.entities.Blacklist;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;


@Repository
public interface IBlacklist extends JpaRepository<Blacklist, Long>{

	Blacklist findByCollaborateurCin(String CIN);
	
}
