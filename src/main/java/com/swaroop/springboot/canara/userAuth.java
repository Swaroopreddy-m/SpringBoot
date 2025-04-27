package com.swaroop.springboot.canara;

import java.io.PrintWriter;
import java.sql.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.*;
@Controller
public class userAuth extends HttpServlet{

	
	/******* check user in db ****/
	
	
@PostMapping("/UserCheck")
public void UserCheckService(HttpServletRequest request,HttpServletResponse response){
response.setContentType("text/html");
try{
    PrintWriter out = response.getWriter();
    
    String userid=request.getParameter("userid");
    String password=request.getParameter("password");
    
    
    //String url = "jdbc:oracle:thin:@192.168.226.29:1521/orcl";  //with internet
    String url = "jdbc:oracle:thin:@127.0.0.1:1521/orcl";   //without internet
    String dbusername = "system";
    String dbpassword = "Swaroop123";
    String userpassword =null;
        String query1="create table student(id varchar2(200),name varchar2(200))";
        String Query="select count(*) from user_master where CUSTOMER_ID='"+userid+"'";
        String Query1="select count(*) from pin_master where CUSTOMER_ID='"+userid+"'";
        String Query2="select CUSTOMER_PASSWORD from pin_master where customer_id in('"+userid+"')";

    try {  
    	
        Class.forName("oracle.jdbc.OracleDriver");
        Connection con = DriverManager.getConnection(url, dbusername, dbpassword);
        Statement stmt = con.createStatement();

    
    ResultSet rs1;
    rs1=stmt.executeQuery(Query);
	
    System.out.println("rs1 :"+rs1);
    
    ResultSet rs2;
    rs2=stmt.executeQuery(Query1);

    
    System.out.println("rs2 :"+rs2);

 if(rs1 != rs2){
	 System.out.println("user :"+userid);
	 if(rs2.next()) {
		 System.out.println("user in pin master:"+userid);
        ResultSet rs3=stmt.executeQuery(Query2);
        rs3.next();
        userpassword=rs3.getString(1);
        System.out.println("userpassword :"+userpassword.length());
        System.out.println("password :"+password.length());
        
        if(password.equals(userpassword)){
            out.println("Hello Welcome ..");
            response.sendRedirect("/html/userWelcome.html");
            System.out.println("[userAuth] validation Done !!! ");
	        
        }else{
            
            out.println("Incorrect Credentials");
            response.sendRedirect("/html/userPage.html");            
        }
		 System.out.println("user found in user master but not in pin master:"+userid);

	 }

    /*}else if(rs 1 && rs2 == 0) {
    	System.out.println("user please set password :"+userid);
    	out.println("Hello Welcome ..Please set password to continue");
    	response.sendRedirect("/html/userpasswordset.html?userid="+userid);
 
 
    }else{*/

        out.println("error at userid validation...");
    }

            stmt.close();

        con.close();
        
    } catch (SQLException e) {
        e.printStackTrace();
        out.println("<h3 style=\"color:red;\">[userAuth] [SQLException] not done!!! Please try again .</h3>");
        out.println("<a href=\"./userPage.html\">Try again</a>");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
        out.println("JDBC Driver not found!!!");
    }


}catch(Exception e){
   
    System.out.println("ERROR whole [userDetailsCap] Exception !!!");
    System.out.println("ERROR whole [userDetailsCap] Exception !!!");
}
}


/***********************************************************************************/
/********************************  User registration  ******************************/
/***********************************************************************************/


@PostMapping("/NewCustomerReg")
public void UserRegistrationService(HttpServletRequest request,HttpServletResponse response){
response.setContentType("text/html");
try{
    PrintWriter out = response.getWriter();
    
    String customerId=request.getParameter("customerId");
    String customerName=request.getParameter("customerName");
    String DateOfBirth=request.getParameter("dob");
    String MobOrPhoneNumber=request.getParameter("phone");
    
    out.println("In [userDetailsCap] : ");
    out.println(" ");
    out.println(" customerId : "+customerId);
    out.println(" ");
    out.println(" customerName :"+customerName);
    out.println(" ");
    out.println(" DateOfBirth :"+DateOfBirth);
    out.println(" ");
    out.println(" MobOrPhoneNumber :"+MobOrPhoneNumber);
    out.println(" ");
    
    //String url = "jdbc:oracle:thin:@192.168.226.29:1521/orcl";  //with internet
    String url = "jdbc:oracle:thin:@127.0.0.1:1521/orcl";   //without internet
    String username = "system";
    String password = "Swaroop123";
        String query1="create table student(id varchar2(200),name varchar2(200))";
    try {  
        Class.forName("oracle.jdbc.OracleDriver");
        Connection con = DriverManager.getConnection(url, username, password);
        String query = "INSERT INTO user_master (CUSTOMER_ID,CUSTOMER_NAME,M_P_NUMBER,DATE_OF_BIRTH) VALUES (?, ?, ?, ?)";
    PreparedStatement stmt = con.prepareStatement(query);
    stmt.setString(1, customerId);
    stmt.setString(2, customerName);
    stmt.setString(4, DateOfBirth); // Ensure proper date format
    stmt.setString(3, MobOrPhoneNumber);
    int rowsInserted = stmt.executeUpdate(); // Use executeUpdate for INSERT
System.out.println("rowsInserted"+rowsInserted+"Insertion Done !!! ");
out.println("<body style=\"text-align:center\">");
out.println("<h3 style=\"color:green;text-align:center;\">User Registered ..</h3>");
out.println("<a href=\"/html/userpasswordset.html?username="+customerId+"><button>Next</button></a>");
out.println("</body>");
            stmt.close();
            
        con.close();
        
    } catch (SQLException e) {
        e.printStackTrace();
        out.println("<h3 style=\"color:red;\">User Registration not done!!! Please try again .</h3>");
        out.println("<a href=\"/html/userPage\">sign up</a>");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
        out.println("JDBC Driver not found!!!");
    }


}catch(Exception e){
   
    System.out.println("ERROR whole [userDetailsCap] Exception !!!");
    System.out.println("ERROR whole [userDetailsCap] Exception !!!");
}
}



/****************************************************************************/
/********************** allows User to set password *************************/
/****************************************************************************/


@PostMapping("/passwordupdate")
public void service(HttpServletRequest request,HttpServletResponse response){
response.setContentType("text/html");
try{
    PrintWriter out = response.getWriter();
    
    String userid=request.getParameter("userid");
    String password=request.getParameter("password");
    
    
    //String url = "jdbc:oracle:thin:@192.168.226.29:1521/orcl";  //with internet
    String url = "jdbc:oracle:thin:@127.0.0.1:1521/orcl";   //without internet
    String dbusername = "system";
    String dbpassword = "Swaroop123";
        String query1="create table student(id varchar2(200),name varchar2(200))";

    try {  
        Class.forName("oracle.jdbc.OracleDriver");
        Connection con = DriverManager.getConnection(url, dbusername, dbpassword);
        String query = "INSERT INTO pin_master (CUSTOMER_ID,customer_password) VALUES (?, ?)";
    PreparedStatement stmt = con.prepareStatement(query);
    stmt.setString(1, userid);
    stmt.setString(2, password);
    
    
    int rowsInserted = stmt.executeUpdate(); // Use executeUpdate for INSERT
System.out.println("rowsInserted"+rowsInserted+"Insertion Done !!! ");
out.println("<body style=\"text-align:center\">");
out.println("<h3 style=\"color:green;text-align:center;\">Password Registered ..</h3>");
out.println("<a href=\"/html/userPage.html\"><button>Next</button></a>");
out.println("</body>");
            stmt.close();
        
        con.close();
        
    } catch (SQLException e) {
        e.printStackTrace();
        out.println("<h3 style=\"color:red;\">Password Registration not done!!! Please try again .</h3>");
        out.println("<a href=\"/html/userpasswordset.html\">sign up</a>");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
        out.println("JDBC Driver not found!!!");
    }


}catch(Exception e){
   
    System.out.println("ERROR whole [userDetailsCap] Exception !!!");
    System.out.println("ERROR whole [userDetailsCap] Exception !!!");
}
}





}
