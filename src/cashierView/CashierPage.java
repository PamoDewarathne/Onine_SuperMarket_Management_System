package cashierView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import keeptoo.KGradientPanel;
import login.Login;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import javax.swing.border.LineBorder;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.ComponentOrientation;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import java.awt.Cursor;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

public class CashierPage extends Login{

	private JFrame frameCashierPage;
	private JTable tableM;
	private JTable tableV;
	private JTable tableS;
	private JTable tableB;
	private JTable tableH;
	private JTable tableJ;
	private JTextField textPIDCart;
	private JTextField textNameCart;
	private JTextField textQtyCart;
	private JTable tableBills;
	private JTable tableProducts;
	private JTextField searchField;
	private JTextField textStock;
	private JTextField textPaymnt;
	private JTable tableSales;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CashierPage window = new CashierPage();
					window.frameCashierPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CashierPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameCashierPage = new JFrame();
		frameCashierPage.getContentPane().setBackground(new Color(255, 255, 255));
		frameCashierPage.getContentPane().setLayout(null);;
		
		//adding a close button
		JButton closeBtn = new JButton("");
		closeBtn.setToolTipText("Close");
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Opt = JOptionPane.showConfirmDialog(null,"Are you sure?", "Exit", JOptionPane.YES_NO_OPTION);
				if (Opt == 0) {
					System.exit(0);
			}}}
		);
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
		closeBtn.setContentAreaFilled(false);
		closeBtn.setBorder(new LineBorder(new Color(255, 28, 28), 68, true));
		closeBtn.setFocusTraversalKeysEnabled(false);
		closeBtn.setFocusable(false);
		closeBtn.setBounds(1259, 10, 18, 18);
		frameCashierPage.getContentPane().add(closeBtn);
		
		//adding a minimize button
		JButton minimizeBtn = new JButton("");
		minimizeBtn.setToolTipText("Minimize");
		minimizeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				minimizeBtn.setBorder(new LineBorder(new Color(255, 230, 69), 68, true));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				minimizeBtn.setBorder(new LineBorder(new Color(215, 188, 0), 68, true));
			}
		});
		minimizeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameCashierPage.setExtendedState(Frame.ICONIFIED);
			}
		});
		minimizeBtn.setFocusable(false);
		minimizeBtn.setFocusTraversalKeysEnabled(false);
		minimizeBtn.setContentAreaFilled(false);
		minimizeBtn.setBorder(new LineBorder(new Color(215, 188, 0), 68, true));
		minimizeBtn.setBounds(1236, 10, 18, 18);
		frameCashierPage.getContentPane().add(minimizeBtn);
		
		JLabel lblTotalBill = new JLabel("Rs. 0.00");
		JLabel lblTotalNo = new JLabel("Rs. 0.00");
		JTabbedPane productTbls = new JTabbedPane(JTabbedPane.TOP);

/*
 * ###############################################################################################################################################################
 * ##########################################################              TITLE PANEL           #################################################################
 * ###############################################################################################################################################################
 * */

		KGradientPanel titlePanel = new KGradientPanel();
		titlePanel.kStartColor = new Color(0, 184, 166);
		titlePanel.setkStartColor(new Color(0, 184, 166));
		titlePanel.kEndColor = new Color(53, 74, 84);
		titlePanel.setkEndColor(new Color(53, 74, 84));
		titlePanel.setBorder(null);
		titlePanel.setBounds(273, 0, 1026, 263);
		frameCashierPage.getContentPane().add(titlePanel);
		titlePanel.setLayout(null);
		
//######################################## MOVE PANEL >
		JPanel movePanel_1 = new JPanel();
		movePanel_1.setOpaque(false);
		movePanel_1.setFocusable(false);
		movePanel_1.setBorder(null);
		movePanel_1.setBounds(0, 0, 1016, 109);
		movePanel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		movePanel_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				frameCashierPage.setLocation(frameCashierPage.getX() + e.getX() - mouseX, frameCashierPage.getY() + e.getY() - mouseY);
			}
		});
		
		
//###################################################################### SEARCH BOX ###############################################
		JPanel panelSearch = new JPanel();
		panelSearch.setVisible(false);
		panelSearch.setBackground(new Color(255, 255, 255));
		panelSearch.setBorder(new LineBorder(new Color(0, 184, 166), 3, true));
		panelSearch.setBounds(579, 28, 337, 45);
		titlePanel.add(panelSearch);
		panelSearch.setLayout(null);
		
		JButton btnSearch = new JButton("");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PreparedStatement pstSnack, pstVege, pstMeat, pstJuices, pstHware, pstBpicks;
					Connection connection = DriverManager.getConnection(url, user, password);
					String PID = searchField.getText();
					
					pstSnack = connection.prepareStatement("select * from product_snacks where S_ID = '"+PID+"'");
					ResultSet rSID = pstSnack.executeQuery();
					while (rSID.next())
						productTbls.setSelectedIndex(0);

						
					pstVege = connection.prepareStatement("select * from product_vegetables where V_ID = '"+PID+"'");
					ResultSet rVID = pstVege.executeQuery();
					while (rVID.next())
						productTbls.setSelectedIndex(1);
					
					pstMeat = connection.prepareStatement("select * from product_fmeat where FM_ID = '"+PID+"'");
					ResultSet rMID = pstMeat.executeQuery();
					while (rMID.next())
						productTbls.setSelectedIndex(2);
					
					pstJuices = connection.prepareStatement("select * from product_juice where J_ID = '"+PID+"'");
					ResultSet rJID = pstJuices.executeQuery();
					while (rJID.next())
						productTbls.setSelectedIndex(3);
					
					pstHware = connection.prepareStatement("select * from product_hware where HW_ID = '"+PID+"'");
					ResultSet rHID = pstHware.executeQuery();
					while (rHID.next())
						productTbls.setSelectedIndex(4);
					
					pstBpicks = connection.prepareStatement("select * from product_bpicks where BP_ID = '"+PID+"'");
					ResultSet rBID = pstBpicks.executeQuery();
					while (rBID.next())
						productTbls.setSelectedIndex(5);
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		btnSearch.setIcon(new ImageIcon(CashierPage.class.getResource("/basic/search.png")));
		btnSearch.setFocusable(false);
		btnSearch.setFocusTraversalKeysEnabled(false);
		btnSearch.setFocusPainted(false);
		btnSearch.setContentAreaFilled(false);
		btnSearch.setBorderPainted(false);
		btnSearch.setBounds(0, 0, 45, 45);
		panelSearch.add(btnSearch);
		
		searchField = new JTextField();
		searchField.setForeground(new Color(53, 74, 84));
		searchField.setFont(new Font("Century Gothic", Font.BOLD, 15));
		searchField.setBorder(null);
		searchField.setBounds(45, 10, 282, 25);
		panelSearch.add(searchField);
		searchField.setColumns(10);
		titlePanel.add(movePanel_1);
		
//######################################## TITLE NAMES >
		JLabel title = new JLabel("Home");
		title.setForeground(new Color(255, 255, 255));
		title.setFont(new Font("Century Gothic", Font.BOLD, 40));
		title.setIcon(new ImageIcon(CashierPage.class.getResource("/main/star.png")));
		title.setBounds(10, 0, 428, 109);
		titlePanel.add(title);
		
		JLabel lblWelcomeUser = new JLabel("Welcome, User!");
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			PreparedStatement pst = connection.prepareStatement("select Last_Name from emp_details where username = '"+userID+"'");
			ResultSet rs = pst.executeQuery();
			rs.next();
			String lName = rs.getString(1);
			lblWelcomeUser.setText("Welcome, " + lName);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		lblWelcomeUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWelcomeUser.setForeground(new Color(255, 255, 255));
		lblWelcomeUser.setFont(new Font("Century Gothic", Font.BOLD, 45));
		lblWelcomeUser.setBounds(131, 154, 858, 75);
		titlePanel.add(lblWelcomeUser);
		
		
/*
 * ###############################################################################################################################################################
 * ##########################################################              SIDE PANEL            #################################################################
 * ###############################################################################################################################################################
 * */
		
//######################################################## BUTTON SELECTED STATES >
		KGradientPanel sidePanel = new KGradientPanel();
		sidePanel.setBackground(new Color(0, 184, 166));
		sidePanel.setkStartColor(new Color(0, 196, 156));
		sidePanel.setkEndColor(new Color(1, 151, 194));
		sidePanel.setBounds(0, 0, 275, 668);
		frameCashierPage.getContentPane().add(sidePanel);
		sidePanel.setLayout(null);
		
		JButton btnHomeSelected = new JButton("Home");
		btnHomeSelected.setBorderPainted(false);
		btnHomeSelected.setBackground(new Color(255, 255, 255));
		btnHomeSelected.setForeground(new Color(1, 151, 194));
		btnHomeSelected.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		btnHomeSelected.setFocusable(false);
		btnHomeSelected.setFocusTraversalKeysEnabled(false);
		btnHomeSelected.setFocusPainted(false);
		btnHomeSelected.setBounds(0, 263, 275, 55);
		sidePanel.add(btnHomeSelected);
		
		JButton btnProductsSelected = new JButton("Products");
		btnProductsSelected.setVisible(false);
		btnProductsSelected.setForeground(new Color(1, 151, 194));
		btnProductsSelected.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		btnProductsSelected.setFocusable(false);
		btnProductsSelected.setFocusTraversalKeysEnabled(false);
		btnProductsSelected.setFocusPainted(false);
		btnProductsSelected.setBorderPainted(false);
		btnProductsSelected.setBackground(Color.WHITE);
		btnProductsSelected.setBounds(0, 318, 275, 55);
		sidePanel.add(btnProductsSelected);
		
		JButton btnCartSelected = new JButton("Cart");
		btnCartSelected.setVisible(false);
		btnCartSelected.setForeground(new Color(1, 151, 194));
		btnCartSelected.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		btnCartSelected.setFocusable(false);
		btnCartSelected.setFocusTraversalKeysEnabled(false);
		btnCartSelected.setFocusPainted(false);
		btnCartSelected.setBorderPainted(false);
		btnCartSelected.setBackground(Color.WHITE);
		btnCartSelected.setBounds(0, 373, 275, 55);
		sidePanel.add(btnCartSelected);
		
		JButton btnSalesSelected = new JButton("Sales");
		btnSalesSelected.setVisible(false);
		btnSalesSelected.setForeground(new Color(1, 151, 194));
		btnSalesSelected.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		btnSalesSelected.setFocusable(false);
		btnSalesSelected.setFocusTraversalKeysEnabled(false);
		btnSalesSelected.setFocusPainted(false);
		btnSalesSelected.setBorderPainted(false);
		btnSalesSelected.setBackground(Color.WHITE);
		btnSalesSelected.setBounds(0, 428, 275, 55);
		sidePanel.add(btnSalesSelected);
		
		
		
		JLabel lblUsername = new JLabel("User");
		lblUsername.setText(userID);
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblUsername.setBounds(0, 194, 275, 36);
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		sidePanel.add(lblUsername);


		JTabbedPane sideMenuPages = new JTabbedPane(JTabbedPane.TOP);
		JPanel home = new JPanel();
		JPanel products = new JPanel();
		JPanel Cart = new JPanel();
		JPanel sales = new JPanel();
		sideMenuPages.setBackground(new Color(0,0,0,0));
		

//################################################################## HOME BUTTON 
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sideMenuPages.setSelectedIndex(0);
				title.setText("Home");
				title.setIcon(new ImageIcon(CashierPage.class.getResource("/main/star.png")));
				titlePanel.setBounds(273, 0, 1026, 263);
				btnHomeSelected.setVisible(true);
				btnProductsSelected.setVisible(false);
				btnCartSelected.setVisible(false);
				btnSalesSelected.setVisible(false);
				lblWelcomeUser.setVisible(true);
				panelSearch.setVisible(false);
			}
		});
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnHome.setBackground(new Color(0, 202, 184));
				btnHome.setContentAreaFilled(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnHome.setContentAreaFilled(false);
			}
		});
		btnHome.setFocusPainted(false);
		btnHome.setFocusTraversalKeysEnabled(false);
		btnHome.setFocusable(false);
		btnHome.setForeground(new Color(255, 255, 255));
		btnHome.setContentAreaFilled(false);
		btnHome.setBorderPainted(false);
		btnHome.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		btnHome.setBounds(0, 263, 275, 55);
		sidePanel.add(btnHome);
	

//################################################################## PRODUCTS BUTTON 

		JButton btnProducts = new JButton("Products");
		btnProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sideMenuPages.setSelectedIndex(1);
				title.setText("Products");
				title.setIcon(new ImageIcon(CashierPage.class.getResource("/main/products.png")));
				titlePanel.setBounds(273, 0, 1026, 109);
				btnHomeSelected.setVisible(false);
				btnProductsSelected.setVisible(true);
				btnCartSelected.setVisible(false);
				btnSalesSelected.setVisible(false);
				lblWelcomeUser.setVisible(false);
				panelSearch.setVisible(true);
			}
		});
		btnProducts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnProducts.setBackground(new Color(0, 202, 184));
				btnProducts.setContentAreaFilled(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnProducts.setContentAreaFilled(false);
			}
		});
		btnProducts.setForeground(Color.WHITE);
		btnProducts.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		btnProducts.setFocusable(false);
		btnProducts.setFocusTraversalKeysEnabled(false);
		btnProducts.setFocusPainted(false);
		btnProducts.setContentAreaFilled(false);
		btnProducts.setBorderPainted(false);
		btnProducts.setBounds(0, 318, 275, 55);
		sidePanel.add(btnProducts);
		
		
//################################################################## CART BUTTON 		
		
		JButton btnCart = new JButton("Cart");
		btnCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sideMenuPages.setSelectedIndex(2);
				title.setText("Cart");
				title.setIcon(new ImageIcon(CashierPage.class.getResource("/main/checkout.png")));
				titlePanel.setBounds(273, 0, 1026, 109);
				btnHomeSelected.setVisible(false);
				btnProductsSelected.setVisible(false);
				btnCartSelected.setVisible(true);
				btnSalesSelected.setVisible(false);
				lblWelcomeUser.setVisible(false);
				panelSearch.setVisible(false);
			}
		});
		btnCart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCart.setBackground(new Color(0, 202, 184));
				btnCart.setContentAreaFilled(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCart.setContentAreaFilled(false);
			}
		});
		btnCart.setForeground(Color.WHITE);
		btnCart.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		btnCart.setFocusable(false);
		btnCart.setFocusTraversalKeysEnabled(false);
		btnCart.setFocusPainted(false);
		btnCart.setContentAreaFilled(false);
		btnCart.setBorderPainted(false);
		btnCart.setBounds(0, 373, 275, 55);
		sidePanel.add(btnCart);
		
		
//################################################################## SALES BUTTON 
		
		JButton btnSales = new JButton("Sales");
		btnSales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sideMenuPages.setSelectedIndex(3);
				title.setText("Sales");
				title.setIcon(new ImageIcon(CashierPage.class.getResource("/main/sales.png")));
				titlePanel.setBounds(273, 0, 1026, 109);
				btnHomeSelected.setVisible(false);
				btnProductsSelected.setVisible(false);
				btnCartSelected.setVisible(false);
				btnSalesSelected.setVisible(true);
				lblWelcomeUser.setVisible(false);
				panelSearch.setVisible(false);
			}
		});
		btnSales.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSales.setBackground(new Color(0, 202, 184));
				btnSales.setContentAreaFilled(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSales.setContentAreaFilled(false);
			}
		});
		btnSales.setForeground(Color.WHITE);
		btnSales.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		btnSales.setFocusable(false);
		btnSales.setFocusTraversalKeysEnabled(false);
		btnSales.setFocusPainted(false);
		btnSales.setContentAreaFilled(false);
		btnSales.setBorderPainted(false);
		btnSales.setBounds(0, 428, 275, 55);
		sidePanel.add(btnSales);
		
		JLabel userImg = new JLabel("");
		userImg.setIcon(new ImageIcon(CashierPage.class.getResource("/users/user m.png")));
		userImg.setHorizontalAlignment(SwingConstants.CENTER);
		userImg.setFocusable(false);
		userImg.setBounds(0, 90, 275, 106);
		sidePanel.add(userImg);
		
		JLabel starmarket = new JLabel("STAR MARKET");
		starmarket.setForeground(new Color(255, 255, 255));
		starmarket.setHorizontalAlignment(SwingConstants.CENTER);
		starmarket.setFont(new Font("Century Gothic", Font.BOLD, 25));
		starmarket.setBounds(37, 34, 177, 46);
		sidePanel.add(starmarket);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(CashierPage.class.getResource("/main/star.png")));
		logo.setBounds(164, 10, 101, 118);
		sidePanel.add(logo);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				frameCashierPage.setVisible(false);
			}
		});
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogout.setBackground(new Color(229, 95, 112));
				btnLogout.setContentAreaFilled(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnLogout.setContentAreaFilled(false);
			}
		});
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		btnLogout.setFocusable(false);
		btnLogout.setFocusTraversalKeysEnabled(false);
		btnLogout.setFocusPainted(false);
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBorderPainted(false);
		btnLogout.setBounds(0, 515, 275, 55);
		sidePanel.add(btnLogout);
		
		JLabel star = new JLabel("");
		star.setIcon(new ImageIcon(CashierPage.class.getResource("/main/star3.png")));
		star.setBounds(-291, 112, 565, 488);
		sidePanel.add(star);
		
		sideMenuPages.setBackground(new Color(255, 255, 255));
		sideMenuPages.setFocusable(false);
		sideMenuPages.setFocusTraversalKeysEnabled(false);
		sideMenuPages.setBorder(null);
		sideMenuPages.setBounds(273, 81, 1026, 587);
		frameCashierPage.getContentPane().add(sideMenuPages);
		
		home.setBackground(new Color(255, 255, 255));
		sideMenuPages.addTab("New tab", null, home, null);
		home.setLayout(null);
		
		JPanel movePanel = new JPanel();
		movePanel.setBounds(0, -106, 1011, 109);
		home.add(movePanel);
		movePanel.setOpaque(false);
		movePanel.setFocusable(false);
		movePanel.setBorder(null);
		
/*
 * ###############################################################################################################################################################
 * ##########################################################          HOMEPAGE BUTTONS           ################################################################
 * ###############################################################################################################################################################
 * */
		KGradientPanel salesTab = new KGradientPanel();
		salesTab.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		salesTab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				salesTab.setBounds(35, 185, 300, 350);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				salesTab.setBounds(40, 190, 290, 340);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSales.doClick();
			}
		});
		salesTab.setkEndColor(new Color(0, 65, 102));
		salesTab.setkStartColor(new Color(229, 95, 112));
		salesTab.setBounds(40, 190, 290, 340);
		home.add(salesTab);
		salesTab.setLayout(null);
		
		JLabel lblTotalSales_1 = new JLabel("Total Sales:");
		lblTotalSales_1.setForeground(new Color(255, 255, 255));
		lblTotalSales_1.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblTotalSales_1.setBounds(30, 24, 201, 50);
		salesTab.add(lblTotalSales_1);
		
		JLabel lblTotalNoHome = new JLabel("0.00");
		try {
			PreparedStatement pst;
			Connection connection = DriverManager.getConnection(url, user, password);
			pst = connection.prepareStatement("select sum(Bil_Amount) from bills");
			ResultSet rs = pst.executeQuery();
			rs.next();
			String totalSales = rs.getString(1);
			
			lblTotalNoHome.setText("Rs."+totalSales);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		lblTotalNoHome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalNoHome.setForeground(new Color(0, 221, 199));
		lblTotalNoHome.setFont(new Font("Century Gothic", Font.BOLD, 38));
		lblTotalNoHome.setBounds(30, 84, 236, 91);
		salesTab.add(lblTotalNoHome);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(CashierPage.class.getResource("/side_menu/sales ico.png")));
		lblNewLabel_1.setBounds(95, 180, 96, 123);
		salesTab.add(lblNewLabel_1);
		
		KGradientPanel productsTab = new KGradientPanel();
		productsTab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				productsTab.setBounds(359, 185, 300, 350);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				productsTab.setBounds(364, 190, 290, 340);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				btnProducts.doClick();
			}
		});
		productsTab.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		productsTab.kStartColor = new Color(229, 95, 112);
		productsTab.setkStartColor(new Color(0, 65, 102));
		productsTab.kEndColor = new Color(0, 65, 102);
		productsTab.setkEndColor(new Color(0, 184, 166));
		productsTab.setBounds(364, 190, 290, 340);
		home.add(productsTab);
		productsTab.setLayout(null);
		
		JLabel lblTotalSales_1_1 = new JLabel("View");
		lblTotalSales_1_1.setForeground(Color.WHITE);
		lblTotalSales_1_1.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblTotalSales_1_1.setBounds(30, 24, 106, 50);
		productsTab.add(lblTotalSales_1_1);
		
		JLabel lblTotalSales_1_3 = new JLabel("Products");
		lblTotalSales_1_3.setForeground(Color.WHITE);
		lblTotalSales_1_3.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblTotalSales_1_3.setBounds(30, 65, 179, 50);
		productsTab.add(lblTotalSales_1_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(CashierPage.class.getResource("/side_menu/category.png")));
		lblNewLabel_1_1.setBounds(90, 180, 96, 123);
		productsTab.add(lblNewLabel_1_1);
		
		KGradientPanel empTab = new KGradientPanel();
		empTab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				empTab.setBounds(682, 185, 300, 350);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				empTab.setBounds(687, 190, 290, 340);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				btnCart.doClick();
			}
		});
		empTab.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		empTab.kStartColor = new Color(229, 95, 112);
		empTab.setkStartColor(new Color(154, 79, 149));
		empTab.kEndColor = new Color(0, 65, 102);
		empTab.setkEndColor(new Color(0, 137, 114));
		empTab.setBounds(687, 190, 290, 340);
		home.add(empTab);
		empTab.setLayout(null);
		
		JLabel lblTotalSales_1_2 = new JLabel("Go to");
		lblTotalSales_1_2.setForeground(Color.WHITE);
		lblTotalSales_1_2.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblTotalSales_1_2.setBounds(30, 24, 179, 50);
		empTab.add(lblTotalSales_1_2);
		
		JLabel lblTotalSales_1_4 = new JLabel("Checkout");
		lblTotalSales_1_4.setForeground(Color.WHITE);
		lblTotalSales_1_4.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblTotalSales_1_4.setBounds(30, 65, 179, 50);
		empTab.add(lblTotalSales_1_4);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon(CashierPage.class.getResource("/side_menu/cart.png")));
		lblNewLabel_1_2.setBounds(90, 180, 96, 123);
		empTab.add(lblNewLabel_1_2);
		
		products.setBackground(Color.WHITE);
		sideMenuPages.addTab("New tab", null, products, null);
		products.setLayout(null);
	
		
/*
 * ###############################################################################################################################################################
 * ################################################              PRODUCT TABLES TABBED PANE           ############################################################
 * ###############################################################################################################################################################
 * */
		
		
		productTbls.setOpaque(true);
		productTbls.setRequestFocusEnabled(false);
		productTbls.setForeground(new Color(255, 255, 255));
		productTbls.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		productTbls.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		productTbls.setFocusTraversalKeysEnabled(false);
		productTbls.setFocusable(false);
		productTbls.setBorder(null);
		productTbls.setBackground(new Color(53, 74, 84));
		productTbls.setBounds(-5, 0, 1026, 568);
		products.add(productTbls);
		
		JPanel snacks = new JPanel();
		snacks.setFocusTraversalKeysEnabled(false);
		snacks.setFocusable(false);
		snacks.setBackground(new Color(255, 255, 255));
		productTbls.addTab("Snacks", null, snacks, null);
		snacks.setLayout(null);
		
		JScrollPane scrollPaneS = new JScrollPane();
		scrollPaneS.setBorder(new LineBorder(new Color(185, 17, 17), 3, true));
		scrollPaneS.setBackground(new Color(255, 255, 255));
		scrollPaneS.setForeground(new Color(185, 17, 17));
		scrollPaneS.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		scrollPaneS.setBounds(152, 15, 730, 480);
		snacks.add(scrollPaneS);
		
		tableS = new JTable();
		try {
			PreparedStatement pStatement;
			Connection connection = DriverManager.getConnection(url, user, password);
			pStatement = connection.prepareStatement("select * from product_snacks");
			ResultSet rs = pStatement.executeQuery();
			DefaultTableModel model = (DefaultTableModel) tableS.getModel();
			
			String[] colName = {"PID", "Name", "Quantity", "Price"};
			model.setColumnIdentifiers(colName);
			
			TableColumnModel columnModel = tableS.getColumnModel();
			columnModel.getColumn(0).setPreferredWidth(5);
			columnModel.getColumn(1).setPreferredWidth(200);
			columnModel.getColumn(2).setPreferredWidth(10);
			columnModel.getColumn(3).setPreferredWidth(15);
			
			DefaultTableCellRenderer right = new DefaultTableCellRenderer();
			DefaultTableCellRenderer center = new DefaultTableCellRenderer();
			right.setHorizontalAlignment(JLabel.RIGHT);
			center.setHorizontalAlignment(JLabel.CENTER);
			
			tableS.getColumnModel().getColumn(0).setCellRenderer(center);
			tableS.getColumnModel().getColumn(2).setCellRenderer(center);
			tableS.getColumnModel().getColumn(3).setCellRenderer(right);
			
			while(rs.next()) {
				String[] row = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
				model.addRow(row);
			}
			pStatement.close();
			connection.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		tableS.setForeground(new Color(53, 74, 84));
		tableS.setFont(new Font("Century Gothic", Font.BOLD, 15));
		tableS.setGridColor(new Color(185, 17, 17));
		scrollPaneS.setViewportView(tableS);
		tableS.setRowHeight(35);
		tableS.setBorder(new MatteBorder(3, 0, 0, 0, (Color) new Color(185, 17, 17)));
		productTbls.setBackgroundAt(0, new Color(185, 17, 17));
		
		JPanel vegetables = new JPanel();
		vegetables.setLayout(null);
		vegetables.setFocusable(false);
		vegetables.setFocusTraversalKeysEnabled(false);
		vegetables.setBackground(Color.WHITE);
		productTbls.addTab("Vegetables", null, vegetables, null);
		productTbls.setBackgroundAt(1, new Color(92, 190, 46));
		
		JScrollPane scrollPaneV = new JScrollPane();
		scrollPaneV.setBorder(new LineBorder(new Color(92, 190, 46), 3, true));
		scrollPaneV.setBackground(new Color(255, 255, 255));
		scrollPaneV.setForeground(new Color(53, 74, 84));
		scrollPaneV.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		scrollPaneV.setBounds(152, 15, 730, 480);
		vegetables.add(scrollPaneV);
		
		tableV = new JTable();
		try {
			PreparedStatement pStatement;
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/super_market_management_system", "root", "admin");
			pStatement = connection.prepareStatement("select * from product_vegetables");
			ResultSet rs = pStatement.executeQuery();
			DefaultTableModel model = (DefaultTableModel) tableV.getModel();
			
			String[] colName = {"PID", "Name", "Quantity", "Price"};
			model.setColumnIdentifiers(colName);
			
			TableColumnModel columnModel = tableV.getColumnModel();
			columnModel.getColumn(0).setPreferredWidth(5);
			columnModel.getColumn(1).setPreferredWidth(200);
			columnModel.getColumn(2).setPreferredWidth(10);
			columnModel.getColumn(3).setPreferredWidth(15);
			
			DefaultTableCellRenderer right = new DefaultTableCellRenderer();
			DefaultTableCellRenderer center = new DefaultTableCellRenderer();
			right.setHorizontalAlignment(JLabel.RIGHT);
			center.setHorizontalAlignment(JLabel.CENTER);
			
			tableV.getColumnModel().getColumn(0).setCellRenderer(center);
			tableV.getColumnModel().getColumn(2).setCellRenderer(center);
			tableV.getColumnModel().getColumn(3).setCellRenderer(right);
			
			while(rs.next()) {
				String[] row = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
				model.addRow(row);
			}
			pStatement.close();
			connection.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		tableV.setForeground(new Color(53, 74, 84));
		tableV.setFont(new Font("Century Gothic", Font.BOLD, 15));
		tableV.setGridColor(new Color(92, 190, 46));
		scrollPaneV.setViewportView(tableV);
		tableV.setRowHeight(35);
		tableV.setBorder(new MatteBorder(3, 0, 0, 0, (Color) new Color(92, 190, 46)));
		
		JPanel meat = new JPanel();
		meat.setLayout(null);
		meat.setFocusable(false);
		meat.setFocusTraversalKeysEnabled(false);
		meat.setBackground(Color.WHITE);
		productTbls.addTab("Fresh Meat", null, meat, null);
		productTbls.setBackgroundAt(2, new Color(130, 130, 130));
		
		JScrollPane scrollPaneM = new JScrollPane();
		scrollPaneM.setBorder(new LineBorder(new Color(130, 130, 130), 3, true));
		scrollPaneM.setBackground(new Color(255, 255, 255));
		scrollPaneM.setForeground(new Color(53, 74, 84));
		scrollPaneM.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		scrollPaneM.setBounds(152, 15, 730, 480);
		meat.add(scrollPaneM);
		
		tableM = new JTable();
		try {
			PreparedStatement pStatement;
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/super_market_management_system", "root", "admin");
			pStatement = connection.prepareStatement("select * from product_fmeat");
			ResultSet rs = pStatement.executeQuery();
			DefaultTableModel model = (DefaultTableModel) tableM.getModel();
			
			String[] colName = {"PID", "Name", "Quantity", "Price"};
			model.setColumnIdentifiers(colName);
			
			TableColumnModel columnModel = tableM.getColumnModel();
			columnModel.getColumn(0).setPreferredWidth(5);
			columnModel.getColumn(1).setPreferredWidth(200);
			columnModel.getColumn(2).setPreferredWidth(10);
			columnModel.getColumn(3).setPreferredWidth(20);
			
			DefaultTableCellRenderer right = new DefaultTableCellRenderer();
			DefaultTableCellRenderer center = new DefaultTableCellRenderer();
			right.setHorizontalAlignment(JLabel.RIGHT);
			center.setHorizontalAlignment(JLabel.CENTER);
			
			tableM.getColumnModel().getColumn(0).setCellRenderer(center);
			tableM.getColumnModel().getColumn(2).setCellRenderer(center);
			tableM.getColumnModel().getColumn(3).setCellRenderer(right);
			
			while(rs.next()) {
				String[] row = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
				model.addRow(row);
			}
			pStatement.close();
			connection.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		tableM.setForeground(new Color(53, 74, 84));
		tableM.setFont(new Font("Century Gothic", Font.BOLD, 15));
		tableM.setGridColor(new Color(130, 130, 130));
		scrollPaneM.setViewportView(tableM);
		tableM.setRowHeight(35);
		tableM.setBorder(new MatteBorder(3, 0, 0, 0, (Color) new Color(130, 130, 130)));
		
		JPanel juices = new JPanel();
		juices.setLayout(null);
		juices.setFocusable(false);
		juices.setFocusTraversalKeysEnabled(false);
		juices.setBackground(Color.WHITE);
		productTbls.addTab("Juices", null, juices, null);
		productTbls.setBackgroundAt(3, new Color(247, 198, 0));
		
		JScrollPane scrollPaneJ = new JScrollPane();
		scrollPaneJ.setBorder(new LineBorder(new Color(247, 198, 0), 3, true));
		scrollPaneJ.setBackground(new Color(255, 255, 255));
		scrollPaneJ.setForeground(new Color(53, 74, 84));
		scrollPaneJ.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		scrollPaneJ.setBounds(152, 15, 730, 480);
		juices.add(scrollPaneJ);
		
		tableJ = new JTable();
		try {
			PreparedStatement pStatement;
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/super_market_management_system", "root", "admin");
			pStatement = connection.prepareStatement("select * from product_juice");
			ResultSet rs = pStatement.executeQuery();
			DefaultTableModel model = (DefaultTableModel) tableJ.getModel();
			
			String[] colName = {"PID", "Name", "Quantity", "Price"};
			model.setColumnIdentifiers(colName);
			
			TableColumnModel columnModel = tableJ.getColumnModel();
			columnModel.getColumn(0).setPreferredWidth(5);
			columnModel.getColumn(1).setPreferredWidth(200);
			columnModel.getColumn(2).setPreferredWidth(10);
			columnModel.getColumn(3).setPreferredWidth(15);
			
			DefaultTableCellRenderer right = new DefaultTableCellRenderer();
			DefaultTableCellRenderer center = new DefaultTableCellRenderer();
			right.setHorizontalAlignment(JLabel.RIGHT);
			center.setHorizontalAlignment(JLabel.CENTER);
			
			tableJ.getColumnModel().getColumn(0).setCellRenderer(center);
			tableJ.getColumnModel().getColumn(2).setCellRenderer(center);
			tableJ.getColumnModel().getColumn(3).setCellRenderer(right);
			
			while(rs.next()) {
				String[] row = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
				model.addRow(row);
			}
			pStatement.close();
			connection.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		tableJ.setForeground(new Color(53, 74, 84));
		tableJ.setFont(new Font("Century Gothic", Font.BOLD, 15));
		tableJ.setGridColor(new Color(247, 198, 0));
		scrollPaneJ.setViewportView(tableJ);
		tableJ.setRowHeight(35);
		tableJ.setBorder(new MatteBorder(3, 0, 0, 0, (Color) new Color(247, 198, 0)));
		
		JPanel hware = new JPanel();
		hware.setLayout(null);
		hware.setFocusable(false);
		hware.setFocusTraversalKeysEnabled(false);
		hware.setBackground(Color.WHITE);
		productTbls.addTab("Homeware Items", null, hware, null);
		productTbls.setBackgroundAt(4, new Color(1, 151, 194));
		
		JScrollPane scrollPaneH = new JScrollPane();
		scrollPaneH.setBorder(new LineBorder(new Color(1, 151, 194), 3, true));
		scrollPaneH.setBackground(new Color(255, 255, 255));
		scrollPaneH.setForeground(new Color(53, 74, 84));
		scrollPaneH.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		scrollPaneH.setBounds(152, 15, 730, 480);
		hware.add(scrollPaneH);
		
		tableH = new JTable();
		try {
			PreparedStatement pStatement;
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/super_market_management_system", "root", "admin");
			pStatement = connection.prepareStatement("select * from product_hware");
			ResultSet rs = pStatement.executeQuery();
			DefaultTableModel model = (DefaultTableModel) tableH.getModel();
			
			String[] colName = {"PID", "Name", "Quantity", "Price"};
			model.setColumnIdentifiers(colName);
			
			TableColumnModel columnModel = tableH.getColumnModel();
			columnModel.getColumn(0).setPreferredWidth(5);
			columnModel.getColumn(1).setPreferredWidth(200);
			columnModel.getColumn(2).setPreferredWidth(10);
			columnModel.getColumn(3).setPreferredWidth(15);
			
			DefaultTableCellRenderer right = new DefaultTableCellRenderer();
			DefaultTableCellRenderer center = new DefaultTableCellRenderer();
			right.setHorizontalAlignment(JLabel.RIGHT);
			center.setHorizontalAlignment(JLabel.CENTER);
			
			tableH.getColumnModel().getColumn(0).setCellRenderer(center);
			tableH.getColumnModel().getColumn(2).setCellRenderer(center);
			tableH.getColumnModel().getColumn(3).setCellRenderer(right);
			
			while(rs.next()) {
				String[] row = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
				model.addRow(row);
			}
			pStatement.close();
			connection.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		tableH.setForeground(new Color(53, 74, 84));
		tableH.setFont(new Font("Century Gothic", Font.BOLD, 15));
		tableH.setGridColor(new Color(1, 151, 194));
		scrollPaneH.setViewportView(tableH);
		tableH.setRowHeight(35);
		tableH.setBorder(new MatteBorder(3, 0, 0, 0, (Color) new Color(1, 151, 194)));
		
		JPanel bpicks = new JPanel();
		bpicks.setLayout(null);
		bpicks.setFocusable(false);
		bpicks.setFocusTraversalKeysEnabled(false);
		bpicks.setBackground(Color.WHITE);
		productTbls.addTab("Beauty Picks", null, bpicks, null);
		productTbls.setBackgroundAt(5, new Color(255, 85, 234));
		
		JScrollPane scrollPaneB = new JScrollPane();
		scrollPaneB.setBorder(new LineBorder(new Color(255, 85, 234), 3, true));
		scrollPaneB.setBackground(new Color(255, 255, 255));
		scrollPaneB.setForeground(new Color(53, 74, 84));
		scrollPaneB.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		scrollPaneB.setBounds(152, 15, 730, 480);
		bpicks.add(scrollPaneB);
		
		tableB = new JTable();
		try {
			PreparedStatement pStatement;
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/super_market_management_system", "root", "admin");
			pStatement = connection.prepareStatement("select * from product_bpicks");
			ResultSet rs = pStatement.executeQuery();
			DefaultTableModel model = (DefaultTableModel) tableB.getModel();
			
			String[] colName = {"PID", "Name", "Quantity", "Price"};
			model.setColumnIdentifiers(colName);
			
			TableColumnModel columnModel = tableB.getColumnModel();
			columnModel.getColumn(0).setPreferredWidth(5);
			columnModel.getColumn(1).setPreferredWidth(200);
			columnModel.getColumn(2).setPreferredWidth(10);
			columnModel.getColumn(3).setPreferredWidth(15);
			
			DefaultTableCellRenderer right = new DefaultTableCellRenderer();
			DefaultTableCellRenderer center = new DefaultTableCellRenderer();
			right.setHorizontalAlignment(JLabel.RIGHT);
			center.setHorizontalAlignment(JLabel.CENTER);
			
			tableB.getColumnModel().getColumn(0).setCellRenderer(center);
			tableB.getColumnModel().getColumn(2).setCellRenderer(center);
			tableB.getColumnModel().getColumn(3).setCellRenderer(right);
			
			while(rs.next()) {
				String[] row = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
				model.addRow(row);
			}
			pStatement.close();
			connection.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		tableB.setForeground(new Color(53, 74, 84));
		tableB.setFont(new Font("Century Gothic", Font.BOLD, 15));
		tableB.setGridColor(new Color(255, 85, 234));
		scrollPaneB.setViewportView(tableB);
		tableB.setRowHeight(35);
		tableB.setBorder(new MatteBorder(3, 0, 0, 0, (Color) new Color(255, 85, 234)));
		
		Cart.setBackground(Color.WHITE);
		sideMenuPages.addTab("New tab", null, Cart, null);
		Cart.setLayout(null);
		
		
/*
 * ###############################################################################################################################################################
 * ##########################################################             CHECKOUT PANEL              ############################################################
 * ###############################################################################################################################################################
 * */
		
		JPanel checkout = new JPanel();
		checkout.setLayout(null);
		checkout.setFocusable(false);
		checkout.setFocusTraversalKeysEnabled(false);
		checkout.setBackground(Color.WHITE);
		checkout.setBounds(0, 22, 1021, 528);
		Cart.add(checkout);
		
		
		
		JScrollPane scrollPaneProducts = new JScrollPane();
		scrollPaneProducts.setForeground(new Color(53, 74, 84));
		scrollPaneProducts.setFont(new Font("Century Gothic", Font.BOLD, 15));
		scrollPaneProducts.setBorder(new TitledBorder(new LineBorder(new Color(1, 151, 194), 3, true), "Choose Products", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(1, 151, 194)));
		scrollPaneProducts.setBackground(new Color(255, 255, 255));
		scrollPaneProducts.setBounds(372, 86, 306, 188);
		checkout.add(scrollPaneProducts);
		
		
/*
 * ###############################################################################################################################################################
 * ##########################################################             PRODUCT TABLES              ############################################################
 * ###############################################################################################################################################################
 * */
		
		tableProducts = new JTable();
		tableProducts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) tableProducts.getModel();
				int row = tableProducts.getSelectedRow();
				
				try {
					textPIDCart.setText(model.getValueAt(row, 0).toString());
					textNameCart.setText(model.getValueAt(row, 1).toString());
					textStock.setText(model.getValueAt(row, 2).toString());
					
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		try {
			PreparedStatement pst;
			Connection connection = DriverManager.getConnection(url, user, password);
			pst = connection.prepareStatement("select * from product_snacks");
			ResultSet rs = pst.executeQuery();
			
			
			tableProducts.setModel(DbUtils.resultSetToTableModel(rs));
			DefaultTableModel model = (DefaultTableModel) tableProducts.getModel();
			
			String[] colName = {"PID", "Name", "Qty", "Price"};
			model.setColumnIdentifiers(colName);
			
			TableColumnModel columnModel = tableProducts.getColumnModel();
			columnModel.getColumn(0).setMaxWidth(40);
			//columnModel.getColumn(1).setMaxWidth(180);
			columnModel.getColumn(2).setMaxWidth(40);
			columnModel.getColumn(3).setMaxWidth(50);
			
			DefaultTableCellRenderer right = new DefaultTableCellRenderer();
			DefaultTableCellRenderer center = new DefaultTableCellRenderer();
			right.setHorizontalAlignment(JLabel.RIGHT);
			center.setHorizontalAlignment(JLabel.CENTER);
			
			tableProducts.getColumnModel().getColumn(0).setCellRenderer(center);
			tableProducts.getColumnModel().getColumn(2).setCellRenderer(center);
			tableProducts.getColumnModel().getColumn(3).setCellRenderer(right);
			
			
			//pStatement.close();
			connection.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		tableProducts.setGridColor(new Color(1, 151, 194));
		tableProducts.setForeground(new Color(53, 74, 84));
		tableProducts.setRowHeight(35);
		tableProducts.setFont(new Font("Century Gothic", Font.BOLD, 10));
		tableProducts.setBorder(new MatteBorder(3, 1, 1, 1, (Color) new Color(1, 151, 194)));
		scrollPaneProducts.setViewportView(tableProducts);
		
		
		
		JPanel editCheck = new JPanel();
		editCheck.setLayout(null);
		editCheck.setBorder(new LineBorder(new Color(1, 151, 194), 3, true));
		editCheck.setBackground(Color.WHITE);
		editCheck.setBounds(33, 30, 329, 480);
		checkout.add(editCheck);
		
		textPIDCart = new JTextField();
		textPIDCart.setForeground(new Color(53, 74, 84));
		textPIDCart.setFont(new Font("Century Gothic", Font.BOLD, 15));
		textPIDCart.setColumns(10);
		textPIDCart.setBorder(new TitledBorder(new LineBorder(new Color(1, 151, 194), 2, true), "Product ID", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(1, 151, 194)));
		textPIDCart.setBounds(33, 17, 267, 49);
		editCheck.add(textPIDCart);
		
		textNameCart = new JTextField();
		textNameCart.setForeground(new Color(53, 74, 84));
		textNameCart.setFont(new Font("Century Gothic", Font.BOLD, 15));
		textNameCart.setColumns(10);
		textNameCart.setBorder(new TitledBorder(new LineBorder(new Color(1, 151, 194), 2, true), "Product Name", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(1, 151, 194)));
		textNameCart.setBounds(33, 76, 267, 49);
		editCheck.add(textNameCart);
		
		textQtyCart = new JTextField();
		textQtyCart.setForeground(new Color(53, 74, 84));
		textQtyCart.setFont(new Font("Century Gothic", Font.BOLD, 15));
		textQtyCart.setColumns(10);
		textQtyCart.setBorder(new TitledBorder(new LineBorder(new Color(1, 151, 194), 2, true), "Quantity", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(1, 151, 194)));
		textQtyCart.setBounds(33, 135, 130, 49);
		editCheck.add(textQtyCart);
		
		textStock = new JTextField();
		textStock.setEditable(false);
		textStock.setForeground(new Color(53, 74, 84));
		textStock.setFont(new Font("Century Gothic", Font.BOLD, 15));
		textStock.setColumns(10);
		textStock.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Available", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		textStock.setBounds(170, 135, 130, 49);
		editCheck.add(textStock);
		
		
/*#############################################################    CART ADD BUTTON      ################################################################
#######################################################################################################################################################*/
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAdd.setBackground(new Color(0,202,187));
				btnAdd.setForeground(new Color(255,255,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAdd.setForeground(new Color(0, 202, 187));
				btnAdd.setBackground(Color.WHITE);
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PreparedStatement pstAutoID, add2Cart, getEMPID, pstUpdate;
					Connection connection = DriverManager.getConnection(url, user, password);
					
					pstAutoID = connection.prepareStatement("select Bill_No from bills order by Bill_No desc limit 1");
					ResultSet rs = pstAutoID.executeQuery();
			
					rs.next();
					String id = rs.getString("Bill_No");
					String no = id.replaceAll("[^0-9]", "");
					billNo = "BN" + String.format("%03d", (Integer.parseInt(no)+1));
					
					getEMPID = connection.prepareStatement("select EMP_ID from emp_details where Username = '"+userID+"' ");
					ResultSet rs2 = getEMPID.executeQuery();
					
					rs2.next();
					String EMPID = rs2.getString("EMP_ID");
					
					add2Cart = connection.prepareStatement("insert into sales values (?, ?, ?, ?, ?, ?)");
					
					
					String PID = textPIDCart.getText();
					
					int qty = Integer.parseInt(textQtyCart.getText());
					
					int newQty = Integer.parseInt(textStock.getText()) - qty;
					
					DefaultTableModel model = (DefaultTableModel) tableProducts.getModel();
					int rn = tableProducts.getSelectedRow();
					
					double price = Double.valueOf(model.getValueAt(rn, 3).toString());
					
					add2Cart.setInt(1, 0);
					add2Cart.setString(2, billNo);
					add2Cart.setString(3, EMPID);
					add2Cart.setString(4, textPIDCart.getText());
					add2Cart.setString(5, textQtyCart.getText());
					add2Cart.setDouble(6, qty*price);
					
					int row = add2Cart.executeUpdate();
					if(row > 0) {
						billTotal = 0;
						JOptionPane.showMessageDialog(btnAdd, "Record Added");
					}
					else 
						JOptionPane.showMessageDialog(btnAdd, "Error");
					
					pstUpdate = connection.prepareStatement("select PID, Qty, Total from sales");
					ResultSet rs3 = pstUpdate.executeQuery();
					tableSales.setModel(DbUtils.resultSetToTableModel(rs3));
					DefaultTableModel modelS = (DefaultTableModel) tableSales.getModel();
					
					String[] colName = {"PID", "Quantity", "Price"};
					modelS.setColumnIdentifiers(colName);
					
					while(rs3.next()) {
						String[] rows = {rs3.getString(1), rs3.getString(2), rs3.getString(3)};
						modelS.addRow(rows);
					}
					
					int numofrow = tableSales.getRowCount();
					for (int i = 0; i < numofrow; i++) {
						double value = Double.valueOf(tableSales.getValueAt(i, 2).toString());
					    billTotal+= value;
					         
					}
					  
					DecimalFormat df = new DecimalFormat("00.00");
					String d1 = df.format(billTotal);
					lblTotalBill.setText("Rs.\t"+d1);
					
					PreparedStatement qtySnacks, qtyVege, qtyFMeat, qtyJuice, qtyHWare, qtyBPicks;
					
					//Snacks
					qtySnacks = connection.prepareStatement("update product_snacks set Quantity = ? where S_ID = ?");
					
					qtySnacks.setInt(1, newQty);
					qtySnacks.setString(2, PID);
					
					qtySnacks.executeUpdate();
					pstUpdate = connection.prepareStatement("select * from product_snacks");
					rs = pstUpdate.executeQuery();
					tableProducts.setModel(DbUtils.resultSetToTableModel(rs));
					
					DefaultTableModel mSnacks = (DefaultTableModel) tableProducts.getModel();
					
					String[] colSnack = {"PID", "Name", "Quantity", "Price"};
					mSnacks.setColumnIdentifiers(colSnack);
					
					
					//Vegetables
					qtyVege = connection.prepareStatement("update product_vegetables set Quantity = ? where V_ID = ?");
					
					qtyVege.setInt(1, newQty);
					qtyVege.setString(2, PID);
					
					qtyVege.executeUpdate();
					pstUpdate = connection.prepareStatement("select * from product_vegetables");
					rs = pstUpdate.executeQuery();
					tableProducts.setModel(DbUtils.resultSetToTableModel(rs));
					
					DefaultTableModel mVege = (DefaultTableModel) tableProducts.getModel();
					
					String[] colVege = {"PID", "Name", "Quantity", "Price"};
					mVege.setColumnIdentifiers(colVege);
					
					
					//Fresh Meat
					qtyFMeat = connection.prepareStatement("update product_fmeat set Quantity = ? where FM_ID = ?");
					
					qtyFMeat.setInt(1, newQty);
					qtyFMeat.setString(2, PID);
					
					qtyFMeat.executeUpdate();
					pstUpdate = connection.prepareStatement("select * from product_fmeat");
					rs = pstUpdate.executeQuery();
					tableProducts.setModel(DbUtils.resultSetToTableModel(rs));
					
					DefaultTableModel mFMeat = (DefaultTableModel) tableProducts.getModel();
					
					String[] colMeat = {"PID", "Name", "Quantity", "Price"};
					mFMeat.setColumnIdentifiers(colMeat);
					
					
					//Juice
					qtyJuice = connection.prepareStatement("update product_juice set Quantity = ? where J_ID = ?");
					
					qtyJuice.setInt(1, newQty);
					qtyJuice.setString(2, PID);
					
					qtyJuice.executeUpdate();
					pstUpdate = connection.prepareStatement("select * from product_juice");
					rs = pstUpdate.executeQuery();
					tableProducts.setModel(DbUtils.resultSetToTableModel(rs));
					
					DefaultTableModel mJuice = (DefaultTableModel) tableProducts.getModel();
					
					String[] colJuice = {"PID", "Name", "Quantity", "Price"};
					mJuice.setColumnIdentifiers(colJuice);
					
					
					//Homeware
					qtyHWare = connection.prepareStatement("update product_hware set Quantity = ? where HW_ID = ?");
					
					qtyHWare.setInt(1, newQty);
					qtyHWare.setString(2, PID);
					
					qtyHWare.executeUpdate();
					pstUpdate = connection.prepareStatement("select * from product_hware");
					rs = pstUpdate.executeQuery();
					tableProducts.setModel(DbUtils.resultSetToTableModel(rs));
					
					DefaultTableModel mHWare = (DefaultTableModel) tableProducts.getModel();
					
					String[] colHWare = {"PID", "Name", "Quantity", "Price"};
					mHWare.setColumnIdentifiers(colHWare);
					
					
					//Beauty Picks
					qtyBPicks = connection.prepareStatement("update product_bpicks set Quantity = ? where BP_ID = ?");
					
					qtyBPicks.setInt(1, newQty);
					qtyBPicks.setString(2, PID);
					
					qtyBPicks.executeUpdate();
					pstUpdate = connection.prepareStatement("select * from product_bpicks");
					rs = pstUpdate.executeQuery();
					tableProducts.setModel(DbUtils.resultSetToTableModel(rs));
					
					DefaultTableModel mBPicks = (DefaultTableModel) tableProducts.getModel();
					
					String[] colBPicks = {"PID", "Name", "Quantity", "Price"};
					mBPicks.setColumnIdentifiers(colBPicks);
					
					
					
					TableColumnModel columnModel = tableProducts.getColumnModel();
					columnModel.getColumn(0).setMaxWidth(40);
					//columnModel.getColumn(1).setMaxWidth(180);
					columnModel.getColumn(2).setMaxWidth(40);
					columnModel.getColumn(3).setMaxWidth(50);
					
					DefaultTableCellRenderer right = new DefaultTableCellRenderer();
					DefaultTableCellRenderer center = new DefaultTableCellRenderer();
					right.setHorizontalAlignment(JLabel.RIGHT);
					center.setHorizontalAlignment(JLabel.CENTER);
					
					tableProducts.getColumnModel().getColumn(0).setCellRenderer(center);
					tableProducts.getColumnModel().getColumn(2).setCellRenderer(center);
					tableProducts.getColumnModel().getColumn(3).setCellRenderer(right);
					
					
					pstUpdate.close();
					connection.close();
					
					
				} catch (Exception e1) {
					
				}
			}
		});
		btnAdd.setForeground(new Color(0, 202, 187));
		btnAdd.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnAdd.setFocusable(false);
		btnAdd.setFocusTraversalKeysEnabled(false);
		btnAdd.setFocusPainted(false);
		btnAdd.setBorder(new LineBorder(new Color(0, 202, 187), 2, true));
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setBounds(33, 207, 130, 50);
		editCheck.add(btnAdd);
		
		
/*######################################################        CART REMOVE BUTTON      ################################################################
#######################################################################################################################################################*/
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sPID = textPIDCart.getText();
					int qty = Integer.parseInt(textQtyCart.getText());
					
					
					PreparedStatement pst, pstUpdate;
					Connection connection = DriverManager.getConnection(url, user, password);
					pst = connection.prepareStatement("delete from sales where PID = '" + sPID + "'  and Qty = '" + qty + "'");
					
					int r = pst.executeUpdate();
					if (r>0) {
						billTotal = 0;
						JOptionPane.showMessageDialog(btnRemove, "Item Removed");
					}
					
					pstUpdate = connection.prepareStatement("select PID, Qty, Total from sales");
					ResultSet rs3 = pstUpdate.executeQuery();
					tableSales.setModel(DbUtils.resultSetToTableModel(rs3));
					DefaultTableModel modelS = (DefaultTableModel) tableSales.getModel();
					
					while(rs3.next()) {
						String[] rows = {rs3.getString(1), rs3.getString(2), rs3.getString(3)};
						modelS.addRow(rows);
					}
					
					int numofrow = tableSales.getRowCount();
					for (int i = 0; i < numofrow; i++) {
						double value = Double.valueOf(tableSales.getValueAt(i, 2).toString());
					    billTotal+= value;
					         
					}
					  
					DecimalFormat df = new DecimalFormat("0.00");
					String d1 = df.format(billTotal);
					lblTotalBill.setText("Rs.\t"+d1);
					
					PreparedStatement qtySnacks, qtyVege, qtyFMeat, qtyJuice, qtyHWare, qtyBPicks;
					ResultSet rs;
					
					String PID = textPIDCart.getText();
					int stock = Integer.parseInt(textStock.getText());
					int cart = Integer.parseInt(textQtyCart.getText());
					int newQty = stock + cart;
					
					//Snacks
					qtySnacks = connection.prepareStatement("update product_snacks set Quantity = ? where S_ID = ?");
					
					qtySnacks.setInt(1, newQty);
					qtySnacks.setString(2, PID);
					
					qtySnacks.executeUpdate();
					pstUpdate = connection.prepareStatement("select * from product_snacks");
					rs = pstUpdate.executeQuery();
					tableProducts.setModel(DbUtils.resultSetToTableModel(rs));
					
					DefaultTableModel mSnacks = (DefaultTableModel) tableProducts.getModel();
					
					String[] colSnack = {"PID", "Name", "Quantity", "Price"};
					mSnacks.setColumnIdentifiers(colSnack);
					
					
					//Vegetables
					qtyVege = connection.prepareStatement("update product_vegetables set Quantity = ? where V_ID = ?");
					
					qtyVege.setInt(1, newQty);
					qtyVege.setString(2, PID);
					
					qtyVege.executeUpdate();
					pstUpdate = connection.prepareStatement("select * from product_vegetables");
					rs = pstUpdate.executeQuery();
					tableProducts.setModel(DbUtils.resultSetToTableModel(rs));
					
					DefaultTableModel mVege = (DefaultTableModel) tableProducts.getModel();
					
					String[] colVege = {"PID", "Name", "Quantity", "Price"};
					mVege.setColumnIdentifiers(colVege);
					
					
					//Fresh Meat
					qtyFMeat = connection.prepareStatement("update product_fmeat set Quantity = ? where FM_ID = ?");
					
					qtyFMeat.setInt(1, newQty);
					qtyFMeat.setString(2, PID);
					
					qtyFMeat.executeUpdate();
					pstUpdate = connection.prepareStatement("select * from product_fmeat");
					rs = pstUpdate.executeQuery();
					tableProducts.setModel(DbUtils.resultSetToTableModel(rs));
					
					DefaultTableModel mFMeat = (DefaultTableModel) tableProducts.getModel();
					
					String[] colMeat = {"PID", "Name", "Quantity", "Price"};
					mFMeat.setColumnIdentifiers(colMeat);
					
					
					//Juice
					qtyJuice = connection.prepareStatement("update product_juice set Quantity = ? where J_ID = ?");
					
					qtyJuice.setInt(1, newQty);
					qtyJuice.setString(2, PID);
					
					qtyJuice.executeUpdate();
					pstUpdate = connection.prepareStatement("select * from product_juice");
					rs = pstUpdate.executeQuery();
					tableProducts.setModel(DbUtils.resultSetToTableModel(rs));
					
					DefaultTableModel mJuice = (DefaultTableModel) tableProducts.getModel();
					
					String[] colJuice = {"PID", "Name", "Quantity", "Price"};
					mJuice.setColumnIdentifiers(colJuice);
					
					
					//Homeware
					qtyHWare = connection.prepareStatement("update product_hware set Quantity = ? where HW_ID = ?");
					
					qtyHWare.setInt(1, newQty);
					qtyHWare.setString(2, PID);
					
					qtyHWare.executeUpdate();
					pstUpdate = connection.prepareStatement("select * from product_hware");
					rs = pstUpdate.executeQuery();
					tableProducts.setModel(DbUtils.resultSetToTableModel(rs));
					
					DefaultTableModel mHWare = (DefaultTableModel) tableProducts.getModel();
					
					String[] colHWare = {"PID", "Name", "Quantity", "Price"};
					mHWare.setColumnIdentifiers(colHWare);
					
					
					//Beauty Picks
					qtyBPicks = connection.prepareStatement("update product_bpicks set Quantity = ? where BP_ID = ?");
					
					qtyBPicks.setInt(1, newQty);
					qtyBPicks.setString(2, PID);
					
					qtyBPicks.executeUpdate();
					pstUpdate = connection.prepareStatement("select * from product_bpicks");
					rs = pstUpdate.executeQuery();
					tableProducts.setModel(DbUtils.resultSetToTableModel(rs));
					
					DefaultTableModel mBPicks = (DefaultTableModel) tableProducts.getModel();
					
					String[] colBPicks = {"PID", "Name", "Quantity", "Price"};
					mBPicks.setColumnIdentifiers(colBPicks);
					
					
					
					TableColumnModel columnModel = tableProducts.getColumnModel();
					columnModel.getColumn(0).setMaxWidth(40);
					//columnModel.getColumn(1).setMaxWidth(180);
					columnModel.getColumn(2).setMaxWidth(40);
					columnModel.getColumn(3).setMaxWidth(50);
					
					DefaultTableCellRenderer right = new DefaultTableCellRenderer();
					DefaultTableCellRenderer center = new DefaultTableCellRenderer();
					right.setHorizontalAlignment(JLabel.RIGHT);
					center.setHorizontalAlignment(JLabel.CENTER);
					
					tableProducts.getColumnModel().getColumn(0).setCellRenderer(center);
					tableProducts.getColumnModel().getColumn(2).setCellRenderer(center);
					tableProducts.getColumnModel().getColumn(3).setCellRenderer(right);
					
					
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnRemove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRemove.setForeground(new Color(255, 255, 255));
				btnRemove.setBackground(new Color(167, 102, 124));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnRemove.setForeground(new Color(167, 102, 124));
				btnRemove.setBackground(Color.WHITE);
			}
		});
		btnRemove.setForeground(new Color(167, 102, 124));
		btnRemove.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnRemove.setFocusable(false);
		btnRemove.setFocusTraversalKeysEnabled(false);
		btnRemove.setFocusPainted(false);
		btnRemove.setBorder(new LineBorder(new Color(167, 102, 124), 2, true));
		btnRemove.setBackground(Color.WHITE);
		btnRemove.setBounds(170, 207, 130, 50);
		editCheck.add(btnRemove);
		
		textPaymnt = new JTextField();
		textPaymnt.setHorizontalAlignment(SwingConstants.RIGHT);
		textPaymnt.setForeground(new Color(1, 151, 194));
		textPaymnt.setFont(new Font("Century Gothic", Font.BOLD, 20));
		textPaymnt.setColumns(10);
		textPaymnt.setBorder(new TitledBorder(new LineBorder(new Color(53, 74, 84), 3, true), "Payment", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(53, 74, 84)));
		textPaymnt.setBounds(33, 326, 267, 56);
		editCheck.add(textPaymnt);
		
		JComboBox<Object> cBoxCategory = new JComboBox<Object>();
		cBoxCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cBoxCategory.getSelectedIndex()==0) {
					try {
						PreparedStatement pst;
						Connection connection = DriverManager.getConnection(url, user, password);
						pst = connection.prepareStatement("select * from product_snacks");
						ResultSet rs = pst.executeQuery();
						
						
						tableProducts.setModel(DbUtils.resultSetToTableModel(rs));
						DefaultTableModel model = (DefaultTableModel) tableProducts.getModel();
						
						String[] colName = {"PID", "Name", "Qty", "Price"};
						model.setColumnIdentifiers(colName);
						
						TableColumnModel columnModel = tableProducts.getColumnModel();
						columnModel.getColumn(0).setMaxWidth(40);
						//columnModel.getColumn(1).setMaxWidth(180);
						columnModel.getColumn(2).setMaxWidth(40);
						columnModel.getColumn(3).setMaxWidth(50);
						
						DefaultTableCellRenderer right = new DefaultTableCellRenderer();
						DefaultTableCellRenderer center = new DefaultTableCellRenderer();
						right.setHorizontalAlignment(JLabel.RIGHT);
						center.setHorizontalAlignment(JLabel.CENTER);
						
						tableProducts.getColumnModel().getColumn(0).setCellRenderer(center);
						tableProducts.getColumnModel().getColumn(2).setCellRenderer(center);
						tableProducts.getColumnModel().getColumn(3).setCellRenderer(right);
						
						
						//pStatement.close();
						connection.close();
						
					} catch (Exception e1) {
						// TODO: handle exception
					}
				}else if(cBoxCategory.getSelectedIndex()==1){
					try {
						PreparedStatement pst;
						Connection connection = DriverManager.getConnection(url, user, password);
						pst = connection.prepareStatement("select * from product_vegetables");
						ResultSet rs = pst.executeQuery();
						
						
						tableProducts.setModel(DbUtils.resultSetToTableModel(rs));
						DefaultTableModel model = (DefaultTableModel) tableProducts.getModel();
						
						String[] colName = {"PID", "Name", "Qty", "Price"};
						model.setColumnIdentifiers(colName);
						
						TableColumnModel columnModel = tableProducts.getColumnModel();
						columnModel.getColumn(0).setMaxWidth(40);
						//columnModel.getColumn(1).setMaxWidth(180);
						columnModel.getColumn(2).setMaxWidth(40);
						columnModel.getColumn(3).setMaxWidth(50);
						
						DefaultTableCellRenderer right = new DefaultTableCellRenderer();
						DefaultTableCellRenderer center = new DefaultTableCellRenderer();
						right.setHorizontalAlignment(JLabel.RIGHT);
						center.setHorizontalAlignment(JLabel.CENTER);
						
						tableProducts.getColumnModel().getColumn(0).setCellRenderer(center);
						tableProducts.getColumnModel().getColumn(2).setCellRenderer(center);
						tableProducts.getColumnModel().getColumn(3).setCellRenderer(right);
						
						
						//pStatement.close();
						connection.close();
						
					} catch (Exception e1) {
						// TODO: handle exception
					}
				}else if(cBoxCategory.getSelectedIndex()==2){
					try {
						PreparedStatement pst;
						Connection connection = DriverManager.getConnection(url, user, password);
						pst = connection.prepareStatement("select * from product_fmeat");
						ResultSet rs = pst.executeQuery();
						
						
						tableProducts.setModel(DbUtils.resultSetToTableModel(rs));
						DefaultTableModel model = (DefaultTableModel) tableProducts.getModel();
						
						String[] colName = {"PID", "Name", "Qty", "Price"};
						model.setColumnIdentifiers(colName);
						
						TableColumnModel columnModel = tableProducts.getColumnModel();
						columnModel.getColumn(0).setMaxWidth(40);
						//columnModel.getColumn(1).setMaxWidth(180);
						columnModel.getColumn(2).setMaxWidth(40);
						columnModel.getColumn(3).setMaxWidth(50);
						
						DefaultTableCellRenderer right = new DefaultTableCellRenderer();
						DefaultTableCellRenderer center = new DefaultTableCellRenderer();
						right.setHorizontalAlignment(JLabel.RIGHT);
						center.setHorizontalAlignment(JLabel.CENTER);
						
						tableProducts.getColumnModel().getColumn(0).setCellRenderer(center);
						tableProducts.getColumnModel().getColumn(2).setCellRenderer(center);
						tableProducts.getColumnModel().getColumn(3).setCellRenderer(right);
						
						
						//pStatement.close();
						connection.close();
						
					} catch (Exception e1) {
						// TODO: handle exception
					}
				}else if(cBoxCategory.getSelectedIndex()==3){
					try {
						PreparedStatement pst;
						Connection connection = DriverManager.getConnection(url, user, password);
						pst = connection.prepareStatement("select * from product_juice");
						ResultSet rs = pst.executeQuery();
						
						
						tableProducts.setModel(DbUtils.resultSetToTableModel(rs));
						DefaultTableModel model = (DefaultTableModel) tableProducts.getModel();
						
						String[] colName = {"PID", "Name", "Qty", "Price"};
						model.setColumnIdentifiers(colName);
						
						TableColumnModel columnModel = tableProducts.getColumnModel();
						columnModel.getColumn(0).setMaxWidth(40);
						//columnModel.getColumn(1).setMaxWidth(180);
						columnModel.getColumn(2).setMaxWidth(40);
						columnModel.getColumn(3).setMaxWidth(50);
						
						DefaultTableCellRenderer right = new DefaultTableCellRenderer();
						DefaultTableCellRenderer center = new DefaultTableCellRenderer();
						right.setHorizontalAlignment(JLabel.RIGHT);
						center.setHorizontalAlignment(JLabel.CENTER);
						
						tableProducts.getColumnModel().getColumn(0).setCellRenderer(center);
						tableProducts.getColumnModel().getColumn(2).setCellRenderer(center);
						tableProducts.getColumnModel().getColumn(3).setCellRenderer(right);
						
						
						//pStatement.close();
						connection.close();
						
					} catch (Exception e1) {
						// TODO: handle exception
					}
				}else if(cBoxCategory.getSelectedIndex()==4){
					try {
						PreparedStatement pst;
						Connection connection = DriverManager.getConnection(url, user, password);
						pst = connection.prepareStatement("select * from product_hware");
						ResultSet rs = pst.executeQuery();
						
						
						tableProducts.setModel(DbUtils.resultSetToTableModel(rs));
						DefaultTableModel model = (DefaultTableModel) tableProducts.getModel();
						
						String[] colName = {"PID", "Name", "Qty", "Price"};
						model.setColumnIdentifiers(colName);
						
						TableColumnModel columnModel = tableProducts.getColumnModel();
						columnModel.getColumn(0).setMaxWidth(40);
						//columnModel.getColumn(1).setMaxWidth(180);
						columnModel.getColumn(2).setMaxWidth(40);
						columnModel.getColumn(3).setMaxWidth(50);
						
						DefaultTableCellRenderer right = new DefaultTableCellRenderer();
						DefaultTableCellRenderer center = new DefaultTableCellRenderer();
						right.setHorizontalAlignment(JLabel.RIGHT);
						center.setHorizontalAlignment(JLabel.CENTER);
						
						tableProducts.getColumnModel().getColumn(0).setCellRenderer(center);
						tableProducts.getColumnModel().getColumn(2).setCellRenderer(center);
						tableProducts.getColumnModel().getColumn(3).setCellRenderer(right);
						
						
						//pStatement.close();
						connection.close();
						
					} catch (Exception e1) {
						// TODO: handle exception
					}
				}else if(cBoxCategory.getSelectedIndex()==5){
					try {
						PreparedStatement pst;
						Connection connection = DriverManager.getConnection(url, user, password);
						pst = connection.prepareStatement("select * from product_bpicks");
						ResultSet rs = pst.executeQuery();
						
						
						tableProducts.setModel(DbUtils.resultSetToTableModel(rs));
						DefaultTableModel model = (DefaultTableModel) tableProducts.getModel();
						
						String[] colName = {"PID", "Name", "Qty", "Price"};
						model.setColumnIdentifiers(colName);
						
						TableColumnModel columnModel = tableProducts.getColumnModel();
						columnModel.getColumn(0).setMaxWidth(40);
						//columnModel.getColumn(1).setMaxWidth(180);
						columnModel.getColumn(2).setMaxWidth(40);
						columnModel.getColumn(3).setMaxWidth(50);
						
						DefaultTableCellRenderer right = new DefaultTableCellRenderer();
						DefaultTableCellRenderer center = new DefaultTableCellRenderer();
						right.setHorizontalAlignment(JLabel.RIGHT);
						center.setHorizontalAlignment(JLabel.CENTER);
						
						tableProducts.getColumnModel().getColumn(0).setCellRenderer(center);
						tableProducts.getColumnModel().getColumn(2).setCellRenderer(center);
						tableProducts.getColumnModel().getColumn(3).setCellRenderer(right);
						
						
						//pStatement.close();
						connection.close();
						
					} catch (Exception e1) {
						// TODO: handle exception
					}
				}
			}
		});
		cBoxCategory.setOpaque(false);
		cBoxCategory.setModel((ComboBoxModel<Object>) new DefaultComboBoxModel<Object>(new String[] {"Snacks", "Vegetables", "Fresh Meat", "Juices", "Homeware Items", "Beauty Picks"}));
		cBoxCategory.setBorder(new TitledBorder(new LineBorder(new Color(1, 151, 194), 3, true), "Category", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(1, 151, 194)));
		cBoxCategory.setBounds(372, 30, 306, 54);
		checkout.add(cBoxCategory);
		
		JLabel lblTot = new JLabel("Total : ");
		lblTot.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblTot.setBorder(null);
		lblTot.setBounds(33, 267, 85, 49);
		editCheck.add(lblTot);
		
	
		lblTotalBill.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalBill.setForeground(new Color(64, 128, 128));
		lblTotalBill.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblTotalBill.setBorder(null);
		lblTotalBill.setBounds(125, 267, 175, 49);
		editCheck.add(lblTotalBill);
		
		JTextArea bill = new JTextArea();
		bill.setBorder(new LineBorder(new Color(1, 151, 194), 3, true));
		bill.setBounds(688, 30, 306, 480);
		checkout.add(bill);

		
/*
 * ###############################################################################################################################################################
 * ##########################################################             PAY BUTTON              ################################################################
 * ###############################################################################################################################################################
 * */
		
		JButton btnPay = new JButton("Pay");
		btnPay.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection(url, user, password);
					
					double payment = Double.parseDouble(textPaymnt.getText());
					PreparedStatement getTotal = connection.prepareStatement("select sum(Total) from sales");
					ResultSet rSet = getTotal.executeQuery();
					rSet.next();
					double billValue = rSet.getDouble(1);
					
					if (payment < billValue) {
						JOptionPane.showMessageDialog(null, "Payment not enough!");
					}else {
					
						try {
							
							PreparedStatement pst = connection.prepareStatement("Select Bill_no from sales");
							ResultSet rs = pst.executeQuery();
							
							rs.next();
							billNo = rs.getString(1);
		
			//##################################################### PRINTING BILL TO TEXT AREA
				            bill.setText("\tStar Market - Sri Lanka \n\n");
				            bill.setText(bill.getText() + "\tNo 161b, Kaduwela Road,\n");
				            bill.setText(bill.getText() + "\tMalabe, Srilanka, \n");
				            bill.setText(bill.getText() + "\tContact No: 076 101 7286\n");
				            bill.setText(bill.getText() + "\n  Bill No. " + billNo + "\n");
				            bill.setText(bill.getText() + "-------------------------------------------------------------------\n");
				            bill.setText(bill.getText() + "    Item \tQuantity\tPrice \n");
				            bill.setText(bill.getText() + "-------------------------------------------------------------------\n");
				            
				            DefaultTableModel df = (DefaultTableModel) tableSales.getModel();
				            for (int i = 0; i < tableSales.getRowCount(); i++) {
				                
				                String PID = df.getValueAt(i, 0).toString();
				                String qt = df.getValueAt(i, 1).toString();
				                String prc = df.getValueAt(i, 2).toString();
				                
				                bill.setText(bill.getText() + "    " + PID + "\t" + qt + "\t" + prc + " \n");
				                
				            }
				            bill.setText(bill.getText() + "-------------------------------------------------------------------\n");
				            bill.setText(bill.getText() + "\tTotal     :\t"+billTotal+"\n");
				            bill.setText(bill.getText() + "\tCash      :\t"+textPaymnt.getText()+"\n");
				            bill.setText(bill.getText() + "\tBallance  :\t"+Double.valueOf(billTotal - Double.valueOf(textPaymnt.getText()))+"\n");
				            bill.setText(bill.getText() + "========================================\n");
				            bill.setText(bill.getText() +"        Thanks For Your Business...!"+"\n");
				            bill.setText(bill.getText() + "--------------------------------------------------------------------\n");
				            
				            // Get the current working directory
				            String workingDirectory = System.getProperty("user.dir");
		
				            // Specify the name of the new folder
				            String folderName = "bills";
		
				            // Create the full path by appending the folder name to the working directory
				            String folderPath = workingDirectory + File.separator + folderName;
		
				            // Create a File object representing the new folder
				            File folder = new File(folderPath);
				            
				            // Check if the folder already exists; if not, create it
				            if (!folder.exists()) {
				                if (folder.mkdirs()) {
				                    System.out.println("Folder created at: " + folderPath);
				                } else {
				                    System.err.println("Failed to create the folder.");
				                }
				            } else {
				                System.out.println("Folder already exists at: " + folderPath);
				            }
				            
				            // Set the filename
				            String billFileName = billNo+".txt"; // Specify the bill file name
				            
				            // setting the path
				            String billFilePath = folderPath + File.separator + billFileName;
				            
				            
				            BufferedWriter printBill = new BufferedWriter(new FileWriter(billFilePath));
				            printBill.write(bill.getText());
				            
				            JOptionPane.showMessageDialog(null, "Bill Printed!");
				            
				            printBill.close();
				            
				            // insert the bill data to bills table
				            PreparedStatement add2bill = connection.prepareStatement("INSERT INTO bills (Bill_No, EMP_ID, EMP_LastName, Bil_Amount) SELECT s.Bill_No, s.EMP_ID, e.Last_Name, SUM(s.Total) FROM sales s INNER JOIN emp_details e ON s.EMP_ID = e.EMP_ID GROUP BY s.Bill_No, s.EMP_ID, e.Last_Name");
				            add2bill.executeUpdate();
				            
				            // delete all current bill data in the sales table
				            PreparedStatement cartDelete = connection.prepareStatement("delete from sales");
				            cartDelete.executeUpdate();
				            
				            textPIDCart.setText(null);
				            textNameCart.setText(null);
				            textQtyCart.setText(null);
				            textStock.setText(null);		            
				            textPaymnt.setText(null);
		
		//####################################################### UPDATING SALES TABLE
				            PreparedStatement pstUpdate = connection.prepareStatement("select PID, Qty, Total from sales");
							ResultSet rs3 = pstUpdate.executeQuery();
							tableSales.setModel(DbUtils.resultSetToTableModel(rs3));
							DefaultTableModel modelS = (DefaultTableModel) tableSales.getModel();
							
							String[] colName = {"PID", "Quantity", "Price"};
							modelS.setColumnIdentifiers(colName);
							
							while(rs3.next()) {
								String[] rows = {rs3.getString(1), rs3.getString(2), rs3.getString(3)};
								modelS.addRow(rows);
							}
							
		//####################################################### UPDATING BILLS TABLE
							PreparedStatement pstUpdateBills;
							pstUpdateBills = connection.prepareStatement("select * from bills");
							ResultSet rs1 = pstUpdateBills.executeQuery();
							tableBills.setModel(DbUtils.resultSetToTableModel(rs1));
							DefaultTableModel model = (DefaultTableModel) tableBills.getModel();
							
							String[] colName1 = {"Bill_No.", "EMP_ID", "EMP_LastName", "Bill_Amount"};
							model.setColumnIdentifiers(colName1);
							
							DefaultTableCellRenderer right = new DefaultTableCellRenderer();
							DefaultTableCellRenderer center = new DefaultTableCellRenderer();
							right.setHorizontalAlignment(JLabel.RIGHT);
							center.setHorizontalAlignment(JLabel.CENTER);
							
							tableBills.getColumnModel().getColumn(0).setCellRenderer(center);
							tableBills.getColumnModel().getColumn(1).setCellRenderer(center);
							tableBills.getColumnModel().getColumn(3).setCellRenderer(right);
							
							
		//####################################################### UPDATING  TOTAL SALES VALUE
							PreparedStatement pstUpTotal = connection.prepareStatement("select sum(Bil_Amount) from bills");
							ResultSet rs2 = pstUpTotal.executeQuery();
							rs2.next();
							String totalSales = rs2.getString(1);
							
							lblTotalNoHome.setText("Rs."+totalSales);
							lblTotalNo.setText("Rs."+totalSales);
							
				            lblTotalBill.setText("Rs. 0.00");
		
				        } catch (Exception e1) {
							// TODO: handle exception
						}
					}
				}
				 catch (NumberFormatException e2) {
					 JOptionPane.showMessageDialog(null, "Invalid Format!");
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
			});
		btnPay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPay.setBackground(new Color(229, 95, 112));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPay.setBackground(new Color(99, 0, 15));
			}
		});
		btnPay.setBorderPainted(false);
		btnPay.setForeground(new Color(255, 255, 255));
		btnPay.setFont(new Font("Century Gothic", Font.BOLD, 30));
		btnPay.setFocusable(false);
		btnPay.setFocusTraversalKeysEnabled(false);
		btnPay.setFocusPainted(false);
		btnPay.setBorder(new LineBorder(new Color(99, 0, 15), 2, true));
		btnPay.setBackground(new Color(99, 0, 15));
		btnPay.setBounds(33, 392, 267, 68);
		editCheck.add(btnPay);
		
		
		
		
		JScrollPane scrollPaneCart = new JScrollPane();
		scrollPaneCart.setBackground(new Color(255, 255, 255));
		scrollPaneCart.setBorder(new TitledBorder(new LineBorder(new Color(1, 151, 194), 3, true), "Cart", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(1, 151, 194)));
		scrollPaneCart.setBounds(372, 280, 306, 230);
		checkout.add(scrollPaneCart);
		

/*
 * ###############################################################################################################################################################
 * ##########################################################              SALES TABLE           #################################################################
 * ###############################################################################################################################################################
 * */

		tableSales = new JTable();
		try {
			PreparedStatement pStatement;
			Connection connection = DriverManager.getConnection(url, user, password);
			pStatement = connection.prepareStatement("select PID, Qty, Total from sales");
			ResultSet rs = pStatement.executeQuery();
			DefaultTableModel model = (DefaultTableModel) tableSales.getModel();
			
			String[] colName = {"PID", "Quantity", "Price"};
			model.setColumnIdentifiers(colName);
			
			while(rs.next()) {
				String[] row = {rs.getString(1), rs.getString(2), rs.getString(3)};
				model.addRow(row);
			}
			pStatement.close();
			connection.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		tableSales.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel modelSales = (DefaultTableModel) tableSales.getModel();
				int rSales = tableSales.getSelectedRow();
				
				try {
					PreparedStatement s, v, fm, j, hw, bp;
					Connection connection = DriverManager.getConnection(url, user, password);
					ResultSet rs, rv, rfm, rj, rhw, rbp;
					
					textPIDCart.setText(modelSales.getValueAt(rSales, 0).toString());
					textQtyCart.setText(modelSales.getValueAt(rSales, 1).toString());
					
					String PID = textPIDCart.getText();
					
					s = connection.prepareStatement("select * from product_snacks where S_ID = '"+PID+"'");
					rs = s.executeQuery();
					
					v = connection.prepareStatement("select * from product_vegetables where V_ID = '"+PID+"'");
					rv = v.executeQuery();
					
					fm = connection.prepareStatement("select * from product_fmeat where FM_ID = '"+PID+"'");
					rfm = fm.executeQuery();
					
					j = connection.prepareStatement("select * from product_juice where J_ID = '"+PID+"'");
					rj = j.executeQuery();
					
					hw = connection.prepareStatement("select * from product_hware where HW_ID = '"+PID+"'");
					rhw = hw.executeQuery();
					
					bp = connection.prepareStatement("select * from product_bpicks where BP_ID = '"+PID+"'");
					rbp = bp.executeQuery();
					
					while (rs.next()) {
						textNameCart.setText(rs.getString("Name"));
						textStock.setText(rs.getString("Quantity"));
					}
					while (rv.next()) {
						textNameCart.setText(rv.getString("Name"));
						textStock.setText(rv.getString("Quantity"));
					}
					while (rfm.next()) {
						textNameCart.setText(rfm.getString("Name"));
						textStock.setText(rfm.getString("Quantity"));
					}
					while (rj.next()) {
						textNameCart.setText(rj.getString("Name"));
						textStock.setText(rj.getString("Quantity"));
					}
					while (rhw.next()) {
						textNameCart.setText(rhw.getString("Name"));
						textStock.setText(rhw.getString("Quantity"));
					}
					while (rbp.next()) {
						textNameCart.setText(rbp.getString("Name"));
						textStock.setText(rbp.getString("Quantity"));
					}
					
					int numofrow = tableSales.getRowCount();
					for (int i = 0; i < numofrow; i++) {
						double value = Double.valueOf(tableSales.getValueAt(i, 2).toString());
					    billTotal += value;
					         
					}
					
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		scrollPaneCart.setViewportView(tableSales);
		
		sales.setBackground(Color.WHITE);
		sideMenuPages.addTab("New tab", null, sales, null);
		sales.setLayout(null);
		
		JTextArea billView = new JTextArea();
		billView.setBorder(new LineBorder(new Color(1, 151, 194), 3, true));
		billView.setBounds(661, 58, 306, 480);
		sales.add(billView);
		
		JScrollPane scrollPaneSales = new JScrollPane();
		scrollPaneSales.setBorder(new LineBorder(new Color(53, 74, 84), 3, true));
		scrollPaneSales.setBackground(new Color(255, 255, 255));
		scrollPaneSales.setForeground(new Color(0, 0, 0));
		scrollPaneSales.setFont(new Font("Century Gothic", Font.BOLD, 15));
		scrollPaneSales.setBounds(65, 58, 565, 334);
		sales.add(scrollPaneSales);
		
/*
 * ###############################################################################################################################################################
 * ##########################################################              BILLS TABLE           #################################################################
 * ###############################################################################################################################################################
 * */
	
		
		tableBills = new JTable();
		tableBills.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				billView.setText(null);
				int row = tableBills.getSelectedRow();
				String BN = tableBills.getModel().getValueAt(row, 0).toString();
				
				String billPath = "bills/"+BN+".txt";
				
				try {
					BufferedReader readBill = new BufferedReader(new FileReader(billPath));
					String line;
		            while ((line = readBill.readLine()) != null) {
		                billView.append(line + "\n"); 
		            }
		            
		            readBill.close();
			            
				} catch (Exception e2) {
					// TODO: handle exception
				} 
			}
		});
		try {
			PreparedStatement pStatement;
			Connection connection = DriverManager.getConnection(url, user, password);
			pStatement = connection.prepareStatement("select * from bills");
			ResultSet rs = pStatement.executeQuery();
			DefaultTableModel model = (DefaultTableModel) tableBills.getModel();
			
			String[] colName = {"Bill_No.", "EMP_ID", "EMP_LastName", "Bill_Amount"};
			model.setColumnIdentifiers(colName);
			
			while(rs.next()) {
				String[] row = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
				model.addRow(row);
			}
			
			DefaultTableCellRenderer right = new DefaultTableCellRenderer();
			DefaultTableCellRenderer center = new DefaultTableCellRenderer();
			right.setHorizontalAlignment(JLabel.RIGHT);
			center.setHorizontalAlignment(JLabel.CENTER);
			
			tableBills.getColumnModel().getColumn(0).setCellRenderer(center);
			tableBills.getColumnModel().getColumn(1).setCellRenderer(center);
			tableBills.getColumnModel().getColumn(3).setCellRenderer(right);
			 
			pStatement.close();
			connection.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		tableBills.setFont(new Font("Century Gothic", Font.BOLD, 15));
		tableBills.setRowHeight(35);
		tableBills.setForeground(new Color(53, 74, 84));
		tableBills.setGridColor(new Color(53, 74, 84));
		tableBills.setBorder(new MatteBorder(3, 1, 1, 1, (Color) new Color(53, 74, 84)));
		tableBills.getColumnModel().getColumn(2).setPreferredWidth(116);

		scrollPaneSales.setViewportView(tableBills);
		
		JLabel lblTotalSales = new JLabel("Total Sales:");
		lblTotalSales.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblTotalSales.setBounds(237, 402, 150, 50);
		sales.add(lblTotalSales);
	
//##############################################################################  TOTAL SUM OF BILLS ###############################################
		
		try {
			PreparedStatement pst;
			Connection connection = DriverManager.getConnection(url, user, password);
			pst = connection.prepareStatement("select sum(Bil_Amount) from bills");
			ResultSet rs = pst.executeQuery();
			rs.next();
			String totalSales = rs.getString(1);
			
			lblTotalNo.setText("Rs."+totalSales);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		lblTotalNo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalNo.setForeground(new Color(185, 17, 17));
		lblTotalNo.setFont(new Font("Century Gothic", Font.BOLD, 40));
		lblTotalNo.setBounds(247, 444, 201, 91);
		sales.add(lblTotalNo);
		
		frameCashierPage.setBackground(new Color(255, 255, 255));
		frameCashierPage.setUndecorated(true);
		frameCashierPage.setBounds(100, 100, 1287, 668);
		frameCashierPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
