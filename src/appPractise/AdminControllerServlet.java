package appPractise;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;


@WebServlet("/AdminControllerServlet")
public class AdminControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminDbUtil AdminDbUtil;
    
	@Resource(name="jdbc/appPractise")
	private DataSource dataSource;

   
	
	@Override
	public void init() throws ServletException {
		super.init();
		try{
			AdminDbUtil = new AdminDbUtil(dataSource);
		}catch(Exception exc){
			throw new ServletException(exc);
			
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
			String theCommand=request.getParameter("command");
				if(theCommand==null){
					theCommand="LIST";
				}
			switch (theCommand){
				
			case"LIST":
			listdoctors(request,response);
			break;
			
			case "LOAD":
			loadoctors(request,response);
			break;
			
			case "UPDATE":
				updateDoctor(request,response);
				break;
				
			case "DELETE":
				deleteDoctor(request,response);
				break;
			
			
			
			default:
				listdoctors(request,response);
			}
		} catch (Exception exc) {
			
			throw new ServletException(exc);
		}
	}
		


	
	private void deleteDoctor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String doctorid= request.getParameter("doctorId");
		AdminDbUtil.deleteDoctor(doctorid);
		listdoctors(request,response);
		
	}

	private void updateDoctor(HttpServletRequest request, HttpServletResponse response)throws Exception {
		// read doctor info from form data
		int id =Integer.parseInt(request.getParameter("doctorId"));
		String name =request.getParameter("name");
		String specialty =request.getParameter("specialty");
		String address =request.getParameter("address");
		String phone =request.getParameter("phone");
		String city =request.getParameter("city");
		String geographical_area =request.getParameter("geographical_area");
		String institution =request.getParameter("institution");
		String position =request.getParameter("position");
		String medical_visitor = request.getParameter("medical_visitor");
		//HttpSession session = request.getSession();
		//Users user = (Users)session.getAttribute("usersession");
		//String medical_visitor = user.getName();
		//create a new student object
		doctors thedoctor = new doctors(id,name,specialty,address,phone,city,geographical_area,institution,position,medical_visitor);
		//perform update on database
		
			AdminDbUtil.updatedoctors(thedoctor);
			//send them back to the "list doctors" page
			listdoctors(request,response);
		}
	

	private void loadoctors(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//read doctor id from form data
		String thedoctorId = request.getParameter("doctorId");
		//get doctor from database (db util)
		doctors thedoctor =AdminDbUtil.getDoctor(thedoctorId);
		//place student in the request attribute
		request.setAttribute("THE_DOCTORS",thedoctor );
		// send to jsp page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/updateAdminAssignForm.jsp");
		dispatcher.forward(request, response);
		
	}

	private void listdoctors(HttpServletRequest request, HttpServletResponse response) {
		try {
			String name =request.getParameter("name");
			//String specialty =request.getParameter("specialty");
			HttpSession session = request.getSession();
			Users user = (Users)session.getAttribute("usersession");
			List<doctors> Doctors = AdminDbUtil.adminSearchDoctors(name);
			request.setAttribute("LIST_SEARCHED_DOCTORS",Doctors);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminAssignVisitor.jsp");
			dispatcher.forward(request, response);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	

	


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //response.setContentType("text/html;charset=UTF-8");
	       // PrintWriter out = response.getWriter();
	        
	       doGet(request, response);
		

} 
}

