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


public class updatedoctor extends JFrame {

	dbconnection dbc = new dbconnection();
	String did;
	private JPanel contentPane;
	private JTextField txtBlood;
	private JTextField txtAge;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JTextField txtAddress;
	private JTextField txtRoom;
	private JTextField txtPass;
	private JTextField txtid;
	private JLabel txtUser;
	private JComboBox comboGender;
	private JComboBox comboMaritial;
	private JComboBox comboDepartment;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updatedoctor frame = new updatedoctor();
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
	public updatedoctor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(1250, 589));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon("Icon\\cross.png"));
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new mainpage1().setVisible(true);
			}
		});
		lblNewLabel_1.setBounds(1166, 46, 46, 43);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(new ImageIcon("Icon\\backs.png"));
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new doctorpanel().setVisible(true);
			}
		});
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.setBounds(1110, 46, 46, 43);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Update Doctor");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(new Color(0, 128, 128));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel.setBounds(0, 36, 1234, 67);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(0, 139, 139));
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(139, 198, 54, 25);
		contentPane.add(lblName);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setForeground(new Color(0, 139, 139));
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAge.setBounds(139, 247, 54, 25);
		contentPane.add(lblAge);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(new Color(0, 139, 139));
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGender.setBounds(139, 298, 64, 25);
		contentPane.add(lblGender);
		
		JLabel lblBloodGroup = new JLabel("Blood Group");
		lblBloodGroup.setForeground(new Color(0, 139, 139));
		lblBloodGroup.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBloodGroup.setBounds(139, 348, 116, 25);
		contentPane.add(lblBloodGroup);
		
		txtBlood = new JTextField();
		txtBlood.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtBlood.setBounds(279, 348, 162, 25);
		contentPane.add(txtBlood);
		txtBlood.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAge.setColumns(10);
		txtAge.setBounds(279, 247, 162, 25);
		contentPane.add(txtAge);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtName.setColumns(10);
		txtName.setBounds(279, 198, 162, 25);
		contentPane.add(txtName);
		
		comboGender = new JComboBox();
		comboGender.addItem("Male");
		comboGender.addItem("Female");
		comboGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboGender.setBounds(279, 300, 162, 25);
		contentPane.add(comboGender);
		
		JLabel txtId = new JLabel(did);
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtId.setBounds(279, 198, 162, 20);
		contentPane.add(txtId);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setForeground(new Color(0, 139, 139));
		lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDepartment.setBounds(139, 397, 116, 25);
		contentPane.add(lblDepartment);
		
		comboDepartment = new JComboBox();
		comboDepartment.addItem("Physician");
		comboDepartment.addItem("Dental");
		comboDepartment.addItem("Gynaecology");
		comboDepartment.addItem("Nutrition");
		comboDepartment.addItem("Neurology");
		comboDepartment.addItem("Cardiology");
		comboDepartment.addItem("Haematology");
		comboDepartment.addItem("Microbiology");
		comboDepartment.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboDepartment.setBounds(279, 399, 162, 25);
		contentPane.add(comboDepartment);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setForeground(new Color(0, 139, 139));
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhoneNumber.setBounds(499, 198, 145, 25);
		contentPane.add(lblPhoneNumber);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPhone.setColumns(10);
		txtPhone.setBounds(656, 196, 162, 25);
		contentPane.add(txtPhone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(0, 139, 139));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(499, 247, 116, 25);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmail.setColumns(10);
		txtEmail.setBounds(656, 245, 162, 25);
		contentPane.add(txtEmail);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(new Color(0, 139, 139));
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddress.setBounds(499, 347, 116, 25);
		contentPane.add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAddress.setColumns(10);
		txtAddress.setBounds(656, 345, 162, 25);
		contentPane.add(txtAddress);
		
		JLabel lblWardroomNo = new JLabel("Ward/Room No.");
		lblWardroomNo.setForeground(new Color(0, 139, 139));
		lblWardroomNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWardroomNo.setBounds(499, 397, 145, 25);
		contentPane.add(lblWardroomNo);
		
		txtRoom = new JTextField();
		txtRoom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtRoom.setColumns(10);
		txtRoom.setBounds(656, 395, 162, 25);
		contentPane.add(txtRoom);
		
		JLabel lblMaritialStatus = new JLabel("Maritial Status");
		lblMaritialStatus.setForeground(new Color(0, 139, 139));
		lblMaritialStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaritialStatus.setBounds(499, 294, 145, 25);
		contentPane.add(lblMaritialStatus);
		
		comboMaritial = new JComboBox();
		comboMaritial.addItem("Single");
		comboMaritial.addItem("Married");
		comboMaritial.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboMaritial.setBounds(656, 294, 162, 25);
		contentPane.add(comboMaritial);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setForeground(new Color(0, 139, 139));
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(869, 227, 101, 25);
		contentPane.add(lblUsername);
		
		txtUser = new JLabel(did);
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtUser.setBounds(994, 227, 162, 20);
		contentPane.add(txtUser);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(0, 139, 139));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(869, 276, 101, 25);
		contentPane.add(lblPassword);
		
		txtPass = new JTextField();
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPass.setColumns(10);
		txtPass.setBounds(994, 276, 138, 25);
		contentPane.add(txtPass);
		
		JLabel lblNewLabel_5 = new JLabel("Update");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				update();
			}
		});
		lblNewLabel_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setOpaque(true);
		lblNewLabel_5.setBackground(new Color(0, 128, 128));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_5.setBounds(684, 461, 116, 50);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_3 = new JLabel("Id of Doctor");
        lblNewLabel_3.setForeground(new Color(0, 139, 139));
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lblNewLabel_3.setBounds(159, 129, 187, 52);
        contentPane.add(lblNewLabel_3);
        
        txtid = new JTextField();
        txtid.setFont(new Font("Tahoma", Font.PLAIN, 28));
        txtid.setBounds(367, 137, 355, 39);
        contentPane.add(txtid);
        txtid.setColumns(10);
        
        JLabel lblDelete = new JLabel("Search");
        lblDelete.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		loadData();
        	}
        });
        lblDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblDelete.setForeground(Color.WHITE);
        lblDelete.setBackground(new Color(0, 128, 128));
        lblDelete.setOpaque(true);
        lblDelete.setHorizontalAlignment(SwingConstants.CENTER);
        lblDelete.setBounds(759, 136, 116, 39);
        contentPane.add(lblDelete);
		
	}
	private void loadData(){
		Integer count=0;
		String did=txtid.getText();
		String sql1="SELECT * FROM doctor WHERE id='"+did+"' ";
		try {
			Statement stmt=dbc.conmethod();
			ResultSet rs=stmt.executeQuery(sql1);
			while (rs.next()){
				if(rs.getString("status").equals("0")){
					txtName.setText(rs.getString("name"));
					txtAge.setText(rs.getString("age"));
					txtBlood.setText(rs.getString("blood"));
					txtPhone.setText(rs.getString("phone"));
					txtEmail.setText(rs.getString("email"));
					txtAddress.setText(rs.getString("address"));
					txtRoom.setText(rs.getString("room"));
					txtUser.setText(rs.getString("username"));
					txtPass.setText(rs.getString("password"));
					if(rs.getString("gender").equals("Male")){comboGender.setSelectedIndex(0);}
					else if(rs.getString("gender").equals("Female")){comboGender.setSelectedIndex(1);}
					if(rs.getString("maritial").equals("Single")){comboMaritial.setSelectedIndex(0);}
					else if(rs.getString("maritial").equals("Married")){comboMaritial.setSelectedIndex(1);}
					if(rs.getString("dept").equals("Physician")){comboDepartment.setSelectedIndex(0);}
					else if(rs.getString("dept").equals("Dental")){comboDepartment.setSelectedIndex(1);}
					else if(rs.getString("dept").equals("Gynaecology")){comboDepartment.setSelectedIndex(2);}
					else if(rs.getString("dept").equals("Nutrition")){comboDepartment.setSelectedIndex(2);}
					else if(rs.getString("dept").equals("Neurology")){comboDepartment.setSelectedIndex(3);}
					else if(rs.getString("dept").equals("Cardiology")){comboDepartment.setSelectedIndex(4);}
					else if(rs.getString("dept").equals("Haematology")){comboDepartment.setSelectedIndex(5);}
					else if(rs.getString("dept").equals("Microbiology")){comboDepartment.setSelectedIndex(6);}
					count+=1;
				}
			}
			if(count==0){
				JOptionPane.showMessageDialog(null, "Data Not Found");
				reset();
			}
			
		}catch(Exception ex){JOptionPane.showMessageDialog(null, ex);}
	}
	private void update(){
		String id,name,age,gender,blood,dept,phone,email,maritial,address,room,password,sql;
		id=txtid.getText();
		name=txtName.getText();
		age=txtAge.getText();
 		gender=comboGender.getSelectedItem().toString();
		blood=txtBlood.getText();
 		dept=comboDepartment.getSelectedItem().toString();
		phone=txtPhone.getText();
		email=txtEmail.getText();
 		maritial=comboMaritial.getSelectedItem().toString();
		address=txtAddress.getText();
		room=txtRoom.getText();
		password=txtPass.getText();
		
		sql="UPDATE doctor SET name='"+name+"',age='"+age+"',gender='"+gender+"',blood='"+blood+"',dept='"+dept+"',phone='"+phone+"',email='"+email+"',maritial='"+maritial+"',address='"+address+"',room='"+room+"',password='"+password+"' where id='"+id+"' ";
		try {
			Statement stmt=dbc.conmethod();
			txtid.setText("");
			stmt.execute(sql);
			JOptionPane.showMessageDialog(null, "Doctor Updated");
			reset();
		}
		catch (SQLException ex){JOptionPane.showMessageDialog(null, ex);}
	}
	private void reset(){
		txtName.setText("");
		txtAge.setText("");
		txtAddress.setText("");
		txtBlood.setText("");
		txtPhone.setText("");
		txtEmail.setText("");
		txtRoom.setText("");
		txtPass.setText("");
		comboGender.setSelectedIndex(0);
		comboMaritial.setSelectedIndex(0);	
		comboDepartment.setSelectedIndex(0);	
	}

}
