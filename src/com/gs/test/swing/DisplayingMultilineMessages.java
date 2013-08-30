package com.gs.test.swing;

import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class DisplayingMultilineMessages {

	public static void main(String[] a) {

		String msg = "<html>this is a really long message<br>this is a really long message this is a really long message this is a really long message this is a really long message this is a really long message this is a really long message";
		String title = "TM Import";
		int msgType = JOptionPane.INFORMATION_MESSAGE;
		
		/*
		JOptionPane optionPane = new NarrowOptionPane();
		optionPane.setMessage(msg);
		optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
		JDialog dialog = optionPane.createDialog(null, "Width 100");
		dialog.setVisible(true);
		*/
		
		displayMultilineMessages(msg,title,msgType);
	}
	
	public static void displayMultilineMessages(String p_msg, String p_title, int p_msgType){
		JOptionPane optionPane = new NarrowOptionPane();
		optionPane.setMessage(p_msg);
		optionPane.setMessageType(p_msgType);
		JDialog dialog = optionPane.createDialog(null, p_title);
		dialog.setVisible(true);
	}
}

class NarrowOptionPane extends JOptionPane {

	NarrowOptionPane() {
	}

	public int getMaxCharactersPerLineCount() {
		return 50;
	}
}