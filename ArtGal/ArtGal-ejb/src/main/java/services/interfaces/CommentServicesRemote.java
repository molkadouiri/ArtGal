package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Comment;

@Remote
public interface CommentServicesRemote {

	void create(Comment t);

	void update(Comment t);

	Comment findById(Integer id);

	List<Comment> findCommentsByTopicId(Integer id);

	List<Comment> findAll();

	void delete(Comment t);

}
