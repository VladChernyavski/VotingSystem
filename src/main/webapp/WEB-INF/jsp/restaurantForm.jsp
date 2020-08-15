<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
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

            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()" type="button">Cancel</button>
    </form>
</section>
</body>
</html>