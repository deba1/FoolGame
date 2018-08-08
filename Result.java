import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

public class Result extends JFrame implements ActionListener, MouseListener {
	private final int WIDTH = 600;
	private final int HEIGHT = 600;
	private JLabel title, emo, background;
	private JButton buttonRetry, buttonExit;
	private JPanel panel;
	public Result(boolean fool) {
		super(fool ? "Fooled You" : "Smart Enough");
		
		this.setSize(WIDTH,HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		Font fontTitle = new Font("Comic Sans MS", Font.BOLD, 25);
		Font fontButton = new Font("Bahnschrift", Font.PLAIN, 15);
		
		String result;
		if (fool)
			result = "Looks Like, You are a fool!";
		else
			result = "You seams to be Smart!";
		
		title = new JLabel(result);
		title.setBounds(fool ? 125 : 150,80,400,30);
		title.setForeground(Color.WHITE);
		title.setFont(fontTitle);
		panel.add(title);
		
		emo = new JLabel(new ImageIcon(fool ? "images/fool.gif" : "images/smart.gif"));
		emo.setBounds(150, 125, 300, 300);
		emo.setOpaque(false);
		panel.add(emo);
		
		buttonRetry = new JButton("Retry");
		buttonRetry.setBounds(200,450,80,30);
		buttonRetry.addActionListener(this);
		buttonRetry.setFont(fontButton);
		buttonRetry.setFocusPainted(false);
		buttonRetry.addMouseListener(this);
		panel.add(buttonRetry);
		
		buttonExit = new JButton("Exit");
		buttonExit.setBounds(300,450,80,30);
		buttonExit.addActionListener(this);
		buttonExit.setFont(fontButton);
		buttonExit.setFocusPainted(false);
		buttonExit.addMouseListener(this);
		panel.add(buttonExit);
		
		background = new JLabel(new ImageIcon("images/background.jpg"));
		background.setBounds(0, 0, WIDTH, HEIGHT);
		panel.add(background);
		
		this.add(panel);
		
		try {
			TimeUnit.SECONDS.sleep(1);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		Game.playSound(fool ? "sounds/fool.wav" : "sounds/smart.wav");
	}
	
	public void actionPerformed(ActionEvent ae) {
		String result = ae.getActionCommand();
		if (result.equals(buttonRetry.getText())) {
			Game.playSound("sounds/click.wav");
			new Game().setVisible(true);
			this.setVisible(false);
		}
		else if (result.equals(buttonExit.getText())) {
			Game.playSound("sounds/click.wav");
			System.exit(0);
		}
		else {}
	}
	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseEntered(MouseEvent me) {
		if(me.getSource().equals(buttonRetry))
		{
			buttonRetry.setBackground(Color.BLACK);
			buttonRetry.setForeground(Color.WHITE);
		}
		else if(me.getSource().equals(buttonExit))
		{
			buttonExit.setBackground(Color.BLACK);
			buttonExit.setForeground(Color.WHITE);
		}
		else{}
	}
	public void mouseExited(MouseEvent me) {
		if(me.getSource().equals(buttonRetry))
		{
			buttonRetry.setBackground(Color.WHITE);
			buttonRetry.setForeground(Color.BLACK);
		}
		else if (me.getSource().equals(buttonExit)) {
			buttonExit.setBackground(Color.WHITE);
			buttonExit.setForeground(Color.BLACK);
		}
		else{}
	}
}