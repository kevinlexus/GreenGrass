package test1;

// Generated 21.10.2016 14:56:01 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * LSaldoId generated by hbm2java
 */
public class LSaldoId implements java.io.Serializable {

	private String lsk;
	private String mg;
	private BigDecimal org;
	private String uslm;
	private BigDecimal summa;

	public LSaldoId() {
	}

	public LSaldoId(String lsk, String mg, BigDecimal org) {
		this.lsk = lsk;
		this.mg = mg;
		this.org = org;
	}

	public LSaldoId(String lsk, String mg, BigDecimal org, String uslm,
			BigDecimal summa) {
		this.lsk = lsk;
		this.mg = mg;
		this.org = org;
		this.uslm = uslm;
		this.summa = summa;
	}

	public String getLsk() {
		return this.lsk;
	}

	public void setLsk(String lsk) {
		this.lsk = lsk;
	}

	public String getMg() {
		return this.mg;
	}

	public void setMg(String mg) {
		this.mg = mg;
	}

	public BigDecimal getOrg() {
		return this.org;
	}

	public void setOrg(BigDecimal org) {
		this.org = org;
	}

	public String getUslm() {
		return this.uslm;
	}

	public void setUslm(String uslm) {
		this.uslm = uslm;
	}

	public BigDecimal getSumma() {
		return this.summa;
	}

	public void setSumma(BigDecimal summa) {
		this.summa = summa;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof LSaldoId))
			return false;
		LSaldoId castOther = (LSaldoId) other;

		return ((this.getLsk() == castOther.getLsk()) || (this.getLsk() != null
				&& castOther.getLsk() != null && this.getLsk().equals(
				castOther.getLsk())))
				&& ((this.getMg() == castOther.getMg()) || (this.getMg() != null
						&& castOther.getMg() != null && this.getMg().equals(
						castOther.getMg())))
				&& ((this.getOrg() == castOther.getOrg()) || (this.getOrg() != null
						&& castOther.getOrg() != null && this.getOrg().equals(
						castOther.getOrg())))
				&& ((this.getUslm() == castOther.getUslm()) || (this.getUslm() != null
						&& castOther.getUslm() != null && this.getUslm()
						.equals(castOther.getUslm())))
				&& ((this.getSumma() == castOther.getSumma()) || (this
						.getSumma() != null && castOther.getSumma() != null && this
						.getSumma().equals(castOther.getSumma())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getLsk() == null ? 0 : this.getLsk().hashCode());
		result = 37 * result + (getMg() == null ? 0 : this.getMg().hashCode());
		result = 37 * result
				+ (getOrg() == null ? 0 : this.getOrg().hashCode());
		result = 37 * result
				+ (getUslm() == null ? 0 : this.getUslm().hashCode());
		result = 37 * result
				+ (getSumma() == null ? 0 : this.getSumma().hashCode());
		return result;
	}

}
