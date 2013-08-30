package com.test.reflect;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import test.Girl;
import test.GirlTestHelper;

public class myTestStudent
{
    public static void main(String[] args){
	testConstructor();
//	testPrivateField(500);
//        testPrivateMethod();
//        testUnicode();
//        testCharsetWhiteSpace();
    }
    
    public static void testCharsetWhiteSpace(){
        char ch = 'a';
        System.out.println(ch + "\t" +Character.isWhitespace(ch));
        
        ch = '\n';
        System.out.println(ch + "\t" +Character.isWhitespace(ch));
        
        ch = '\r';
        System.out.println(ch + "\t" +Character.isWhitespace(ch));
        
        ch = '\t';
        System.out.println(ch + "\t" +Character.isWhitespace(ch));
        
        ch = '\b';
        System.out.println(ch + "\t" +Character.isWhitespace(ch));
    }

    public static void testConstructor(){
	Girl girl = null;
//	girl = new Girl(0, "");
	try {
	    Class<?> objectClass = Class.forName("test.Girl");
	    girl = (Girl) objectClass.newInstance();
	} catch (ClassNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (InstantiationException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IllegalAccessException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
//	girl = GirlTestHelper.getInstance(5, "Instance");
	girl.setName("LL");
	System.out.println(girl.toString());
    }
    
    public static void testPrivateField(int p_value) {
	Student stu = new Student();
	System.out.println(stu.getId());
	try {
	    ClassUtil.updateField(stu, "id", p_value);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	System.out.println(stu.getId());
    }

    public static void testPrivateMethod()
    {
        Student stu = new Student();
        // stu = new Student(1000, "David");
        ClassUtil.testMethod(stu, "print", "Hello world", ", Welcome!");
    }
    
    public static void testUnicode(){
        String[][] strArr = {
                {"\u0061", "\u0062", "\u0063"},
                {"\u000E", "\u0262", "\u0263", "\u0264", "\u0265"}
                };

        PrintStream out = null;
        try
        {
            out = new PrintStream(System.out, true, "UTF-8");
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }

        for (int i = 0; i < strArr.length; i++)
        {
            for (int j = 0; j < strArr[i].length; j++)
            {
                out.print(strArr[i][j] + ", ");
//                System.out.print(strArr[i][j] + ", ");
//                System.out.print(unicodeToString(strArr[i][j]) + ", ");
            }
            System.out.println();
        }
    }
    
    public static String unicodeToString(String p_str){
        return unicodeToString(p_str, "UTF-8");
    }
    
    public static String unicodeToString(String p_str, String p_encoding)
    {
        try
        {
            byte[] arr = p_str.getBytes(p_encoding);
            return new String(arr, p_encoding);
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        return p_str;

    }
}
