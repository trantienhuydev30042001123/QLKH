package ViewQLKH;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import connection.connectionJDBCkh;
import model.Khachhang;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View extends JFrame {
	private static final Object DefaultTableModel = null;
	private JTextField txtMAKH;
	private JTextField txtTENKH;
	private JTextField txtDIACHI;
	private JTextField txtSDT;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 974, 560);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("M\u00E3 Kh\u00E1ch H\u00E0ng");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel.setBounds(40, 23, 141, 31);
		getContentPane().add(lblNewLabel);

		JLabel lblTnKhchHng = new JLabel("T\u00EAn Kh\u00E1ch H\u00E0ng");
		lblTnKhchHng.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblTnKhchHng.setBounds(40, 86, 141, 31);
		getContentPane().add(lblTnKhchHng);

		JLabel lblNewLabel_1_1 = new JLabel("\u0110\u1ECBa Ch\u1EC9");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_1_1.setBounds(483, 23, 141, 31);
		getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_1_2.setBounds(483, 86, 141, 31);
		getContentPane().add(lblNewLabel_1_2);

		txtMAKH = new JTextField();
		txtMAKH.setBounds(191, 25, 205, 31);
		getContentPane().add(txtMAKH);
		txtMAKH.setColumns(10);

		txtTENKH = new JTextField();
		txtTENKH.setColumns(10);
		txtTENKH.setBounds(191, 86, 205, 31);
		getContentPane().add(txtTENKH);

		txtDIACHI = new JTextField();
		txtDIACHI.setColumns(10);
		txtDIACHI.setBounds(642, 23, 205, 31);
		getContentPane().add(txtDIACHI);

		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(642, 86, 205, 31);
		getContentPane().add(txtSDT);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 128, 950, 2);
		getContentPane().add(separator);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 140, 950, 154);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, "", null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
				},
				new String[] {
						"ID", "M\u00E3 Kh\u00E1ch Hang", "T\u00EAn Kh\u00E1ch H\u00E0ng", "\u0110\u1ECBa Ch\u1EC9", "S\u1ED1 \u0110I\u1EC7n Tho\u1EA1i"
				}
				));
		table.getColumnModel().getColumn(0).setPreferredWidth(37);
		table.getColumnModel().getColumn(1).setPreferredWidth(83);
		table.getColumnModel().getColumn(2).setPreferredWidth(117);
		table.getColumnModel().getColumn(3).setPreferredWidth(224);
		table.getColumnModel().getColumn(4).setPreferredWidth(98);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		scrollPane.setViewportView(table);
		showData(connectionJDBCkh.FindAll());

		JButton btnthem = new JButton("Th\u00EAm");
		btnthem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Khachhang kh = new Khachhang();
				kh.setMAKH(txtMAKH.getText());
				kh.setTENKH(txtTENKH.getText());
				kh.setDIACHI(txtDIACHI.getText());
				kh.setSDT(Integer.parseInt(txtSDT.getText()));
				connectionJDBCkh.insert(kh);
				JOptionPane.showMessageDialog(null, "Thêm Thành Công!");
				showData(connectionJDBCkh.FindAll());
			}
		});
		btnthem.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btnthem.setBounds(73, 395, 141, 41);
		getContentPane().add(btnthem);

		JButton btnSua = new JButton("S\u1EEDa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Khachhang kh = new Khachhang();
				kh.setMAKH(txtMAKH.getText());
				kh.setTENKH(txtTENKH.getText());
				kh.setDIACHI(txtDIACHI.getText());
				kh.setSDT(Integer.parseInt(txtSDT.getText()));
				connectionJDBCkh.Update(kh);
				JOptionPane.showConfirmDialog(null, " bạn có muốn update!");
				showData(connectionJDBCkh.FindAll());
			}
		});
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btnSua.setBounds(407, 395, 141, 41);
		getContentPane().add(btnSua);

		JButton btnXoa = new JButton("X\u00F3a");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Khachhang kh = new Khachhang();
				kh.setMAKH(txtMAKH.getText());
				connectionJDBCkh.delete(kh);
				JOptionPane.showConfirmDialog(null, " bạn có muốn delete!");
				showData(connectionJDBCkh.FindAll());
			}
		});
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btnXoa.setBounds(738, 395, 141, 41);
		getContentPane().add(btnXoa);
	}
	public void showData(List<Khachhang>Khachhanglt) {
		List<Khachhang>listKhachhang = new ArrayList<>();
		listKhachhang=Khachhanglt;
		DefaultTableModel tableModel;
		table.getModel();
		tableModel=(DefaultTableModel)table.getModel();
		tableModel.setRowCount(0);
		listKhachhang.forEach((Khachhang) -> {
			tableModel.addRow(new Object [] {
					Khachhang.getId(),Khachhang.getMAKH(),Khachhang.getTENKH(),Khachhang.getDIACHI(),Khachhang.getSDT()
			});
		});
		this.setVisible(true);

	}
}
