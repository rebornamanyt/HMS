import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class addreceptionist extends JFrame {

	dbconnection dbc = new dbconnection();
	String rid;
	private JPanel contentPane;
	private JTextField txtBlood;
	private JTextField txtAge;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JTextField txtAddress;
	private JTextField txtPass;
	private JComboBox comboGender;
	private JComboBox comboMaritial;
	
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
					addreceptionist frame = new addreceptionist();
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
	public addreceptionist() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(1250, 589));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//Auto increment id
		int count =1;
		String sql=("select * from receptionist");
		try {
			Statement stmt=dbc.conmethod();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				count+=1;
			}
		} catch (Exception e) { JOptionPane.showMessageDialog(null, e);}
		Integer id=1000+count;
		rid = "r"+id.toString();
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon("Icon\\cross.png"));
		lblNewLabel_1.setBounds(1166, 46, 46, 43);
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new mainpage1().setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(new ImageIcon("Icon\\backs.png"));
		lblNewLabel_2.setBounds(1110, 46, 46, 43);
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new receptionistpanel().setVisible(true);
			}
		});
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Add Receptionist");
		lblNewLabel.setBounds(0, 36, 1234, 67);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(new Color(0, 128, 128));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Date");
		lblNewLabel_3.setBounds(139, 148, 54, 25);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setForeground(new Color(0, 139, 139));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(139, 206, 54, 25);
		lblId.setForeground(new Color(0, 139, 139));
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(139, 267, 54, 25);
		lblName.setForeground(new Color(0, 139, 139));
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblName);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(139, 324, 54, 25);
		lblAge.setForeground(new Color(0, 139, 139));
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblAge);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(139, 383, 64, 25);
		lblGender.setForeground(new Color(0, 139, 139));
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblGender);
		
		JLabel lblBloodGroup = new JLabel("Blood Group");
		lblBloodGroup.setBounds(499, 148, 116, 25);
		lblBloodGroup.setForeground(new Color(0, 139, 139));
		lblBloodGroup.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblBloodGroup);
		
		txtBlood = new JTextField();
		txtBlood.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtBlood.setBounds(656, 149, 162, 25);
		contentPane.add(txtBlood);
		txtBlood.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAge.setColumns(10);
		txtAge.setBounds(279, 324, 162, 25);
		contentPane.add(txtAge);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtName.setColumns(10);
		txtName.setBounds(279, 267, 162, 25);
		contentPane.add(txtName);
		
		comboGender = new JComboBox();
		comboGender.addItem("Male");
		comboGender.addItem("Female");
		comboGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboGender.setBounds(279, 385, 162, 25);
		contentPane.add(comboGender);
		
		JLabel txtId = new JLabel(rid);
		txtId.setBounds(279, 206, 162, 20);
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtId);
		
		JLabel txtDate = new JLabel(today);
		txtDate.setBounds(279, 148, 162, 20);
		txtDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtDate);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(499, 206, 145, 25);
		lblPhoneNumber.setForeground(new Color(0, 139, 139));
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblPhoneNumber);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPhone.setColumns(10);
		txtPhone.setBounds(656, 204, 162, 25);
		contentPane.add(txtPhone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(499, 267, 116, 25);
		lblEmail.setForeground(new Color(0, 139, 139));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmail.setColumns(10);
		txtEmail.setBounds(656, 265, 162, 25);
		contentPane.add(txtEmail);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(499, 383, 116, 25);
		lblAddress.setForeground(new Color(0, 139, 139));
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAddress.setColumns(10);
		txtAddress.setBounds(656, 381, 162, 25);
		contentPane.add(txtAddress);
		
		JLabel lblMaritialStatus = new JLabel("Maritial Status");
		lblMaritialStatus.setBounds(499, 322, 145, 25);
		lblMaritialStatus.setForeground(new Color(0, 139, 139));
		lblMaritialStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblMaritialStatus);
		
		comboMaritial = new JComboBox();
		comboMaritial.addItem("Single");
		comboMaritial.addItem("Married");
		comboMaritial.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboMaritial.setBounds(656, 322, 162, 25);
		contentPane.add(comboMaritial);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setBounds(869, 227, 101, 25);
		lblUsername.setForeground(new Color(0, 139, 139));
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblUsername);
		
		JLabel txtUser = new JLabel(rid);
		txtUser.setBounds(994, 227, 162, 20);
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtUser);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(869, 276, 101, 25);
		lblPassword.setForeground(new Color(0, 139, 139));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblPassword);
		
		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPass.setColumns(10);
		txtPass.setBounds(994, 276, 138, 25);
		contentPane.add(txtPass);
		
		JLabel lblNewLabel_5 = new JLabel("Add");
		lblNewLabel_5.setBounds(684, 461, 116, 50);
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Long phone=Long.valueOf(txtPhone.getText());
				if(phone>6000000000l&&phone<99999999999l){
					String email=txtEmail.getText();
					if(email.contains("@")&&email.contains(".")){
						receptionist();}
					else{
						JOptionPane.showMessageDialog(null, "Enter Valid Email Address ");
						txtEmail.setText("");
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Enter 10 digit correct Mobile No.");
					txtPhone.requestFocus();
				}
			}
		});
		lblNewLabel_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setOpaque(true);
		lblNewLabel_5.setBackground(new Color(0, 128, 128));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 22));
		contentPane.add(lblNewLabel_5);
		
		JLabel lblClear = new JLabel("Clear");
		lblClear.setBounds(415, 461, 116, 50);
		lblClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				reset();
			}
		});
		lblClear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblClear.setOpaque(true);
		lblClear.setHorizontalAlignment(SwingConstants.CENTER);
		lblClear.setForeground(Color.WHITE);
		lblClear.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblClear.setBackground(new Color(0, 128, 128));
		contentPane.add(lblClear);
	}

	private void receptionist(){
		String name,age,gender,blood=null,email=null,address,phone,maritial,password,sql;
 		name=txtName.getText();
 		age=txtAge.getText();
 		blood=txtBlood.getText();
 		gender=comboGender.getSelectedItem().toString();
 		email=txtEmail.getText();
 		address=txtAddress.getText();
 		phone=txtPhone.getText();
 		maritial=comboMaritial.getSelectedItem().toString();
 		password=txtPass.getText();
 		
 		sql="INSERT INTO receptionist(date,id,name,age,gender,blood,phone,email,maritial,address,username,password,status) values(now(),'"+rid+"','"+name+"','"+age+"','"+gender+"','"+blood+"','"+phone+"','"+email+"','"+maritial+"','"+address+"','"+rid+"','"+password+"','0')";
 		if (name.equals("") || age.equals("") || address.equals("") || phone.equals("") || password.equals("")){
			JOptionPane.showMessageDialog(null, "Fill Requried Data");
		}else
		{
			try {
				Statement stmt=dbc.conmethod();
				stmt.execute(sql);
        		reset();
				JOptionPane.showMessageDialog(null, "New Receptionist Added.");
				dispose();
				new receptionistpanel().setVisible(true);
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
		txtBlood.setText("");
		txtPhone.setText("");
		txtEmail.setText("");
		txtPass.setText("");
		comboGender.setSelectedIndex(0);
		comboMaritial.setSelectedIndex(0);	
	}
}
