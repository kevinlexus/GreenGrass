Hello!
Say, I have two entities:
	
	@Entity
	@Table(name = "PAR")
	public class Par implements java.io.Serializable, Simple {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "ID", updatable = false, nullable = false)
		private int id; //id
	
	    @Column(name = "CD", updatable = false, nullable = false)
		private String cd; //cd 
	
	    @Column(name = "NAME", updatable = false, nullable = false)
		private String name; //Наименование 
	
	    @Column(name = "VAL_TP", updatable = false, nullable = true)
		private String tp; //тип параметра (NM, ST)
	
	    @Column(name = "DATA_TP", updatable = false, nullable = true)
		private String dataTp; //тип данного (SI, LI, ID, BL)
	    
	    public Integer getId() {
			return this.id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		
	    public String getCd() {
			return this.cd;
		}
		public void setCd(String cd) {
			this.cd = cd;
		}
		
		public String getTp() {
			return tp;
		}
		public void setTp(String tp) {
			this.tp = tp;
		}
		
		public String getDataTp() {
			return dataTp;
		}
		public void setDataTp(String dataTp) {
			this.dataTp = dataTp;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	
	}

And 

	@Entity
	@Table(name = "DW")
	public class Dw implements java.io.Serializable, Simple {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "ID", updatable = false, nullable = false)
		private int id;
		
	    @Column(name = "S1", updatable = true)
	    private String s1;
	
	    @Column(name = "NS1", updatable = true)
	    private Double n1;
	
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="FK_HFP", referencedColumnName="ID")
		private Par par; 
	
		public Dw() {
		}
	
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
	
		public String getS1() {
			return s1;
		}
		public void setS1(String s1) {
			this.s1 = s1;
		}
	
		public Double getN1() {
			return n1;
		}
	
		public void setN1(Double n1) {
			this.n1 = n1;
		}	
	
		public Par getPar() {
			return par;
		}
	
		public void setPar(Par par) {
			this.par = par;
		}
		
		
	}



I need to find the row of "dw" that matches to the par.cd="TEST1".  

I have to do it by iteration through dw: 

	for (Dw dw: dwMng.findAll()) {
		if (dw.getPar().getCd()=="TEST1") {
		 Calc.mess("Found row with par.cd:"+dw.getPar().getCd()+" value of S1="+dw.getS1);
		}
	}    		
		

But i think it is not convinient way to do it. 

How can i quickly get such row?
		
For example (without using dw.getPar() ): 

	for (Dw dw: dwMng.findAll()) {
		if (dw.getCdOfPar("Test1")=="TEST1") {
		 Calc.mess("Found row with par.cd:"+dw.getPar().getCd()+" value of S1="+dw.getS1);
		}
	}    		

Or may be exist another way to do this job?
		
