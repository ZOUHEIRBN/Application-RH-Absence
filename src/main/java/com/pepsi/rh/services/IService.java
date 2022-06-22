package com.pepsi.rh.services;



import java.util.List;

import org.springframework.data.domain.Page;
import com.pepsi.rh.entities.Absences;
import com.pepsi.rh.entities.Collaborateur;

public interface IService {

	public Collaborateur addcollaborateur(Collaborateur c);
	public Collaborateur findCollaborateur(long id);
	public Page<Collaborateur> allcollaboraters(int page, int size);
	public Absences addAbsence(Absences a, long idc);
	public Absences findAbsence(long id);
	public Page<Absences> allAbsence(int page, int size);
	public Absences updateAbsences(Absences abs,Long id );
	public List<Absences> getAll();
	public void deleteAbsence(long id);
}
