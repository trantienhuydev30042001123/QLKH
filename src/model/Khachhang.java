package model;

public class Khachhang {
	private int id;
	private String MAKH;
	private String TENKH;
	private String DIACHI;
	private int SDT;
	public Khachhang() {
	}
	public Khachhang(int id, String mAKH, String tENKH, String dIACHI, int sDT) {
		this.id = id;
		MAKH = mAKH;
		TENKH = tENKH;
		DIACHI = dIACHI;
		SDT = sDT;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMAKH() {
		return MAKH;
	}
	public void setMAKH(String mAKH) {
		MAKH = mAKH;
	}
	public String getTENKH() {
		return TENKH;
	}
	public void setTENKH(String tENKH) {
		TENKH = tENKH;
	}
	public String getDIACHI() {
		return DIACHI;
	}
	public void setDIACHI(String dIACHI) {
		DIACHI = dIACHI;
	}
	public int getSDT() {
		return SDT;
	}
	public void setSDT(int sDT) {
		SDT = sDT;
	}
	

}
