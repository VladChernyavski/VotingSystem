<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Restaurant</title>
</head>
<body>
<section>
    <h3><a href="index">Home</a></h3>
    <hr>
    <h2>Create restaurant</h2>
    <jsp:useBean id="restaurant" type="by.chernyavski.model.Restaurant" scope="request"/>
    <form method="post" action="${pageContext.request.contextPath}/restaurants">
        <input type="hidden" name="id" value="${restaurant.id}">
        <dl>
            <dt>Name:</dt>
            <dd><input type="text" value="${restaurant.name}" name="name" required></dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()" type="button">Cancel</button>
    </form>
</section>
</body>
</html>