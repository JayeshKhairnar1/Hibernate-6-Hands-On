package mypack;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		/*
		 * Employee e1=new Employee(); e1.setName("pqr"); e1.setDesig("clerk");
		 * e1.setSalary(30000);
		 * 
		 * Employee e2=new Employee(); e2.setName("Jayesh"); e2.setDesig("Developer");
		 * e2.setSalary(40000); session.persist(e1); session.persist(e2); tr.commit();
		 * factory.close(); System.out.println("done with employees");
		 */
		/*
		 * session=factory.openSession(); Transaction tr=session.beginTransaction();
		 * Product p=new Product();
		 * 
		 * p.setName("soap"); p.setQty(75); p.setPrice(90);
		 * 
		 * Scanner sc=new Scanner(System.in); System.out.println(sc.nextInt()); //
		 * Halting; change the row in db from outside
		 * System.out.println("Before refresh\t"+p); session.refresh(p);
		 * System.out.println("After refresh\t"+p); factory.close();
		 */
/*
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
*/
		Dirty_Product p=new Dirty_Product();
        p.setName("soap");
        p.setQty(75);
        p.setPrice(90);
    
        session.persist(p);      
        tr.commit(); 
       
        Scanner sc=new Scanner(System.in);
        System.out.println(sc.nextInt()); // go and check in database

        tr=session.beginTransaction();
        p.setPrice(190); // if u change this then only hibernate will fire update query on commit
        tr.commit();
        session.close();
        factory.close();

	}

}