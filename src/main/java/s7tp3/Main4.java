package s7tp3;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main4 {
	public static void main(String[] args) {

		final String driverClass = "oracle.jdbc.driver.OracleDriver";
		final String url = "jdbc:oracle:thin:@localhost:1521:xe";
		final String login = "hr";
		final String password = "hr";
		final String req = "insert into PERSONNE values (?, ?, ?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driverClass);
			con = DriverManager.getConnection(url, login, password);
			// System.out.println(con!=null);
			pstmt = con.prepareStatement(req);
			pstmt.setInt(1, 2);
			pstmt.setString(2, "N2");
			pstmt.setDate(3, new Date(System.currentTimeMillis()));
			pstmt.executeUpdate();
			// con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getErrorCode());
			e.printStackTrace();
		} finally {

			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				con.close();
				System.out.println(pstmt.isClosed());// true
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
}
