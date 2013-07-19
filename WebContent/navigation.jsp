<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Navigation</title>
</head>
<body>
	<a href="search">Search</a>

	<table>
		<c:forEach items="${requestScope.navigateResult.media}" var="media">
			<tr>
				<td><a href="navigation?breadCrumb=${requestScope.navigateResult.breadCrumb},${media.title}">${media.title}</a></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>