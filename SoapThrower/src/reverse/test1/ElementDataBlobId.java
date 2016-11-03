package test1;

// Generated 21.10.2016 14:56:01 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Clob;
import java.util.Date;

/**
 * ElementDataBlobId generated by hbm2java
 */
public class ElementDataBlobId implements java.io.Serializable {

	private BigDecimal valId;
	private BigDecimal elementIdLink;
	private Blob valB;
	private Date valDBeg;
	private Date valDEnd;
	private Clob valClob;

	public ElementDataBlobId() {
	}

	public ElementDataBlobId(BigDecimal elementIdLink) {
		this.elementIdLink = elementIdLink;
	}

	public ElementDataBlobId(BigDecimal valId, BigDecimal elementIdLink,
			Blob valB, Date valDBeg, Date valDEnd, Clob valClob) {
		this.valId = valId;
		this.elementIdLink = elementIdLink;
		this.valB = valB;
		this.valDBeg = valDBeg;
		this.valDEnd = valDEnd;
		this.valClob = valClob;
	}

	public BigDecimal getValId() {
		return this.valId;
	}

	public void setValId(BigDecimal valId) {
		this.valId = valId;
	}

	public BigDecimal getElementIdLink() {
		return this.elementIdLink;
	}

	public void setElementIdLink(BigDecimal elementIdLink) {
		this.elementIdLink = elementIdLink;
	}

	public Blob getValB() {
		return this.valB;
	}

	public void setValB(Blob valB) {
		this.valB = valB;
	}

	public Date getValDBeg() {
		return this.valDBeg;
	}

	public void setValDBeg(Date valDBeg) {
		this.valDBeg = valDBeg;
	}

	public Date getValDEnd() {
		return this.valDEnd;
	}

	public void setValDEnd(Date valDEnd) {
		this.valDEnd = valDEnd;
	}

	public Clob getValClob() {
		return this.valClob;
	}

	public void setValClob(Clob valClob) {
		this.valClob = valClob;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ElementDataBlobId))
			return false;
		ElementDataBlobId castOther = (ElementDataBlobId) other;

		return ((this.getValId() == castOther.getValId()) || (this.getValId() != null
				&& castOther.getValId() != null && this.getValId().equals(
				castOther.getValId())))
				&& ((this.getElementIdLink() == castOther.getElementIdLink()) || (this
						.getElementIdLink() != null
						&& castOther.getElementIdLink() != null && this
						.getElementIdLink()
						.equals(castOther.getElementIdLink())))
				&& ((this.getValB() == castOther.getValB()) || (this.getValB() != null
						&& castOther.getValB() != null && this.getValB()
						.equals(castOther.getValB())))
				&& ((this.getValDBeg() == castOther.getValDBeg()) || (this
						.getValDBeg() != null && castOther.getValDBeg() != null && this
						.getValDBeg().equals(castOther.getValDBeg())))
				&& ((this.getValDEnd() == castOther.getValDEnd()) || (this
						.getValDEnd() != null && castOther.getValDEnd() != null && this
						.getValDEnd().equals(castOther.getValDEnd())))
				&& ((this.getValClob() == castOther.getValClob()) || (this
						.getValClob() != null && castOther.getValClob() != null && this
						.getValClob().equals(castOther.getValClob())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getValId() == null ? 0 : this.getValId().hashCode());
		result = 37
				* result
				+ (getElementIdLink() == null ? 0 : this.getElementIdLink()
						.hashCode());
		result = 37 * result
				+ (getValB() == null ? 0 : this.getValB().hashCode());
		result = 37 * result
				+ (getValDBeg() == null ? 0 : this.getValDBeg().hashCode());
		result = 37 * result
				+ (getValDEnd() == null ? 0 : this.getValDEnd().hashCode());
		result = 37 * result
				+ (getValClob() == null ? 0 : this.getValClob().hashCode());
		return result;
	}

}