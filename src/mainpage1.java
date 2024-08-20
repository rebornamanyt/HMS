import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;


public class mainpage1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainpage1 frame = new mainpage1();
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
	public mainpage1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(1030, 589));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hospital Management System");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(new Color(0, 128, 128));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel.setBounds(0, 36, 1014, 67);
		contentPane.add(lblNewLabel);
		
		JLabel lblLoginAs = new JLabel("Login As ");
		lblLoginAs.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginAs.setBackground(new Color(255, 99, 71));
		lblLoginAs.setForeground(Color.WHITE);
		lblLoginAs.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblLoginAs.setOpaque(true);
		lblLoginAs.setBounds(0, 156, 233, 67);
		contentPane.add(lblLoginAs);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBackground(new Color(0, 128, 128));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setOpaque(true);
		lblWelcome.setBounds(44, 300, 137, 35);
		contentPane.add(lblWelcome);
		
		JLabel label = new JLabel("To");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setOpaque(true);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBackground(new Color(0, 128, 128));
		label.setBounds(56, 338, 109, 35);
		contentPane.add(label);
		
		JLabel lblLoginPortal = new JLabel("Login Portal");
		lblLoginPortal.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginPortal.setOpaque(true);
		lblLoginPortal.setForeground(Color.WHITE);
		lblLoginPortal.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblLoginPortal.setBackground(new Color(0, 128, 128));
		lblLoginPortal.setBounds(45, 374, 148, 35);
		contentPane.add(lblLoginPortal);
		
		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setBackground(new Color(0, 128, 128));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBounds(0, 252, 233, 222);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAdmin.setForeground(Color.WHITE);
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setBackground(new Color(0, 128, 128));
		lblAdmin.setBounds(315, 307, 153, 25);
		contentPane.add(lblAdmin);
		
		JLabel lblDoctor = new JLabel("Doctor");
		lblDoctor.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctor.setForeground(Color.WHITE);
		lblDoctor.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDoctor.setBackground(new Color(0, 128, 128));
		lblDoctor.setBounds(540, 307, 153, 25);
		contentPane.add(lblDoctor);
		
		JLabel lblReceptionist = new JLabel("Receptionist");
		lblReceptionist.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionist.setForeground(Color.WHITE);
		lblReceptionist.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblReceptionist.setBackground(new Color(0, 128, 128));
		lblReceptionist.setBounds(761, 307, 153, 25);
		contentPane.add(lblReceptionist);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("Icon\\admin.png"));
		lblNewLabel_1.setBounds(367, 256, 48, 44);
		contentPane.add(lblNewLabel_1);
		
		JLabel label_3 = new JLabel(new ImageIcon("Icon\\doctor.png"));
		label_3.setBounds(594, 256, 48, 44);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel(new ImageIcon("Icon\\reception.png"));
		label_4.setBounds(815, 256, 48, 44);
		contentPane.add(label_4);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new alogin().setVisible(true);
			}
		});
		lblNewLabel_3.setBackground(new Color(0, 128, 128));
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBounds(315, 241, 153, 105);
		contentPane.add(lblNewLabel_3);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new dlogin().setVisible(true);
			}
		});
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.setOpaque(true);
		label_1.setBackground(new Color(0, 128, 128));
		label_1.setBounds(540, 241, 153, 105);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new alogin().setVisible(true);
			}
		});
		label_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_2.setOpaque(true);
		label_2.setBackground(new Color(0, 128, 128));
		label_2.setBounds(761, 241, 153, 105);
		contentPane.add(label_2);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("Icon\\bgd.jpg"));
		lblNewLabel_5.setBounds(0, 0, 1014, 550);
		contentPane.add(lblNewLabel_5);
	}

}
