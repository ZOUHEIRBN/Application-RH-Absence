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

import com.pepsi.rh.entities.Absence;
import com.pepsi.rh.services.IService;
@CrossOrigin(origins = "*", allowedHeaders = "*") //DESKTOP-8CM1NR0:4200
@RestController
@RequestMapping("Absence")
public class AbsenceRest {

	@Autowired
	IService service;
	

	// @GetMapping("/allCollaborateurs")
	// public Page<Collaborateur> all(@RequestParam int page,@RequestParam int size)
	// {
	// 	return service.allcollaboraters(page, size);
	// }
	@GetMapping("/page")
	public Page<Absence> allAbsences(@PathVariable @RequestParam  int page,@PathVariable @RequestParam int size){
		return service.allAbsence(page, size);
	}

	@GetMapping("/")
	public List<Absence> allAbsence() {
		return service.getAllAbsence();
	}
	// @GetMapping("/oneCollaborateurs/{id}")
	// public ResponseEntity<Collaborateur> oneCollaborateurs(@PathVariable long id)
	// {
	// 	Collaborateur c = service.findCollaborateur(id);
	// 	if(c!=null)
	// 	return new ResponseEntity<Collaborateur>(c,HttpStatus.FOUND);
	// 	else
	// 	return new ResponseEntity<Collaborateur>(HttpStatus.NO_CONTENT);
		
	// }
	
	
	@PostMapping("/{id}")
	public Absence addabss(@RequestBody Absence ab,@PathVariable long id)
	{
		
		return service.addAbsence(ab, id);
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteAbsence(@PathVariable("id") long id)
	{
		if(service.findAbsence(id)!=null)
		{
			service.deleteAbsence(id);
			return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Absence> updateAbsences(@RequestBody Absence abs,@PathVariable long id) {
		if(service.findAbsence(id)!=null)
		{
			abs=service.updateAbsences(abs, id);
			return new ResponseEntity<Absence>(abs,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

                
	
	
	
	
	
}
