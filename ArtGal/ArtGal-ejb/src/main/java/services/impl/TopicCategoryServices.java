package services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.TopicCategory;
import services.interfaces.TopicCategoryServicesLocal;
import services.interfaces.TopicCategoryServicesRemote;

/**
 * Session Bean implementation class TopicCategoryServices
 */
@Stateless
@LocalBean
public class TopicCategoryServices implements TopicCategoryServicesRemote, TopicCategoryServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public TopicCategoryServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(TopicCategory t) {
		entityManager.persist(t);
	}

	@Override
	public void update(TopicCategory t) {
		entityManager.merge(t);
	}

	@Override
	public TopicCategory findById(Integer id) {
		return entityManager.find(TopicCategory.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TopicCategory> findAll() {
		String jpql = "SELECT m FROM TopicCategory m ";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public void delete(TopicCategory t) {
		entityManager.remove(t);
	}

}
