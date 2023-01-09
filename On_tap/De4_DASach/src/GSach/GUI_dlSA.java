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
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI_dlSA extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox comboBox;
	
	final String[] header = {"Mã Sách", "Tên Sách", "Năm", "Giá", "Thành Tiền"};
	final DefaultTableModel tableModel = new DefaultTableModel(header, 0);
	
	private Connection conn = null;
	private JTextField textField_MaS;
	private JTextField textField_TenS;
	private JTextField textField_GiaB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_dlSA frame = new GUI_dlSA();
					frame.loadData();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void loadData() throws SQLException {
		XLSach xlsach = new XLSach();
		tableModel.setRowCount(0);
		for(int i=0; i< xlsach.getSA().size(); i++) {
			Vector row = new Vector();
			row.add(xlsach.getSA().get(i).getMaS());
			row.add(xlsach.getSA().get(i).getTenS());
			row.add(xlsach.getSA().get(i).getNamXB());
			row.add(xlsach.getSA().get(i).getGiaB());
			row.add(xlsach.getSA().get(i).ThanhTien());
			
			tableModel.addRow(row);
			table.setModel(tableModel);
		}
	}
	/**
	 * Create the frame.
	 */
	public GUI_dlSA() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "2019", "2020", "2021"}));
		comboBox.setBounds(190, 108, 126, 21);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Năm XB");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(61, 110, 66, 13);
		contentPane.add(lblNewLabel);
		
		JButton btn_xoa = new JButton("Delete");
		btn_xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().toString() != "") {
					int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa đầu sách này không", "Xác nhận", JOptionPane.YES_NO_OPTION);
					if(result == JOptionPane.YES_OPTION){
	                    XLSach xlsach = new XLSach();
	                    try {
							xlsach.deleteSA(Integer.parseInt(comboBox.getSelectedItem().toString()));
							loadData();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
	                }
				}
			}
		});
		btn_xoa.setBounds(417, 72, 85, 21);
		contentPane.add(btn_xoa);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 211, 482, 131);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int indexRow = table.getSelectedRow();
				textField_MaS.setText(String.valueOf(table.getValueAt(indexRow, 0)));
				textField_TenS.setText(String.valueOf(table.getValueAt(indexRow, 1)));
				comboBox.setSelectedItem(String.valueOf(table.getValueAt(indexRow, 2)));
				textField_GiaB.setText(String.valueOf(table.getValueAt(indexRow, 3)));
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btn_Them = new JButton("Thêm");
		btn_Them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XLSach xlsach = new XLSach();
				try {
					xlsach.insertSA(Integer.parseInt(textField_MaS.getText()), textField_TenS.getText(), Integer.parseInt(comboBox.getSelectedItem().toString()), Float.parseFloat(textField_GiaB.getText()));
					loadData();
				} catch (NumberFormatException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btn_Them.setBounds(417, 29, 85, 21);
		contentPane.add(btn_Them);
		
		JButton btn_sua = new JButton("sửa");
		btn_sua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XLSach xlsach = new XLSach();
				try {
					int MaS_old = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
					xlsach.updateSA(MaS_old,Integer.parseInt(textField_MaS.getText()), textField_TenS.getText(), Integer.parseInt(comboBox.getSelectedItem().toString()), Float.parseFloat(textField_GiaB.getText()));
					loadData();
				} catch (NumberFormatException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btn_sua.setBounds(417, 108, 85, 21);
		contentPane.add(btn_sua);
		
		JButton btn_tim = new JButton("tìm kiếm");
		btn_tim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XLSach xlsach = new XLSach();
				try {
					tableModel.setRowCount(0);
					Vector<Sach> V = xlsach.getTimKiem( Integer.parseInt(textField_MaS.getText()) , Integer.parseInt(comboBox.getSelectedItem().toString()));
					for(int i=0; i< V.size(); i++) {
						Vector row = new Vector();
						row.add(V.get(i).getMaS());
						row.add(V.get(i).getTenS());
						row.add(V.get(i).getNamXB());
						row.add(V.get(i).getGiaB());
						row.add(V.get(i).ThanhTien());
						
						tableModel.addRow(row);
						table.setModel(tableModel);
					}
				} catch (NumberFormatException|SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btn_tim.setBounds(417, 147, 85, 21);
		contentPane.add(btn_tim);
		
		JLabel lblMSch = new JLabel("Mã Sách");
		lblMSch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMSch.setBounds(61, 31, 66, 13);
		contentPane.add(lblMSch);
		
		JLabel lblTnSch = new JLabel("Tên Sách");
		lblTnSch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTnSch.setBounds(61, 74, 66, 13);
		contentPane.add(lblTnSch);
		
		JLabel lblGiBn = new JLabel("Giá Bán");
		lblGiBn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGiBn.setBounds(61, 149, 66, 13);
		contentPane.add(lblGiBn);
		
		textField_MaS = new JTextField();
		textField_MaS.setBounds(190, 30, 126, 19);
		contentPane.add(textField_MaS);
		textField_MaS.setColumns(10);
		
		textField_TenS = new JTextField();
		textField_TenS.setColumns(10);
		textField_TenS.setBounds(190, 73, 126, 19);
		contentPane.add(textField_TenS);
		
		textField_GiaB = new JTextField();
		textField_GiaB.setColumns(10);
		textField_GiaB.setBounds(190, 148, 126, 19);
		contentPane.add(textField_GiaB);
	}
}
