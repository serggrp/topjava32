<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="mealTo" class="ru.javawebinar.topjava.model.MealTo" scope="page"/>
<html lang="ru">
<head>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>
<h3>
    <table border="1">
        <c:forEach var="meal" items="${mealsList}">
            <tr> <td>   <c:out value="${meal.description}"/> </td>
            </tr>
        </c:forEach>
    </table>
</h3>
</body>
</html>