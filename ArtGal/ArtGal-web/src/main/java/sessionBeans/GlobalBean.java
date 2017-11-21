package sessionBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import entities.AspNetUser;
import entities.Comment;
import entities.CommentLike;
import entities.Topic;
import entities.TopicCategory;
import entities.TopicLike;
import entities.TopicLikePK;
import services.impl.CommentLikeServices;
import services.interfaces.CommentServicesLocal;
import services.interfaces.TopicCategoryServicesLocal;
import services.interfaces.TopicLikeServicesLocal;
import services.interfaces.TopicServicesLocal;

@ManagedBean(name = "globalbean")
@SessionScoped
public class GlobalBean {

	@EJB
	TopicServicesLocal topicLocal;
	@EJB
	CommentServicesLocal commentLocal;
	@EJB
	TopicCategoryServicesLocal categoryLocal;
	@EJB
	TopicLikeServicesLocal likeLocal;
	@EJB
	CommentLikeServices commLikeLocal;

	@ManagedProperty(value = "#{loginbean}")
	private LoginBean loginbean;
	private AspNetUser loggedUser;
	private List<Topic> myTopics;
	private List<TopicCategory> categories;
	private Topic selectedTopic;
	private Comment selectedComment;
	private List<Comment> comments;
	private List<TopicLike> allTopicLikes;
	private Integer topicNumLikes;
	private Integer commentNumLikes;

	@PostConstruct
	public void init() {
		categories = categoryLocal.findAll();
		loggedUser = loginbean.getUser();
		// allTopicLikes = new ArrayList<TopicLike>();
		// allTopicLikes = likeLocal.findAll();
		topicNumLikes = 0;
		commentNumLikes = 0;
		myTopics = topicLocal.findTopicsByUser(loginbean.getUser().getId());
		if (selectedComment == null) {
			selectedComment = new Comment();
		}
		if (selectedTopic == null) {
			selectedTopic = new Topic();
		} else {
			topicLocal.findTopicById(selectedTopic.getId());

		}

	}

	public String goToTopicDetails() {
		comments = commentLocal.findCommentsByTopicId(selectedTopic.getId());
		topicNumLikes = numLikesByTopic(likeLocal.findAll(), selectedTopic);
		// commentNumLikes = numLikesByComment(commLikeLocal.findAll(),
		// comments);
		return "/pages/details/topic?faces-redirect=true";
	}

	public void likeTopic() {
		TopicLike like = new TopicLike(new TopicLikePK(loginbean.getUser().getId(), selectedTopic.getId()),
				Boolean.TRUE);
		likeLocal.create(like);
		goToTopicDetails();

	}

	public static Integer numLikesByTopic(List<TopicLike> all, Topic selected) {
		Integer i = 0;
		for (TopicLike topicLike : all) {
			if (topicLike.getId().getIdTopic() == selected.getId()) {
				i++;
				System.out.println("likes    =" + i);
			}
		}

		return i;
	}

	public Integer numLikesOfTopic(Topic selected) {
		Integer i = 0;
		for (TopicLike topicLike : likeLocal.findAll()) {
			if (topicLike.getId().getIdTopic() == selected.getId()) {
				i++;
				System.out.println("likes    =" + i);
			}
		}

		return i;
	}

	public Integer numLikesByComment(Integer id) {
		Integer i = 0;
		for (CommentLike commentLike : commLikeLocal.findAll()) {
			// for (Comment comment : coms) {
			if (commentLike.getId().getIdComment() == id) {
				i++;
			}
			// }
		}

		return i;
	}

	public String goToMyTopics() {
		myTopics = topicLocal.findTopicsByUser(loginbean.getUser().getId());
		return "/pages/lists/myTopics?faces-redirect=true";
	}

	public String goToAllTopics() {
		myTopics = topicLocal.findTopicsByUser(loginbean.getUser().getId());
		return "/pages/lists/topics?faces-redirect=true";
	}

	public String goToAddOrUpdateTopic() {
		return "/pages/forms/topic?faces-redirect=true";
	}

	public String goToAddTopic() {
		selectedTopic = new Topic();
		return "/pages/forms/topic?faces-redirect=true";
	}

	public String goToUpdateComment() {
		return "/pages/forms/comment?faces-redirect=true";
	}

	public String topicLikedOrOwned(Topic t) {

		String s = "yesLike";
		if (t.getOwner().getId().equals(loginbean.getUser().getId()))
			s = "noLike";
		if (topicAlreadyLiked(t.getId(), loginbean.getUser().getId()).equals(Boolean.TRUE))
			s = "noLike";
		return s;

	}

	public Boolean topicAlreadyLiked(Integer idTopic, String idUser) {
		Boolean b = Boolean.FALSE;
		for (TopicLike topicLike : likeLocal.findAll()) {
			if (topicLike.getId().getIdTopic() == idTopic && topicLike.getId().getIdUser().equals(idUser)) {
				b = Boolean.TRUE;
			}
		}
		return b;
	}

	public String commentLikedOrOwned(Comment t) {

		String s = "yesLike";
		if (commentOwned(t).equals("owned"))
			s = "noLike";
		if (commentAlreadyLiked(t.getId(), loginbean.getUser().getId()).equals(Boolean.TRUE))
			s = "noLike";
		return s;

	}

	public String commentOwned(Comment t) {
		String s = "notOwned";
		if (t.getOwner().getId().equals(loginbean.getUser().getId()))
			s = "owned";
		return s;
	}

	public Boolean commentAlreadyLiked(Integer idComment, String idUser) {
		Boolean b = Boolean.FALSE;
		for (CommentLike commentLike : commLikeLocal.findAll()) {
			if (commentLike.getId().getIdComment() == idComment && commentLike.getId().getIdUser().equals(idUser)) {
				b = Boolean.TRUE;
			}
		}
		return b;
	}

	public LoginBean getLoginbean() {
		return loginbean;
	}

	public void setLoginbean(LoginBean loginbean) {
		this.loginbean = loginbean;
	}

	public List<Topic> getMyTopics() {
		return myTopics;
	}

	public void setMyTopics(List<Topic> myTopics) {
		this.myTopics = myTopics;
	}

	public Topic getSelectedTopic() {
		return selectedTopic;
	}

	public void setSelectedTopic(Topic selectedTopic) {
		this.selectedTopic = selectedTopic;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<TopicCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<TopicCategory> categories) {
		this.categories = categories;
	}

	public AspNetUser getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(AspNetUser loggedUser) {
		this.loggedUser = loggedUser;
	}

	public List<TopicLike> getAllTopicLikes() {
		return allTopicLikes;
	}

	public void setAllTopicLikes(List<TopicLike> allTopicLikes) {
		this.allTopicLikes = allTopicLikes;
	}

	public Integer getTopicNumLikes() {
		return topicNumLikes;
	}

	public void setTopicNumLikes(Integer topicNumLikes) {
		this.topicNumLikes = topicNumLikes;
	}

	public Integer getCommentNumLikes() {
		return commentNumLikes;
	}

	public void setCommentNumLikes(Integer commentNumLikes) {
		this.commentNumLikes = commentNumLikes;
	}

	public Comment getSelectedComment() {
		return selectedComment;
	}

	public void setSelectedComment(Comment selectedComment) {
		this.selectedComment = selectedComment;
	}

}
