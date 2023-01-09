package QLCB;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiInsertCB extends JFrame {

	private JPanel contentPane;
	private JTextField textField_SoTK;
	private JTextField textField_HoTen;
	private JTextField textField_GT;
	private JTextField textField_DiaChi;
	private JTextField textField_Luong;
	private JTable table;
	
	final String[] header = {"Số TK", "Họ Tên", "Giới Tính", "Địa chỉ", "Lương"};
	DefaultTableModel tableModel = new DefaultTableModel(header,0);
	
	private Connection conn = null;
	private QLCB qlcb;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiInsertCB frame = new GuiInsertCB();
					frame.loadData_Jtable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//tải dữ liệu lên bảng
	public void loadData_Jtable() throws SQLException {
		qlcb = new QLCB();
		conn = qlcb.getCon();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select *from tbCanBo");
		tableModel.setRowCount(0);
		while(rs.next()) {
			Vector row = new Vector();
			row.add(rs.getInt("SoTK"));
			row.add(rs.getString("Hoten"));
			row.add(rs.getString("GT"));
			row.add(rs.getString("DiaChi"));
			row.add(rs.getFloat("Luong"));
			tableModel.addRow(row);
			table.setModel(tableModel);
		}
	}

	/**
	 * Create the frame.
	 */
	public GuiInsertCB() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Số TK");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(57, 10, 80, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblHTn = new JLabel("Họ Tên");
		lblHTn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHTn.setBounds(57, 55, 80, 25);
		contentPane.add(lblHTn);
		
		JLabel lblGiiTnh = new JLabel("Giới Tính");
		lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGiiTnh.setBounds(57, 107, 80, 25);
		contentPane.add(lblGiiTnh);
		
		JLabel lblaCh = new JLabel("Địa Chỉ");
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblaCh.setBounds(57, 163, 80, 25);
		contentPane.add(lblaCh);
		
		JLabel lblLuong = new JLabel("Lương");
		lblLuong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLuong.setBounds(57, 210, 80, 25);
		contentPane.add(lblLuong);
		
		textField_SoTK = new JTextField();
		textField_SoTK.setBounds(196, 15, 197, 19);
		contentPane.add(textField_SoTK);
		textField_SoTK.setColumns(10);
		
		textField_HoTen = new JTextField();
		textField_HoTen.setColumns(10);
		textField_HoTen.setBounds(196, 60, 197, 19);
		contentPane.add(textField_HoTen);
		
		textField_GT = new JTextField();
		textField_GT.setColumns(10);
		textField_GT.setBounds(196, 112, 197, 19);
		contentPane.add(textField_GT);
		
		textField_DiaChi = new JTextField();
		textField_DiaChi.setColumns(10);
		textField_DiaChi.setBounds(196, 168, 197, 19);
		contentPane.add(textField_DiaChi);
		
		textField_Luong = new JTextField();
		textField_Luong.setColumns(10);
		textField_Luong.setBounds(196, 215, 197, 19);
		contentPane.add(textField_Luong);
		
		JButton Button_Them = new JButton("Thêm");
		Button_Them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector row = new Vector();
				row.add(Integer.parseInt(textField_SoTK.getText()));
				row.add(textField_HoTen.getText());
				row.add(textField_GT.getText());
				row.add(textField_DiaChi.getText());
				row.add(Float.parseFloat(textField_Luong.getText()));
				qlcb = new QLCB();
				try {
					qlcb.insertCB(row);
					loadData_Jtable();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		Button_Them.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Button_Them.setBounds(178, 279, 85, 21);
		contentPane.add(Button_Them);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 329, 341, 115);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
