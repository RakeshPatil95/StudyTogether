package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TopicsServlet
 */
@WebServlet("/topics")
public class TopicsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		System.out.println("create topic dao instance");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("clean up topic dao instance");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// generate HTML form dynamically : to show avlable topics
		System.out.println("in do-get of " + getClass());
		// set cont type
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			pw.print("<h4> In Topics Page : </h4>");
			// get user details from cookie
			// API of HttpServletRequest
			// public Cookie[] getCookies()
			Cookie[] cookies = request.getCookies();
			if (cookies != null) // cookies are avlable
			{
				for (Cookie c : cookies)
					if (c.getName().equals("user_details")) {
						// display validated user details
						pw.print("<h5>  User Details  retrieved from a cookie " + c.getValue());
						break;
					}
			} else
				pw.print("<h5> NO Cookies : Session Tracking Failed!!!!!!!!!!!!!!!</h5>");

		}
	}

}
