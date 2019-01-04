package Football_Manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Squad extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	Connection connection = null;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Date date = new Date();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Squad frame = new Squad("", date);
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
	public Squad(String team, Date date) 
	{
		connection = sqliteConnection.this_game();
		date = date.prev;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		switch (team) 
		{
		case "Arsenal":
			label.setIcon(new ImageIcon("C:\\Users\\\u05D9\u05D5\u05D1\u05DC\\Desktop\\icons\\arsenal.png"));
			break;

		default:
			break;
		}
		label.setBounds(10, 10, 128, 128);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBounds(236, 212, 962, 363);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 962, 342);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table_1 = new JTable();
		table_1.setBounds(236, 568, 962, 75);
		contentPane.add(table_1);
		
		try
		{
			PreparedStatement pst;
			pst = connection.prepareStatement("SELECT * FROM " + team);
			ResultSet rs = pst.executeQuery();
			PreparedStatement pst1 = connection.prepareStatement("SELECT * FROM "+ (team + "2"));
			ResultSet rs1 = pst1.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(rs1));
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
