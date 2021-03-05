import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import keeptoo.KGradientPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginGUI extends JFrame {

	private JPanel panel;
	private JTextField txtAd;
	private JPasswordField passwordField;
	private JButton btnGiris;
	private JLabel lblHogeldiniz;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 389);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);

		KGradientPanel gradientPanel = new KGradientPanel();
		gradientPanel.kEndColor = new Color(0, 153, 255);
		gradientPanel.setBounds(0, 0, 551, 352);
		panel.add(gradientPanel);
		gradientPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Kullanici Adi");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblNewLabel.setBounds(48, 122, 111, 35);
		gradientPanel.add(lblNewLabel);

		JLabel lblifre = new JLabel("Sifre");
		lblifre.setForeground(Color.WHITE);
		lblifre.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblifre.setBackground(Color.WHITE);
		lblifre.setBounds(48, 193, 87, 35);
		gradientPanel.add(lblifre);

		txtAd = new JTextField();
		txtAd.setBounds(286, 122, 204, 35);
		gradientPanel.add(txtAd);
		txtAd.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(286, 193, 204, 35);
		gradientPanel.add(passwordField);

		btnGiris = new JButton("Giris Yap");
		btnGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtAd.getText().length() == 0 || passwordField.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Kullanici Bilgileri Eksik !!", "Uyari",
							JOptionPane.WARNING_MESSAGE);
				}
				GameGUI game = new GameGUI();
				JOptionPane.showMessageDialog(null,
						"Kirmizi Noktayi Toplayarak Coin Kazan ve Can Satin Al Veya Alanin Icinde Kalmaya Calis",
						"Uyari", JOptionPane.WARNING_MESSAGE);
				game.setVisible(true);
				dispose();

			}
		});
		btnGiris.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		btnGiris.setBounds(48, 278, 442, 41);
		gradientPanel.add(btnGiris);

		lblHogeldiniz = new JLabel("Hosgeldiniz");
		lblHogeldiniz.setForeground(Color.WHITE);
		lblHogeldiniz.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		lblHogeldiniz.setBackground(Color.WHITE);
		lblHogeldiniz.setBounds(197, 39, 111, 41);
		gradientPanel.add(lblHogeldiniz);

		JSeparator separator = new JSeparator();
		separator.setBounds(48, 155, 442, 2);
		gradientPanel.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(44, 226, 446, 2);
		gradientPanel.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(48, 74, 446, 2);
		gradientPanel.add(separator_2);
	}
}
