package test1;

// Generated 21.10.2016 14:56:01 by Hibernate Tools 3.4.0.CR1

/**
 * ElementReestr generated by hbm2java
 */
public class ElementReestr implements java.io.Serializable {

	private ElementReestrId id;
	private String valV;
	private String dtChange;

	public ElementReestr() {
	}

	public ElementReestr(ElementReestrId id) {
		this.id = id;
	}

	public ElementReestr(ElementReestrId id, String valV, String dtChange) {
		this.id = id;
		this.valV = valV;
		this.dtChange = dtChange;
	}

	public ElementReestrId getId() {
		return this.id;
	}

	public void setId(ElementReestrId id) {
		this.id = id;
	}

	public String getValV() {
		return this.valV;
	}

	public void setValV(String valV) {
		this.valV = valV;
	}

	public String getDtChange() {
		return this.dtChange;
	}

	public void setDtChange(String dtChange) {
		this.dtChange = dtChange;
	}

}