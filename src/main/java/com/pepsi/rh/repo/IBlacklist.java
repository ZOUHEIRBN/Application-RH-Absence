package com.pepsi.rh.repo;

import java.util.List;

import com.pepsi.rh.entities.Blacklist;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;


@Repository
public interface IBlacklist extends JpaRepository<Blacklist, Long>{

	List<Blacklist> findByCollaborateurCin(String CIN);
	
}
