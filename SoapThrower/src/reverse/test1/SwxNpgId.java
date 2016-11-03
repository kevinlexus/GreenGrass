package test1;

// Generated 21.10.2016 14:56:01 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * SwxNpgId generated by hbm2java
 */
public class SwxNpgId implements java.io.Serializable {

	private String lsk;
	private String uslm;
	private BigDecimal swxS;
	private BigDecimal npgS;
	private BigDecimal swxNpgS;

	public SwxNpgId() {
	}

	public SwxNpgId(String lsk, String uslm, BigDecimal swxS, BigDecimal npgS,
			BigDecimal swxNpgS) {
		this.lsk = lsk;
		this.uslm = uslm;
		this.swxS = swxS;
		this.npgS = npgS;
		this.swxNpgS = swxNpgS;
	}

	public String getLsk() {
		return this.lsk;
	}

	public void setLsk(String lsk) {
		this.lsk = lsk;
	}

	public String getUslm() {
		return this.uslm;
	}

	public void setUslm(String uslm) {
		this.uslm = uslm;
	}

	public BigDecimal getSwxS() {
		return this.swxS;
	}

	public void setSwxS(BigDecimal swxS) {
		this.swxS = swxS;
	}

	public BigDecimal getNpgS() {
		return this.npgS;
	}

	public void setNpgS(BigDecimal npgS) {
		this.npgS = npgS;
	}

	public BigDecimal getSwxNpgS() {
		return this.swxNpgS;
	}

	public void setSwxNpgS(BigDecimal swxNpgS) {
		this.swxNpgS = swxNpgS;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SwxNpgId))
			return false;
		SwxNpgId castOther = (SwxNpgId) other;

		return ((this.getLsk() == castOther.getLsk()) || (this.getLsk() != null
				&& castOther.getLsk() != null && this.getLsk().equals(
				castOther.getLsk())))
				&& ((this.getUslm() == castOther.getUslm()) || (this.getUslm() != null
						&& castOther.getUslm() != null && this.getUslm()
						.equals(castOther.getUslm())))
				&& ((this.getSwxS() == castOther.getSwxS()) || (this.getSwxS() != null
						&& castOther.getSwxS() != null && this.getSwxS()
						.equals(castOther.getSwxS())))
				&& ((this.getNpgS() == castOther.getNpgS()) || (this.getNpgS() != null
						&& castOther.getNpgS() != null && this.getNpgS()
						.equals(castOther.getNpgS())))
				&& ((this.getSwxNpgS() == castOther.getSwxNpgS()) || (this
						.getSwxNpgS() != null && castOther.getSwxNpgS() != null && this
						.getSwxNpgS().equals(castOther.getSwxNpgS())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getLsk() == null ? 0 : this.getLsk().hashCode());
		result = 37 * result
				+ (getUslm() == null ? 0 : this.getUslm().hashCode());
		result = 37 * result
				+ (getSwxS() == null ? 0 : this.getSwxS().hashCode());
		result = 37 * result
				+ (getNpgS() == null ? 0 : this.getNpgS().hashCode());
		result = 37 * result
				+ (getSwxNpgS() == null ? 0 : this.getSwxNpgS().hashCode());
		return result;
	}

}