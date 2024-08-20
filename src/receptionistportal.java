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


public class receptionistportal extends JFrame {

	private JPanel contentPane;
	String name="Beauty";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					receptionistportal frame = new receptionistportal();
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
	public receptionistportal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(1030, 589));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		lblWelcome.setBounds(58, 271, 137, 35);
		contentPane.add(lblWelcome);
		
		JLabel label = new JLabel("To");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setOpaque(true);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBackground(new Color(0, 128, 128));
		label.setBounds(70, 309, 109, 35);
		contentPane.add(label);
		
		JLabel lblLoginPortal = new JLabel("Receptionist Portal");
		lblLoginPortal.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginPortal.setOpaque(true);
		lblLoginPortal.setForeground(Color.WHITE);
		lblLoginPortal.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLoginPortal.setBackground(new Color(0, 128, 128));
		lblLoginPortal.setBounds(21, 345, 211, 35);
		contentPane.add(lblLoginPortal);
		
		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setBackground(new Color(0, 128, 128));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBounds(0, 190, 252, 284);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Receptionist Portal");
		lblNewLabel.setBounds(0, 36, 1014, 67);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(new Color(0, 128, 128));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		contentPane.add(lblNewLabel);
		
		JLabel lblPatient = new JLabel("Add Patient");
		lblPatient.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPatient.setForeground(Color.WHITE);
		lblPatient.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatient.setBackground(new Color(0, 128, 128));
		lblPatient.setBounds(315, 262, 153, 25);
		contentPane.add(lblPatient);
		
		JLabel updatepatient = new JLabel("Update patient");
		updatepatient.setHorizontalAlignment(SwingConstants.CENTER);
		updatepatient.setForeground(Color.WHITE);
		updatepatient.setFont(new Font("Tahoma", Font.BOLD, 20));
		updatepatient.setBackground(new Color(0, 128, 128));
		updatepatient.setBounds(540, 262, 153, 25);
		contentPane.add(updatepatient);
		
		JLabel lblAppointment = new JLabel("Set Appointment");
		lblAppointment.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppointment.setForeground(Color.WHITE);
		lblAppointment.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAppointment.setBackground(new Color(0, 128, 128));
		lblAppointment.setBounds(761, 262, 153, 25);
		contentPane.add(lblAppointment);
		
		JLabel lblPrescription = new JLabel("View Prescription");
		lblPrescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrescription.setForeground(Color.WHITE);
		lblPrescription.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPrescription.setBackground(new Color(0, 128, 128));
		lblPrescription.setBounds(317, 413, 153, 25);
		contentPane.add(lblPrescription);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("Icon\\addpatient.png"));
		lblNewLabel_4.setBounds(367, 211, 48, 44);
		contentPane.add(lblNewLabel_4);
		
		JLabel label_3 = new JLabel(new ImageIcon("Icon\\updatepatient.png"));
		label_3.setBounds(594, 211, 48, 44);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel(new ImageIcon("Icon\\appointment.png"));
		label_4.setBounds(815, 211, 48, 44);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel(new ImageIcon("Icon\\prescription.png"));
		label_5.setBounds(371, 362, 48, 44);
		contentPane.add(label_5);
		
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
		lblNewLabel_3.setBounds(315, 196, 153, 105);
		contentPane.add(lblNewLabel_3);
		
		JLabel label_1 = new JLabel("");
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new updatepatient(name).setVisible(true);
			}
		});
		label_1.setOpaque(true);
		label_1.setBackground(Color.DARK_GRAY);
		label_1.setBounds(540, 196, 153, 105);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new setappointment().setVisible(true);
			}
		});
		label_2.setOpaque(true);
		label_2.setBackground(Color.DARK_GRAY);
		label_2.setBounds(761, 196, 153, 105);
		contentPane.add(label_2);
		
		JLabel label_6 = new JLabel("");
		label_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new viewprescription().setVisible(true);
			}
		});
		label_6.setOpaque(true);
		label_6.setBackground(Color.DARK_GRAY);
		label_6.setBounds(317, 347, 153, 105);
		contentPane.add(label_6);
	}

}
