package appPractise;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/UsersControlerServlet")
public class UsersControlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsersDbUtil UsersDbUtil;

	@Resource(name = "jdbc/appPractise")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		// create our Users UsersDbUtil...and pass in the conn pool/datasource
		super.init();
		try {
			UsersDbUtil = new UsersDbUtil(dataSource);
		} catch (Exception exc) {
			throw new ServletException(exc);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
		// list the users ... in mvc fashion
		listUsers(request, response);
	}catch(Exception exc){
		throw new ServletException(exc);
	}

	}

	private void listUsers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get users from db util
		List<Users> Users = UsersDbUtil.getUsers();
		// add users to the request
		request.setAttribute("USERS_LIST",Users);
		// send to jsp page ()
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listUsers.jsp");
		dispatcher.forward(request, response);
		;
	}

}
