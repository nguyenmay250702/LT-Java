package QLCB;

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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiUpdateCB extends JFrame {

	private JPanel contentPane;
	private JTextField textField_SoTK;
	private JTextField textField_HoTen;
	private JTextField textField_DiaChi;
	private JTextField textField_Luong;
	private JComboBox comboBox;
	private JTable table;
	private Connection conn = null;
	
	final String [] header = {"Số TK", "Họ Tên", "Giới Tính", "Địa Chỉ", "Lương"};
	final DefaultTableModel tableModel = new DefaultTableModel(header,0);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiUpdateCB frame = new GuiUpdateCB();
					frame.loadData();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void loadData() throws SQLException {
		QLCB qlcb = new QLCB();
		conn = qlcb.getCon();
		Statement st = conn.createStatement();
		ResultSet resurt = st.executeQuery("select * from tbCanBo");
		tableModel.setRowCount(0);
		while(resurt.next()) {
			Vector row = new Vector();
			row.add(resurt.getString("SoTK"));
			row.add(resurt.getString("Hoten"));
			row.add(resurt.getString("GT"));
			row.add(resurt.getString("DiaChi"));
			row.add(resurt.getString("Luong"));
			tableModel.addRow(row);
			table.setModel(tableModel);
		}
	}

	/**
	 * Create the frame.
	 */
	public GuiUpdateCB() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Số TK");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(77, 11, 79, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblHTn = new JLabel("Họ Tên");
		lblHTn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHTn.setBounds(77, 54, 79, 20);
		contentPane.add(lblHTn);
		
		JLabel lblGiiTnh = new JLabel("Giới Tính");
		lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGiiTnh.setBounds(77, 98, 79, 20);
		contentPane.add(lblGiiTnh);
		
		JLabel lblaCh = new JLabel("Địa Chỉ");
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblaCh.setBounds(77, 141, 79, 20);
		contentPane.add(lblaCh);
		
		JLabel lblLng = new JLabel("Lương");
		lblLng.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLng.setBounds(77, 183, 79, 20);
		contentPane.add(lblLng);
		
		textField_SoTK = new JTextField();
		textField_SoTK.setBounds(225, 11, 140, 19);
		contentPane.add(textField_SoTK);
		textField_SoTK.setColumns(10);
		
		textField_HoTen = new JTextField();
		textField_HoTen.setColumns(10);
		textField_HoTen.setBounds(225, 54, 140, 19);
		contentPane.add(textField_HoTen);
		
		textField_DiaChi = new JTextField();
		textField_DiaChi.setColumns(10);
		textField_DiaChi.setBounds(225, 141, 140, 19);
		contentPane.add(textField_DiaChi);
		
		textField_Luong = new JTextField();
		textField_Luong.setColumns(10);
		textField_Luong.setBounds(225, 183, 140, 19);
		contentPane.add(textField_Luong);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "nam", "nữ"}));
		comboBox.setBounds(225, 97, 140, 21);
		contentPane.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 273, 337, 159);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int indexRow = table.getSelectedRow();
				textField_SoTK.setText(String.valueOf(table.getValueAt(indexRow, 0)));
				textField_HoTen.setText((String) table.getValueAt(indexRow, 1));
				comboBox.setSelectedItem((String) table.getValueAt(indexRow, 2));
				textField_DiaChi.setText((String) table.getValueAt(indexRow, 3));
				textField_Luong.setText(String.valueOf(table.getValueAt(indexRow, 4)));
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Sửa");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QLCB qlcb = new QLCB();
				int indexRow = table.getSelectedRow();
				if(indexRow == -1) return;
				try {
					qlcb.updateCB(Integer.parseInt(textField_SoTK.getText()), textField_HoTen.getText(), comboBox.getSelectedItem().toString(), textField_DiaChi.getText(), Float.parseFloat(textField_Luong.getText()), Integer.valueOf((String) table.getValueAt(indexRow, 0)));
					loadData();
					textField_SoTK.setText("");
					textField_HoTen.setText("");
					comboBox.setSelectedItem("");
					textField_DiaChi.setText("");
					textField_Luong.setText("");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(162, 230, 85, 21);
		contentPane.add(btnNewButton);
	}
}
