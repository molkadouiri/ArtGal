package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.AspNetUser;

@Local
public interface UserServicesLocal {

	void create(AspNetUser t);

	void update(AspNetUser t);

	AspNetUser findById(String id);

	List<AspNetUser> findAll();

	void delete(AspNetUser t);

}
