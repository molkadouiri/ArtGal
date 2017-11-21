package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Topic;

@Remote
public interface TopicServicesRemote {

	void create(Topic t);

	void update(Topic t);

	Topic findTopicById(Integer id);

	List<Topic> findAllTopics();

	List<Topic> findTopicsByUser(String id);

	void deleteTopics(Topic topicFound);
}
