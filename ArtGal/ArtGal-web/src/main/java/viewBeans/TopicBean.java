package viewBeans;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import entities.AspNetUser;
import entities.Comment;
import entities.CommentLike;
import entities.CommentLikePK;
import entities.Topic;
import entities.TopicCategory;
import services.interfaces.CommentLikeServicesLocal;
import services.interfaces.CommentServicesLocal;
import services.interfaces.TopicLikeServicesLocal;
import services.interfaces.TopicServicesLocal;
import sessionBeans.GlobalBean;
import sessionBeans.LoginBean;

@ManagedBean(name = "topicbean")
@ViewScoped
public class TopicBean {

	@EJB
	TopicServicesLocal topicLocal;
	@EJB
	CommentServicesLocal commentLocal;
	@EJB
	TopicLikeServicesLocal topicLikeLocal;

	@EJB
	CommentLikeServicesLocal commLike;
	@ManagedProperty(value = "#{loginbean}")
	private LoginBean loginbean;
	@ManagedProperty(value = "#{globalbean}")
	private GlobalBean globalbean;
	private AspNetUser loggedUser;
	private Topic selectedTopic;
	private Integer categoryId;
	private List<Topic> allTopics;
	private Comment selectedComment;

	public TopicBean() {
		super();
	}

	@PostConstruct
	public void init() {

		allTopics = topicLocal.findAllTopics();
		loggedUser = loginbean.getUser();
		selectedTopic = globalbean.getSelectedTopic();
		if (selectedComment == null) {
			selectedComment = new Comment();
		}
		// if (selectedComment != null) {
		// selectedComment = globalbean.getSelectedComment();
		// }
		if (selectedTopic == null) {
			selectedTopic = new Topic();
		} // else {
			// selectedTopic = topicLocal.findTopicById(selectedTopic.getId());
			// }
	}

	public void doAddOrUpdateTopic() {
		TopicCategory category = new TopicCategory();
		category.setId(categoryId);
		selectedTopic.setCreationDate(new Date());
		selectedTopic.setCategory(category);
		if (selectedTopic.getId() == null) {
			selectedTopic.setOwner(loggedUser);
			topicLocal.create(selectedTopic);
		} else
			topicLocal.update(selectedTopic);
		globalbean.goToMyTopics();

	}

	public void doAddOrUpdateComment() {
		// selectedTopic = globalbean.getSelectedTopic();
		selectedComment.setCreationDate(new Date());
		if (selectedComment.getId() == null) {
			selectedComment.setOwner(loggedUser);
			selectedComment.setTopic(globalbean.getSelectedTopic());
			commentLocal.create(selectedComment);
		} else
			commentLocal.update(selectedComment);

		selectedComment = new Comment();
		globalbean.goToTopicDetails();
	}

	public void doUpdateComment() {
		globalbean.getSelectedComment().setCreationDate(new Date());
		commentLocal.update(globalbean.getSelectedComment());
		this.globalbean.goToTopicDetails();
	}

	public String deleteTopic(Topic t) {
		topicLocal.deleteTopics(t);
		return globalbean.goToMyTopics();
	}

	public String deleteComment(Comment t) {
		commentLocal.delete(t);
		return globalbean.goToTopicDetails();
	}

	public void likeComment(Integer id) {
		CommentLike comLike = new CommentLike(new CommentLikePK(loginbean.getUser().getId(), id), Boolean.TRUE);
		commLike.create(comLike);
		globalbean.goToTopicDetails();
	}

	@SuppressWarnings({ "static-access" })
	public List<Topic> topFiveTopicsBylike() {

		// Integer v1 = 0;
		// Integer v2 = 0;
		Integer i = 0;
		Map<Topic, Integer> unsorMap = new HashMap<Topic, Integer>();
		Map<Topic, Integer> finalMap = new LinkedHashMap<>();
		// List<Topic> listSorted = new ArrayList<Topic>();
		List<Topic> topFive = new ArrayList<Topic>();

		for (Topic topic : allTopics) {
			unsorMap.put(topic, globalbean.numLikesByTopic(topicLikeLocal.findAll(), topic));
		}

		unsorMap.entrySet().stream().sorted(Map.Entry.<Topic, Integer> comparingByValue().reversed())
				.forEachOrdered(x -> finalMap.put(x.getKey(), x.getValue()));
		for (Map.Entry<Topic, Integer> entry : finalMap.entrySet()) {
			if (i == 5)
				break;
			else {
				topFive.add(entry.getKey());
				i++;
				System.out.println(
						"Topic num--- " + entry.getKey().getId() + " ---has ---" + entry.getValue() + " --- likes");
			}
		}

		// topFive.addAll(map.keySet());
		// map.forEach((x, y) -> topFive.add(x));

		// if (v1 == 0) {
		// v1 = globalbean.numLikesByTopic(topicLikeLocal.findAll(), topic);
		// } else {
		// v2 = globalbean.numLikesByTopic(topicLikeLocal.findAll(), topic);
		// }
		//
		// if (v1 != 0 && v2 != 0) {
		// if (v2 >= v1) {
		// listSorted.add(topic);
		//
		// }
		// v1 = v2;
		// }
		//
		// }
		// System.out.println("trah hal top melowel siiiize" +
		// listSorted.size());
		//
		// for (Topic topic : listSorted) {
		// topFive.add(topic);
		// i++;
		// if (i == 4)
		// break;
		// }
		// System.out.println("trah hal top melowel ");
		//
		// for (Topic topic : topFive) {
		// System.out.println("trah hal top " + topic.getId());
		// }
		// System.out.println("trah hal top mele5er siiiize" + topFive.size());

		return topFive;// new ArrayList<Topic>(finalMap.keySet()).subList(0, 5);

	}

	public List<Topic> latestFiveTopicOfTheMonth() {
		List<Topic> list = new ArrayList<Topic>();
		Calendar c = Calendar.getInstance();
		Integer i = 0;
		for (Topic topic : allTopics) {

			if (i == 5)
				break;
			else {
				c.setTime(topic.getCreationDate());

				if (Calendar.getInstance().get(Calendar.MONTH) == c.get(Calendar.MONTH)) {
					list.add(topic);
					i++;
				}
			}
		}

		return list;
	}

	public Integer countTopicCategoryInTopics(TopicCategory tc) {
		Integer i = 0;
		System.out.println("dkhalna fel count");
		for (Topic topic : allTopics) {
			System.out.println("i before if" + i);
			if (topic.getCategory().getId() == tc.getId()) {
				i++;
				System.out.println("i after if" + i);

			}
		}
		return i;
	}

	public String categoryPercentagePopularity(TopicCategory tc) {

		Double val1 = (double) countTopicCategoryInTopics(tc);
		Double val2 = (double) allTopics.size();
		System.out.println("val1 --------------------" + val1);
		System.out.println("val2 --------------------" + val2);
		System.out.println("Category : " + tc.getName() + "----has percentage----" + (val1 / val2) * 100 + "%");
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		return df.format(((val1 / val2) * 100));
	}

	public AspNetUser getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(AspNetUser loggedUser) {
		this.loggedUser = loggedUser;
	}

	public Topic getSelectedTopic() {
		return selectedTopic;
	}

	public void setSelectedTopic(Topic selectedTopic) {
		this.selectedTopic = selectedTopic;
	}

	public List<Topic> getAllTopics() {
		return allTopics;
	}

	public void setAllTopics(List<Topic> allTopics) {
		this.allTopics = allTopics;
	}

	public LoginBean getLoginbean() {
		return loginbean;
	}

	public void setLoginbean(LoginBean loginbean) {
		this.loginbean = loginbean;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Comment getSelectedComment() {
		return selectedComment;
	}

	public void setSelectedComment(Comment selectedComment) {
		this.selectedComment = selectedComment;
	}

	public GlobalBean getGlobalbean() {
		return globalbean;
	}

	public void setGlobalbean(GlobalBean globalbean) {
		this.globalbean = globalbean;
	}

}
