package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Khachhang;

public class connectionJDBCkh extends Khachhang{
	static String url = "jdbc:mysql://localhost:3306/qlkhachhang";
	static String user = "root";
	static String password = "";
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(conn != null) {
			System.out.println("kết nối mysql thành công");
		}else {
			System.out.println("kết nối mysql không thành công");
		}
		return conn;

	}
	public static List<Khachhang>FindAll(){
		List<Khachhang>khachhangList = new ArrayList<>();
		String query = "select * from Khachhang";
		try {
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				Khachhang kh = new Khachhang(rs.getInt("id"),rs.getString("MAKH"),rs.getString("TENKH"),rs.getString("DIACHI"),rs.getInt("SDT"));
				khachhangList.add(kh);
			}
		} catch (Exception ex) {
			// TODO: handle exception
		}
		return khachhangList;
	}
	public static void insert(Khachhang kh) {
		String query = "insert into Khachhang(MAKH,TENKH,DIACHI,SDT) values(?,?,?,?)";
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, kh.getMAKH());
			pstmt.setString(2, kh.getTENKH());
			pstmt.setString(3, kh.getDIACHI());
			pstmt.setInt(4, kh.getSDT());
			pstmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void Update(Khachhang kh) {
		String query = "Update Khachhang set MAKH = ?,TENKH = ?,DIACHI = ?,SDT = ? where MAKH='"+kh.getMAKH()+"'";
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, kh.getMAKH());
			pstmt.setString(2, kh.getTENKH());
			pstmt.setString(3, kh.getDIACHI());
			pstmt.setInt(4, kh.getSDT());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void delete(Khachhang kh) {
		String query ="delete From Khachhang where MAKH = '"+kh.getMAKH()+"'"	;
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
