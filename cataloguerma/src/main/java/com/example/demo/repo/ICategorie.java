package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Categorie;

public interface ICategorie extends JpaRepository<Categorie, Long>{

	@Query(value = "from Categorie c where c.tailleproduit()>?1")
	public List<Categorie> abc(int nb);
	
	
	
	
}
