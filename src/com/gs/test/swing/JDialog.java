package com.gs.test.swing;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class JDialog extends javax.swing.JDialog {
	private JScrollPane jScrollPaneEast;
	private JPanel jPanelEast;
	private JCheckBox jCheckBox1;
	private JButton jButton1;
	private JButton jButton2;
	private JMenuItem jMenuItem2;
	private JMenuItem jMenuItem1;
	private JMenu jMenu;
	private JScrollPane jScrollPaneEastTop;
	private JScrollPane jScrollPaneWest;

	/**
	* Auto-generated main method to display this JDialog
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				JDialog inst = new JDialog(frame);
				inst.setVisible(true);
			}
		});
	}
	
	public JDialog(JFrame frame) {
		super(frame);
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				jScrollPaneEast = new JScrollPane();
				getContentPane().add(jScrollPaneEast, BorderLayout.EAST);
			}
			{
				jScrollPaneWest = new JScrollPane();
				getContentPane().add(jScrollPaneWest, BorderLayout.WEST);
				jScrollPaneWest.setPreferredSize(new java.awt.Dimension(109, 292));
				{
					jMenu = new JMenu();
					jScrollPaneWest.setViewportView(jMenu);
					jMenu.setText("jMenu1");
					{
						jMenuItem1 = new JMenuItem();
						jMenu.add(jMenuItem1);
						jMenuItem1.setText("jMenuItem1");
					}
					{
						jMenuItem2 = new JMenuItem();
						jMenu.add(jMenuItem2);
						jMenuItem2.setText("jMenuItem2");
					}
				}
			}
			{
				jPanelEast = new JPanel();
				getContentPane().add(jPanelEast, BorderLayout.CENTER);
				jPanelEast.setPreferredSize(new java.awt.Dimension(366, 316));
				{
					jScrollPaneEastTop = new JScrollPane();
					jPanelEast.add(jScrollPaneEastTop);
					jScrollPaneEastTop.setPreferredSize(new java.awt.Dimension(326, 248));
					{
						jCheckBox1 = new JCheckBox();
						jScrollPaneEastTop.setViewportView(jCheckBox1);
						jCheckBox1.setText("job split option show");
						jCheckBox1.setPreferredSize(new java.awt.Dimension(322, 245));
					}
				}
				{
					jButton1 = new JButton();
					jPanelEast.add(jButton1);
					jButton1.setText("jButton1");
					jButton1.setPreferredSize(new java.awt.Dimension(76, 27));
				}
				{
					jButton2 = new JButton();
					jPanelEast.add(jButton2);
					jButton2.setText("jButton2");
				}
			}
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
