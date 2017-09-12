import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Arrays;

public class Barchart extends HttpServlet
{
	
	//Initialisation du tableau
	private int[] tabTemperature;
	
	private void initAleatoire()
	{
		for (int i = 0; i < tabTemperature.length; i++)
		{
			this.tabTemperature[i] = (int) (Math.random()*40 + -10);
		}
	}
	
	//Calcul du minimum
	public int minimum() {
		
		int min = this.tabTemperature[0];
	
	 for (int m = 0; m < this.tabTemperature.length; m++) 
		{
			if (min > this.tabTemperature[m]) 
			{
				min = this.tabTemperature[m];
			}	
		}
		return min;
	}
	
	//Calcul du maximum
	public int maximum() {
		
		int max = this.tabTemperature[0];
	
	 for (int m = 0; m < this.tabTemperature.length; m++) 
		{
			if (max < this.tabTemperature[m]) 
			{
				max = this.tabTemperature[m];
			}	
		}
		return max;
	}
	
	//Calcul de la moyenne
	public int moyenne() {
		
		int moy = this.tabTemperature[0];
	
		for (int m = 0; m <this.tabTemperature.length; m++) 
		{
			moy+=this.tabTemperature[m];
		}			
		moy=(int)moy/(this.tabTemperature.length);
		return moy;
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		response.setContentType("text/html");
		response.setCharacterEncoding( "UTF-8" );
		PrintWriter out = response.getWriter();
		this.tabTemperature = new int [31];
		this.initAleatoire();
		String msg = "";
		for(int i=1;i<this.tabTemperature.length;i++)
			msg+="["+i+":"+this.tabTemperature[i]+"]";
		request.setAttribute("tab",msg);
		String min = ""+this.minimum();
		request.setAttribute("min",min);
		String max = ""+this.maximum();
		request.setAttribute("max",max);
		String moy = ""+this.moyenne();
		request.setAttribute("moy",moy);

		this.getServletContext().getRequestDispatcher("/barchart.jsp").forward( request, response );
	
	
	
	}
}
