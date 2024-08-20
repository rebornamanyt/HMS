import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;


public class rlogin extends JFrame {

	dbconnection dbc = new dbconnection();
	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rlogin frame = new rlogin();
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
	public rlogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(1030, 589));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hospital Management System");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(new Color(0, 128, 128));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel.setBounds(0, 36, 1014, 67);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("UserName:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(295, 213, 119, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPassword.setBounds(295, 305, 119, 29);
		contentPane.add(lblPassword);
		
		user = new JTextField();
		user.setFont(new Font("Tahoma", Font.PLAIN, 18));
		user.setBounds(449, 213, 330, 29);
		contentPane.add(user);
		user.setColumns(10);
		
		pass = new JPasswordField();
		pass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pass.setColumns(10);
		pass.setBounds(449, 305, 330, 29);
		contentPane.add(pass);
		
		JLabel lblNewLabel_2 = new JLabel("Home");
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new mainpage1().setVisible(true);
			}
		});
		lblNewLabel_2.setBackground(new Color(0, 128, 128));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(374, 406, 97, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblLogin = new JLabel("LogIn");
		lblLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login();
			}
		});
		lblLogin.setOpaque(true);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogin.setBackground(new Color(0, 128, 128));
		lblLogin.setBounds(570, 406, 97, 33);
		contentPane.add(lblLogin);
		
		JLabel lblNewLabel_3 = new JLabel("Receptionist Login");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_3.setForeground(new Color(0, 139, 139));
		lblNewLabel_3.setBounds(411, 135, 243, 43);
		contentPane.add(lblNewLabel_3);
	}
	public void login(){
		String uname=user.getText();
		String upass=pass.getText();
		String sql=("select * from receptionist");
		if (uname.equals("") || upass.equals("")) {
			reset();
			JOptionPane.showMessageDialog(null, "Username or Password must required");
		}else{
			try {
				Statement stmt=dbc.conmethod();
				ResultSet rs=stmt.executeQuery(sql);
				int count=0;
				while(rs.next()){
					String user=rs.getString("username");
					String pass=rs.getString("password");
					if((uname.equals(user))&&(upass.equals(pass))){
							count+=1;
							new receptionistportal().setVisible(true);
							dispose();
							JOptionPane.showMessageDialog(null, "Receptionist Login Successfull");
					}
				}
				if (count==0){
					reset();
					JOptionPane.showMessageDialog(null, "Invalid user or password");
				}
			} catch (Exception e){ JOptionPane.showMessageDialog(null, e);}
		}
	}
	public void reset(){
		user.setText("");
		pass.setText("");
		user.requestFocus(true);
	}

}
