package com.servlet.finalAssessment;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//@WebServlet("/SignIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SignIn() {
        super();
         }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		ArrayList<String> a=new ArrayList<String>();
		HttpSession session=request.getSession();
		String name=request.getParameter("username");
		session.setAttribute("user", name);
		out.println("<html><head><title>SignIn Page</title><style>" + 
				"body {" + 
				"  background-image: url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS7ckxLOooJJb4tZi_AGFflKx6PFw2evGgsWw&usqp=CAU');" + 
				"  background-repeat: no-repeat;" + 
				"  background-attachment: fixed;" + 
				"  background-size: 100% 100%;" + 
				"}</style></head><body>");
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employees","root","shashwati");
			//out.print("driver loaded");
			Statement st=con.createStatement();
			String query="select * from EMPLOYEE";
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				a.add(rs.getString("username"));
			}
			if(a.contains(name)) {
				request.getRequestDispatcher("NewFile.jsp").forward(request, response);  
			}
			else {
				out.println("invalid user, enter valid credentials !!!");
				request.getRequestDispatcher("SignIn.html").include(request, response);  
				//out.println("invalid user, enter valid credentials !!!");
			}
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	
		/*PrintWriter out=response.getWriter();
		out.println("<html><head><title>SignIn Page</title><style>\r\n" + 
				"body {\r\n" + 
				"  background-image: url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS7ckxLOooJJb4tZi_AGFflKx6PFw2evGgsWw&usqp=CAU');\r\n" + 
				"  background-repeat: no-repeat;\r\n" + 
				"  background-attachment: fixed;\r\n" + 
				"  background-size: 100% 100%;\r\n" + 
				"}</style></head><body>");
		String name,pwd;
		name=request.getParameter("name");
		pwd=request.getParameter("password");
		if(name.equals("snnp") && pwd.equals("snnp")) {
			out.println("User verified!!");
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");//com.mysql.cj.jdbc.Driver
			java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","shashwati");	
			java.sql.Statement st=con.createStatement();
			String q="Insert into Employee";
			ResultSet rs=st.executeQuery(q);
			while(rs.next())
			{
					out.println("<tr>");
					out.println("<th>"+rs.getString("id")+"</th>");
					out.println("<th>"+rs.getString("fname")+"</th>");
					out.println("<th>"+rs.getString("lname")+"</th>");
					out.println("<th>"+rs.getString("phone")+"</th>");
					out.println("<th>"+rs.getString("email")+"</th>");
					out.println("<th>"+rs.getString("designation")+"</th>");
					out.println("<th>"+rs.getString("address")+"</th>");
					out.println("<th>"+rs.getString("skill")+"</th>");
					out.println("<th>"+rs.getString("salary")+"</th>");
					out.println("</tr>");					
			}
			}
			catch(Exception e)
			{
			e.printStackTrace();
			}
			}
		else
		{
			out.println("Verification Failed!!");
			RequestDispatcher rd;
			rd=request.getRequestDispatcher("Index.jsp");
			rd.include(request, response);
		}
				
		out.println("</body></html>");
	}*/
	}
}
