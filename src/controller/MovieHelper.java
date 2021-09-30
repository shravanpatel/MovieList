package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.MovieItem;

/**
 * @author Shravan - spatel10
 * CIS175 - Fall 2021
 * Sep 30, 2021
 */
public class MovieHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MovieList");

	public void insertMovie(MovieItem toInsert) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toInsert);
		em.getTransaction().commit();
		em.close();
	}

	public void deleteMovie(MovieItem toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<MovieItem> typedQuery = em.createQuery("SELECT i FROM MovieItem i WHERE i.title = :selectedTitle",
				MovieItem.class);
		typedQuery.setParameter("selectedTitle", toDelete.getTitle());
		typedQuery.setMaxResults(1);

		MovieItem result = typedQuery.getSingleResult();

		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public List<MovieItem> showAllMovies() {
		EntityManager em = emfactory.createEntityManager();
		List<MovieItem> allItems = em.createQuery("SELECT i FROM MovieItem i").getResultList();
		return allItems;
	}

	public List<MovieItem> searchForMovieByTitle(String titleName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<MovieItem> typedQuery = em.createQuery("SELECT i FROM MovieItem i WHERE i.title = :selectedTitle",
				MovieItem.class);
		typedQuery.setParameter("selectedTitle", titleName);
		List<MovieItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<MovieItem> searchForMovieByDirector(String directorName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<MovieItem> typedQuery = em
				.createQuery("SELECT i FROM MovieItem i WHERE i.director = :selectedDirector", MovieItem.class);
		typedQuery.setParameter("selectedDirector", directorName);
		List<MovieItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<MovieItem> searchForMovieByActor(String actorName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<MovieItem> typedQuery = em
				.createQuery("SELECT i FROM MovieItem i WHERE i.actor LIKE '%selectedActor%'", MovieItem.class);
		typedQuery.setParameter("selectedActor", actorName);
		List<MovieItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<MovieItem> searchForMovieByGenre(String genreSelected) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<MovieItem> typedQuery = em
				.createQuery("SELECT i FROM MovieItem i WHERE i.genre LIKE '%selectedGenre%'", MovieItem.class);
		typedQuery.setParameter("selectedGenre", genreSelected);
		List<MovieItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public MovieItem searchForMovieById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		MovieItem found = em.find(MovieItem.class, idToEdit);
		em.close();
		return found;
	}

	public void updateMovie(MovieItem toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public void cleanUp() {
		emfactory.close();
	}
}
