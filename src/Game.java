import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game {

	//imports 
	JFrame window;
	Container con;
	JPanel titlePanel;
	
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
		//make window appear on screen
		window.setVisible(true);
		
		
		titlePanel = new JPanel();
		con = window.getContentPane();
		//set bounds and color for starting screen title
		titlePanel.setBounds(100, 100, 600, 150);
		titlePanel.setBackground(Color.blue);
		//container to add text to
		con.add(titlePanel);
	}

}
