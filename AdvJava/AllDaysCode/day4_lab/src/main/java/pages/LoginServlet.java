package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImpl;
import pojos.User;

import static utils.DBUtils.*;

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
			else // login success --

			{
				//1. create a cookie to hold validated user details
				//javax.servlet.http.Cookie(String name,String value)
				Cookie c1=new Cookie("user_details", user.toString());//created in server side heap
				//2. Add the cookie to the resp header
				//API of HttpServletResponse
				//public void addCookie(Cookie c)
				response.addCookie(c1);//added in resp hdr			
				// auto navigate the clnt to topics page : in the NEXT request
				// coming from clnt browser
				// API of HttpServletResponse
				// public void sendRedirect(String redirectLocationURL) throws IOExc
				// pw.print("<h4> Successful Login : sending from login page .....</h4>");
				// pw.flush();//WC throws IllegalStateExc --can not call sendRedirect after
				// committing the resp !!!!!!!!!!!!
				response.sendRedirect("topics");
				//WC sends temp redirect resp
				//SC 302 | headers Location : topics , Set-Cookie : user_details : user details | body : EMPTY
			}

		} catch (Exception e) {
			throw new ServletException("err in do-post of " + getClass(), e);
		}
	}

}
