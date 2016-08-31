package appPractise;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class CycleServlet
 */
@WebServlet("/createCycle")
public class CycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private CycleDBUtil cycleDBUtil;
	
	@Resource(name="jdbc/appPractise")
	private DataSource dataSource;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CycleServlet() {
        super();
    }

    
    @Override
	public void init() throws ServletException {
		super.init();
		try {
			cycleDBUtil = new CycleDBUtil(dataSource);
		}catch(Exception exc){
			throw new ServletException(exc);
		}
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fromDateParam = request.getParameter("fromDate");
		String toDateParam = request.getParameter("toDate");
		Date fromDate = null;
		Date toDate = null;
		String error = null;
		try {
			 fromDate = convertDate(fromDateParam);
		} catch(Exception ex) {
			error = "From Date has invalid format!";
			request.setAttribute("fromDateError", error);
			
		}
		
		try {
			 toDate = convertDate(toDateParam);
		} catch(Exception ex) {
			error = "To Date has invalid format!";
			request.setAttribute("toDateError", error);
			
		}
		
		if(error!=null) {
			forwardToJsp(request, response, "/newCycle.jsp");
		} else {
			try {
				Cycle cycle = new Cycle(fromDate, toDate);
				cycleDBUtil.createCycle(cycle);
				forwardToJsp(request, response, "/admin.jsp");
			} catch(Exception ex) {
				throw new ServletException(ex);
			}
		}
		
	}
	
	private Date convertDate(String date) throws Exception {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormatter.parse(date);
	}
	
	protected void forwardToJsp(HttpServletRequest request, HttpServletResponse response, String page) throws IOException, ServletException {
		getServletContext().getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
