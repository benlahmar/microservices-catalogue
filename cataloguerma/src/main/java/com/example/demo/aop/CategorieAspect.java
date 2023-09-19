package com.example.demo.aop;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Aspect
@Service

public class CategorieAspect {

	Logger log=Logger.getLogger(getClass().getName());
	@Before("execution (* *.save(..))")
	public void jouralisation()
	{
		
		log.info("debut d'ajout d'insertion a la db ");
	}
	@After("execution (* com.example.demo.repo.ICategorie.save(..))")
	public void jouralisationfin()
	{
		log.info("fin d'ajout d'une categorie");
	}
	
	@After("execution (* com.example.demo.repo.IProduit.delete(..))")
	public void jouralisation2()
	{
		log.info("fin d'ajout d'une categorie");
	}
	
	
	@AfterReturning(
			pointcut = "execution (* com.example.demo.repo.IProduit.save(..))",
			returning = "res")
	public void verifier(JoinPoint jp,Object res)
	{
		log.info(jp.getSignature().getName()+"----"+jp.getSignature().getDeclaringTypeName());
		log.info(res.toString());
	}
	@AfterThrowing(pointcut = "execution (* com.example.demo.repo.IProduit.*(..))",
			throwing = "e")
	public void exept(Object e)
	{
		log.info(e.toString());
	}
	
//	@Around("execution (* com.example.demo.repo.IProduit.*(..))")
//	public void desinfo()
//	{
//		log.info("arround ");
//	}
}
