package com.gs.test.applet;

import java.applet.Applet;
import java.awt.Graphics;

public class HelloWorld extends Applet {
	
	int i;

	public void paint(Graphics g) {
		i = 10;
		g.drawString("Hello world!", 25, 25);
		System.out.println("Print...");
	}
}
