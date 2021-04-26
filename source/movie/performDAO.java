package movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import movie.PerformDTO;

public class performDAO {
	String dburl = "jdbc:mysql://172.17.0.2:3306/movie";
	String dbUser = "root";
	String dbpasswd = "root";

	public int addPerform(PerformDTO perform) {
		int insertCount = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("연결 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "INSERT INTO PERFORMS_IN (ACTOR_ANUM, MOVIE_MNUM) VALUES (?,?)";
		
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			ps.setInt(1,  perform.getAnum());
			ps.setInt(2,  perform.getMnum());
			
			insertCount = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return insertCount;
	}
	

	public int deletePerform(Integer ANum) {
		int deleteCount = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "DELETE FROM PERFORMS_IN WHERE ACTOR_ANUM = ?";
		
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1,  ANum);
			
			deleteCount = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return deleteCount;
	}
	
	public int updatePerform(PerformDTO perform, int mm) {
		int updateCount = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "update PERFORMS_IN set MOVIE_MNUM=? where MOVIE_MNUM=? and ACTOR_ANUM=?";
		
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			ps.setInt(1,  perform.getMnum());
            ps.setInt(2, mm);
			ps.setInt(3,  perform.getAnum());
			
			updateCount = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return updateCount;
	}
	
}
