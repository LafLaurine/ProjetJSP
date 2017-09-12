import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Patron extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		response.setContentType("text/html");
		response.setCharacterEncoding( "UTF-8" );
		PrintWriter out = response.getWriter();
		String ch = request.getParameter("ch");
		String patron = request.getParameter("patron");
		if(ch!=null && patron!=null)
			{	
				int index = new Integer(ch.indexOf(patron));
				String s = String.valueOf(index);
				request.setAttribute("index",s);
			}
		
	this.getServletContext().getRequestDispatcher("/patron.jsp").forward( request, response );
	}
}
