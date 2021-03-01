package com.servlet.finalAssessment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Logout() {
        super();
         }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>Error Page</title><style>\r\n" + 
				"body {\r\n" + 
				"  background-image: url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS7ckxLOooJJb4tZi_AGFflKx6PFw2evGgsWw&usqp=CAU');\r\n" + 
				"  background-repeat: no-repeat;\r\n" + 
				"  background-attachment: fixed;\r\n" + 
				"  background-size: 100% 100%;\r\n" + 
				"}</style></head><body>");
		out.println("<br><br><h1 style ='align:center' 'color:red'>Thank you for visiting Supreme "+request.getParameter("fname")+"!!</h1>");
		out.println("<br><br><br><a href=SignIn?name=\"+name+\">Login</a>\"");
		out.println("</body></html>");
	}

}
