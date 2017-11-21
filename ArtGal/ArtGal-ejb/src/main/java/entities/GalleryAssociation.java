package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the GalleryAssociations database table.
 * 
 */
@Entity
@Table(name="GalleryAssociations")
@NamedQuery(name="GalleryAssociation.findAll", query="SELECT g FROM GalleryAssociation g")
public class GalleryAssociation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="GalleryAssociationId")
	private int galleryAssociationId;

	@Column(name="Address")
	private String address;

	@Column(name="Description")
	private String description;

	@Column(name="Image")
	private String image;

	@Column(name="Name")
	private String name;

	//bi-directional many-to-one association to VenteAuxEnchere
	@OneToMany(mappedBy="galleryAssociation", fetch=FetchType.EAGER)
	private List<VenteAuxEnchere> venteAuxEncheres;

	public GalleryAssociation() {
	}

	public int getGalleryAssociationId() {
		return this.galleryAssociationId;
	}

	public void setGalleryAssociationId(int galleryAssociationId) {
		this.galleryAssociationId = galleryAssociationId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<VenteAuxEnchere> getVenteAuxEncheres() {
		return this.venteAuxEncheres;
	}

	public void setVenteAuxEncheres(List<VenteAuxEnchere> venteAuxEncheres) {
		this.venteAuxEncheres = venteAuxEncheres;
	}

	public VenteAuxEnchere addVenteAuxEnchere(VenteAuxEnchere venteAuxEnchere) {
		getVenteAuxEncheres().add(venteAuxEnchere);
		venteAuxEnchere.setGalleryAssociation(this);

		return venteAuxEnchere;
	}

	public VenteAuxEnchere removeVenteAuxEnchere(VenteAuxEnchere venteAuxEnchere) {
		getVenteAuxEncheres().remove(venteAuxEnchere);
		venteAuxEnchere.setGalleryAssociation(null);

		return venteAuxEnchere;
	}

}