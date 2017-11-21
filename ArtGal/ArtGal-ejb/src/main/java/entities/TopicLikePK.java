package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class TopicLikePK implements Serializable {
	private static final long serialVersionUID = 1L;

	private String idUser;
	
	private Integer idTopic;

	public TopicLikePK() {
		super();
	}

	public TopicLikePK(String idUser, Integer idTopic) {
		super();
		this.idUser = idUser;
		this.idTopic = idTopic;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public Integer getIdTopic() {
		return idTopic;
	}

	public void setIdTopic(Integer idTopic) {
		this.idTopic = idTopic;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTopic == null) ? 0 : idTopic.hashCode());
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
		TopicLikePK other = (TopicLikePK) obj;
		if (idTopic == null) {
			if (other.idTopic != null)
				return false;
		} else if (!idTopic.equals(other.idTopic))
			return false;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		return true;
	}
	
	

}
