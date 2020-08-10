<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body class="text-center">
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
    <jsp:include page="fragments/bodyHeader.jsp"/>

    <main role="main" class="inner cover">
        <h1 class="cover-heading">Cover your page.</h1>
        <p class="lead">
        <table class="table table-borderless">
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
        </p>
        <p class="lead">
            <a href="#" class="btn btn-lg btn-secondary">Learn more</a>
        </p>
    </main>


</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>