package GLuong;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class GUI_updateNV extends JFrame {

	private JPanel contentPane;
	private JTextField textField_MaNV;
	private JTextField textField_HoTen;
	private JTextField textField_Luong;
	private JComboBox comboBox_DiaChi;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_updateNV frame = new GUI_updateNV();
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
	public GUI_updateNV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 221);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã NV");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(48, 10, 69, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblHTn = new JLabel("Họ Tên");
		lblHTn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHTn.setBounds(48, 45, 69, 25);
		contentPane.add(lblHTn);
		
		JLabel lblLng = new JLabel("Lương");
		lblLng.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLng.setBounds(48, 80, 69, 25);
		contentPane.add(lblLng);
		
		JLabel lblaCh = new JLabel("Địa chỉ");
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblaCh.setBounds(48, 125, 69, 25);
		contentPane.add(lblaCh);
		
		comboBox_DiaChi = new JComboBox();
		comboBox_DiaChi.setModel(new DefaultComboBoxModel(new String[] {"", "Hải Phòng", "Hà Nội", "Nam Định"}));
		comboBox_DiaChi.setBounds(155, 129, 143, 21);
		contentPane.add(comboBox_DiaChi);
		
		textField_MaNV = new JTextField();
		textField_MaNV.setBounds(155, 16, 143, 19);
		contentPane.add(textField_MaNV);
		textField_MaNV.setColumns(10);
		
		textField_HoTen = new JTextField();
		textField_HoTen.setColumns(10);
		textField_HoTen.setBounds(155, 50, 143, 19);
		contentPane.add(textField_HoTen);
		
		textField_Luong = new JTextField();
		textField_Luong.setColumns(10);
		textField_Luong.setBounds(155, 85, 143, 19);
		contentPane.add(textField_Luong);
		
		JButton btnNewButton = new JButton("Tìm kiếm nhân viên");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XLLuong nv = new XLLuong();
				try {
					Vector<Nhanvien> V= nv.getNVbyMa(Integer.parseInt(textField_MaNV.getText()));
					if(V.size() == 0) return;
					textField_HoTen.setText(V.get(0).getHoten());
					textField_Luong.setText(String.valueOf(V.get(0).getLuong()));
					comboBox_DiaChi.setSelectedItem(V.get(0).getDiachi());
				} catch (NumberFormatException|SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(351, 47, 194, 21);
		contentPane.add(btnNewButton);
		
		JButton btnTmKimNhn = new JButton("Cập nhật nhân viên");
		btnTmKimNhn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XLLuong nv = new XLLuong();
				try {
					nv.updateNV(Integer.parseInt(textField_MaNV.getText()), textField_HoTen.getText(), comboBox_DiaChi.getSelectedItem().toString(), Float.parseFloat(textField_Luong.getText()));
				} catch (NumberFormatException|SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnTmKimNhn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTmKimNhn.setBounds(351, 99, 194, 21);
		contentPane.add(btnTmKimNhn);
	}
}
