package movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import movie.directorDTO;

public class directorDAO {
	private static String dburl = "jdbc:mysql://172.17.0.2:3306/movie";
	private static String dbUser = "root";
	private static String dbpasswd = "root";
	
	public directorDTO getView() {
		directorDTO bk = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "SELECT * FROM DNUM";
		
		try(Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			
			try(ResultSet rs = ps.executeQuery()){
				if(rs.next()) {
					String name = rs.getString(1);
					Integer tnum = rs.getInt(2);
					
					bk = new directorDTO(name, tnum);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bk;
	}
	
	public int addDirector(directorDTO Director) {
		int insertCount = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("연결 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "INSERT INTO DIRECTOR (DNAME, DNUM) VALUES (?,?)";
		
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			ps.setString(1,  Director.getName());
			ps.setInt(2,  Director.getDnum());
			
			insertCount = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return insertCount;
	}
	
	public int deleteDirector(Integer MNum) {
		int deleteCount = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "DELETE FROM DIRECTOR WHERE DNUM = ?";
		
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1,  MNum);;
			deleteCount = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return deleteCount;
	}
	
	public int updateDirector(directorDTO Director) {
		int updateCount = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "update DIRECTOR set dname=? where dnum=?";
		
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			ps.setString(1,  Director.getName());
			ps.setInt(2,  Director.getDnum());
			
			updateCount = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return updateCount;
	}
	
	public List<directorDTO> get_director_Lists(){
		List<directorDTO> list = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String sql = "SELECT * FROM DIRECTOR";
		
		try(Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					String name = rs.getString(1);
					Integer tnum = rs.getInt(2);
					
					directorDTO bk = new directorDTO(name, tnum);
					list.add(bk);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
		
	}

}
