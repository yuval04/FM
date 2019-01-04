package Football_Manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Home_Page extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Connection connection = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Date date = new Date();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home_Page frame = new Home_Page("",date);
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
	public Home_Page(String team,Date date) {
		date.increase();
		connection = sqliteConnection.this_game();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		switch (team) 
		{
		case "Arsenal":
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Yuval_David\\Desktop\\יובל\\פרוייקט מנגר\\icons\\arsenal.png"));
			break;

		default:
			break;
		}
		lblNewLabel.setBounds(26, 22, 128, 128);
		contentPane.add(lblNewLabel);
		
		try 
		{
			JButton btnNewButton = new JButton("Squad");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{
					JComponent comp = (JComponent) e.getSource();
	                Window win = SwingUtilities.getWindowAncestor(comp);
	                win.dispose();
					Squad tp = new Squad(team, date);
					tp.setVisible(true);
				}
			});
			btnNewButton.setBounds(0, 236, 118, 50);
			contentPane.add(btnNewButton);
			
			JButton btnTactics = new JButton("Tactics");
			btnTactics.setBounds(0, 340, 118, 50);
			contentPane.add(btnTactics);
			
			JButton btnSchedule = new JButton("Schedule");
			btnSchedule.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnSchedule.setBounds(0, 439, 118, 50);
			contentPane.add(btnSchedule);
			
			JButton btnProfile = new JButton("Profile");
			btnProfile.setBounds(0, 543, 118, 50);
			contentPane.add(btnProfile);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(186, 324, 988, 347);
			contentPane.add(scrollPane);
			
			table = new JTable();
			scrollPane.setViewportView(table);
			PreparedStatement pst = connection.prepareStatement("SELECT * FROM Premier_League ORDER BY Points DESC,Team ASC");
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(Choose_logo(1)));
			lblNewLabel_1.setBounds(170, 344, 16, 16);
			contentPane.add(lblNewLabel_1);
			
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(Choose_logo(2)));
			label.setBounds(170, 361, 16, 16);
			contentPane.add(label);
			
			JButton btnNext = new JButton("Next");
			btnNext.setBounds(1016, 74, 118, 50);
			contentPane.add(btnNext);
			
			JLabel lblNextMatch = new JLabel("Next Match :");
			lblNextMatch.setBounds(327, 22, 128, 29);
			contentPane.add(lblNextMatch);
			
			JLabel lblDate = new JLabel("Date :");
			lblDate.setBounds(1020, 22, 100, 29);
			contentPane.add(lblDate);
			
			JLabel label_1 = new JLabel("");
			label_1.setBounds(1069, 26, 74, 21);
			contentPane.add(label_1);
			label_1.setText(date.make_text());;
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	String Choose_logo(int row)
	{
		try 
		{
			PreparedStatement pst1 = connection.prepareStatement("CREATE VIEW IF NOT EXISTS Premier_League1 AS SELECT(Team) FROM Premier_League ORDER BY Points DESC,Team ASC");
			pst1.executeUpdate();
			PreparedStatement pst5 = connection.prepareStatement("SELECT Team FROM Premier_League1");
			ResultSet rs5 = pst5.executeQuery();
			for(int i = 0;i<row;i++)
			{
				rs5.next();
			}
			if(rs5.getString(1).equals("AFC Bournemouth"))
			{
				return "C:\\Users\\Yuval_David\\Desktop\\יובל\\פרוייקט מנגר\\icons\\bournemouth2.png";
			}
			else if(rs5.getString(1).equals("Arsenal"))
			{
				return "C:\\Users\\Yuval_David\\Desktop\\יובל\\פרוייקט מנגר\\icons\\arsenal2.png";
			}
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return "";
	}
}
