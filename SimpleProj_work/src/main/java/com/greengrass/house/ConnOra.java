package com.greengrass.house;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnOra {
	
	private Connection con = null;

	public boolean empty() {
		return false;
	}
	
	public boolean setConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:orcl", "scott", "monemyro");
			System.out.println("Connection Established: "+ con);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
	    }
	}

	public ResultSet execQuery(String l_query) {
		//���� �� ���� ����������� �����, - ����������
		if (con == null) {
			setConnect();
		}
		Statement st = null;
		//��������� ������, ������������ ResultSet
		try {
		st = con.createStatement();
		return st.executeQuery(l_query);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
	    }
		
	}
	
	
}
