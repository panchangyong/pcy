import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class zhuce extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	String user;
	String pass;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("未成功");
			e.printStackTrace();
		}

		try {

		  user=request.getParameter("yonghuming");
			pass=request.getParameter("mima");
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/studb","root","admin");
			System.out.println("");
			 Statement sta=(Statement) con.createStatement();
			int n=sta.executeUpdate("insert studentinfo values('"+user+"','"+pass+"')");
			System.out.println("注册成功");
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("注册未成功，已有该用户名");
			e.printStackTrace();
		}


	        }
	         
	    }
	  
	
	                
	            

