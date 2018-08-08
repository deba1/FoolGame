import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.applet.*;
import java.io.*;
import javax.sound.sampled.*;

public class Game extends JFrame implements ActionListener, MouseListener {
	private final int WIDTH = 600;
	private final int HEIGHT = 600;
	private JLabel title, background;
	private ImageIcon bgimg;
	private JButton buttonYes, buttonNo;
	private JPanel panel;
	public Game() {
		super("Fool Tester");
		
		this.setSize(WIDTH, HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		Font fontTitle = new Font("Comic Sans MS", Font.BOLD, 30);
		Font fontButton = new Font("Bahnschrift", Font.PLAIN, 15);
		
		title = new JLabel("ARE YOU FOOL ?");
		title.setBounds(150,80,300,30);
		title.setForeground(Color.WHITE);
		title.setFont(fontTitle);
		panel.add(title);
		
		buttonYes = new JButton("Yes");
		buttonYes.setBounds(200,150,60,30);
		buttonYes.setBackground(Color.WHITE);
		buttonYes.setFont(fontButton);
		buttonYes.setFocusPainted(false);
		buttonYes.addActionListener(this);
		buttonYes.addMouseListener(this);
		panel.add(buttonYes);
		
		buttonNo = new JButton("No");
		buttonNo.setBounds(300,150,60,30);
		buttonNo.setBackground(Color.WHITE);
		buttonNo.addMouseListener(this);
		buttonNo.setFont(fontButton);
		buttonNo.addActionListener(this);
		panel.add(buttonNo);
		
		bgimg = new ImageIcon("images/background.jpg");
		background = new JLabel(bgimg);
		background.setBounds(0, 0, WIDTH, HEIGHT);
		panel.add(background);
		
		this.add(panel);
	}
	
	public static void playSound(String sound) {
		try {
			File soundFile = new File(sound);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);              
			Clip clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void  actionPerformed(ActionEvent ae) {
		String result = ae.getActionCommand();
		if (result.equals(buttonYes.getText())) {
			this.playSound("sounds/click.wav");
			new Result(true).setVisible(true);
			this.setVisible(false);
		}
		else if (result.equals(buttonNo.getText())) {
			this.playSound("sounds/click.wav");
			new Result(false).setVisible(true);
			this.setVisible(false);
		}
		else {}
	}
	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseEntered(MouseEvent me) {
		if(me.getSource().equals(buttonNo))
		{
			this.playSound("sounds/no.wav");
			Random r = new Random();
			buttonNo.setBounds(r.nextInt(WIDTH-80), r.nextInt(HEIGHT-50), 60, 30);
			buttonNo.setBackground(Color.BLACK);
			buttonNo.setForeground(Color.WHITE);
		}
		else if(me.getSource().equals(buttonYes))
		{
			buttonYes.setBackground(Color.BLACK);
			buttonYes.setForeground(Color.WHITE);
		}
		else{}
	}
	public void mouseExited(MouseEvent me) {
		if(me.getSource().equals(buttonNo))
		{
			buttonNo.setBackground(Color.WHITE);
			buttonNo.setForeground(Color.BLACK);
		}
		else if (me.getSource().equals(buttonYes)) {
			buttonYes.setBackground(Color.WHITE);
			buttonYes.setForeground(Color.BLACK);
		}
		else{}
	}
	
}