import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Jinuk extends HttpServlet { //Jinuk 서블릿 이라고 부른다
	public void Jinuk(HttpServletRequest request, HttpServletResponse reponse) throws IOException,
	ServletException {
		System.out.println("Hello Servlet");
	}
}