package br.com.leandroprado.examplecrud.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	public static Connection getConnection() 
	{
		try {
			String userName = "leandro";
			String password = "#P2ssw0rd#";

			String url = "jdbc:sqlserver://VM02-TFSDB;databaseName=PortalMVC";

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(url, userName, password);
			return conn;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
