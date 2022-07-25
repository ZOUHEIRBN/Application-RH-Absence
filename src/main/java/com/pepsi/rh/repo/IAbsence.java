package com.pepsi.rh.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.pepsi.rh.entities.Absence;

@CrossOrigin
public interface IAbsence extends JpaRepository<Absence, Long>{
}
