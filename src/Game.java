import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
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
	JPanel startPanel, mainTextPanel, choiceButtonPanel;
	JLabel titleLabel;
	JButton startButton, choice1, choice2, choice3, choice4;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 65);
	Font startButtonFont = new Font("Times New Roman", Font.PLAIN, 30 );
	JTextArea mainTextArea;
	
	titleScreenHandler tsHandler = new titleScreenHandler();
	
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
		startButton.addActionListener(tsHandler);
		
		//make window appear on screen
		window.setVisible(true);
	}
	
	//method to create game screen
	public void createGameScreen() {
		
		titlePanel.setVisible(false);
		startPanel.setVisible(false);
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea("This is the main text area.");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(startButtonFont);
		//if text is too long
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		
		//sets up choice buttons for second game screen
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		con.add(choiceButtonPanel);
		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.gray);
		choice1.setFont(startButtonFont);
		choiceButtonPanel.add(choice1);
		
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.gray);
		choice2.setFont(startButtonFont);
		choiceButtonPanel.add(choice2);
		
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.gray);
		choice3.setFont(startButtonFont);
		choiceButtonPanel.add(choice3);
		
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.gray);
		choice4.setFont(startButtonFont);
		choiceButtonPanel.add(choice4);
		
		
	}
	
	public class titleScreenHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
			createGameScreen();
			
			
			
		}
	}

}
