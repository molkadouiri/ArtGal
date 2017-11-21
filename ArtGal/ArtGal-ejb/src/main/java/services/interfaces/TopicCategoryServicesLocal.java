package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.TopicCategory;

@Local
public interface TopicCategoryServicesLocal {

	void create(TopicCategory t);

	void update(TopicCategory t);

	TopicCategory findById(Integer id);

	List<TopicCategory> findAll();

	void delete(TopicCategory t);

}
