package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Artworks database table.
 * 
 */
@Entity
@Table(name="Artworks")
@NamedQuery(name="Artwork.findAll", query="SELECT a FROM Artwork a")
public class Artwork implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ArtworksId")
	private int artworksId;

	@Column(name="DateAjout")
	private Timestamp dateAjout;

	@Column(name="Description")
	private String description;


	@Column(name="Etat")
	private String etat;

	@Column(name="Image")
	private String image;

	@Column(name="Material")
	private String material;

	@Column(name="Name")
	private String name;

	@Column(name="Price")
	private double price;

	@Column(name="Size")
	private String size;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="UserId")
	private AspNetUser aspNetUser;

	//uni-directional many-to-one association to SubCategory
	@ManyToOne
	@JoinColumn(name="subcategoryId")
	private SubCategory subCategory;

	//bi-directional many-to-one association to Bid
	@OneToMany(mappedBy="artwork", fetch=FetchType.EAGER)
	private List<Bid> bids;

	public Artwork() {
	}

	public int getArtworksId() {
		return this.artworksId;
	}

	public void setArtworksId(int artworksId) {
		this.artworksId = artworksId;
	}

	public Timestamp getDateAjout() {
		return this.dateAjout;
	}

	public void setDateAjout(Timestamp dateAjout) {
		this.dateAjout = dateAjout;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getMaterial() {
		return this.material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Object getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public AspNetUser getAspNetUser() {
		return this.aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}

	public SubCategory getSubCategory() {
		return this.subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public List<Bid> getBids() {
		return this.bids;
	}

	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}

	public Bid addBid(Bid bid) {
		getBids().add(bid);
		bid.setArtwork(this);

		return bid;
	}

	public Bid removeBid(Bid bid) {
		getBids().remove(bid);
		bid.setArtwork(null);

		return bid;
	}

}