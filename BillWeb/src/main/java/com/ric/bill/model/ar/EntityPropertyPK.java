package com.ric.bill.model.ar;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.ric.bill.model.bs.Org;

@Embeddable
public class EntityPropertyPK implements Serializable {
	@Column(name = "LSK", updatable = false, insertable = false)
	public String lsk;
	@JoinColumn(name="FK_UK", referencedColumnName="ID", updatable = false, insertable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	public Org uk;
	@Column(name = "DT1", updatable = false, insertable = false)
	public Date dt1;
	@Column(name = "DT2", updatable = false, insertable = false)
	public Date dt2;

	public EntityPropertyPK() {
	}
	
	public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof EntityPropertyPK))
            return false;
        EntityPropertyPK castOther = (EntityPropertyPK) other;
        return lsk.equals(castOther.lsk) && uk.equals(castOther.uk) && dt1.equals(castOther.dt1) && dt2.equals(castOther.dt2);
    }

    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder();
        hcb.append(lsk);
        hcb.append(uk);
        hcb.append(dt1);
        hcb.append(dt2);
        return hcb.toHashCode();
    }	
}