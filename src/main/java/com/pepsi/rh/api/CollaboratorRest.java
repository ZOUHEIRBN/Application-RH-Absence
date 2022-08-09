package com.pepsi.rh.api;





import java.util.List;

import com.pepsi.rh.entities.Collaborator;
import com.pepsi.rh.services.IService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
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
@RequestMapping("Collaborator")
public class CollaboratorRest {

	@Autowired
	IService service;
	@Autowired
    private SimpMessagingTemplate template;
	@PostMapping("/")
	public ResponseEntity<Collaborator> save(@RequestBody Collaborator c)
	{
		c=service.addCollaborator(c);
		if(c!=null){
			return new ResponseEntity<>(c, HttpStatus.OK);
		}
		
		else{
			return new ResponseEntity<Collaborator>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@GetMapping("/page")
	public Page<Collaborator> allCollaboratorsByPage(@RequestParam int page,@RequestParam int size)
	{
		return service.findAllCollaboratorsByPage(page, size);
	}
	@GetMapping("/")
	public List<Collaborator> allCollaborators() {
		Notification notification = new Notification("Test notification", 
		"Lorem ipsum dolor sit amet");

        // Push notifications to front-end
        template.convertAndSend("/pepsi_rh/notification", notification);
		return service.getAllCollaborator();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Collaborator> oneCollaborator(@PathVariable long id)
	{
		Collaborator c = service.findCollaborator(id);
		if(c!=null)
		return new ResponseEntity<Collaborator>(c,HttpStatus.FOUND);
		else
		return new ResponseEntity<Collaborator>(HttpStatus.NO_CONTENT);
		
	}
	

}
