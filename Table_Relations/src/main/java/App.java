
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.*;

import many_to_many.Employee;
import many_to_many.Project;
import one_to_many.Phone;
import one_to_many.Student;
import one_to_many_bidirectional.Answer;
import one_to_many_bidirectional.Question;
import one_to_many_delete_cascade.Phone2;
import one_to_many_delete_cascade.Student2;
import one_to_one.Account;
import one_to_one.Company;
import one_to_one_bidirectional.Account_bidirectional;
import one_to_one_bidirectional.Company_bidirectonal;

public class App {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
/*		
 //--------------------One To One--------------------

		 Company comp=new Company();
         Account acc=new Account();
         acc.setBalance(20000);
         comp.setName("capgemini");
         comp.setLocation("mumbai");
         comp.setAcc(acc);
       
         Company comp2=new Company();
         Account acc2=new Account();
         acc2.setBalance(40000);
         comp2.setName("smartstream");
         comp2.setLocation("banglore");
         comp2.setAcc(acc2);
         session.persist(comp);
         session.persist(comp2);
         transaction.commit(); 
         System.out.println("done with company"); 

 //------------------------Bidirectional One to One--------------------

		Company_bidirectonal comp3 = new Company_bidirectonal();
		Account_bidirectional acc3 = new Account_bidirectional();
		acc3.setBalance(20000);
		comp3.setName("capgemini");
		comp3.setLocation("mumbai");
		
		comp3.setAcc(acc3);
		acc3.setCompany(comp3);
		session.persist(comp3);
		transaction.commit();

		System.out.println("done with company");
		System.out.println("from company get account");
		Company_bidirectonal ref1 = session.get(Company_bidirectonal.class, Integer.valueOf(1));
		System.out.println("Company is\t" + ref1.getName());
		System.out.println("Account is\t" + ref1.getAcc().getBalance());

		System.out.println("now from account get company");

		Account_bidirectional ref2 = session.get(Account_bidirectional.class, Integer.valueOf(1));
		System.out.println("Account is\t" + ref2.getBalance());
		System.out.println("Company is\t" + ref2.getCompany().getName());

 //-----------------------one to many----------------------------------------------------

		Student s1 = new Student();
		Phone p1 = new Phone();
		p1.setPhoneNumber("923456789");
		p1.setPhoneType("mobile");
		Phone p2 = new Phone();
		p2.setPhoneNumber("2654321");
		p2.setPhoneType("resd");
		Set<Phone> h = new HashSet<Phone>();
		h.add(p1);
		h.add(p2);
		s1.setStudentName("abc");
		s1.setStudentPhoneNumbers(h);
		session.persist(s1);
		transaction.commit();
		System.out.println("done with student");

//------------------------one to many delete---------------------		
		Student2 st = new Student2();
		Phone2 ph1 = new Phone2();
		ph1.setPhoneNumber("923456789");
		ph1.setPhoneType("mobile");
		Phone2 ph2= new Phone2();
		ph2.setPhoneNumber("2654321");
		ph2.setPhoneType("resd");
		Set<Phone2> phone_set = new HashSet<Phone2>();
		phone_set.add(ph1);
		phone_set.add(ph2);
		st.setStudentName("abc");
		st.setStudentPhoneNumbers(phone_set);
		session.persist(st);
		transaction.commit();
		System.out.println("done with student");
		System.out.println("enter a number");
		new Scanner(System.in).nextInt();
		transaction = session.beginTransaction();
		session.remove(s1);
		transaction.commit();
		System.out.println("done completely");

//-----------------one to many many to one Bidirectional	-------------------------------------
		Question q1=new Question();
		Answer a1=new Answer();
		Answer a2=new Answer();
		Answer a3=new Answer();
		List<Answer>anslist=new ArrayList<>();
		q1.setQuest("What is Cricket");
		a1.setReply("Cricket is one of the sports types");
		a1.setQuestion(q1);
		a2.setReply("Cricket is very interesting");
		a2.setQuestion(q1);
		a3.setReply("Cricket is a religion in India");
		a3.setQuestion(q1);
		anslist.add(a1);
		anslist.add(a2);
		anslist.add(a3);
		q1.setAns(anslist);
		
		session.persist(q1);
		transaction.commit();
		System.out.println("Done with question");
		System.out.println("Let's retrieve the answers from a question");
		
		Question que_ref=session.get(Question.class,1);
		System.out.println("Question is\t"+que_ref.getQuest());
		System.out.println("Answers are ");
		for(Answer k: que_ref.getAns())
		{
			System.out.println(k.getReply());
		}
		System.out.println();
		System.out.println("Let's retrieve the question from the answers");
		Answer ans1=session.get(Answer.class,1);
		System.out.println("Answer\t"+ans1.getReply()+"\t\t\tQuestion\t"+ans1.getQuestion().getQuest());

		Answer ans2=session.get(Answer.class,2);
		System.out.println("Answer\t"+ans2.getReply()+"\t\t\tQuestion\t"+ans2.getQuestion().getQuest());
		
		Answer ans3=session.get(Answer.class,3);
		System.out.println("Answer\t"+ans3.getReply()+"\t\t\tQuestion\t"+ans3.getQuestion().getQuest());

*/
//---------------------------many to many-------------------------------------
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		e1.setEname("Harry");
		e2.setEname("Javed");
		Project proj1 = new Project();
		Project proj2 = new Project();
		proj1.setPname("Emart");
		proj2.setPname("Etour");
		List<Project> projectlist = new ArrayList<Project>();
		List<Employee> employeelist = new ArrayList<Employee>();
		projectlist.add(proj1);
		projectlist.add(proj2);
		employeelist.add(e1);
		employeelist.add(e2);
		 //Harry has been assigned two projects
		e1.setProjects(projectlist);
		e2.setProjects(projectlist);
		 //Etour project has been assigned both the employees
		proj2.setEmployees(employeelist);
		session.persist(e1);
		session.persist(e2);
		session.persist(proj1);
		session.persist(proj2);
		transaction.commit();
		factory.close();
		System.out.println("Done with Many to Many");
	}
}
