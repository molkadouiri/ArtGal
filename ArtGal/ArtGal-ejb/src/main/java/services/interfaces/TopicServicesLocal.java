package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Topic;

@Local
public interface TopicServicesLocal {

	void create(Topic t);

	void update(Topic t);

	Topic findTopicById(Integer id);

	List<Topic> findAllTopics();

	List<Topic> findTopicsByUser(String id);

	void deleteTopics(Topic topicFound);

}
