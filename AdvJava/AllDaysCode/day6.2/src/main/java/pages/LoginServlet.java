package pages;

import static utils.DBUtils.closeConnection;
import static utils.DBUtils.openConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDaoImpl;
import pojos.User;

/**
 * Servlet implementation class LoginServlet
 */
//Entry in request mapping Key /validate Value : pages.LoginServlet
@WebServlet(value = "/validate", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;

	/**
	 * @see Servlet#init()
	 */
	@Override
	public void init() throws ServletException {
		try {
			openConnection();
			userDao = new UserDaoImpl();
		} catch (Exception e) {
			// System.out.println(+" err "+e);
			// ServletException(String mesg, Throwable rootCause)
			throw new ServletException("err in init of " + getClass(), e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	@Override
	public void destroy() {
		try {
			userDao.cleanUp();
			closeConnection();
		} catch (Exception e) {
			// System.out.println("err in destroy of "+getClass()+" err "+e); reco.
			throw new RuntimeException("err in destroy " + getClass(), e);
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in do-post of " + getClass());
		// set cont type
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			String email = request.getParameter("em");
			String password = request.getParameter("pass");
			// invoke user dao's method for authentication
			User user = userDao.authenticateUser(email, password);
			if (user == null) // => failed login --- send retry link ---Client Pull I
				pw.print("<h4>Invalid Login , Please <a href='login.html'>Retry</a></h4>");
			else // login success --navigate the clnt to the next page(Topics page) in the SAME
					// request

			{
				pw.print("<h5>from login page</h5>");
				pw.flush();
				// 1. save validated user details under request scope
				request.setAttribute("user_details", user);// request scoped attrs are stored in a SEPARATE map other
															// than session scoped attr map
				// 2. Create RequestDispatcher obj --to wrap the next page/resource
				RequestDispatcher rd = request.getRequestDispatcher("topics");
				//3 . Forward the clnt
				rd.include(request, response);//WC --suspends this method exec ---invokes 
				//TopicServlet's doPost --after it's exec is over --control rets back n continues....
				System.out.println("control back in login page");
				pw.print("<h5>dyn contents post include....</h5>");
			}

		} catch (Exception e) {
			throw new ServletException("err in do-post of " + getClass(), e);
		}
	}

}
