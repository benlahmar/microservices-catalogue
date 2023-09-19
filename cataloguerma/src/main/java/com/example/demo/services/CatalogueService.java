package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Categorie;
import com.example.demo.entities.Produit;
import com.example.demo.repo.ICategorie;
import com.example.demo.repo.IProduit;

@Service
public class CatalogueService implements Iservice {

	@Autowired
	ICategorie crepo;
	@Autowired
	IProduit prepo;
	
	@Override
	public Categorie addcat(Categorie c) {
		
		return crepo.save(c);
	}

	@Override
	public Categorie findById(long id) throws Exception {
		Optional<Categorie> o = crepo.findById(id);
		if(o.isPresent())
			return o.get();
		else  throw  new Exception();
	}

	@Override
	public List<Categorie> allCategories() {
		// TODO Auto-generated method stub
		return crepo.findAll();
	}

	@Override
	public Produit addprd(Produit p, long idcat) {
		Optional<Categorie> o = crepo.findById(idcat);
		p.setCategorie(o.get());
		return prepo.save(p);
	}

	@Override
	public List<Produit> allprd(long idcat) {
		
		return prepo.findByCategorieId(idcat);
	}

	@Override
	public List<Produit> findByX(Predicate<Produit> predicat) {
		List<Produit> res = prepo.findAll()
							.stream()
							.filter(predicat)
							.collect(Collectors.toList());
		
		
		
		return res;
	}

	@Override
	public Produit findProduitById(long id) {
		
		return prepo.findById(id).orElse(new Produit());
	}

	@Override
	public void deleteprd(long id) {
		Optional<Produit> pp = prepo.findById(id);
		Produit pt = pp.orElseThrow();
		prepo.delete(pt);
		
	}

	@Override
	public Page<Categorie> allCategoriesbypage(Pageable p) {
		
		return crepo.findAll(p);
	}

}
