package mypack;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

public class PersonTest {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		/*
		 * //Adding data to DB: Transaction tr=session.beginTransaction();
		 * 
		 * Person p1=new Person("Abc",20); Person p2=new Person("Xyz",33); Person p3=new
		 * Person("Pqr",21); session.persist(p1); session.persist(p2);
		 * session.persist(p3);
		 * 
		 * 
		 * tr.commit();
		 * 
		 * 
		 * Query<?> query=session.createQuery("from Person",Person.class);
		 * System.out.println("After calling createQuery method"); List<?>
		 * mylist1=(List<?>) query.list();
		 * System.out.println("After calling list method");
		 * 
		 * System.out.println(mylist1); factory.close();
		 */

		// Retrieving from DB:
		/*
		 * Query<?> query = session.createQuery("from Person", Person.class); List<?>
		 * mylist1 = (List<?>) query.list();
		 * 
		 * System.out.println(mylist1);
		 * 
		 * SelectionQuery<?> query1 =
		 * session.createSelectionQuery("select c.name from Person c"); List<?> mylist2
		 * = (List<?>) query1.list();
		 * 
		 * System.out.println(mylist2); SelectionQuery<?> query2 =
		 * session.createSelectionQuery("select c.name,c.age from Person c"); List<?>
		 * mylist3 = (List<?>) query2.list();
		 * 
		 * for (int i = 0; i < mylist3.size(); i++) { Object str[] = (Object[])
		 * mylist3.get(i); for (int j = 0; j < str.length; j++) {
		 * System.out.print(str[j] + "\t"); } System.out.println();
		 * 
		 * }
		 * 
		 * System.out.println("Done with Person");
		 */
//Update On DB:

		Transaction tr = null;
		Query<?> query = session.createQuery("from Person", Person.class);
		List<?> mylist1 = query.list();

		System.out.println(mylist1);
		tr = session.beginTransaction();
		MutationQuery query1 = session.createMutationQuery("update Person p set p.name='Amar'");
		int k = query1.executeUpdate();
		tr.commit();

		new Scanner(System.in).next();
		System.out.println("Records updated\t" + k);
		session.close();
		session = factory.openSession();
		query = session.createQuery("from Person", Person.class);
		mylist1 = query.list();

		System.out.println(mylist1);
		tr = session.beginTransaction();
		MutationQuery query2 = session.createMutationQuery("update Person p set p.name=:str");
		query2.setParameter("str", "vishal");
		k = query2.executeUpdate();
		tr.commit();
		new Scanner(System.in).next();
		System.out.println("Records updated\t" + k);
		session.close();
		session = factory.openSession();
		query = session.createQuery("from Person", Person.class);
		mylist1 = query.list();
		System.out.println(mylist1);

		tr = session.beginTransaction();
		MutationQuery query3 = session.createMutationQuery("update Person p set p.name=:str1 where p.age > :j");
		query3.setParameter("str1", "varun");
		query3.setParameter("j", 30);
		k = query3.executeUpdate();
		tr.commit();
		System.out.println("Records updated\t" + k);
		session.close();
		System.out.println("Done with Person");
		factory.close();

		
	}
}
