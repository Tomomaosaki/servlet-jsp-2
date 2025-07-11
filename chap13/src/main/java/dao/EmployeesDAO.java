package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;

public class EmployeesDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/example";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public List<Employee> findAll() {
		List<Employee> empList = new ArrayList<>();
		
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT id, name, age FROM employees";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			ResultSet rs = pStmt.executeQuery(); // executeQueryメソッドを実行
			
			// ↓イテレータ
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				Employee employee = new Employee(id, name, age);
				empList.add(employee);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
		return empList;
	}

	public List<Employee> findByAge(int _age) {
		List<Employee> empList = new ArrayList<>();
		
		try {
			Class.forName("org.h2.Driver"); // ←"org.h2.Driver"というクラスを読み込む（h2-2.3.232.jarに入っている）
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = 
					"""
					SELECT id, name, age FROM employees
					WHERE age >= ?
					""";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, _age); // ←1つめは「?の数」のこと(1はじまり)
			ResultSet rs = pStmt.executeQuery(); // executeQueryメソッドを実行
			
			// ↓イテレータ
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				Employee employee = new Employee(id, name, age);
				empList.add(employee);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
		return empList;
	}

	public List<Employee> findByName(String _name) {
		List<Employee> empList = new ArrayList<>();
		
		try {
			Class.forName("org.h2.Driver"); // ←"org.h2.Driver"というクラスを読み込む（h2-2.3.232.jarに入っている）
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = 
					"""
					SELECT id, name, age FROM employees
					WHERE name LIKE ? 
					""";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, "%" + _name + "%"); // ←1つめは「?の数」のこと(1はじまり)
			ResultSet rs = pStmt.executeQuery(); // executeQueryメソッドを実行
			
			// ↓イテレータ
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				Employee employee = new Employee(id, name, age);
				empList.add(employee);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
		return empList;
	}

	// trye---そのIDは存在していない
	// false---そのIDは存在している
	public boolean isNotExistId(String id) {		
		try {
			Class.forName("org.h2.Driver"); // ←"org.h2.Driver"というクラスを読み込む（h2-2.3.232.jarに入っている）
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT id FROM employees WHERE id = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id); // ←1つめは「?の数」のこと(1はじまり)
			ResultSet rs = pStmt.executeQuery(); // executeQueryメソッドを実行
			
			if (rs.next()) { // ←入力したidが存在していたら
				return false;
			}		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}		
		return true;
	}

	public boolean create(Employee emp) {
		try {
			Class.forName("org.h2.Driver"); // ←"org.h2.Driver"というクラスを読み込む（h2-2.3.232.jarに入っている）
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = 
					"""
					INSERT INTO employees (id, name, age)
                    VALUES (?, ?, ?); 
					""";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, emp.getId()); // ←1つめの「?」の内容(1はじまり)
			pStmt.setString(2, emp.getName());
			pStmt.setInt(3, emp.getAge());
			
			int result = pStmt.executeUpdate(); // 変更した数が返ってくる（1は成功）
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
