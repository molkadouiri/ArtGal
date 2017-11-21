package services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.CommentLike;
import services.interfaces.CommentLikeServicesLocal;
import services.interfaces.CommentLikeServicesRemote;

/**
 * Session Bean implementation class CommentLikeServices
 */
@Stateless
@LocalBean
public class CommentLikeServices implements CommentLikeServicesRemote, CommentLikeServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public CommentLikeServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(CommentLike t) {
		entityManager.persist(t);

	}

	@Override
	public void update(CommentLike t) {

		entityManager.merge(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CommentLike> findAll() {
		String jpql = "SELECT m FROM CommentLike m ";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

}
