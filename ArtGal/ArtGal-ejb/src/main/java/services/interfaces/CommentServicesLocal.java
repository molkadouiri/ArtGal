package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Comment;

@Local
public interface CommentServicesLocal {

	void create(Comment t);

	void update(Comment t);

	Comment findById(Integer id);

	List<Comment> findCommentsByTopicId(Integer id);

	List<Comment> findAll();

	void delete(Comment t);

}
