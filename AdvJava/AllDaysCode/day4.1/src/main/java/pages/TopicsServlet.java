package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
			//send welcome mesg to the clnt : Welcome ...email
			pw.print("<h5> Welcome ...Hello , "+request.getParameter("em"));
			
		}
	}

}
