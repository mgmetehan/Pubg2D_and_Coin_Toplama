import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class GameGUI extends JFrame implements KeyListener, ActionListener {
	JLabel lblCan = new JLabel("");
	JLabel lblCan_1 = new JLabel("Can:");
	JLabel lblCoin_1 = new JLabel("0");
	JLabel lblCoin = new JLabel("Coin");
	private JPanel w_panel;
	private int AlanX = (int) (Math.random() * 1000), AlanY = (int) (Math.random() * 800), AlanW = 700, AlanH = 700;
	private int karakterX = 50, karakterY = 50, karakterW = 30, karakterH = 30, sayac;
	private float can = 100;
	private int KitX = 500, KitY = 500, KitW = 20, KitH = 20;
	private int hvar = 0, coin = 0;
	private String yol;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameGUI frame = new GameGUI();
					frame.setVisible(true);
					frame.setFocusable(false);
					frame.setBackground(Color.white);
					frame.setTitle("Pubg 2D");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GameGUI() {
		Timer time = new Timer(20, this);
		time.start();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		w_panel = new JPanel();
		w_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(w_panel);
		w_panel.setBackground(Color.white);
		w_panel.requestFocus();
		w_panel.addKeyListener(this);
		w_panel.setFocusable(true);
		w_panel.setFocusTraversalKeysEnabled(false);
		w_panel.setLayout(null);

		lblCan.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblCan.setBounds(872, 29, 100, 47);
		w_panel.add(lblCan);

		lblCan_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblCan_1.setBounds(784, 29, 62, 47);
		w_panel.add(lblCan_1);

		lblCoin_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblCoin_1.setBounds(872, 65, 100, 47);
		w_panel.add(lblCoin_1);

		lblCoin.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblCoin.setBounds(784, 65, 62, 47);
		w_panel.add(lblCoin);

		JList list = new JList();
		list.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] { "Q=+4 Can Para=-5", "W=+8 Can Para=-10", "E=+18 Can Para=-20" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(10, 29, 170, 78);
		w_panel.add(list);

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		sayac++;

		g.setColor(Color.lightGray);
		g.fillOval(AlanX, AlanY, AlanW, AlanH);

		g.setColor(Color.red);
		g.fillRect(KitX, KitY, KitW, KitH);

		g.setColor(Color.black);
		g.fillRect(karakterX, karakterY, karakterW, karakterH);

		// g.setColor(Color.black);
		// g.drawString(String.valueOf(can), 100, 200);
		if (kontrol() == true) {
		} else if (kontrol() == false) {
			if (sayac % 10 == 0) {
				can -= 2;
				lblCan.setText(String.valueOf(can));
			}
			if (can == 0) {
				JOptionPane.showMessageDialog(this, "Öldünüz!!", "Uyarı", JOptionPane.ERROR_MESSAGE);
				lblCan.setText(String.valueOf(can));
				System.exit(0);
			}
		}
		if (medkit() == true) {
			coin += 2;
			medkRand();
			lblCoin_1.setText(String.valueOf(coin));
		} else if (medkit() == false) {
		}

	}

	@Override
	public void repaint() {
		super.repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {// Haraket
		int x = e.getKeyCode();
		if (x == KeyEvent.VK_LEFT) {
			if (karakterX <= 50) {
				karakterX = 10;
			} else {
				karakterX -= karakterW;
			}
		} else if (x == KeyEvent.VK_RIGHT) {
			if (karakterX >= 920) {
				karakterX = 930;
			}
			karakterX += karakterW;
		} else if (x == KeyEvent.VK_DOWN) {
			if (karakterY > 720) {
				karakterY = 730;
			}
			karakterY += karakterW;
		} else if (x == KeyEvent.VK_UP) {
			if (karakterY < 55) {
				karakterY = 70;
			}
			karakterY -= karakterW;
		} else if (x == KeyEvent.VK_Q) {

			if (coin >= 6) {
				coin -= 5;
				can += 5;
				lblCan.setText(String.valueOf(can));
				lblCoin_1.setText(String.valueOf(coin));
			}

		} else if (x == KeyEvent.VK_W) {

			if (coin >= 10) {
				coin -= 10;
				can += 8;
				lblCan.setText(String.valueOf(can));
				lblCoin_1.setText(String.valueOf(coin));
			}

		} else if (x == KeyEvent.VK_E) {

			if (coin >= 20) {
				coin -= 20;
				can += 18;
				lblCan.setText(String.valueOf(can));
				lblCoin_1.setText(String.valueOf(coin));
			}

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AlanW -= 0.5;
		AlanH -= 0.5;
		repaint();
	}

	public void medkRand() {
		KitX = (int) (Math.random() * 900 + 80);
		KitY = (int) (Math.random() * 700 + 80);
	}

	public boolean kontrol() {
		if (new Rectangle(AlanX, AlanY, AlanW, AlanH).intersects(new Rectangle(karakterX, karakterY, 30, 30))) {
			return true;
		}
		return false;
	}

	public boolean medkit() {
		if (new Rectangle(KitX, KitY, KitW, KitH).intersects(new Rectangle(karakterX, karakterY, 30, 30))) {
			return true;
		}
		return false;
	}
}
