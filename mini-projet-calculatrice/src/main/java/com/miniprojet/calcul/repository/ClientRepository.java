package com.miniprojet.calcul.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miniprojet.calcul.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
	
	public Client findByLoginAndMotPasse(String login , String motPasse);

}
