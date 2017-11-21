package services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Comment;
import services.interfaces.CommentServicesLocal;
import services.interfaces.CommentServicesRemote;

/**
 * Session Bean implementation class Comment
 */
@Stateless
@LocalBean
public class CommentServices implements CommentServicesRemote, CommentServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public CommentServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(Comment t) {
		entityManager.persist(t);
	}

	@Override
	public void update(Comment t) {

		entityManager.merge(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> findAll() {
		String jpql = "SELECT m FROM Comment m ";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public void delete(Comment t) {
		String jpql = "Delete FROM Comment e where e.id=" + t.getId();
		entityManager.createQuery(jpql).executeUpdate();
	}

	@Override
	public Comment findById(Integer id) {

		return entityManager.find(Comment.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> findCommentsByTopicId(Integer id) {
		String jpql = "SELECT e FROM Comment e where topic.id=:id";
		Query query = entityManager.createQuery(jpql).setParameter("id", id);
		return query.getResultList();
	}

}
