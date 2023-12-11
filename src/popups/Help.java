package popups;

import java.awt.EventQueue;

import javax.swing.JFrame;
import keeptoo.KGradientPanel;
import login.Login;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class Help extends Login{

	private JFrame frameHelp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Help window = new Help();
					window.frameHelp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Help() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameHelp = new JFrame();
		frameHelp.setUndecorated(true);
		frameHelp.setBounds(100, 100, 388, 291);
		frameHelp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameHelp.getContentPane().setLayout(null);
		
		KGradientPanel gradientPanel = new KGradientPanel();
		gradientPanel.setkStartColor(new Color(0, 184, 166));
		gradientPanel.setkEndColor(new Color(0, 65, 102));
		gradientPanel.setBounds(0, 0, 388, 304);
		frameHelp.getContentPane().add(gradientPanel);
		gradientPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(53, 74, 84));
		panel.setBounds(10, 46, 368, 232);
		gradientPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin :");
		lblNewLabel.setForeground(new Color(154, 235, 188));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblNewLabel.setBounds(29, 35, 93, 46);
		panel.add(lblNewLabel);
		
		JLabel lblIt = new JLabel("admin");
		lblIt.setForeground(Color.WHITE);
		lblIt.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblIt.setBounds(270, 25, 61, 40);
		panel.add(lblIt);
		
		JLabel lblIt_4 = new JLabel("admin");
		lblIt_4.setForeground(Color.WHITE);
		lblIt_4.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblIt_4.setBounds(270, 65, 61, 40);
		panel.add(lblIt_4);
		
		JLabel lblDewarathnePS_1_1 = new JLabel("Username     >>");
		lblDewarathnePS_1_1.setForeground(Color.WHITE);
		lblDewarathnePS_1_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblDewarathnePS_1_1.setBounds(140, 25, 126, 40);
		panel.add(lblDewarathnePS_1_1);
		
		JLabel lblHasaraMK_1_1 = new JLabel("Password       >>");
		lblHasaraMK_1_1.setForeground(Color.WHITE);
		lblHasaraMK_1_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblHasaraMK_1_1.setBounds(140, 65, 126, 40);
		panel.add(lblHasaraMK_1_1);
		
		JLabel lblCashier = new JLabel("User :");
		lblCashier.setForeground(new Color(154, 235, 188));
		lblCashier.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblCashier.setBounds(56, 132, 66, 46);
		panel.add(lblCashier);
		
		JLabel lblDewarathnePS_1_1_2 = new JLabel("Username     >>");
		lblDewarathnePS_1_1_2.setForeground(Color.WHITE);
		lblDewarathnePS_1_1_2.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblDewarathnePS_1_1_2.setBounds(140, 116, 126, 40);
		panel.add(lblDewarathnePS_1_1_2);
		
		JLabel lblHasaraMK_1_1_1 = new JLabel("Password       >>");
		lblHasaraMK_1_1_1.setForeground(Color.WHITE);
		lblHasaraMK_1_1_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblHasaraMK_1_1_1.setBounds(140, 156, 126, 40);
		panel.add(lblHasaraMK_1_1_1);
		
		JLabel lblIt_4_1 = new JLabel("user");
		lblIt_4_1.setForeground(Color.WHITE);
		lblIt_4_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblIt_4_1.setBounds(270, 156, 61, 40);
		panel.add(lblIt_4_1);
		
		JLabel lblUser = new JLabel("user");
		lblUser.setForeground(Color.WHITE);
		lblUser.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblUser.setBounds(270, 116, 61, 40);
		panel.add(lblUser);
		
		JButton closeBtn = new JButton("");
		closeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				closeBtn.setBorder(new LineBorder(new Color(255, 100, 100), 68, true));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				closeBtn.setBorder(new LineBorder(new Color(255, 28, 28), 68, true));
			}
		});
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameHelp.setVisible(false);
			}
		});
		closeBtn.setToolTipText("Close");
		closeBtn.setFocusable(false);
		closeBtn.setFocusTraversalKeysEnabled(false);
		closeBtn.setContentAreaFilled(false);
		closeBtn.setBorder(new LineBorder(new Color(255, 28, 28), 68, true));
		closeBtn.setBounds(356, 15, 18, 18);
		gradientPanel.add(closeBtn);
		
		JPanel movePanel = new JPanel();
		movePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		movePanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				frameHelp.setLocation(frameHelp.getX() + e.getX() - mouseX, frameHelp.getY() + e.getY() - mouseY);
			}
		});
		movePanel.setOpaque(false);
		movePanel.setFocusable(false);
		movePanel.setBorder(null);
		movePanel.setBounds(0, 0, 388, 48);
		gradientPanel.add(movePanel);
		
		JLabel lblDewarathnePS_1_1_1 = new JLabel("Help");
		lblDewarathnePS_1_1_1.setForeground(Color.WHITE);
		lblDewarathnePS_1_1_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblDewarathnePS_1_1_1.setBounds(24, 0, 59, 48);
		gradientPanel.add(lblDewarathnePS_1_1_1);
	}
}
