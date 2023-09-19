package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Produit.searchByKw",query = "select p from Produit p "
		+ "where p.desg like ?1 Or p.description like ?1")
public class Produit {

	@Id
	@GeneratedValue
	long id;
	String desg,description;
	double pu;
	int qte;
	
	@ManyToOne()
	Categorie categorie;


	public Produit(String desg, String description, double pu, int qte) {
		super();
		this.desg = desg;
		this.description = description;
		this.pu = pu;
		this.qte = qte;
	}


	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getDesg() {
		return desg;
	}


	public void setDesg(String desg) {
		this.desg = desg;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getPu() {
		return pu;
	}


	public void setPu(double pu) {
		this.pu = pu;
	}


	public int getQte() {
		return qte;
	}


	public void setQte(int qte) {
		this.qte = qte;
	}


	public Categorie getCategorie() {
		return categorie;
	}


	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	@Override
	public String toString() {
		return "Produit [id=" + id + ", desg=" + desg + ", description=" + description + ", pu=" + pu + ", qte=" + qte
				+ "]";
	}
	
	
	
}
