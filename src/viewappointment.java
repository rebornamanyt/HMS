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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class viewappointment extends JFrame {

	dbconnection dbc = new dbconnection();
	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();
	Object[] row = new Object[7];
	private JLabel txtName;
	private JLabel txtDisease;
	private JLabel txtGender;
	private JLabel txtAge;
	private JLabel txtId;
	private Integer count1=0;
	private String did,pid,id,status1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewappointment frame = new viewappointment(null);
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
	public viewappointment(String uname) {
		did=uname;
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
		contentPane.setLayout(null);
		lblNewLabel_1.setBounds(949, 46, 46, 43);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(new ImageIcon("Icon\\backs.png"));
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new doctorportal(uname).setVisible(true);
			}
		});
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.setBounds(893, 46, 46, 43);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("View Appointment");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(new Color(0, 128, 128));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(0, 36, 1014, 67);
		contentPane.add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(10, 114, 994, 425);
		contentPane.add(table);
		Object[] columns = {"Date","ID","Name","Age","Gender","Disease","Status"};
        table.setModel(model);        
        model.setColumnIdentifiers(columns);
        table.setRowHeight(30);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(89, 234, 835, 305);
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
        tabledata();
	    
	    JLabel lblName = new JLabel("Name");
	    lblName.setForeground(new Color(0, 139, 139));
	    lblName.setFont(new Font("Tahoma", Font.PLAIN, 22));
	    lblName.setBounds(176, 130, 64, 27);
	    contentPane.add(lblName);
	    
	    txtName = new JLabel("");
	    txtName.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    txtName.setBounds(279, 130, 162, 25);
	    contentPane.add(txtName);
	    
	    JLabel lblDisease = new JLabel("Disease");
	    lblDisease.setForeground(new Color(0, 139, 139));
	    lblDisease.setFont(new Font("Tahoma", Font.PLAIN, 22));
	    lblDisease.setBounds(176, 179, 93, 27);
	    contentPane.add(lblDisease);
	    
	    txtDisease = new JLabel("");
	    txtDisease.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    txtDisease.setBounds(279, 179, 162, 25);
	    contentPane.add(txtDisease);
	    
	    JLabel lblGender = new JLabel("Gender");
	    lblGender.setForeground(new Color(0, 139, 139));
	    lblGender.setFont(new Font("Tahoma", Font.PLAIN, 22));
	    lblGender.setBounds(451, 179, 82, 27);
	    contentPane.add(lblGender);
	    
	    txtGender = new JLabel("");
	    txtGender.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    txtGender.setBounds(538, 179, 108, 25);
	    contentPane.add(txtGender);
	    
	    JLabel lblAge = new JLabel("Age");
	    lblAge.setForeground(new Color(0, 139, 139));
	    lblAge.setFont(new Font("Tahoma", Font.PLAIN, 22));
	    lblAge.setBounds(451, 130, 64, 27);
	    contentPane.add(lblAge);
	    
	    txtAge = new JLabel("");
	    txtAge.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    txtAge.setBounds(538, 130, 108, 25);
	    contentPane.add(txtAge);
	    
	    JLabel lblId = new JLabel("ID");
	    lblId.setForeground(new Color(0, 139, 139));
	    lblId.setFont(new Font("Tahoma", Font.PLAIN, 22));
	    lblId.setBounds(703, 130, 36, 27);
	    contentPane.add(lblId);
	    
	    txtId = new JLabel("");
	    txtId.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    txtId.setBounds(749, 130, 108, 25);
	    contentPane.add(txtId);
	    
	    JLabel lblNewLabel_4 = new JLabel("Seen");
	    lblNewLabel_4.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		seen();
	    	}
	    });
	    lblNewLabel_4.setForeground(Color.WHITE);
	    lblNewLabel_4.setBackground(new Color(0, 128, 128));
	    lblNewLabel_4.setOpaque(true);
	    lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 22));
	    lblNewLabel_4.setBounds(759, 173, 117, 43);
	    contentPane.add(lblNewLabel_4);
	    
	    appdata();
	    patientdata();
	    
	}
	private void tabledata(){
		String patid,status2;
		String sql1="SELECT * FROM appointment WHERE did='"+did+"' ORDER BY id DESC";
		try {
			Statement stmt=dbc.conmethod();
			ResultSet rs=stmt.executeQuery(sql1);
			while (rs.next()){
				patid=rs.getString("pid");
				status2=rs.getString("status");
				String date=null, id=null, name=null, age=null,gender=null,disease=null,status=null;
				String sql2="SELECT * FROM patient where id='"+patid+"'";
				try {
					Statement stmt1=dbc.conmethod();
					ResultSet rs1=stmt1.executeQuery(sql2);
					while (rs1.next()){
						if(rs1.getString("status").equals("0")){
							date = rs1.getString("date");
							id = rs1.getString("id");
							name = rs1.getString("name");
							age = rs1.getString("age");
							gender = rs1.getString("gender");
							disease = rs1.getString("disease");
							if(status2.equals("0")){status="Not Seen";}
							else{status="Seen";}
							
							row[0]= date;
							row[1]= id;
							row[2]= name;
							row[3]= age;
							row[4]= gender;
							row[5]= disease;
							row[6]= status;
							
							model.addRow(row);
							}
					}
					
				}catch(Exception ex){JOptionPane.showMessageDialog(null, ex);}
			}			
		}catch(Exception ex){JOptionPane.showMessageDialog(null, ex);}
	}
	private void patientdata(){
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
					txtId.setText(pid);
				}
			}			
		}catch(Exception ex){JOptionPane.showMessageDialog(null, ex);}
	}
	private void appdata(){
		String sql1="SELECT * FROM appointment WHERE did='"+did+"'";
		try {
			Statement stmt=dbc.conmethod();
			ResultSet rs=stmt.executeQuery(sql1);
			while (rs.next()){
				if(rs.getString("status").equals("0")){
					pid=rs.getString("pid");
					status1=rs.getString("status");
					id=rs.getString("id");
					count1+=1;
					break;
				}
			}
			if(count1==0){
				JOptionPane.showMessageDialog(null,"No more Appointment");
			}
		}catch(Exception ex){JOptionPane.showMessageDialog(null, ex);}
	}
	private void seen(){
			String sql="UPDATE appointment SET status='1' where id='"+id+"' ";
			try {
				if(count1!=0){
					Statement stmt=dbc.conmethod();
					stmt.execute(sql);
					reset();
					dispose();
					new doctorportal(did).setVisible(true);
					JOptionPane.showMessageDialog(null, "Patient Seened");
					
				}
			}
			catch (SQLException ex){JOptionPane.showMessageDialog(null, ex);}
	}
	private void reset(){
		txtName.setText("");
		txtAge.setText("");
		txtDisease.setText("");
		txtGender.setText("");
		txtId.setText("");
	}
}
