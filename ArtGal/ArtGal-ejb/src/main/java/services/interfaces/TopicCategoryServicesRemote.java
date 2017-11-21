package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.TopicCategory;

@Remote
public interface TopicCategoryServicesRemote {

	void create(TopicCategory t);

	void update(TopicCategory t);

	TopicCategory findById(Integer id);

	List<TopicCategory> findAll();

	void delete(TopicCategory t);

}
