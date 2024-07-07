
import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mypack.Dept;

/**
 * Servlet implementation class Search
 */
public class SearchServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Session session;
	private SessionFactory factory;

	@Override
	public void init() throws ServletException {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		factory = cfg.buildSessionFactory();
		session = factory.openSession();
		super.init();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String location = request.getParameter("location");
		String hql = "FROM Dept WHERE loc = :location";
		Query<Dept> query = session.createQuery(hql, Dept.class);
		query.setParameter("location", location);

		List<Dept> depts = query.list();

		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}
