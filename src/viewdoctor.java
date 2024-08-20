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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;


public class viewdoctor extends JFrame {
	
	dbconnection dbc = new dbconnection();
	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();
	Object[] row = new Object[12];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewdoctor frame = new viewdoctor();
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
	public viewdoctor() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(1250, 589));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
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
		
		JLabel lblNewLabel = new JLabel("View Doctor");
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
		Object[] columns = {"Date","ID","Name","Age","Gender","Blood Group","Department","Mobile no","Email","Maritial Status","Address","Room No."};
        table.setModel(model);        
        model.setColumnIdentifiers(columns);
        table.setRowHeight(30);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(10, 121, 1214, 418);
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
        table.getColumnModel().getColumn(9).setPreferredWidth(50);
        table.getColumnModel().getColumn(10).setPreferredWidth(50);
        table.getColumnModel().getColumn(11).setPreferredWidth(50);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        
        String date=null, id=null, name=null, age=null,gender=null,blood=null,dept=null,phone=null,email=null,maritial=null,address=null,room=null;
		String sql1="SELECT * FROM doctor";
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
					blood = rs.getString("blood");
					dept = rs.getString("dept");
					phone = rs.getString("phone");
					email = rs.getString("email");
					maritial = rs.getString("maritial");
					address = rs.getString("address");
					room = rs.getString("room");
					
					row[0]= date;
					row[1]= id;
					row[2]= name;
					row[3]= age;
					row[4]= gender;
					row[5]= blood;
					row[6]= dept;
					row[7]= phone;
					row[8]= email;
					row[9]= maritial;
					row[10]= address;
					row[11]= room;
					
					model.addRow(row);
					}
			}
			
		}catch(Exception ex){JOptionPane.showMessageDialog(null, ex);}
	}
}
