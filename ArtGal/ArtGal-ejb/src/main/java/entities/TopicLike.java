package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: TopicLike
 *
 */
@Entity

public class TopicLike implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TopicLikePK id;
	
	private Boolean state;
	
	
	public TopicLike() {
		super();
	}


	public TopicLike(TopicLikePK id, Boolean state) {
		super();
		this.id = id;
		this.state = state;
	}


	public TopicLikePK getId() {
		return id;
	}


	public void setId(TopicLikePK id) {
		this.id = id;
	}


	public Boolean getState() {
		return state;
	}


	public void setState(Boolean state) {
		this.state = state;
	}
   
	
	
}
