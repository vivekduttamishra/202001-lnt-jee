<%@page import="in.conceptarchitect.movieservice.Review"%>
<%@page import="java.util.Collection"%>
<%@page import="in.conceptarchitect.movieservice.Movie"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<% 
	Movie movie=(Movie) request.getAttribute("movie");
%>

<title><%=movie.getName() %></title>
</head>
<body>
<a href='/simple-web/movielist'>Back To List</a>

<h1><%=movie.getName() %></h1>

<h3>Plot</h3>
<p><%=movie.getPlot() %></p>


<p>Imdb Rating : <%=movie.getImdbRating() %>/10 </p>

<h3>User Reviews</h3>


<table style='border:1px solid black;'>
<thead>
<tr>
<th style='width:70%' >Review</th>
<th>User Rating</th>
</tr>
</thead>

<tbody>
	<% for(Review review: movie.getReviews()){ %>
	<tr>
		<td><%=review.getDescription() %></a></td>
		<td><%=review.getRating() %></td>
	</tr>
	<%} %>
</tbody>
</table>



</body>
</html>