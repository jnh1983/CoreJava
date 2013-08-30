package com.gs.test.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class Tester2 extends JPanel {

	private static final long serialVersionUID = 1L;

	public Tester2() {
        JNotWorkingCrap crap = new JNotWorkingCrap();
        add(crap);
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        Tester2 newContentPane = new Tester2();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }


    
    
    public static class JNotWorkingCrap extends JPanel {

    	/** panel with toolbars */
    	private JPanel toolbarPane;
    	/** scroll pane for the toolbar pane */
    	private JScrollPane toolbarSp;
    	/** central panel with the buttons*/
    	private JPanel centralPanel;
    	/** buttons for adding/removing a toolbar */
    	private JButton addToolbarBtn;
    	private JButton removeToolbarBtn;

    	/** counter indicating number of toolbars */
    	private static int toolbarCnt = 0;
    	
    	public JNotWorkingCrap() {
    		initComponents();
    		initLayout();
    	}

    	private void initComponents() {
    		centralPanel = new JPanel();
    		toolbarPane = new JPanel();
    		toolbarSp = new JScrollPane(toolbarPane);
    		
    		addToolbarBtn = new JButton(new AbstractAction("Add toolbar") {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// create a new "toolbar"
					JPanel newToolbar = new JPanel();
					newToolbar.add(new JLabel("Toolbar "+toolbarCnt));
					// with a fixed size
					newToolbar.setPreferredSize(new Dimension(150, 50));
					newToolbar.setMinimumSize(new Dimension(150, 50));
					newToolbar.setMaximumSize(new Dimension(150, 50));
					newToolbar.setSize(new Dimension(150, 50));
					newToolbar.setBorder(BorderFactory.createTitledBorder("Toolbar " + toolbarCnt));
					
					// add the "toolbar" to the toolbar pane
					toolbarPane.add(newToolbar);
					
					// revalidate/repaint
					toolbarPane.revalidate();
		    		revalidate();
		    		revalidate();
		    		
		    		// increment the counter
		    		toolbarCnt++;
				}
			});

    		removeToolbarBtn = new JButton(new AbstractAction("Remove toolbar") {
    			
				@Override
				public void actionPerformed(ActionEvent e) {
					// remove the toolbar from the toolbar pane
					toolbarPane.remove(toolbarPane.getComponentCount()-1);
					
					// revalidate/repaint
					toolbarPane.revalidate();
		    		revalidate();
		    		toolbarPane.repaint();
		    		
		    		// decrement the counter
					toolbarCnt--;
				}
			});
    	}

    	/**
    	 * Lay out the components.
    	 */
    	private void initLayout() {
    		setLayout(new BorderLayout(0, 0));
    		setPreferredSize(new Dimension(600, 300));
    		
    		centralPanel.add(addToolbarBtn);
    		centralPanel.add(removeToolbarBtn);
    		
    		toolbarPane.setLayout(new BoxLayout(toolbarPane, BoxLayout.X_AXIS));
    		toolbarPane.setOpaque(true);
    		toolbarPane.setBackground(Color.BLUE);

    		
    		toolbarSp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    		//toolbarSp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    		toolbarSp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

    		
    		add(toolbarSp, BorderLayout.NORTH);
    		add(centralPanel, BorderLayout.CENTER);
    	}
    }
}
