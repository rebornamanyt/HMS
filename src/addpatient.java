import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JTextField;
import javax.swing.JComboBox;


public class addpatient extends JFrame {

	dbconnection dbc = new dbconnection();
	String pid,a;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtAddress;
	private JTextField txtPhone;
	private JTextField txtDisease;
	private JTextField txtRoom;
	private JLabel txtDate;
	private JLabel txtId;
	private JComboBox comboMaritial;
	private JComboBox comboGender;
	
	java.util.Date datet= Calendar.getInstance().getTime();
    DateFormat format= new SimpleDateFormat("dd/MM/yyyy");
	String today = format.format(datet);
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addpatient frame = new addpatient(null);
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
	public addpatient(String name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(1030, 589));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Auto increment id
		int count =1;
		String sql=("select * from patient");
		try {
			Statement stmt=dbc.conmethod();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				count+=1;
			}
		} catch (Exception e) { JOptionPane.showMessageDialog(null, e);}
		Integer id=1000+count;
		pid = "p"+id.toString();
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon("Icon\\cross.png"));
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new mainpage1().setVisible(true);
			}
		});
		lblNewLabel_1.setBounds(949, 46, 46, 43);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(new ImageIcon("Icon\\backs.png"));
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(name=="Beauty"){
					dispose();
					new receptionistportal().setVisible(true);
				}
				else{
					dispose();
					new patientpanel().setVisible(true);
				}
			}
		});
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.setBounds(893, 46, 46, 43);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Add Patient");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(new Color(0, 128, 128));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel.setBounds(0, 36, 1014, 67);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Date");
		lblNewLabel_3.setForeground(new Color(0, 139, 139));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(178, 157, 56, 22);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblId = new JLabel("Id");
		lblId.setForeground(new Color(0, 139, 139));
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblId.setBounds(178, 214, 56, 22);
		contentPane.add(lblId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(0, 139, 139));
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(178, 271, 56, 22);
		contentPane.add(lblName);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setForeground(new Color(0, 139, 139));
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAge.setBounds(178, 324, 56, 25);
		contentPane.add(lblAge);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(new Color(0, 139, 139));
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGender.setBounds(178, 378, 72, 25);
		contentPane.add(lblGender);
		
		JLabel lblWardroomNo = new JLabel("Ward/Room No");
		lblWardroomNo.setForeground(new Color(0, 139, 139));
		lblWardroomNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWardroomNo.setBounds(520, 378, 143, 25);
		contentPane.add(lblWardroomNo);
		
		JLabel lblDiseaseName = new JLabel("Disease Name");
		lblDiseaseName.setForeground(new Color(0, 139, 139));
		lblDiseaseName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDiseaseName.setBounds(520, 324, 131, 25);
		contentPane.add(lblDiseaseName);
		
		JLabel lblMaritialStatus = new JLabel("Maritial Status");
		lblMaritialStatus.setForeground(new Color(0, 139, 139));
		lblMaritialStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaritialStatus.setBounds(520, 271, 131, 22);
		contentPane.add(lblMaritialStatus);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setForeground(new Color(0, 139, 139));
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhoneNumber.setBounds(520, 214, 131, 22);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(new Color(0, 139, 139));
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddress.setBounds(520, 157, 105, 22);
		contentPane.add(lblAddress);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtName.setColumns(10);
		txtName.setBounds(287, 271, 153, 22);
		contentPane.add(txtName);
		
		txtAge = new JTextField();
		txtAge.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtAge.setColumns(10);
		txtAge.setBounds(287, 327, 153, 22);
		contentPane.add(txtAge);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtAddress.setColumns(10);
		txtAddress.setBounds(682, 157, 153, 22);
		contentPane.add(txtAddress);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPhone.setColumns(10);
		txtPhone.setBounds(682, 214, 153, 22);
		contentPane.add(txtPhone);
		
		txtDisease = new JTextField();
		txtDisease.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDisease.setColumns(10);
		txtDisease.setBounds(682, 327, 153, 22);
		contentPane.add(txtDisease);
		
		txtRoom = new JTextField();
		txtRoom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtRoom.setColumns(10);
		txtRoom.setBounds(682, 378, 153, 22);
		contentPane.add(txtRoom);
		
		comboMaritial = new JComboBox();
		comboMaritial.addItem("Single");
		comboMaritial.addItem("Married");
		comboMaritial.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboMaritial.setBounds(682, 274, 153, 22);
		contentPane.add(comboMaritial);
		
		comboGender = new JComboBox();
		comboGender.addItem("Male");
		comboGender.addItem("Female");
		comboGender.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboGender.setBounds(287, 378, 153, 22);
		contentPane.add(comboGender);
		
		txtId = new JLabel(pid);
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtId.setBounds(291, 214, 149, 22);
		contentPane.add(txtId);
		
		txtDate = new JLabel(today);
		txtDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDate.setBounds(291, 157, 149, 22);
		contentPane.add(txtDate);
		
		JLabel clear = new JLabel("Clear");
		clear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		clear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				reset();
			}
		});
		clear.setForeground(Color.WHITE);
		clear.setOpaque(true);
		clear.setBackground(new Color(0, 128, 128));
		clear.setFont(new Font("Tahoma", Font.BOLD, 22));
		clear.setHorizontalAlignment(SwingConstants.CENTER);
		clear.setBounds(321, 453, 105, 50);
		contentPane.add(clear);
		
		JLabel lblAdd = new JLabel("Add");
		lblAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Long phone=Long.valueOf(txtPhone.getText());
				if(phone>6000000000l&&phone<99999999999l){
					patient();
				}
				else{
					JOptionPane.showMessageDialog(null, "Enter 10 digit correct Mobile No.");
					txtPhone.requestFocus();
				}
			}
		});
		lblAdd.setOpaque(true);
		lblAdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdd.setForeground(Color.WHITE);
		lblAdd.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblAdd.setBackground(new Color(0, 128, 128));
		lblAdd.setBounds(532, 453, 105, 50);
		contentPane.add(lblAdd);
	}
	private void patient(){
		String date,id,name,age,gender,address,phone,maritial,disease,roomno,sql;
 		date=txtDate.getText();
 		id=txtId.getText();
 		name=txtName.getText();
 		age=txtAge.getText();
 		gender=comboGender.getSelectedItem().toString();
 		address=txtAddress.getText();
 		phone=txtPhone.getText();
 		maritial=comboMaritial.getSelectedItem().toString();
 		disease=txtDisease.getText();
 		roomno=txtRoom.getText();
 		
 		sql="INSERT INTO patient(date,id,name,age,gender,address,phone,maritial,disease,room,status) values(now(),'"+id+"','"+name+"','"+age+"','"+gender+"','"+address+"','"+phone+"','"+maritial+"','"+disease+"','"+roomno+"','0')";
 		if (name.equals("") || age.equals("") || address.equals("") || phone.equals("") || disease.equals("") || roomno.equals("")){
			JOptionPane.showMessageDialog(null, "Fill Requried Data");
		}else
		{
			try {
				Statement stmt=dbc.conmethod();
				stmt.execute(sql);
        		reset();
				JOptionPane.showMessageDialog(null, "New Patient Added.");
				if(name=="Beauty"){
					dispose();
					new receptionistportal().setVisible(true);
				}
				else{
					dispose();
					new patientpanel().setVisible(true);
				}
				stmt.close();
			}
			catch (SQLException e){JOptionPane.showMessageDialog(null, e); } 
			catch(java.lang.NullPointerException ex){ JOptionPane.showMessageDialog(null, ex); }
		}
	}
	private void reset(){
		txtName.setText("");
		txtAge.setText("");
		txtAddress.setText("");
		txtPhone.setText("");
		txtDisease.setText("");
		txtRoom.setText("");
		comboGender.setSelectedIndex(0);
		comboMaritial.setSelectedIndex(0);	
	}
}
