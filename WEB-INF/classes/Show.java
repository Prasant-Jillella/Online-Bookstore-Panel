import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class Show extends HttpServlet
{
public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
 {
   PrintWriter out=res.getWriter();
		res.setContentType("text/html");
		String s = "center.jpg";
		String c = "blue";
		String f = "Gabriola";
		String g = "#85FF5C";
		String y = "yellow";
		String m = "Comic Sans MS";
		String l = "catalogue.html";
		int t = 0;
try
  {
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   Connection con=DriverManager.getConnection("Jdbc:Odbc:git","","");
   Statement st=con.createStatement();
ResultSet rs = st.executeQuery("Select * from Cart");
			out.println("<html><body background='"+s+"'><center><font color='"+g+"' size='"+12+"' face='"+f+"'><b><u>Cart</u></b></fort></h1><table border='"+3+"' cellpadding='"+15+"' cellspacing='"+10+"'><tr><th><font color='"+y+"' size='"+5+"' face='"+m+"'>Books</font></th><th><font color='"+y+"' size='"+5+"' face='"+m+"'>Price</font></th></tr>");
			while(rs.next())
			{
				String p = rs.getString(1);
				String price = rs.getString(2);
				t+=Integer.valueOf(price);
				out.println("<tr><td><img src='"+p+"' height='"+200+"' width='"+150+"'></td>");
				out.println("</font></b></td><td><b><font color='"+c+"' size='"+6+"' face='"+f+"'>Rs.");
				out.println(price);
				out.println("</font></b></td></tr>");
			}
			out.println("</table><font color='"+c+"' size='"+12+"' face='"+f+"'><b>Total price is: Rs."+t+"</b></fort><br><font color='"+y+"' size='"+5+"' face='"+m+"'><b><a href='"+l+"'>Keep shopping</a></b></fort></center></body></html>");
st.close();
con.close();
  }
catch (Exception e)
   {out.println(e);}}}
