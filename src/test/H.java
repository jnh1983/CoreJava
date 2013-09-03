package test;

import java.util.Calendar;

public class H {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "Hello123";
		System.out.println(str + "\t" + Calendar.getInstance().getTime());
		System.out.println(System.getProperty("os.name").toLowerCase());
		System.out.println(str.hashCode());

	}

}
