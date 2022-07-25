
package com.pepsi.rh.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data 
public class Departs {

	@Id
	@GeneratedValue
	Long id;
	String motif;
	LocalDate datededepart;
	LocalDate dernierjourtravaille;
	LocalDate datefindepaie;
	@JsonIgnore
	@ManyToOne
	Collaborator collaborateur;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public LocalDate getDatededepart() {
		return datededepart;
	}
	public void setDatededepart(LocalDate datededepart) {
		this.datededepart = datededepart;
	}
	public LocalDate getDernierjourtravaille() {
		return dernierjourtravaille;
	}
	public void setDernierjourtravaille(LocalDate dernierjourtravaille) {
		this.dernierjourtravaille = dernierjourtravaille;
	}
	public LocalDate getDatefindepaie() {
		return datefindepaie;
	}
	public void setDatefindepaie(LocalDate datefindepaie) {
		this.datefindepaie = datefindepaie;
	}
	public Collaborator getCollaborateur() {
		return collaborateur;
	}
	public void setCollaborateur(Collaborator collaborateur) {
		this.collaborateur = collaborateur;
	}
    
}
