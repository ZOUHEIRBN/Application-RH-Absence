package com.pepsi.rh.entities;



import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "absences")
public class Absence {

	@Id
	@GeneratedValue
	long id;
	LocalDateTime datePremierJ,dateDernierJ,dateRetour,createdDate;
	@Enumerated(EnumType.STRING)
	Raison typeAbs;
	String responsable;
	float nombreJ;
	String commentaire;
	jour MatinorApresMidiPJ;
	jour MatinorApresMidiDJ;
	String file;
	
	@ManyToOne
	@JsonIgnore
	Collaborator collaborateur;

    public LocalDateTime getDatePremierJ() {
        return datePremierJ;
    }

    public void setDatePremierJ(LocalDateTime datePremierJ) {
        this.datePremierJ = datePremierJ;
    }

    public LocalDateTime getDateDernierJ() {
        return dateDernierJ;
    }

    public void setDateDernierJ(LocalDateTime dateDernierJ) {
        this.dateDernierJ = dateDernierJ;
    }

    public LocalDateTime getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(LocalDateTime dateRetour) {
        this.dateRetour = dateRetour;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Raison getTypeAbs() {
        return typeAbs;
    }

    public void setTypeAbs(Raison typeAbs) {
        this.typeAbs = typeAbs;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public float getNombreJ() {
        return nombreJ;
    }

    public void setNombreJ(float nombreJ) {
        this.nombreJ = nombreJ;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public jour getMatinorApresMidiPJ() {
        return MatinorApresMidiPJ;
    }

    public void setMatinorApresMidiPJ(jour matinorApresMidiPJ) {
        MatinorApresMidiPJ = matinorApresMidiPJ;
    }

    public jour getMatinorApresMidiDJ() {
        return MatinorApresMidiDJ;
    }

    public void setMatinorApresMidiDJ(jour matinorApresMidiDJ) {
        MatinorApresMidiDJ = matinorApresMidiDJ;
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
