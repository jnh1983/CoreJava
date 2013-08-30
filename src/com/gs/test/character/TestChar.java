package com.gs.test.character;

public class TestChar {

    public static void main(String[] args) {
//	testCharAndInt();
	
	char c = '\uFFFF';
	System.out.println("A"+c+"A");
    }

    public static void testCharAndInt() {
	char ch = 'a';

	log(ch);
	ch = '\\';
	log(ch);
	ch = ' ';
	log(ch);
	ch = '\t';
	log(ch);
	ch = '\r';
	log(ch);
	ch = '\n';
	log(ch);
	ch = '\f';
	log(ch);

	System.out.println("************");
	log(97);
	log(92);
	log(32);
	log(9);
	log(13);
	log(10);
	log(12);
    }

    public static void log(char ch) {
	String str = "[" + ch + "]";
	if (ch == 10 || ch == 13) {
	    str = "[Next Line \\r\\n]";
	}
	if (str.length() < 8) {
	    if (str.contains("\t")) {
		str = str + "\t";
	    } else {
		str = str + "\t\t";
	    }
	}
	System.out.println(str + "\t" + (int) ch);
    }

    public static void log(int i) {
	char ch = (char) i;
	log(ch);
    }
}
