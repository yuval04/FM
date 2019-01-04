package Football_Manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Arsenal extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Connection connection = null;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Date date = new Date();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Arsenal frame = new Arsenal(date);
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
	public Arsenal(Date date) {
		connection = sqliteConnection.this_game();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 100, 1105, 362);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		try 
		{
			PreparedStatement pst = connection.prepareStatement("SELECT * FROM Arsenal");
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			table_1 = new JTable();
			table_1.setBounds(40, 460, 1105, 70);
			contentPane.add(table_1);
		try 
		{
			PreparedStatement pst1 = connection.prepareStatement("SELECT * FROM Arsenal2");
			ResultSet rs1 = pst1.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(rs1));
			
			JButton btnNext = new JButton("next");
			btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					JComponent comp = (JComponent) e.getSource();
	                Window win = SwingUtilities.getWindowAncestor(comp);
	                win.dispose();
					Home_Page tp = new Home_Page("Arsenal",date);
					tp.setVisible(true);
				}
			});
			btnNext.setBounds(998, 626, 85, 21);
			contentPane.add(btnNext);
			
			JButton btnPrevios = new JButton("previos");
			btnPrevios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{
					JComponent comp = (JComponent) e.getSource();
	                Window win = SwingUtilities.getWindowAncestor(comp);
	                win.dispose();
					Team_Pick tp = new Team_Pick(date);
					tp.setVisible(true);
				}
			});
			btnPrevios.setBounds(118, 626, 85, 21);
			contentPane.add(btnPrevios);
			
			
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
