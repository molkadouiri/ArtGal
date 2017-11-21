package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.AspNetUser;

@Remote
public interface UserServicesRemote {

	void create(AspNetUser t);

	void update(AspNetUser t);

	AspNetUser findById(String id);

	List<AspNetUser> findAll();

	void delete(AspNetUser t);

}
