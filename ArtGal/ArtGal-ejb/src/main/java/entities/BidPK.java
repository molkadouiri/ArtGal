package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the Bids database table.
 * 
 */
@Embeddable
public class BidPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="VenteId", insertable=false, updatable=false)
	private int venteId;

	@Column(name="ArtworkId")
	private int artworkId;

	@Column(name="BidId")
	private int bidId;

	public BidPK() {
	}
	public int getVenteId() {
		return this.venteId;
	}
	public void setVenteId(int venteId) {
		this.venteId = venteId;
	}
	public int getArtworkId() {
		return this.artworkId;
	}
	public void setArtworkId(int artworkId) {
		this.artworkId = artworkId;
	}
	public int getBidId() {
		return this.bidId;
	}
	public void setBidId(int bidId) {
		this.bidId = bidId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BidPK)) {
			return false;
		}
		BidPK castOther = (BidPK)other;
		return 
			(this.venteId == castOther.venteId)
			&& (this.artworkId == castOther.artworkId)
			&& (this.bidId == castOther.bidId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.venteId;
		hash = hash * prime + this.artworkId;
		hash = hash * prime + this.bidId;
		
		return hash;
	}
}