package in.conceptarchitect.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//when user types /
public class WelcomeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer = resp.getWriter();
		
		writer.println("<html><head><title>Welcome to Movies Web</title></head>");
		writer.println("<body>");
		writer.println("<h1>Movies Web</h1>");
		
		writer.printf("<p><strong>URL</strong> : %s", req.getRequestURI());
		
		writer.println("<h2>Request Headers</h2>");
		writer.println("<ul>");
		
		Enumeration<String> headerKeys=  req.getHeaderNames();
		while(headerKeys.hasMoreElements()) {
			String headerKey= headerKeys.nextElement();
			String headerValue=req.getHeader(headerKey);
			writer.printf("<li><strong>%s</strong> : %s", headerKey, headerValue);
		}
		writer.println("</ul>");
		
		writer.println("</body>");
	}
	
	

}
