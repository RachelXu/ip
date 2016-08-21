package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DBTools {
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public DBTools() {
		this("jdbc:mysql://127.0.0.1:3306/media_management", "root", "sentry");
	}

	public DBTools(String url, String username, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// this.conn = DriverManager.getConnection(url, username, password);
			this.conn = C3P0Utils.getInstance().getConnection();
			this.st = this.conn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.conn = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.conn = null;
		}
	}

	public ResultSet getResult(String sql) {
		try {
			this.rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return this.rs;
	}

	public ResultSet getResult(String sql, List params) {
		try {
			pst = this.conn.prepareStatement(sql);

			for (int i = 0; i < params.size(); i++) {
				pst.setObject(i + 1, params.get(i).toString());
			}

			this.rs = pst.executeQuery();
			return this.rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public int executeDML(String sql) {
		try {
			return this.st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}

	public int executeDML(String sql, List params) {
		try {
			this.pst = this.conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pst.setObject(i + 1, params.get(i).toString());
			}
			return this.pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}

	public void close() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
