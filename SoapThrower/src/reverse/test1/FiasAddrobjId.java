package test1;

// Generated 21.10.2016 14:56:01 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * FiasAddrobjId generated by hbm2java
 */
public class FiasAddrobjId implements java.io.Serializable {

	private BigDecimal lv;
	private String name;
	private String offname;
	private String shortname;
	private String code;
	private Double actstatus;
	private BigDecimal priorActstatus;
	private Double currstatus;
	private Double operstatus;
	private String previd;
	private String nextid;
	private String aoguid;
	private String parentguid;
	private String allName;
	private BigDecimal isleaf;

	public FiasAddrobjId() {
	}

	public FiasAddrobjId(BigDecimal lv, String name, String offname,
			String shortname, String code, Double actstatus,
			BigDecimal priorActstatus, Double currstatus, Double operstatus,
			String previd, String nextid, String aoguid, String parentguid,
			String allName, BigDecimal isleaf) {
		this.lv = lv;
		this.name = name;
		this.offname = offname;
		this.shortname = shortname;
		this.code = code;
		this.actstatus = actstatus;
		this.priorActstatus = priorActstatus;
		this.currstatus = currstatus;
		this.operstatus = operstatus;
		this.previd = previd;
		this.nextid = nextid;
		this.aoguid = aoguid;
		this.parentguid = parentguid;
		this.allName = allName;
		this.isleaf = isleaf;
	}

	public BigDecimal getLv() {
		return this.lv;
	}

	public void setLv(BigDecimal lv) {
		this.lv = lv;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOffname() {
		return this.offname;
	}

	public void setOffname(String offname) {
		this.offname = offname;
	}

	public String getShortname() {
		return this.shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Double getActstatus() {
		return this.actstatus;
	}

	public void setActstatus(Double actstatus) {
		this.actstatus = actstatus;
	}

	public BigDecimal getPriorActstatus() {
		return this.priorActstatus;
	}

	public void setPriorActstatus(BigDecimal priorActstatus) {
		this.priorActstatus = priorActstatus;
	}

	public Double getCurrstatus() {
		return this.currstatus;
	}

	public void setCurrstatus(Double currstatus) {
		this.currstatus = currstatus;
	}

	public Double getOperstatus() {
		return this.operstatus;
	}

	public void setOperstatus(Double operstatus) {
		this.operstatus = operstatus;
	}

	public String getPrevid() {
		return this.previd;
	}

	public void setPrevid(String previd) {
		this.previd = previd;
	}

	public String getNextid() {
		return this.nextid;
	}

	public void setNextid(String nextid) {
		this.nextid = nextid;
	}

	public String getAoguid() {
		return this.aoguid;
	}

	public void setAoguid(String aoguid) {
		this.aoguid = aoguid;
	}

	public String getParentguid() {
		return this.parentguid;
	}

	public void setParentguid(String parentguid) {
		this.parentguid = parentguid;
	}

	public String getAllName() {
		return this.allName;
	}

	public void setAllName(String allName) {
		this.allName = allName;
	}

	public BigDecimal getIsleaf() {
		return this.isleaf;
	}

	public void setIsleaf(BigDecimal isleaf) {
		this.isleaf = isleaf;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof FiasAddrobjId))
			return false;
		FiasAddrobjId castOther = (FiasAddrobjId) other;

		return ((this.getLv() == castOther.getLv()) || (this.getLv() != null
				&& castOther.getLv() != null && this.getLv().equals(
				castOther.getLv())))
				&& ((this.getName() == castOther.getName()) || (this.getName() != null
						&& castOther.getName() != null && this.getName()
						.equals(castOther.getName())))
				&& ((this.getOffname() == castOther.getOffname()) || (this
						.getOffname() != null && castOther.getOffname() != null && this
						.getOffname().equals(castOther.getOffname())))
				&& ((this.getShortname() == castOther.getShortname()) || (this
						.getShortname() != null
						&& castOther.getShortname() != null && this
						.getShortname().equals(castOther.getShortname())))
				&& ((this.getCode() == castOther.getCode()) || (this.getCode() != null
						&& castOther.getCode() != null && this.getCode()
						.equals(castOther.getCode())))
				&& ((this.getActstatus() == castOther.getActstatus()) || (this
						.getActstatus() != null
						&& castOther.getActstatus() != null && this
						.getActstatus().equals(castOther.getActstatus())))
				&& ((this.getPriorActstatus() == castOther.getPriorActstatus()) || (this
						.getPriorActstatus() != null
						&& castOther.getPriorActstatus() != null && this
						.getPriorActstatus().equals(
								castOther.getPriorActstatus())))
				&& ((this.getCurrstatus() == castOther.getCurrstatus()) || (this
						.getCurrstatus() != null
						&& castOther.getCurrstatus() != null && this
						.getCurrstatus().equals(castOther.getCurrstatus())))
				&& ((this.getOperstatus() == castOther.getOperstatus()) || (this
						.getOperstatus() != null
						&& castOther.getOperstatus() != null && this
						.getOperstatus().equals(castOther.getOperstatus())))
				&& ((this.getPrevid() == castOther.getPrevid()) || (this
						.getPrevid() != null && castOther.getPrevid() != null && this
						.getPrevid().equals(castOther.getPrevid())))
				&& ((this.getNextid() == castOther.getNextid()) || (this
						.getNextid() != null && castOther.getNextid() != null && this
						.getNextid().equals(castOther.getNextid())))
				&& ((this.getAoguid() == castOther.getAoguid()) || (this
						.getAoguid() != null && castOther.getAoguid() != null && this
						.getAoguid().equals(castOther.getAoguid())))
				&& ((this.getParentguid() == castOther.getParentguid()) || (this
						.getParentguid() != null
						&& castOther.getParentguid() != null && this
						.getParentguid().equals(castOther.getParentguid())))
				&& ((this.getAllName() == castOther.getAllName()) || (this
						.getAllName() != null && castOther.getAllName() != null && this
						.getAllName().equals(castOther.getAllName())))
				&& ((this.getIsleaf() == castOther.getIsleaf()) || (this
						.getIsleaf() != null && castOther.getIsleaf() != null && this
						.getIsleaf().equals(castOther.getIsleaf())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getLv() == null ? 0 : this.getLv().hashCode());
		result = 37 * result
				+ (getName() == null ? 0 : this.getName().hashCode());
		result = 37 * result
				+ (getOffname() == null ? 0 : this.getOffname().hashCode());
		result = 37 * result
				+ (getShortname() == null ? 0 : this.getShortname().hashCode());
		result = 37 * result
				+ (getCode() == null ? 0 : this.getCode().hashCode());
		result = 37 * result
				+ (getActstatus() == null ? 0 : this.getActstatus().hashCode());
		result = 37
				* result
				+ (getPriorActstatus() == null ? 0 : this.getPriorActstatus()
						.hashCode());
		result = 37
				* result
				+ (getCurrstatus() == null ? 0 : this.getCurrstatus()
						.hashCode());
		result = 37
				* result
				+ (getOperstatus() == null ? 0 : this.getOperstatus()
						.hashCode());
		result = 37 * result
				+ (getPrevid() == null ? 0 : this.getPrevid().hashCode());
		result = 37 * result
				+ (getNextid() == null ? 0 : this.getNextid().hashCode());
		result = 37 * result
				+ (getAoguid() == null ? 0 : this.getAoguid().hashCode());
		result = 37
				* result
				+ (getParentguid() == null ? 0 : this.getParentguid()
						.hashCode());
		result = 37 * result
				+ (getAllName() == null ? 0 : this.getAllName().hashCode());
		result = 37 * result
				+ (getIsleaf() == null ? 0 : this.getIsleaf().hashCode());
		return result;
	}

}