import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class loginservlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	   response.setCharacterEncoding("UTF-8");//设置字符编码
           response.setContentType("text/html");//设置响应类型
           
           String yonghuming=request.getParameter("yonghuming");
  		 String mima=request.getParameter("mima");
  		   if(yonghuming.equals("zhangsan") && mima.equals("123456")){
  			   request.getRequestDispatcher("/logina").forward(request, response);//转发到成功页面
            }else{
         
                response.sendRedirect("/panchangyong/zhuseHtml.html");//密码错误,重定向到失败页面
            }
  	
  			response.setContentType("text/html");
  			PrintWriter out = response.getWriter();

  			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
  			out.println("<HTML>");
  			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
  			out.println("  <BODY>");
  	      
  			out.println("  </BODY>");
  			out.println("</HTML>");
  			out.flush();
  			out.close();
}
}
