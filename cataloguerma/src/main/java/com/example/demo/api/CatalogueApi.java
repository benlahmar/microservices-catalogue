package com.example.demo.api;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Categorie;
import com.example.demo.entities.Produit;
import com.example.demo.services.Iservice;

@RestController()
public class CatalogueApi {

	@Autowired
	Iservice service;
	
	@GetMapping(path = "/categories")
	public List<Categorie> categories()
	{
		return service.allCategories();
	}
	
	@GetMapping(path = "/categories/page")
	public Page<Categorie> categoriespage(@RequestParam int page,@RequestParam int size)
	{
		
		Pageable p=PageRequest.of(page, size);
		return service.allCategoriesbypage(p);
	}
	
	
	
	@GetMapping(path = "/categories/{id}")
	public ResponseEntity<Categorie> categorie(@PathVariable long id)
	{
		ResponseEntity<Categorie> rep;
		try {
			Categorie c = service.findById(id);
			rep=new ResponseEntity<Categorie>(c,HttpStatus.FOUND);	
		} catch (Exception e) {
			rep=new ResponseEntity<Categorie>(HttpStatus.NO_CONTENT);
			e.printStackTrace();
		}
		return rep;
	}
	
	@GetMapping(path = "/categories/{idcat}/produits")
	public List<Produit> produits(@PathVariable(name = "idcat") long idcat)
	{
		return service.allprd(idcat);
	}
	@GetMapping(path = "/produits/{id}")
	public Produit produitbyid(@PathVariable(name = "id") long id)
	{
		return service.findProduitById(id);
	}
	
	@GetMapping(path = "/produits/searchmc")
	public List<Produit> searchbymc(@RequestParam(name = "q") String mc)
	{
		Predicate<Produit> predicat1=p->p.getDesg().contains(mc);
		Predicate<Produit> predicat2=p->p.getDescription().contains(mc);
		return service.findByX(predicat1.or(predicat2));
	}
	@GetMapping(path = "/produits/searchpu")
	public List<Produit> searchbyLesspu(@RequestParam(name = "q") double pu)
	{
		return service.findByX(p->p.getPu()<pu);
	}
	
	@GetMapping(path = "/produits/searchqte")
	public List<Produit> searchLessqte(@RequestParam(name = "q") int qte)
	{
		return service.findByX(p->p.getQte()<qte);
	}
	
	@PostMapping("/categories")
	public Categorie addcat( @RequestBody Categorie c)
	{
		return service.addcat(c);
	}
	
	@PostMapping("/produits/{idcat}")
	public Produit addprd( @RequestBody Produit p,@PathVariable long idcat)
	{
		return service.addprd(p, idcat);
	}

	@DeleteMapping("/produits/{id}")
	public ResponseEntity<Void> deleteprd(@PathVariable long id)throws Exception
	{
		try {
		service.deleteprd(id);
		return new ResponseEntity(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
	}
}
