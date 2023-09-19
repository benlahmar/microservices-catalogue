package com.example.demo;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entities.Categorie;
import com.example.demo.entities.Produit;
import com.example.demo.repo.ICategorie;
import com.example.demo.repo.IProduit;
import com.example.demo.services.Iservice;

@SpringBootApplication
public class CataloguermaApplication implements CommandLineRunner{

	@Autowired
	Iservice service;
	
	public static void main(String[] args) {
		SpringApplication.run(CataloguermaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		service.findByX(p->p.getQte()>12);
		service.findByX(p-> p.getDesg().contains("abc"));
		
		
	}

}
