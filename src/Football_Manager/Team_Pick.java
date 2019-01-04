package Football_Manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Team_Pick extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Date date = new Date();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Team_Pick frame = new Team_Pick(date);
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
	public Team_Pick(Date date) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnManchesterUnited = new JButton("Manchester United");
		btnManchesterUnited.setBounds(248, 100, 131, 36);
		contentPane.add(btnManchesterUnited);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(412, 100, 131, 36);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("New button");
		button.setBounds(248, 170, 131, 36);
		contentPane.add(button);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(89, 300, 131, 36);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("New button");
		button_2.setBounds(248, 237, 131, 36);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("New button");
		button_3.setBounds(412, 170, 131, 36);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("New button");
		button_4.setBounds(412, 237, 131, 36);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("New button");
		button_5.setBounds(248, 364, 131, 36);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("New button");
		button_6.setBounds(587, 100, 131, 36);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("New button");
		button_7.setBounds(587, 170, 131, 36);
		contentPane.add(button_7);
		
		JButton button_8 = new JButton("New button");
		button_8.setBounds(587, 300, 131, 36);
		contentPane.add(button_8);
		
		JButton button_9 = new JButton("New button");
		button_9.setBounds(587, 237, 131, 36);
		contentPane.add(button_9);
		
		JButton button_10 = new JButton("New button");
		button_10.setBounds(248, 300, 131, 36);
		contentPane.add(button_10);
		
		JButton button_11 = new JButton("New button");
		button_11.setBounds(412, 300, 131, 36);
		contentPane.add(button_11);
		
		JButton button_12 = new JButton("New button");
		button_12.setBounds(89, 364, 131, 36);
		contentPane.add(button_12);
		
		JButton button_13 = new JButton("New button");
		button_13.setBounds(89, 237, 131, 36);
		contentPane.add(button_13);
		
		JButton btnArsenal = new JButton("Arsenal");
		btnArsenal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();
				Arsenal tp = new Arsenal(date);
				tp.setVisible(true);
			}
		});
		btnArsenal.setBounds(89, 100, 131, 36);
		contentPane.add(btnArsenal);
		
		JButton button_15 = new JButton("New button");
		button_15.setBounds(89, 170, 131, 36);
		contentPane.add(button_15);
		
		JButton button_16 = new JButton("New button");
		button_16.setBounds(412, 364, 131, 36);
		contentPane.add(button_16);
		
		JButton button_17 = new JButton("New button");
		button_17.setBounds(587, 364, 131, 36);
		contentPane.add(button_17);
	}
}
