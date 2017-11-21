package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CommentLikePK implements Serializable {
	private static final long serialVersionUID = 1L;

	private String idUser;
	
	private Integer idComment;

	public CommentLikePK() {
		super();
	}

	public CommentLikePK(String idUser, Integer idComment) {
		super();
		this.idUser = idUser;
		this.idComment = idComment;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public Integer getIdComment() {
		return idComment;
	}

	public void setIdComment(Integer idComment) {
		this.idComment = idComment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idComment == null) ? 0 : idComment.hashCode());
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentLikePK other = (CommentLikePK) obj;
		if (idComment == null) {
			if (other.idComment != null)
				return false;
		} else if (!idComment.equals(other.idComment))
			return false;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		return true;
	}
	
	


}
