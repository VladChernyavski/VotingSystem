<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body class="text-center">
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
    <jsp:include page="fragments/bodyHeader.jsp"/>

    <main role="main" class="inner cover">
        <h1 class="cover-heading">Restaurant voting system</h1>
        <p class="lead">
            Here you can vote for the restaurant in which you like the menu more</p>
        <p class="lead">
            <a href="restaurants" class="btn btn-lg btn-secondary">Go to restaurants</a>
        </p>
    </main>

    <jsp:include page="fragments/footer.jsp"/>
</div>
</body>
</html>