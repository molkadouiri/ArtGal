package entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: CommentLike
 *
 */
@Entity

public class CommentLike implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CommentLikePK id;

	private Boolean state;

	public CommentLike() {
		super();
	}

	public CommentLike(CommentLikePK id, Boolean state) {
		super();
		this.id = id;
		this.state = state;
	}

	public CommentLikePK getId() {
		return id;
	}

	public void setId(CommentLikePK id) {
		this.id = id;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

}
