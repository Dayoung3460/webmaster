package com.yedam.common;

import java.sql.*;

public class DAO {
	public Connection conn;
	public PreparedStatement pstmt;
	public ResultSet rs;
  
  public void connect() {
    try {
      Class.forName("oracle.jdbc.OracleDriver");
      conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.28:1521:xe", "java", "1234");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
  public void disconnect() {
    try {
      conn.close();
      pstmt.close();
      if (rs != null) {
        rs.close();
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    
  }
}
