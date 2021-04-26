package movie;

public class leadDTO {
	private Integer Act_num;
	private Integer Mov_num;
	
	public leadDTO(int Tnum, int Tmnum) {
		super();
		
		Act_num = Tnum;
		Mov_num = Tmnum;
	}
	public Integer getAnum() {
		return Act_num;
	}
	public Integer getMnum() {
		return Mov_num;
	}
}
