import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class Cart extends HttpServlet
{
 public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
  PrintWriter out=res.getWriter();
  try {
   String name=req.getQueryString();
			String s[] = name.split("%2B"); name = s[0];
			String s1[] = s[1].split("=");
			String price = s1[0];
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   Connection con=DriverManager.getConnection("Jdbc:Odbc:git","","");
   Statement st=con.createStatement();
   st.executeUpdate("Insert Into Cart (Picture,Price) Values ('"+name+"','"+price+"')");
   res.sendRedirect("http://localhost:8080/prasant/car_suc.html");
   st.close();   con.close();
  }
 catch (Exception e)
  {out.println(e);} } }
