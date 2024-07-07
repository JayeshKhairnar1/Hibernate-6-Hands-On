
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mypack.User;

/**
 * Servlet implementation class ViewServ
 */
public class ViewServ extends HttpServlet {
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body><h1>Registered Users</h1>");
		Query<User> query = session.createQuery("FROM User", User.class);
        List<User> users_list = query.list();
        out.println("<table border='1'><tr><th>Name</th><th>Address</th><th>Email</th><th>Login</th></tr>");
        for (User user : users_list) {
            out.println("<tr><td>" + user.getName() + "</td>");
            out.println("<td>" + user.getAddress() + "</td>");
            out.println("<td>" + user.getEmail() + "</td>");
            out.println("<td>" + user.getLogin() + "</td></tr>");
        }
        out.println("</table>");
        out.println("</body></html>");
    }

	}


