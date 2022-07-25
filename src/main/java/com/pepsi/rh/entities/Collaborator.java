/**
 * 
 */
package com.pepsi.rh.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;


import lombok.Data;


@Component
@Data
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="collaborateur_type")

public class Collaborator {

	@Id
	@GeneratedValue
	long id;
	@Column(unique = true,length=10)
	String cin;
	@Column(length=20)
	String nom, prenom, tel, prenom2;
	@Column(length=60)
	String adresse,email, lieu_naiss;
	@Column(length=11)@Enumerated(EnumType.STRING)
	Situation situation;
	@Column(length=6)@Enumerated(EnumType.STRING)
	Gender sexe;
	LocalDate date_borth, date_recrut;
	@Column(length=10)
	String ncnss;

	@Column(length=30)
	String pays, ville, nationalite, langue, poste, motif;
	
     @Column
     boolean actived ;

	@OneToMany(mappedBy = "collaborateur")
	List<Absence> absences=new ArrayList<>();

	@OneToMany(mappedBy = "collaborateur")
 	List<Discipline> disciplines=new ArrayList<>();
 	 	
 	
 	@OneToMany(mappedBy = "collaborateur")
 	List<Departs> depart=new ArrayList<Departs>();
 	
 	@OneToMany(mappedBy = "collaborateur")
 	List<Blacklist> blacklists=new ArrayList<Blacklist>();

	

	public String getCin() {
		return cin;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Situation getSituation() {
		return situation;
	}

	public void setSituation(Situation situation) {
		this.situation = situation;
	}

	public Gender getSexe() {
		return sexe;
	}

	public void setSexe(Gender sexe) {
		this.sexe = sexe;
	}

	public LocalDate getDate_borth() {
		return date_borth;
	}

	public void setDate_borth(LocalDate date_borth) {
		this.date_borth = date_borth;
	}

	public LocalDate getDate_recrut() {
		return date_recrut;
	}

	public void setDate_recrut(LocalDate date_recrut) {
		this.date_recrut = date_recrut;
	}

	public String getNcnss() {
		return ncnss;
	}

	public void setNcnss(String ncnss) {
		this.ncnss = ncnss;
	}

	public List<Absence> getAbsences() {
		return absences;
	}

	public void setAbsences(List<Absence> absences) {
		this.absences = absences;
	}
	
	
	
	
	

}
