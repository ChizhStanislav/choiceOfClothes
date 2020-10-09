<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add clothes</title>
</head>
<body>
<h1>ADD CLOTHES</h1>
<div>
    <form action="${pageContext.request.contextPath}/clothes" method="post">
        <input type="text" name="name">
        <select name="temperature" required>
            <c:forEach var="temperature" items="${sessionScope.temperatures}">
                <option value="${temperature.name()}">${temperature.name()}[${temperature.minimumTemperature},${temperature.maximumTemperature}]</option>
            </c:forEach>
        </select>
        <input type="submit" value="Save">
    </form>
</div>
</body>
</html>
