package movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import movie.viewDTO;

public class viewDAO {
	String dburl = "jdbc:mysql://172.17.0.2:3306/movie";
	String dbUser = "root";
	String dbpasswd = "root";
	
	public List<viewDTO> get_view_Lists(){
		List<viewDTO> list = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String sql = "SELECT * FROM ACTOR_LEAD";
		
		try(Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					String An = rs.getString(1);
					String Mn = rs.getString(2);
					
					viewDTO bk = new viewDTO(An, Mn);
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