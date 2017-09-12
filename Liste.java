import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Liste extends HttpServlet{
	
	//Cherche le dernier élément de la liste
	public static Integer dernierElt(ArrayList<Integer>l1)
	{
		if (l1!=null && !l1.isEmpty())
		{
			int dernier = l1.get(l1.size()-1);
			
			return dernier;
		}
		
		return null;
	}
	
	//Inverse la liste
	public static ArrayList<Integer> inverse(ArrayList<Integer>l1)
	{
		ArrayList<Integer> l2 = new ArrayList <Integer>();

		for(int i=l1.size()-1; i>=0;i--)
		{
			int inv = l1.get(i);
			l2.add(inv);
		}
		return l2;
	}
	
	//Cherche si un élément est présent dans la liste ou non
	public static int presenceNb(ArrayList<Integer>l1, int n)
	{
		boolean present = false;
		int position = -1;
		
		int i =0;
		
		while(!present && i<l1.size())
		{
			if(l1.get(i).intValue()==n)
			{
				position = i;
				present=true;
			}
			
			i++;
		}
		
		return position;
	}
	
	//Donne la position de l'élément que l'on cherche s'il est présent
	public static Integer elementPos(ArrayList<Integer>l1, int pos) 
	{
		if(pos<0 || pos>=l1.size())
			return null;
		
		return l1.get(pos);
	}
	
	//Supprime l'élément demandé
	public static ArrayList<Integer> supprimeElement(ArrayList<Integer>l1,int posi)
	{
		if(posi<0 || posi>=l1.size())
			return l1;
		
		@SuppressWarnings("unchecked") //permet d'autorisé une exception
		ArrayList<Integer> l2 = (ArrayList<Integer>) l1.clone();
		
		l2.remove(posi);
		
		return l2;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		response.setContentType("text/html");
		response.setCharacterEncoding( "UTF-8" );
		PrintWriter out = response.getWriter();
		ArrayList<Integer> l1 = new ArrayList <Integer>();
		
		//Initialistation de la liste
		for (int i =0;i<10;i++)
		{
			l1.add((int)(Math.random()*100));
		}
		
		String liste1 = l1.toString();
		request.setAttribute("liste1",liste1);
		String dernierElt = String.valueOf(dernierElt(l1));
		request.setAttribute("dernierElt",dernierElt);
		String inverse = inverse(l1).toString();
		request.setAttribute("inverse",inverse);
		String n = request.getParameter("n");
		if (n!=null){
		int z = Integer.parseInt(n);
		String nb = String.valueOf(presenceNb(l1,z));
		request.setAttribute("nb",nb);
		}
		
		String pos = request.getParameter("pos");
		if (pos!=null){
		int poz = Integer.parseInt(pos);
		String poos = String.valueOf(elementPos(l1,poz));
		request.setAttribute("position",poos);
		}
		
		String remove = request.getParameter("eltRmv");
		if (remove!=null){
		int rem = Integer.parseInt(remove);
		String listeRemove = supprimeElement(l1,rem).toString();
		request.setAttribute("nbRmv",listeRemove);
		}
	
	this.getServletContext().getRequestDispatcher("/liste.jsp").forward( request, response );
	}
}
