package com.pepsi.rh.api;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.pepsi.rh.entities.Absences;
import com.pepsi.rh.entities.Collaborateur;
import com.pepsi.rh.services.IService;
@CrossOrigin(origins = "*", allowedHeaders = "*") //DESKTOP-8CM1NR0:4200
@RestController
@RequestMapping("Collaborateur")
public class CollaborateurRest {

	@Autowired
	IService service;
	
	@PostMapping("/add")
	public ResponseEntity<Collaborateur> save(@RequestBody Collaborateur c)
	{
		c=service.addcollaborateur(c);
		if(c!=null)
		return new ResponseEntity<>(c, HttpStatus.OK);
		else
			return new ResponseEntity<Collaborateur>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@GetMapping("/allCollaborateurs")
	public Page<Collaborateur> all(@RequestParam int page,@RequestParam int size)
	{
		return service.allcollaboraters(page, size);
	}
	@GetMapping("/Absences")
	public Page<Absences> allAbsences(@PathVariable @RequestParam  int page,@PathVariable @RequestParam int size){
		return service.allAbsence(page, size);
	}

	@GetMapping("/Absence")
	public List allAbsence() {
		return service.getAll();
	}
	@GetMapping("/oneCollaborateurs/{idc}")
	public ResponseEntity<Collaborateur> oneCollaborateurs(@PathVariable long idc)
	{
		Collaborateur c = service.findCollaborateur(idc);
		if(c!=null)
		return new ResponseEntity<Collaborateur>(c,HttpStatus.FOUND);
		else
		return new ResponseEntity<Collaborateur>(HttpStatus.NO_CONTENT);
		
	}
	
	
	@PostMapping("/Absence/{idc}")
	public Absences addabss(@RequestBody Absences ab,@PathVariable long idc)
	{
		
		return service.addAbsence(ab, idc);
	}

	
	@DeleteMapping("/Absence/{id}")
	public ResponseEntity<Object> deleteAbsence(@PathVariable("id") long id)
	{
		if(service.findAbsence(id)!=null)
		{
			service.deleteAbsence(id);
			return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/Absence/{id}")
	public ResponseEntity<Absences> updateAbsences(@RequestBody Absences abs,@PathVariable long id) {
		if(service.findAbsence(id)!=null)
		{
			abs=service.updateAbsences(abs, id);
			return new ResponseEntity<Absences>(abs,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

                
	
	
	
	
	
}
