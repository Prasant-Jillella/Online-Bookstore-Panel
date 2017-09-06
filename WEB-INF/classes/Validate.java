import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*; 
public class Validate extends HttpServlet
{
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
  {
   PrintWriter out=res.getWriter();
   try
   {
     String e=req.getParameter("email");
     String p=req.getParameter("pwd");
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("Jdbc:Odbc:git","","");
     Statement st=con.createStatement();
     ResultSet rs=st.executeQuery("Select * from Login");
     while(rs.next())
     {
	String em=rs.getString(1);
	String ps=rs.getString(2);
	if((em.equals(e))&&(ps.equals(p)))
        {
          res.sendRedirect("http://localhost:8090/prasant/login_suc.html");
          st.close();
          con.close();
	  break;
        }
     }
     res.sendRedirect("http://localhost:8090/prasant/login.html");
     st.close();
     con.close();
  }
  catch (Exception e)
  {out.println(e);}
 }
}
  