package appPractise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class UsersDbUtil {
	private static DataSource dataSource;

	public UsersDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}

	public List<Users> getUsers() throws Exception {

		List<Users> Users = new ArrayList<>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			// get a connection
			myConn = dataSource.getConnection();
			// create sql statement
			String sql = "select * from mis.Users order by USER_ID";

			myStmt = myConn.createStatement();
			// execute query
			myRs = myStmt.executeQuery(sql);
			// process result set
			while (myRs.next()) {
				// retrieve data from result set row
				int id = myRs.getInt("USER_ID");
				String user_type = myRs.getString("USER_TYPE");
				String name = myRs.getString("NAME");
				String userName = myRs.getString("USERNAME");
				String passWord = myRs.getString("PASSWORD");
				// create new Users object
				Users tempUsers = new Users(id, user_type, name, userName, passWord);
				// add it to the list of students
				Users.add(tempUsers);
			}
			return Users;

		} finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);

		}
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			if (myStmt != null) {
				myConn.close();
			}
			if (myConn != null) {
				myConn.close();
			}
		} catch (Exception exc) {

			exc.printStackTrace();

		}

	}

	public Users checkUser(String username, String password) throws Exception {
	

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		try {
			// get db connection
			myConn = dataSource.getConnection();
			// set the param values for the city
			PreparedStatement ps = myConn.prepareStatement("select * from mis.users where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			myRs = ps.executeQuery();
			Users tempUsers = null;
			if (myRs.next()) {
				// retrieve data from result set row
				int id = myRs.getInt("USER_ID");
				String user_type = myRs.getString("USER_TYPE");
				String name = myRs.getString("NAME");
				String userName = myRs.getString("USERNAME");
				String passWord = myRs.getString("PASSWORD");
				// create new Users object
				 tempUsers = new Users(id, user_type, name, userName, passWord);
				
				
			}
			return tempUsers;

		}  finally {

			close(myConn, myStmt, myRs);
		}
	}
	public boolean idUser(String visitor) throws Exception {
		boolean st = false;

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();

			// set the param values for the city
			PreparedStatement ps = myConn.prepareStatement("select * from mis.users.USER_TYPE where  visitor=? ");
			//ps.setString(1, admin);
			ps.setString(1, visitor);
			ResultSet rs = ps.executeQuery();
			st = rs.next();
			return st;
		} finally {

			close(myConn, myStmt, null);
		}
	}

}
