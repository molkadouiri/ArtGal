package sessionBeans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.AspNetUser;
import services.interfaces.UserServicesLocal;

@ManagedBean(name = "loginbean")
@SessionScoped
public class LoginBean {

	@EJB
	private UserServicesLocal userLocal;
	private AspNetUser user;

	public LoginBean() {
		super();
	}

	@PostConstruct
	public void init() {
		System.out.println("Test init login");
		user = new AspNetUser();
	}

	public String doLogin() {

		// Dynamic impl TODO
		// Getting Static USER as LOGGED USER
		user = userLocal.findById("1");
		System.out.println("welcome user id=" + user.getId() + " username = " + user.getUserName());
		return "/index?faces-redirect=true";

	}

	public AspNetUser getUser() {
		return user;
	}

	public void setUser(AspNetUser user) {
		this.user = user;
	}

}
