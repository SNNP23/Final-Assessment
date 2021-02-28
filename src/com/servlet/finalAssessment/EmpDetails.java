package com.servlet.finalAssessment;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//@WebServlet("/EmpDetails")
public class EmpDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public EmpDetails() {
        super();
         }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String userID = request.getParameter("username");
        String pass = request.getParameter("password");
		HttpSession session=request.getSession(false);
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employees","root","shashwati");
				
				Statement st=con.createStatement();
				String query="select * from EMPLOYEE";
				//st.setString(1,userID); 
				ResultSet rs=st.executeQuery(query);
				//PreparedStatement statement = con.prepareStatement("select * from EMPLOYEE where username= ?");    
				//statement.setString(1,userID);    
				//ResultSet rs = statement.executeQuery();
				while(rs.next()) {
					out.println("<html><head><title>EmpDetails</title><style>" + 
							"body {" + 
							"  background-image: url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS7ckxLOooJJb4tZi_AGFflKx6PFw2evGgsWw&usqp=CAU');" + 
							"  background-repeat: no-repeat;" + 
							"  background-attachment: fixed;" + 
							"  background-size: 100% 100%;" + 
						    "   table, th, td {\r\n"
							+ "  border: 1px solid black;\r\n"
							+ "  border-collapse: collapse;\r\n"
							+ "}\r\n"
							+ "th, td {\r\n"
							+ "  padding: 5px;\r\n"
							+ "  text-align: left;    \r\n"
							+ "}"
							
							+ "</style></head>");
					
					out.println("<body align=center>");
					out.println("<h1>Employee Details</h1>");
					out.println("<table style=\"width:50%\"><th style=\"width:40%\">EMPLOYEE ID:</th>"+"<td>"+rs.getString("empid")+"</td>"+"<br>");
					out.println("<table style=\"width:50%\"><th style=\"width:40%\">FIRST NAME:</th>"+"<td>"+rs.getString("fname")+"</td>"+"<br>");
					out.println("<table style=\"width:50%\"><th style=\"width:40%\">LAST NAME:</th>"+"<td>"+rs.getString("lname")+"</td>"+"<br>");
					out.println("<table style=\"width:50%\"><th style=\"width:40%\">PHONE:</th>"+"<td>"+rs.getString("phone")+"</td>"+"<br>");
					out.println("<table style=\"width:50%\"><th style=\"width:40%\">EMAIL:</th>"+"<td>"+rs.getString("email")+"</td>"+"<br>");
					out.println("<table style=\"width:50%\"><th style=\"width:40%\">DESIGNATION:</th>"+"<td>"+rs.getString("designation")+"</td>"+"<br>");
					out.println("<table style=\"width:50%\"><th style=\"width:40%\">ADDRESS:</th>"+"<td>"+rs.getString("address")+"</td>"+"<br>");
					out.println("<table style=\"width:50%\"><th style=\"width:40%\">GENDER:</th>"+"<td>"+rs.getString("gender")+"</td>"+"<br>");
					out.println("<table style=\"width:50%\"><th style=\"width:40%\">SKILL SET:</th>"+"<td>"+rs.getString("skill")+"</td>"+"<br>");
					out.println("<table style=\"width:50%\"><th style=\"width:40%\">SALARY:</th>"+"<td>"+rs.getString("salary")+"</td>"+"<br>");

					out.println("</table>");

					/*out.println("-----------------------------------------------------------<br>");
					out.println("Id               :     "+rs.getString("empid")+"<br>");
					out.println("First Name       :     "+rs.getString("fname")+"<br>");
					out.println("Last Name        :     "+rs.getString("lname")+"<br>");
					out.println("Phone Number     :     "+rs.getString("phone")+"<br>");
					out.println("Email ID         :     "+rs.getString("email")+"<br>");
					out.println("Designation      :     "+rs.getString("designation")+"<br>");
					out.println("Address          :     "+rs.getString("address")+"<br>");
					out.println("Gender           :     "+rs.getString("gender")+"<br>");
					out.println("Skills           :     "+rs.getString("skillset")+"<br>");
					out.println("Basic Salary     :     "+rs.getString("salary")+"<br>");
					out.println("-----------------------------------------------------------<br><br>");*/
					
					//out.println("Skills           :     "+rs.getString("skills")+"<br>");
				}
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			out.println("<br><br><a href=EmpPayslip>Employee Pay Slip </a><br>");
			out.println("<a href=NewFile.jsp>Home Page</a><br>");
			out.println("<a href=Logout>Logout</a><br>");
			out.println("</body></html>");
            /*PrintWriter out=response.getWriter();
		out.println("<html><head><title>Employee Payslip</title><style>\r\n" + 
				"body {\r\n" + 
				"  background-image: url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS7ckxLOooJJb4tZi_AGFflKx6PFw2evGgsWw&usqp=CAU');\r\n" + 
				"  background-repeat: no-repeat;\r\n" + 
				"  background-attachment: fixed;\r\n" + 
				"  background-size: 100% 100%;\r\n" + 
				"}</style></head><body>");
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");//com.mysql.cj.jdbc.Driver
		java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employees","root","shashwati");	
		java.sql.Statement st=con.createStatement();
		String q="select USERNAME,EMPID,FNAME,LNAME,PHONE,EMAIL,DESIGNATION,ADDRESS,GENDER,SKILLSET,SALARY from EMPLOYEE";
		ResultSet rs=st.executeQuery(q);		
		while(rs.next())
		{
			    out.println("<table style=\"width:100%\">" + 
					"<tr>"+
					"<th>Employee ID</th> " + 
					"<th>Firstname</th>" + 
					"<th>Lastname</th>" + 
					"<th>Phone</th>"+
					"<th>Email</th>"+
					"<th>Designation</th>"+
					"<th>Address</th>"+
					"<th>Gender</th>"+
					"<th>Skill Set</th>"+
					"<th>Salary</th>" + 
					"</tr>");
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
				out.println("</body></html>");
		}
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}	*/
	}
}


