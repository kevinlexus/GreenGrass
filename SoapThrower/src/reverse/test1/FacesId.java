package test1;

// Generated 21.10.2016 14:56:01 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * FacesId generated by hbm2java
 */
public class FacesId implements java.io.Serializable {

	private BigDecimal faceId;
	private BigDecimal propIdLink;
	private BigDecimal propValLink;
	private String propVal;
	private Date dtBeg;
	private Date dtEnd;

	public FacesId() {
	}

	public FacesId(BigDecimal faceId, BigDecimal propIdLink) {
		this.faceId = faceId;
		this.propIdLink = propIdLink;
	}

	public FacesId(BigDecimal faceId, BigDecimal propIdLink,
			BigDecimal propValLink, String propVal, Date dtBeg, Date dtEnd) {
		this.faceId = faceId;
		this.propIdLink = propIdLink;
		this.propValLink = propValLink;
		this.propVal = propVal;
		this.dtBeg = dtBeg;
		this.dtEnd = dtEnd;
	}

	public BigDecimal getFaceId() {
		return this.faceId;
	}

	public void setFaceId(BigDecimal faceId) {
		this.faceId = faceId;
	}

	public BigDecimal getPropIdLink() {
		return this.propIdLink;
	}

	public void setPropIdLink(BigDecimal propIdLink) {
		this.propIdLink = propIdLink;
	}

	public BigDecimal getPropValLink() {
		return this.propValLink;
	}

	public void setPropValLink(BigDecimal propValLink) {
		this.propValLink = propValLink;
	}

	public String getPropVal() {
		return this.propVal;
	}

	public void setPropVal(String propVal) {
		this.propVal = propVal;
	}

	public Date getDtBeg() {
		return this.dtBeg;
	}

	public void setDtBeg(Date dtBeg) {
		this.dtBeg = dtBeg;
	}

	public Date getDtEnd() {
		return this.dtEnd;
	}

	public void setDtEnd(Date dtEnd) {
		this.dtEnd = dtEnd;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof FacesId))
			return false;
		FacesId castOther = (FacesId) other;

		return ((this.getFaceId() == castOther.getFaceId()) || (this
				.getFaceId() != null && castOther.getFaceId() != null && this
				.getFaceId().equals(castOther.getFaceId())))
				&& ((this.getPropIdLink() == castOther.getPropIdLink()) || (this
						.getPropIdLink() != null
						&& castOther.getPropIdLink() != null && this
						.getPropIdLink().equals(castOther.getPropIdLink())))
				&& ((this.getPropValLink() == castOther.getPropValLink()) || (this
						.getPropValLink() != null
						&& castOther.getPropValLink() != null && this
						.getPropValLink().equals(castOther.getPropValLink())))
				&& ((this.getPropVal() == castOther.getPropVal()) || (this
						.getPropVal() != null && castOther.getPropVal() != null && this
						.getPropVal().equals(castOther.getPropVal())))
				&& ((this.getDtBeg() == castOther.getDtBeg()) || (this
						.getDtBeg() != null && castOther.getDtBeg() != null && this
						.getDtBeg().equals(castOther.getDtBeg())))
				&& ((this.getDtEnd() == castOther.getDtEnd()) || (this
						.getDtEnd() != null && castOther.getDtEnd() != null && this
						.getDtEnd().equals(castOther.getDtEnd())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getFaceId() == null ? 0 : this.getFaceId().hashCode());
		result = 37
				* result
				+ (getPropIdLink() == null ? 0 : this.getPropIdLink()
						.hashCode());
		result = 37
				* result
				+ (getPropValLink() == null ? 0 : this.getPropValLink()
						.hashCode());
		result = 37 * result
				+ (getPropVal() == null ? 0 : this.getPropVal().hashCode());
		result = 37 * result
				+ (getDtBeg() == null ? 0 : this.getDtBeg().hashCode());
		result = 37 * result
				+ (getDtEnd() == null ? 0 : this.getDtEnd().hashCode());
		return result;
	}

}