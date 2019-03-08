package osf.food.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "osfu";
	private static final String PASSWORD = "12345678";
	private static final String CLASS_NAME = "oracle.jdbc.OracleDriver"; // 유심칩같은거임. 내가 지금 전화할 유심이 뭔지 알려주는 단계?
	private static Connection con;

	private static boolean open() {
		try {
			Class.forName(CLASS_NAME);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static Connection getCon() { // 캡슐화라고 한다.
		if (con == null) {
			if (open()) {
				return con;
			}
		}
		return null;
	}

	public static void close() {
		if (con != null) {
			try {
				if (con.isClosed()) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		con = null; // 이전까지는 메모리 주소가 남아있어서 이렇게 하면서 전화기를 없애는 작업.
	}
}
