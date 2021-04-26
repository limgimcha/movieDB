package movie;

public class movieDTO {
	private String Mname;
	private	Integer Mnum;
	private String film;
	private Integer Dir_num;
	private Integer Pro_num;
	
	public movieDTO(String Tname, int Tnum, String fil, int Dnum, int Pnum) {
		super();
		
		Mname = Tname;
		Mnum = Tnum;
		film = fil;
		Dir_num = Dnum;
		Pro_num = Pnum;
	}
	public String getName() {
		return Mname;
	}
	public Integer getMnum() {
		return Mnum;
	}
	public String getFilm() {
		return film;
	}
	public Integer getDir_num() {
		return Dir_num;
	}
	public Integer getPro_num() {
		return Pro_num;
	}
}
