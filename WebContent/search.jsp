<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Search</title>
</head>
<body>
	<a href="navigation">Navigation</a>
	<form action="search" method="get">
		<table>
			<tr>
				<td>Search term</td>
				<td><input name="term"
					value="${requestScope.searchResult.term}" /></td>
				<td colspan="2"><input type="submit" value="Search" /></td>
			</tr>
		</table>
	</form>

	Movies matching your search criteria:
	<table>
		<c:forEach items="${requestScope.searchResult.movies}" var="movie">
			<tr>
				<td>${movie.title}</td>
			</tr>
		</c:forEach>
	</table>

	Serials matching your search criteria:
	<table>
		<c:forEach items="${requestScope.searchResult.serials}" var="serial">
			<tr>
				<td>${serial.title}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>