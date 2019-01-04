package Football_Manager;


import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Label;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Start_Manu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start_Manu window = new Start_Manu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Start_Manu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Image img = new ImageIcon(this.getClass().getResource("/start1.png")).getImage();
		
		JLabel lblFootballManager = new JLabel("Football Manager");
		lblFootballManager.setForeground(new Color(255, 0, 0));
		lblFootballManager.setFont(new Font("Snowdrift", Font.ITALIC, 47));
		lblFootballManager.setBounds(109, 44, 447, 94);
		frame.getContentPane().add(lblFootballManager);
		
		JButton btnNewCarrer = new JButton("New Carrer");
		btnNewCarrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
				New_Manager nm = new New_Manager();
				nm.setVisible(true);
			}
		});
		btnNewCarrer.setFont(new Font("Valken", Font.BOLD, 18));
		btnNewCarrer.setBounds(56, 148, 158, 41);
		frame.getContentPane().add(btnNewCarrer);
		
		JButton btnLoadCarrer = new JButton("Load Carrer");
		btnLoadCarrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
				Login login = new Login();
				login.setVisible(true);
			}
		});
		btnLoadCarrer.setFont(new Font("Valken", Font.BOLD, 18));
		btnLoadCarrer.setBounds(56, 221, 158, 41);
		frame.getContentPane().add(btnLoadCarrer);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\\u05D9\u05D5\u05D1\u05DC\\Desktop\\icons\\start1.png"));
		lblNewLabel.setBounds(0, 0, 608, 441);
		frame.getContentPane().add(lblNewLabel);
	}

}
