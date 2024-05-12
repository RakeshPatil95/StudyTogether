package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestEagerServlet
 */
//@WebServlet(value="/hello3",loadOnStartup = 1)
public class TestEagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		System.out.println("in init of "+getClass()+" thread "+Thread.currentThread());
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("in destroy of "+getClass()+" thread "+Thread.currentThread());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in do-get of "+getClass()+" thread "+Thread.currentThread());
		//set cont type
		response.setContentType("text/html");
		//get pw
		try(PrintWriter pw=response.getWriter())
		{
			pw.print("<h4> Resp from eagerly loaded servlet ...."+LocalTime.now()+"</h4>");
		}
	}

}
