package com.example.demo.services;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.ProduitDto;
import com.example.demo.entities.Categorie;
import com.example.demo.entities.Produit;

public interface Iservice {

	public Categorie addcat(Categorie c);
	public Categorie findById(long id) throws Exception;
	public List<Categorie> allCategories();
	public Page<Categorie> allCategoriesbypage(Pageable p);
	
	public Produit addprd(Produit p, long idcat);
	public List<Produit> allprd(long idcat);
	public List<Produit> findByX(Predicate<Produit> predicat);
	public Produit findProduitById(long id);
	
	public ProduitDto findProduitById2(long id);
	public void deleteprd(long id);
	
	
}
