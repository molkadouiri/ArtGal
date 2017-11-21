package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.TopicLike;

@Remote
public interface TopicLikeServicesRemote {
	void create(TopicLike t);

	void update(TopicLike t);

	List<TopicLike> findAll();
	
	
}
