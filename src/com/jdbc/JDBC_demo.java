package com.jdbc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class JDBC_demo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out=response.getWriter();

        out.println("<h1>hello JDBC_DEMO</h1>");

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","Computer_lab","computer_lab");
            Statement stmt=con.createStatement();
            ResultSet rst=stmt.executeQuery("select*from computer_student");

            while(rst.next())

            {    String computer_student=rst.getString(2);

                int student_id=rst.getInt(1);
                int student_age=rst.getInt(3);

                out.println("<h1>"+computer_student+" "+student_id+" "+student_age+"</h1>");
            }
            con.close();


        }
        catch(Exception e)
        {
            out.println("<h3>"+e+"</h3>");
        }




    }
}
