package entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * The persistent class for the AspNetUsers database table.
 * 
 */
@Entity
public class AspNetUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	// @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Id", insertable = false, updatable = false)
	private String id;

	@Column(name = "AccessFailedCount")
	private int accessFailedCount;

	@Column(name = "Email")
	private String email;

	@Column(name = "EmailConfirmed")
	private boolean emailConfirmed;

	@Column(name = "FirstName")
	private String firstName;

	@Column(name = "ImageUrl")
	private String imageUrl;

	@Column(name = "LastName")
	private String lastName;

	@Column(name = "LockoutEnabled")
	private boolean lockoutEnabled;

	@Column(name = "LockoutEndDateUtc")
	private Timestamp lockoutEndDateUtc;

	@Column(name = "PasswordHash")
	private String passwordHash;

	@Column(name = "PasswordNonHasher")
	private String passwordNonHasher;

	@Column(name = "PhoneNumber")
	private String phoneNumber;

	@Column(name = "PhoneNumberConfirmed")
	private boolean phoneNumberConfirmed;

	@Column(name = "SecurityStamp")
	private String securityStamp;

	@Column(name = "TwoFactorEnabled")
	private boolean twoFactorEnabled;

	@Column(name = "UserName")
	private String userName;

	// bi-directional many-to-one association to Artwork
	@OneToMany(mappedBy = "aspNetUser", fetch = FetchType.EAGER)
	private List<Artwork> artworks;

	// bi-directional many-to-many association to AspNetRole
	// @ManyToMany(fetch=FetchType.EAGER)
	// @JoinTable(
	// name="AspNetUserRoles"
	// , joinColumns={
	// @JoinColumn(name="UserId")
	// }
	// , inverseJoinColumns={
	// @JoinColumn(name="RoleId")
	// }
	// )
	// private List<AspNetRole> aspNetRoles;

	// bi-directional many-to-one association to Bid
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "Bid_ArtworkId", referencedColumnName = "ArtworkId"),
			@JoinColumn(name = "Bid_BidId", referencedColumnName = "BidId"),
			@JoinColumn(name = "Bid_VenteId", referencedColumnName = "VenteId") })
	private Bid bid;

	// bi-directional many-to-one association to VenteAuxEnchere
	@ManyToOne
	@JoinColumn(name = "VenteAuxEncheres_VenteId")
	private VenteAuxEnchere venteAuxEnchere;

	// bi-directional many-to-one association to Bid
	@OneToMany(mappedBy = "aspNetUser", fetch = FetchType.EAGER)
	private List<Bid> bids;

	// bi-directional many-to-one association to DealAchete
	@OneToMany(mappedBy = "aspNetUser", fetch = FetchType.EAGER)
	private List<DealAchete> dealAchetes;

	// bi-directional many-to-one association to VenteAuxEnchere
	@OneToMany(mappedBy = "aspNetUser1", fetch = FetchType.EAGER)
	private List<VenteAuxEnchere> venteAuxEncheres1;

	// bi-directional many-to-one association to VenteAuxEnchere
	@OneToMany(mappedBy = "aspNetUser2", fetch = FetchType.EAGER)
	private List<VenteAuxEnchere> venteAuxEncheres2;

	public AspNetUser() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAccessFailedCount() {
		return this.accessFailedCount;
	}

	public void setAccessFailedCount(int accessFailedCount) {
		this.accessFailedCount = accessFailedCount;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getEmailConfirmed() {
		return this.emailConfirmed;
	}

	public void setEmailConfirmed(boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean getLockoutEnabled() {
		return this.lockoutEnabled;
	}

	public void setLockoutEnabled(boolean lockoutEnabled) {
		this.lockoutEnabled = lockoutEnabled;
	}

	public Timestamp getLockoutEndDateUtc() {
		return this.lockoutEndDateUtc;
	}

	public void setLockoutEndDateUtc(Timestamp lockoutEndDateUtc) {
		this.lockoutEndDateUtc = lockoutEndDateUtc;
	}

	public String getPasswordHash() {
		return this.passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getPasswordNonHasher() {
		return this.passwordNonHasher;
	}

	public void setPasswordNonHasher(String passwordNonHasher) {
		this.passwordNonHasher = passwordNonHasher;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean getPhoneNumberConfirmed() {
		return this.phoneNumberConfirmed;
	}

	public void setPhoneNumberConfirmed(boolean phoneNumberConfirmed) {
		this.phoneNumberConfirmed = phoneNumberConfirmed;
	}

	public String getSecurityStamp() {
		return this.securityStamp;
	}

	public void setSecurityStamp(String securityStamp) {
		this.securityStamp = securityStamp;
	}

	public boolean getTwoFactorEnabled() {
		return this.twoFactorEnabled;
	}

	public void setTwoFactorEnabled(boolean twoFactorEnabled) {
		this.twoFactorEnabled = twoFactorEnabled;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Artwork> getArtworks() {
		return this.artworks;
	}

	public void setArtworks(List<Artwork> artworks) {
		this.artworks = artworks;
	}

	public Artwork addArtwork(Artwork artwork) {
		getArtworks().add(artwork);
		artwork.setAspNetUser(this);

		return artwork;
	}

	public Artwork removeArtwork(Artwork artwork) {
		getArtworks().remove(artwork);
		artwork.setAspNetUser(null);

		return artwork;
	}

	// public List<AspNetRole> getAspNetRoles() {
	// return this.aspNetRoles;
	// }
	//
	// public void setAspNetRoles(List<AspNetRole> aspNetRoles) {
	// this.aspNetRoles = aspNetRoles;
	// }

	public Bid getBid() {
		return this.bid;
	}

	public void setBid(Bid bid) {
		this.bid = bid;
	}

	public VenteAuxEnchere getVenteAuxEnchere() {
		return this.venteAuxEnchere;
	}

	public void setVenteAuxEnchere(VenteAuxEnchere venteAuxEnchere) {
		this.venteAuxEnchere = venteAuxEnchere;
	}

	public List<Bid> getBids() {
		return this.bids;
	}

	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}

	public Bid addBid(Bid bid) {
		getBids().add(bid);
		bid.setAspNetUser(this);

		return bid;
	}

	public Bid removeBid(Bid bid) {
		getBids().remove(bid);
		bid.setAspNetUser(null);

		return bid;
	}

	public List<DealAchete> getDealAchetes() {
		return this.dealAchetes;
	}

	public void setDealAchetes(List<DealAchete> dealAchetes) {
		this.dealAchetes = dealAchetes;
	}

	public DealAchete addDealAchete(DealAchete dealAchete) {
		getDealAchetes().add(dealAchete);
		dealAchete.setAspNetUser(this);

		return dealAchete;
	}

	public DealAchete removeDealAchete(DealAchete dealAchete) {
		getDealAchetes().remove(dealAchete);
		dealAchete.setAspNetUser(null);

		return dealAchete;
	}

	public List<VenteAuxEnchere> getVenteAuxEncheres1() {
		return this.venteAuxEncheres1;
	}

	public void setVenteAuxEncheres1(List<VenteAuxEnchere> venteAuxEncheres1) {
		this.venteAuxEncheres1 = venteAuxEncheres1;
	}

	public VenteAuxEnchere addVenteAuxEncheres1(VenteAuxEnchere venteAuxEncheres1) {
		getVenteAuxEncheres1().add(venteAuxEncheres1);
		venteAuxEncheres1.setAspNetUser1(this);

		return venteAuxEncheres1;
	}

	public VenteAuxEnchere removeVenteAuxEncheres1(VenteAuxEnchere venteAuxEncheres1) {
		getVenteAuxEncheres1().remove(venteAuxEncheres1);
		venteAuxEncheres1.setAspNetUser1(null);

		return venteAuxEncheres1;
	}

	public List<VenteAuxEnchere> getVenteAuxEncheres2() {
		return this.venteAuxEncheres2;
	}

	public void setVenteAuxEncheres2(List<VenteAuxEnchere> venteAuxEncheres2) {
		this.venteAuxEncheres2 = venteAuxEncheres2;
	}

	public VenteAuxEnchere addVenteAuxEncheres2(VenteAuxEnchere venteAuxEncheres2) {
		getVenteAuxEncheres2().add(venteAuxEncheres2);
		venteAuxEncheres2.setAspNetUser2(this);

		return venteAuxEncheres2;
	}

	public VenteAuxEnchere removeVenteAuxEncheres2(VenteAuxEnchere venteAuxEncheres2) {
		getVenteAuxEncheres2().remove(venteAuxEncheres2);
		venteAuxEncheres2.setAspNetUser2(null);

		return venteAuxEncheres2;
	}

}