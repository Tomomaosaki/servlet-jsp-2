package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Mutter;

public class MuttersDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/dokoTsubu";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public List<Mutter> findAll() { // 戻り値はList<Mutter>
		List<Mutter> mutterList = new ArrayList<>(); // 戻り値となる空のListを作る
		
		try {
			Class.forName("org.h2.Driver"); // ←org.h2.Driverをメモリ上に読み込む
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql =
					"""
					SELECT id,name,text FROM mutters
					ORDER BY id DESC
					""";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			ResultSet rs = pStmt.executeQuery(); // sql文（SELECT文）が実行される
			
			while(rs.next()) { // データがある間は実行する
				int id =rs.getInt("id"); // ""の中は大文字でも小文字でもいい
				String userName = rs.getString("name");
				String text = rs.getString("text");
				Mutter mutter = new Mutter(id, userName, text); // mutterインスタンスを作る
				mutterList.add(mutter); // 19行目で作ったmutterListに追加する
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
		return mutterList; // mutterListを返す
	}

	public boolean create(Mutter mutter) { // trueなら成功　falseなら失敗
		try {
			Class.forName("org.h2.Driver"); // ←org.h2.Driverをメモリ上に読み込む
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql =
					"""
					INSERT INTO mutters (name, text)
					VALUES (?, ?)
					""";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, mutter.getUserName());
			pStmt.setString(2, mutter.getText());
			
			int result = pStmt.executeUpdate(); // sql文（INSERT文）が実行される
			
			if (result != 1) {
				return false;
			}		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}		
		return true;
	}
}
