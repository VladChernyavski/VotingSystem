<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Meals</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/restaurants">Restaurant</a>
<section>
    <table border="1" cellpadding="8" cellspacing="8">
        <thead>
        <tr>
            <th>Dish name</th>
            <th>Price</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${meals}" var="meal">
            <tr>
                <td>${meal.dishName}</td>
                <td>${meal.price}</td>
                <td><a href="meals/update/${meal.id}">Update</a></td>
                <td><a href="meals/delete/${meal.id}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>

    </table>

    <a href="${pageContext.request.contextPath}/${restId}/meals/create">Add Meal</a>

</section>
</body>
</html>