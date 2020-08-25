<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body class="text-center">
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
    <jsp:include page="fragments/bodyHeader.jsp"/>

    <main role="main" class="inner cover">
        <h1 class="cover-heading">Restaurant menu</h1>
        <hr/>
        <p class="lead">

            <table class="table table-borderless">
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
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <td><a class="btn btn-secondary" href="meals/update/${meal.id}">Update</a></td>
                                <td><a class="btn btn-secondary" href="meals/delete/${meal.id}">Delete</a></td>
                            </sec:authorize>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <hr/>
            <div class="row">
                <sec:authorize url="${pageContext.request.contextPath}/${restId}/meals/create">
                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/${restId}/meals/create">Add Meal</a>
                </sec:authorize>
                <a style="margin-left: 15px" class="btn btn-secondary" href="${pageContext.request.contextPath}/restaurants">Back</a>
            </div>
        </p>
    </main>

    <jsp:include page="fragments/footer.jsp"/>
</div>
</body>
</html>