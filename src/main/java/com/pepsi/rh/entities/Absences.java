package com.pepsi.rh.entities;



import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Absences {

	@Id
	@GeneratedValue
	long id;
	LocalDateTime datePremierJ,dateDernierJ,dateRetour,createdDate;
	@Enumerated(EnumType.STRING)
	Raison typeAbs;
	String responsable;
	float nombreJ;
	String commentaire;
	jour MatinorAprèsMidiPJ;
	jour MatinorAprèsMidiDJ;
	String file;
	
	@ManyToOne
	@JsonIgnore
	Collaborateur collaborateur;
}
