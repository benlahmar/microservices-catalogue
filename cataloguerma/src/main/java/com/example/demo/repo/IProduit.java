package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.ProduitDto;
import com.example.demo.entities.Produit;

public interface IProduit extends JpaRepository<Produit, Long>{

	public List<Produit> findByQteLessThan(int q);
	
	public List<Produit> findByQteLessThanAndPuGreaterThan(int q, double p);
	
	@Query("from Produit p where p.qte<?1 and p.pu>?2")
	public List<Produit> findc(int q, double p);
	
	public List<Produit> searchByKw(String k);
	
	public List<Produit> findByCategorieId(long id);
	
	@Query("from Produit p where p.id=?1")
	public ProduitDto findprd(long id);
	
	List<ProduitDto> findByPuLessThanEqual(double pu);
}
