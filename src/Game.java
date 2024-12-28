import java.awt.Color;

import javax.swing.JFrame;

public class Game {

	//imports JFrame window for base of game
	JFrame window;
	
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
		//background color of window
		window.getContentPane().setBackground(Color.black);
		//disable default layout to have a customzied layout
		window.setLayout(null);
		//make window appear on screen
		window.setVisible(true);
	}

}
