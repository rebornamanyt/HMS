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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;


public class addprescription extends JFrame {

	dbconnection dbc = new dbconnection();
	private JPanel contentPane;
	private JTextField txtid;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();
	Object[] row = new Object[4];
	private JLabel txtName;
	private JLabel txtAge;
	private JLabel txtGender;
	private JLabel txtDisease;
	private JTextField txtMedicine;
	private JTextField txtDuration;
	private JTextField txtDose;
	String did=null;
	
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
					addprescription frame = new addprescription(null);
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
	public addprescription(String uname) {
		did=uname;
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
				new doctorportal(uname).setVisible(true);
			}
		});
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.setBounds(1110, 46, 46, 43);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Add Prescription");
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
	    
	    JLabel lblMedicineName = new JLabel("Date");
	    lblMedicineName.setForeground(new Color(0, 139, 139));
	    lblMedicineName.setFont(new Font("Tahoma", Font.PLAIN, 22));
	    lblMedicineName.setBounds(744, 257, 77, 27);
	    contentPane.add(lblMedicineName);
	    
	    JLabel txtDate = new JLabel(today);
	    txtDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    txtDate.setBounds(918, 257, 155, 20);
	    contentPane.add(txtDate);
	    
	    JLabel lblMedicineName_1 = new JLabel("Medicine Name");
	    lblMedicineName_1.setForeground(new Color(0, 139, 139));
	    lblMedicineName_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
	    lblMedicineName_1.setBounds(744, 314, 160, 27);
	    contentPane.add(lblMedicineName_1);
	    
	    JLabel lblCourse = new JLabel("Course Duration");
	    lblCourse.setForeground(new Color(0, 139, 139));
	    lblCourse.setFont(new Font("Tahoma", Font.PLAIN, 22));
	    lblCourse.setBounds(744, 369, 160, 27);
	    contentPane.add(lblCourse);
	    
	    JLabel lblDaily = new JLabel("Daily Dose");
	    lblDaily.setForeground(new Color(0, 139, 139));
	    lblDaily.setFont(new Font("Tahoma", Font.PLAIN, 22));
	    lblDaily.setBounds(744, 428, 147, 27);
	    contentPane.add(lblDaily);
	    
	    JLabel lblNewLabel_5 = new JLabel("Add");
	    lblNewLabel_5.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		adddata();
	    	}
	    });
	    lblNewLabel_5.setBackground(new Color(0, 128, 128));
	    lblNewLabel_5.setOpaque(true);
	    lblNewLabel_5.setForeground(Color.WHITE);
	    lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 26));
	    lblNewLabel_5.setBounds(840, 481, 100, 43);
	    contentPane.add(lblNewLabel_5);
	    
	    JLabel lblDays = new JLabel("Days");
	    lblDays.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblDays.setBounds(981, 369, 46, 20);
	    contentPane.add(lblDays);
	    
	    JLabel lblTimes = new JLabel("Times");
	    lblTimes.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblTimes.setBounds(982, 428, 64, 20);
	    contentPane.add(lblTimes);
	    
	    txtMedicine = new JTextField();
	    txtMedicine.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    txtMedicine.setBounds(918, 314, 169, 23);
	    contentPane.add(txtMedicine);
	    txtMedicine.setColumns(10);
	    
	    txtDuration = new JTextField();
	    txtDuration.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    txtDuration.setColumns(10);
	    txtDuration.setBounds(922, 369, 51, 23);
	    contentPane.add(txtDuration);
	    
	    JLabel label_1 = new JLabel("");
	    label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    label_1.setBounds(911, 428, 46, 20);
	    contentPane.add(label_1);
	    
	    txtDose = new JTextField();
	    txtDose.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    txtDose.setColumns(10);
	    txtDose.setBounds(922, 428, 51, 23);
	    contentPane.add(txtDose);
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
	private void adddata(){

		String pid,medicine,dose,course,sql;
		pid=txtid.getText();
		medicine=txtMedicine.getText();
		dose=txtDose.getText();
		course=txtDuration.getText();
		
		sql="INSERT INTO prescription(pid,did,medicine,dose,course,dop) values('"+pid+"','"+did+"','"+medicine+"','"+dose+"','"+course+"',now())";
		if (medicine.equals("") || dose.equals("") || course.equals("")){
			JOptionPane.showMessageDialog(null, "Fill Requried Data");
		}else
		{
			try {
				Statement stmt=dbc.conmethod();
				stmt.execute(sql);
				JOptionPane.showMessageDialog(null, "Prescription Added");
	            model.getDataVector().removeAllElements();
	            model.fireTableDataChanged();
				tabledata();
				reset2();
			}
			catch (SQLException ex){JOptionPane.showMessageDialog(null, ex);}
		}
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
	private void reset1(){
		txtName.setText("");
		txtAge.setText("");
		txtDisease.setText("");
		txtGender.setText("");
	}
	private void reset2(){
		txtMedicine.setText("");
		txtDuration.setText("");
		txtDose.setText("");
		txtMedicine.requestFocus();
	}
}
