package com.miniprojet.calcul.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.miniprojet.calcul.model.Client;
import com.miniprojet.calcul.model.Operation;
import com.miniprojet.calcul.model.Session;
import com.miniprojet.calcul.service.ClientService;



@RestController
public class ClientController {
	@Autowired
	private ClientService clientService;
	
	
	@PostMapping("/addClient")
	public Client addClient(@RequestBody Client client) {
		
		return clientService.addClient(client);
	}

	@GetMapping("/getAll")
	public List<Client> getClients(){
		return clientService.getClients();
	}
	
	@GetMapping("/login/{login}/{motPasse}")
	public ResponseEntity<Client> findByLoginAndMotPasse(@PathVariable String login ,@PathVariable String motPasse){
		Client c = clientService.findByLoginAndMotPasse(login, motPasse);
		if(c == null) {
			return new ResponseEntity<Client>(HttpStatus.NO_CONTENT);
		}else {
			System.err.println(c);
			return new ResponseEntity<Client>(c,HttpStatus.OK);
		}
	}
	 
	
	@GetMapping("/addSession/{id}")
	public Session affecterDateOpen(@PathVariable int id) {
		return clientService.affecterDateOpen(id);
	}
	
	@GetMapping("/closeSeession/{id}")
	public void affecterDateClose(@PathVariable int id) {
		clientService.affecterDateClose(id);
	}
	
	@PostMapping("addOperation/{id}")
	public Operation addOperation(@PathVariable int id , @RequestBody Operation operation) {
		return clientService.addOperation(id, operation);
	}
	

	

}
