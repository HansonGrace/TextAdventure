import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {

	//variables
	JFrame window;
	Container con;
	JPanel titlePanel;
	JPanel startPanel, mainTextPanel;
	JLabel titleLabel;
	JButton startButton;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 65);
	Font startButtonFont = new Font("Times New Roman", Font.PLAIN, 30 );
	JTextArea mainTextArea;
	
	public static void main(String[] args) {
		
		new Game();
		

	}
	public Game() {
		
		//Set game window:
		
		//initialize JFrame and set size (width, height)
		window = new JFrame();
		window.setSize(800, 600);
		//function to close window properly
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		//disable default layout to have a customzied layout
		window.setLayout(null);
	
		
		//create titlePanel and set restrictions
		titlePanel = new JPanel();
		con = window.getContentPane();
		//set bounds and color for starting screen title
		titlePanel.setBounds(100, 100, 600, 100);
		titlePanel.setBackground(Color.black);
		
		//container to add text to
		titleLabel = new JLabel("TEXT ADVENTURE");
		con.add(titlePanel);
		titleLabel.setForeground(Color.white);
		titlePanel.add(titleLabel);
		titleLabel.setFont(titleFont);
		
		//create start button
		startPanel = new JPanel();
		startPanel.setBounds(300, 400, 150, 60);
		startPanel.setBackground(Color.black);
		con.add(startPanel);
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		con.add(startButton);
		startPanel.add(startButton);
		startButton.setFont(startButtonFont);
		
		//make window appear on screen
		window.setVisible(true);
	}
	
	//method to create game screen
	public void createGameScreen() {
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.blue);
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea();
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(startButtonFont);
		//if text is too long
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		
		
	}
	
	public class titleScreenHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
			
			
		}
	}

}
