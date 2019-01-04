package Football_Manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	Connection connection = null;
	private JTextField textFieldUN;
	private JPasswordField passwordField;

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
		connection = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setBackground(new Color(255, 255, 255));
		lblUsername.setForeground(new Color(0, 0, 0));
		lblUsername.setFont(new Font("Valken", Font.BOLD, 18));
		lblUsername.setBounds(153, 108, 136, 41);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setFont(new Font("Valken", Font.BOLD, 18));
		lblPassword.setBounds(153, 169, 122, 41);
		contentPane.add(lblPassword);
		
		textFieldUN = new JTextField();
		textFieldUN.setBounds(321, 113, 147, 37);
		contentPane.add(textFieldUN);
		textFieldUN.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(321, 174, 147, 37);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setFont(new Font("Valken", Font.BOLD, 18));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try 
				{
					String query = "select * from Login where Username = ? and Password = ? ";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textFieldUN.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs = pst.executeQuery();
					
					int count = 0;
					while(rs.next())
					{
						count++;
					}
					
					if(count == 1)
					{
						JOptionPane.showMessageDialog(null, "Username and Password is correct");
					}
					else if(count > 1)
					{
						JOptionPane.showMessageDialog(null, "Duplicate Username and Password");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Username and Password is worng try again...");
					}
					
					rs.close();
					pst.close();
					
				}catch(Exception a)
				{
					JOptionPane.showMessageDialog(null, a);
					
				}
				
					
			}
		});
		btnLogin.setBounds(395, 274, 154, 52);
		contentPane.add(btnLogin);
		
		JLabel lblCarrerMode = new JLabel("Carrer Mode");
		lblCarrerMode.setForeground(new Color(0, 0, 0));
		lblCarrerMode.setFont(new Font("Stencil", Font.BOLD, 37));
		lblCarrerMode.setBounds(153, 22, 293, 59);
		contentPane.add(lblCarrerMode);
	}

}
