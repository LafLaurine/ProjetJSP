import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Arrays;

public class Tri extends HttpServlet{

	//initialisation du tableau
	private static int[] init(int n)
	{
		int tab[] = new int[10];

		for(int i=0;i<tab.length;i++)
			tab[i] = (int) (Math.random()*101);

		return tab;
	}
	
	//Permutation
	private static void swap(int tab[],int i, int j)
	{
		int temp = tab[i];
		tab[i]=tab[j];
		tab[j]=temp;
	}
	
public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
{
			response.setContentType("text/html");
			response.setCharacterEncoding( "UTF-8" );
			PrintWriter out = response.getWriter();
			
			int [] tab = init(10);

			String tableau = Arrays.toString(tab);
			request.setAttribute("tab",tableau);


			for(int i=tab.length-1;i>=1;i--)
			{
				for(int j=0;j<i-1;j++)
				{
					if(tab[j+1] < tab[j])
					swap(tab,j+1,j);
					
				}
			}
			tableau = Arrays.toString(tab);
			request.setAttribute("tabTrie",tableau);
				
		this.getServletContext().getRequestDispatcher("/tri.jsp").forward(request, response);
}
}

