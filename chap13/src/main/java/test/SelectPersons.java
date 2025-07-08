package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectPersons {

	public static void main(String[] args) {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		try (Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/example", "sa", "")) {
			String sql = "SELECT id, name, state FROM persons";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String state = rs.getString("state");
				
				System.out.println("ID:" + id);
				System.out.println("名前:" + name);
				System.out.println("出身地:" + state + "\n");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
