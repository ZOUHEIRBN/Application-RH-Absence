package com.pepsi.rh.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.pepsi.rh.entities.Absence;
import com.pepsi.rh.entities.Blacklist;
import com.pepsi.rh.entities.Collaborator;
import com.pepsi.rh.entities.Departs;
import com.pepsi.rh.repo.IAbsence;
import com.pepsi.rh.repo.IBlacklist;
import com.pepsi.rh.repo.ICollaborateur;
import com.pepsi.rh.repo.IDepart;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class ServiceImpl implements IService{

	@Autowired
	ICollaborateur crepo;
	@Autowired
	IAbsence arepo;
	@Autowired
	IDepart deprepo;
	@Autowired
	IBlacklist blackrepo;

	public Absence addAbsence(Absence a, long idc) {
		Collaborator c = crepo.findById(idc).get();
		//c.getAbsences().add(a);
		a.setCollaborateur(c);
		a=arepo.save(a);
		return a;
	}
	public Absence findAbsence(long id) {
		Optional<Absence> o = arepo.findById(id);
		if(o.isPresent())
		return o.get();
		else
			return null;
		
	}

	@Override
	public Page<Absence> allAbsence(int page, int size) {
		Pageable pageable=PageRequest.of(page, size);
		return arepo.findAll(pageable);
	}
	public Absence updateAbsences(Absence abs,Long id ) {
		Absence absenceFromDb = findAbsence(id);
		 
		absenceFromDb.setTypeAbs(abs.getTypeAbs());
		absenceFromDb.setNombreJ(abs.getNombreJ());
		absenceFromDb.setResponsable(abs.getResponsable());
		absenceFromDb.setCollaborateur(abs.getCollaborateur());
		absenceFromDb.setMatinorApresMidiDJ(abs.getMatinorApresMidiDJ());
		absenceFromDb.setMatinorApresMidiPJ(abs.getMatinorApresMidiPJ());
		absenceFromDb.setCreatedDate(abs.getCreatedDate());
		absenceFromDb.setDatePremierJ(abs.getDatePremierJ());
		absenceFromDb.setDateDernierJ(abs.getDateDernierJ());
		absenceFromDb.setDateRetour(abs.getDateRetour());
		absenceFromDb.setFile(abs.getFile());
		absenceFromDb.setCommentaire(abs.getCommentaire());
		abs=arepo.save(absenceFromDb);
		return abs;
	}
	public void deleteAbsence(long id){
			arepo.deleteById(id);
	}

	@Override
	public List<Absence> getAllAbsence() {
		
		return arepo.findAll();
	}


	
	@Override
	public Collaborator addCollaborator(Collaborator c) {
		Collaborator C=crepo.save(c);
		return C;
	}

	@Override
	public Collaborator findCollaborator(long id) {
		
		Optional<Collaborator> o = crepo.findById(id);
		if(o.isPresent())
		return o.get();
		else
			return null;
		
	}

	@Override
	public Page<Collaborator> findAllCollaboratorsByPage(int page, int size) {
		Pageable pageable=PageRequest.of(page, size);
		return crepo.findAll(pageable);
		
	}

	@Override
	public List<Collaborator> getAllCollaborator() {
		return crepo.findAll();
	}
	public Collaborator updateCollaborator(Collaborator col,Long id ) {
		Collaborator collaboratorFromDb = findCollaborator(id);
		col=crepo.save(collaboratorFromDb);
		return col;
	}
	

	public void deleteCollaborator(long id){
		crepo.deleteById(id);
}



//Départs
@Override
public Departs addDeparts(Departs D, long idc) {
 		
	Collaborator c = crepo.findById(idc).get();
	D.setCollaborateur(c);
	D=deprepo.save(D);
	return D;
}

public List<Departs> findDepartCollaborateur(long id){
	Collaborator e = crepo.findById(id).get();
	return deprepo.findByCollaborateur(e);
}

@Override
public Departs updateDeparts(Departs d, Long id) {
	
	Departs e =deprepo.findById(id).get();
	   e.setId(id);
	   e.setDatededepart(d.getDatededepart());
	   e.setDatefindepaie(d.getDatefindepaie());	
	  e.setDernierjourtravaille(d.getDernierjourtravaille());
	  e.setMotif(d.getMotif());
	 return deprepo.save(e);
}

@Override
public void deleteDeparts(long id) {
	
	deprepo.deleteById(id);
	
}


@Override
public Departs findDeparts(Long id) {
	Optional<Departs> o = deprepo.findById(id);
	if(o.isPresent())
	return o.get();
	else
		return null;
}
@Override
public Page<Departs> allDeparts(int page, int size) {
	Pageable pageable=PageRequest.of(page, size);
	return deprepo.findAll(pageable);
}
@Override
public List<Departs> getAllDeparts() {
	return deprepo.findAll();
}

//Blacklist
@Override
public Blacklist addBlacklist(Blacklist D, long idc) {
 		
	Collaborator c = crepo.findById(idc).get();
	D.setCollaborateur(c);
	D=blackrepo.save(D);
	return D;
}
@Override
public List<Blacklist> findBlacklistCollaborateur(long id){
	String cin = crepo.findById(id).get().getCin();
	return blackrepo.findByCollaborateurCin(cin);
}

@Override
public Blacklist updateBlacklist(Blacklist d, long id) {
	
	Blacklist e =blackrepo.findById(id).get();
	//    e.setId(id);
	//    e.setDatededepart(d.getDatededepart());
	//    e.setDatefindepaie(d.getDatefindepaie());	
	//   e.setDernierjourtravaille(d.getDernierjourtravaille());
	//   e.setMotif(d.getMotif());
	 return blackrepo.save(e);
}

@Override
public void deleteBlacklist(long id) {
	
	blackrepo.deleteById(id);
	
}


@Override
public Blacklist findBlacklist(Long id) {
	Optional<Blacklist> o = blackrepo.findById(id);
	if(o.isPresent())
	return o.get();
	else
		return null;
}
@Override
public Page<Blacklist> allBlacklist(int page, int size) {
	Pageable pageable=PageRequest.of(page, size);
	return blackrepo.findAll(pageable);
}
@Override
public List<Blacklist> getAllBlacklist() {
	return blackrepo.findAll();
}

}
