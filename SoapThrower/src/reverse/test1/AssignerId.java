package test1;

// Generated 21.10.2016 14:56:01 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * AssignerId generated by hbm2java
 */
public class AssignerId implements java.io.Serializable {

	private BigDecimal id;
	private String reu;
	private String kul;
	private String nd;
	private BigDecimal fkSrc;
	private BigDecimal fkDst;
	private String mg1;
	private String mg2;
	private String comm;
	private String username;
	private Date dtf;

	public AssignerId() {
	}

	public AssignerId(BigDecimal id, String reu, String kul, String nd,
			BigDecimal fkSrc, BigDecimal fkDst, String mg1, String mg2,
			String comm, String username, Date dtf) {
		this.id = id;
		this.reu = reu;
		this.kul = kul;
		this.nd = nd;
		this.fkSrc = fkSrc;
		this.fkDst = fkDst;
		this.mg1 = mg1;
		this.mg2 = mg2;
		this.comm = comm;
		this.username = username;
		this.dtf = dtf;
	}

	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
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

	public BigDecimal getFkSrc() {
		return this.fkSrc;
	}

	public void setFkSrc(BigDecimal fkSrc) {
		this.fkSrc = fkSrc;
	}

	public BigDecimal getFkDst() {
		return this.fkDst;
	}

	public void setFkDst(BigDecimal fkDst) {
		this.fkDst = fkDst;
	}

	public String getMg1() {
		return this.mg1;
	}

	public void setMg1(String mg1) {
		this.mg1 = mg1;
	}

	public String getMg2() {
		return this.mg2;
	}

	public void setMg2(String mg2) {
		this.mg2 = mg2;
	}

	public String getComm() {
		return this.comm;
	}

	public void setComm(String comm) {
		this.comm = comm;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getDtf() {
		return this.dtf;
	}

	public void setDtf(Date dtf) {
		this.dtf = dtf;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AssignerId))
			return false;
		AssignerId castOther = (AssignerId) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getReu() == castOther.getReu()) || (this.getReu() != null
						&& castOther.getReu() != null && this.getReu().equals(
						castOther.getReu())))
				&& ((this.getKul() == castOther.getKul()) || (this.getKul() != null
						&& castOther.getKul() != null && this.getKul().equals(
						castOther.getKul())))
				&& ((this.getNd() == castOther.getNd()) || (this.getNd() != null
						&& castOther.getNd() != null && this.getNd().equals(
						castOther.getNd())))
				&& ((this.getFkSrc() == castOther.getFkSrc()) || (this
						.getFkSrc() != null && castOther.getFkSrc() != null && this
						.getFkSrc().equals(castOther.getFkSrc())))
				&& ((this.getFkDst() == castOther.getFkDst()) || (this
						.getFkDst() != null && castOther.getFkDst() != null && this
						.getFkDst().equals(castOther.getFkDst())))
				&& ((this.getMg1() == castOther.getMg1()) || (this.getMg1() != null
						&& castOther.getMg1() != null && this.getMg1().equals(
						castOther.getMg1())))
				&& ((this.getMg2() == castOther.getMg2()) || (this.getMg2() != null
						&& castOther.getMg2() != null && this.getMg2().equals(
						castOther.getMg2())))
				&& ((this.getComm() == castOther.getComm()) || (this.getComm() != null
						&& castOther.getComm() != null && this.getComm()
						.equals(castOther.getComm())))
				&& ((this.getUsername() == castOther.getUsername()) || (this
						.getUsername() != null
						&& castOther.getUsername() != null && this
						.getUsername().equals(castOther.getUsername())))
				&& ((this.getDtf() == castOther.getDtf()) || (this.getDtf() != null
						&& castOther.getDtf() != null && this.getDtf().equals(
						castOther.getDtf())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getReu() == null ? 0 : this.getReu().hashCode());
		result = 37 * result
				+ (getKul() == null ? 0 : this.getKul().hashCode());
		result = 37 * result + (getNd() == null ? 0 : this.getNd().hashCode());
		result = 37 * result
				+ (getFkSrc() == null ? 0 : this.getFkSrc().hashCode());
		result = 37 * result
				+ (getFkDst() == null ? 0 : this.getFkDst().hashCode());
		result = 37 * result
				+ (getMg1() == null ? 0 : this.getMg1().hashCode());
		result = 37 * result
				+ (getMg2() == null ? 0 : this.getMg2().hashCode());
		result = 37 * result
				+ (getComm() == null ? 0 : this.getComm().hashCode());
		result = 37 * result
				+ (getUsername() == null ? 0 : this.getUsername().hashCode());
		result = 37 * result
				+ (getDtf() == null ? 0 : this.getDtf().hashCode());
		return result;
	}

}