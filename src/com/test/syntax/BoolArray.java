package com.test.syntax;

public class BoolArray {

    boolean[] b = new boolean[3];
    int count = 0;

    void set(boolean[] x, int i) {
	x[i] = true;
	++count;
    }

    public static void main(String[] args) {
	BoolArray ba = new BoolArray();
	ba.set(ba.b, 0);
	ba.set(ba.b, 2);
	ba.test();
	
	testIf();
    }

    void test() {
	if (b[0] && b[1] | b[2])
	    count++;
	if (b[1] && b[(++count - 2)])
	    count += 7;
	System.out.println("count = " + count);
    }
    
    public static void testIf(){
	int i = 0;
	if(true && (++i)>-1){
	    System.out.println("First:\tThe value of i is "+i);
	}
	
	if(false && (++i)>-1){
	    System.out.println("Second:\tThe value of i is "+i);
	}
	
	System.out.println("Last:\tThe value of i is "+i);
    }

}
