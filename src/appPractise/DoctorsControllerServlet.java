package appPractise;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.sun.xml.internal.ws.resources.HttpserverMessages;


@WebServlet("/DoctorsControllerServlet")
public class DoctorsControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private doctorsDbUtil doctorsDbUtil;
	
	@Resource (name="jdbc/appPractise")
       private DataSource dataSource;


	
	
    
    

	
	@Override
	public void init() throws ServletException {
		super.init();
		try{
			doctorsDbUtil = new doctorsDbUtil(dataSource);
		}catch(Exception exc){
			throw new ServletException(exc);
			
		}
	}






	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String theCommand=request.getParameter("command");
				if(theCommand==null){
					theCommand="LIST";
				}
			switch (theCommand){
				
			case"LIST":
			listDoctors(request,response);
			break;
			
			case "ADD":
			addDoctors(request,response);
			break;
			case "NEW-VISIT":
				prepareNewVisit(request, response);
				break;
			case "ADD-VISIT":
				addVisit(request,response);
				break;
			
			case "LIST-VISITS":
				listVisit(request,response);
				break;
			
			
			
			
			default:
				listDoctors(request,response);
			}
		} catch (Exception exc) {
			
			throw new ServletException(exc);
		}
	}
	
	









	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 doGet(request, response);
 }



	private void prepareNewVisit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String doctorId =request.getParameter("doctorId");
		doctors doctor = doctorsDbUtil.getDoctor(doctorId);
		request.setAttribute("doctorName", doctor.getName());
		List<Cycle> cycles = doctorsDbUtil.getCycles();
		request.setAttribute("cycles", cycles);
		forwardToJsp(request, response, "/add-visit.jsp");
	}
	
	private void addVisit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int doctorId =Integer.parseInt(request.getParameter("doctorId"));
		String DateParam = request.getParameter("date");
		 Date date= null;
		String comments=request.getParameter("comments");
		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("usersession");
		int userId= user.getId();
		String error=null;
		
		try {
			 date = convertDate(DateParam);
		} catch(Exception ex) {
			error = "Visit date has invalid format!";
			request.setAttribute("dateVisitError", error);
			
		}
		
		if(error!=null) {
			//if we have an error return to previous page, indicating the error
			prepareNewVisit(request, response);
			return;
		}
		
		int cycleId = Integer.parseInt(request.getParameter("cycle"));
		Cycle cycle = doctorsDbUtil.getCycleById(cycleId);
		
		if(cycle.getFromDate().after(date)
			|| cycle.getToDate().before(date)) {
			error = "The visit date is outside the cycle!";
			request.setAttribute("dateVisitError", error);
			prepareNewVisit(request, response);
			return;
		}
		
		//no error.... proceed in adding the visit
		try {
			
			Visits visit = new Visits(doctorId,userId,date, cycleId, comments);
			doctorsDbUtil.addVisit(visit);
			forwardToJsp(request, response, "/medvistab.jsp");
		} catch(Exception ex) {
			throw new ServletException(ex);
		}

		
		
	
		
			//listVisit(request,response);
		}
		
	

		
	






	private Date convertDate(String date) throws Exception{
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormatter.parse(date);
	}
	
	protected void forwardToJsp(HttpServletRequest request, HttpServletResponse response, String page) throws IOException, ServletException {
		getServletContext().getRequestDispatcher(page).forward(request, response);
	}







	private void listVisit(HttpServletRequest request, HttpServletResponse response) 
		throws Exception{
		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("usersession");
		int userId = user.getId();
		List<Visits> visits = doctorsDbUtil.getvisits(userId);
		request.setAttribute("VISIT_LIST", visits);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/visitInfo.jsp");
		dispatcher.forward(request, response);
		
	}




	




	private void addDoctors(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		String name =request.getParameter("name");
		String specialty =request.getParameter("specialty");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		String city =request.getParameter("city");
		String geographical_area =request.getParameter("geographical_area");
		String institution =request.getParameter("institution");
		String position =request.getParameter("position");
		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("usersession");
		String medical_visitor = user.getName();
		doctors theDoctors = new doctors(name,specialty,
				address,phone,city,geographical_area,institution,position,medical_visitor);

		boolean doctorExists = doctorsDbUtil.doctorExists(name, address, -1);
		
		if(doctorExists) {
			String errorMessage = "The doctor already exists. Choose different name/address.";
			request.setAttribute("error", errorMessage);
			//request.setAttribute("THE_DOCTORS", theDoctors);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/add-doctor-form.jsp");
			dispatcher.forward(request, response);
			
		} else {
			doctorsDbUtil.addDoctor(theDoctors);
			listDoctors(request,response);
		}
		
	}



	private void listDoctors(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		List<doctors> doctors = doctorsDbUtil.getdoctors();
		request.setAttribute("doctors_list", doctors);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/doctorsList.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
