package movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import movie.movieDTO;

public class movieDAO {
	String dburl = "jdbc:mysql://172.17.0.2:3306/movie";
	String dbUser = "root";
	String dbpasswd = "root";
	
	public movieDTO getView() {
		movieDTO bk = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "SELECT * FROM MNUM";
		
		try(Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			
			try(ResultSet rs = ps.executeQuery()){
				if(rs.next()) {
					String name = rs.getString(1);
					Integer tnum = rs.getInt(2);
					String fil = rs.getString(3);
					Integer Dnum = rs.getInt(4);
					Integer Pnum = rs.getInt(5);
					
					bk = new movieDTO(name, tnum, fil, Dnum, Pnum);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bk;
	}
	
	public int addMovie(movieDTO movie) {
		int insertCount = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("연결 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "INSERT INTO MOVIE (MNAME, MNUM, FILM_DISTRIBUTOR, DIRECTOR_DNUM, PRODUCER_PNUM) VALUES (?,?,?,?,?)";
		
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			ps.setString(1,  movie.getName());
			ps.setInt(2,  movie.getMnum());
			ps.setString(3,  movie.getFilm());
			ps.setInt(4,  movie.getDir_num());
			ps.setInt(5,  movie.getPro_num());
			
			insertCount = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return insertCount;
	}
	
	public int deleteMovie(Integer MNum) {
		int deleteCount = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "DELETE FROM MOVIE WHERE MNUM = ?";
		
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1,  MNum);;
			deleteCount = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return deleteCount;
	}
	
	public int updateMovie(movieDTO movie) {
		int updateCount = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "update MOVIE set MNAME=?, FILM_DISTRIBUTOR=?, DIRECTOR_DNUM=?, PRODUCER_PNUM=? WHERE MNUM=?";
		
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)){
			
            ////// modified!!
			ps.setString(1,  movie.getName());
			ps.setString(2,  movie.getFilm());
			ps.setInt(3,  movie.getDir_num());
			ps.setInt(4,  movie.getPro_num());
			ps.setInt(5,  movie.getMnum());
			
			updateCount = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return updateCount;
	}
	
	public List<movieDTO> get_movie_Lists(){
		List<movieDTO> list = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String sql = "SELECT * FROM MOVIE";
		
		try(Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					String name = rs.getString(1);
					Integer tnum = rs.getInt(2);
					String fil = rs.getString(3);
					Integer Dnum = rs.getInt(4);
					Integer Pnum = rs.getInt(5);
					
					movieDTO bk = new movieDTO(name, tnum, fil, Dnum, Pnum);
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
