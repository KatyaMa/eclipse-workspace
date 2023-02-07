import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyServletDemo extends HttpServlet {
		 private String mymsg;
		 
		  public void init() throws ServletException {
		      mymsg = "Hello World!";
		   }
		 
public void doGet(HttpServletRequest request,  HttpServletResponse response)
		      throws ServletException, IOException 
		   {
		 
		      // Setting up the content type of webpage
		      response.setContentType("text/html");
		 
		      // Writing message to the web page
		      PrintWriter out = response.getWriter();
		      out.println("<h1>" + mymsg + "</h1>");
		   }
		 
		   public void destroy() {
		      /* leaving empty for now this can be
		       * used when we want to do something at the end
		       * of Servlet life cycle
		       */
		   }

		   // doPost() method used for execution of HTTP POST requests.  
		   
//		   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
//		   {
//		  	String username = request.getParameter("myname");
//		  	String password = request.getParameter("password");
//		  	PrintWriter pw = response.getWriter();
//		  	response.setContentType("text/html");
//		  	pw.print("<html><head>");
//		  	pw.print("<title> Welcome to the Web World </title>");
//		  	pw.println("<h2> username is :" + username +"</h2> \n");
//		  	pw.println("<h2> password is :" + password + "</h2> \n");
//		  	pw.println("</head></html>");
//		  }

		   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		   {
		  	String u = "haseeb";
		  	String p = "123";
		  	String username = request.getParameter("myname");
		  	String password = request.getParameter("password");
		  		
		  	if(u.equals(username) || p.equals(password))
		  	  {
		  		response.setContentType("text/html");
		  		PrintWriter pw = response.getWriter();
		  		request.setAttribute("username", username);
		  		request.setAttribute("password", password);
		  		RequestDispatcher rd = request.getRequestDispatcher("/sucess.jsp");
		  		rd.forward(request, response);
		  	  }
		  	else {
		  		request.setAttribute("username", username);
		  		request.setAttribute("password", password);
		  		RequestDispatcher rd = request.getRequestDispatcher("/fail.jsp");
		  		rd.forward(request, response);
		  	     }
		  }

}
