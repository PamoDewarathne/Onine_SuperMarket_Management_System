package popups;

import java.awt.EventQueue;

import javax.swing.JFrame;
import keeptoo.KGradientPanel;
import login.Login;

import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Cursor;

public class Info extends Login{

	private JFrame frameInfo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Info window = new Info();
					window.frameInfo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Info() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameInfo = new JFrame();
		frameInfo.setUndecorated(true);
		frameInfo.setBounds(100, 100, 406, 454);
		frameInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameInfo.getContentPane().setLayout(null);
		
		KGradientPanel gradientPanel = new KGradientPanel();
		gradientPanel.setkStartColor(new Color(0, 184, 166));
		gradientPanel.setkEndColor(new Color(0, 65, 102));
		gradientPanel.setBounds(0, 0, 406, 457);
		frameInfo.getContentPane().add(gradientPanel);
		gradientPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(53, 74, 84));
		panel.setBounds(10, 46, 386, 395);
		gradientPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblTnx = new JLabel("Thank You!");
		lblTnx.setHorizontalAlignment(SwingConstants.CENTER);
		lblTnx.setForeground(new Color(0, 184, 166));
		lblTnx.setFont(new Font("Century Gothic", Font.BOLD, 45));
		lblTnx.setBounds(0, 7, 386, 78);
		panel.add(lblTnx);
		
		JLabel lblNewLabel = new JLabel("Created by :");
		lblNewLabel.setForeground(new Color(154, 235, 188));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblNewLabel.setBounds(29, 88, 162, 46);
		panel.add(lblNewLabel);
		
		JLabel lblDewarathnePS = new JLabel("Dewarathne P S");
		lblDewarathnePS.setForeground(Color.WHITE);
		lblDewarathnePS.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblDewarathnePS.setBounds(50, 133, 152, 40);
		panel.add(lblDewarathnePS);
		
		JLabel lblHasaraMK = new JLabel("Hasara M K");
		lblHasaraMK.setForeground(Color.WHITE);
		lblHasaraMK.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblHasaraMK.setBounds(50, 173, 152, 40);
		panel.add(lblHasaraMK);
		
		JLabel lblGonagalaGA = new JLabel("Gonagala G A S T");
		lblGonagalaGA.setForeground(Color.WHITE);
		lblGonagalaGA.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblGonagalaGA.setBounds(50, 213, 152, 40);
		panel.add(lblGonagalaGA);
		
		JLabel lblPereraPA = new JLabel("Perera P A I P");
		lblPereraPA.setForeground(Color.WHITE);
		lblPereraPA.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblPereraPA.setBounds(50, 253, 152, 40);
		panel.add(lblPereraPA);
		
		JLabel lblIt = new JLabel("IT22004536");
		lblIt.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIt.setForeground(Color.WHITE);
		lblIt.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblIt.setBounds(230, 133, 104, 40);
		panel.add(lblIt);
		
		JLabel lblIt_4 = new JLabel("IT22308566");
		lblIt_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIt_4.setForeground(Color.WHITE);
		lblIt_4.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblIt_4.setBounds(230, 173, 104, 40);
		panel.add(lblIt_4);
		
		JLabel lblIt_1 = new JLabel("IT22314956");
		lblIt_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIt_1.setForeground(Color.WHITE);
		lblIt_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblIt_1.setBounds(230, 213, 104, 40);
		panel.add(lblIt_1);
		
		JLabel lblIt_2 = new JLabel("IT22884824");
		lblIt_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIt_2.setForeground(Color.WHITE);
		lblIt_2.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblIt_2.setBounds(230, 253, 104, 40);
		panel.add(lblIt_2);
		
		JButton btnNewButton = new JButton("References");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Desktop browser = Desktop.getDesktop();
				try {
					browser.browse(new URI("https://youtube.com/playlist?list=PLNNVm1DhlpLdC63_8VFsVDIXSGpmEk8-Y&si=Hz69rxGdCm-wYWNl"));
				} catch (IOException err) {
					
				}catch (URISyntaxException err) {

				}
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(new Color(0, 220, 206));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(new Color(0, 184, 166));
			}
		});
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(0, 184, 166));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 20));
		btnNewButton.setFocusTraversalKeysEnabled(false);
		btnNewButton.setFocusable(false);
		btnNewButton.setBounds(103, 316, 175, 44);
		panel.add(btnNewButton);
		
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
				frameInfo.setVisible(false);
			}
		});
		closeBtn.setToolTipText("Close");
		closeBtn.setFocusable(false);
		closeBtn.setFocusTraversalKeysEnabled(false);
		closeBtn.setContentAreaFilled(false);
		closeBtn.setBorder(new LineBorder(new Color(255, 28, 28), 68, true));
		closeBtn.setBounds(370, 14, 18, 18);
		gradientPanel.add(closeBtn);
		
		JLabel lblAbout = new JLabel("About");
		lblAbout.setForeground(Color.WHITE);
		lblAbout.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblAbout.setBounds(21, 0, 73, 47);
		gradientPanel.add(lblAbout);
		
		JPanel movePanel = new JPanel();
		movePanel.setBounds(0, 0, 406, 48);
		gradientPanel.add(movePanel);
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
				frameInfo.setLocation(frameInfo.getX() + e.getX() - mouseX, frameInfo.getY() + e.getY() - mouseY);
			}
		});
		movePanel.setOpaque(false);
		movePanel.setFocusable(false);
		movePanel.setBorder(null);
	}
}
