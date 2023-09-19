package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Categorie {

	@Id
	@GeneratedValue
	long id;
	String libelle;
	String description;
	
	@OneToMany(fetch = FetchType.EAGER,
			cascade = CascadeType.ALL,
			mappedBy = "categorie")
	
	List<Produit> produits;


	public Categorie(String libelle, String description) {
		super();
		this.libelle = libelle;
		this.description = description;
	}


	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<Produit> getProduits() {
		return produits;
	}


	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
	public int tailleproduit()
	{
		if(produits!=null)
		return produits.size();
		else
			return 0;
	}
	
}
