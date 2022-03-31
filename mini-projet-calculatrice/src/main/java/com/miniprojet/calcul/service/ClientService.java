package com.miniprojet.calcul.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniprojet.calcul.model.Client;
import com.miniprojet.calcul.model.Operation;
import com.miniprojet.calcul.model.Session;
import com.miniprojet.calcul.repository.ClientRepository;
import com.miniprojet.calcul.repository.OperationRepository;
import com.miniprojet.calcul.repository.SessionRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	@Autowired 
	public SessionRepository sessionRepository;
	@Autowired
	private OperationRepository operationRepository;
	
	public Client addClient(Client client) {
		return repository.save(client);
	}
	
	public List<Client> getClients(){
		
		return repository.findAll();
	}
	
	public Client findByLoginAndMotPasse(String login,String motPasse) {
		Optional<Client> clOptional = Optional.ofNullable(repository.findByLoginAndMotPasse(login, motPasse));
		if(clOptional.isEmpty()) {
			return null;
		}else {
			
			return clOptional.get();
		}
	}
	
	public Session affecterDateOpen(int id) {
		Client c = repository.findById(id).orElse(null);
		if (c!=null) {
		 
			Session session = new Session();
			session.setOpenSession(new Date());
			session.setClient(c);
			return sessionRepository.save(session);
		}
		return null;
	}
	
	public void affecterDateClose(int id) {
		Session s = sessionRepository.findById(id).orElse(null);
		if(s!=null) {
			
			s.setCloseSession(new Date());
			 sessionRepository.save(s);
		}
	}
	
	public Operation addOperation(int id, Operation operation) {
		Session session = sessionRepository.findById(id).orElse(null);
		if(session!=null) {
			
			switch (operation.getType()) {
			case "+":
				operation.setResultat(operation.getValue1()+operation.getValue2());
				break;
			case "*":
				operation.setResultat(operation.getValue1()*operation.getValue2());
				break;
			case "-":
				operation.setResultat(operation.getValue1()-operation.getValue2());
				break;
			case "/":
				operation.setResultat(operation.getValue1()/operation.getValue2());
				break;
			}
			operation.setSession(session);
			return operationRepository.save(operation);
			
		}
		return null;
	}

}
