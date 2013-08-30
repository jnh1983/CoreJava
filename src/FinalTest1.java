public class FinalTest1 {
	private static final Circle1 wheel = new Circle1(5.0);

	public static void main(String args[]) {
		System.out.println("Radius of wheel is " + wheel.radius());
		wheel.setRadius(7.4);
		System.out.println("Radius of wheel is now " + wheel.radius());
	}
}

class Circle1 {
	private double rad;

	public Circle1(double r) {
		rad = r;
	}

	public void setRadius(double r) {
		rad = r;
	}

	public double radius() {
		return rad;
	}
}
