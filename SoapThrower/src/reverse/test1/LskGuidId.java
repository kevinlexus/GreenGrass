package test1;

// Generated 21.10.2016 14:56:01 by Hibernate Tools 3.4.0.CR1

/**
 * LskGuidId generated by hbm2java
 */
public class LskGuidId implements java.io.Serializable {

	private String lsk;
	private String ulsk;
	private String ulskCd;
	private String uflatCd;
	private String reu;
	private String kul;
	private String nd;
	private String kw;
	private String gkn;

	public LskGuidId() {
	}

	public LskGuidId(String lsk, String ulsk, String ulskCd, String uflatCd,
			String reu, String kul, String nd, String kw, String gkn) {
		this.lsk = lsk;
		this.ulsk = ulsk;
		this.ulskCd = ulskCd;
		this.uflatCd = uflatCd;
		this.reu = reu;
		this.kul = kul;
		this.nd = nd;
		this.kw = kw;
		this.gkn = gkn;
	}

	public String getLsk() {
		return this.lsk;
	}

	public void setLsk(String lsk) {
		this.lsk = lsk;
	}

	public String getUlsk() {
		return this.ulsk;
	}

	public void setUlsk(String ulsk) {
		this.ulsk = ulsk;
	}

	public String getUlskCd() {
		return this.ulskCd;
	}

	public void setUlskCd(String ulskCd) {
		this.ulskCd = ulskCd;
	}

	public String getUflatCd() {
		return this.uflatCd;
	}

	public void setUflatCd(String uflatCd) {
		this.uflatCd = uflatCd;
	}

	public String getReu() {
		return this.reu;
	}

	public void setReu(String reu) {
		this.reu = reu;
	}

	public String getKul() {
		return this.kul;
	}

	public void setKul(String kul) {
		this.kul = kul;
	}

	public String getNd() {
		return this.nd;
	}

	public void setNd(String nd) {
		this.nd = nd;
	}

	public String getKw() {
		return this.kw;
	}

	public void setKw(String kw) {
		this.kw = kw;
	}

	public String getGkn() {
		return this.gkn;
	}

	public void setGkn(String gkn) {
		this.gkn = gkn;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof LskGuidId))
			return false;
		LskGuidId castOther = (LskGuidId) other;

		return ((this.getLsk() == castOther.getLsk()) || (this.getLsk() != null
				&& castOther.getLsk() != null && this.getLsk().equals(
				castOther.getLsk())))
				&& ((this.getUlsk() == castOther.getUlsk()) || (this.getUlsk() != null
						&& castOther.getUlsk() != null && this.getUlsk()
						.equals(castOther.getUlsk())))
				&& ((this.getUlskCd() == castOther.getUlskCd()) || (this
						.getUlskCd() != null && castOther.getUlskCd() != null && this
						.getUlskCd().equals(castOther.getUlskCd())))
				&& ((this.getUflatCd() == castOther.getUflatCd()) || (this
						.getUflatCd() != null && castOther.getUflatCd() != null && this
						.getUflatCd().equals(castOther.getUflatCd())))
				&& ((this.getReu() == castOther.getReu()) || (this.getReu() != null
						&& castOther.getReu() != null && this.getReu().equals(
						castOther.getReu())))
				&& ((this.getKul() == castOther.getKul()) || (this.getKul() != null
						&& castOther.getKul() != null && this.getKul().equals(
						castOther.getKul())))
				&& ((this.getNd() == castOther.getNd()) || (this.getNd() != null
						&& castOther.getNd() != null && this.getNd().equals(
						castOther.getNd())))
				&& ((this.getKw() == castOther.getKw()) || (this.getKw() != null
						&& castOther.getKw() != null && this.getKw().equals(
						castOther.getKw())))
				&& ((this.getGkn() == castOther.getGkn()) || (this.getGkn() != null
						&& castOther.getGkn() != null && this.getGkn().equals(
						castOther.getGkn())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getLsk() == null ? 0 : this.getLsk().hashCode());
		result = 37 * result
				+ (getUlsk() == null ? 0 : this.getUlsk().hashCode());
		result = 37 * result
				+ (getUlskCd() == null ? 0 : this.getUlskCd().hashCode());
		result = 37 * result
				+ (getUflatCd() == null ? 0 : this.getUflatCd().hashCode());
		result = 37 * result
				+ (getReu() == null ? 0 : this.getReu().hashCode());
		result = 37 * result
				+ (getKul() == null ? 0 : this.getKul().hashCode());
		result = 37 * result + (getNd() == null ? 0 : this.getNd().hashCode());
		result = 37 * result + (getKw() == null ? 0 : this.getKw().hashCode());
		result = 37 * result
				+ (getGkn() == null ? 0 : this.getGkn().hashCode());
		return result;
	}

}
