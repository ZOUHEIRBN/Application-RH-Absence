package com.pepsi.rh.api;





import java.util.List;

import com.pepsi.rh.entities.Blacklist;
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
@RequestMapping("Blacklist")
public class BlacklistRest {

	@Autowired
	IService service;
	
	@PostMapping("/{uid}")
	public ResponseEntity<Blacklist> save(@RequestBody Blacklist c, @PathVariable long uid)
	{
		c=service.addBlacklist(c, uid);
		if(c!=null)
		return new ResponseEntity<>(c, HttpStatus.OK);
		else
			return new ResponseEntity<Blacklist>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@GetMapping("/page")
	public Page<Blacklist> allBlacklistsByPage(@RequestParam int page,@RequestParam int size)
	{
		return service.allBlacklist(page, size);
	}
	@GetMapping("/")
	public List<Blacklist> allBlacklists() {
		return service.getAllBlacklist();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Blacklist> oneBlacklist(@PathVariable long id)
	{
		Blacklist c = service.findBlacklist(id);
		if(c!=null)
		return new ResponseEntity<Blacklist>(c,HttpStatus.FOUND);
		else
		return new ResponseEntity<Blacklist>(HttpStatus.NO_CONTENT);
		
	}

	@GetMapping("/user/{uid}")
	public List<Blacklist> findByUser(@PathVariable long uid){
		return service.findBlacklistCollaborateur(uid);
	}
	

}
