import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class viewprescription extends JFrame {

	dbconnection dbc = new dbconnection();
	String did;
	private JPanel contentPane;
	private JTextField txtid;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();
	Object[] row = new Object[4];
	private JLabel txtName;
	private JLabel txtAge;
	private JLabel txtGender;
	private JLabel txtDisease;
	private JLabel txtDoctor;
	private JLabel txtPhone;
	private JLabel txtDepartment;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewprescription frame = new viewprescription();
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
	public viewprescription() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(1250, 639));
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
				new receptionistportal().setVisible(true);
			}
		});
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.setBounds(1110, 46, 46, 43);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("View Prescription");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(new Color(0, 128, 128));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel.setBounds(0, 36, 1234, 67);
		contentPane.add(lblNewLabel);
	    
	    JLabel lblNewLabel_3 = new JLabel("ID of Patient");
	    lblNewLabel_3.setBounds(296, 114, 202, 52);
	    lblNewLabel_3.setForeground(new Color(0, 139, 139));
	    lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 32));
	    contentPane.add(lblNewLabel_3);
	    
	    txtid = new JTextField();
	    txtid.setBounds(519, 122, 355, 39);
	    txtid.setFont(new Font("Tahoma", Font.PLAIN, 28));
	    contentPane.add(txtid);
	    txtid.setColumns(10);
	    
	    JLabel lblSearch = new JLabel("Search");
	    lblSearch.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		loadData();
	    		DoctorData();
	            model.getDataVector().removeAllElements();
	            model.fireTableDataChanged();
	    		tabledata();
	    	}
	    });
	    lblSearch.setBounds(911, 121, 116, 39);
	    lblSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    lblSearch.setFont(new Font("Tahoma", Font.BOLD, 20));
	    lblSearch.setForeground(Color.WHITE);
	    lblSearch.setBackground(new Color(0, 128, 128));
	    lblSearch.setOpaque(true);
	    lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
	    contentPane.add(lblSearch);
	    
	    JLabel lblName = new JLabel("Name");
	    lblName.setForeground(new Color(0, 139, 139));
	    lblName.setFont(new Font("Tahoma", Font.PLAIN, 22));
	    lblName.setBounds(192, 192, 64, 27);
	    contentPane.add(lblName);
	    
	    JLabel lblAge = new JLabel("Age");
	    lblAge.setForeground(new Color(0, 139, 139));
	    lblAge.setFont(new Font("Tahoma", Font.PLAIN, 22));
	    lblAge.setBounds(434, 192, 46, 27);
	    contentPane.add(lblAge);
	    
	    JLabel lblGender = new JLabel("Gender");
	    lblGender.setForeground(new Color(0, 139, 139));
	    lblGender.setFont(new Font("Tahoma", Font.PLAIN, 22));
	    lblGender.setBounds(625, 192, 77, 27);
	    contentPane.add(lblGender);
	    
	    JLabel lblDisease = new JLabel("Disease");
	    lblDisease.setForeground(new Color(0, 139, 139));
	    lblDisease.setFont(new Font("Tahoma", Font.PLAIN, 22));
	    lblDisease.setBounds(863, 192, 77, 27);
	    contentPane.add(lblDisease);
	    
	    txtName = new JLabel("");
	    txtName.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    txtName.setBounds(265, 197, 147, 20);
	    contentPane.add(txtName);
	    
	    txtAge = new JLabel("");
	    txtAge.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    txtAge.setBounds(490, 197, 100, 20);
	    contentPane.add(txtAge);
	    
	    txtGender = new JLabel("");
	    txtGender.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    txtGender.setBounds(720, 195, 123, 20);
	    contentPane.add(txtGender);
	    
	    txtDisease = new JLabel("");
	    txtDisease.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    txtDisease.setBounds(964, 195, 155, 20);
	    contentPane.add(txtDisease);
	    
	    table = new JTable();
	    table.setBounds(211, 242, 467, 296);
	    contentPane.add(table);
		Object[] columns = {"Medicine Name","Course Duration","Daily Dose","Prescription Date"};
	    table.setModel(model);        
	    model.setColumnIdentifiers(columns);
	    table.setRowHeight(30);
	    JScrollPane pane = new JScrollPane(table);
	    pane.setBounds(211, 249, 467, 289);
	    contentPane.setLayout(null);
	    contentPane.add(pane);
	    table.getColumnModel().getColumn(0).setPreferredWidth(50);
	    table.getColumnModel().getColumn(1).setPreferredWidth(50);
	    table.getColumnModel().getColumn(2).setPreferredWidth(50);
	    table.getColumnModel().getColumn(3).setPreferredWidth(50);
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
	    
	    JLabel lblDoctorName = new JLabel("Doctor Name");
	    lblDoctorName.setForeground(new Color(0, 139, 139));
	    lblDoctorName.setFont(new Font("Tahoma", Font.PLAIN, 22));
	    lblDoctorName.setBounds(768, 290, 138, 27);
	    contentPane.add(lblDoctorName);
	    
	    txtDoctor = new JLabel("");
	    txtDoctor.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    txtDoctor.setBounds(914, 293, 147, 20);
	    contentPane.add(txtDoctor);
	    
	    JLabel lblDepartment = new JLabel("Department");
	    lblDepartment.setForeground(new Color(0, 139, 139));
	    lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 22));
	    lblDepartment.setBounds(768, 355, 138, 27);
	    contentPane.add(lblDepartment);
	    
	    txtDepartment = new JLabel("");
	    txtDepartment.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    txtDepartment.setBounds(914, 358, 147, 20);
	    contentPane.add(txtDepartment);
	    
	    JLabel lblPhoneNo = new JLabel("Phone No.");
	    lblPhoneNo.setForeground(new Color(0, 139, 139));
	    lblPhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 22));
	    lblPhoneNo.setBounds(768, 420, 138, 27);
	    contentPane.add(lblPhoneNo);
	    
	    txtPhone = new JLabel("");
	    txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    txtPhone.setBounds(914, 423, 147, 20);
	    contentPane.add(txtPhone);
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
					txtDisease.setText(rs.getString("disease"));
					txtGender.setText(rs.getString("gender"));
					count+=1;
				}
			}
			if(count==0){
				JOptionPane.showMessageDialog(null, "Data Not Found");
				reset1();
			}
			
		}catch(Exception ex){JOptionPane.showMessageDialog(null, ex);}
	}
	
	private void DoctorData(){
		did();
		String sql1="SELECT * FROM doctor WHERE id='"+did+"' ";
		try {
			Statement stmt=dbc.conmethod();
			ResultSet rs=stmt.executeQuery(sql1);
			while (rs.next()){
				if(rs.getString("status").equals("0")){
					txtDoctor.setText(rs.getString("name"));
					txtDepartment.setText(rs.getString("dept"));
					txtPhone.setText(rs.getString("phone"));
				}
			}
		}catch(Exception ex){JOptionPane.showMessageDialog(null, ex);}
	}
	
	private void tabledata(){
		String pid=txtid.getText();
	    String date=null, medicine=null, dose=null, course=null;
		String sql1="SELECT * FROM prescription ORDER BY id DESC";
		try {
			Statement stmt=dbc.conmethod();
			ResultSet rs=stmt.executeQuery(sql1);
			while (rs.next()){
				if(rs.getString("pid").equals(pid)){
					medicine = rs.getString("medicine");
					course = rs.getString("course");
					dose = rs.getString("dose");
					date = rs.getString("dop");
					
					row[0]= medicine;
					row[1]= course;
					row[2]= dose;
					row[3]= date;
					
					model.addRow(row);
				}
			}
		}catch(Exception ex){JOptionPane.showMessageDialog(null, ex);}
	}
	private void did(){
		String pid=txtid.getText();
		String sql1="SELECT * FROM prescription ORDER BY id DESC";
		try {
			Statement stmt=dbc.conmethod();
			ResultSet rs=stmt.executeQuery(sql1);
			while (rs.next()){
				if(rs.getString("pid").equals(pid)){
					did=rs.getString("did");
					break;
				}
			}
		}catch(Exception ex){JOptionPane.showMessageDialog(null, ex);}
	}
	private void reset1(){
		txtName.setText("");
		txtAge.setText("");
		txtDisease.setText("");
		txtGender.setText("");
		txtDoctor.setText("");
		txtDepartment.setText("");
		txtPhone.setText("");
	}

}
