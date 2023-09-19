package com.example.demo.services;

import java.util.List;
import java.util.function.Predicate;

import com.example.demo.entities.Categorie;
import com.example.demo.entities.Produit;

public interface Iservice {

	public Categorie addcat(Categorie c);
	public Categorie findById(long id) throws Exception;
	public List<Categorie> allCategories();
	
	
	public Produit addprd(Produit p, long idcat);
	public List<Produit> allprd(long idcat);
	public List<Produit> findByX(Predicate<Produit> predicat);
}
