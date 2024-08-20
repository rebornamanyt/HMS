import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class patientpanel extends JFrame {

	private JPanel contentPane;
	String name="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					patientpanel frame = new patientpanel();
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
	public patientpanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(1030, 589));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel(new ImageIcon("Icon\\backs.png"));
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new adminportal().setVisible(true);
			}
		});
		lblNewLabel_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_5.setBounds(893, 46, 46, 43);
		contentPane.add(lblNewLabel_5);
		
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
		contentPane.add(lblNewLabel_1);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBackground(new Color(0, 128, 128));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setOpaque(true);
		lblWelcome.setBounds(58, 268, 137, 35);
		contentPane.add(lblWelcome);
		
		JLabel label = new JLabel("To");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setOpaque(true);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBackground(new Color(0, 128, 128));
		label.setBounds(70, 306, 109, 35);
		contentPane.add(label);
		
		JLabel lblLoginPortal = new JLabel("Patient Panel");
		lblLoginPortal.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginPortal.setOpaque(true);
		lblLoginPortal.setForeground(Color.WHITE);
		lblLoginPortal.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblLoginPortal.setBackground(new Color(0, 128, 128));
		lblLoginPortal.setBounds(35, 342, 180, 35);
		contentPane.add(lblLoginPortal);
		
		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setBackground(new Color(0, 128, 128));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBounds(0, 174, 252, 300);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Patient Panel");
		lblNewLabel.setBounds(0, 36, 1014, 67);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(new Color(0, 128, 128));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		contentPane.add(lblNewLabel);
		
		JLabel lblAdmin = new JLabel("Add Patient");
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAdmin.setForeground(Color.WHITE);
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setBackground(new Color(0, 128, 128));
		lblAdmin.setBounds(324, 256, 153, 25);
		contentPane.add(lblAdmin);
		
		JLabel lblDoctor = new JLabel("Update Patient");
		lblDoctor.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctor.setForeground(Color.WHITE);
		lblDoctor.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDoctor.setBackground(new Color(0, 128, 128));
		lblDoctor.setBounds(549, 256, 153, 25);
		contentPane.add(lblDoctor);
		
		JLabel lblReceptionist = new JLabel("Delete Patient");
		lblReceptionist.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceptionist.setForeground(Color.WHITE);
		lblReceptionist.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblReceptionist.setBackground(new Color(0, 128, 128));
		lblReceptionist.setBounds(770, 256, 153, 25);
		contentPane.add(lblReceptionist);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("Icon\\addpatient.png"));
		lblNewLabel_4.setBounds(376, 205, 48, 44);
		contentPane.add(lblNewLabel_4);
		
		JLabel label_3 = new JLabel(new ImageIcon("Icon\\updatepatient.png"));
		label_3.setBounds(603, 205, 48, 44);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel(new ImageIcon("Icon\\deletepatient.png"));
		label_4.setBounds(824, 205, 48, 44);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel(new ImageIcon("Icon\\searchpatient.png"));
		label_5.setBounds(376, 366, 48, 44);
		contentPane.add(label_5);
		
		JLabel label_8 = new JLabel(new ImageIcon("Icon\\viewpatient.png"));
		label_8.setBounds(599, 366, 48, 44);
		contentPane.add(label_8);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new addpatient(name).setVisible(true);				
			}
		});
		lblNewLabel_3.setBackground(Color.DARK_GRAY);
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBounds(324, 190, 153, 105);
		contentPane.add(lblNewLabel_3);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new updatepatient(name).setVisible(true);
			}
		});
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.setOpaque(true);
		label_1.setBackground(Color.DARK_GRAY);
		label_1.setBounds(549, 190, 153, 105);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new deletepatient().setVisible(true);
			}
		});
		label_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_2.setOpaque(true);
		label_2.setBackground(Color.DARK_GRAY);
		label_2.setBounds(770, 190, 153, 105);
		contentPane.add(label_2);
		
		JLabel lblSearchPatient = new JLabel("Search patient");
		lblSearchPatient.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchPatient.setForeground(Color.WHITE);
		lblSearchPatient.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSearchPatient.setBackground(new Color(0, 128, 128));
		lblSearchPatient.setBounds(324, 417, 153, 25);
		contentPane.add(lblSearchPatient);
		
		JLabel label_7 = new JLabel("");
		label_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new searchpatient().setVisible(true);
			}
		});
		label_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_7.setOpaque(true);
		label_7.setBackground(Color.DARK_GRAY);
		label_7.setBounds(324, 351, 153, 105);
		contentPane.add(label_7);
		
		JLabel lblViewPatient = new JLabel("View Patient");
		lblViewPatient.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewPatient.setForeground(Color.WHITE);
		lblViewPatient.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblViewPatient.setBackground(new Color(0, 128, 128));
		lblViewPatient.setBounds(547, 417, 153, 25);
		contentPane.add(lblViewPatient);
		
		JLabel label_10 = new JLabel("");
		label_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new viewpatient().setVisible(true);
			}
		});
		label_10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_10.setOpaque(true);
		label_10.setBackground(Color.DARK_GRAY);
		label_10.setBounds(547, 351, 153, 105);
		contentPane.add(label_10);
	}
}
