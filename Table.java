import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Table extends HttpServlet
{

	public static String addition(int n)
	{
		String str = "";
		for(int i=0;i<=10;i++)
		{
			str+= (i + " + " + n + " = " + (i+n + "\n")); //ajout de la table dans une chaîne
		}
		return str;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
			response.setContentType("text/html");
			response.setCharacterEncoding( "UTF-8" );
			PrintWriter out = response.getWriter();
			if(request.getParameter("n")!=null)
			{
				int paramN = new Integer(request.getParameter("n")).intValue();
				String tab = addition(paramN);
				request.setAttribute("tab",tab);
			}
			this.getServletContext().getRequestDispatcher("/table.jsp").forward( request, response );
			
	}

}
