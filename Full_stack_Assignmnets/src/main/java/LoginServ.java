
import java.io.IOException;

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
 * Servlet implementation class LoginServ
 */
public class LoginServ extends HttpServlet {
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
		String login = request.getParameter("login");
        String password = request.getParameter("password");
        String hql = "FROM User WHERE login = :login AND password = :password";
        Query<User> query = session.createQuery(hql, User.class);
        query.setParameter("login", login);
        query.setParameter("password", password);
        User user = query.uniqueResult();
        
     

  
        if (user != null) {
            response.sendRedirect("Success.html");
        } else {
            response.sendRedirect("Fail.html");
        }

	}
}
