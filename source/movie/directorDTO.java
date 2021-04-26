package movie;

public class directorDTO {

	private String Dname;
	private	Integer Dnum;
	
	public directorDTO(String Tname, int Tnum) {
		super();
		
		Dname = Tname;
		Dnum = Tnum;
	}
	public String getName() {
		return Dname;
	}
	public Integer getDnum() {
		return Dnum;
	}
}
