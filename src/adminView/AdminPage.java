package adminView;

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
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

public class AdminPage extends Login{

	private JFrame frameAdminPage;
	private JTable tableM;
	private JTable tableV;
	private JTable tableS;
	private JTable tableB;
	private JTable tableH;
	private JTable tableJ;
	private JTextField txtPIDS;
	private JTextField txtNameS;
	private JTextField txtQtyS;
	private JTextField txtPriceS;
	private JTextField textPIDV;
	private JTextField textNameV;
	private JTextField textQtyV;
	private JTextField textPriceV;
	private JTextField textPIDM;
	private JTextField textNameM;
	private JTextField textQtyM;
	private JTextField textPriceM;
	private JTextField textPIDJ;
	private JTextField textNameJ;
	private JTextField textQtyJ;
	private JTextField textPriceJ;
	private JTextField textPIDH;
	private JTextField textNameH;
	private JTextField textQtyH;
	private JTextField textPriceH;
	private JTextField textPIDB;
	private JTextField textNameB;
	private JTextField textQtyB;
	private JTextField textPriceB;
	private JTextField textEMPID;
	private JTextField textFName;
	private JTextField textLName;
	private JTextField textCNo;
	private JTable tableEmp;
	private JTextField searchField;
	private JTextField textAddress;
	private JTextField textUsername;
	private JTextField textPass;
	private JTextField textNIC;
	private JTable tableBills;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage window = new AdminPage();
					window.frameAdminPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameAdminPage = new JFrame();
		frameAdminPage.getContentPane().setBackground(new Color(255, 255, 255));
		frameAdminPage.getContentPane().setLayout(null);;
		
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
		frameAdminPage.getContentPane().add(closeBtn);
		
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
				frameAdminPage.setExtendedState(Frame.ICONIFIED);
			}
		});
		minimizeBtn.setFocusable(false);
		minimizeBtn.setFocusTraversalKeysEnabled(false);
		minimizeBtn.setContentAreaFilled(false);
		minimizeBtn.setBorder(new LineBorder(new Color(215, 188, 0), 68, true));
		minimizeBtn.setBounds(1236, 10, 18, 18);
		frameAdminPage.getContentPane().add(minimizeBtn);
		
		
//############################################################ TITLE PANEL ####################################################
		KGradientPanel titlePanel = new KGradientPanel();
		titlePanel.kStartColor = new Color(0, 184, 166);
		titlePanel.setkStartColor(new Color(0, 184, 166));
		titlePanel.kEndColor = new Color(53, 74, 84);
		titlePanel.setkEndColor(new Color(53, 74, 84));
		titlePanel.setBorder(null);
		titlePanel.setBounds(273, 0, 1026, 263);
		frameAdminPage.getContentPane().add(titlePanel);
		titlePanel.setLayout(null);
		
		
//###################################################################### SEARCH BOX ###############################################
		JPanel panelSearch = new JPanel();
		panelSearch.setVisible(false);
		panelSearch.setBackground(new Color(255, 255, 255));
		panelSearch.setBorder(new LineBorder(new Color(0, 184, 166), 3, true));
		panelSearch.setBounds(579, 28, 337, 45);
		titlePanel.add(panelSearch);
		panelSearch.setLayout(null);
		
		JTabbedPane productTbls = new JTabbedPane(JTabbedPane.TOP);
		JButton btnSearch = new JButton("");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PreparedStatement pstSnack, pstVege, pstMeat, pstJuices, pstHware, pstBpicks;
					Connection connection = DriverManager.getConnection(url, user, password);
					String PID = searchField.getText();
					
					pstSnack = connection.prepareStatement("select * from product_snacks where S_ID = '"+PID+"'");
					ResultSet rSID = pstSnack.executeQuery();
					while (rSID.next()) {
						
						txtPIDS.setText(rSID.getString("S_ID"));
						txtNameS.setText(rSID.getString("Name"));
						txtQtyS.setText(rSID.getString("Quantity"));
						txtPriceS.setText(rSID.getString("Price"));
						productTbls.setSelectedIndex(0);
						
						}
						
					pstVege = connection.prepareStatement("select * from product_vegetables where V_ID = '"+PID+"'");
					ResultSet rVID = pstVege.executeQuery();
					while (rVID.next()) {
						
						textPIDV.setText(rVID.getString("V_ID"));
						textNameV.setText(rVID.getString("Name"));
						textQtyV.setText(rVID.getString("Quantity"));
						textPriceV.setText(rVID.getString("Price"));
						productTbls.setSelectedIndex(1);
							
						}
					
					pstMeat = connection.prepareStatement("select * from product_fmeat where FM_ID = '"+PID+"'");
					ResultSet rMID = pstMeat.executeQuery();
					while (rMID.next()) {
						
						textPIDM.setText(rMID.getString("FM_ID"));
						textNameM.setText(rMID.getString("Name"));
						textQtyM.setText(rMID.getString("Quantity"));
						textPriceM.setText(rMID.getString("Price"));
						productTbls.setSelectedIndex(2);
							
						}
					
					pstJuices = connection.prepareStatement("select * from product_juice where J_ID = '"+PID+"'");
					ResultSet rJID = pstJuices.executeQuery();
					while (rJID.next()) {
						
						textPIDJ.setText(rJID.getString("J_ID"));
						textNameJ.setText(rJID.getString("Name"));
						textQtyJ.setText(rJID.getString("Quantity"));
						textPriceJ.setText(rJID.getString("Price"));
						productTbls.setSelectedIndex(3);
							
						}
					
					pstHware = connection.prepareStatement("select * from product_hware where HW_ID = '"+PID+"'");
					ResultSet rHID = pstHware.executeQuery();
					while (rHID.next()) {
						
						textPIDH.setText(rHID.getString("HW_ID"));
						textNameH.setText(rHID.getString("Name"));
						textQtyH.setText(rHID.getString("Quantity"));
						textPriceH.setText(rHID.getString("Price"));
						productTbls.setSelectedIndex(4);
							
						}
					
					pstBpicks = connection.prepareStatement("select * from product_bpicks where BP_ID = '"+PID+"'");
					ResultSet rBID = pstBpicks.executeQuery();
					while (rBID.next()) {
						
						textPIDB.setText(rBID.getString("BP_ID"));
						textNameB.setText(rBID.getString("Name"));
						textQtyB.setText(rBID.getString("Quantity"));
						textPriceB.setText(rBID.getString("Price"));
						productTbls.setSelectedIndex(5);
							
						}
				}
					
				 catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		btnSearch.setIcon(new ImageIcon(AdminPage.class.getResource("/basic/search.png")));
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
		
//######################################## TITLE NAMES >
		JLabel title = new JLabel("Home");
		title.setForeground(new Color(255, 255, 255));
		title.setFont(new Font("Century Gothic", Font.BOLD, 40));
		title.setIcon(new ImageIcon(AdminPage.class.getResource("/main/star.png")));
		title.setBounds(10, 0, 428, 109);
		titlePanel.add(title);
		
		JLabel lblWelcomeAdmin = new JLabel("Welcome, Admin!");
		lblWelcomeAdmin.setText("Welcome, "+userID);
		lblWelcomeAdmin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWelcomeAdmin.setForeground(Color.WHITE);
		lblWelcomeAdmin.setFont(new Font("Century Gothic", Font.BOLD, 45));
		lblWelcomeAdmin.setBounds(131, 154, 858, 75);
		titlePanel.add(lblWelcomeAdmin);
		
//######################################## MOVE PANEL >
		JPanel movePanel_1 = new JPanel();
		movePanel_1.setBounds(0, 0, 1016, 109);
		titlePanel.add(movePanel_1);
		movePanel_1.setOpaque(false);
		movePanel_1.setFocusable(false);
		movePanel_1.setBorder(null);
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
				frameAdminPage.setLocation(frameAdminPage.getX() + e.getX() - mouseX, frameAdminPage.getY() + e.getY() - mouseY);
			}
		});
		
		
//#################################################################### SIDE PANEL ##################################################
		
//######################################################## BUTTON SELECTED STATES >
		KGradientPanel sidePanel = new KGradientPanel();
		sidePanel.setBackground(new Color(0, 184, 166));
		sidePanel.setkStartColor(new Color(0, 196, 156));
		sidePanel.setkEndColor(new Color(1, 151, 194));
		sidePanel.setBounds(0, 0, 275, 668);
		frameAdminPage.getContentPane().add(sidePanel);
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
		btnProductsSelected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
		
		JButton btnEmployeesSelected = new JButton("Employees");
		btnEmployeesSelected.setVisible(false);
		btnEmployeesSelected.setForeground(new Color(1, 151, 194));
		btnEmployeesSelected.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		btnEmployeesSelected.setFocusable(false);
		btnEmployeesSelected.setFocusTraversalKeysEnabled(false);
		btnEmployeesSelected.setFocusPainted(false);
		btnEmployeesSelected.setBorderPainted(false);
		btnEmployeesSelected.setBackground(Color.WHITE);
		btnEmployeesSelected.setBounds(0, 373, 275, 55);
		sidePanel.add(btnEmployeesSelected);
		
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
		
		
		
		JLabel lblUsername = new JLabel("Admin");
		lblUsername.setText(userID);
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblUsername.setBounds(0, 194, 275, 36);
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		sidePanel.add(lblUsername);


		JTabbedPane sideMenuPages = new JTabbedPane(JTabbedPane.TOP);
		JPanel home = new JPanel();
		JPanel products = new JPanel();
		JPanel employees = new JPanel();
		JPanel sales = new JPanel();
		sideMenuPages.setBackground(new Color(0,0,0,0));
		
		
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sideMenuPages.setSelectedIndex(0);
				title.setText("Home");
				title.setIcon(new ImageIcon(AdminPage.class.getResource("/main/star.png")));
				titlePanel.setBounds(273, 0, 1026, 263);
				btnHomeSelected.setVisible(true);
				btnProductsSelected.setVisible(false);
				btnEmployeesSelected.setVisible(false);
				panelSearch.setVisible(false);
				btnSalesSelected.setVisible(false);
				lblWelcomeAdmin.setVisible(true);
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
		
		JButton btnProducts = new JButton("Products");
		btnProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sideMenuPages.setSelectedIndex(1);
				title.setText("Products");
				title.setIcon(new ImageIcon(AdminPage.class.getResource("/main/products.png")));
				titlePanel.setBounds(273, 0, 1026, 109);
				btnHomeSelected.setVisible(false);
				btnProductsSelected.setVisible(true);
				btnEmployeesSelected.setVisible(false);
				btnSalesSelected.setVisible(false);
				panelSearch.setVisible(true);
				lblWelcomeAdmin.setVisible(false);
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
		
		JButton btnEmployees = new JButton("Employees");
		btnEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sideMenuPages.setSelectedIndex(2);
				title.setText("Employees");
				title.setIcon(new ImageIcon(AdminPage.class.getResource("/main/employees.png")));
				titlePanel.setBounds(273, 0, 1026, 109);
				btnHomeSelected.setVisible(false);
				btnProductsSelected.setVisible(false);
				btnEmployeesSelected.setVisible(true);
				btnSalesSelected.setVisible(false);
				panelSearch.setVisible(false);
				lblWelcomeAdmin.setVisible(false);
			}
		});
		btnEmployees.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEmployees.setBackground(new Color(0, 202, 184));
				btnEmployees.setContentAreaFilled(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEmployees.setContentAreaFilled(false);
			}
		});
		btnEmployees.setForeground(Color.WHITE);
		btnEmployees.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		btnEmployees.setFocusable(false);
		btnEmployees.setFocusTraversalKeysEnabled(false);
		btnEmployees.setFocusPainted(false);
		btnEmployees.setContentAreaFilled(false);
		btnEmployees.setBorderPainted(false);
		btnEmployees.setBounds(0, 373, 275, 55);
		sidePanel.add(btnEmployees);
		
		JButton btnSales = new JButton("Sales");
		btnSales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sideMenuPages.setSelectedIndex(3);
				title.setText("Sales");
				title.setIcon(new ImageIcon(AdminPage.class.getResource("/main/sales.png")));
				titlePanel.setBounds(273, 0, 1026, 109);
				btnHomeSelected.setVisible(false);
				btnProductsSelected.setVisible(false);
				btnEmployeesSelected.setVisible(false);
				btnSalesSelected.setVisible(true);
				panelSearch.setVisible(false);
				lblWelcomeAdmin.setVisible(false);
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
		userImg.setIcon(new ImageIcon(AdminPage.class.getResource("/users/admin.png")));
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
		logo.setIcon(new ImageIcon(AdminPage.class.getResource("/main/star.png")));
		logo.setBounds(164, 10, 101, 118);
		sidePanel.add(logo);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				frameAdminPage.setVisible(false);
				
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
		star.setIcon(new ImageIcon(AdminPage.class.getResource("/main/star3.png")));
		star.setBounds(-291, 112, 565, 488);
		sidePanel.add(star);
		
		sideMenuPages.setBackground(new Color(255, 255, 255));
		sideMenuPages.setFocusable(false);
		sideMenuPages.setFocusTraversalKeysEnabled(false);
		sideMenuPages.setBorder(null);
		sideMenuPages.setBounds(273, 81, 1026, 587);
		frameAdminPage.getContentPane().add(sideMenuPages);
		
		home.setBackground(new Color(255, 255, 255));
		sideMenuPages.addTab("New tab", null, home, null);
		home.setLayout(null);
		
		JPanel movePanel = new JPanel();
		movePanel.setBounds(0, -106, 1011, 109);
		home.add(movePanel);
		movePanel.setOpaque(false);
		movePanel.setFocusable(false);
		movePanel.setBorder(null);
		
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
		lblTotalSales_1.setBounds(30, 24, 179, 50);
		salesTab.add(lblTotalSales_1);
		
		JLabel lblTotalNo_1 = new JLabel("0.00");
		try {
			PreparedStatement pst;
			Connection connection = DriverManager.getConnection(url, user, password);
			pst = connection.prepareStatement("select sum(Bil_Amount) from bills");
			ResultSet rs = pst.executeQuery();
			rs.next();
			String totalSales = rs.getString(1);
			
			lblTotalNo_1.setText("Rs."+totalSales);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		lblTotalNo_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalNo_1.setForeground(new Color(0, 221, 199));
		lblTotalNo_1.setFont(new Font("Century Gothic", Font.BOLD, 42));
		lblTotalNo_1.setBounds(66, 84, 201, 91);
		salesTab.add(lblTotalNo_1);
		
		JLabel lblSicon = new JLabel("");
		lblSicon.setIcon(new ImageIcon(AdminPage.class.getResource("/side_menu/sales ico.png")));
		lblSicon.setBounds(98, 190, 96, 123);
		salesTab.add(lblSicon);
		
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
		
		JLabel lblAddA = new JLabel("Add a");
		lblAddA.setForeground(Color.WHITE);
		lblAddA.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblAddA.setBounds(30, 24, 106, 50);
		productsTab.add(lblAddA);
		
		JLabel lblProduct = new JLabel("Product");
		lblProduct.setForeground(Color.WHITE);
		lblProduct.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblProduct.setBounds(30, 74, 179, 50);
		productsTab.add(lblProduct);
		
		JLabel lblPicon = new JLabel("");
		lblPicon.setIcon(new ImageIcon(AdminPage.class.getResource("/side_menu/category.png")));
		lblPicon.setBounds(98, 190, 96, 123);
		productsTab.add(lblPicon);
		
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
				btnEmployees.doClick();
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
		
		JLabel lblView = new JLabel("View");
		lblView.setForeground(Color.WHITE);
		lblView.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblView.setBounds(30, 24, 179, 50);
		empTab.add(lblView);
		
		JLabel lblEmployee = new JLabel("Employee");
		lblEmployee.setForeground(Color.WHITE);
		lblEmployee.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblEmployee.setBounds(30, 74, 179, 50);
		empTab.add(lblEmployee);
		
		JLabel lblDetails = new JLabel("Details");
		lblDetails.setForeground(Color.WHITE);
		lblDetails.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblDetails.setBounds(30, 124, 179, 50);
		empTab.add(lblDetails);
		
		JLabel lblEMPicon = new JLabel("");
		lblEMPicon.setIcon(new ImageIcon(AdminPage.class.getResource("/side_menu/sellers ico.png")));
		lblEMPicon.setBounds(98, 190, 96, 123);
		empTab.add(lblEMPicon);
		
		products.setBackground(Color.WHITE);
		sideMenuPages.addTab("New tab", null, products, null);
		products.setLayout(null);
		
		
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
		
/*##############################################################################################################################################
##########################################################     SNACKS TABLE      ###############################################################
################################################################################################################################################*/
		
		JPanel snacks = new JPanel();
		snacks.setFocusTraversalKeysEnabled(false);
		snacks.setFocusable(false);
		snacks.setBackground(new Color(255, 255, 255));
		productTbls.addTab("Snacks", null, snacks, null);
		snacks.setLayout(null);
		productTbls.setBackgroundAt(0, new Color(185, 17, 17));
		
		JPanel EditS = new JPanel();
		EditS.setName("");
		EditS.setBackground(new Color(255, 255, 255));
		EditS.setBorder(new LineBorder(new Color(1, 151, 194), 3, true));
		EditS.setBounds(35, 15, 389, 480);
		snacks.add(EditS);
		EditS.setLayout(null);
		
		txtPIDS = new JTextField();
		// adding next PID to the text field
				try {
					PreparedStatement pstAutoID;
					Connection connection = DriverManager.getConnection(url, user, password);
					pstAutoID = connection.prepareStatement("select S_ID from product_snacks order by S_ID desc limit 1");
					ResultSet rs = pstAutoID.executeQuery();
					
					if(rs.next()) {
						String id = rs.getString(1);
						String no = id.replaceAll("[^0-9]", "");
						String idno = "SN" + String.format("%02d", (Integer.parseInt(no)+1));
						txtPIDS.setText(idno);
					}
					
					
				} catch (Exception e) {
					
				}
		txtPIDS.setForeground(new Color(53, 74, 84));
		txtPIDS.setFont(new Font("Century Gothic", Font.BOLD, 15));
		txtPIDS.setBorder(new TitledBorder(new LineBorder(new Color(1, 151, 194), 2, true), "Product ID", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(1, 151, 194)));
		txtPIDS.setBounds(53, 48, 289, 49);
		EditS.add(txtPIDS);
		txtPIDS.setColumns(10);
		
		txtNameS = new JTextField();
		txtNameS.setForeground(new Color(53, 74, 84));
		txtNameS.setFont(new Font("Century Gothic", Font.BOLD, 15));
		txtNameS.setColumns(10);
		txtNameS.setBorder(new TitledBorder(new LineBorder(new Color(1, 151, 194), 2, true), "Name", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(1, 151, 194)));
		txtNameS.setBounds(53, 120, 289, 49);
		EditS.add(txtNameS);
		
		txtQtyS = new JTextField();
		txtQtyS.setForeground(new Color(53, 74, 84));
		txtQtyS.setFont(new Font("Century Gothic", Font.BOLD, 15));
		txtQtyS.setColumns(10);
		txtQtyS.setBorder(new TitledBorder(new LineBorder(new Color(1, 151, 194), 2, true), "Quantity", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(1, 151, 194)));
		txtQtyS.setBounds(53, 188, 289, 49);
		EditS.add(txtQtyS);
		
		txtPriceS = new JTextField();
		txtPriceS.setFont(new Font("Century Gothic", Font.BOLD, 15));
		txtPriceS.setColumns(10);
		txtPriceS.setBorder(new TitledBorder(new LineBorder(new Color(1, 151, 194), 2, true), "Price", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(1, 151, 194)));
		txtPriceS.setBounds(53, 253, 289, 49);
		EditS.add(txtPriceS);
		
/*########################################################    SNACKS ADD BUTTON      ################################################################
#####################################################################################################################################################*/	
		
		JButton btnAddS = new JButton("");
		btnAddS.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddS.setBounds(44, 329, 70, 70);
		EditS.add(btnAddS);
		btnAddS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				//connecting to database
					PreparedStatement pstAdd, pstAutoID, pstUpdate;
					Connection connection = DriverManager.getConnection(url, user, password);
					pstAutoID = connection.prepareStatement("select S_ID from product_snacks");
					pstAdd = connection.prepareStatement("insert into product_snacks values (?,?,?,?)");
					
				//getting texts from textFields and insert them to database table
					pstAdd.setString(1, txtPIDS.getText());
					pstAdd.setString(2, txtNameS.getText());
                    pstAdd.setString(3, txtQtyS.getText());		
                    pstAdd.setString(4, txtPriceS.getText());
					
				
					
					int row = pstAdd.executeUpdate();
					if(row > 0)
						JOptionPane.showMessageDialog(btnAddS, "Record Added");
					else 
						JOptionPane.showMessageDialog(btnAddS, "Error");
				
				//insert next PID to the PID text field	
					pstAutoID = connection.prepareStatement("select S_ID from product_snacks order by S_ID desc limit 1");
					ResultSet rs = pstAutoID.executeQuery();
					
					if(rs.next()) {
						String id = rs.getString(1);
						String no = id.replaceAll("[^0-9]", "");
						String idno = "SN" + String.format("%02d", (Integer.parseInt(no)+1));
						txtPIDS.setText(idno);
						txtNameS.setText(null);
						txtQtyS.setText(null);
						txtPriceS.setText(null);
					}
					
				//updating the table
					pstUpdate = connection.prepareStatement("select * from product_snacks");
					rs = pstUpdate.executeQuery();
					tableS.setModel(DbUtils.resultSetToTableModel(rs));
					
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
				
					connection.close();
					
					
					
				} catch (Exception e2) {
			
				}
			}
		});
		btnAddS.setBackground(new Color(255, 255, 255));
		btnAddS.setIcon(new ImageIcon(AdminPage.class.getResource("/basic/add.png")));
		btnAddS.setFocusTraversalKeysEnabled(false);
		btnAddS.setFocusable(false);
		btnAddS.setBorder(null);
		btnAddS.setBorderPainted(false);
		
/*########################################################    SNACKS REMOVE BUTTON      ################################################################
#######################################################################################################################################################*/		
		
		JButton btnRemoveS = new JButton("");
		btnRemoveS.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRemoveS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//connecting to database
						PreparedStatement pstRemove, pstUpdate, pstAutoID;
						Connection connection = DriverManager.getConnection(url, user, password);
						pstRemove = connection.prepareStatement("Delete from product_snacks where S_ID = ?");
					
						
						pstRemove.setString(1, txtPIDS.getText());
					
						
						int row = pstRemove.executeUpdate();
						if(row > 0) {
							JOptionPane.showMessageDialog(btnRemoveS, "Record Deleted");
							txtPIDS.setText(null);
							txtNameS.setText(null);
							txtQtyS.setText(null);
							txtPriceS.setText(null);
						}
						else 
							JOptionPane.showMessageDialog(btnRemoveS, "Error");
				
						//insert next PID to the PID text field	
						pstAutoID = connection.prepareStatement("select S_ID from product_snacks order by S_ID desc limit 1");
						ResultSet rs = pstAutoID.executeQuery();
						
						if(rs.next()) {
							String id = rs.getString(1);
							String no = id.replaceAll("[^0-9]", "");
							String idno = "SN" + String.format("%02d", (Integer.parseInt(no)+1));
							txtPIDS.setText(idno);
							txtNameS.setText(null);
							txtQtyS.setText(null);
							txtPriceS.setText(null);
						}
					//updating the table
						pstUpdate = connection.prepareStatement("select * from product_snacks");
						rs = pstUpdate.executeQuery();
						tableS.setModel(DbUtils.resultSetToTableModel(rs));
						
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
					
						connection.close();
						
						
					} catch (Exception e2) {
					
					}
			}
		});
		btnRemoveS.setBounds(124, 329, 70, 70);
		EditS.add(btnRemoveS);
		btnRemoveS.setBackground(new Color(255, 255, 255));
		btnRemoveS.setIcon(new ImageIcon(AdminPage.class.getResource("/basic/remove.png")));
		btnRemoveS.setBorderPainted(false);
		btnRemoveS.setFocusable(false);
		
/*########################################################    SNACKS SAVE BUTTON      ################################################################
 #####################################################################################################################################################*/
		
		JButton btnSaveS = new JButton("");
		btnSaveS.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSaveS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				//connecting to database
					PreparedStatement pstSave, pstUpdate,pstAutoID;
					Connection connection = DriverManager.getConnection(url, user, password);
					pstSave = connection.prepareStatement("update product_snacks set Name = ?, Quantity = ?, Price = ? where S_ID = ?");
				//////////
					
				//getting texts from textFields and insert them to database table
					pstSave.setString(4, txtPIDS.getText());
					pstSave.setString(1, txtNameS.getText());
					pstSave.setString(2, txtQtyS.getText());
					pstSave.setString(3, txtPriceS.getText());	
					
					
					int row = pstSave.executeUpdate();
					if(row > 0) {
						JOptionPane.showMessageDialog(btnSaveS, "Record Updated");
						txtPIDS.setText(null);
						txtNameS.setText(null);
						txtQtyS.setText(null);
						txtPriceS.setText(null);
					}
					else 
						JOptionPane.showMessageDialog(btnSaveS, "Error");
				
				//insert next PID to the PID text field	
					pstAutoID = connection.prepareStatement("select S_ID from product_snacks order by S_ID desc limit 1");
					ResultSet rs = pstAutoID.executeQuery();
					
					if(rs.next()) {
						String id = rs.getString(1);
						String no = id.replaceAll("[^0-9]", "");
						String idno = "SN" + String.format("%02d", (Integer.parseInt(no)+1));
						txtPIDS.setText(idno);
						txtNameS.setText(null);
						txtQtyS.setText(null);
						txtPriceS.setText(null);
					}
					
				//updating the table
					pstUpdate = connection.prepareStatement("select * from product_snacks");
					rs = pstUpdate.executeQuery();
					tableS.setModel(DbUtils.resultSetToTableModel(rs));
					
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
				
					connection.close();
					
					
				} catch (Exception e2) {
					
				}
			}
		});
		btnSaveS.setBounds(204, 329, 70, 70);
		EditS.add(btnSaveS);
		btnSaveS.setIcon(new ImageIcon(AdminPage.class.getResource("/basic/successBlue.png")));
		btnSaveS.setFocusable(false);
		btnSaveS.setBorderPainted(false);
		btnSaveS.setBackground(Color.WHITE);
		
/*########################################################    SNACKS RESET BUTTON      ################################################################
#######################################################################################################################################################*/	
		
		JButton btnResetS = new JButton("");
		btnResetS.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnResetS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PreparedStatement pstAutoID;
					Connection connection = DriverManager.getConnection(url, user, password);
					pstAutoID = connection.prepareStatement("select S_ID from product_snacks order by S_ID desc limit 1");
					ResultSet rs = pstAutoID.executeQuery();
					
					if(rs.next()) {
						String id = rs.getString(1);
						String no = id.replaceAll("[^0-9]", "");
						String idno = "SN" + String.format("%02d", (Integer.parseInt(no)+1));
						txtPIDS.setText(idno);
						txtNameS.setText(null);
						txtQtyS.setText(null);
						txtPriceS.setText(null);
					}
					
				} catch (Exception e2) {
					
				}
			}
		});
		
		btnResetS.setBounds(284, 329, 70, 70);
		EditS.add(btnResetS);
		btnResetS.setIcon(new ImageIcon(AdminPage.class.getResource("/basic/reset.png")));
		btnResetS.setFocusable(false);
		btnResetS.setBorderPainted(false);
		btnResetS.setBackground(Color.WHITE);
		
		JLabel lblAdd = new JLabel("Add");
		lblAdd.setBounds(44, 399, 70, 24);
		EditS.add(lblAdd);
		lblAdd.setForeground(new Color(0, 196, 0));
		lblAdd.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblAdd.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblRemove = new JLabel("Remove");
		lblRemove.setBounds(124, 399, 70, 24);
		EditS.add(lblRemove);
		lblRemove.setForeground(new Color(185, 17, 17));
		lblRemove.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemove.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		
		JLabel lblSave = new JLabel("Save");
		lblSave.setBounds(204, 399, 70, 24);
		EditS.add(lblSave);
		lblSave.setForeground(new Color(1, 151, 194));
		lblSave.setHorizontalAlignment(SwingConstants.CENTER);
		lblSave.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		
		JLabel lblReset = new JLabel("Reset");
		lblReset.setBounds(284, 399, 70, 24);
		EditS.add(lblReset);
		lblReset.setForeground(new Color(0, 128, 128));
		lblReset.setHorizontalAlignment(SwingConstants.CENTER);
		lblReset.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		
		JScrollPane scrollPaneS = new JScrollPane();
		scrollPaneS.setBorder(new LineBorder(new Color(185, 17, 17), 3, true));
		scrollPaneS.setBackground(new Color(255, 255, 255));
		scrollPaneS.setForeground(new Color(185, 17, 17));
		scrollPaneS.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		scrollPaneS.setBounds(446, 15, 525, 480);
		snacks.add(scrollPaneS);
		
		tableS = new JTable();
		try {
			PreparedStatement pStatement;
			Connection connection = DriverManager.getConnection(url, user, password);
			pStatement = connection.prepareStatement("select * from product_snacks");
			ResultSet rs = pStatement.executeQuery();
			tableS.setModel(DbUtils.resultSetToTableModel(rs));
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
			
			
			pStatement.close();
			connection.close();
			
		} catch (Exception e) {
			
		}
		
		//update text fields according table row clicks
		tableS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				//connecting to database
					Connection connection = DriverManager.getConnection(url, user, password);
				
					int row = tableS.getSelectedRow();
					String S_ID_ = (tableS.getModel().getValueAt(row, 0)).toString();
					PreparedStatement pst = connection.prepareStatement("select * from product_snacks where S_ID = '"+S_ID_+"' ");
					ResultSet rs = pst.executeQuery();
					
					while (rs.next()) {
						txtPIDS.setText(rs.getString("S_ID"));
						txtNameS.setText(rs.getString("Name"));
						txtQtyS.setText(rs.getString("Quantity"));
						txtPriceS.setText(rs.getString("Price"));
						
					}
					
					pst.close();
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		
		tableS.setForeground(new Color(53, 74, 84));
		tableS.setFont(new Font("Century Gothic", Font.BOLD, 12));
		tableS.setGridColor(new Color(185, 17, 17));
		scrollPaneS.setViewportView(tableS);
		tableS.setRowHeight(35);
		tableS.setBorder(new MatteBorder(3, 0, 0, 0, (Color) new Color(185, 17, 17)));
	
/*##############################################################################################################################################
##########################################################     VEGETABLES TABLE      ###########################################################
################################################################################################################################################*/
		
		JPanel vegetables = new JPanel();
		vegetables.setLayout(null);
		vegetables.setFocusable(false);
		vegetables.setFocusTraversalKeysEnabled(false);
		vegetables.setBackground(Color.WHITE);
		productTbls.addTab("Vegetables", null, vegetables, null);
		productTbls.setBackgroundAt(1, new Color(92, 190, 46));
		
		JPanel EditV = new JPanel();
		EditV.setLayout(null);
		EditV.setBorder(new LineBorder(new Color(1, 151, 194), 3, true));
		EditV.setBackground(Color.WHITE);
		EditV.setBounds(35, 15, 389, 480);
		vegetables.add(EditV);
		
		textPIDV = new JTextField();
		// adding next PID to the text field
		try {
			PreparedStatement pstAutoID;
			Connection connection = DriverManager.getConnection(url, user, password);
			pstAutoID = connection.prepareStatement("select V_ID from product_vegetables order by V_ID desc limit 1");
			ResultSet rs = pstAutoID.executeQuery();
			
			if(rs.next()) {
				String id = rs.getString(1);
				String no = id.replaceAll("[^0-9]", "");
				String idno = "VG" + String.format("%02d", (Integer.parseInt(no)+1));
				textPIDV.setText(idno);
			}
		} catch (Exception e) {
		
		}
		
		textPIDV.setForeground(new Color(53, 74, 84));
		textPIDV.setFont(new Font("Century Gothic", Font.BOLD, 15));
		textPIDV.setColumns(10);
		textPIDV.setBorder(new TitledBorder(new LineBorder(new Color(1, 151, 194), 2, true), "Product ID", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(1, 151, 194)));
		textPIDV.setBounds(53, 48, 289, 49);
		EditV.add(textPIDV);
		
		textNameV = new JTextField();
		textNameV.setForeground(new Color(53, 74, 84));
		textNameV.setFont(new Font("Century Gothic", Font.BOLD, 15));
		textNameV.setColumns(10);
		textNameV.setBorder(new TitledBorder(new LineBorder(new Color(1, 151, 194), 2, true), "Name", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(1, 151, 194)));
		textNameV.setBounds(53, 120, 289, 49);
		EditV.add(textNameV);
		
		textQtyV = new JTextField();
		textQtyV.setForeground(new Color(53, 74, 84));
		textQtyV.setFont(new Font("Century Gothic", Font.BOLD, 15));
		textQtyV.setColumns(10);
		textQtyV.setBorder(new TitledBorder(new LineBorder(new Color(1, 151, 194), 2, true), "Quantity", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(1, 151, 194)));
		textQtyV.setBounds(53, 188, 289, 49);
		EditV.add(textQtyV);
		
		textPriceV = new JTextField();
		textPriceV.setFont(new Font("Century Gothic", Font.BOLD, 15));
		textPriceV.setColumns(10);
		textPriceV.setBorder(new TitledBorder(new LineBorder(new Color(1, 151, 194), 2, true), "Price", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(1, 151, 194)));
		textPriceV.setBounds(53, 253, 289, 49);
		EditV.add(textPriceV);
		
/*####################################################      VEGETABLES ADD BUTTON      #########################################################
################################################################################################################################################*/
				
		
		JButton btnAddV = new JButton("");
		btnAddV.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				//connecting to database
				PreparedStatement pstAdd, pstAutoID, pstUpdate;
				Connection connection = DriverManager.getConnection(url, user, password);
				pstAutoID = connection.prepareStatement("select V_ID from product_vegetables");
				pstAdd = connection.prepareStatement("insert into product_vegetables values (?,?,?,?)");
				
				//getting texts from textFields and insert them to database table
				pstAdd.setString(1, textPIDV.getText());
				pstAdd.setString(2, textNameV.getText());
				pstAdd.setString(3, textQtyV.getText());
				pstAdd.setString(4, textPriceV.getText());
				
				int row = pstAdd.executeUpdate();
				if(row > 0)
					JOptionPane.showMessageDialog(btnAddS, "Record Added");
				else
					JOptionPane.showMessageDialog(btnAddS, "Error");
			
				
				//insert next PID to the PID text field
				pstAutoID = connection.prepareStatement("select V_ID from product_vegetables order by V_ID desc limit 1");
				ResultSet rs = pstAutoID.executeQuery();
				if(rs.next()) {
				String id = rs.getString(1);
				String no = id.replaceAll("[^0-9]", "");
				String idno = "VG" + String.format("%02d", (Integer.parseInt(no)+1));
					textPIDV.setText(idno);
					textNameV.setText(null);
					textQtyV.setText(null);
					textPriceV.setText(null);
				}
				
				//updating the table
				pstUpdate = connection.prepareStatement("select * from product_vegetables");
				rs = pstUpdate.executeQuery();
				tableV.setModel(DbUtils.resultSetToTableModel(rs));
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
			
				connection.close();
				
				} catch (Exception e2) {
					
				}
			}
		});
		btnAddV.setIcon(new ImageIcon(AdminPage.class.getResource("/basic/add.png")));
		btnAddV.setFocusable(false);
		btnAddV.setFocusTraversalKeysEnabled(false);
		btnAddV.setBorderPainted(false);
		btnAddV.setBorder(null);
		btnAddV.setBackground(Color.WHITE);
		btnAddV.setBounds(44, 329, 70, 70);
		EditV.add(btnAddV);
		
/*####################################################      VEGETABLES REMOVE BUTTON      ######################################################
################################################################################################################################################*/
		
		JButton btnRemoveV = new JButton("");
		btnRemoveV.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRemoveV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
			//connecting to database
			PreparedStatement pstRemove, pstUpdate, pstAutoID;
			Connection connection = DriverManager.getConnection(url, user, password);
			pstRemove = connection.prepareStatement("Delete from product_vegetables where V_ID = ?");
			
			pstRemove.setString(1, textPIDV.getText());
			int row = pstRemove.executeUpdate();
			if(row > 0) {
			JOptionPane.showMessageDialog(btnRemoveS, "Record Deleted");
			textPIDV.setText(null);
			textNameV.setText(null);
			textQtyV.setText(null);
			textPriceV.setText(null);
			}
			else
			JOptionPane.showMessageDialog(btnRemoveS, "Error");
			
			//insert next PID to the PID text field
			pstAutoID = connection.prepareStatement("select V_ID from product_vegetables order by V_ID desc limit 1");
			ResultSet rs = pstAutoID.executeQuery();
			
			if(rs.next()) {
				String id = rs.getString(1);
				String no = id.replaceAll("[^0-9]", "");
				String idno = "VG" + String.format("%02d", (Integer.parseInt(no)+1));
				textPIDV.setText(idno);
				textNameV.setText(null);
				textQtyV.setText(null);
				textPriceV.setText(null);
			}
			//updating the table
			pstUpdate = connection.prepareStatement("select * from product_vegetables");
			rs = pstUpdate.executeQuery();
			tableV.setModel(DbUtils.resultSetToTableModel(rs));
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
			
			connection.close();
			} catch (Exception e2) {
			
			}
			}
			});
		btnRemoveV.setIcon(new ImageIcon(AdminPage.class.getResource("/basic/remove.png")));
		btnRemoveV.setFocusable(false);
		btnRemoveV.setBorderPainted(false);
		btnRemoveV.setBackground(Color.WHITE);
		btnRemoveV.setBounds(124, 329, 70, 70);
		EditV.add(btnRemoveV);
		
/*####################################################      VEGETABLES SAVE BUTTON      ######################################################
################################################################################################################################################*/
		
		JButton btnSaveV = new JButton("");
		btnSaveV.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSaveV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
			//connecting to database
			PreparedStatement pstSave, pstUpdate, pstAutoID;
			Connection connection = DriverManager.getConnection(url, user, password);
			pstSave = connection.prepareStatement("update product_vegetables set Name = ?, Quantity = ?, Price = ? where V_ID = ?");
			
			//getting texts from textFields and insert them to database table
			pstSave.setString(4, textPIDV.getText());
			pstSave.setString(1, textNameV.getText());
			pstSave.setString(2, textQtyV.getText());
			pstSave.setString(3, textPriceV.getText());
			int row = pstSave.executeUpdate();
			if(row > 0) {
			JOptionPane.showMessageDialog(btnSaveS, "Record Updated");
			textPIDV.setText(null);
			textNameV.setText(null);
			textQtyV.setText(null);
			textPriceV.setText(null);
			}
			else
			JOptionPane.showMessageDialog(btnSaveS, "Error");
			
			//insert next PID to the PID text field
			pstAutoID = connection.prepareStatement("select V_ID from product_vegetables order by V_ID desc limit 1");
			ResultSet rs = pstAutoID.executeQuery();
			
			if(rs.next()) {
				String id = rs.getString(1);
				String no = id.replaceAll("[^0-9]", "");
				String idno = "VG" + String.format("%02d", (Integer.parseInt(no)+1));
				textPIDV.setText(idno);
				textNameV.setText(null);
				textQtyV.setText(null);
				textPriceV.setText(null);
			}
			//updating the table
			pstUpdate = connection.prepareStatement("select * from product_vegetables");
			rs = pstUpdate.executeQuery();
			tableV.setModel(DbUtils.resultSetToTableModel(rs));
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
			
		
			connection.close();
			} catch (Exception e2) {
			
			}
			}
			});
		btnSaveV.setIcon(new ImageIcon(AdminPage.class.getResource("/basic/successBlue.png")));
		btnSaveV.setFocusable(false);
		btnSaveV.setBorderPainted(false);
		btnSaveV.setBackground(Color.WHITE);
		btnSaveV.setBounds(204, 329, 70, 70);
		EditV.add(btnSaveV);
		
/*####################################################      VEGETABLES RESET BUTTON      #######################################################
################################################################################################################################################*/
		
		JButton btnResetV = new JButton("");
		btnResetV.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnResetV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PreparedStatement pstAutoID;
					Connection connection = DriverManager.getConnection(url, user, password);
					pstAutoID = connection.prepareStatement("select V_ID from product_vegetables order by V_ID desc limit 1");
					ResultSet rs = pstAutoID.executeQuery();
					
					if(rs.next()) {
						String id = rs.getString(1);
						String no = id.replaceAll("[^0-9]", "");
						String idno = "VG" + String.format("%02d", (Integer.parseInt(no)+1));
						textPIDV.setText(idno);
						textNameV.setText(null);
						textQtyV.setText(null);
						textPriceV.setText(null);
					}
					
				} catch (Exception e2) {
				
				}
			}
			});
		btnResetV.setIcon(new ImageIcon(AdminPage.class.getResource("/basic/reset.png")));
		btnResetV.setFocusable(false);
		btnResetV.setBorderPainted(false);
		btnResetV.setBackground(Color.WHITE);
		btnResetV.setBounds(284, 329, 70, 70);
		EditV.add(btnResetV);
		
		JLabel lblAdd_1 = new JLabel("Add");
		lblAdd_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdd_1.setForeground(new Color(0, 196, 0));
		lblAdd_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblAdd_1.setBounds(44, 399, 70, 24);
		EditV.add(lblAdd_1);
		
		JLabel lblRemove_1 = new JLabel("Remove");
		lblRemove_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemove_1.setForeground(new Color(185, 17, 17));
		lblRemove_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblRemove_1.setBounds(124, 399, 70, 24);
		EditV.add(lblRemove_1);
		
		JLabel lblSave_1 = new JLabel("Save");
		lblSave_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSave_1.setForeground(new Color(1, 151, 194));
		lblSave_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblSave_1.setBounds(204, 399, 70, 24);
		EditV.add(lblSave_1);
		
		JLabel lblReset_1 = new JLabel("Reset");
		lblReset_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblReset_1.setForeground(new Color(0, 128, 128));
		lblReset_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblReset_1.setBounds(284, 399, 70, 24);
		EditV.add(lblReset_1);
		
		JScrollPane scrollPaneV = new JScrollPane();
		scrollPaneV.setBorder(new LineBorder(new Color(92, 190, 46), 3, true));
		scrollPaneV.setBackground(new Color(255, 255, 255));
		scrollPaneV.setForeground(new Color(53, 74, 84));
		scrollPaneV.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		scrollPaneV.setBounds(446, 15, 525, 480);
		vegetables.add(scrollPaneV);
		
		tableV = new JTable();
		try {
			PreparedStatement pStatement;
			Connection connection = DriverManager.getConnection(url, user, password);
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
			
		}
		
		//update text fields according table row clicks
		tableV.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		try {
		//connecting to database
		Connection connection = DriverManager.getConnection(url, user, password);
		
		int row = tableV.getSelectedRow();
		String PID = (tableV.getModel().getValueAt(row, 0)).toString();
		PreparedStatement pst = connection.prepareStatement("select * from product_vegetables where V_ID = '"+PID+"' ");
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
		textPIDV.setText(rs.getString("V_ID"));
		textNameV.setText(rs.getString("Name"));
		textQtyV.setText(rs.getString("Quantity"));
		textPriceV.setText(rs.getString("Price"));
		}
		pst.close();
		} catch (Exception e2) {
		e2.printStackTrace();
		}
		}
		});
	
		tableV.setForeground(new Color(53, 74, 84));
		tableV.setFont(new Font("Century Gothic", Font.BOLD, 12));
		tableV.setGridColor(new Color(92, 190, 46));
		scrollPaneV.setViewportView(tableV);
		tableV.setRowHeight(35);
		tableV.setBorder(new MatteBorder(3, 0, 0, 0, (Color) new Color(92, 190, 46)));

/*##############################################################################################################################################
##########################################################     MEAT TABLE      #################################################################
################################################################################################################################################*/
		
		JPanel meat = new JPanel();
		meat.setLayout(null);
		meat.setFocusable(false);
		meat.setFocusTraversalKeysEnabled(false);
		meat.setBackground(Color.WHITE);
		productTbls.addTab("Fresh Meat", null, meat, null);
		productTbls.setBackgroundAt(2, new Color(130, 130, 130));
		
		JPanel EditM = new JPanel();
		EditM.setLayout(null);
		EditM.setBorder(new LineBorder(new Color(1, 151, 194), 3, true));
		EditM.setBackground(Color.WHITE);
		EditM.setBounds(35, 15, 389, 480);
		meat.add(EditM);
		
/*########################################################    MEAT ADD BUTTON      ################################################################
#####################################################################################################################################################*/
		
		JButton btnAddM = new JButton("");
		btnAddM.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 btnAddM.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			 try { 
			 //connecting to database
			 PreparedStatement pstAdd, pstAutoID, pstUpdate; 
			 Connection connection = DriverManager.getConnection(url, user, password);
			 pstAutoID = connection.prepareStatement("select FM_ID from product_fmeat");
			 pstAdd = connection.prepareStatement("insert into product_fmeat values (?,?,?,?)");
			 
			 
			 //getting texts from textFields and insert them to database table
			 pstAdd.setString(1, textPIDM.getText());
			 pstAdd.setString(2, textNameM.getText());
			 pstAdd.setString(3, textQtyM.getText());
			 pstAdd.setString(4, textPriceM.getText());
			 
			 
			 int row = pstAdd.executeUpdate();
			 if(row > 0)
			 JOptionPane.showMessageDialog(btnAddM, "Record Added");
			 else 
			 JOptionPane.showMessageDialog(btnAddM, "Error");
			
			 
			 //insert next PID to the PID text field
			 pstAutoID = connection.prepareStatement("select FM_ID from product_fmeat order by FM_ID desc limit 1");
			 ResultSet rs = pstAutoID.executeQuery();
			 
			 if(rs.next()) {
			 String id = rs.getString(1);
			 String no = id.replaceAll("[^0-9]", "");
			 String idno = "FM" + String.format("%02d", (Integer.parseInt(no)+1));
			 textPIDM.setText(idno);
			 textNameM.setText(null);
			 textQtyM.setText(null);
			 textPriceM.setText(null);
			 } 
			 
			 //updating the table
			 pstUpdate = connection.prepareStatement("select * from product_fmeat");
			 rs = pstUpdate.executeQuery();
			 tableM.setModel(DbUtils.resultSetToTableModel(rs));
			 
			 DefaultTableModel model = (DefaultTableModel) tableM.getModel();
			 
			 String[] colName = {"PID", "Name", "Quantity", "Price"};
			 model.setColumnIdentifiers(colName);
			 
			 TableColumnModel columnModel = tableM.getColumnModel();
			 columnModel.getColumn(0).setPreferredWidth(5);
			 columnModel.getColumn(1).setPreferredWidth(200);
			 columnModel.getColumn(2).setPreferredWidth(10);
			 columnModel.getColumn(3).setPreferredWidth(15);
			 
			 DefaultTableCellRenderer right = new DefaultTableCellRenderer();
			 DefaultTableCellRenderer center = new DefaultTableCellRenderer();
			 right.setHorizontalAlignment(JLabel.RIGHT);
			 center.setHorizontalAlignment(JLabel.CENTER);
			 
			 tableM.getColumnModel().getColumn(0).setCellRenderer(center);
			 tableM.getColumnModel().getColumn(2).setCellRenderer(center);
			 tableM.getColumnModel().getColumn(3).setCellRenderer(right);
			
			 connection.close();
			 
			
			 
			 
			 } catch (Exception e2) {
			
			 } 
			 } 
			 });
		btnAddM.setIcon(new ImageIcon(AdminPage.class.getResource("/basic/add.png")));
		btnAddM.setFocusable(false);
		btnAddM.setFocusTraversalKeysEnabled(false);
		btnAddM.setBorderPainted(false);
		btnAddM.setBorder(null);
		btnAddM.setBackground(Color.WHITE);
		btnAddM.setBounds(44, 329, 70, 70);
		EditM.add(btnAddM);
		
/*########################################################    MEAT REMOVE BUTTON      ################################################################
#####################################################################################################################################################*/
				
		
		JButton btnRemoveM = new JButton("");
		btnRemoveM.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRemoveM.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			 try { 
			 //connecting to database
			 PreparedStatement pstRemove, pstUpdate, pstAutoID; 
			 Connection connection = DriverManager.getConnection(url, user, password);
			 pstRemove = connection.prepareStatement("Delete from product_fmeat where FM_ID = ?");
			 
			 
			 pstRemove.setString(1, textPIDM.getText());
			 
			 
			 int row = pstRemove.executeUpdate();
			 if(row > 0) {
			 JOptionPane.showMessageDialog(btnRemoveM, "Record Deleted");
			 textPIDM.setText(null);
			 textNameM.setText(null);
			 textQtyM.setText(null);
			 textPriceM.setText(null);
			 } 
			 else 
			 JOptionPane.showMessageDialog(btnRemoveM, "Error");

			//insert next PID to the PID text field
				pstAutoID = connection.prepareStatement("select FM_ID from product_fmeat order by FM_ID desc limit 1");
				ResultSet rs = pstAutoID.executeQuery();
				if(rs.next()) {
				String id = rs.getString(1);
				String no = id.replaceAll("[^0-9]", "");
				String idno = "FM" + String.format("%02d", (Integer.parseInt(no)+1));
					textPIDM.setText(idno);
					textNameM.setText(null);
					textQtyM.setText(null);
					textPriceM.setText(null);
				}
			 
			 //updating the table
			 pstUpdate = connection.prepareStatement("select * from product_fmeat");
			 rs = pstUpdate.executeQuery();
			 tableM.setModel(DbUtils.resultSetToTableModel(rs));
			 
			 DefaultTableModel model = (DefaultTableModel) tableM.getModel();
			 
			 String[] colName = {"PID", "Name", "Quantity", "Price"};
			 model.setColumnIdentifiers(colName);
			 
			 TableColumnModel columnModel = tableM.getColumnModel();
			 columnModel.getColumn(0).setPreferredWidth(5);
			 columnModel.getColumn(1).setPreferredWidth(200);
			 columnModel.getColumn(2).setPreferredWidth(10);
			 columnModel.getColumn(3).setPreferredWidth(15);
			 
			 DefaultTableCellRenderer right = new DefaultTableCellRenderer();
			 DefaultTableCellRenderer center = new DefaultTableCellRenderer();
			 right.setHorizontalAlignment(JLabel.RIGHT);
			 center.setHorizontalAlignment(JLabel.CENTER);
			 
			 tableM.getColumnModel().getColumn(0).setCellRenderer(center);
			 tableM.getColumnModel().getColumn(2).setCellRenderer(center);
			 tableM.getColumnModel().getColumn(3).setCellRenderer(right);
			 ///////
			 connection.close();
			 
			 
			 } catch (Exception e2) {
			
			
			 } 
			 } 
			 });
		btnRemoveM.setIcon(new ImageIcon(AdminPage.class.getResource("/basic/remove.png")));
		btnRemoveM.setFocusable(false);
		btnRemoveM.setBorderPainted(false);
		btnRemoveM.setBackground(Color.WHITE);
		btnRemoveM.setBounds(124, 329, 70, 70);
		EditM.add(btnRemoveM);
		
/*########################################################    MEAT SAVE BUTTON      ################################################################
#####################################################################################################################################################*/
				
		JButton btnSaveM = new JButton("");
		btnSaveM.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSaveM.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			 try { 
			 //connecting to database
			 PreparedStatement pstSave, pstUpdate, pstAutoID; 
			 Connection connection = DriverManager.getConnection(url, user, password);
			 pstSave = connection.prepareStatement("update product_fmeat set Name = ?, Quantity = ?, Price = ? where FM_ID = ?");
			 
			 
			 //getting texts from textFields and insert them to database table
			 pstSave.setString(4, textPIDM.getText());
			 pstSave.setString(1, textNameM.getText());
			 pstSave.setString(2, textQtyM.getText());
			 pstSave.setString(3, textPriceM.getText()); 
			 
			 
			 int row = pstSave.executeUpdate();
			 if(row > 0) {
			 JOptionPane.showMessageDialog(btnSaveM, "Record Updated");
			 textPIDM.setText(null);
			 textNameM.setText(null);
			 textQtyM.setText(null);
			 textPriceM.setText(null);
			 } 
			 else 
			 JOptionPane.showMessageDialog(btnSaveM, "Error");
			 
			//insert next PID to the PID text field
				pstAutoID = connection.prepareStatement("select FM_ID from product_fmeat order by FM_ID desc limit 1");
				ResultSet rs = pstAutoID.executeQuery();
				if(rs.next()) {
				String id = rs.getString(1);
				String no = id.replaceAll("[^0-9]", "");
				String idno = "FM" + String.format("%02d", (Integer.parseInt(no)+1));
					textPIDM.setText(idno);
					textNameM.setText(null);
					textQtyM.setText(null);
					textPriceM.setText(null);
				}
				
			 //updating the table
			 pstUpdate = connection.prepareStatement("select * from product_fmeat");
			 rs = pstUpdate.executeQuery();
			 tableM.setModel(DbUtils.resultSetToTableModel(rs));
			 
			 DefaultTableModel model = (DefaultTableModel) tableM.getModel();
			 
			 String[] colName = {"PID", "Name", "Quantity", "Price"};
			 model.setColumnIdentifiers(colName);
			 
			 TableColumnModel columnModel = tableM.getColumnModel();
			 columnModel.getColumn(0).setPreferredWidth(5);
			 columnModel.getColumn(1).setPreferredWidth(200);
			 columnModel.getColumn(2).setPreferredWidth(10);
			 columnModel.getColumn(3).setPreferredWidth(15);
			 
			 DefaultTableCellRenderer right = new DefaultTableCellRenderer();
			 DefaultTableCellRenderer center = new DefaultTableCellRenderer();
			 right.setHorizontalAlignment(JLabel.RIGHT);
			 center.setHorizontalAlignment(JLabel.CENTER);
			 
			 tableM.getColumnModel().getColumn(0).setCellRenderer(center);
			 tableM.getColumnModel().getColumn(2).setCellRenderer(center);
			 tableM.getColumnModel().getColumn(3).setCellRenderer(right);
			
			 connection.close();
			 
			 
			 } catch (Exception e2) {

		
			 } 
			 } 
			 });
		btnSaveM.setIcon(new ImageIcon(AdminPage.class.getResource("/basic/successBlue.png")));
		btnSaveM.setFocusable(false);
		btnSaveM.setBorderPainted(false);
		btnSaveM.setBackground(Color.WHITE);
		btnSaveM.setBounds(204, 329, 70, 70);
		EditM.add(btnSaveM);
		
/*########################################################    MEAT RESET BUTTON      ################################################################
#####################################################################################################################################################*/
				
		
		JButton btnResetM = new JButton("");
		btnResetM.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnResetM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PreparedStatement pstAutoID;
					Connection connection = DriverManager.getConnection(url, user, password);
					pstAutoID = connection.prepareStatement("select FM_ID from product_fmeat order by FM_ID desc limit 1");
					ResultSet rs = pstAutoID.executeQuery();
					
					if(rs.next()) {
						String id = rs.getString(1);
						String no = id.replaceAll("[^0-9]", "");
						String idno = "FM" + String.format("%02d", (Integer.parseInt(no)+1));
						textPIDM.setText(idno);
						textNameM.setText(null);
						textQtyM.setText(null);
						textPriceM.setText(null);
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			 });
		
		btnResetM.setIcon(new ImageIcon(AdminPage.class.getResource("/basic/reset.png")));
		btnResetM.setFocusable(false);
		btnResetM.setBorderPainted(false);
		btnResetM.setBackground(Color.WHITE);
		btnResetM.setBounds(284, 329, 70, 70);
		EditM.add(btnResetM);
		
		JLabel lblAdd_2 = new JLabel("Add");
		lblAdd_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdd_2.setForeground(new Color(0, 196, 0));
		lblAdd_2.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblAdd_2.setBounds(44, 399, 70, 24);
		EditM.add(lblAdd_2);
		
		JLabel lblRemove_2 = new JLabel("Remove");
		lblRemove_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemove_2.setForeground(new Color(185, 17, 17));
		lblRemove_2.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblRemove_2.setBounds(124, 399, 70, 24);
		EditM.add(lblRemove_2);
		
		JLabel lblSave_2 = new JLabel("Save");
		lblSave_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSave_2.setForeground(new Color(1, 151, 194));
		lblSave_2.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblSave_2.setBounds(204, 399, 70, 24);
		EditM.add(lblSave_2);
		
		JLabel lblReset_2 = new JLabel("Reset");
		lblReset_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblReset_2.setForeground(new Color(0, 128, 128));
		lblReset_2.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblReset_2.setBounds(284, 399, 70, 24);
		EditM.add(lblReset_2);
		
		textPIDM = new JTextField();
		// adding next PID to the text field
		try {
			PreparedStatement pstAutoID;
			Connection connection = DriverManager.getConnection(url, user, password);
			pstAutoID = connection.prepareStatement("select FM_ID from product_fmeat order by FM_ID desc limit 1");
			ResultSet rs = pstAutoID.executeQuery();
			
			if(rs.next()) {
				String id = rs.getString(1);
				String no = id.replaceAll("[^0-9]", "");
				String idno = "FM" + String.format("%02d", (Integer.parseInt(no)+1));
				textPIDM.setText(idno);
			}
			
			
		} catch (Exception e) {
		}
		textPIDM.setForeground(new Color(53, 74, 84));
		textPIDM.setFont(new Font("Century Gothic", Font.BOLD, 15));
		textPIDM.setColumns(10);
		textPIDM.setBorder(new TitledBorder(new LineBorder(new Color(1, 151, 194), 2, true), "Product ID", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(1, 151, 194)));
		textPIDM.setBounds(53, 48, 289, 49);
		EditM.add(textPIDM);
		
		textNameM = new JTextField();
		textNameM.setForeground(new Color(53, 74, 84));
		textNameM.setFont(new Font("Century Gothic", Font.BOLD, 15));
		textNameM.setColumns(10);
		textNameM.setBorder(new TitledBorder(new LineBorder(new Color(1, 151, 194), 2, true), "Name", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(1, 151, 194)));
		textNameM.setBounds(53, 120, 289, 49);
		EditM.add(textNameM);
		
		textQtyM = new JTextField();
		textQtyM.setForeground(new Color(53, 74, 84));
		textQtyM.setFont(new Font("Century Gothic", Font.BOLD, 15));
		textQtyM.setColumns(10);
		textQtyM.setBorder(new TitledBorder(new LineBorder(new Color(1, 151, 194), 2, true), "Quantity", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(1, 151, 194)));
		textQtyM.setBounds(53, 188, 289, 49);
		EditM.add(textQtyM);
		
		textPriceM = new JTextField();
		textPriceM.setFont(new Font("Century Gothic", Font.BOLD, 15));
		textPriceM.setColumns(10);
		textPriceM.setBorder(new TitledBorder(new LineBorder(new Color(1, 151, 194), 2, true), "Price", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(1, 151, 194)));
		textPriceM.setBounds(53, 253, 289, 49);
		EditM.add(textPriceM);
		
		JScrollPane scrollPaneM = new JScrollPane();
		scrollPaneM.setBorder(new LineBorder(new Color(130, 130, 130), 3, true));
		scrollPaneM.setBackground(new Color(255, 255, 255));
		scrollPaneM.setForeground(new Color(53, 74, 84));
		scrollPaneM.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		scrollPaneM.setBounds(446, 15, 525, 480);
		meat.add(scrollPaneM);
		
		tableM = new JTable();
		try {
			PreparedStatement pStatement;
			Connection connection = DriverManager.getConnection(url, user, password);
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
			
		}
		tableM.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseClicked(MouseEvent e) {
			 try { 
			 //connecting to database
			 Connection connection = DriverManager.getConnection(url, user, password);
			
			 int row = tableM.getSelectedRow();
			 String S_ID_ = (tableM.getModel().getValueAt(row, 0)).toString();
			 PreparedStatement pst = connection.prepareStatement("select * from product_fmeat where FM_ID = '"+S_ID_+"' ");
			 ResultSet rs = pst.executeQuery();
			 
			 while (rs.next()) {
			 textPIDM.setText(rs.getString("FM_ID"));
			 textNameM.setText(rs.getString("Name"));
			 textQtyM.setText(rs.getString("Quantity"));
			 textPriceM.setText(rs.getString("Price"));
			 
			 } 
			 
			 pst.close();
			 
			 } catch (Exception e2) {
			 e2.printStackTrace();
			 } 
			 } 
			 });


		tableM.setForeground(new Color(53, 74, 84));
		tableM.setFont(new Font("Century Gothic", Font.BOLD, 12));
		tableM.setGridColor(new Color(130, 130, 130));
		scrollPaneM.setViewportView(tableM);
		tableM.setRowHeight(35);
		tableM.setBorder(new MatteBorder(3, 0, 0, 0, (Color) new Color(130, 130, 130)));
		tableM.getColumnModel().getColumn(1).setPreferredWidth(180);
		tableM.getColumnModel().getColumn(3).setPreferredWidth(100);
		
/*##############################################################################################################################################
##########################################################     JUICE TABLE      ################################################################
################################################################################################################################################*/
		
		JPanel juices = new JPanel();
		juices.setLayout(null);
		juices.setFocusable(false);
		juices.setFocusTraversalKeysEnabled(false);
		juices.setBackground(Color.WHITE);
		productTbls.addTab("Juices", null, juices, null);
		productTbls.setBackgroundAt(3, new Color(247, 198, 0));
		
		JPanel EditJ = new JPanel();
		EditJ.setLayout(null);
		EditJ.setBorder(new LineBorder(new Color(1, 151, 194), 3, true));
		EditJ.setBackground(Color.WHITE);
		EditJ.setBounds(35, 15, 389, 480);
		juices.add(EditJ);
		
/*########################################################    JUICE ADD BUTTON      ################################################################
#####################################################################################################################################################*/
				
		
		JButton btnAddJ = new JButton("");
		btnAddJ.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 btnAddJ.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			 try { 
			 //connecting to database
			 PreparedStatement pstAdd, pstAutoID, pstUpdate; 
			 Connection connection = DriverManager.getConnection(url, user, password);
			 pstAutoID = connection.prepareStatement("select J_ID from product_juice");
			 pstAdd = connection.prepareStatement("insert into product_juice values (?,?,?,?)");
			 
			 
			 //getting texts from textFields and insert them to database table
			 pstAdd.setString(1, textPIDJ.getText());
			 pstAdd.setString(2, textNameJ.getText());
			 pstAdd.setString(3, textQtyJ.getText());
			 pstAdd.setString(4, textPriceJ.getText());
			 
			 
			 int row = pstAdd.executeUpdate();
			 if(row > 0)
			 JOptionPane.showMessageDialog(btnAddJ, "Record Added");
			 else 
			 JOptionPane.showMessageDialog(btnAddJ, "Error");
			
			 
			 //insert next PID to the PID text field
			 pstAutoID = connection.prepareStatement("select J_ID from product_juice order by J_ID desc limit 1");
			 ResultSet rs = pstAutoID.executeQuery();
			 
			 if(rs.next()) {
			 String id = rs.getString(1);
			 String no = id.replaceAll("[^0-9]", "");
			 String idno = "JU" + String.format("%02d", (Integer.parseInt(no)+1));
			 textPIDJ.setText(idno);
			 textNameJ.setText(null);
			 textQtyJ.setText(null);
			 textPriceJ.setText(null);
			 } 
			
			 //updating the table
			 pstUpdate = connection.prepareStatement("select * from product_juice");
			 rs = pstUpdate.executeQuery();
			 tableJ.setModel(DbUtils.resultSetToTableModel(rs));
			 
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
			
			
			 connection.close();
			 
			
			 
			 
			 } catch (Exception e2) {
			
			 } 
			 } 
			 });
		
		textPIDJ = new JTextField();
		// adding next PID to the text field
				try {
					PreparedStatement pstAutoID;
					Connection connection = DriverManager.getConnection(url, user, password);
					pstAutoID = connection.prepareStatement("select J_ID from product_juice order by J_ID desc limit 1");
					ResultSet rs = pstAutoID.executeQuery();
					
					if(rs.next()) {
						String id = rs.getString(1);
						String no = id.replaceAll("[^0-9]", "");
						String idno = "JU" + String.format("%02d", (Integer.parseInt(no)+1));
						textPIDJ.setText(idno);
					}
					
					
				} catch (Exception e) {
				}
		textPIDJ.setForeground(new Color(53, 74, 84));
		textPIDJ.setFont(new Font("Century Gothic", Font.BOLD, 15));
		textPIDJ.setColumns(10);
		textPIDJ.setBorder(new TitledBorder(new LineBorder(new Color(1, 151, 194), 2, true), "Product ID", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(1, 151, 194)));
		textPIDJ.setBounds(53, 48, 289, 49);
		EditJ.add(textPIDJ);
		
		textNameJ = new JTextField();
		textNameJ.setForeground(new Color(53, 74, 84));
		textNameJ.setFont(new Font("Century Gothic", Font.BOLD, 15));
		textNameJ.setColumns(10);
		textNameJ.setBorder(new TitledBorder(new LineBorder(new Color(1, 151, 194), 2, true), "Name", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(1, 151, 194)));
		textNameJ.setBounds(53, 120, 289, 49);
		EditJ.add(textNameJ);
		
		textQtyJ = new JTextField();
		textQtyJ.setForeground(new Color(53, 74, 84));
		textQtyJ.setFont(new Font("Century Gothic", Font.BOLD, 15));
		textQtyJ.setColumns(10);
		textQtyJ.setBorder(new TitledBorder(new LineBorder(new Color(1, 151, 194), 2, true), "Quantity", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(1, 151, 194)));
		textQtyJ.setBounds(53, 188, 289, 49);
		EditJ.add(textQtyJ);
		
		textPriceJ = new JTextField();
		textPriceJ.setFont(new Font("Century Gothic", Font.BOLD, 15));
		textPriceJ.setColumns(10);
		textPriceJ.setBorder(new TitledBorder(new LineBorder(new Color(1, 151, 194), 2, true), "Price", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(1, 151, 194)));
		textPriceJ.setBounds(53, 253, 289, 49);
		EditJ.add(textPriceJ);
		btnAddJ.setIcon(new ImageIcon(AdminPage.class.getResource("/basic/add.png")));
		btnAddJ.setFocusable(false);
		btnAddJ.setFocusTraversalKeysEnabled(false);
		btnAddJ.setBorderPainted(false);
		btnAddJ.setBorder(null);
		btnAddJ.setBackground(Color.WHITE);
		btnAddJ.setBounds(44, 329, 70, 70);
		EditJ.add(btnAddJ);
		
/*########################################################    JUICE REMOVE BUTTON      ################################################################
#####################################################################################################################################################*/
		
		JButton btnRemoveJ = new JButton("");
		btnRemoveJ.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRemoveJ.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			 try { 
			 //connecting to database
			 PreparedStatement pstRemove, pstUpdate, pstAutoID; 
			 Connection connection = DriverManager.getConnection(url, user, password);
			 pstRemove = connection.prepareStatement("Delete from product_juice where J_ID = ?");
			 
			 pstRemove.setString(1, textPIDJ.getText());
			 
			 
			 int row = pstRemove.executeUpdate();
			 if(row > 0) {
			 JOptionPane.showMessageDialog(btnRemoveJ, "Record Deleted");
			 textPIDJ.setText(null);
			 textNameJ.setText(null);
			 textQtyJ.setText(null);
			 textPriceJ.setText(null);
			 } 
			 else 
			 JOptionPane.showMessageDialog(btnRemoveJ, "Error");
		
			//insert next PID to the PID text field
				pstAutoID = connection.prepareStatement("select J_ID from product_juice order by J_ID desc limit 1");
				ResultSet rs = pstAutoID.executeQuery();
				if(rs.next()) {
				String id = rs.getString(1);
				String no = id.replaceAll("[^0-9]", "");
				String idno = "JU" + String.format("%02d", (Integer.parseInt(no)+1));
					textPIDJ.setText(idno);
					textNameJ.setText(null);
					textQtyJ.setText(null);
					textPriceJ.setText(null);
				}
			 
			 //updating the table
			 pstUpdate = connection.prepareStatement("select * from product_juice");
			 rs = pstUpdate.executeQuery();
			 tableJ.setModel(DbUtils.resultSetToTableModel(rs));
			 
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
			 
			 connection.close();
			 
			 
			 } catch (Exception e2) {
		
			 
			 } 
			 } 
			 });
		btnRemoveJ.setIcon(new ImageIcon(AdminPage.class.getResource("/basic/remove.png")));
		btnRemoveJ.setFocusable(false);
		btnRemoveJ.setBorderPainted(false);
		btnRemoveJ.setBackground(Color.WHITE);
		btnRemoveJ.setBounds(124, 329, 70, 70);
		EditJ.add(btnRemoveJ);
		
/*########################################################    JUICE SAVE BUTTON      ################################################################
#####################################################################################################################################################*/
		
		JButton btnSaveJ = new JButton("");
		btnSaveJ.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 btnSaveJ.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			 try { 
			 //connecting to database
			 PreparedStatement pstSave, pstUpdate, pstAutoID; 
			 Connection connection = DriverManager.getConnection(url, user, password);
			 pstSave = connection.prepareStatement("update product_juice set Name = ?, Quantity = ?, Price = ? where J_ID = ?");
			 //////////
			 
			 //getting texts from textFields and insert them to database table
			 pstSave.setString(4, textPIDJ.getText());
			 pstSave.setString(1, textNameJ.getText());
			 pstSave.setString(2, textQtyJ.getText());
			 pstSave.setString(3, textPriceJ.getText()); 
			 
			 
			 int row = pstSave.executeUpdate();
			 if(row > 0) {
			 JOptionPane.showMessageDialog(btnSaveJ, "Record Updated");
			 textPIDJ.setText(null);
			 textNameJ.setText(null);
			 textQtyJ.setText(null);
			 textPriceJ.setText(null);
			 } 
			 else 
			 JOptionPane.showMessageDialog(btnSaveJ, "Error");
			 
				//insert next PID to the PID text field
				pstAutoID = connection.prepareStatement("select J_ID from product_juice order by J_ID desc limit 1");
				ResultSet rs = pstAutoID.executeQuery();
				if(rs.next()) {
				String id = rs.getString(1);
				String no = id.replaceAll("[^0-9]", "");
				String idno = "JU" + String.format("%02d", (Integer.parseInt(no)+1));
					textPIDJ.setText(idno);
					textNameJ.setText(null);
					textQtyJ.setText(null);
					textPriceJ.setText(null);
				}
			 
			 //updating the table
			 pstUpdate = connection.prepareStatement("select * from product_juice");
			 rs = pstUpdate.executeQuery();
			 tableJ.setModel(DbUtils.resultSetToTableModel(rs));
			 
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
			
			 connection.close();
			 
			 
			 } catch (Exception e2) {
	
			 } 
			 } 
			 });
		btnSaveJ.setIcon(new ImageIcon(AdminPage.class.getResource("/basic/successBlue.png")));
		btnSaveJ.setFocusable(false);
		btnSaveJ.setBorderPainted(false);
		btnSaveJ.setBackground(Color.WHITE);
		btnSaveJ.setBounds(204, 329, 70, 70);
		EditJ.add(btnSaveJ);
		
/*########################################################    JUICE RESET BUTTON      ################################################################
#####################################################################################################################################################*/
		
		JButton btnResetJ = new JButton("");
		btnResetJ.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 btnResetJ.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
					try {
						PreparedStatement pstAutoID;
						Connection connection = DriverManager.getConnection(url, user, password);
						pstAutoID = connection.prepareStatement("select J_ID from product_juice order by J_ID desc limit 1");
						ResultSet rs = pstAutoID.executeQuery();
						
						if(rs.next()) {
							String id = rs.getString(1);
							String no = id.replaceAll("[^0-9]", "");
							String idno = "JU" + String.format("%02d", (Integer.parseInt(no)+1));
							textPIDJ.setText(idno);
							textNameJ.setText(null);
							textQtyJ.setText(null);
							textPriceJ.setText(null);
						}
						
					} catch (Exception e2) {
						
					}
				}
		 });
		btnResetJ.setIcon(new ImageIcon(AdminPage.class.getResource("/basic/reset.png")));
		btnResetJ.setFocusable(false);
		btnResetJ.setBorderPainted(false);
		btnResetJ.setBackground(Color.WHITE);
		btnResetJ.setBounds(284, 329, 70, 70);
		EditJ.add(btnResetJ);
		
		JLabel lblAdd_3 = new JLabel("Add");
		lblAdd_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdd_3.setForeground(new Color(0, 196, 0));
		lblAdd_3.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblAdd_3.setBounds(44, 399, 70, 24);
		EditJ.add(lblAdd_3);
		
		JLabel lblRemove_3 = new JLabel("Remove");
		lblRemove_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemove_3.setForeground(new Color(185, 17, 17));
		lblRemove_3.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblRemove_3.setBounds(124, 399, 70, 24);
		EditJ.add(lblRemove_3);
		
		JLabel lblSave_3 = new JLabel("Save");
		lblSave_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblSave_3.setForeground(new Color(1, 151, 194));
		lblSave_3.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblSave_3.setBounds(204, 399, 70, 24);
		EditJ.add(lblSave_3);
		
		JLabel lblReset_3 = new JLabel("Reset");
		lblReset_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblReset_3.setForeground(new Color(0, 128, 128));
		lblReset_3.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblReset_3.setBounds(284, 399, 70, 24);
		EditJ.add(lblReset_3);
		// adding next PID to the text field
		 try { 
		 PreparedStatement pstAutoID; 
		 Connection connection = DriverManager.getConnection(url, user, password);
		 pstAutoID = connection.prepareStatement("select J_ID from product_juice order by J_ID desclimit 1");
		 ResultSet rs = pstAutoID.executeQuery();
		 
		 if(rs.next()) {
		 String id = rs.getString(1);
		 String no = id.replaceAll("[^0-9]", "");
		 String idno = "JU" + String.format("%02d", (Integer.parseInt(no)+1));
		 textPIDJ.setText(idno);
		 } 
		 
		 
		 } catch (Exception e) {
		 
		 } 
		
		JScrollPane scrollPaneJ = new JScrollPane();
		scrollPaneJ.setBorder(new LineBorder(new Color(247, 198, 0), 3, true));
		scrollPaneJ.setBackground(new Color(255, 255, 255));
		scrollPaneJ.setForeground(new Color(53, 74, 84));
		scrollPaneJ.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		scrollPaneJ.setBounds(446, 15, 525, 480);
		juices.add(scrollPaneJ);
		
		tableJ = new JTable();
		try {
			PreparedStatement pStatement;
			Connection connection = DriverManager.getConnection(url, user, password);
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
			
		}
		
		//update text fields according table row clicks
		 tableJ.addMouseListener(new MouseAdapter() {
		 @Override
		 public void mouseClicked(MouseEvent e) {
		 try { 
		 //connecting to database
		 Connection connection = DriverManager.getConnection(url, user, password);
		
		 int row = tableJ.getSelectedRow();
		 String S_ID_ = (tableJ.getModel().getValueAt(row, 0)).toString();
		 PreparedStatement pst = connection.prepareStatement("select * from product_juice where J_ID = '"+S_ID_+"' ");
		 ResultSet rs = pst.executeQuery();
		 
		 while (rs.next()) {
		 textPIDJ.setText(rs.getString("J_ID"));
		 textNameJ.setText(rs.getString("Name"));
		 textQtyJ.setText(rs.getString("Quantity"));
		 textPriceJ.setText(rs.getString("Price"));
		 
		 } 
		 
		 pst.close();
		 
		 } catch (Exception e2) {
		 e2.printStackTrace();
		 } 
		 } 
		 });
		
		tableJ.setForeground(new Color(53, 74, 84));
		tableJ.setFont(new Font("Century Gothic", Font.BOLD, 12));
		tableJ.setGridColor(new Color(247, 198, 0));
		scrollPaneJ.setViewportView(tableJ);
		tableJ.setRowHeight(35);
		tableJ.setBorder(new MatteBorder(3, 0, 0, 0, (Color) new Color(247, 198, 0)));
		 
/*##############################################################################################################################################
##########################################################     HOMEWARE TABLE      #############################################################
################################################################################################################################################*/
		
		JPanel hware = new JPanel();
		hware.setLayout(null);
		hware.setFocusable(false);
		hware.setFocusTraversalKeysEnabled(false);
		hware.setBackground(Color.WHITE);
		productTbls.addTab("Homeware Items", null, hware, null);
		productTbls.setBackgroundAt(4, new Color(1, 151, 194));
		
		JPanel EditH = new JPanel();
		EditH.setLayout(null);
		EditH.setBorder(new LineBorder(new Color(1, 151, 194), 3, true));
		EditH.setBackground(Color.WHITE);
		EditH.setBounds(35, 15, 389, 480);
		hware.add(EditH);
		
		
/*########################################################    HOMEWARE ADD BUTTON      ##############################################################
#####################################################################################################################################################*/
		
		JButton btnAddH = new JButton("");
		btnAddH.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddH.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			 try { 
			 //connecting to database
			 PreparedStatement pstAdd, pstAutoID, pstUpdate; 
			 Connection connection = DriverManager.getConnection(url, user, password);
			 pstAutoID = connection.prepareStatement("select HW_ID from product_hware");
			 pstAdd = connection.prepareStatement("insert into product_hware values (?,?,?,?)");
			 //////////
			 
			 //getting texts from textFields and insert them to database table
			 pstAdd.setString(1, textPIDH.getText());
			 pstAdd.setString(2, textNameH.getText());
			 pstAdd.setString(3, textQtyH.getText());
			 pstAdd.setString(4, textPriceH.getText());
			 
			 int row = pstAdd.executeUpdate();
			 if(row > 0)
			 JOptionPane.showMessageDialog(btnAddH, "Record Added");
			 else 
			 JOptionPane.showMessageDialog(btnAddH, "Error");
			
			 //insert next PID to the PID text field
			 pstAutoID = connection.prepareStatement("select HW_ID from product_hware order by HW_ID desc limit 1");
			 ResultSet rs = pstAutoID.executeQuery();
			 
			 if(rs.next()) {
			 String id = rs.getString(1);
			 String no = id.replaceAll("[^0-9]", "");
			 String idno = "HW" + String.format("%02d", (Integer.parseInt(no)+1));
			 textPIDH.setText(idno);
			 textNameH.setText(null);
			 textQtyH.setText(null);
			 textPriceH.setText(null);
			 } 
			 
			 
			 //updating the table
			 pstUpdate = connection.prepareStatement("select * from product_hware");
			 rs = pstUpdate.executeQuery();
			 tableH.setModel(DbUtils.resultSetToTableModel(rs));
			 
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
			
			
			 connection.close();
			 
			
			 
			 
			 } catch (Exception e2) {
			 
			 } 
			 } 
			 });
		
		 textPIDH = new JTextField();
		 //adding next PID to the text field
		 try { 
		 PreparedStatement pstAutoID; 
		 Connection connection = DriverManager.getConnection(url, user, password);
		 pstAutoID = connection.prepareStatement("select HW_ID from product_hware order by HW_ID desc limit 1");
		 ResultSet rs = pstAutoID.executeQuery();
		 
		 if(rs.next()) {
		 String id = rs.getString(1);
		 String no = id.replaceAll("[^0-9]", "");
		 String idno = "HW" + String.format("%02d", (Integer.parseInt(no)+1));
		 textPIDH.setText(idno);
		 } 
		 
		 
		 } catch (Exception e) {
		 // TODO: handle exception
		 } 
		textPIDH.setForeground(new Color(53, 74, 84));
		textPIDH.setFont(new Font("Century Gothic", Font.BOLD, 15));
		textPIDH.setColumns(10);
		textPIDH.setBorder(new TitledBorder(new LineBorder(new Color(1, 151, 194), 2, true), "Product ID", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(1, 151, 194)));
		textPIDH.setBounds(53, 48, 289, 49);
		EditH.add(textPIDH);
		
		textNameH = new JTextField();
		textNameH.setForeground(new Color(53, 74, 84));
		textNameH.setFont(new Font("Century Gothic", Font.BOLD, 15));
		textNameH.setColumns(10);
		textNameH.setBorder(new TitledBorder(new LineBorder(new Color(1, 151, 194), 2, true), "Name", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(1, 151, 194)));
		textNameH.setBounds(53, 120, 289, 49);
		EditH.add(textNameH);
		
		textQtyH = new JTextField();
		textQtyH.setForeground(new Color(53, 74, 84));
		textQtyH.setFont(new Font("Century Gothic", Font.BOLD, 15));
		textQtyH.setColumns(10);
		textQtyH.setBorder(new TitledBorder(new LineBorder(new Color(1, 151, 194), 2, true), "Quantity", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(1, 151, 194)));
		textQtyH.setBounds(53, 188, 289, 49);
		EditH.add(textQtyH);
		
		textPriceH = new JTextField();
		textPriceH.setFont(new Font("Century Gothic", Font.BOLD, 15));
		textPriceH.setColumns(10);
		textPriceH.setBorder(new TitledBorder(new LineBorder(new Color(1, 151, 194), 2, true), "Price", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(1, 151, 194)));
		textPriceH.setBounds(53, 253, 289, 49);
		EditH.add(textPriceH);
		btnAddH.setIcon(new ImageIcon(AdminPage.class.getResource("/basic/add.png")));
		btnAddH.setFocusable(false);
		btnAddH.setFocusTraversalKeysEnabled(false);
		btnAddH.setBorderPainted(false);
		btnAddH.setBorder(null);
		btnAddH.setBackground(Color.WHITE);
		btnAddH.setBounds(44, 329, 70, 70);
		EditH.add(btnAddH);
		
/*########################################################    HOMEWARE REMOVE BUTTON      ##############################################################
#####################################################################################################################################################*/
				
		
		JButton btnRemoveH = new JButton("");
		btnRemoveH.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 btnRemoveH.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			 try { 
			 //connecting to database
			 PreparedStatement pstRemove, pstUpdate, pstAutoID; 
			 Connection connection = DriverManager.getConnection(url, user, password);
			 pstRemove = connection.prepareStatement("Delete from product_hware where HW_ID = ?");
			 
			 pstRemove.setString(1, textPIDH.getText());
			 
			 
			 int row = pstRemove.executeUpdate();
			 if(row > 0) {
			 JOptionPane.showMessageDialog(btnRemoveH, "Record Deleted");
			 textPIDH.setText(null);
			 textNameH.setText(null);
			 textQtyH.setText(null);
			 textPriceH.setText(null);
			 } 
			 else 
			 JOptionPane.showMessageDialog(btnRemoveH, "Error");

			 //insert next PID to the PID text field
			 pstAutoID = connection.prepareStatement("select HW_ID from product_hware order by HW_ID desc limit 1");
			 ResultSet rs = pstAutoID.executeQuery();
			 
			 if(rs.next()) {
			 String id = rs.getString(1);
			 String no = id.replaceAll("[^0-9]", "");
			 String idno = "HW" + String.format("%02d", (Integer.parseInt(no)+1));
			 textPIDH.setText(idno);
			 textNameH.setText(null);
			 textQtyH.setText(null);
			 textPriceH.setText(null);
			 } 
			 
			 //updating the table
			 pstUpdate = connection.prepareStatement("select * from product_hware");
		     rs = pstUpdate.executeQuery();
			 tableH.setModel(DbUtils.resultSetToTableModel(rs));
			 
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
			
			 connection.close();
			 
			 
			 } catch (Exception e2) {
			
			
			 } 
			 } 
			 });
		btnRemoveH.setIcon(new ImageIcon(AdminPage.class.getResource("/basic/remove.png")));
		btnRemoveH.setFocusable(false);
		btnRemoveH.setBorderPainted(false);
		btnRemoveH.setBackground(Color.WHITE);
		btnRemoveH.setBounds(124, 329, 70, 70);
		EditH.add(btnRemoveH);
		
/*########################################################    HOMEWARE SAVE BUTTON      ##############################################################
#####################################################################################################################################################*/
				
		
		JButton btnSaveH = new JButton("");
		btnSaveH.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSaveH.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			 try { 
			 //connecting to database
			 PreparedStatement pstSave, pstUpdate, pstAutoID; 
			 Connection connection = DriverManager.getConnection(url, user, password);
			 pstSave = connection.prepareStatement("update product_hware set Name = ?, Quantity = ?, Price = ? where HW_ID = ?");
			
			 
			 //getting texts from textFields and insert them to database table
			 pstSave.setString(4, textPIDH.getText());
			 pstSave.setString(1, textNameH.getText());
			 pstSave.setString(2, textQtyH.getText());
			 pstSave.setString(3, textPriceH.getText()); 
			 
			 
			 int row = pstSave.executeUpdate();
			 if(row > 0) {
			 JOptionPane.showMessageDialog(btnSaveH, "Record Updated");
			 textPIDH.setText(null);
			 textNameH.setText(null);
			 textQtyH.setText(null);
			 textPriceH.setText(null);
			 } 
			 else 
			 JOptionPane.showMessageDialog(btnSaveH, "Error");

			 //insert next PID to the PID text field
			 pstAutoID = connection.prepareStatement("select HW_ID from product_hware order by HW_ID desc limit 1");
			 ResultSet rs = pstAutoID.executeQuery();
			 
			 if(rs.next()) {
			 String id = rs.getString(1);
			 String no = id.replaceAll("[^0-9]", "");
			 String idno = "HW" + String.format("%02d", (Integer.parseInt(no)+1));
			 textPIDH.setText(idno);
			 textNameH.setText(null);
			 textQtyH.setText(null);
			 textPriceH.setText(null);
			 } 
			 
			 //updating the table
			 pstUpdate = connection.prepareStatement("select * from product_hware");
			 rs = pstUpdate.executeQuery();
			 tableH.setModel(DbUtils.resultSetToTableModel(rs));
			 
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
			
			 connection.close();
			 
			 } catch (Exception e2) {
			 
			
			 } 
			 } 
			 });
		btnSaveH.setIcon(new ImageIcon(AdminPage.class.getResource("/basic/successBlue.png")));
		btnSaveH.setFocusable(false);
		btnSaveH.setBorderPainted(false);
		btnSaveH.setBackground(Color.WHITE);
		btnSaveH.setBounds(204, 329, 70, 70);
		EditH.add(btnSaveH);
		
/*########################################################    HOMEWARE RESET BUTTON      ##############################################################
#####################################################################################################################################################*/
				
		
		JButton btnResetH = new JButton("");
		btnResetH.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnResetH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PreparedStatement pstAutoID;
					Connection connection = DriverManager.getConnection(url, user, password);
					pstAutoID = connection.prepareStatement("select HW_ID from product_hware order by HW_ID desc limit 1");
					ResultSet rs = pstAutoID.executeQuery();
					
					if(rs.next()) {
						String id = rs.getString(1);
						String no = id.replaceAll("[^0-9]", "");
						String idno = "HW" + String.format("%02d", (Integer.parseInt(no)+1));
						textPIDH.setText(idno);
						textNameH.setText(null);
						textQtyH.setText(null);
						textPriceH.setText(null);
					}
					
				} catch (Exception e2) {
					
				}
			}
			 });
		btnResetH.setIcon(new ImageIcon(AdminPage.class.getResource("/basic/reset.png")));
		btnResetH.setFocusable(false);
		btnResetH.setBorderPainted(false);
		btnResetH.setBackground(Color.WHITE);
		btnResetH.setBounds(284, 329, 70, 70);
		EditH.add(btnResetH);
		
		JLabel lblAdd_4 = new JLabel("Add");
		lblAdd_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdd_4.setForeground(new Color(0, 196, 0));
		lblAdd_4.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblAdd_4.setBounds(44, 399, 70, 24);
		EditH.add(lblAdd_4);
		
		JLabel lblRemove_4 = new JLabel("Remove");
		lblRemove_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemove_4.setForeground(new Color(185, 17, 17));
		lblRemove_4.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblRemove_4.setBounds(124, 399, 70, 24);
		EditH.add(lblRemove_4);
		
		JLabel lblSave_4 = new JLabel("Save");
		lblSave_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblSave_4.setForeground(new Color(1, 151, 194));
		lblSave_4.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblSave_4.setBounds(204, 399, 70, 24);
		EditH.add(lblSave_4);
		
		JLabel lblReset_4 = new JLabel("Reset");
		lblReset_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblReset_4.setForeground(new Color(0, 128, 128));
		lblReset_4.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblReset_4.setBounds(284, 399, 70, 24);
		EditH.add(lblReset_4);
		
		JScrollPane scrollPaneH = new JScrollPane();
		scrollPaneH.setBorder(new LineBorder(new Color(1, 151, 194), 3, true));
		scrollPaneH.setBackground(new Color(255, 255, 255));
		scrollPaneH.setForeground(new Color(53, 74, 84));
		scrollPaneH.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		scrollPaneH.setBounds(446, 15, 525, 480);
		hware.add(scrollPaneH);
		
		tableH = new JTable();
		try {
			PreparedStatement pStatement;
			Connection connection = DriverManager.getConnection(url, user, password);
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
			
		}
		tableH.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseClicked(MouseEvent e) {
			 try { 
			 //connecting to database
			 Connection connection = DriverManager.getConnection(url, user, password);
			
			 int row = tableH.getSelectedRow();
			 String S_ID_ = (tableH.getModel().getValueAt(row, 0)).toString();
			 PreparedStatement pst = connection.prepareStatement("select * from product_hware where HW_ID = '"+S_ID_+"' ");
			 ResultSet rs = pst.executeQuery();
			 
			 while (rs.next()) {
			 textPIDH.setText(rs.getString("HW_ID"));
			 textNameH.setText(rs.getString("Name"));
			 textQtyH.setText(rs.getString("Quantity"));
			 textPriceH.setText(rs.getString("Price"));
			 
			 } 
			 
			 pst.close();
			 
			 } catch (Exception e2) {
			 e2.printStackTrace();
			 } 
			 } 
			 });
			
		tableH.setForeground(new Color(53, 74, 84));
		tableH.setFont(new Font("Century Gothic", Font.BOLD, 12));
		tableH.setGridColor(new Color(1, 151, 194));
		scrollPaneH.setViewportView(tableH);
		tableH.setRowHeight(35);
		tableH.setBorder(new MatteBorder(3, 0, 0, 0, (Color) new Color(1, 151, 194)));
		
/*##############################################################################################################################################
##########################################################     BPICKS TABLE      ###############################################################
################################################################################################################################################*/		
		
		JPanel bpicks = new JPanel();
		bpicks.setLayout(null);
		bpicks.setFocusable(false);
		bpicks.setFocusTraversalKeysEnabled(false);
		bpicks.setBackground(Color.WHITE);
		productTbls.addTab("Beauty Picks", null, bpicks, null);
		productTbls.setBackgroundAt(5, new Color(255, 85, 234));
		
		JPanel EditB = new JPanel();
		EditB.setLayout(null);
		EditB.setBorder(new LineBorder(new Color(1, 151, 194), 3, true));
		EditB.setBackground(Color.WHITE);
		EditB.setBounds(35, 15, 389, 480);
		bpicks.add(EditB);
		
/*########################################################    BPICKS ADD BUTTON      ##############################################################
#####################################################################################################################################################*/
				
		
		JButton btnAddB = new JButton("");
		btnAddB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddB.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			 try { 
			 //connecting to database
			 PreparedStatement pstAdd, pstAutoID, pstUpdate; 
			 Connection connection = DriverManager.getConnection(url, user, password);
			 pstAutoID = connection.prepareStatement("select BP_ID from product_bpicks");
			 pstAdd = connection.prepareStatement("insert into product_bpicks values (?,?,?,?)");
			
			 
			 //getting texts from textFields and insert them to database table
			 pstAdd.setString(1, textPIDB.getText());
			 pstAdd.setString(2, textNameB.getText());
			 pstAdd.setString(3, textQtyB.getText());
			 pstAdd.setString(4, textPriceB.getText());
			 
			 
			 int row = pstAdd.executeUpdate();
			 if(row > 0)
			 JOptionPane.showMessageDialog(btnAddB, "Record Added");
			 else 
			 JOptionPane.showMessageDialog(btnAddB, "Error");
			 //////
			 
			 //insert next PID to the PID text field
			 pstAutoID = connection.prepareStatement("select BP_ID from product_bpicks order by BP_ID desc limit 1");
			 ResultSet rs = pstAutoID.executeQuery();
			 
			 if(rs.next()) {
			 String id = rs.getString(1);
			 String no = id.replaceAll("[^0-9]", "");
			 String idno = "BP" + String.format("%02d", (Integer.parseInt(no)+1));
			 textPIDB.setText(idno);
			 textNameB.setText(null);
			 textQtyB.setText(null);
			 textPriceB.setText(null);
			 } 
			 
			 
			 //updating the table
			 pstUpdate = connection.prepareStatement("select * from product_bpicks");
			 rs = pstUpdate.executeQuery();
			 tableB.setModel(DbUtils.resultSetToTableModel(rs));
			 
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
			
			 connection.close();
			 
	
			 
			 
			 } catch (Exception e2) {
			
			 } 
			 } 
			 });
		
		textPIDB = new JTextField();
		// adding next PID to the text field
				try {
					PreparedStatement pstAutoID;
					Connection connection = DriverManager.getConnection(url, user, password);
					pstAutoID = connection.prepareStatement("select BP_ID from product_bpicks order by BP_ID desc limit 1");
					ResultSet rs = pstAutoID.executeQuery();
					
					if(rs.next()) {
						String id = rs.getString(1);
						String no = id.replaceAll("[^0-9]", "");
						String idno = "BP" + String.format("%02d", (Integer.parseInt(no)+1));
						textPIDB.setText(idno);
					}
					
					
				} catch (Exception e) {
				}
		
		textPIDB.setForeground(new Color(53, 74, 84));
		textPIDB.setFont(new Font("Century Gothic", Font.BOLD, 15));
		textPIDB.setColumns(10);
		textPIDB.setBorder(new TitledBorder(new LineBorder(new Color(1, 151, 194), 2, true), "Product ID", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(1, 151, 194)));
		textPIDB.setBounds(53, 48, 289, 49);
		EditB.add(textPIDB);
		
		textNameB = new JTextField();
		textNameB.setForeground(new Color(53, 74, 84));
		textNameB.setFont(new Font("Century Gothic", Font.BOLD, 15));
		textNameB.setColumns(10);
		textNameB.setBorder(new TitledBorder(new LineBorder(new Color(1, 151, 194), 2, true), "Name", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(1, 151, 194)));
		textNameB.setBounds(53, 120, 289, 49);
		EditB.add(textNameB);
		
		textQtyB = new JTextField();
		textQtyB.setForeground(new Color(53, 74, 84));
		textQtyB.setFont(new Font("Century Gothic", Font.BOLD, 15));
		textQtyB.setColumns(10);
		textQtyB.setBorder(new TitledBorder(new LineBorder(new Color(1, 151, 194), 2, true), "Quantity", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(1, 151, 194)));
		textQtyB.setBounds(53, 188, 289, 49);
		EditB.add(textQtyB);
		
		textPriceB = new JTextField();
		textPriceB.setFont(new Font("Century Gothic", Font.BOLD, 15));
		textPriceB.setColumns(10);
		textPriceB.setBorder(new TitledBorder(new LineBorder(new Color(1, 151, 194), 2, true), "Price", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(1, 151, 194)));
		textPriceB.setBounds(53, 253, 289, 49);
		EditB.add(textPriceB);
		btnAddB.setIcon(new ImageIcon(AdminPage.class.getResource("/basic/add.png")));
		btnAddB.setFocusable(false);
		btnAddB.setFocusTraversalKeysEnabled(false);
		btnAddB.setBorderPainted(false);
		btnAddB.setBorder(null);
		btnAddB.setBackground(Color.WHITE);
		btnAddB.setBounds(44, 329, 70, 70);
		EditB.add(btnAddB);
		
/*########################################################    BPICKS REMOVE BUTTON      ##############################################################
#####################################################################################################################################################*/
				
		
		JButton btnRemoveB = new JButton("");
		btnRemoveB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRemoveB.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			 try { 
			 //connecting to database
			 PreparedStatement pstRemove, pstUpdate, pstAutoID; 
			 Connection connection = DriverManager.getConnection(url, user, password);
			 pstRemove = connection.prepareStatement("Delete from product_bpicks where BP_ID = ?");
			
			 
			 pstRemove.setString(1, textPIDB.getText());
			 
			 
			 int row = pstRemove.executeUpdate();
			 if(row > 0) {
			 JOptionPane.showMessageDialog(btnRemoveB, "Record Deleted");
			 textPIDB.setText(null);
			 textNameB.setText(null);
			 textQtyB.setText(null);
			 textPriceB.setText(null);
			 } 
			 else 
			 JOptionPane.showMessageDialog(btnRemoveB, "Error");

			 //insert next PID to the PID text field
			 pstAutoID = connection.prepareStatement("select BP_ID from product_bpicks order by BP_ID desc limit 1");
			 ResultSet rs = pstAutoID.executeQuery();
			 
			 if(rs.next()) {
			 String id = rs.getString(1);
			 String no = id.replaceAll("[^0-9]", "");
			 String idno = "BP" + String.format("%02d", (Integer.parseInt(no)+1));
			 textPIDB.setText(idno);
			 textNameB.setText(null);
			 textQtyB.setText(null);
			 textPriceB.setText(null);
			 } 
			 
			 //updating the table
			 pstUpdate = connection.prepareStatement("select * from product_bpicks");
			 rs = pstUpdate.executeQuery();
			 tableB.setModel(DbUtils.resultSetToTableModel(rs));
			 
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
		
			 connection.close();
			 
			 
			 } catch (Exception e2) {
			
			 } 
			 } 
			 });
		btnRemoveB.setIcon(new ImageIcon(AdminPage.class.getResource("/basic/remove.png")));
		btnRemoveB.setFocusable(false);
		btnRemoveB.setBorderPainted(false);
		btnRemoveB.setBackground(Color.WHITE);
		btnRemoveB.setBounds(124, 329, 70, 70);
		EditB.add(btnRemoveB);
		
/*########################################################    BPICKS SAVE BUTTON      ##############################################################
#####################################################################################################################################################*/
				
		JButton btnSaveB = new JButton("");
		btnSaveB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSaveB.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			 try { 
			 //connecting to database
			 PreparedStatement pstSave, pstUpdate; 
			 Connection connection = DriverManager.getConnection(url, user, password);
			 pstSave = connection.prepareStatement("update product_bpicks set Name = ?, Quantity = ?, Price = ? where BP_ID = ?");
			 //////////
			 
			 //getting texts from textFields and insert them to database table
			 pstSave.setString(4, textPIDB.getText());
			 pstSave.setString(1, textNameB.getText());
			 pstSave.setString(2, textQtyB.getText());
			 pstSave.setString(3, textPriceB.getText()); 
			 
			 
			 int row = pstSave.executeUpdate();
			 if(row > 0) {
			 JOptionPane.showMessageDialog(btnSaveB, "Record Updated");
			 textPIDB.setText(null);
			 textNameB.setText(null);
			 textQtyB.setText(null);
			 textPriceB.setText(null);
			 } 
			 else 
			 JOptionPane.showMessageDialog(btnSaveB, "Error");
			 
			 
			 //updating the table
			 pstUpdate = connection.prepareStatement("select * from product_bpicks");
			 ResultSet rs = pstUpdate.executeQuery();
			 tableB.setModel(DbUtils.resultSetToTableModel(rs));
			 
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
			
			 connection.close();
			 
			 
			 } catch (Exception e2) {
			
			
			 } 
			 } 
			 });
		btnSaveB.setIcon(new ImageIcon(AdminPage.class.getResource("/basic/successBlue.png")));
		btnSaveB.setFocusable(false);
		btnSaveB.setBorderPainted(false);
		btnSaveB.setBackground(Color.WHITE);
		btnSaveB.setBounds(204, 329, 70, 70);
		EditB.add(btnSaveB);
		
/*########################################################    BPICKS RESET BUTTON     ##############################################################
#####################################################################################################################################################*/
				
		JButton btnResetB = new JButton("");
		btnResetB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnResetB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PreparedStatement pstAutoID;
					Connection connection = DriverManager.getConnection(url, user, password);
					pstAutoID = connection.prepareStatement("select BP_ID from product_bpicks order by BP_ID desc limit 1");
					ResultSet rs = pstAutoID.executeQuery();
					
					if(rs.next()) {
						String id = rs.getString(1);
						String no = id.replaceAll("[^0-9]", "");
						String idno = "BP" + String.format("%02d", (Integer.parseInt(no)+1));
						textPIDB.setText(idno);
						textNameB.setText(null);
						textQtyB.setText(null);
						textPriceB.setText(null);
					}
					
				} catch (Exception e2) {
					
				}
			}
			 });
		btnResetB.setIcon(new ImageIcon(AdminPage.class.getResource("/basic/reset.png")));
		btnResetB.setFocusable(false);
		btnResetB.setBorderPainted(false);
		btnResetB.setBackground(Color.WHITE);
		btnResetB.setBounds(284, 329, 70, 70);
		EditB.add(btnResetB);
		
		JLabel lblAdd_5 = new JLabel("Add");
		lblAdd_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdd_5.setForeground(new Color(0, 196, 0));
		lblAdd_5.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblAdd_5.setBounds(44, 399, 70, 24);
		EditB.add(lblAdd_5);
		
		JLabel lblRemove_5 = new JLabel("Remove");
		lblRemove_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemove_5.setForeground(new Color(185, 17, 17));
		lblRemove_5.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblRemove_5.setBounds(124, 399, 70, 24);
		EditB.add(lblRemove_5);
		
		JLabel lblSave_5 = new JLabel("Save");
		lblSave_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblSave_5.setForeground(new Color(1, 151, 194));
		lblSave_5.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblSave_5.setBounds(204, 399, 70, 24);
		EditB.add(lblSave_5);
		
		JLabel lblReset_5 = new JLabel("Reset");
		lblReset_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblReset_5.setForeground(new Color(0, 128, 128));
		lblReset_5.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblReset_5.setBounds(284, 399, 70, 24);
		EditB.add(lblReset_5);
		// adding next PID to the text field
		 try { 
		 PreparedStatement pstAutoID; 
		 Connection connection = DriverManager.getConnection(url, user, password);
		 pstAutoID = connection.prepareStatement("select BP_ID from product_bpicks order by BP_ID desclimit 1");
		 ResultSet rs = pstAutoID.executeQuery();
		 
		 if(rs.next()) {
		 String id = rs.getString(1);
		 String no = id.replaceAll("[^0-9]", "");
		 String idno = "BP" + String.format("%02d", (Integer.parseInt(no)+1));
		 textPIDB.setText(idno);
		 } 
		 
		 
		 } catch (Exception e) {
		 
		 } 
		
		JScrollPane scrollPaneB = new JScrollPane();
		scrollPaneB.setBorder(new LineBorder(new Color(255, 85, 234), 3, true));
		scrollPaneB.setBackground(new Color(255, 255, 255));
		scrollPaneB.setForeground(new Color(53, 74, 84));
		scrollPaneB.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		scrollPaneB.setBounds(446, 15, 525, 480);
		bpicks.add(scrollPaneB);
		
		tableB = new JTable();
		try {
			PreparedStatement pStatement;
			Connection connection = DriverManager.getConnection(url, user, password);
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
			
		}
		//update text fields according table row clicks
		 tableB.addMouseListener(new MouseAdapter() {
		 @Override
		 public void mouseClicked(MouseEvent e) {
		 try { 
		 //connecting to database
		 Connection connection = DriverManager.getConnection(url, user, password);
		 
		 int row = tableB.getSelectedRow();
		 String S_ID_ = (tableB.getModel().getValueAt(row, 0)).toString();
		 PreparedStatement pst = connection.prepareStatement("select * from product_bpicks where BP_ID = '"+S_ID_+"' ");
		 ResultSet rs = pst.executeQuery();
		 
		 while (rs.next()) {
		 textPIDB.setText(rs.getString("BP_ID"));
		 textNameB.setText(rs.getString("Name"));
		 textQtyB.setText(rs.getString("Quantity"));
		 textPriceB.setText(rs.getString("Price"));
		 
		 } 
		 
		 pst.close();
		 
		 } catch (Exception e2) {
		 e2.printStackTrace();
		 } 
		 } 
		 });
		tableB.setForeground(new Color(53, 74, 84));
		tableB.setFont(new Font("Century Gothic", Font.BOLD, 12));
		tableB.setGridColor(new Color(255, 85, 234));
		scrollPaneB.setViewportView(tableB);
		tableB.setRowHeight(35);
		tableB.setBorder(new MatteBorder(3, 0, 0, 0, (Color) new Color(255, 85, 234)));
		
		
/*##############################################################################################################################################
##########################################################     EMPLOYEE TABLE      #############################################################
################################################################################################################################################*/
		
		
		employees.setBackground(Color.WHITE);
		sideMenuPages.addTab("New tab", null, employees, null);
		employees.setLayout(null);
		
		JPanel emp = new JPanel();
		emp.setLayout(null);
		emp.setFocusable(false);
		emp.setFocusTraversalKeysEnabled(false);
		emp.setBackground(Color.WHITE);
		emp.setBounds(0, 22, 1021, 528);
		employees.add(emp);
		
		JPanel editEmp = new JPanel();
		editEmp.setLayout(null);
		editEmp.setBorder(new LineBorder(new Color(1, 151, 194), 3, true));
		editEmp.setBackground(Color.WHITE);
		editEmp.setBounds(33, 10, 964, 290);
		emp.add(editEmp);
		
		
		
		textEMPID = new JTextField();
		//adding next EMPID to the text field
		try {
			PreparedStatement pstAutoID;
			Connection connection = DriverManager.getConnection(url, user, password);
			pstAutoID = connection.prepareStatement("select EMP_ID from emp_details order by EMP_ID desc limit 1");
			ResultSet rs = pstAutoID.executeQuery();
			if(rs.next()) {
				String id = rs.getString(1);
				String no = id.replaceAll("[^0-9]", "");
				String idno = "EMP" + String.format("%02d", (Integer.parseInt(no)+1));
				textEMPID.setText(idno);
			}
		} catch (Exception e) {
	
		}
		
		textEMPID.setForeground(new Color(53, 74, 84));
		textEMPID.setFont(new Font("Century Gothic", Font.BOLD, 15));
		textEMPID.setColumns(10);
		textEMPID.setBorder(new TitledBorder(new LineBorder(new Color(1, 151, 194), 2, true), "Employee ID", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(1, 151, 194)));
		textEMPID.setBounds(37, 20, 289, 49);
		editEmp.add(textEMPID);
		
		textFName = new JTextField();
		textFName.setForeground(new Color(53, 74, 84));
		textFName.setFont(new Font("Century Gothic", Font.BOLD, 15));
		textFName.setColumns(10);
		textFName.setBorder(new TitledBorder(new LineBorder(new Color(1, 151, 194), 2, true), "First Name", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(1, 151, 194)));
		textFName.setBounds(340, 20, 289, 49);
		editEmp.add(textFName);
		
		textLName = new JTextField();
		textLName.setForeground(new Color(53, 74, 84));
		textLName.setFont(new Font("Century Gothic", Font.BOLD, 15));
		textLName.setColumns(10);
		textLName.setBorder(new TitledBorder(new LineBorder(new Color(1, 151, 194), 2, true), "Last Name", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(1, 151, 194)));
		textLName.setBounds(340, 79, 289, 49);
		editEmp.add(textLName);
		
		JComboBox<Object> gender = new JComboBox<Object>();
		gender.setOpaque(false);
		gender.setForeground(new Color(1, 151, 194));
		gender.setFont(new Font("Century Gothic", Font.BOLD, 12));
		gender.setFocusTraversalKeysEnabled(false);
		gender.setFocusable(false);
		gender.setModel(new DefaultComboBoxModel<Object>(new String[] {"Male", "Female"}));
		gender.setBorder(new TitledBorder(new LineBorder(new Color(1, 151, 194), 2, true), "Gender", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(1, 151, 194)));
		gender.setBounds(188, 79, 140, 49);
		editEmp.add(gender);
		
		textNIC = new JTextField();
		textNIC.setForeground(new Color(53, 74, 84));
		textNIC.setFont(new Font("Century Gothic", Font.BOLD, 15));
		textNIC.setColumns(10);
		textNIC.setBorder(new TitledBorder(new LineBorder(new Color(1, 151, 194), 2, true), "NIC", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(1, 151, 194)));
		textNIC.setBounds(37, 138, 289, 49);
		editEmp.add(textNIC);
		
		textCNo = new JTextField();
		textCNo.setFont(new Font("Century Gothic", Font.BOLD, 15));
		textCNo.setColumns(10);
		textCNo.setBorder(new TitledBorder(new LineBorder(new Color(1, 151, 194), 2, true), "Contact No.", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(1, 151, 194)));
		textCNo.setBounds(38, 79, 140, 49);
		editEmp.add(textCNo);
		
		textAddress = new JTextField();
		textAddress.setFont(new Font("Century Gothic", Font.BOLD, 15));
		textAddress.setColumns(10);
		textAddress.setBorder(new TitledBorder(new LineBorder(new Color(1, 151, 194), 2, true), "Address", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(1, 151, 194)));
		textAddress.setBounds(340, 138, 289, 49);
		editEmp.add(textAddress);
		
		textUsername = new JTextField();
		textUsername.setForeground(new Color(53, 74, 84));
		textUsername.setFont(new Font("Century Gothic", Font.BOLD, 15));
		textUsername.setColumns(10);
		textUsername.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Username", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		textUsername.setBounds(649, 20, 289, 49);
		editEmp.add(textUsername);
		
		textPass = new JTextField();
		textPass.setForeground(new Color(53, 74, 84));
		textPass.setFont(new Font("Century Gothic", Font.BOLD, 15));
		textPass.setColumns(10);
		textPass.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Password", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		textPass.setBounds(649, 79, 289, 49);
		editEmp.add(textPass);
		
/*########################################################    EMPLOYEE ADD BUTTON      ##############################################################
#####################################################################################################################################################*/
				
		
		JButton btnAddEMP = new JButton("");
		btnAddEMP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddEMP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//connecting to database
					PreparedStatement pstAdd, pstAutoID, pstUpdate, pstLogin;
					Connection connection = DriverManager.getConnection(url, user, password);
					pstAutoID = connection.prepareStatement("select EMP_ID from emp_details");
					pstAdd = connection.prepareStatement("insert into emp_details values (?,?,?,?,?,?,?,?,?)");
					pstLogin = connection.prepareStatement("insert into cashier_login values (?,?)");
				
					//getting texts from textFields and insert them to database table
					pstAdd.setString(1, textEMPID.getText());
					pstAdd.setString(2, textFName.getText());
					pstAdd.setString(3, textLName.getText());
					if(gender.getSelectedIndex()== 0)
						pstAdd.setString(4, "M");
					else if(gender.getSelectedIndex()== 1){
						pstAdd.setString(4, "F");
					}
					if(textNIC.getText().length() == 12) {
						pstAdd.setString(5, textNIC.getText());
					}else
						{
							JOptionPane.showMessageDialog(null, "NIC should be contained 12 charachters...");
						}
					
					if(textCNo.getText().length() == 10) {
						pstAdd.setString(6, textCNo.getText());
					}else
						{
							JOptionPane.showMessageDialog(null, "Phone No. should be contained 10 charachters...");
						}
					pstAdd.setString(7, textAddress.getText());
					pstAdd.setString(8, textUsername.getText());
					pstAdd.setString(9, textPass.getText());
					
					pstLogin.setString(1, textUsername.getText());
					pstLogin.setString(2, textPass.getText());
					
					int row = pstAdd.executeUpdate();
					if(row > 0) {
						JOptionPane.showMessageDialog(btnAddEMP, "Record Added");
						pstLogin.executeUpdate();
					}
					else
						JOptionPane.showMessageDialog(btnAddEMP, "Error");
					
					//adding next EMPID to the text field
					
					pstAutoID = connection.prepareStatement("select EMP_ID from emp_details order by EMP_ID desc limit 1");
					ResultSet rs = pstAutoID.executeQuery();
					if(rs.next()) {
						String id = rs.getString(1);
						String no = id.replaceAll("[^0-9]", "");
						String idno = "EMP" + String.format("%02d", (Integer.parseInt(no)+1));
						textEMPID.setText(idno);
						textFName.setText(null);
						textLName.setText(null);
						textNIC.setText(null);
						textCNo.setText(null);
						textAddress.setText(null);
						textUsername.setText(null);
						textPass.setText(null);
					}	
					
					pstUpdate = connection.prepareStatement("select * from emp_details");
					rs = pstUpdate.executeQuery();
					tableEmp.setModel(DbUtils.resultSetToTableModel(rs));
					DefaultTableModel model = (DefaultTableModel) tableEmp.getModel();
					
					String[] colName = {"EMP ID", "First Name", "Last Name", "Gender", "NIC", "Contact No.", "Address", "Username", "Password"};
					model.setColumnIdentifiers(colName);
					
					TableColumnModel columnModel = tableEmp.getColumnModel();
					columnModel.getColumn(0).setMaxWidth(60);
					columnModel.getColumn(1).setPreferredWidth(60);
					columnModel.getColumn(2).setPreferredWidth(60);
					columnModel.getColumn(3).setMaxWidth(45);
					columnModel.getColumn(4).setMaxWidth(90);
					columnModel.getColumn(4).setMinWidth(90);
					columnModel.getColumn(5).setMaxWidth(90);
					columnModel.getColumn(6).setMinWidth(180);
					columnModel.getColumn(7).setMaxWidth(90);
					columnModel.getColumn(8).setMaxWidth(90);
					
					DefaultTableCellRenderer center = new DefaultTableCellRenderer();
					center.setHorizontalAlignment(JLabel.CENTER);
					
					tableEmp.getColumnModel().getColumn(0).setCellRenderer(center);
					tableEmp.getColumnModel().getColumn(3).setCellRenderer(center);
					tableEmp.getColumnModel().getColumn(4).setCellRenderer(center);
					tableEmp.getColumnModel().getColumn(5).setCellRenderer(center);
					
					while(rs.next()) {
						String[] data = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)};
						model.addRow(data);
					}
					pstUpdate.close();
					connection.close();
					
			
				} catch (Exception e2) {
				
				}
			
				
			}
		});
		btnAddEMP.setIcon(new ImageIcon(AdminPage.class.getResource("/seller/empAdd.png")));
		btnAddEMP.setFocusable(false);
		btnAddEMP.setFocusTraversalKeysEnabled(false);
		btnAddEMP.setBorderPainted(false);
		btnAddEMP.setBorder(null);
		btnAddEMP.setBackground(Color.WHITE);
		btnAddEMP.setBounds(329, 189, 70, 70);
		editEmp.add(btnAddEMP);
		
/*########################################################    EMPLOYEE REMOVE BUTTON      ##############################################################
#####################################################################################################################################################*/
		
		JButton btnRemoveEMP = new JButton("");
		btnRemoveEMP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRemoveEMP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//connecting to database
					PreparedStatement pstRemove, pstAutoID, pstUpdate, pstLoginRemove;
					Connection connection = DriverManager.getConnection(url, user, password);
					pstAutoID = connection.prepareStatement("select EMP_ID from emp_details");
					pstRemove = connection.prepareStatement("delete from emp_details where EMP_ID = ?");
					
					int rn = tableEmp.getSelectedRow();
					String EMPID = (tableEmp.getModel().getValueAt(rn, 0)).toString();
					pstLoginRemove = connection.prepareStatement("delete from cashier_login where Username in (select Username FROM emp_details where EMP_ID = '"+EMPID+"')");
					pstLoginRemove.execute();
									
					pstRemove.setString(1, textEMPID.getText());
					
					int row = pstRemove.executeUpdate();
					
					if(row > 0) {
						JOptionPane.showMessageDialog(btnRemoveEMP, "Record Deleted");
					}
					else
						JOptionPane.showMessageDialog(btnRemoveEMP, "Error");
						
					
					//adding next EMPID to the text field
					
					pstAutoID = connection.prepareStatement("select EMP_ID from emp_details order by EMP_ID desc limit 1");
					ResultSet rs = pstAutoID.executeQuery();
					if(rs.next()) {
						String id = rs.getString(1);
						String no = id.replaceAll("[^0-9]", "");
						String idno = "EMP" + String.format("%02d", (Integer.parseInt(no)+1));
						textEMPID.setText(idno);
						textFName.setText(null);
						textLName.setText(null);
						textNIC.setText(null);
						textCNo.setText(null);
						textAddress.setText(null);
						textUsername.setText(null);
						textPass.setText(null);
					}	
					
					pstUpdate = connection.prepareStatement("select * from emp_details");
					rs = pstUpdate.executeQuery();
					tableEmp.setModel(DbUtils.resultSetToTableModel(rs));
					DefaultTableModel model = (DefaultTableModel) tableEmp.getModel();
					
					String[] colName = {"EMP ID", "First Name", "Last Name", "Gender", "NIC", "Contact No.", "Address", "Username", "Password"};
					model.setColumnIdentifiers(colName);
					
					TableColumnModel columnModel = tableEmp.getColumnModel();
					columnModel.getColumn(0).setMaxWidth(60);
					columnModel.getColumn(1).setPreferredWidth(60);
					columnModel.getColumn(2).setPreferredWidth(60);
					columnModel.getColumn(3).setMaxWidth(45);
					columnModel.getColumn(4).setMaxWidth(90);
					columnModel.getColumn(4).setMinWidth(90);
					columnModel.getColumn(5).setMaxWidth(90);
					columnModel.getColumn(6).setMinWidth(180);
					columnModel.getColumn(7).setMaxWidth(90);
					columnModel.getColumn(8).setMaxWidth(90);
					
					DefaultTableCellRenderer center = new DefaultTableCellRenderer();
					center.setHorizontalAlignment(JLabel.CENTER);
					
					tableEmp.getColumnModel().getColumn(0).setCellRenderer(center);
					tableEmp.getColumnModel().getColumn(3).setCellRenderer(center);
					tableEmp.getColumnModel().getColumn(4).setCellRenderer(center);
					tableEmp.getColumnModel().getColumn(5).setCellRenderer(center);
					
					while(rs.next()) {
						String[] data = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)};
						model.addRow(data);
					}
					pstUpdate.close();
					connection.close();
					
				} catch (Exception e2) {
					
				}
			}
		});
		btnRemoveEMP.setIcon(new ImageIcon(AdminPage.class.getResource("/seller/empRemove.png")));
		btnRemoveEMP.setFocusable(false);
		btnRemoveEMP.setBorderPainted(false);
		btnRemoveEMP.setBackground(Color.WHITE);
		btnRemoveEMP.setBounds(409, 189, 70, 70);
		editEmp.add(btnRemoveEMP);
		
/*########################################################    EMPLOYEE SAVE BUTTON      ##############################################################
#####################################################################################################################################################*/
		
		JButton btnSaveEMP = new JButton("");
		btnSaveEMP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSaveEMP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//connecting to database
					PreparedStatement pstSave, pstAutoID, pstUpdate, pstLogin;
					Connection connection = DriverManager.getConnection(url, user, password);
					
					pstAutoID = connection.prepareStatement("select EMP_ID from emp_details");
					
					pstSave = connection.prepareStatement("update emp_details set First_Name = ?, Last_Name = ?, Gender = ?, NIC = ?, Contact_No = ?, Address = ?, Username = ?, Password = ? where EMP_ID = ?");
					
					int rn = tableEmp.getSelectedRow();
					String EMPID = (tableEmp.getModel().getValueAt(rn, 0)).toString();
					pstLogin = connection.prepareStatement("update cashier_login set username = ?, password = ? where Username in (select Username FROM emp_details where EMP_ID = '"+EMPID+"')");
					
					//getting texts from textFields and insert them to database table
					pstSave.setString(9, textEMPID.getText());
					pstSave.setString(1, textFName.getText());
					pstSave.setString(2, textLName.getText());
					if(gender.getSelectedIndex()== 0)
						pstSave.setString(3, "M");
					else if(gender.getSelectedIndex()== 1){
						pstSave.setString(3, "F");
					}
					pstSave.setString(4, textNIC.getText());
					pstSave.setString(5, textCNo.getText());
					pstSave.setString(6, textAddress.getText());
					pstSave.setString(7, textUsername.getText());
					pstLogin.setString(1, textUsername.getText());
					pstSave.setString(8, textPass.getText());
					pstLogin.setString(2, textPass.getText());
					
					
					int row = pstSave.executeUpdate();
					int row2 = pstLogin.executeUpdate();
					if(row > 0 && row2 > 0)
					JOptionPane.showMessageDialog(btnSaveEMP, "Record Updated");
					else
					JOptionPane.showMessageDialog(btnSaveEMP, "Error");
					
					//adding next EMPID to the text field
					
					pstAutoID = connection.prepareStatement("select EMP_ID from emp_details order by EMP_ID desc limit 1");
					ResultSet rs = pstAutoID.executeQuery();
					if(rs.next()) {
						String id = rs.getString(1);
						String no = id.replaceAll("[^0-9]", "");
						String idno = "EMP" + String.format("%02d", (Integer.parseInt(no)+1));
						textEMPID.setText(idno);
						textFName.setText(null);
						textLName.setText(null);
						textNIC.setText(null);
						textCNo.setText(null);
						textAddress.setText(null);
						textUsername.setText(null);
						textPass.setText(null);
					}	
					
					pstUpdate = connection.prepareStatement("select * from emp_details");
					rs = pstUpdate.executeQuery();
					tableEmp.setModel(DbUtils.resultSetToTableModel(rs));
					DefaultTableModel model = (DefaultTableModel) tableEmp.getModel();
					
					String[] colName = {"EMP ID", "First Name", "Last Name", "Gender", "NIC", "Contact No.", "Address", "Username", "Password"};
					model.setColumnIdentifiers(colName);
					
					TableColumnModel columnModel = tableEmp.getColumnModel();
					columnModel.getColumn(0).setMaxWidth(60);
					columnModel.getColumn(1).setPreferredWidth(60);
					columnModel.getColumn(2).setPreferredWidth(60);
					columnModel.getColumn(3).setMaxWidth(45);
					columnModel.getColumn(4).setMaxWidth(90);
					columnModel.getColumn(4).setMinWidth(90);
					columnModel.getColumn(5).setMaxWidth(90);
					columnModel.getColumn(6).setMinWidth(180);
					columnModel.getColumn(7).setMaxWidth(90);
					columnModel.getColumn(8).setMaxWidth(90);
					
					DefaultTableCellRenderer center = new DefaultTableCellRenderer();
					center.setHorizontalAlignment(JLabel.CENTER);
					
					tableEmp.getColumnModel().getColumn(0).setCellRenderer(center);
					tableEmp.getColumnModel().getColumn(3).setCellRenderer(center);
					tableEmp.getColumnModel().getColumn(4).setCellRenderer(center);
					tableEmp.getColumnModel().getColumn(5).setCellRenderer(center);
					
					while(rs.next()) {
						String[] data = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)};
						model.addRow(data);
					}
					pstUpdate.close();
					connection.close();
					
				} catch (Exception e2) {
					
				}
			}
		});
		btnSaveEMP.setIcon(new ImageIcon(AdminPage.class.getResource("/seller/empEdit.png")));
		btnSaveEMP.setFocusable(false);
		btnSaveEMP.setBorderPainted(false);
		btnSaveEMP.setBackground(Color.WHITE);
		btnSaveEMP.setBounds(489, 189, 70, 70);
		editEmp.add(btnSaveEMP);
		
/*########################################################    EMPLOYEE RESET BUTTON      ##############################################################
#####################################################################################################################################################*/

		JButton btnResetEMP = new JButton("");
		btnResetEMP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnResetEMP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PreparedStatement pstAutoID;
					Connection connection = DriverManager.getConnection(url, user, password);
					pstAutoID = connection.prepareStatement("select EMP_ID from emp_details order by EMP_ID desc limit 1");
					ResultSet rs = pstAutoID.executeQuery();
					if(rs.next()) {
						String id = rs.getString(1);
						String no = id.replaceAll("[^0-9]", "");
						String idno = "EMP" + String.format("%02d", (Integer.parseInt(no)+1));
						textEMPID.setText(idno);
						textFName.setText(null);
						textLName.setText(null);
						textNIC.setText(null);
						textCNo.setText(null);
						textAddress.setText(null);
						textUsername.setText(null);
						textPass.setText(null);
					}
				} catch (Exception e1) {
				
				}
			}
		});
		btnResetEMP.setIcon(new ImageIcon(AdminPage.class.getResource("/basic/reset.png")));
		btnResetEMP.setFocusable(false);
		btnResetEMP.setBorderPainted(false);
		btnResetEMP.setBackground(Color.WHITE);
		btnResetEMP.setBounds(569, 189, 70, 70);
		editEmp.add(btnResetEMP);
		
		JLabel lblAdd_4_1 = new JLabel("Add");
		lblAdd_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdd_4_1.setForeground(new Color(0, 196, 0));
		lblAdd_4_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblAdd_4_1.setBounds(329, 259, 70, 24);
		editEmp.add(lblAdd_4_1);
		
		JLabel lblRemove_4_1 = new JLabel("Remove");
		lblRemove_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemove_4_1.setForeground(new Color(185, 17, 17));
		lblRemove_4_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblRemove_4_1.setBounds(409, 259, 70, 24);
		editEmp.add(lblRemove_4_1);
		
		JLabel lblSave_4_1 = new JLabel("Update");
		lblSave_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSave_4_1.setForeground(new Color(1, 151, 194));
		lblSave_4_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblSave_4_1.setBounds(489, 259, 70, 24);
		editEmp.add(lblSave_4_1);
		
		JLabel lblReset_4_1 = new JLabel("Reset");
		lblReset_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblReset_4_1.setForeground(new Color(0, 128, 128));
		lblReset_4_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblReset_4_1.setBounds(569, 259, 70, 24);
		editEmp.add(lblReset_4_1);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setForeground(new Color(53, 74, 84));
		scrollPane.setFont(new Font("Century Gothic", Font.BOLD, 10));
		scrollPane.setBorder(new LineBorder(new Color(1, 151, 194), 3, true));
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(33, 310, 964, 208);
		emp.add(scrollPane);
		
		tableEmp = new JTable();
		try {
			PreparedStatement pStatement;
			Connection connection = DriverManager.getConnection(url, user, password);
			pStatement = connection.prepareStatement("select * from emp_details");
			ResultSet rs = pStatement.executeQuery();
			DefaultTableModel model = (DefaultTableModel) tableEmp.getModel();
			
			String[] colName = {"EMP ID", "First Name", "Last Name", "Gender", "NIC", "Contact No.", "Address", "Username", "Password"};
			model.setColumnIdentifiers(colName);
			
			TableColumnModel columnModel = tableEmp.getColumnModel();
			columnModel.getColumn(0).setMaxWidth(60);
			columnModel.getColumn(1).setPreferredWidth(60);
			columnModel.getColumn(2).setPreferredWidth(60);
			columnModel.getColumn(3).setMaxWidth(45);
			columnModel.getColumn(4).setMaxWidth(90);
			columnModel.getColumn(4).setMinWidth(90);
			columnModel.getColumn(5).setMaxWidth(90);
			columnModel.getColumn(6).setMinWidth(180);
			columnModel.getColumn(7).setMaxWidth(90);
			columnModel.getColumn(8).setMaxWidth(90);
			
			DefaultTableCellRenderer center = new DefaultTableCellRenderer();
			center.setHorizontalAlignment(JLabel.CENTER);
			
			tableEmp.getColumnModel().getColumn(0).setCellRenderer(center);
			tableEmp.getColumnModel().getColumn(3).setCellRenderer(center);
			tableEmp.getColumnModel().getColumn(4).setCellRenderer(center);
			tableEmp.getColumnModel().getColumn(5).setCellRenderer(center);
			
			while(rs.next()) {
				String[] row = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)};
				model.addRow(row);
			}
			pStatement.close();
			connection.close();
			
		} catch (Exception e) {
		
		}
		//update text fields according table row clicks
		tableEmp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				//connecting to database
					Connection connection = DriverManager.getConnection(url, user, password);
					
					int row = tableEmp.getSelectedRow();
					String EMPID = (tableEmp.getModel().getValueAt(row, 0)).toString();
					PreparedStatement pst = connection.prepareStatement("select * from emp_details where EMP_ID = '"+EMPID+"' ");
					ResultSet rs = pst.executeQuery();
					while (rs.next()) {
						textEMPID.setText(rs.getString("EMP_ID"));
						textFName.setText(rs.getString("First_Name"));
						textLName.setText(rs.getString("Last_Name"));
						if(rs.getString("Gender").equals("M")) {
							gender.setSelectedIndex(0);
						}else{
							gender.setSelectedIndex(1);
						}
						textNIC.setText(rs.getString("NIC"));
						textCNo.setText(rs.getString("Contact_No"));
						textAddress.setText(rs.getString("Address"));
						textUsername.setText(rs.getString("Username"));
						textPass.setText(rs.getString("Password"));
						
					}
					pst.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		tableEmp.setGridColor(new Color(1, 151, 194));
		tableEmp.setForeground(new Color(53, 74, 84));
		tableEmp.setRowHeight(35);
		tableEmp.setFont(new Font("Century Gothic", Font.BOLD, 11));
		tableEmp.setBorder(new MatteBorder(3, 1, 1, 1, (Color) new Color(1, 151, 194)));
		scrollPane.setViewportView(tableEmp);
		
		sales.setBackground(Color.WHITE);
		sideMenuPages.addTab("New tab", null, sales, null);
		sales.setLayout(null);
		
		
		JTextArea billView = new JTextArea();
		billView.setBorder(new LineBorder(new Color(1, 151, 194), 3, true));
		billView.setBounds(661, 58, 306, 480);
		sales.add(billView);
		
		JLabel lblTotalSales = new JLabel("Total Sales:");
		lblTotalSales.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblTotalSales.setBounds(237, 402, 150, 50);
		sales.add(lblTotalSales);
		
		JLabel lblTotalNo = new JLabel("Rs. 0.00");
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
		
		JScrollPane scrollPaneBills = new JScrollPane();
		scrollPaneBills.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		scrollPaneBills.setBounds(65, 58, 565, 334);
		sales.add(scrollPaneBills);
		

/*##############################################################################################################################################
##########################################################     SALES TABLE      ################################################################
################################################################################################################################################*/
		
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
		
		scrollPaneBills.setViewportView(tableBills);
		tableBills.setRowHeight(35);
		tableBills.setGridColor(new Color(53, 74, 84));
		tableBills.setForeground(new Color(53, 74, 84));
		tableBills.setFont(new Font("Century Gothic", Font.BOLD, 15));
		tableBills.setBorder(new MatteBorder(3, 1, 1, 1, (Color) new Color(53, 74, 84)));
		
		
		frameAdminPage.setBackground(new Color(255, 255, 255));
		frameAdminPage.setUndecorated(true);
		frameAdminPage.setBounds(100, 100, 1287, 668);
		frameAdminPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
