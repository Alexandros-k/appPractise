package appPractise;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import java.sql.PreparedStatement;

public class CycleDBUtil {
	private DataSource dataSource;

	public CycleDBUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	
	public void createCycle(Cycle cycle) throws Exception {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = dataSource.getConnection();
			String createCycleQuery = "INSERT INTO CYCLE (DATE_FROM, DATE_TO) VALUES (?, ?)";
			pStatement = connection.prepareStatement(createCycleQuery);
			pStatement.setDate(1, new Date(cycle.getFromDate().getTime()));
			pStatement.setDate(2, new Date(cycle.getToDate().getTime()));
			pStatement.executeUpdate();
			
		} finally {
			close(connection, pStatement, null);
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
	
	
	
}
