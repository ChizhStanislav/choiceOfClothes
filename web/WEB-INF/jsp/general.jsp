<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Clothing selection</title>
</head>
<body>
<h1>Enter the city name</h1>
<div>
    <form action="${pageContext.request.contextPath}/general" method="post">
        <input type="text" name="city">
        <input type="submit" value="Select">
    </form>
</div>
<c:if test="${requestScope.clothes != null}">
    <h2>Clothes:</h2>
    <c:forEach var="clothe" items="${requestScope.clothes}">
        <span>${clothe.name}</span>
    </c:forEach>
</c:if>
</body>
</html>
