package services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.TopicLike;
import services.interfaces.TopicLikeServicesLocal;
import services.interfaces.TopicLikeServicesRemote;

/**
 * Session Bean implementation class TopicLikeServices
 */
@Stateless
@LocalBean
public class TopicLikeServices implements TopicLikeServicesRemote, TopicLikeServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public TopicLikeServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(TopicLike t) {
		entityManager.persist(t);
	}

	@Override
	public void update(TopicLike t) {
		entityManager.merge(t);

	}

	@Override
	public List<TopicLike> findAll() {
		String jpql = "SELECT m FROM TopicLike m ";
		Query query = entityManager.createQuery(jpql, TopicLike.class);
		return (List<TopicLike>) query.getResultList();
	}

}
