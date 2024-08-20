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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class updatepatient extends JFrame {

	dbconnection dbc = new dbconnection();
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtAddress;
	private JTextField txtPhone;
	private JTextField txtDisease;
	private JTextField txtid;
	private JTextField txtRoom;
	private JComboBox comboMaritial;
	private JComboBox comboGender;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updatepatient frame = new updatepatient(null);
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
	public updatepatient(String name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(1030, 589));
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
		
		JLabel lblNewLabel = new JLabel("Update Patient");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(new Color(0, 128, 128));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel.setBounds(0, 36, 1014, 67);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(0, 139, 139));
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(180, 217, 56, 22);
		contentPane.add(lblName);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setForeground(new Color(0, 139, 139));
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAge.setBounds(180, 270, 56, 25);
		contentPane.add(lblAge);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(new Color(0, 139, 139));
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGender.setBounds(180, 324, 72, 25);
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
		lblAddress.setBounds(180, 381, 105, 22);
		contentPane.add(lblAddress);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtName.setColumns(10);
		txtName.setBounds(289, 217, 153, 22);
		contentPane.add(txtName);
		
		txtAge = new JTextField();
		txtAge.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtAge.setColumns(10);
		txtAge.setBounds(289, 273, 153, 22);
		contentPane.add(txtAge);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtAddress.setColumns(10);
		txtAddress.setBounds(295, 381, 153, 22);
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
		comboGender.setBounds(289, 324, 153, 22);
		contentPane.add(comboGender);
		
		JLabel lblAdd = new JLabel("Update");
		lblAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				update();
			}
		});
		lblAdd.setOpaque(true);
		lblAdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdd.setForeground(Color.WHITE);
		lblAdd.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblAdd.setBackground(new Color(0, 128, 128));
		lblAdd.setBounds(532, 453, 105, 50);
		contentPane.add(lblAdd);
		

        
        JLabel lblNewLabel_3 = new JLabel("Id of Patient");
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
		String pid=txtid.getText();
		String sql1="SELECT * FROM patient WHERE id='"+pid+"' ";
		try {
			Statement stmt=dbc.conmethod();
			ResultSet rs=stmt.executeQuery(sql1);
			while (rs.next()){
				if(rs.getString("status").equals("0")){
					txtName.setText(rs.getString("name"));
					txtAge.setText(rs.getString("age"));
					txtAddress.setText(rs.getString("address"));
					txtPhone.setText(rs.getString("phone"));
					txtDisease.setText(rs.getString("disease"));
					txtRoom.setText(rs.getString("room"));
					if(rs.getString("gender").equals("Male")){comboGender.setSelectedIndex(0);}
					else if(rs.getString("gender").equals("Female")){comboGender.setSelectedIndex(1);}
					if(rs.getString("maritial").equals("Single")){comboMaritial.setSelectedIndex(0);}
					else if(rs.getString("maritial").equals("Married")){comboMaritial.setSelectedIndex(1);}
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
		String id,name,age,gender,address,phone,maritial,disease,room,sql;
		id=txtid.getText();
		name=txtName.getText();
		age=txtAge.getText();
 		gender=comboGender.getSelectedItem().toString();
		address=txtAddress.getText();
		phone=txtPhone.getText();
 		maritial=comboMaritial.getSelectedItem().toString();
		disease=txtDisease.getText();
		room=txtRoom.getText();
		
		sql="UPDATE patient SET name='"+name+"',age='"+age+"',gender='"+gender+"',address='"+address+"',phone='"+phone+"',maritial='"+maritial+"',disease='"+disease+"',room='"+room+"' where id='"+id+"' ";
		try {
			Statement stmt=dbc.conmethod();
			txtid.setText("");
			stmt.execute(sql);
			JOptionPane.showMessageDialog(null, "Patient Updated");
			reset();
		}
		catch (SQLException ex){JOptionPane.showMessageDialog(null, ex);}
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
