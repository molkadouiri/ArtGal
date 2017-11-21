package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the UserConnections database table.
 * 
 */
@Entity
@Table(name="UserConnections")
@NamedQuery(name="UserConnection.findAll", query="SELECT u FROM UserConnection u")
public class UserConnection implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	private Timestamp dateConnection;

	//uni-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="UserId")
	private AspNetUser aspNetUser;

	public UserConnection() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDateConnection() {
		return this.dateConnection;
	}

	public void setDateConnection(Timestamp dateConnection) {
		this.dateConnection = dateConnection;
	}

	public AspNetUser getAspNetUser() {
		return this.aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}

}