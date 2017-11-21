package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the DealAchetes database table.
 * 
 */
@Embeddable
public class DealAchetePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="DealAcheteId")
	private int dealAcheteId;

	@Column(name="UserId")
	private int userId;

	@Column(name="ArtworkId")
	private int artworkId;

	public DealAchetePK() {
	}
	public int getDealAcheteId() {
		return this.dealAcheteId;
	}
	public void setDealAcheteId(int dealAcheteId) {
		this.dealAcheteId = dealAcheteId;
	}
	public int getUserId() {
		return this.userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getArtworkId() {
		return this.artworkId;
	}
	public void setArtworkId(int artworkId) {
		this.artworkId = artworkId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DealAchetePK)) {
			return false;
		}
		DealAchetePK castOther = (DealAchetePK)other;
		return 
			(this.dealAcheteId == castOther.dealAcheteId)
			&& (this.userId == castOther.userId)
			&& (this.artworkId == castOther.artworkId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.dealAcheteId;
		hash = hash * prime + this.userId;
		hash = hash * prime + this.artworkId;
		
		return hash;
	}
}