package Football_Manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;

public class New_Manager extends JFrame {

	private JPanel contentPane;
	Connection connection = null;
	private JTextField textFieldUN;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textFieldFN;
	private JTextField textFieldLN;
	Date date = new Date();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					New_Manager frame = new New_Manager();
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
	public New_Manager() {
		connection = sqliteConnection.dbConnector(); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New Manager Carrer");
		lblNewLabel.setBounds(235, 30, 125, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblPleaseEnterYour = new JLabel("Please Enter Your Details :");
		lblPleaseEnterYour.setBounds(110, 98, 168, 35);
		contentPane.add(lblPleaseEnterYour);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(132, 143, 80, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(132, 182, 80, 27);
		contentPane.add(lblPassword);
		
		textFieldUN = new JTextField();
		textFieldUN.setBounds(264, 147, 96, 19);
		contentPane.add(textFieldUN);
		textFieldUN.setColumns(10);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int count = 0;
				try 
				{
					String qu = "select * from Login where Username = ?";
					PreparedStatement ps = connection.prepareStatement(qu);
					ps.setString(1, textFieldUN.getText());
					ResultSet rs = ps.executeQuery();
					
					while(rs.next())
					{
						count++;
					}
					
					if(count == 0)
					{
						rs.close();
						if(textFieldUN.getText().length() >= 4)
						{
							if(passwordField.getText().length() >= 6)
							{
								if(passwordField.getText().equals(passwordField_1.getText()))
								{
									String query = "insert into Login (Username, Password, First_Name, Last_Name) values (?,?,?,?)";
									PreparedStatement pst = connection.prepareStatement(query);
									pst.setString(1, textFieldUN.getText());
									pst.setString(2, passwordField.getText());
									pst.setString(3, textFieldFN.getText());
									pst.setString(4, textFieldLN.getText());
									pst.execute();
									pst.close();
									
								
									//JOptionPane.showMessageDialog(null, "Data Saved");
									
									try
									{
										Team team = new Team("Arsenal");
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									try
									{
										Connection connection1 = sqliteConnection.this_game();
										PreparedStatement pst4 = connection1.prepareStatement("CREATE TABLE IF NOT EXISTS Premier_League(Team TEXT,Played INTEGER,Won INTEGER,Drawn INTEGER, Lost INTEGER,Goals_For INTEGER,Goals_Againts INTEGER,Goal_Difference INTEGER,Points INTEGER,Form TEXT)");
										pst4.executeUpdate();
										pst4.close();
										for(int i = 0;i<20;i++)
										{
											String query5 = "insert into Premier_League(Team ,Played,Won,Drawn, Lost,Goals_For,Goals_Againts,Goal_Difference,Points,Form) values (?,?,?,?,?,?,?,?,?,?)";
											PreparedStatement pst5 = connection1.prepareStatement(query5);
											if(i == 0)
											{
												pst5.setString(1, "Arsenal");
											}
											else if (i == 1)
											{
												pst5.setString(1, "AFC Bournemouth");
											}
											else if (i == 2)
											{
												pst5.setString(1, "Brighton Albion");
											}
											else if (i == 3)
											{
												pst5.setString(1, "Burnley");
											}
											else if (i == 4)
											{
												pst5.setString(1, "Cardiff City");
											}
											else if (i == 5)
											{
												pst5.setString(1, "Chelsea");
											}
											else if (i == 6)
											{
												pst5.setString(1, "Crystal Palace");
											}
											else if (i == 7)
											{
												pst5.setString(1, "Everton");
											}
											else if (i == 8)
											{
												pst5.setString(1, "Fulhan");
											}
											else if (i == 9)
											{
												pst5.setString(1, "Huddersfield Town");
											}
											else if (i == 10)
											{
												pst5.setString(1, "Leiceser City");
											}
											else if (i == 11)
											{
												pst5.setString(1, "Liverpool");
											}
											else if (i == 12)
											{
												pst5.setString(1, "Manchester City");
											}
											else if (i == 13)
											{
												pst5.setString(1, "Manchester United");
											}
											else if (i == 14)
											{
												pst5.setString(1, "Newcastle United");
											}
											else if (i == 15)
											{
												pst5.setString(1, "Southampton");
											}
											else if (i == 16)
											{
												pst5.setString(1, "Tottenham");
											}
											else if (i == 17)
											{
												pst5.setString(1, "Watford");
											}
											else if (i == 18)
											{
												pst5.setString(1, "West Ham United");
											}
											else if (i == 19)
											{
												pst5.setString(1, "Wolves");
											}
											pst5.setInt(2, 0);
											pst5.setInt(3, 0);
											pst5.setInt(4, 0);
											pst5.setInt(5, 0);
											pst5.setInt(6, 0);
											pst5.setInt(7, 0);
											pst5.setInt(8, 0);
											pst5.setInt(9, 0);
											pst5.setString(10, "D D D D D");
											pst5.execute();
											pst5.close();
										}
									} catch (SQLException e1) 
									{
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
											
					                JComponent comp = (JComponent) e.getSource();
					                Window win = SwingUtilities.getWindowAncestor(comp);
					                win.dispose();
									Team_Pick tp = new Team_Pick(date);
									tp.setVisible(true);
								}
								else 
								{
									JOptionPane.showMessageDialog(null, "Passwords dont match");
									textFieldUN.setText("");
									passwordField.setText("");
									passwordField_1.setText("");
									textFieldFN.setText("");
									textFieldLN.setText("");
								}
							
							}
							else 
							{
								JOptionPane.showMessageDialog(null, "The password is too short please enter 6 characters or more");
								textFieldUN.setText("");
								passwordField.setText("");
								passwordField_1.setText("");
								textFieldFN.setText("");
								textFieldLN.setText("");
							}	
						}
						else 
						{
							JOptionPane.showMessageDialog(null, "The username is too short please enter 4 characters or more");
							textFieldUN.setText("");
							passwordField.setText("");
							passwordField_1.setText("");
							textFieldFN.setText("");
							textFieldLN.setText("");
						}
					}
					else
					{
						rs.close();
						JOptionPane.showMessageDialog(null, "Username exsist try again");
						textFieldUN.setText("");
						passwordField.setText("");
						passwordField_1.setText("");
						textFieldFN.setText("");
						textFieldLN.setText("");
					}
					
					
					
				} catch (Exception a)
				{
					a.printStackTrace();
				}
			}
		});
		btnNext.setBounds(216, 374, 85, 21);
		contentPane.add(btnNext);
		
		JLabel lblPasswordAgain = new JLabel("Password again");
		lblPasswordAgain.setBounds(132, 231, 109, 19);
		contentPane.add(lblPasswordAgain);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(264, 186, 96, 19);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(264, 231, 96, 19);
		contentPane.add(passwordField_1);
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setBounds(132, 272, 80, 27);
		contentPane.add(lblFirstName);
		
		textFieldFN = new JTextField();
		textFieldFN.setBounds(264, 276, 96, 19);
		contentPane.add(textFieldFN);
		textFieldFN.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setBounds(132, 309, 80, 29);
		contentPane.add(lblLastName);
		
		textFieldLN = new JTextField();
		textFieldLN.setBounds(264, 314, 96, 19);
		contentPane.add(textFieldLN);
		textFieldLN.setColumns(10);
	}
}
