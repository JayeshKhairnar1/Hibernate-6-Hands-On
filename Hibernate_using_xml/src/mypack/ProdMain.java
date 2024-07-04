package mypack;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.*;
import java.util.*;

public class ProdMain {
	public static void main(String[] args) {
		/*
							 * Configuration cfg=new Configuration(); cfg.configure("hibernate.cfg.xml");
							 * SessionFactory factory=cfg.buildSessionFactory(); Session
							 * session=factory.openSession(); Transaction tr=session.beginTransaction();
							 * Product p=new Product();
							 * 
							 * p.setName("soap"); p.setQty(75); p.setPrice(90);
							 * 
							 * //session.save(p); deprecated in Hibernate 6 session.persist(p); tr.commit();
							 * 
							 * Scanner sc=new Scanner(System.in); System.out.println(sc.nextInt()); // Halting;
							 *  change the row in db from outside
							 * System.out.println("Before refresh\t"+p); session.refresh(p);
							 * System.out.println("After refresh\t"+p); factory.close();
							 */

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		Merge_Product p = new Merge_Product();
		p.setName("soap");
		p.setQty(75);
		p.setPrice(90);
		session.persist(p);
		tr.commit();
		session.close();
		System.out.println("before changing qty\t" + p);
		p.setQty(150); // detached
		System.out.println("after changing qty\t" + p);
		Scanner sc = new Scanner(System.in);
		System.out.println(sc.nextInt()); // Halting Program here
		session = factory.openSession();
		tr = session.beginTransaction();

		session.merge(p);
		tr.commit();
		session.close();
		factory.close();

	}

}