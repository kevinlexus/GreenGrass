package test1;

// Generated 21.10.2016 14:56:01 by Hibernate Tools 3.4.0.CR1

import java.sql.Clob;
import java.util.Date;

/**
 * TrIrbSoapId generated by hbm2java
 */
public class TrIrbSoapId implements java.io.Serializable {

	private Long rn;
	private Date dateload;
	private Clob soapText;
	private String unitcode;

	public TrIrbSoapId() {
	}

	public TrIrbSoapId(Long rn, Date dateload, Clob soapText, String unitcode) {
		this.rn = rn;
		this.dateload = dateload;
		this.soapText = soapText;
		this.unitcode = unitcode;
	}

	public Long getRn() {
		return this.rn;
	}

	public void setRn(Long rn) {
		this.rn = rn;
	}

	public Date getDateload() {
		return this.dateload;
	}

	public void setDateload(Date dateload) {
		this.dateload = dateload;
	}

	public Clob getSoapText() {
		return this.soapText;
	}

	public void setSoapText(Clob soapText) {
		this.soapText = soapText;
	}

	public String getUnitcode() {
		return this.unitcode;
	}

	public void setUnitcode(String unitcode) {
		this.unitcode = unitcode;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TrIrbSoapId))
			return false;
		TrIrbSoapId castOther = (TrIrbSoapId) other;

		return ((this.getRn() == castOther.getRn()) || (this.getRn() != null
				&& castOther.getRn() != null && this.getRn().equals(
				castOther.getRn())))
				&& ((this.getDateload() == castOther.getDateload()) || (this
						.getDateload() != null
						&& castOther.getDateload() != null && this
						.getDateload().equals(castOther.getDateload())))
				&& ((this.getSoapText() == castOther.getSoapText()) || (this
						.getSoapText() != null
						&& castOther.getSoapText() != null && this
						.getSoapText().equals(castOther.getSoapText())))
				&& ((this.getUnitcode() == castOther.getUnitcode()) || (this
						.getUnitcode() != null
						&& castOther.getUnitcode() != null && this
						.getUnitcode().equals(castOther.getUnitcode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getRn() == null ? 0 : this.getRn().hashCode());
		result = 37 * result
				+ (getDateload() == null ? 0 : this.getDateload().hashCode());
		result = 37 * result
				+ (getSoapText() == null ? 0 : this.getSoapText().hashCode());
		result = 37 * result
				+ (getUnitcode() == null ? 0 : this.getUnitcode().hashCode());
		return result;
	}

}
