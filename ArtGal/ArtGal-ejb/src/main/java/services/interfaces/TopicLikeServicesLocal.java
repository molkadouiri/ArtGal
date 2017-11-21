package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.TopicLike;

@Local
public interface TopicLikeServicesLocal {

	void create(TopicLike t);

	void update(TopicLike t);

	List<TopicLike> findAll();
}
