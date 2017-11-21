package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Bids database table.
 * 
 */
@Entity
@Table(name="Bids")
@NamedQuery(name="Bid.findAll", query="SELECT b FROM Bid b")
public class Bid implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BidPK id;

	@Column(name="Active")
	private boolean active;

	@Column(name="DateClose")
	private Timestamp dateClose;

	@Column(name="DateOpen")
	private Timestamp dateOpen;

	@Column(name="Image")
	private String image;

	@Column(name="MinPrice")
	private int minPrice;

	@Column(name="Price")
	private int price;

	private String status;

	@Column(name="UserId")
	private int userId;

	//bi-directional many-to-one association to AspNetUser
	@OneToMany(mappedBy="bid", fetch=FetchType.EAGER)
	private List<AspNetUser> aspNetUsers;

	//bi-directional many-to-one association to Artwork
	@ManyToOne
	@JoinColumn(name="Artworks_ArtworksId")
	private Artwork artwork;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="User_Id")
	private AspNetUser aspNetUser;

	//bi-directional many-to-one association to VenteAuxEnchere
	@ManyToOne
	@JoinColumn(name="VenteId",insertable=false,updatable=false)
	private VenteAuxEnchere venteAuxEnchere;

	public Bid() {
	}

	public BidPK getId() {
		return this.id;
	}

	public void setId(BidPK id) {
		this.id = id;
	}

	public boolean getActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Timestamp getDateClose() {
		return this.dateClose;
	}

	public void setDateClose(Timestamp dateClose) {
		this.dateClose = dateClose;
	}

	public Timestamp getDateOpen() {
		return this.dateOpen;
	}

	public void setDateOpen(Timestamp dateOpen) {
		this.dateOpen = dateOpen;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getMinPrice() {
		return this.minPrice;
	}

	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Object getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<AspNetUser> getAspNetUsers() {
		return this.aspNetUsers;
	}

	public void setAspNetUsers(List<AspNetUser> aspNetUsers) {
		this.aspNetUsers = aspNetUsers;
	}

	public AspNetUser addAspNetUser(AspNetUser aspNetUser) {
		getAspNetUsers().add(aspNetUser);
		aspNetUser.setBid(this);

		return aspNetUser;
	}

	public AspNetUser removeAspNetUser(AspNetUser aspNetUser) {
		getAspNetUsers().remove(aspNetUser);
		aspNetUser.setBid(null);

		return aspNetUser;
	}

	public Artwork getArtwork() {
		return this.artwork;
	}

	public void setArtwork(Artwork artwork) {
		this.artwork = artwork;
	}

	public AspNetUser getAspNetUser() {
		return this.aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}

	public VenteAuxEnchere getVenteAuxEnchere() {
		return this.venteAuxEnchere;
	}

	public void setVenteAuxEnchere(VenteAuxEnchere venteAuxEnchere) {
		this.venteAuxEnchere = venteAuxEnchere;
	}

}