package com.miniprojet.calcul.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Session implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date openSession;
	private Date closeSession;
	@OneToMany(mappedBy = "session", fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JsonBackReference
	private List<Operation> operations;
	@ManyToOne
	public Client client;
	
	
	
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getOpenSession() {
		return openSession;
	}
	public void setOpenSession(Date openSession) {
		this.openSession = openSession;
	}
	public Date getCloseSession() {
		return closeSession;
	}
	public void setCloseSession(Date closeSession) {
		this.closeSession = closeSession;
	}
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	@Override
	public String toString() {
		return "Session [id=" + id + ", openSession=" + openSession + ", closeSession=" + closeSession + ", operations="
				+ operations + "]";
	}
	
	
}
