package login;

import popups.*;
import java.sql.Statement;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import keeptoo.KGradientPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.Cursor;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;
import adminView.AdminPage;
import cashierView.CashierPage;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.MatteBorder;

public class Login{

	public JFrame frameLogin;
	
	public int mouseX;
	public int mouseY;
	
	public static String userID;
	public String userPass;

	public String billNo;
	public double billTotal;
	
	private JTextField usernameTxtF;
	private JPasswordField passwordField;
	
	public String url = "jdbc:mysql://localhost:3306/super_market_management_system";
	public String user = "root";
	public String password = "admin";
	
	Connection con= null;
	Statement st = null;
	ResultSet rs= null;

	protected Window frameAdminPage;

	protected Window frameCashierPage;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frameLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameLogin = new JFrame();
		frameLogin.setBounds(300, 100, 955, 600);
		frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLogin.setUndecorated(true);
		frameLogin.getContentPane().setLayout(null);
		
		KGradientPanel gradientPanel = new KGradientPanel();
		gradientPanel.kStartColor = new Color(0, 196, 156);
		gradientPanel.kEndColor = new Color(1, 151, 194);
		gradientPanel.setkEndColor(new Color(1, 151, 194));
		gradientPanel.setkStartColor(new Color(0, 196, 156));
		gradientPanel.setBounds(0, 0, 967, 600);
		frameLogin.getContentPane().add(gradientPanel);
		gradientPanel.setLayout(null);
		
		JButton btnInfo = new JButton("");
		btnInfo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Info.main(null);
			}
		});
		btnInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnInfo.setIcon(new ImageIcon(Login.class.getResource("/basic/info_c.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnInfo.setIcon(new ImageIcon(Login.class.getResource("/basic/info.png")));
			}
		});
		btnInfo.setIcon(new ImageIcon(Login.class.getResource("/basic/info.png")));
		btnInfo.setOpaque(false);
		btnInfo.setFocusable(false);
		btnInfo.setContentAreaFilled(false);
		btnInfo.setBorderPainted(false);
		btnInfo.setBounds(58, 540, 50, 50);
		gradientPanel.add(btnInfo);
		
		JButton btnHelp = new JButton("");
		btnHelp.setBounds(10, 540, 50, 50);
		gradientPanel.add(btnHelp);
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Help.main(null);
			}
		});
		btnHelp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHelp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnHelp.setIcon(new ImageIcon(Login.class.getResource("/basic/help coloured.png")));
				}
			@Override
			public void mouseExited(MouseEvent e) {
				btnHelp.setIcon(new ImageIcon(Login.class.getResource("/basic/help.png")));
			}
		});
		btnHelp.setContentAreaFilled(false);
		btnHelp.setOpaque(false);
		btnHelp.setIcon(new ImageIcon(Login.class.getResource("/basic/help.png")));
		btnHelp.setFocusable(false);
		btnHelp.setBorderPainted(false);
		
		JLabel groceryBag = new JLabel("");
		groceryBag.setBounds(172, 188, 377, 378);
		groceryBag.setIcon(new ImageIcon(Login.class.getResource("/login/login bag s.png")));
		gradientPanel.add(groceryBag);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBounds(453, 27, 479, 549);
		loginPanel.setBorder(null);
		loginPanel.setBackground(new Color(255, 255, 255));
		gradientPanel.add(loginPanel);
		loginPanel.setLayout(null);
		
		JLabel cashierSelected = new JLabel("CASHIER");
		cashierSelected.addMouseListener(new MouseAdapter() {
	
		});
		cashierSelected.setVisible(false);
		cashierSelected.setOpaque(true);
		cashierSelected.setHorizontalAlignment(SwingConstants.CENTER);
		cashierSelected.setForeground(Color.WHITE);
		cashierSelected.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		cashierSelected.setBorder(new LineBorder(new Color(1, 151, 194), 3, true));
		cashierSelected.setBackground(new Color(1, 151, 194));
		cashierSelected.setBounds(242, 117, 182, 38);
		loginPanel.add(cashierSelected);
		
		JLabel adminSelected = new JLabel("ADMIN");
		adminSelected.addMouseListener(new MouseAdapter() {
			
		});
		adminSelected.setVisible(false);
		adminSelected.setOpaque(true);
		adminSelected.setHorizontalAlignment(SwingConstants.CENTER);
		adminSelected.setBackground(new Color(1, 151, 194));
		adminSelected.setForeground(new Color(255, 255, 255));
		adminSelected.setBorder(new LineBorder(new Color(1, 151, 194), 3, true));
		adminSelected.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		adminSelected.setBounds(63, 117, 182, 38);
		loginPanel.add(adminSelected);
		
		JLabel passTxt = new JLabel("PASSWORD");
		passTxt.setForeground(new Color(1, 151, 194));
		passTxt.setFont(new Font("Century Gothic", Font.BOLD, 15));
		passTxt.setBounds(63, 283, 82, 20);
		loginPanel.add(passTxt);
		
		JLabel usernameTxt = new JLabel("USERNAME");
		usernameTxt.setForeground(new Color(1, 151, 194));
		usernameTxt.setFont(new Font("Century Gothic", Font.BOLD, 15));
		usernameTxt.setBounds(63, 190, 79, 20);
		loginPanel.add(usernameTxt);
		
		JLabel loginTxt = new JLabel("LOGIN");
		loginTxt.setForeground(new Color(1, 151, 194));
		loginTxt.setFont(new Font("Century Gothic", Font.BOLD, 40));
		loginTxt.setBounds(179, 35, 126, 50);
		loginPanel.add(loginTxt);
		
		JButton exitBtn = new JButton("EXIT");
		exitBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitBtn.setFocusTraversalKeysEnabled(false);
		exitBtn.setFocusPainted(false);
		exitBtn.setBackground(new Color(255, 255, 255));
		exitBtn.setBorder(new LineBorder(new Color(198, 0, 0), 4, true));
		exitBtn.setFocusable(false);
		exitBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitBtn.setForeground(new Color(255, 255, 255));
				exitBtn.setBackground(new Color(198, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitBtn.setForeground(new Color(198, 0, 0));
				exitBtn.setBackground(new Color(255, 255, 255));
			}
		});
		exitBtn.setToolTipText("");
		exitBtn.setForeground(new Color(198, 0, 0));
		exitBtn.setFont(new Font("Century Gothic", Font.BOLD, 25));
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opt = JOptionPane.showConfirmDialog(null, "Are you sure?", "Exit", JOptionPane.YES_NO_OPTION);
				if (opt == 0) {
					System.exit(0);
				}
				
			}
		});
		exitBtn.setBounds(254, 418, 170, 50);
		loginPanel.add(exitBtn);
		
		JToggleButton toggleCashier = new JToggleButton("CASHIER");
		JToggleButton toggleAdmin = new JToggleButton("ADMIN");
		
		toggleAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				adminSelected.setVisible(true);
				cashierSelected.setVisible(false);
				toggleCashier.setSelected(false);
				
			}
		});
		toggleAdmin.setForeground(new Color(1, 151, 194));
		toggleAdmin.setBackground(new Color(255, 255, 255));
		toggleAdmin.setContentAreaFilled(false);
		toggleAdmin.setOpaque(true);
		toggleAdmin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		toggleAdmin.setBorder(new LineBorder(new Color(1, 151, 194), 3, true));
		toggleAdmin.setFocusable(false);
		toggleAdmin.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		toggleAdmin.setBounds(63, 117, 182, 38);
		loginPanel.add(toggleAdmin);
		
		
		toggleCashier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cashierSelected.setVisible(true);
				adminSelected.setVisible(false);
				toggleAdmin.setSelected(false);
			}
		});
		toggleCashier.setForeground(new Color(1, 151, 194));
		toggleCashier.setBackground(new Color(255, 255, 255));
		toggleCashier.setContentAreaFilled(false);
		toggleCashier.setOpaque(true);
		toggleCashier.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		toggleCashier.setBorder(new LineBorder(new Color(1, 151, 194), 3, true));
		toggleCashier.setFocusable(false);
		toggleCashier.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		toggleCashier.setBounds(242, 117, 182, 38);
		loginPanel.add(toggleCashier);
		
		usernameTxtF = new JTextField();
		usernameTxtF.setForeground(new Color(53, 74, 84));
		usernameTxtF.setFont(new Font("Arial", Font.PLAIN, 20));
		usernameTxtF.setColumns(10);
		usernameTxtF.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(1, 151, 194)));
		usernameTxtF.setBounds(63, 209, 361, 50);
		loginPanel.add(usernameTxtF);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(53, 74, 84));
		passwordField.setFont(new Font("Arial", Font.PLAIN, 20));
		passwordField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(1, 151, 194)));
		passwordField.setBounds(63, 300, 361, 50);
		loginPanel.add(passwordField);
		
/*###############################################################################################################################################
##########################################################       LOGIN BUTTON      ##################################################################
#################################################################################################################################################*/
		
		JButton loginBtn = new JButton("LOGIN");
		loginBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loginBtn.setBackground(new Color(255, 255, 255));
		loginBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				loginBtn.setForeground(new Color(255, 255, 255));
				loginBtn.setBackground(new Color(1, 151, 194));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				loginBtn.setForeground(new Color(1, 151, 194));
				loginBtn.setBackground(new Color(255, 255, 255));
			}
		});
		loginBtn.addActionListener(new ActionListener() {
	    @SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {
			if(toggleCashier.isSelected()==true ) {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						con = DriverManager.getConnection(url, user, password);
						st = con.createStatement();
						userID = usernameTxtF.getText();
						rs = st.executeQuery("Select * from cashier_login where binary Username='"+userID+"' and binary Password='"+passwordField.getText()+"'");
						if(rs.next()) {
							CashierPage.main(null);
							frameLogin.setVisible(false);
								
						}
						else {
							JOptionPane.showMessageDialog(null, "Invalid username or password...");
						}con.close();
						
						} catch (Exception ex) {
							
						}
					}
			 else if(toggleAdmin.isSelected()==true){
				 try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection(url, user, password);
					st = con.createStatement();
					userID = usernameTxtF.getText();
					rs = st.executeQuery("Select * from admin_login where binary Username='"+userID+"' and binary Password='"+passwordField.getText()+"'");
					if(rs.next()) {
						AdminPage.main(null);
						frameLogin.setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(null, "Invalid username or password...");
					}con.close();
				
				} catch (Exception ex) {
					
				}
					}
			 else {
				JOptionPane.showMessageDialog(null, "Please select the Role...");
			 }}
			}
			
		);
		loginBtn.setForeground(new Color(1, 151, 194));
		loginBtn.setBorder(new LineBorder(new Color(1, 151, 194), 4, true));
		loginBtn.setFocusTraversalKeysEnabled(false);
		loginBtn.setFocusPainted(false);
		loginBtn.setFocusable(false);
		loginBtn.setFont(new Font("Century Gothic", Font.BOLD, 25));
		loginBtn.setBounds(63, 418, 170, 50);
		loginPanel.add(loginBtn);
		
		JLabel welcome = new JLabel("WELCOME\r\n");
		welcome.setBounds(39, 66, 229, 50);
		welcome.setForeground(new Color(255, 255, 255));
		welcome.setFont(new Font("Century Gothic", Font.BOLD, 40));
		gradientPanel.add(welcome);
		
		JLabel to = new JLabel("TO\r\n");
		to.setBounds(39, 102, 69, 55);
		to.setForeground(Color.WHITE);
		to.setFont(new Font("Century Gothic", Font.BOLD, 40));
		gradientPanel.add(to);
		
		JLabel StarMarket = new JLabel("STAR MARKET");
		StarMarket.setBounds(36, 135, 420, 92);
		StarMarket.setForeground(Color.WHITE);
		StarMarket.setFont(new Font("Century Gothic", Font.BOLD, 55));
		gradientPanel.add(StarMarket);
		
		JPanel movePanel = new JPanel();
		movePanel.setBounds(0, 0, 957, 600);
		gradientPanel.add(movePanel);
		movePanel.setOpaque(false);
		movePanel.setFocusable(false);
		movePanel.setBorder(null);
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
				frameLogin.setLocation(frameLogin.getX() + e.getX() - mouseX, frameLogin.getY() + e.getY() - mouseY);
			}
		});
		
		JLabel star = new JLabel("");
		star.setBounds(-291, 112, 727, 488);
		star.setIcon(new ImageIcon(Login.class.getResource("/main/star2.png")));
		gradientPanel.add(star);
		
		
		
	}
}