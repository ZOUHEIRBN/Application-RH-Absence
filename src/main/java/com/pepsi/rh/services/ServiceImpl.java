package com.pepsi.rh.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.pepsi.rh.entities.Absences;
import com.pepsi.rh.entities.Collaborateur;
import com.pepsi.rh.repo.IAbsence;
import com.pepsi.rh.repo.ICollaborateur;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class ServiceImpl implements IService{

	@Autowired
	ICollaborateur crepo;
	@Autowired
	IAbsence arepo;
	@Autowired

	
	@Override
	public Collaborateur addcollaborateur(Collaborateur c) {
		Collaborateur C=crepo.save(c);
		return C;
	}

	@Override
	public Collaborateur findCollaborateur(long id) {
		
		Optional<Collaborateur> o = crepo.findById(id);
		if(o.isPresent())
		return o.get();
		else
			return null;
		
	}

	@Override
	public Page<Collaborateur> allcollaboraters(int page, int size) {
		Pageable pageable=PageRequest.of(page, size);
		return crepo.findAll(pageable);
		
	}

	@Override
	public Absences addAbsence(Absences a, long idc) {
		Collaborateur c = crepo.findById(idc).get();
		//c.getAbsences().add(a);
		a.setCollaborateur(c);
		a=arepo.save(a);
		return a;
	}
	public Absences findAbsence(long id) {
		Optional<Absences> o = arepo.findById(id);
		if(o.isPresent())
		return o.get();
		else
			return null;
		
	}
	//Absences updateAbsence(Absences abs, long id) throws NotFoundException{}

	public void deleteAbsence(long id){
			arepo.deleteById(id);
	}

	@Override
	public Page<Absences> allAbsence(int page, int size) {
		Pageable pageable=PageRequest.of(page, size);
		return arepo.findAll(pageable);
	}
	public Absences updateAbsences(Absences abs,Long id ) {
		Absences absenceFromDb = findAbsence(id);
		 
		absenceFromDb.setTypeAbs(abs.getTypeAbs());
		absenceFromDb.setNombreJ(abs.getNombreJ());
		absenceFromDb.setResponsable(abs.getResponsable());
		absenceFromDb.setCollaborateur(abs.getCollaborateur());
		absenceFromDb.setMatinorAprèsMidiDJ(abs.getMatinorAprèsMidiDJ());
		absenceFromDb.setMatinorAprèsMidiPJ(abs.getMatinorAprèsMidiPJ());
		absenceFromDb.setCreatedDate(abs.getCreatedDate());
		absenceFromDb.setDatePremierJ(abs.getDatePremierJ());
		absenceFromDb.setDateDernierJ(abs.getDateDernierJ());
		absenceFromDb.setDateRetour(abs.getDateRetour());
		absenceFromDb.setFile(abs.getFile());
		absenceFromDb.setCommentaire(abs.getCommentaire());
		abs=arepo.save(absenceFromDb);
		return abs;
	}

	@Override
	public List<Absences> getAll() {
		
		return arepo.findAll();
	}
	
}
