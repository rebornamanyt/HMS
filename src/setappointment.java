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
import javax.swing.JComboBox;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class setappointment extends JFrame {
	
	String dname, droom,pname;
	Integer count=0,count1=0;
	dbconnection dbc = new dbconnection();
	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();
	Object[] row = new Object[7];
	private JComboBox comboDept;
	private JTextField txtDid;
	private JTextField txtPid;
	private JComboBox comboDD;
	private JComboBox comboMM;
	private JComboBox comboYYYY;
	private JTextField txtPname;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setappointment frame = new setappointment();
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
	public setappointment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(1250, 589));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
				new receptionistportal().setVisible(true);
			}
		});
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Set Appointment");
		lblNewLabel.setBounds(0, 36, 1234, 67);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(new Color(0, 128, 128));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		contentPane.add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(10, 121, 1214, 418);
		contentPane.add(table);
		Object[] columns = {"ID","Name","Gender","Mobile no","Email","Address","Room No."};
        table.setModel(model);        
        model.setColumnIdentifiers(columns);
        table.setRowHeight(30);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(81, 188, 608, 317);
        contentPane.setLayout(null);
        contentPane.add(pane);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(50);
        table.getColumnModel().getColumn(2).setPreferredWidth(50);
        table.getColumnModel().getColumn(3).setPreferredWidth(50);
        table.getColumnModel().getColumn(4).setPreferredWidth(50);
        table.getColumnModel().getColumn(5).setPreferredWidth(50);
        table.getColumnModel().getColumn(6).setPreferredWidth(50);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        
        JLabel lblNewLabel_3 = new JLabel("Department");
	    lblNewLabel_3.setBounds(88, 116, 177, 52);
	    lblNewLabel_3.setForeground(new Color(0, 139, 139));
	    lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 32));
	    contentPane.add(lblNewLabel_3);
	    
	    JLabel lblSearch = new JLabel("Search");
	    lblSearch.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		Integer count=0;
	    		String dept=comboDept.getSelectedItem().toString();
	    		String id=null, name=null,gender=null,phone=null,email=null,address=null,room=null;
	    		String sql1="SELECT * FROM doctor";
	    		try {
	    			Statement stmt=dbc.conmethod();
	    			ResultSet rs=stmt.executeQuery(sql1);
	    			while (rs.next()){
	    				if(rs.getString("status").equals("0")&&rs.getString("dept").equals(dept)){
	    					id = rs.getString("id");
	    					name = rs.getString("name");
	    					gender = rs.getString("gender");
	    					phone = rs.getString("phone");
	    					email = rs.getString("email");
	    					address = rs.getString("address");
	    					room = rs.getString("room");
	    					count+=1;
	    					
	    					row[0]= id;
	    					row[1]= name;
	    					row[2]= gender;
	    					row[3]= phone;
	    					row[4]= email;
	    					row[5]= address;
	    					row[6]= room;
	    					
	    					model.addRow(row);
	    					}
	    			}
	    			if(count==0){
    					JOptionPane.showMessageDialog(null, "Doctor Not Found");
    				}
	    		}catch(Exception ex){JOptionPane.showMessageDialog(null, ex);}
	    	}
	    });
	    lblSearch.setBounds(566, 124, 116, 39);
	    lblSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    lblSearch.setFont(new Font("Tahoma", Font.BOLD, 20));
	    lblSearch.setForeground(Color.WHITE);
	    lblSearch.setBackground(new Color(0, 128, 128));
	    lblSearch.setOpaque(true);
	    lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
	    contentPane.add(lblSearch);
	    
	    comboDept = new JComboBox();
	    comboDept.setFont(new Font("Tahoma", Font.PLAIN, 22));
		comboDept.addItem("Physician");
		comboDept.addItem("Dental");
		comboDept.addItem("Gynaecology");
		comboDept.addItem("Neurology");
		comboDept.addItem("Cardiology");
		comboDept.addItem("Haematology");
		comboDept.addItem("Microbiology");
	    comboDept.setBounds(290, 127, 244, 36);
	    contentPane.add(comboDept);
	    
	    JLabel lblDoctorId = new JLabel("Doctor ID");
	    lblDoctorId.setForeground(new Color(0, 139, 139));
	    lblDoctorId.setFont(new Font("Tahoma", Font.PLAIN, 22));
	    lblDoctorId.setBounds(760, 211, 106, 39);
	    contentPane.add(lblDoctorId);
	    
	    JLabel lblPatientId = new JLabel("Patient ID");
	    lblPatientId.setForeground(new Color(0, 139, 139));
	    lblPatientId.setFont(new Font("Tahoma", Font.PLAIN, 22));
	    lblPatientId.setBounds(760, 276, 106, 39);
	    contentPane.add(lblPatientId);
	    
	    txtDid = new JTextField();
	    txtDid.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    txtDid.setBounds(926, 218, 177, 26);
	    contentPane.add(txtDid);
	    txtDid.setColumns(10);
	    
	    txtPid = new JTextField();
	    txtPid.addKeyListener(new KeyAdapter() {
	    	@Override
	    	public void keyReleased(KeyEvent e) {
	    		String pid=txtPid.getText();
	    		if(pid.compareTo("p1000")>0){
		    		String sql="SELECT * FROM patient WHERE id='"+pid+"'";
		    		try {
		    			txtPname.setText("");
		    			Statement stmt=dbc.conmethod();
		    			ResultSet rs=stmt.executeQuery(sql);
		    			while (rs.next()){
		    				if(rs.getString("status").equals("0")){
		    					txtPname.setText(rs.getString("name"));
		    				}
		    			}
		    		}catch(Exception ex){}
	    		}
	    	}
	    });
	    txtPid.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    txtPid.setColumns(10);
	    txtPid.setBounds(927, 284, 177, 26);
	    contentPane.add(txtPid);
	    
	    JLabel lblSetAppointment = new JLabel("Set Appointment");
	    lblSetAppointment.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		doctordata();
	    		patientdata();
	    		if(count==0){
					JOptionPane.showMessageDialog(null,"Please Enter correct Id of Doctor");
	    		}
	    		else if(count1==0){
					JOptionPane.showMessageDialog(null,"Please Enter correct Id of Patient");
	    		}
	    		else{
	    			addapp();
	    		}
	    	}
	    });
	    lblSetAppointment.setOpaque(true);
	    lblSetAppointment.setHorizontalAlignment(SwingConstants.CENTER);
	    lblSetAppointment.setForeground(Color.WHITE);
	    lblSetAppointment.setFont(new Font("Tahoma", Font.BOLD, 20));
	    lblSetAppointment.setBackground(new Color(0, 128, 128));
	    lblSetAppointment.setBounds(842, 431, 176, 39);
	    contentPane.add(lblSetAppointment);
	    
	    JLabel lblPatientName = new JLabel("Patient Name");
	    lblPatientName.setForeground(new Color(0, 139, 139));
	    lblPatientName.setFont(new Font("Tahoma", Font.PLAIN, 22));
	    lblPatientName.setBounds(760, 344, 140, 39);
	    contentPane.add(lblPatientName);
	    
	    txtPname = new JTextField();
	    txtPname.setEditable(false);
	    txtPname.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    txtPname.setColumns(10);
	    txtPname.setBounds(927, 352, 177, 26);
	    contentPane.add(txtPname);
	}
	private void addapp(){
		String did,pid,sql;
		did=txtDid.getText();
		pid=txtPid.getText();
		sql="INSERT INTO appointment(did,pid,status,date) values('"+did+"','"+pid+"','0',now())";
		if (did.equals("") || pid.equals("")){
			JOptionPane.showMessageDialog(null, "Fill Requried Data");
		}else
		{
			try {
				doctordata();
				patientdata();
				Statement stmt=dbc.conmethod();
				stmt.execute(sql);
				JOptionPane.showMessageDialog(null, pname+" Your Appointment Set to Doctor "+dname+" in Room "+droom);
				dispose();
				new receptionistpanel().setVisible(true);
			}
			catch (SQLException ex){JOptionPane.showMessageDialog(null, ex);}
		}
	}
	private void doctordata(){
		String did,sql;
		did=txtDid.getText();
		sql="SELECT * FROM doctor where id='"+did+"'";
		try {
			Statement stmt=dbc.conmethod();
			ResultSet rs=stmt.executeQuery(sql);
			while (rs.next()){
				if(rs.getString("status").equals("0")){
					dname=rs.getString("name");
					droom=rs.getString("room");
					count+=1;
				}
			}
		}catch(Exception ex){JOptionPane.showMessageDialog(null, ex);}
	}
	private void patientdata(){
		String pid,sql;
		pid=txtPid.getText();
		sql="SELECT * FROM patient where id='"+pid+"'";
		try {
			Statement stmt=dbc.conmethod();
			ResultSet rs=stmt.executeQuery(sql);
			while (rs.next()){
				if(rs.getString("status").equals("0")){
					pname=rs.getString("name");
					count1+=1;
				}
			}
		}catch(Exception ex){JOptionPane.showMessageDialog(null, ex);}
	}
}
