package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.CommentLike;

@Local
public interface CommentLikeServicesLocal {

	void create(CommentLike t);

	void update(CommentLike t);

	List<CommentLike> findAll();

}
