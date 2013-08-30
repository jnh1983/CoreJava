package com.test.hibernate.helper;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.test.hibernate.Room;

public class Test {

    Test (){}
    /**
     * @param args
     */
    public static void main(String[] args) {
	
	Test t = new Test();
	String hql = "FROM Room";
	//List list = HibernateUtil.search(hql);
	//System.out.println(list.size() + "\t" + list);
    }
    
    public static SessionFactory sessionFactory;//数据存储源
    static {
        try {
            Configuration config = new Configuration().configure();
            sessionFactory = config.buildSessionFactory();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
