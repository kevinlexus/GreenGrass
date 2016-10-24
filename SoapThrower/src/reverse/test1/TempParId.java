package test1;

// Generated 21.10.2016 14:56:01 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * TempParId generated by hbm2java
 */
public class TempParId implements java.io.Serializable {

	private BigDecimal CLskId;
	private String lsk;
	private Date dt1;
	private Date dt2;

	public TempParId() {
	}

	public TempParId(BigDecimal CLskId, String lsk, Date dt1, Date dt2) {
		this.CLskId = CLskId;
		this.lsk = lsk;
		this.dt1 = dt1;
		this.dt2 = dt2;
	}

	public BigDecimal getCLskId() {
		return this.CLskId;
	}

	public void setCLskId(BigDecimal CLskId) {
		this.CLskId = CLskId;
	}

	public String getLsk() {
		return this.lsk;
	}

	public void setLsk(String lsk) {
		this.lsk = lsk;
	}

	public Date getDt1() {
		return this.dt1;
	}

	public void setDt1(Date dt1) {
		this.dt1 = dt1;
	}

	public Date getDt2() {
		return this.dt2;
	}

	public void setDt2(Date dt2) {
		this.dt2 = dt2;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TempParId))
			return false;
		TempParId castOther = (TempParId) other;

		return ((this.getCLskId() == castOther.getCLskId()) || (this
				.getCLskId() != null && castOther.getCLskId() != null && this
				.getCLskId().equals(castOther.getCLskId())))
				&& ((this.getLsk() == castOther.getLsk()) || (this.getLsk() != null
						&& castOther.getLsk() != null && this.getLsk().equals(
						castOther.getLsk())))
				&& ((this.getDt1() == castOther.getDt1()) || (this.getDt1() != null
						&& castOther.getDt1() != null && this.getDt1().equals(
						castOther.getDt1())))
				&& ((this.getDt2() == castOther.getDt2()) || (this.getDt2() != null
						&& castOther.getDt2() != null && this.getDt2().equals(
						castOther.getDt2())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCLskId() == null ? 0 : this.getCLskId().hashCode());
		result = 37 * result
				+ (getLsk() == null ? 0 : this.getLsk().hashCode());
		result = 37 * result
				+ (getDt1() == null ? 0 : this.getDt1().hashCode());
		result = 37 * result
				+ (getDt2() == null ? 0 : this.getDt2().hashCode());
		return result;
	}

}
