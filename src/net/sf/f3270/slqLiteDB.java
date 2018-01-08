package net.sf.f3270;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class slqLiteDB {

	private Connection connect() throws ClassNotFoundException {
		// SQLite connection string
		Class.forName("org.sqlite.JDBC");
		String url = "jdbc:sqlite:"+ Initializer.toolBaseLocation+"/toolBackEnd.sqlite";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public void insert(String query) {	
		Connection conn=null;
		PreparedStatement pstmt = null;
		try {
			conn = this.connect();
			pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
		} catch (Exception e) {
			//e.printStackTrace();		
		}
		finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void insertBulk(List<String> query) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = this.connect();
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
			for (int i = 0; i < query.size() - 1; i++) {
				stmt.addBatch(query.get(i));
			}
			stmt.executeBatch();
			conn.commit();
			conn.setAutoCommit(true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	public String select(String query, String field) throws ClassNotFoundException {
		String returnVal = null;
		Statement stmt=null;
		ResultSet rs=null;
		Connection conn=null;
		try {
			conn = this.connect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				returnVal = rs.getString(field);
				break;
			}
			return returnVal;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
		finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	public List<HashMap<String, String>> selectAsDict(String query) throws ClassNotFoundException {
		List<HashMap<String, String>> returnVal=new ArrayList<HashMap<String, String>>();
		Statement stmt=null;
		ResultSet rs=null;
		Connection conn=null;
		try {
			conn = this.connect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			List<String> fields = new ArrayList<String>();
			if(rsmd.getColumnCount()>0){
				for(int i=1;i<= rsmd.getColumnCount();i++){
					fields.add(rsmd.getColumnName(i));
				}
				while (rs.next()) {
					HashMap<String, String> tableRow=new HashMap<String, String>();
					for (String string : fields) {
						tableRow.put(string,(rs.getObject(string) != null)?rs.getObject(string).toString():null);
					}
					returnVal.add(tableRow);
				}
			}
			return returnVal;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
}
