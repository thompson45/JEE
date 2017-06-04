package com.zenika.library.service;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.zenika.library.data.PodiumDAO;
import com.zenika.library.process.Podium;
import com.zenika.library.process.PodiumList;
import com.zenika.library.process.Search;
import com.zenika.library.process.Vote;

@Path("/Podium")
@Singleton
public class PodiumService {
	
	@PersistenceContext(unitName="apiPU")
	protected EntityManagerFactory 	emf;
	protected EntityManager 		em;
	
	@Consumes({"application/json"})
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	@POST
	public Response podium(Podium podium){
		emf = Persistence.createEntityManagerFactory("apiPU");
		em = emf.createEntityManager();
		EntityManager emSelect = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		int maxPodium = 0;
		int maxPodiumId = 0;
		try
		{
			try
			{
				Query q = emSelect.createNativeQuery("SELECT MAX(id) FROM Podium;");
				maxPodium = Integer.parseInt(q.getSingleResult().toString()) + 1;
				q = emSelect.createNativeQuery("SELECT MAX(idPodium) FROM Podium;");
				maxPodiumId = Integer.parseInt(q.getSingleResult().toString()) + 1;
			}
			catch(Exception E)
			{
				if(E.getMessage() == null)
				{
					System.out.println("Erreur : Aucun enregistrement dans la liste de Podium");
				}
				else
				{
					System.out.println(E.getMessage());
				}
			}
			
			podium.setId(maxPodiumId);
			PodiumDAO p1 = new PodiumDAO(podium,maxPodium,0);
			PodiumDAO p2 = new PodiumDAO(podium,maxPodium+1,1);
			PodiumDAO p3 = new PodiumDAO(podium,maxPodium+2,2);
			em.persist(p1);
			em.persist(p2);
			em.persist(p3);
			t.commit();
			return Response.ok().entity(podium).build();
		}
		catch(Exception E)
		{
			System.out.println(E.getMessage());
			t.rollback();
			return Response.status(404).entity("Erreur à la création du Podium").build();
		}
		finally
		{
			if(t.isActive())
			{
				t.rollback();
				return Response.status(404).entity("Erreur à la création du Podium").build();
			}
			em.close();
			emSelect.close();
			emf.close();
		}
	}
	
	
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("/{id}")
	public Response get(@PathParam("id") int id){
		emf = Persistence.createEntityManagerFactory("apiPU");
		em = emf.createEntityManager();
		EntityManager emSelect = emf.createEntityManager();
		try
		{
			@SuppressWarnings("unchecked")
			List<Integer> list = emSelect.createNativeQuery("SELECT id FROM Podium WHERE idPodium = :v_idPodium ORDER BY id;")
						.setParameter("v_idPodium", id).getResultList();
			if(list.size() != 3){throw new Exception("Aucun résultat !");}
			PodiumDAO p1 = em.find(PodiumDAO.class,list.get(0));
			PodiumDAO p2 = em.find(PodiumDAO.class,list.get(1));
			PodiumDAO p3 = em.find(PodiumDAO.class,list.get(2));
			Podium podium = new Podium(p1,p2,p3);
			return Response.ok().entity(podium).build();
		}
		catch(Exception E)
		{
			System.out.println(E.getMessage());
			return Response.status(404).entity("Erreur à la sélection du Podium").build();
		}
		finally
		{
			em.close();
			emSelect.close();
			emf.close();
		}
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id){
		emf = Persistence.createEntityManagerFactory("apiPU");
		em = emf.createEntityManager();
		EntityManager emSelect = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		try
		{
			@SuppressWarnings("unchecked")
			List<Integer> list = emSelect.createNativeQuery("SELECT id FROM Podium WHERE idPodium = :v_idPodium ORDER BY id;")
						.setParameter("v_idPodium", id).getResultList();
			if(list.size() != 3){throw new Exception("Aucun résultat !");}
			em.remove(em.find(PodiumDAO.class,list.get(0)));
			em.remove(em.find(PodiumDAO.class,list.get(1)));
			em.remove(em.find(PodiumDAO.class,list.get(2)));
			t.commit();
			return Response.ok().entity("Le podium " + id + " à été supprimée").build();
		}
		catch(Exception E)
		{
			System.out.println(E.getMessage());
			t.rollback();
			return Response.status(404).entity("Erreur à la suppression du Podium").build();
		}
		finally
		{
			if(t.isActive())
			{
				t.rollback();
				return Response.status(404).entity("Erreur à la suppression du Podium").build();
			}
			em.close();
			emSelect.close();
			emf.close();
		}
	}
	
	@Consumes({"application/json"})
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	@Path("/{id}/vote")
	public Response vote(@PathParam("id") int id, Vote vote) {
		emf = Persistence.createEntityManagerFactory("apiPU");
		em = emf.createEntityManager();
		EntityManager emSelect = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		try
		{
			@SuppressWarnings("unchecked")
			List<Integer> list = emSelect.createNativeQuery("SELECT id FROM Podium WHERE idPodium = :v_idPodium ORDER BY id;")
						.setParameter("v_idPodium", id).getResultList();
			if(list.size() != 3){throw new Exception("Aucun résultat !");}
					
			PodiumDAO p1 = em.find(PodiumDAO.class,list.get(0));
			PodiumDAO p2 = em.find(PodiumDAO.class,list.get(1));
			PodiumDAO p3 = em.find(PodiumDAO.class,list.get(2));
			
			p1.setNumberOfVotes(p1.getNumberOfVotes()+1);
			p2.setNumberOfVotes(p2.getNumberOfVotes()+1);
			p3.setNumberOfVotes(p3.getNumberOfVotes()+1);
			
			switch(vote.getOrder().get(0))
			{
			case 0:
				p1.setPoints(p1.getPoints() + 2);
				break;
			case 1:
				p2.setPoints(p2.getPoints() + 2);
				break;
			case 2:
				p3.setPoints(p3.getPoints() + 2);
				break;
			}
			
			switch(vote.getOrder().get(1))
			{
			case 0:
				p1.setPoints(p1.getPoints() + 1);
				break;
			case 1:
				p2.setPoints(p2.getPoints() + 1);
				break;
			case 2:
				p3.setPoints(p3.getPoints() + 1);
				break;
			}

			switch(vote.getOrder().get(2))
			{
			case 0:
				p1.setPoints(p1.getPoints() + 0);
				break;
			case 1:
				p2.setPoints(p2.getPoints() + 0);
				break;
			case 2:
				p3.setPoints(p3.getPoints() + 0);
				break;
			}
			
			em.merge(p1);
			em.merge(p2);
			em.merge(p3);
			t.commit();
			return Response.ok().entity("Le vote à été pris en compte").build();
		}
		catch(Exception E)
		{
			System.out.println(E.getMessage());
			t.rollback();
			return Response.status(404).entity("Erreur au vote du Podium").build();
		}
		finally
		{
			if(t.isActive())
			{
				t.rollback();
				return Response.status(400).entity("Mauvaise requête").build();
			}
			em.close();
			emSelect.close();
			emf.close();
		}
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("/trending")
	public Response trending(){
		emf = Persistence.createEntityManagerFactory("apiPU");
		em = emf.createEntityManager();
		EntityManager emSelect = emf.createEntityManager();
		try
		{
			@SuppressWarnings("unchecked")
			List<Integer> listPodium = emSelect.createNativeQuery("SELECT idPodium FROM Podium GROUP BY idPodium ORDER BY numberOfVotes DESC LIMIT 3").getResultList();
			PodiumList pl = new PodiumList();
			int i = 0;
			int id = 0;
			boolean erreur = false;
			while(i < listPodium.size() && !erreur)
			{
				id = listPodium.get(i);
				try
				{
					@SuppressWarnings("unchecked")
					List<Integer> list = emSelect.createNativeQuery("SELECT id FROM Podium WHERE idPodium = :v_idPodium ORDER BY id;")
								.setParameter("v_idPodium", id).getResultList();
					if(list.size() != 3){throw new Exception("Aucun résultat !");}
					System.out.println(list.get(0) + " " + list.get(1) + " " + list.get(2));
					pl.addPodium(
							new Podium(
									em.find(PodiumDAO.class,list.get(0)),
									em.find(PodiumDAO.class,list.get(1)),
									em.find(PodiumDAO.class,list.get(2))
							)
					);
				}
				catch(Exception E)
				{
					erreur = true;
					System.out.println(E.getMessage());
					return Response.status(404).entity("Erreur à la sélection du Podium").build();
				}
				i++;
			}
			if(erreur)
			{
				throw new Exception("Erreur lors de la récupération d'un podium");
			}
			else
			{
				return Response.ok().entity(pl).build();
			}
		}
		catch(Exception E)
		{
			return Response.status(404).entity("Erreur à la sélection du top 3 des Podiums").build();
		}
		finally
		{
			em.close();
			emSelect.close();
			emf.close();
		}
	}
	

	@Consumes({"application/json"})
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	@Path("/search")
	public Response search(Search search){
		search.setSearchTerm('%' + search.getSearchTerm() + '%');
		if(search.getPage() <= 0){search.setPage(10);}
		emf = Persistence.createEntityManagerFactory("apiPU");
		em = emf.createEntityManager();
		EntityManager emSelect = emf.createEntityManager();
		try
		{
			@SuppressWarnings("unchecked")
			List<Integer> listPodium = emSelect.createNativeQuery("SELECT idPodium FROM Podium WHERE name LIKE :v_searchTerm1 OR nameItem LIKE :v_searchTerm2 OR imageUrl LIKE :v_searchTerm3 GROUP BY idPodium ORDER BY id ASC LIMIT :v_searchPage ;")
					.setParameter("v_searchTerm1", search.getSearchTerm())
					.setParameter("v_searchTerm2", search.getSearchTerm())
					.setParameter("v_searchTerm3", search.getSearchTerm())
					.setParameter("v_searchPage", search.getPage())
					.getResultList();
			PodiumList pl = new PodiumList();
			int i = 0;
			int id = 0;
			boolean erreur = false;
			while(i < listPodium.size() && !erreur)
			{
				id = listPodium.get(i);
				try
				{
					@SuppressWarnings("unchecked")
					List<Integer> list = emSelect.createNativeQuery("SELECT id FROM Podium WHERE idPodium = :v_idPodium ORDER BY id;")
								.setParameter("v_idPodium", id).getResultList();
					if(list.size() != 3){throw new Exception("Aucun résultat !");}
					System.out.println(list.get(0) + " " + list.get(1) + " " + list.get(2));
					pl.addPodium(
							new Podium(
									em.find(PodiumDAO.class,list.get(0)),
									em.find(PodiumDAO.class,list.get(1)),
									em.find(PodiumDAO.class,list.get(2))
							)
					);
				}
				catch(Exception E)
				{
					erreur = true;
					System.out.println(E.getMessage());
					return Response.status(404).entity("Erreur à la sélection du Podium").build();
				}
				i++;
			}
			if(erreur)
			{
				throw new Exception("Erreur lors de la récupération d'un podium");
			}
			else
			{
				return Response.ok().entity(pl).build();
			}
		}
		catch(Exception E)
		{
			return Response.status(404).entity("Erreur à la sélection du top 3 des Podiums").build();
		}
		finally
		{
			em.close();
			emSelect.close();
			emf.close();
		}
	}
}