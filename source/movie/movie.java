package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie.movieDAO;
import movie.movieDTO;

import movie.actorDAO;
import movie.actorDTO;

import movie.directorDAO;
import movie.directorDTO;

import movie.producerDAO;
import movie.producerDTO;

import movie.performDAO;
import movie.PerformDTO;

import movie.leadDAO;
import movie.leadDTO;

import movie.viewDAO;
import movie.viewDTO;

import java.util.ArrayList;
import java.util.List;

@WebServlet("/movie")
public class movie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String dburl = "jdbc:mysql://172.17.0.2:3306/movie";
	String dbUser = "root";
	String dbpasswd = "root";
	
    public movie() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		System.out.println("DAO add doGet() 호출");
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try(Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd)){
			System.out.println("연결 성공!!");
			
			movieDAO dao = new movieDAO();
			actorDAO dao2 = new actorDAO();
			directorDAO dao3 = new directorDAO();
			producerDAO dao4 = new producerDAO();
			performDAO dao5 = new performDAO();
			leadDAO dao6 = new leadDAO();
			viewDAO dao7 = new viewDAO();
			
			String get_number = request.getParameter("submit");
			String get_p = request.getParameter("submit");
			
			String resp = get_p.substring(get_p.length()-5, get_p.length());
			

			System.out.println(get_p);
			System.out.println(resp);
			//String Act = request.getParameter("myAct");
			//String Dir = request.getParameter("myDir");
			//String Pro = request.getParameter("myPro");
			
			/////// MOVIE
			if(resp.equals("MOVIE")) {
				System.out.println("mov");
				int mydn = Integer.parseInt(request.getParameter("mymnum"));
				movieDTO movie = null;
				
				if(get_number.equals("SELECT_MOVIE")) { // GET 명령 수행

					System.out.println("get from Movie OK");
					List<movieDTO> bkList = dao.get_movie_Lists();
					for(movieDTO bk3 : bkList) {
						out.println("<h1> Name: " + bk3.getName()+ "<br> MNum: "+bk3.getMnum()+ 
								"<br>Film Distributor: "+ bk3.getFilm() + "<br> Director num: "+ bk3.getDir_num()
								+"<br> Producer num: "+ bk3.getPro_num() +" </h1>");
					}
					
				} else if(get_number.equals("INSERT_MOVIE")) { // INSERT 명령 수행
					System.out.println("insert into Movie OK");
					String ins_myname = request.getParameter("mymname");
					String ins_myfilm = request.getParameter("myfilm");
					
					int ins_mdnum = Integer.parseInt(request.getParameter("mymdnum"));
					int ins_mpnum = Integer.parseInt(request.getParameter("mympnum"));
					//int inst_mnum = Integer.parseInt(request.getParameter("mymnum"));
					
					
					
					movie = new movieDTO(ins_myname, mydn, ins_myfilm, ins_mdnum, ins_mpnum);
					
					dao.addMovie(movie);
					
				} else if(get_number.equals("DELETE_MOVIE")) { // DELETE 수행
					System.out.println("Delete from Movie OK");
					dao.deleteMovie(mydn);
					
				} else if(get_number.equals("UPDATE_MOVIE")) {
					System.out.println("Update Movie OK");
					String ins_myname = request.getParameter("mymname");
					String ins_myfilm = request.getParameter("myfilm");
					int ins_mdnum = Integer.parseInt(request.getParameter("mymdnum"));
					int ins_mpnum = Integer.parseInt(request.getParameter("mympnum"));
					
					movie = new movieDTO(ins_myname, mydn, ins_myfilm, ins_mdnum, ins_mpnum );
					
					dao.updateMovie(movie);
				}
			}


			/////////////////////////////////

			if(resp.equals("ACTOR")) {
				System.out.println("act");
				int myda = Integer.parseInt(request.getParameter("myanum"));
				actorDTO actor = null;
				
				if(get_number.equals("SELECT_ACTOR")) { // GET 명령 수행

					System.out.println("get from actor OK");
					List<actorDTO> atList = dao2.get_actor_Lists();
					for(actorDTO bk3 : atList) {
						out.println("<h1> Name: " + bk3.getName()+ "<br> ANum: "+bk3.getAnum()+
								"<br> Also Director: "+ bk3.getDir_num()+"<br> Also Producer: "+ bk3.getPro_num() + " </h1>");
					}
					
				} else if(get_number.equals("INSERT_ACTOR")) { // INSERT 명령 수행
					System.out.println("insert into actor OK");


					
					String ins_myname = request.getParameter("myaname");
					
					int ins_dnum = 0, ins_pnum = 0;
					
					String adnum = request.getParameter("myadnum");
					if(!adnum.equals("")) {
						System.out.println("myadnum");
						ins_dnum = Integer.parseInt(request.getParameter("myadnum"));
					}
					
					String apnum = request.getParameter("myapnum");	
					if(!apnum.equals("")) {
						System.out.println("myapnum");
						ins_pnum = Integer.parseInt(request.getParameter("myapnum"));
					}

					System.out.println(ins_dnum);
					System.out.println(ins_pnum);
					actor = new actorDTO(ins_myname, myda, ins_dnum, ins_pnum);
					
					dao2.addActor(actor);
					
					String per = request.getParameter("performs");
					String lea = request.getParameter("lead_role");
					
					int dnn = Integer.parseInt(request.getParameter("mydnn"));

					PerformDTO perform = null;
					leadDTO lead = null;

					System.out.println(per);
					System.out.println(lea);
					if(per!=null) {
						System.out.println("pergogo");
						perform = new PerformDTO(myda, dnn);
						dao5.addPerform(perform);
					}
					if(lea!=null) {
						System.out.println("leagogo");
						lead = new leadDTO(myda, dnn);
                        
						dao6.addLead(lead);
					}
					
				} else if(get_number.equals("DELETE_ACTOR")) { // DELETE 수행
					System.out.println("Delete from Movie OK");
					dao5.deletePerform(myda);
					dao6.deleteLead(myda);

					dao2.deleteActor(myda);
					
				} else if(get_number.equals("UPDATE_ACTOR")) {

					System.out.println("Update Actor OK");
					String ins_myname = request.getParameter("myaname");
					
					int ins_dnum = 0, ins_pnum = 0;
					
					String adnum = request.getParameter("myadnum");
					if(!adnum.equals("")) {
						System.out.println("myadnum");
						ins_dnum = Integer.parseInt(request.getParameter("myadnum"));
					}
					
					String apnum = request.getParameter("myapnum");	
					if(!apnum.equals("")) {
						System.out.println("myapnum");
						ins_pnum = Integer.parseInt(request.getParameter("myapnum"));
					}

					System.out.println(ins_dnum);
					System.out.println(ins_pnum);
					actor = new actorDTO(ins_myname, myda, ins_dnum, ins_pnum);
					
					dao2.updateActor(actor);
                    
                    String per = request.getParameter("performs");
					String lea = request.getParameter("lead_role");
					
					int dnn = Integer.parseInt(request.getParameter("mydnn"));
					int unn = Integer.parseInt(request.getParameter("myunn"));

					PerformDTO perform = null;
					leadDTO lead = null;
					
					if(per!=null) {
						perform = new PerformDTO(myda, dnn);
						dao5.updatePerform(perform, unn);
					}
					if(lea!=null) {
						lead = new leadDTO(myda, dnn);
						dao6.updateLead(lead, unn);
					}

					
				}

			}
			//////////////////////////////////////////
			if(resp.equals("ECTOR")) {
				System.out.println("dir");
				
				int mydd = Integer.parseInt(request.getParameter("mydnum"));
				directorDTO director = null;
				
				if(get_number.equals("SELECT_DIRECTOR")) { // GET 명령 수행

					System.out.println("get from director OK");
					List<directorDTO> atList = dao3.get_director_Lists();
					for(directorDTO bk3 : atList) {
						out.println("<h1> Name: " + bk3.getName()+ "<br> DNum: "+bk3.getDnum() + " </h1>");
					}
					
				} else if(get_number.equals("INSERT_DIRECTOR")) { // INSERT 명령 수행

					System.out.println("insert into director OK");
					String ins_myname = request.getParameter("mydname");
					
					director = new directorDTO(ins_myname, mydd);
					
					dao3.addDirector(director);
					
				}  else if(get_number.equals("DELETE_DIRECTOR")) { // DELETE 수행
					System.out.println("Delete from director OK");
					dao3.deleteDirector(mydd);
					
				} else if(get_number.equals("UPDATE_DIRECTOR")) {
					System.out.println("Update director OK");
					String ins_myname = request.getParameter("mydname");
					
					director = new directorDTO(ins_myname, mydd);
					
					dao3.updateDirector(director);
				}
			}
				

				////////////////////////////////////////////////////////////////

			if(resp.equals("DUCER")) {
				System.out.println("pno");
				int mydp = Integer.parseInt(request.getParameter("mypnum"));
				producerDTO producer = null;
				
				if(get_number.equals("SELECT_PRODUCER")) { // GET 명령 수행

					System.out.println("get from producer OK");
					List<producerDTO> atList = dao4.get_producer_Lists();
					for(producerDTO bk3 : atList) {
						out.println("<h1> Name: " + bk3.getName()+ "<br> PNum: "+bk3.getPnum() + " </h1>");
					}
					
				} else if(get_number.equals("INSERT_PRODUCER")) { // INSERT 명령 수행
					System.out.println("insert into producer OK");
					String ins_myname = request.getParameter("mypname");
					
					producer = new producerDTO(ins_myname, mydp);
					// INSERT할 DEPARTMENT 만들고
					
					dao4.addProducer(producer);
					
				}    else if(get_number.equals("DELETE_PRODUCER")) { // DELETE 수행
					System.out.println("Delete from producer OK");
					dao4.deleteProducer(mydp);
					
				} else if(get_number.equals("UPDATE_PRODUCER")) {
					System.out.println("Update producer OK");
					String ins_myname = request.getParameter("mypname");
					
					producer = new producerDTO(ins_myname, mydp);
					
					dao4.updateProducer(producer);
				}
			}
				////////////////////////////////
			if(resp.equals("_VIEW")) {

                List<viewDTO> atList = dao7.get_view_Lists();
				for(viewDTO bk3 : atList) {
					out.println("<h1> Name: " + bk3.getAname()+ "<br> PNum: "+bk3.getMname() + " </h1>");
				}
            }

		} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	out.close();
		
	}
    
}
