<%@page import="java.util.Enumeration"%>
<html>
<body>
<h2>Hello World!</h2>

<p> URL :  <%= request.getRequestURI() %> </p>

<h2>Headers</h2>

<ul>

<%
   Enumeration<String> headerKeys= request.getHeaderNames();
   while(headerKeys.hasMoreElements()){
	   String headerKey= headerKeys.nextElement();
	   String headerValue= request.getHeader(headerKey);
%>
	   <li><strong><%=headerKey %></strong>: <%=headerValue %></li>

<% 	   
   }
%>

</ul>



</body>
</html>
