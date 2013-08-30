/**
 * Reference: http://www.mkyong.com/java/how-to-detect-os-in-java-systemgetpropertyosname/
 */
package com.gs.test.os;

public class TestOperationSystem {

	private static String osName = System.getProperty("os.name").toLowerCase();

	public static void main(String[] args) {
		// Gets Operation System Information
		// getOS();

		// System.out.println(System.getProperties());
		getSysProperies();
	}

	/*
	 * Get System Properties
	 */
	public static void getSysProperies() {
		getSysProperty("java.class.path");
		getSysProperty("java.class.version");
		getSysProperty("java.home");
		getSysProperty("java.vendor");
		getSysProperty("java.vendor.url");
		getSysProperty("java.version");

		getSysProperty("os.arch");
		getSysProperty("os.name");
		getSysProperty("file.separator");
		getSysProperty("path.separator");
		getSysProperty("line.separator");
		getSysProperty("user.dir");
		getSysProperty("user.home");
		getSysProperty("user.name");
		getSysProperty("user.language");
		getSysProperty("user.country");
	}

	/*
	 * Get System Property
	 */
	public static void getSysProperty(String p_proName) {
		String name = p_proName + ":";
		int len = name.length();
		if (len < 8) {
			name = name + "\t\t\t";
		} else if (len < 16) {
			name = name + "\t\t";
		} else if (len < 24) {
			name = name + "\t";
		} else {
		}

		String value = System.getProperty(p_proName).replace("\r\n", "\\r\\n");
		System.out.println(name + value);
	}

	public static void getOS() {
		System.out.println("OS Name:\t" + osName);
		System.out.println("OS version:\t" + System.getProperty("os.version"));
		System.out.println("OS arch:\t" + System.getProperty("os.arch"));

		if (isWindows()) {
			System.out.println("This is Windows");
		} else if (isMac()) {
			System.out.println("This is Mac");
		} else if (isUnix()) {
			System.out.println("This is Unix or Linux");
		} else {
			System.out.println("Your OS is not support!!");
		}
	}

	public static boolean isWindows() {
		// windows
		return (osName.indexOf("win") >= 0);
	}

	public static boolean isMac() {
		// Mac
		return (osName.indexOf("mac") >= 0);
	}

	public static boolean isUnix() {
		// linux or unix
		return (osName.indexOf("nix") >= 0 || osName.indexOf("nux") >= 0);
	}
}
