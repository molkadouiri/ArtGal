package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the DealAchetes database table.
 * 
 */
@Entity
@Table(name="DealAchetes")
@NamedQuery(name="DealAchete.findAll", query="SELECT d FROM DealAchete d")
public class DealAchete implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DealAchetePK id;

	@Column(name="DateAchat")
	private Timestamp dateAchat;

	@Column(name="Etat")
	private String etat;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="user_Id")
	private AspNetUser aspNetUser;

	//bi-directional many-to-one association to Deal
	@ManyToOne
	private Deal deal;

	public DealAchete() {
	}

	public DealAchetePK getId() {
		return this.id;
	}

	public void setId(DealAchetePK id) {
		this.id = id;
	}

	public Timestamp getDateAchat() {
		return this.dateAchat;
	}

	public void setDateAchat(Timestamp dateAchat) {
		this.dateAchat = dateAchat;
	}

	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public AspNetUser getAspNetUser() {
		return this.aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}

	public Deal getDeal() {
		return this.deal;
	}

	public void setDeal(Deal deal) {
		this.deal = deal;
	}

}