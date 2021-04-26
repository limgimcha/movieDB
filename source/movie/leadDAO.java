package movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import movie.leadDTO;

public class leadDAO {
	private static String dburl = "jdbc:mysql://172.17.0.2:3306/movie";
	private static String dbUser = "root";
	private static String dbpasswd = "root";
	
	public int addLead(leadDTO lead) {
		int insertCount = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("연결 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "INSERT INTO LEAD_ROLE (ACTOR_ANUM, MOVIE_MNUM) VALUES (?,?)";

		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			ps.setInt(1,  lead.getAnum());
			ps.setInt(2,  lead.getMnum());
			
			insertCount = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return insertCount;
	}
	
	public int deleteLead(Integer ANum) {
		int deleteCount = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "DELETE FROM LEAD_ROLE WHERE ACTOR_ANUM = ?";
		
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1,  ANum);
			
			deleteCount = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return deleteCount;
	}
	
	public int updateLead(leadDTO lead, int mm) {
		int updateCount = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "update LEAD_ROLE set MOVIE_MNUM=? where MOVIE_MNUM=? and ACTOR_ANUM=?";

		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			ps.setInt(1,  lead.getMnum());
			ps.setInt(2,  mm);
			ps.setInt(3,  lead.getAnum());
			
			updateCount = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return updateCount;
	}
}
