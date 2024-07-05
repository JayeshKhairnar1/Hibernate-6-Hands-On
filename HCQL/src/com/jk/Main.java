package com.jk;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import jakarta.persistence.criteria.CriteriaQuery;

public class Main {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();

		Employee e1 = new Employee();
		e1.setName("abc");
		e1.setDesig("accountant");
		e1.setSalary(25000);

		Employee e2 = new Employee();
		e2.setName("xyz");
		e2.setDesig("manager");
		e2.setSalary(35000);

		Employee e3 = new Employee();
		e3.setName("pqr");
		e3.setDesig("clerk");
		e3.setSalary(15000);

		Employee e4 = new Employee();
		e4.setName("lmn");
		e4.setDesig("Soft_Engineer");
		e4.setSalary(45000);

		session.persist(e1);
		session.persist(e2);
		session.persist(e3);
		session.persist(e4);
		tr.commit();

		HibernateCriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class); // here "Employee" is result type
		criteria.from(Employee.class); // here "Employee" is an Entity for which query will work
		Query<?> q = session.createQuery(criteria);
		System.out.println("after createQuery method");
		List<?> results = q.getResultList(); // here query gets fired in the database
		System.out.println("after getResultList method");
		System.out.println(results);

	}
}
