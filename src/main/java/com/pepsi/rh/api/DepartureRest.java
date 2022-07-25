package com.pepsi.rh.api;





import java.util.List;

import com.pepsi.rh.entities.Departs;
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
@RequestMapping("Depart")
public class DepartureRest {

	@Autowired
	IService service;
	
	@PostMapping("/{uid}")
	public ResponseEntity<Departs> save(@RequestBody Departs c, @PathVariable long uid)
	{
		c=service.addDeparts(c, uid);
		if(c!=null)
		return new ResponseEntity<>(c, HttpStatus.OK);
		else
			return new ResponseEntity<Departs>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@GetMapping("/page")
	public Page<Departs> allDepartssByPage(@RequestParam int page,@RequestParam int size)
	{
		return service.allDeparts(page, size);
	}
	@GetMapping("/")
	public List<Departs> allDepartss() {
		return service.getAllDeparts();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Departs> oneDeparts(@PathVariable long id)
	{
		Departs c = service.findDeparts(id);
		if(c!=null)
		return new ResponseEntity<Departs>(c,HttpStatus.FOUND);
		else
		return new ResponseEntity<Departs>(HttpStatus.NO_CONTENT);
		
	}

	@GetMapping("/user/{uid}")
	public List<Departs> findByUser(@PathVariable long uid){
		return service.findDepartCollaborateur(uid);
	}
	

}
