import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField tf1;
	private JPasswordField tf2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 279);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb1 = new JLabel("UserName");
		lb1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lb1.setBounds(51, 62, 92, 20);
		contentPane.add(lb1);
		
		JLabel lb2 = new JLabel("Password");
		lb2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lb2.setBounds(51, 109, 92, 20);
		contentPane.add(lb2);
		
		tf1 = new JTextField();
		tf1.setBounds(202, 64, 86, 20);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JPasswordField();
		tf2.setBounds(202, 111, 86, 18);
		contentPane.add(tf2);
	}
}
