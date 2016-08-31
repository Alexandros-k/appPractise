 package appPractise;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;

import javax.sql.DataSource;

public class doctorsDbUtil {

	private DataSource dataSource;

	public doctorsDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}

	public List<doctors> getdoctors() throws Exception {

		List<doctors> doctors = new ArrayList<>();
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			myConn = dataSource.getConnection();
			String sql = "select * from mis.doctors order by id";
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(sql);
			while (myRs.next()) {
				int id = myRs.getInt("id");
				String name = myRs.getString("name");
				String specialty = myRs.getString("specialty");
				String address = myRs.getString("address");
				String phone = myRs.getString("phone");
				String city = myRs.getString("city");
				String geographical_area = myRs.getString("geographical_area");
				String institution = myRs.getString("institution");
				String position = myRs.getString("position");
				String medical_visitor = myRs.getString("medical_visitor");
				doctors tempDoctors = new doctors(id, name, specialty, address,phone,  city, geographical_area,
						institution, position,medical_visitor);
				doctors.add(tempDoctors);
			}
			return doctors;
		} finally {
			close(myConn, myStmt, myRs);
		}
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myConn != null) {
				myConn.close();
			}
			if (myStmt != null) {
				myStmt.close();
			}
			if (myRs != null) {
				myRs.close();
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

	public void addDoctor(doctors theDoctors) throws Exception {
		 Connection myConn=null;
		 PreparedStatement myStmt =null;
		 try{
		 myConn=dataSource.getConnection();
		 String sql ="insert into doctors"
				 +"(name,specialty,address,phone,city,geographical_area,institution,position,medical_visitor)"
						+"values(?,?,?,?,?,?,?,?,?)";
						myStmt=myConn.prepareStatement(sql);
						myStmt.setString(1,theDoctors.getName());
						myStmt.setString(2,theDoctors.getSpecialty());
						myStmt.setString(3,theDoctors.getAddress());
						myStmt.setString(4,theDoctors.getPhone());
						myStmt.setString(5,theDoctors.getCity());
						myStmt.setString(6,theDoctors.getGeographical_area());
						myStmt.setString(7,theDoctors.getInstitution());
						myStmt.setString(8,theDoctors.getPosition());
						myStmt.setString(9,theDoctors.getMedical_visitor());
						
		 myStmt.execute();
	}finally {
		close(myConn, myStmt, null);
	}
	}
	
	public List<doctors> searchdoctors(String vis, String name) throws Exception {

		List<doctors> Doctors = new ArrayList<doctors>();
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		try {
			myConn = dataSource.getConnection();
			
			PreparedStatement ps = myConn.prepareStatement(
					"SELECT id,name,specialty,address,phone,city,geographical_area,institution,position,medical_visitor FROM doctors "
					+ "WHERE medical_visitor = ? "
					+ "and lower(name) like ? ");
			
			ps.setString(1, vis);
			ps.setString(2, "%" + name + "%");
			myRs = ps.executeQuery();
			doctors sdoctors = null;
			while (myRs.next()) {
				int id = myRs.getInt("id");
				String name1 = myRs.getString("name");
				String specialty = myRs.getString("specialty");
				String address = myRs.getString("address");
				String phone = myRs.getString("phone");
				String city = myRs.getString("city");
				String geographical_area = myRs.getString("geographical_area");
				String institution = myRs.getString("institution");
				String position = myRs.getString("position");
				String medical_visitor1 = myRs.getString("medical_visitor");
				sdoctors = new doctors(id, name1, specialty, address, phone, city, geographical_area, institution,
						position, medical_visitor1);
				Doctors.add(sdoctors);
			}

			return Doctors;
		} finally {
			close(myConn, myStmt, myRs);
		}

	}

	


	public boolean doctorExists(String name, String address, int doctorIdToExclude) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = dataSource.getConnection();
			String sql= "SELECT id "
					+ "FROM doctors "
					+ "WHERE name = ? "
					+ "and address = ?";
			if(doctorIdToExclude>0) {
				sql= "SELECT id "
						+ "FROM doctors "
						+ "WHERE name = ? "
						+ "and address = ?"
						+ "and id <> ?";
			}
			PreparedStatement ps = myConn.prepareStatement(sql);
			
			ps.setString(1, name);
			ps.setString(2, address);
			if(doctorIdToExclude>0) {
				ps.setInt(3, doctorIdToExclude);
			}
			myRs = ps.executeQuery();
			if (myRs.next()) {
				return true;
			} else {
				return false;
			}
			
		} finally {
			close(myConn, myStmt, myRs);
		}

	}

	public doctors getDoctor(String thedoctorId) throws Exception {
		doctors thedoctor = null;
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int doctorId;
		try{
			doctorId=Integer.parseInt(thedoctorId);
		myConn=dataSource.getConnection();
		String sql="select* from doctors where id=?";
		myStmt=myConn.prepareStatement(sql);
		myStmt.setInt(1,doctorId);
		myRs=myStmt.executeQuery();
		if (myRs.next()) {
			int id = myRs.getInt("id");
			String name = myRs.getString("name");
			String specialty = myRs.getString("specialty");
			String address = myRs.getString("address");
			String phone = myRs.getString("phone");
			String city = myRs.getString("city");
			String geographical_area = myRs.getString("geographical_area");
			String institution = myRs.getString("institution");
			String position = myRs.getString("position");
			String medical_visitor = myRs.getString("medical_visitor");
			thedoctor = new doctors(doctorId, name, specialty, address, phone, city, geographical_area, institution,
					position, medical_visitor);
		}
		else{
			throw new Exception("Could not fint doctor id:"+doctorId);
		}
		
		
		return thedoctor;
		}
		finally{
			close(myConn, myStmt, myRs);
	}
}

	public void updatedoctors(doctors thedoctor) throws Exception {
	Connection myConn = null;
	PreparedStatement myStmt = null;
	try{
	//get db connection
	myConn=dataSource.getConnection();
	//create SQL update statement
	String sql = "UPDATE doctors "
			+"SET name=?, "
			+ "specialty=?, "
			+ "address=?, "
			+ "phone=?, "
			+ "city=?, "
			+ "geographical_area=?, "
			+ "institution=?, "
			+ "position=?, "
			+ "medical_visitor=? "
			+"WHERE id=?";
	
	//prepare statement
	myStmt = myConn.prepareStatement(sql);
	//set params
	myStmt.setString(1,thedoctor.getName());
	myStmt.setString(2,thedoctor.getSpecialty());
	myStmt.setString(3,thedoctor.getAddress());
	myStmt.setString(4,thedoctor.getPhone());
	myStmt.setString(5,thedoctor.getCity());
	myStmt.setString(6,thedoctor.getGeographical_area());
	myStmt.setString(7,thedoctor.getInstitution());
	myStmt.setString(8,thedoctor.getPosition());
	myStmt.setString(9,thedoctor.getMedical_visitor());
	myStmt.setInt(10,thedoctor.getId());
	//execute SQL statement
		myStmt.executeUpdate();
	}
	finally{
	close(myConn,myStmt,null);
      }
	}

	public List<doctors> adminSearchDoctors(String name) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	public void addVisit(Visits visit) throws Exception {
		 Connection myConn=null;
		 PreparedStatement myStmt =null;
		 try{
		 myConn=dataSource.getConnection();
		 String sql ="insert into visits"
				 +"(Doctorid,UserId,date,comments,cycle_id)"
						+"values(?,?,?,?,?)";
						myStmt=myConn.prepareStatement(sql);
						myStmt.setInt(1,visit.getDoctorId());
						myStmt.setInt(2,visit.getUserId());
						myStmt.setDate(3,new Date(visit.getDate().getTime()));
						myStmt.setString(4,visit.getComments());
						myStmt.setInt(5, visit.getCycleId());
						
						
		 myStmt.executeUpdate();
	}finally {
		close(myConn, myStmt, null);
	}
		
	}

	public List<Visits> getvisits(int userId) throws Exception {

			List<Visits> visits = new ArrayList<>();
			Connection myConn = null;
			PreparedStatement myStmt = null;
			ResultSet myRs = null;
			try {
				myConn = dataSource.getConnection();
				String sql = "select * from mis.visits where userid=?";
				myStmt = myConn.prepareStatement(sql);
				myStmt.setInt(1, userId);
				myRs = myStmt.executeQuery();
				while (myRs.next()) {
					int id = myRs.getInt("id");
					int doctorId = myRs.getInt("doctorId");
					userId = myRs.getInt("UserId");
					Date date = myRs.getDate("date");
					String comments = myRs.getString("comments");
					int cycleId = myRs.getInt("cycle_id");
					
					Visits tempVisits = new Visits(id, doctorId, userId, date, cycleId, comments);
					visits.add(tempVisits);
				}
				return visits;
			} finally {
				close(myConn, myStmt, myRs);
			}

	}
	
	public List<Cycle> getCycles() throws Exception {

		List<Cycle> cycles = new ArrayList<>();
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			myConn = dataSource.getConnection();
			String sql = "select * from mis.cycle order by cycle_id";
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(sql);
			while (myRs.next()) {
				int cycleId = myRs.getInt("cycle_id");
				Date dateFrom = myRs.getDate("date_from");
				Date dateTo = myRs.getDate("date_to");
				Cycle cycle = new Cycle(cycleId, dateFrom, dateTo);

				SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
				String cycleDescription = dateFormatter.format(dateFrom) + " - " + dateFormatter.format(dateTo);
				cycle.setCycleDescription(cycleDescription);
				cycles.add(cycle);
			}
			return cycles;
		} finally {
			close(myConn, myStmt, myRs);
		}

}
	
	
	public Cycle getCycleById(int cycleId) throws Exception {

		Cycle cycle = null;
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		try {
			myConn = dataSource.getConnection();
			String sql = "select * from mis.cycle where cycle_id=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, cycleId);
			myRs = myStmt.executeQuery();
			if (myRs.next()) {
				cycleId = myRs.getInt("cycle_id");
				Date dateFrom = myRs.getDate("date_from");
				Date dateTo = myRs.getDate("date_to");
				cycle = new Cycle(cycleId, dateFrom, dateTo);

				SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
				String cycleDescription = dateFormatter.format(dateFrom) + " - " + dateFormatter.format(dateTo);
				cycle.setCycleDescription(cycleDescription);
		
			}
			return cycle;
		} finally {
			close(myConn, myStmt, myRs);
		}

}
	
	
	
}

		
	

