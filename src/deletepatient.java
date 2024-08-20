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
import javax.swing.JTextField;


public class deletepatient extends JFrame {

	dbconnection dbc = new dbconnection();
	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();
	Object[] row = new Object[9];
	private JTextField txtid;
	Integer count=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deletepatient frame = new deletepatient();
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
	public deletepatient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(1030, 589));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon("Icon\\cross.png"));
		lblNewLabel_1.setBounds(949, 46, 46, 43);
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new mainpage1().setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(new ImageIcon("Icon\\backs.png"));
		lblNewLabel_2.setBounds(893, 46, 46, 43);
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new patientpanel().setVisible(true);
			}
		});
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(lblNewLabel_2);
		

		
		JLabel lblNewLabel = new JLabel("Delete Patient");
		lblNewLabel.setBounds(0, 36, 1014, 67);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(new Color(0, 128, 128));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(1, 1, 992, 0);
		contentPane.add(table);
		Object[] columns = {"Date","ID","Name","Age","Gender","Address", "Mobile no","Disease","Room No."};
        table.setModel(model);        
        model.setColumnIdentifiers(columns);
        table.setRowHeight(30);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(10, 175, 994, 364);
        contentPane.setLayout(null);
        contentPane.add(pane);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(50);
        table.getColumnModel().getColumn(2).setPreferredWidth(50);
        table.getColumnModel().getColumn(3).setPreferredWidth(50);
        table.getColumnModel().getColumn(4).setPreferredWidth(50);
        table.getColumnModel().getColumn(5).setPreferredWidth(50);
        table.getColumnModel().getColumn(6).setPreferredWidth(50);
        table.getColumnModel().getColumn(7).setPreferredWidth(50);
        table.getColumnModel().getColumn(8).setPreferredWidth(50);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        loadData();
        
        JLabel lblNewLabel_3 = new JLabel("Id of Patient");
        lblNewLabel_3.setForeground(new Color(0, 139, 139));
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lblNewLabel_3.setBounds(159, 114, 187, 52);
        contentPane.add(lblNewLabel_3);
        
        txtid = new JTextField();
        txtid.setFont(new Font("Tahoma", Font.PLAIN, 28));
        txtid.setBounds(367, 122, 355, 39);
        contentPane.add(txtid);
        txtid.setColumns(10);
        
        JLabel lblDelete = new JLabel("Delete");
        lblDelete.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		String id,sql;
        		id=txtid.getText();
        		sql="UPDATE patient SET status='1' where id='"+id+"' ";
        		try {
        			Statement stmt=dbc.conmethod();
        			datafound();
        			if(count==0){
        				JOptionPane.showMessageDialog(null, "Receptionist Not fount");
        			}
        			else
        			{
	        			txtid.setText("");
	        			stmt.execute(sql);
	        			JOptionPane.showMessageDialog(null, "Patient Deleted");
	    				dispose();
	    				new patientpanel().setVisible(true);
        			}
        		}
        		catch (SQLException ex){JOptionPane.showMessageDialog(null, ex);}
        	}
        });
        lblDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblDelete.setForeground(Color.WHITE);
        lblDelete.setBackground(new Color(0, 128, 128));
        lblDelete.setOpaque(true);
        lblDelete.setHorizontalAlignment(SwingConstants.CENTER);
        lblDelete.setBounds(759, 121, 116, 39);
        contentPane.add(lblDelete);
	}
	private void loadData(){
        String date=null, id=null, name=null, age=null,gender=null,address=null,phone=null,disease=null,room=null;
		String sql1="SELECT * FROM patient ORDER BY date DESC";
		try {
			Statement stmt=dbc.conmethod();
			ResultSet rs=stmt.executeQuery(sql1);
			while (rs.next()){
				if(rs.getString("status").equals("0")){
					date = rs.getString("date");
					id = rs.getString("id");
					name = rs.getString("name");
					age = rs.getString("age");
					gender = rs.getString("gender");
					address = rs.getString("address");
					phone = rs.getString("phone");
					disease = rs.getString("disease");
					room = rs.getString("room");
					
					row[0]= date;
					row[1]= id;
					row[2]= name;
					row[3]= age;
					row[4]= gender;
					row[5]= address;
					row[6]= phone;
					row[7]= disease;
					row[8]= room;
					
					model.addRow(row);
				}
			}
			
		}catch(Exception ex){JOptionPane.showMessageDialog(null, ex);}
	}
	private void datafound(){
		String id=txtid.getText();
		String sql1="SELECT * FROM patient where id='"+id+"'";
		try {
			Statement stmt=dbc.conmethod();
			ResultSet rs=stmt.executeQuery(sql1);
			while (rs.next()){
				if(rs.getString("status").equals("0")){
					count+=1;
				}
			}
		}catch(Exception ex){JOptionPane.showMessageDialog(null, ex);}
	}
}
