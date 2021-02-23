package Tank;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		drawCanvas();

	}

	static void drawCanvas() {
		//To be increased to add lives and score board

		final int gameWidth = 1095;            //Game Screen size (Width)
		final int gameHeight = 759;            //Game Screen size (Height)
		final Color bgColor = Color.darkGray;   //Background of color
		JFrame obj = new JFrame();





		Gameplay gameplay = new Gameplay();
		obj.setBounds(10, 10, gameWidth, gameHeight);
		obj.setBackground(bgColor);
		obj.setLocationRelativeTo(null); // To centralise game screen
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(gameplay);

		
	
		

	}



}