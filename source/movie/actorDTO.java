package movie;

public class actorDTO {

	private String Name;
	private	Integer Anum;
	private Integer Dir_num;
	private Integer Pro_num;
	
	public actorDTO(String Tname, int Tnum, int Dnum, int Pnum) {
		super();
		
		Name = Tname;
		Anum = Tnum;
		Dir_num = Dnum;
		Pro_num = Pnum;
	}
	public String getName() {
		return Name;
	}
	public Integer getAnum() {
		return Anum;
	}
	public Integer getDir_num() {
		return Dir_num;
	}
	public Integer getPro_num() {
		return Pro_num;
	}
}
