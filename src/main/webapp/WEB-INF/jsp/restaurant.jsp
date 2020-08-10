<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Restaurant</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}">Home</a>
<section>

    <table border="1" cellpadding="8" cellspacing="8">
        <thead>
            <tr>
                <th>Restaurant Name</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${restaurants}" var="rs">
            <tr>
                <td><a href="${rs.id}/meals">${rs.name}</a></td>
                <td><a href="restaurants/update/${rs.id}">Update</a></td>
                <td><a href="restaurants/delete/${rs.id}">Delete</a></td>

                <c:forEach items="${meals}" var="meal">
                    <c:if test="${meal.restaurant.id == rs.id}">
                <td>
                        ${meal.dishName}
                </td>
                    </c:if>
                </c:forEach>

            </tr>
            </c:forEach>
        </tbody>

    </table>
        <a href="restaurants/create">Add Restaurant</a>
</section>
</body>
</html>