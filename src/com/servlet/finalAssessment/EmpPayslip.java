package com.servlet.finalAssessment;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//@WebServlet("/EmpPayslip")
public class EmpPayslip extends HttpServlet {
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
    
	public EmpPayslip() {
        super();
       }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>Employee Details</title><style>\r\n" + 
				"body {\r\n" + 
				"  background-image: url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS7ckxLOooJJb4tZi_AGFflKx6PFw2evGgsWw&usqp=CAU');\r\n" + 
				"  background-repeat: no-repeat;\r\n" + 
				"  background-attachment: fixed;\r\n" + 
				"  background-size: 100% 100%;\r\n" + 
				"}</style></head><body>"
				+ "");	
		HttpSession session=request.getSession(false);
		//int bp=Integer.valueOf(request.getParameter("sal"));
		int bp;
		
		try {
			Class.forName(driver);
			
			java.sql.Connection con=DriverManager.getConnection(url,user,pwd);
			
			Statement st=con.createStatement();
			String query="select * from employee";
			ResultSet rs=st.executeQuery(query);
			String s="";
			out.println("<html><head><title>SignIn Page</title><style>" + 
					"body {" + 
					"  background-image: url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS7ckxLOooJJb4tZi_AGFflKx6PFw2evGgsWw&usqp=CAU');" + 
					"  background-repeat: no-repeat;" + 
					"  background-attachment: fixed;" + 
					"  background-size: 100% 100%;" + 
					"}</style></head><body>");while(rs.next()) {
				s=(rs.getString("salary"));
			
			
			bp=Integer.parseInt(s);
			double ta=(10.0*bp)/100;
			double hra=(17.0*bp)/100;
			double pf=(15.0*bp)/100;
			double pt=(7.0*bp)/100;
			double it=(9.0*bp)/100;
			String name=rs.getString("fname")+" "+rs.getString("lname");
			double gross=bp+ta+hra;
			double net=gross-pf-pt-it;
			
			out.println("<br><br><br>-----------------------------------------<br>");
			out.println("Employee Name         :  "+name+"<br>");
			out.println("Basic Salary          :  "+bp+"<br>");
			out.println("Total allowance       :  "+ta+"<br>");
			out.println("House Rent Allowance  :  "+hra+"<br>");
			out.println("Provident Fund        :  "+pf+"<br>");
			out.println("Professional Tax      :  "+pt+"<br>");
			out.println("Income tax            :  "+it+"<br>");
			out.println("Gross Salary          :  "+gross+"<br>");
			out.println("Net Salary            :  "+net+"<br>");
			out.println("-----------------------------------------<br>");
			}
			out.println("<br><br><br><br><br>");
			out.println("<a href=EmpDetails>Employee Details</a><br>");
			out.println("<a href=NewFile.jsp>Home Page</a><br>");
			out.println("<a href=Logout>Logout</a><br>");
			out.println("</body></html>");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	

}
