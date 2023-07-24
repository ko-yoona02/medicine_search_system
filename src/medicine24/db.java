package medicine24;

public class db {
	
	 public String jname; //약이름
	 public String main;
	 public String addi;
	 public int maina;
	 public String type1;
	 public String sef;
	 public String kname;
	    
	    public String getJname() {
	        return jname;
	    }
	    public void setJname(String jname) {
	        this.jname = jname;
	    }
	    
	    
	    public String type1() {
	        return type1;
	    }
	    public void setType1(String type1) {
	        this.type1 = type1;
	    }
	    public String sef() {
	        return sef;
	    }
	    public void setSef(String sef) {
	        this.type1 = sef;
	    }
	    public String kname() {
	        return kname;
	    }
	    public void setKname(String kname) {
	        this.kname = kname;
	    }
	    public int getMaina() {
	        return maina;
	    }
	    public void setMaina(int maina) {
	        this.maina = maina;
	        
	    }
	    public String getMain() {
	        return main;
	    }
	    public void setMain(String main) {
	        this.main = main;
	    }
	    public String getAddi() {
	        return addi;
	    }
	    public void setAddi(String addi) {
	        this.addi = addi;
	    }
	    public String getImportent() {
	        return "이름: "+jname+" 주성분: "+main+" 함량: "+maina+" 추가 성분: "+addi+" 부작용: "+sef+" 유사한 한국 의약품: "+kname;
	    }
		

}
