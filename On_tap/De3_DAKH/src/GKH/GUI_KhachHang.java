package GKH;

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
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_KhachHang extends JFrame {

	private JPanel contentPane;
	private JTextField textField_STK;
	private JTextField textField_HoTen;
	private JTextField textField_DiaChi;
	private JTextField textField_SoDu;
	private JComboBox comboBox;
	private JTable table;
	final String[] header = {"Số TK", "Họ Tên", "Giới Tính", "Địa Chỉ", "Số Dư"};
	final DefaultTableModel tableModel = new DefaultTableModel(header,0);
	
	private Connection conn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_KhachHang frame = new GUI_KhachHang();
					frame.loadData();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void loadData() throws SQLException {
		XLKH xlkh = new XLKH();
		conn = xlkh.getCon();
		Statement st = conn.createStatement();
		ResultSet result = st.executeQuery("select *from tbKhachHang");
		tableModel.setRowCount(0);
		while(result.next()) {
			Vector row = new Vector();
			row.add(result.getInt("SoTK"));
			row.add(result.getString("HoTen"));
			row.add(result.getString("GT"));
			row.add(result.getString("DiaChi"));
			row.add(result.getFloat("SoDu"));
			
			tableModel.addRow(row);
			table.setModel(tableModel);
		}
		conn.close();
	}
	
	/**
	 * Create the frame.
	 */
	public GUI_KhachHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Số TK");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(71, 23, 61, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblHTn = new JLabel("Họ Tên");
		lblHTn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHTn.setBounds(71, 60, 61, 26);
		contentPane.add(lblHTn);
		
		JLabel lblSTk = new JLabel("Giới tính");
		lblSTk.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSTk.setBounds(71, 99, 61, 26);
		contentPane.add(lblSTk);
		
		JLabel lblaCh = new JLabel("Địa Chỉ");
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblaCh.setBounds(71, 135, 61, 26);
		contentPane.add(lblaCh);
		
		JLabel lblSD = new JLabel("Số Dư");
		lblSD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSD.setBounds(71, 170, 61, 26);
		contentPane.add(lblSD);
		
		textField_STK = new JTextField();
		textField_STK.setBounds(194, 29, 138, 19);
		contentPane.add(textField_STK);
		textField_STK.setColumns(10);
		
		textField_HoTen = new JTextField();
		textField_HoTen.setColumns(10);
		textField_HoTen.setBounds(194, 66, 138, 19);
		contentPane.add(textField_HoTen);
		
		textField_DiaChi = new JTextField();
		textField_DiaChi.setColumns(10);
		textField_DiaChi.setBounds(194, 141, 138, 19);
		contentPane.add(textField_DiaChi);
		
		textField_SoDu = new JTextField();
		textField_SoDu.setColumns(10);
		textField_SoDu.setBounds(194, 176, 138, 19);
		contentPane.add(textField_SoDu);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "nam", "nữ"}));
		comboBox.setBounds(194, 104, 138, 21);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() == -1) return;
				
				XLKH xlkh = new XLKH();
				try {
					xlkh.delKH((String) table.getValueAt(table.getSelectedRow(), 3), (String) table.getValueAt(table.getSelectedRow(), 2));
					loadData();
					textField_STK.setText("");
					textField_HoTen.setText("");
					comboBox.setSelectedItem("");
					textField_DiaChi.setText("");
					textField_SoDu.setText("");	
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(168, 246, 85, 21);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 287, 332, 152);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int indexRow = table.getSelectedRow();
				textField_STK.setText(String.valueOf(table.getValueAt(indexRow, 0)));
				textField_HoTen.setText((String) table.getValueAt(indexRow, 1));
				comboBox.setSelectedItem((String) table.getValueAt(indexRow, 2));
				textField_DiaChi.setText((String) table.getValueAt(indexRow, 3));
				textField_SoDu.setText(String.valueOf(table.getValueAt(indexRow, 4)));				
			}
		});
		scrollPane.setViewportView(table);
	}
}
