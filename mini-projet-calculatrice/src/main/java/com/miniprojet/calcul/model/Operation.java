package com.miniprojet.calcul.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Operation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public double value1;
	public double value2;
	public String type;
	public double resultat;
	@ManyToOne
	public Session session;
	
	
	
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getValue1() {
		return value1;
	}
	public void setValue1(double value1) {
		this.value1 = value1;
	}
	public double getValue2() {
		return value2;
	}
	public void setValue2(double value2) {
		this.value2 = value2;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getResultat() {
		return resultat;
	}
	public void setResultat(double resultat) {
		this.resultat = resultat;
	}
	@Override
	public String toString() {
		return "Operation [id=" + id + ", value1=" + value1 + ", value2=" + value2 + ", type=" + type + ", resultat="
				+ resultat + "]";
	}
	
	
}
