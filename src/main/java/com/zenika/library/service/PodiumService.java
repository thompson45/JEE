package com.zenika.library.service;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.hibernate.Session;

import com.zenika.library.process.Podium;

@Path("/Podium")
@Singleton
public class PodiumService {
	
	@PersistenceContext(unitName="apiPU")
	protected EntityManagerFactory emf;
	protected EntityManager em;
	
	@Path("/")
	@POST
	public String podium(){
		emf = Persistence.createEntityManagerFactory("PodiumService");	//bi
		em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try
		{
			Podium p = new Podium();
			p.setId(1);
			em.persist(p);
			t.commit();
		}
		finally
		{
			if(t.isActive())
			{
				t.rollback();
			}
			em.close();
			emf.close();
		}
		return "";
	}
	
	
	@GET
	@Path("/{id}")
	public String get(@PathParam("id") int id){
		emf = Persistence.createEntityManagerFactory("apiPU");
		em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try
		{
			Podium p = new Podium();
			p.setId(id);
			em.persist(p);
			t.commit();
		}
		finally
		{
			if(t.isActive())
			{
				t.rollback();
			}
			em.close();
			emf.close();
		}
		return "";
	}
	
	@DELETE
	@Path("/{id}")
	public String delete(@PathParam("id") int id){
		return "";
	}
	
	@GET
	@Path("/{id}/vote")
	public String vote(@PathParam("id") int id){
		return "";
	}
	
	@GET
	@Path("/trending")
	public String trending(){
		return "";
	}
	
	@POST
	@Path("/search")
	public String search(){
		return "";
	}
}