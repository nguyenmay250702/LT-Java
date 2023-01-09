package exam;

import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Vector;


public class Gu extends JFrame {

	private JPanel contentPane;
	private JTextField textField_width;
	private JTextField textField_length;
	private JComboBox comboBox_color;
	private JTextField textField_perimeter;
	private JTextField textField_area;
	private JLabel lblNewLabel_tostring;
	private JTable table;

	final String header[] = {"width","length","color","area","perimeter","filled"};
	final DefaultTableModel tb = new DefaultTableModel(header,0);
	Connection conn;
	Rectangle HCN;
	
	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {				
					Gu frame = new Gu();
					frame.loadData_To_JTable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//kết nối sql
	public Connection GetConnection() {
		conn = null;
		String userName = "sa";
		String pass = "250702";
		String str = "jdbc:sqlserver://MSI\\SQLEXPRESS:1433;DatabaseName=dtRectangle;encrypt=false";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(str, userName, pass);
			System.out.println("pass");
		}
		catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
			System.out.println("fail");
		};
		return conn;
	}	
	
	//tải dữ liệu lên trên Jtable
	public void loadData_To_JTable() {
		try {
			//tạo kết nối đến CSDL			
			conn = GetConnection();
			
			//tạo đối tượng statement
			Statement st = conn.createStatement();
			
			//thực thi câu lệnh truy vấn SELECT
			ResultSet rs = st.executeQuery( "select *from tbRectangle");	//trả về đối tượng ResultSet
			
			//lấy ra metadata của ResultSet (lấy ra thông tin của bảng tbStudent)
			ResultSetMetaData metadata = rs.getMetaData();
			
			//tổng số các cột của đối tượng ResultSet
			int number = metadata.getColumnCount();		
			tb.setRowCount(0);
			Vector<String> row;
			while(rs.next()) {
				row = new Vector<String>();
				for(int i=1; i<=number; i++) row.addElement(rs.getString(i));
				tb.addRow(row);
				table.setModel(tb);
			} 
			st.close();
			rs.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * Create the frame.
	 */
	public Gu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_width = new JTextField();
		textField_width.setBounds(213, 10, 141, 19);
		contentPane.add(textField_width);
		textField_width.setColumns(10);
		
		textField_length = new JTextField();
		textField_length.setColumns(10);
		textField_length.setBounds(213, 51, 141, 19);
		contentPane.add(textField_length);
		
		textField_perimeter = new JTextField();
		textField_perimeter.setEnabled(false);
		textField_perimeter.setColumns(10);
		textField_perimeter.setBounds(213, 183, 141, 19);
		contentPane.add(textField_perimeter);
		
		textField_area = new JTextField();
		textField_area.setEnabled(false);
		textField_area.setColumns(10);
		textField_area.setBounds(213, 144, 141, 19);
		contentPane.add(textField_area);
		
		comboBox_color = new JComboBox();
		comboBox_color.setModel(new DefaultComboBoxModel(new String[] {"", "Red", "gree", "blue", "yellow", "pink"}));
		comboBox_color.setBounds(213, 99, 141, 21);
		contentPane.add(comboBox_color);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conn = GetConnection();
					Statement st = conn.createStatement();
					HCN = new Rectangle(Double.parseDouble(textField_width.getText()), Double.parseDouble(textField_length.getText()), (String)comboBox_color.getSelectedItem(),((comboBox_color.getSelectedItem()=="")? false:true));
					float dientich = (float) HCN.getArea();
					float chuvi = (float) HCN.getPerimeter();
					String strInsert = "insert into tbRectangle(width,length,color,area,perimeter,filled)"
										+ "values (" + Float.parseFloat(textField_width.getText()) + ", " + Float.parseFloat(textField_length.getText()) + ", N'" + comboBox_color.getSelectedItem() + "', " + dientich + ", " + chuvi + ", " + ((comboBox_color.getSelectedItem()=="")? 0:1) + ")";
					st.executeUpdate(strInsert);
					conn.close();
					
					//tải lại dữ liệu lên Jtable
					loadData_To_JTable();
					
					lblNewLabel_tostring.setText(HCN.toString());
				} catch (Exception e1) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(169, 234, 101, 29);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 358, 358, 111);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Width");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(62, 11, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblLength = new JLabel("Length");
		lblLength.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLength.setBounds(62, 50, 76, 20);
		contentPane.add(lblLength);
		
		JLabel lblArea = new JLabel("Area");
		lblArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblArea.setBounds(62, 141, 76, 20);
		contentPane.add(lblArea);
		
		JLabel lblPerimeter = new JLabel("Perimeter");
		lblPerimeter.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPerimeter.setBounds(62, 180, 76, 20);
		contentPane.add(lblPerimeter);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblColor.setBounds(62, 97, 76, 20);
		contentPane.add(lblColor);
		
		lblNewLabel_tostring = new JLabel("Thông tin hình chữ nhật");
		lblNewLabel_tostring.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_tostring.setBounds(35, 298, 358, 29);
		contentPane.add(lblNewLabel_tostring);
	}
}
