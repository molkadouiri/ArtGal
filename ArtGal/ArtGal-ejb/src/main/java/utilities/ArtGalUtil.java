package utilities;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import entities.AspNetUser;
import entities.Topic;
import entities.TopicCategory;
import services.interfaces.CommentServicesLocal;
import services.interfaces.TopicCategoryServicesLocal;
import services.interfaces.TopicServicesLocal;
import services.interfaces.UserServicesLocal;

@Singleton
@LocalBean
@Startup

public class ArtGalUtil {

	@EJB
	private TopicServicesLocal topicService;
	@EJB
	private CommentServicesLocal commentService;
	@EJB
	private UserServicesLocal userLocal;
	@EJB
	private TopicCategoryServicesLocal tCLocal;

	public ArtGalUtil() {
	}

	@PostConstruct
	public void initDB() {

//		TopicCategory tp1 = new TopicCategory("critique");
//		TopicCategory tp2 = new TopicCategory("evenement");
//		TopicCategory tp3 = new TopicCategory("deal");
//		TopicCategory tp4 = new TopicCategory("ventes");
//
//		tCLocal.create(tp1);
//		tCLocal.create(tp2);
//		tCLocal.create(tp3);
//		tCLocal.create(tp4);
//
//		tp1.setId(1);
//		tp2.setId(2);
//		tp3.setId(3);
//		tp4.setId(4);
//
//		AspNetUser user1 = new AspNetUser();
//		AspNetUser user2 = new AspNetUser();
//		AspNetUser user3 = new AspNetUser();
//		// if (userLocal.findById("1") == null) {
//		user2.setId("2");
//		user2.setFirstName("samir");
//		user2.setLastName("mabrouk");
//		user2.setEmail("samir.mabrouk@gmail.com");
//		user2.setUserName("samir123");
//		userLocal.create(user2);
//
//		user1.setId("1");
//		user1.setFirstName("ahmed");
//		user1.setLastName("mohamed");
//		user1.setEmail("ahmed.mohamed@gmail.com");
//		user1.setUserName("ahmed123");
//		userLocal.create(user1);
//
//		user3.setId("3");
//		user3.setFirstName("ali");
//		user3.setLastName("mansour");
//		user3.setEmail("ali.mansour@gmail.com");
//		user3.setUserName("ali123");
//		userLocal.create(user3);
//
//		Topic t1 = new Topic("ART1", new Date(), "desc1", tp1);
//		Topic t2 = new Topic("ART2", new Date(), "desc2", tp2);
//		Topic t3 = new Topic("ART3", new Date(), "desc3", tp3);
//		Topic t4 = new Topic("ART4", new Date(), "desc4", tp4);
//		t1.setOwner(user1);
//		t2.setOwner(user1);
//		t3.setOwner(user2);
//		t4.setOwner(user2);
//
//		// }
//		topicService.create(t1);
//		topicService.create(t2);
//		topicService.create(t3);
//		topicService.create(t4);

	}

}
