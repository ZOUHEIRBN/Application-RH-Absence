package com.pepsi.rh.services;



import java.util.List;

import org.springframework.data.domain.Page;
import com.pepsi.rh.entities.Departs;
import com.pepsi.rh.entities.Absence;
import com.pepsi.rh.entities.Blacklist;
import com.pepsi.rh.entities.Collaborator;

public interface IService {

	public Collaborator addCollaborator(Collaborator c);
	public Collaborator findCollaborator(long id);
	public Page<Collaborator> findAllCollaboratorsByPage(int page, int size);
	public List<Collaborator> getAllCollaborator();

	public Absence addAbsence(Absence a, long idc);
	public Absence findAbsence(long id);
	public Page<Absence> allAbsence(int page, int size);
	public Absence updateAbsences(Absence abs,Long id );
	public List<Absence> getAllAbsence();
	public void deleteAbsence(long id);

	public Departs addDeparts(Departs d, long idc);
	public Departs findDeparts(Long id);
	public Page<Departs> allDeparts(int page, int size);
	public Departs updateDeparts(Departs dep,Long id );
	public List<Departs> getAllDeparts();
	public void deleteDeparts(long id);
	public List<Departs> findDepartCollaborateur(long uid);

	public Blacklist addBlacklist(Blacklist a, long idc);
	public Blacklist findBlacklist(Long id);
	public Page<Blacklist> allBlacklist(int page, int size);
	public Blacklist updateBlacklist(Blacklist abs,long id );
	public List<Blacklist> getAllBlacklist();
	public void deleteBlacklist(long id);
	public List<Blacklist> findBlacklistCollaborateur(long uid);

}
