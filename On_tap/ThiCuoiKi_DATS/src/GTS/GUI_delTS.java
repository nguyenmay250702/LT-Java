package GTS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.nio.file.OpenOption;
import java.awt.event.ActionEvent;

public class GUI_delTS extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	final String[] header = {"Số báo danh", "Họ tên", "Giới tính", "Ngành học", "Tổng điểm", "Xét tuyển"};
	final DefaultTableModel tableModel = new DefaultTableModel(header,0);
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_delTS frame = new GUI_delTS();
					frame.loaddata();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void loaddata() throws SQLException {
		XLTS xlts = new XLTS();
		tableModel.setRowCount(0);
		for(int i=0; i< xlts.getTS().size(); i++) {
			Vector row = new Vector<>();
			row.add(xlts.getTS().get(i).getSoBD());
			row.add(xlts.getTS().get(i).getHoten());
			row.add(xlts.getTS().get(i).getGT());
			row.add(xlts.getTS().get(i).getNganhH());
			row.add(xlts.getTS().get(i).getTongD());
			row.add(xlts.getTS().get(i).Xettuyen());
			tableModel.addRow(row);
			table.setModel(tableModel);
		}
	}
	
	
	/**
	 * Create the frame.
	 */
	public GUI_delTS() {
		setTitle("NguyenThiMay_2051063448");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Kỹ thuật ô tô", "Hệ thống thông tin", "Công trình biển"}));
		comboBox.setBounds(150, 10, 136, 21);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Ngành Học");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(40, 14, 89, 21);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Xóa thí sinh");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().toString().isBlank()) return;
				int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa không", "Xác nhận", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION){
					XLTS xlts = new XLTS();
					try {
						xlts.deleteTS(comboBox.getSelectedItem().toString());
						loaddata();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(325, 10, 131, 21);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 77, 418, 176);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
