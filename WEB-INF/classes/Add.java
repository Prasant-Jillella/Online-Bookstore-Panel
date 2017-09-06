importjavax.servlet.*;
importjavax.servlet.http.*;
import java.io.*;
importjava.sql.*;
public class Add extends HttpServlet
{
public void service(HttpServletRequestreq, HttpServletResponse res) throws ServletException,IOException
 {
PrintWriter out=res.getWriter();
try
  {
   String e=req.getParameter("email");
   String p=req.getParameter("pwd");
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   Connection con=DriverManager.getConnection("Jdbc:Odbc:git","","");
   Statement st=con.createStatement();
st.executeUpdate("Insert Into Login (Email,Password) Values ('"+e+"','"+p+"')");
res.sendRedirect("http://localhost:8080/prasant/reg_suc.html");
st.close();
con.close();
  }
catch (Exception e)
  {out.println(e);}}}
