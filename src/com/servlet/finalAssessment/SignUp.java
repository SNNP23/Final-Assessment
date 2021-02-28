package com.servlet.finalAssessment;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String driver;
	String url;
	String user;
	String pwd;
	public void init(ServletConfig config) {
		driver=config.getInitParameter("driver");
		url=config.getInitParameter("url");
		user=config.getInitParameter("user");
		pwd=config.getInitParameter("pwd");
	}
    public SignUp() 
    {
        super();       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String username,password,fname,lname,email,designation,address,gender,skillset;
		String id,phone,salary;
		username=request.getParameter("username");
		password=request.getParameter("password");
		id=request.getParameter("id");
		//id=Integer.parseInt(request.getParameter("id"));
		fname=request.getParameter("fname");
		lname=request.getParameter("lname");
		phone=request.getParameter("phone");
		email=request.getParameter("email");
		designation=request.getParameter("designation");
		address=request.getParameter("address");
		gender=request.getParameter("gender");
		skillset=request.getParameter("skillset");
		salary=request.getParameter("salary");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//com.mysql.cj.jdbc.Driver
			System.out.println("driver loaded");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employees","root","shashwati");
			java.sql.Statement st=con.createStatement();
			PreparedStatement pst =con.prepareStatement("Insert into Employee values(?,?,?,?,?,?,?,?,?,?,?,?)");				      
			System.out.println("loaded");				
				  pst.setString (1,username);
			      pst.setString (2,password);
			      pst.setString(3,id);
			      pst.setString(4,fname);
			      pst.setString (5,lname);
			      pst.setString(6,phone);
			      pst.setString(7,email);
			      pst.setString(8,designation);
			      pst.setString(9,address);
			      pst.setString(10,gender);
			      pst.setString(11,skillset);
			      pst.setString(12,salary);
			      //pst.execute();
			      //con.close();  
			      pst.executeUpdate();
			      out.println("<html><head><title>SignUp Page</title><style>\r\n" + 
							"body {\r\n" + 
							"  background-image: url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS7ckxLOooJJb4tZi_AGFflKx6PFw2evGgsWw&usqp=CAU');\r\n" + 
							"  background-repeat: no-repeat;\r\n" + 
							"  background-attachment: fixed;\r\n" + 
							"  background-size: 100% 100%;\r\n" + 
							"}</style></head><body>"
							+ "<br><br><h1 align=\"center\"> Welcome to Supreme!!</h1>"
								+ "<h2 align=\"center\">Registered Successfully!!</h2>"
								+ "<form action=\"Welcome.html\">"
								+ "</form>");
				out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">"
				+ "<style>.button {"
				+ "  background-color: #008CBA;"
				+ "  border: none;"
				+ "  color: white;"
				+ "  padding: 5px 15px;"
				+ "  text-align: center;"
				+ "  text-decoration: none;"
				+ "  display: inline-block;"
				+ "  font-size: 16px;"
				+ "  margin: 4px 2px;"
				+ "  cursor: pointer;"
				+ "}"
				+ "body {" + 
			    "  background-image: url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS7ckxLOooJJb4tZi_AGFflKx6PFw2evGgsWw&usqp=CAU');" + 
		        "  background-repeat: no-repeat;" + 
				"  background-attachment: fixed;" + 
				"  background-size: 100% 100%;" + 
				"  }</style></head><body>"
				+ "</style>"
				+ "</head>"
				+ "<body>"
				+ "<p align=\"center\">"
				+ "<button type=\"submit\" class=\"button\" onclick=\"location.href = 'SignIn.html';\">SignIn</button>"
				+ "</p>"
				+ "</body>"
				+ "</html>");
					}
			catch(Exception e)
			{
			e.printStackTrace();
			}		 
		
		out.println("</body></html>");
	}
}


/*out.println("<br><br><h2> Welcome to Supreme "+request.getAttribute("fname")+"!!"
	+ "<h1>Registered Successfully!!</h1>"
	+ "<form action=\"Welcome.html\">"
	+"<br><br><input type=\"submit\" value=\"Click here to login\">" + 
	"</form>");*/
//rd=request.getRequestDispatcher("Welcome.html");
//rd.include(request, response);

