<%@page import="java.util.Collection"%>
<%@page import="in.conceptarchitect.movieservice.Movie"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<% 
	String heading=(String)request.getAttribute("heading");
	Collection<Movie> movies=(Collection<Movie>) request.getAttribute("movies");
%>

<title><%=heading %></title>
</head>
<body>
<h1><%=heading %></h1>

<table style='border:1px solid black;'>
<thead>
<tr>
<th style='width:70%' >Title</th>
<th>Imdb Rating</th>
</tr>
</thead>

<tbody>
	<% for(Movie movie : movies){ %>
	<tr>
		<td><a href='/simple-web/moviedetails?imdbId=<%=movie.getImdbId()%>'><%=movie.getName() %></a></td>
		<td><%=movie.getImdbRating() %></td>
	</tr>
	<%} %>
</tbody>
</table>



</body>
</html>