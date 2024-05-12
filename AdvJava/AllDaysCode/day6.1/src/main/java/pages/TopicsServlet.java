package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TopicDaoImpl;
import pojos.Topic;
import pojos.User;

/**
 * Servlet implementation class TopicsServlet
 */
@WebServlet("/topics")
public class TopicsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TopicDaoImpl topicDao;

	/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		try {
			topicDao = new TopicDaoImpl();
		} catch (Exception e) {
			// how to inform WC that init has failed ? --throw ServletExc wrapping a mesg n
			// root cause
			throw new ServletException("err in init of " + getClass(), e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			topicDao.cleanUp();
		} catch (Exception e) {
			throw new RuntimeException("err in destroy of " + getClass(), e);
		}
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in do-post of "+getClass());
		doGet(req, resp);		
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
			
			//1.get user details from request scoped attribute map 
			User user=(User) request.getAttribute("user_details");
			if(user != null) {			
						// display validated user details
						pw.print("<h5>  User Details  retrieved from a request " + user+"</h5>");
						pw.print("<h5>  UserEmail " + request.getParameter("em")+"</h5>");
						// dyn form generation
						pw.print("<form action='tutorials'>");
						// <input type='radio' name='topic_id' value='actual topic id '/>lable : topic name
						for (Topic t : topicDao.getAllTopics())
							pw.print("<input type='radio' name='topic_id' value='" + t.getTopicId() + "'/>"
									+ t.getTopicName() + "<br/>");
						pw.print("<input type='submit' value='Choose Topic'/>");
						pw.print("</form>");
						
					
			} else
				pw.print("<h5> Request Dispatching Failed!!!!!!!!!!!!!!!</h5>");

		} catch (Exception e) {
			throw new ServletException("err in do-get of "+getClass(), e);
		}
	}

}
