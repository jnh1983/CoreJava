import java.awt.Graphics;
import java.applet.Applet;

public class HelloWorld extends Applet {
	
	int i;

	public void paint(Graphics g) {
		i = 10;
		g.drawString("Hello world!", 25, 25);
		System.out.println("This is print test...");
	}
}
