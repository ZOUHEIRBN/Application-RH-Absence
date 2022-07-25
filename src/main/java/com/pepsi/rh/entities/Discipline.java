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
public class Discipline {

	@Id
	@GeneratedValue
	Long id;
	String avertissement;
	LocalDate date;
	
	String file;
	@JsonIgnore
	@ManyToOne
	Collaborator collaborateur;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAvertissement() {
		return avertissement;
	}
	public void setAvertissement(String avertissement) {
		this.avertissement = avertissement;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public Collaborator getCollaborateur() {
		return collaborateur;
	}
	public void setCollaborateur(Collaborator collaborateur) {
		this.collaborateur = collaborateur;
	}
}
