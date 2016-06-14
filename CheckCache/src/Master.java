import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name = "MASTER", schema="FN")
public class Master implements java.io.Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false, insertable = false)
	private Integer id;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="BBB", referencedColumnName="BBB", table = "")
	private Set<Detail> detail = new HashSet<Detail>(0);
	
    @Column(name = "BBB")
	private Integer bbb;

	public Master() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Detail> getDetail() {
		return this.detail;
	}

	public void setDetail(Set<Detail> detail) {
		this.detail = detail;
	}

	public Integer getBbb() {
		return bbb;
	}

	public void setBbb(Integer bbb) {
		this.bbb = bbb;
	}
	
}

