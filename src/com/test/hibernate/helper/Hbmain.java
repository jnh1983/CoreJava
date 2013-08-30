package com.test.hibernate.helper;

import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.Iterator;
import java.util.List;

public class Hbmain {

    public static SessionFactory sessionFactory;//数据存储源
    static {
        try {
            Configuration config = new Configuration().configure();
            sessionFactory = config.buildSessionFactory();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
	System.out.println();
    }
}
