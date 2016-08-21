package util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * C3P0数据库连接池
 * 
 * @author 郑悦
 */
public class C3P0Utils {
	private static C3P0Utils dbcputils = null;
	private ComboPooledDataSource cpds = null;

	private C3P0Utils() {
		if (cpds == null) {
			cpds = new ComboPooledDataSource();
		}
		cpds.setUser(Contents.DB_UESER_NAME);
		cpds.setPassword(Contents.DB_PASSWORD);
		cpds.setJdbcUrl(Contents.DB_URL);
		try {
			cpds.setDriverClass(Contents.DB_DRIVER_CLASS);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		cpds.setInitialPoolSize(Contents.DB_INIT_POOL_SIZE);
		cpds.setMaxIdleTime(Contents.DB_IDLE_TIME);
		cpds.setMaxPoolSize(Contents.DB_MAX_POOL_SIZE);
		cpds.setMinPoolSize(Contents.DB_MIN_POOL_SIZE);
		cpds.setAcquireIncrement(Contents.ACQUIRE_INCREMENT);
	}

	public synchronized static C3P0Utils getInstance() {
		if (dbcputils == null)
			dbcputils = new C3P0Utils();
		return dbcputils;
	}

	public Connection getConnection() {
		Connection con = null;
		try {
			con = cpds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			con = C3P0Utils.getInstance().getConnection();
			con.close();
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时为:" + (end - begin) + "ms");
	}
}