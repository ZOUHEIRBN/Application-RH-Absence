package com.pepsi.rh.api;





import java.util.List;

import com.pepsi.rh.entities.Discipline;
import com.pepsi.rh.services.IService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*", allowedHeaders = "*") //DESKTOP-8CM1NR0:4200
@RestController
@RequestMapping("Discipline")
public class DisciplineRest {

	@Autowired
	IService service;
	
	@PostMapping("/{uid}")
	public ResponseEntity<Discipline> save(@RequestBody Discipline c, @PathVariable long uid)
	{
		c=service.addDiscipline(c, uid);
		if(c!=null)
		return new ResponseEntity<>(c, HttpStatus.OK);
		else
			return new ResponseEntity<Discipline>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@GetMapping("/page")
	public Page<Discipline> allDisciplinesByPage(@RequestParam int page,@RequestParam int size)
	{
		return service.allDiscipline(page, size);
	}
	@GetMapping("/")
	public List<Discipline> allDisciplines() {
		return service.getAllDiscipline();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Discipline> oneDiscipline(@PathVariable long id)
	{
		Discipline c = service.findDiscipline(id);
		if(c!=null)
		return new ResponseEntity<Discipline>(c,HttpStatus.FOUND);
		else
		return new ResponseEntity<Discipline>(HttpStatus.NO_CONTENT);
		
	}

	@GetMapping("/user/{uid}")
	public List<Discipline> findByUser(@PathVariable long uid){
		return service.findDisciplineCollaborateur(uid);
	}
	

}
