package movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import movie.actorDTO;

public class actorDAO {

	private static String dburl = "jdbc:mysql://172.17.0.2:3306/movie";
	private static String dbUser = "root";
	private static String dbpasswd = "root";
	
	public actorDTO getView() {
		actorDTO bk = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "SELECT * FROM actor_lead";
		
		try(Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			
			try(ResultSet rs = ps.executeQuery()){
				if(rs.next()) {
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return bk;
	}
	
	public int addActor(actorDTO actor) {
		int insertCount = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("연결 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = null;
		int sw = 0;
		
		if(actor.getDir_num() == 0 && actor.getPro_num() == 0) {
			sql = "INSERT INTO ACTOR (NAME, ANUM) VALUES (?,?)";
			sw=1;
		} else if(actor.getPro_num() == 0) {
			sql = "INSERT INTO ACTOR (NAME, ANUM, DIRECTOR_DNUM) VALUES (?,?,?)";
			sw=2;
		} else if(actor.getDir_num()==0) {
			sql = "INSERT INTO ACTOR (NAME, ANUM, PRODUCER_PNUM) VALUES (?,?,?)";
			sw=3;
		} else {
			sql = "INSERT INTO ACTOR (NAME, ANUM, DIRECTOR_DNUM, PRODUCER_PNUM) VALUES (?,?,?,?)";
			sw=4;
		}
		
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)){

			ps.setString(1,  actor.getName());
			ps.setInt(2,  actor.getAnum());
			if(sw==1) {
				
			} else if(sw==2) {
				ps.setInt(3,  actor.getDir_num());
			} else if(sw==3) {
				ps.setInt(3,  actor.getPro_num());
			} else if(sw==4) {
				ps.setInt(3,  actor.getDir_num());
				ps.setInt(4,  actor.getPro_num());
			}
			
			insertCount = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return insertCount;
	}
	
	public int deleteActor(Integer MNum) {
		int deleteCount = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "DELETE FROM ACTOR WHERE ANUM = ?";
		
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1,  MNum);;
			deleteCount = ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return deleteCount;
	}
	
	public int updateActor(actorDTO actor) {
		int updateCount = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		

        
		String sql = null;
		int sw = 0;
		
		if(actor.getDir_num() == 0 && actor.getPro_num() == 0) {
			sql = "update ACTOR set NAME=? where ANUM=?";
			sw=1;
		} else if(actor.getPro_num() == 0) {
			sql = "update ACTOR set NAME=?, DIRECTOR_DNUM=? where ANUM=?";
			sw=2;
		} else if(actor.getDir_num()==0) {
			sql = "update ACTOR set NAME=?, PRODUCER_PNUM=? where ANUM=?";
			sw=3;
		} else {
			sql = "update ACTOR set NAME=?, DIRECTOR_DNUM=?, PRODCUER_PNUM=? where ANUM=?";
			sw=4;
		}

		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			ps.setString(1,  actor.getName());
			
			if(sw==1) {
			    ps.setInt(2,  actor.getAnum());
			} else if(sw==2) {
				ps.setInt(2,  actor.getDir_num());
			    ps.setInt(3,  actor.getAnum());
			} else if(sw==3) {
				ps.setInt(2,  actor.getPro_num());
			    ps.setInt(3,  actor.getAnum());
			} else if(sw==4) {
				ps.setInt(2,  actor.getDir_num());
				ps.setInt(3,  actor.getPro_num());
			    ps.setInt(4,  actor.getAnum());
			}

			updateCount = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return updateCount;
	}
	
	public List<actorDTO> get_actor_Lists(){
		List<actorDTO> list = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String sql = "SELECT * FROM ACTOR";
		
		try(Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					String name = rs.getString(1);
					Integer tnum = rs.getInt(2);
					Integer dnum = rs.getInt(3);
					Integer pnum = rs.getInt(4);
					
					actorDTO bk = new actorDTO(name, tnum, dnum, pnum);
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
