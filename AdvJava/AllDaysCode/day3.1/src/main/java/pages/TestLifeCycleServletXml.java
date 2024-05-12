package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TestLifeCycleServletXml extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in do-get of "+getClass()+" invoked by "+Thread.currentThread());
		//set response content type
		//API of HttpServletResponse --public void setContentType(String type)
		resp.setContentType("text/html");
		//Open -- char , buffered , o/p stream to send resp from server ----> clnt
		//API of HttpServletResponse --public PrintWriter getWriter() throws IOExc
		try(PrintWriter pw=resp.getWriter())
		{
			//send resp
			pw.print("<h4> Hello from Servlets @ "+LocalDateTime.now()+"</h4>");
		}
		
	}

	@Override
	public void destroy() {
		System.out.println("in destroy of "+getClass()+" invoked by "+Thread.currentThread());
	}

	@Override
	public void init() throws ServletException {
		System.out.println("in init of "+getClass()+" invoked by "+Thread.currentThread());
	}

}
