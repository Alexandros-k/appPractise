package appPractise;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsersDbUtil UsersDbUtil;

	@Resource(name="jdbc/appPractise")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		// create our student cityutil...and pass in the conn pool/datasource
		super.init();
		try {
			UsersDbUtil = new UsersDbUtil(dataSource);
		} catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	 {}

	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        
	        
	        try {
	        	Users u1 =UsersDbUtil.checkUser(username,password);
				if(u1 != null)
				{
	                HttpSession session = request.getSession();
						
					session.setAttribute("usersession" , u1);
					String al = u1.getType();
					if(al.equals("visitor")){
						
					    RequestDispatcher rs = request.getRequestDispatcher("medvistab.jsp");
						rs.forward(request, response);
					} else {
						if(al.equals("admin")){
							
							RequestDispatcher rs = request.getRequestDispatcher("adminServlet");
							rs.forward(request, response);
						}
						
					}
				}
				else
				{
				   //out.println("Username or Password incorrect");
					String errorMessage = "Username or Password incorrect!";
					request.setAttribute("error", errorMessage);
				   RequestDispatcher rs = request.getRequestDispatcher("/login.jsp");
				   rs.include(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
