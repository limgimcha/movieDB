package movie;

public class producerDTO {

	private String Pname;
	private	Integer Pnum;
	
	public producerDTO(String Tname, int Tnum) {
		super();
		
		Pname = Tname;
		Pnum = Tnum;
	}
	public String getName() {
		return Pname;
	}
	public Integer getPnum() {
		return Pnum;
	}
}
