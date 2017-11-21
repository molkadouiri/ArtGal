package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.CommentLike;

@Remote
public interface CommentLikeServicesRemote {

	void create(CommentLike t);

	void update(CommentLike t);

	List<CommentLike> findAll();
}
