package com.greengrass.house;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class ObjxPropId implements java.io.Serializable {
	
	private Obj obj;
    private Property property;

    
    @ManyToOne
	public Obj getObj() {
		return obj;
	}
 
	public void setObj(Obj obj) {
		this.obj = obj;
	}
 
	@ManyToOne
	public Property getProperty() { 
		return property;
	}
 
	public void setProperty(Property property) {
		this.property = property;
	}
 
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
 
        ObjxPropId that = (ObjxPropId) o;
 
        if (obj != null ? !obj.equals(that.obj) : that.obj != null) return false;
        if (property != null ? !property.equals(that.property) : that.property != null)
            return false;
 
        return true;
    }
 
    public int hashCode() {
        int result;
        result = (obj != null ? obj.hashCode() : 0);
        result = 31 * result + (property != null ? property.hashCode() : 0);
        return result;
    }
    
}
