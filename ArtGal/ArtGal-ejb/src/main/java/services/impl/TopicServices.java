package services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Topic;
import services.interfaces.TopicServicesLocal;
import services.interfaces.TopicServicesRemote;

/**
 * Session Bean implementation class TopicServices
 */
@Stateless
@LocalBean
public class TopicServices implements TopicServicesRemote, TopicServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public TopicServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(Topic t) {

		entityManager.persist(t);
	}

	@Override
	public void update(Topic t) {
		entityManager.merge(t);
	}

	@Override
	public Topic findTopicById(Integer id) {
		return entityManager.find(Topic.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Topic> findAllTopics() {
		String jpql = "SELECT m FROM Topic m ";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();

	}

	@Override
	public void deleteTopics(Topic topicFound) {
		String jpql = "Delete FROM Topic e where e.id=" + topicFound.getId();
		entityManager.createQuery(jpql).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Topic> findTopicsByUser(String id) {
		String jpql = "SELECT e FROM Topic e where owner.id=:id";
		Query query = entityManager.createQuery(jpql).setParameter("id", id);
		return query.getResultList();
	}

}
