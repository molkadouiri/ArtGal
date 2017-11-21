package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the VenteAuxEncheres database table.
 * 
 */
@Entity
@Table(name="VenteAuxEncheres")
@NamedQuery(name="VenteAuxEnchere.findAll", query="SELECT v FROM VenteAuxEnchere v")
public class VenteAuxEnchere implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="VenteId")
	private int venteId;

	@Column(name="Active")
	private boolean active;
	
	@Column(name="status")
	private String status;

	@Column(name="Title")
	private String title;

	//bi-directional many-to-one association to AspNetUser
	@OneToMany(mappedBy="venteAuxEnchere", fetch=FetchType.EAGER)
	private List<AspNetUser> aspNetUsers;

	//bi-directional many-to-one association to Bid
	@OneToMany(mappedBy="venteAuxEnchere", fetch=FetchType.EAGER)
	private List<Bid> bids;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="WinnerId")
	private AspNetUser aspNetUser1;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="ApplicationUser_Id")
	private AspNetUser aspNetUser2;

	//bi-directional many-to-one association to GalleryAssociation
	@ManyToOne
	@JoinColumn(name="GalleryAssociation_GalleryAssociationId")
	private GalleryAssociation galleryAssociation;

	public VenteAuxEnchere() {
	}

	public int getVenteId() {
		return this.venteId;
	}

	public void setVenteId(int venteId) {
		this.venteId = venteId;
	}

	public boolean getActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<AspNetUser> getAspNetUsers() {
		return this.aspNetUsers;
	}

	public void setAspNetUsers(List<AspNetUser> aspNetUsers) {
		this.aspNetUsers = aspNetUsers;
	}

	public AspNetUser addAspNetUser(AspNetUser aspNetUser) {
		getAspNetUsers().add(aspNetUser);
		aspNetUser.setVenteAuxEnchere(this);

		return aspNetUser;
	}

	public AspNetUser removeAspNetUser(AspNetUser aspNetUser) {
		getAspNetUsers().remove(aspNetUser);
		aspNetUser.setVenteAuxEnchere(null);

		return aspNetUser;
	}

	public List<Bid> getBids() {
		return this.bids;
	}

	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}

	public Bid addBid(Bid bid) {
		getBids().add(bid);
		bid.setVenteAuxEnchere(this);

		return bid;
	}

	public Bid removeBid(Bid bid) {
		getBids().remove(bid);
		bid.setVenteAuxEnchere(null);

		return bid;
	}

	public AspNetUser getAspNetUser1() {
		return this.aspNetUser1;
	}

	public void setAspNetUser1(AspNetUser aspNetUser1) {
		this.aspNetUser1 = aspNetUser1;
	}

	public AspNetUser getAspNetUser2() {
		return this.aspNetUser2;
	}

	public void setAspNetUser2(AspNetUser aspNetUser2) {
		this.aspNetUser2 = aspNetUser2;
	}

	public GalleryAssociation getGalleryAssociation() {
		return this.galleryAssociation;
	}

	public void setGalleryAssociation(GalleryAssociation galleryAssociation) {
		this.galleryAssociation = galleryAssociation;
	}

}