package test1;

// Generated 21.10.2016 14:56:01 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * DmfOrgId generated by hbm2java
 */
public class DmfOrgId implements java.io.Serializable {

	private String lsk;
	private String fkUsl;
	private BigDecimal fkOrg;

	public DmfOrgId() {
	}

	public DmfOrgId(String lsk, String fkUsl, BigDecimal fkOrg) {
		this.lsk = lsk;
		this.fkUsl = fkUsl;
		this.fkOrg = fkOrg;
	}

	public String getLsk() {
		return this.lsk;
	}

	public void setLsk(String lsk) {
		this.lsk = lsk;
	}

	public String getFkUsl() {
		return this.fkUsl;
	}

	public void setFkUsl(String fkUsl) {
		this.fkUsl = fkUsl;
	}

	public BigDecimal getFkOrg() {
		return this.fkOrg;
	}

	public void setFkOrg(BigDecimal fkOrg) {
		this.fkOrg = fkOrg;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DmfOrgId))
			return false;
		DmfOrgId castOther = (DmfOrgId) other;

		return ((this.getLsk() == castOther.getLsk()) || (this.getLsk() != null
				&& castOther.getLsk() != null && this.getLsk().equals(
				castOther.getLsk())))
				&& ((this.getFkUsl() == castOther.getFkUsl()) || (this
						.getFkUsl() != null && castOther.getFkUsl() != null && this
						.getFkUsl().equals(castOther.getFkUsl())))
				&& ((this.getFkOrg() == castOther.getFkOrg()) || (this
						.getFkOrg() != null && castOther.getFkOrg() != null && this
						.getFkOrg().equals(castOther.getFkOrg())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getLsk() == null ? 0 : this.getLsk().hashCode());
		result = 37 * result
				+ (getFkUsl() == null ? 0 : this.getFkUsl().hashCode());
		result = 37 * result
				+ (getFkOrg() == null ? 0 : this.getFkOrg().hashCode());
		return result;
	}

}
