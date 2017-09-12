import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Stack;

public class InfixToPrefix extends HttpServlet{

	//Renvoie la priorité de calcul de l'opérateur
	private static int getPriorite(char operateur)
	{
		//Plus l'entier est grand, plus l'opérateur est prioritaire
		switch(operateur)
		{
			case '+':
				return 1;
			case '-':
				return 1;
			case '*':
				return 2;
			case '/':
				return 2;
			case '^':
				return 3;
			
			default : 
				return -1;
		}
	}
	
	//Méthode qui permet de convertir la chaîne infixe parenthésée en préfixe	
	public static String convertir(String infix) {
		
		Stack<Character> stack = new Stack<Character>();
		
		String prefix = "";
		
		for(int i=infix.length()-1;i>=0;i--){
			
            char c = infix.charAt(i);
            
            if(c==' ')
            	continue;
            
            else if(Character.isLetter(c) || Character.isDigit(c)) //on vérifie si le caractère est une lettre ou un nombre
	    {
                prefix = ((Character)c).toString() + ' ' + prefix;
            }
            
            else if(c == '('){
                prefix = ((Character)stack.pop()).toString() + ' ' + prefix;
            }
            
            else if(c == ')'){
                continue;
            }
            
            else{
                stack.push(c);
            }
        }
		
		return prefix;
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		response.setContentType("text/html");
		response.setCharacterEncoding( "UTF-8" );
		PrintWriter out = response.getWriter();
		String infix = request.getParameter("infix");
		String prefix = "";
		if (infix!=null) //si la chaîne n'est pas nulle, on convertir la chaîne infixe
	{
		prefix = convertir(infix);
	}
		request.setAttribute("prefix",prefix);
		this.getServletContext().getRequestDispatcher("/infix.jsp").forward( request, response );
	}
	
}
