package movie;

public class viewDTO {
	private String Aname;
	private String Mname;

	public viewDTO(String An, String Mn) {
		super();
		
		Aname = An;
		Mname = Mn;
	}
	public String getAname() {
		return Aname;
	}
	public String getMname() {
		return Mname;
	}
}
