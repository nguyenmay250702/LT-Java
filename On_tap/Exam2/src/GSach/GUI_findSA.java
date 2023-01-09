package GSach;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_findSA extends JFrame {

	private JPanel contentPane;
	private JTextField textField_gia;
	private JComboBox comboBox_nxb;
	private JTable table;
	private XLSach XLS;
	final String header[] = {"Mã Sách","Tên Sách","Nhà Xuất Bản","Năm Xuất Bản","Giá Bán","Khuyến Mãi"};
	final DefaultTableModel TableModel = new DefaultTableModel(header,0);
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_findSA frame = new GUI_findSA();
					frame.LoadData_Jframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//đổ dữ liệu vào bảng
	public void LoadData_Jframe() throws SQLException {
		XLS = new XLSach();
		for(int i=0; i<XLS.getSA().size(); i++) {
			Vector row = new Vector();
			row.add(XLS.getSA().get(i).getMaS());
			row.add(XLS.getSA().get(i).getTenS());
			row.add(XLS.getSA().get(i).getNhaXB());
			row.add(XLS.getSA().get(i).getNamXB());
			row.add(XLS.getSA().get(i).getGiaB());
			row.add(XLS.getSA().get(i).KhuyenMai());
			TableModel.addRow(row);
			table.setModel(TableModel);
		}
	}	

	/**
	 * Create the frame.
	 */
	public GUI_findSA() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox_nxb = new JComboBox();
		comboBox_nxb.setModel(new DefaultComboBoxModel(new String[] {"Kim Đồng", "Giáo dục", "Thanh niên"}));
		comboBox_nxb.setBounds(209, 34, 139, 21);
		contentPane.add(comboBox_nxb);
		
		JLabel lblNewLabel = new JLabel("Nhà Xuất Bản");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(39, 34, 113, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblGa = new JLabel("Giá");
		lblGa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGa.setBounds(39, 77, 113, 17);
		contentPane.add(lblGa);
		
		textField_gia = new JTextField();
		textField_gia.setBounds(209, 73, 139, 29);
		contentPane.add(textField_gia);
		textField_gia.setColumns(10);
		
		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				XLS = new XLSach();
				try {
					if(textField_gia.getText().isBlank()) //nếu giá trị nhập vào là khoảng trống hoặc k nhập giá trị thì đưa ra thông báo
					{
						JOptionPane.showMessageDialog(null, "Bạn chưa nhập giá sách!!!");
						return;
					}
					TableModel.setRowCount(0);
					Vector<Sach> V =  XLS.getSAbyNXBGB(comboBox_nxb.getSelectedItem().toString(), Float.parseFloat(textField_gia.getText()));
					for(int i=0; i<V.size(); i++) {
						Vector row = new Vector();
						row.add(V.get(i).getMaS());
						row.add(V.get(i).getTenS());
						row.add(V.get(i).getNhaXB());
						row.add(V.get(i).getNamXB());
						row.add(V.get(i).getGiaB());
						row.add(XLS.getSA().get(i).KhuyenMai());
						
						TableModel.addRow(row);
						table.setModel(TableModel);
					}
				} catch (NumberFormatException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(435, 51, 113, 29);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 139, 510, 114);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
