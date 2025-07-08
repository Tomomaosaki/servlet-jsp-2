package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectEmployees {

	public static void main(String[] args) {
		try {
			Class.forName("org.h2.Driver"); // ドライバを読み込む
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした"); // ここで処理を止める
		}
		System.out.println("うまくいった");
		
		try (Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/example", "sa", "")) {
			String sql = "select id, name, age from employees";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				
				System.out.println("ID:" + id);
				System.out.println("名前:" + name);
				System.out.println("年齢:" + age + "\n");
			}
			
			System.out.println("接続成功");
		} catch (SQLException e) {
			System.out.println("データベースへのアクセスエラー");
			e.printStackTrace();
		}
	}

}
