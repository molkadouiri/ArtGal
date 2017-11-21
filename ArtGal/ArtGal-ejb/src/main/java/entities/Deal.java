package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Deals database table.
 * 
 */
@Entity
@Table(name="Deals")
@NamedQuery(name="Deal.findAll", query="SELECT d FROM Deal d")
public class Deal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int dealId;

	@Column(name="ArtworkId")
	private int artworkId;

	@Column(name="DateDeb")
	private Timestamp dateDeb;

	@Column(name="DateFin")
	private Timestamp dateFin;

	@Column(name="Description")
	private String description;

	@Column(name="ImageUrl")
	private String imageUrl;

	@Column(name="NomDeal")
	private String nomDeal;

	@Column(name="Quantity")
	private int quantity;

	private int reduction;

	@Column(name="UserId")
	private int userId;

	//bi-directional many-to-one association to DealAchete
	@OneToMany(mappedBy="deal", fetch=FetchType.EAGER)
	private List<DealAchete> dealAchetes;

	//uni-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="user_Id")
	private AspNetUser aspNetUser;

	public Deal() {
	}

	public int getDealId() {
		return this.dealId;
	}

	public void setDealId(int dealId) {
		this.dealId = dealId;
	}

	public int getArtworkId() {
		return this.artworkId;
	}

	public void setArtworkId(int artworkId) {
		this.artworkId = artworkId;
	}

	public Timestamp getDateDeb() {
		return this.dateDeb;
	}

	public void setDateDeb(Timestamp dateDeb) {
		this.dateDeb = dateDeb;
	}

	public Timestamp getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(Timestamp dateFin) {
		this.dateFin = dateFin;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getNomDeal() {
		return this.nomDeal;
	}

	public void setNomDeal(String nomDeal) {
		this.nomDeal = nomDeal;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getReduction() {
		return this.reduction;
	}

	public void setReduction(int reduction) {
		this.reduction = reduction;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<DealAchete> getDealAchetes() {
		return this.dealAchetes;
	}

	public void setDealAchetes(List<DealAchete> dealAchetes) {
		this.dealAchetes = dealAchetes;
	}

	public DealAchete addDealAchete(DealAchete dealAchete) {
		getDealAchetes().add(dealAchete);
		dealAchete.setDeal(this);

		return dealAchete;
	}

	public DealAchete removeDealAchete(DealAchete dealAchete) {
		getDealAchetes().remove(dealAchete);
		dealAchete.setDeal(null);

		return dealAchete;
	}

	public AspNetUser getAspNetUser() {
		return this.aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}

}