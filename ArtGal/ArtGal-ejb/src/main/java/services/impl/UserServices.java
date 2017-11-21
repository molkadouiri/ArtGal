package services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.AspNetUser;
import services.interfaces.UserServicesLocal;
import services.interfaces.UserServicesRemote;

/**
 * Session Bean implementation class UserServices
 */
@Stateless
@LocalBean
public class UserServices implements UserServicesRemote, UserServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public UserServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(AspNetUser t) {

		entityManager.persist(t);
	}

	@Override
	public void update(AspNetUser t) {
		entityManager.merge(t);
	}

	@Override
	public AspNetUser findById(String id) {
		
		String jpql = "SELECT e FROM AspNetUser e where id=:id";
		Query query = entityManager.createQuery(jpql).setParameter("id", id);
		return (AspNetUser) query.getSingleResult();
//		return entityManager.find(AspNetUser.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AspNetUser> findAll() {
		String jpql = "SELECT m FROM AspNetUser m ";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();

	}

	@Override
	public void delete(AspNetUser t) {
		entityManager.remove(t);
	}

}
