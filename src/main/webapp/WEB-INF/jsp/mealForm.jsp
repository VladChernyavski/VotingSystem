<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Meal</title>
</head>
<body>
<section>
    <h3><a href="index">Home</a></h3>
    <hr>
    <h2>Create meal</h2>
    <jsp:useBean id="meal" type="by.chernyavski.model.Meal" scope="request"/>
    <form method="post" action="${pageContext.request.contextPath}/${meal.restaurant.id}/meals">
        <input type="hidden" name="id" value="${meal.id}">
        <input type="hidden" name="restId" value="${meal.restaurant.id}">
        <dl>
            <dt>Dish name:</dt>
            <dd><input type="text" value="${meal.dishName}" name="dishName" required></dd>
        </dl>
        <dl>
            <dt>Price:</dt>
            <dd><input type="number" value="${meal.price}" name="price" required></dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()" type="button">Cancel</button>
    </form>
</section>
</body>
</html>