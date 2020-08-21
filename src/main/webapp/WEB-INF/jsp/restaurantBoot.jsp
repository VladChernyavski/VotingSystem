<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body class="text-center">
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
    <jsp:include page="fragments/bodyHeader.jsp"/>

    <main role="main" class="inner cover">
        <h1 class="cover-heading">Restaurants</h1>
        <hr/>
        <p class="lead">
        <table class="table table-borderless">
            <thead align="center">
            <tr>
                <th></th>
                <th></th>
                <th>Vote</th>
            </tr>
            </thead>
            <tbody align="center">
            <c:forEach items="${restaurantsTo}" var="rs">

                <tr>
                    <td align="left">${rs.name}</td>
                    <td><a class="btn btn-secondary" href="${rs.id}/meals">Restaurant menu</a></td>
                    <td>${rs.countVote}</td>
                    <sec:authorize access="hasRole('ROLE_USER')">
                        <td>
                            <form method="POST" action="${pageContext.request.contextPath}/vote">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <input hidden name="rest" value="${rs.id}">
                                <button class="btn btn-secondary" type="submit">Vote</button>
                            </form>
                        </td>
                    </sec:authorize>

                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <td><a class="btn btn-secondary" href="restaurants/update/${rs.id}">Update</a></td>
                        <td><a class="btn btn-secondary" href="restaurants/delete/${rs.id}">Delete</a></td>
                    </sec:authorize>

                </tr>
            </c:forEach>
            </tbody>

        </table>
        <hr/>
        <sec:authorize url="/restaurants/create">
            <a class="btn btn-secondary" href="restaurants/create">Add restaurant</a>
        </sec:authorize>
        </p>
    </main>

    <jsp:include page="fragments/footer.jsp"/>
</div>
</body>
</html>