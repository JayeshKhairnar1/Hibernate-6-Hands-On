
import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mypack.User;

public class RegisterServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Session session;
	private SessionFactory factory;

	@Override
	public void init() throws ServletException {
		super.init();
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		factory = cfg.buildSessionFactory();
		session = factory.openSession();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		Transaction tr = session.beginTransaction();
		User user = new User();
		user.setName(name);
		user.setAddress(address);
		user.setEmail(email);
		user.setLogin(login);
		user.setPassword(password);

		session.persist(user);
		tr.commit();
		factory.close();
		session.close();
		PrintWriter pw = response.getWriter();
		pw.println("<h1>Data Saved Successfully</h1>");
		pw.println("<a href='Home.html'>Back to Home</a>");

	}

}
