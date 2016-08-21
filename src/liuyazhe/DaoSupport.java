package liuyazhe;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoSupport {
	public List<String[]> getChannalClassifyDao(String request) {
		DBTools db = new DBTools();
		String sql = "SELECT * FROM catalog WHERE SUPER_CATALOG_ID = "
				+ request;
		ResultSet rs = db.getResult(sql);
		List<String[]> list = new ArrayList();
		try {
			while (rs.next()) {
				String[] ChannelCla = new String[5];
				ChannelCla[0] = rs.getString(1);
				ChannelCla[1] = rs.getString(2);
				ChannelCla[2] = rs.getString(3);
				ChannelCla[3] = rs.getString(4);
				ChannelCla[4] = rs.getString(5);
				list.add(ChannelCla);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<String[]> getChannalDetialDao(String request) {
		DBTools db = new DBTools();
		String sql = "SELECT * FROM media_catalog WHERE MEDIA_CATALOG_ID IN (SELECT MEDIA_CATALOG_ID FROM catalog_media_relation WHERE CATALOG_ID = "
				+ request + ")";
		ResultSet rs = db.getResult(sql);

		List<String[]> list = new ArrayList();
		try {
			while (rs.next()) {
				String[] ChannelCla = new String[5];
				ChannelCla[0] = rs.getString(1);
				ChannelCla[1] = rs.getString(2);
				ChannelCla[2] = rs.getString(3);
				ChannelCla[3] = rs.getString(4);
				ChannelCla[4] = rs.getString(5);
				list.add(ChannelCla);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<String[]> getChannalResourceDao(String request) {
		DBTools db = new DBTools();
		String sql = "SELECT * FROM sub_media_source WHERE MEDIA_ID = "
				+ request;

		ResultSet rs = db.getResult(sql);

		List<String[]> list = new ArrayList();
		try {
			while (rs.next()) {
				String[] ChannelCla = new String[3];
				ChannelCla[0] = rs.getString(1);
				ChannelCla[1] = rs.getString(2);
				ChannelCla[2] = rs.getString(3);
				list.add(ChannelCla);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<String[]> getChannalAllDao(String request) {
		DBTools db = new DBTools();
		String sql = "SELECT * FROM media_catalog WHERE MEDIA_CATALOG_ID IN (SELECT MEDIA_CATALOG_ID FROM catalog_media_relation WHERE CATALOG_ID IN (SELECT CATALOG_ID FROM catalog WHERE SUPER_CATALOG_ID ="
				+ request + " ))";

		ResultSet rs = db.getResult(sql);

		List<String[]> list = new ArrayList();
		try {
			while (rs.next()) {
				String[] ChannelCla = new String[5];
				ChannelCla[0] = rs.getString(1);
				ChannelCla[1] = rs.getString(2);
				ChannelCla[2] = rs.getString(3);
				ChannelCla[3] = rs.getString(4);
				ChannelCla[4] = rs.getString(5);
				list.add(ChannelCla);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<String[]> getMediaDescDao(String request) {
		DBTools db = new DBTools();
		String sql = "SELECT * FROM media_desc WHERE MEDIA_ID = " + request;
		ResultSet rs = db.getResult(sql);
		List<String[]> list = new ArrayList();
		String[] ChannelCla = new String[11];
		try {
			while (rs.next()) {
				ChannelCla[0] = rs.getString(1);
				ChannelCla[1] = rs.getString(2);
				ChannelCla[2] = rs.getString(3);
				ChannelCla[3] = rs.getString(4);
				ChannelCla[4] = rs.getString(5);
				ChannelCla[5] = rs.getString(6);
				ChannelCla[6] = rs.getString(7);
				ChannelCla[7] = rs.getString(8);
				ChannelCla[8] = rs.getString(9);
				ChannelCla[9] = rs.getString(10);
				ChannelCla[10] = rs.getString(11);
			}
			rs.close();
			String sql1 = "SELECT AREA_NAME FROM area WHERE AREA_ID = "
					+ ChannelCla[3];
			ResultSet rs1 = db.getResult(sql1);
			while (rs1.next()) {
				ChannelCla[3] = rs1.getString("AREA_NAME");
			}
			rs1.close();
			String sql2 = "SELECT LANGUAGE_NAME FROM language WHERE LANGUAGE_ID = "
					+ ChannelCla[4];
			ResultSet rs2 = db.getResult(sql2);
			while (rs2.next()) {
				ChannelCla[4] = rs2.getString("LANGUAGE_NAME");
			}
			rs2.close();
			list.add(ChannelCla);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
