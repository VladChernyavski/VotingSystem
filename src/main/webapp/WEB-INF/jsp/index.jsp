<%--<%@ page contentType="text/html;charset=UTF-8" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Voting System</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<section>--%>

<%--    <h1>Hello</h1>--%>
<%--    <hr/>--%>
<%--    <a href="login">Login</a>--%>
<%--    <a href="registration">Registration</a>--%>

<%--</section>--%>
<%--</body>--%>
<%--</html>--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body class="text-center">
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
    <header class="masthead">
        <div class="container">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="#">Navbar</a>
                <sec:authorize access="!isAuthenticated()">
                <a class="nav-link" href="login">Log in</a>
                <a class="nav-link" href="registration">Register</a>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <form id="logoutForm" method="POST" action="${pageContext.request.contextPath}/logout">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Log Out</button>
                    </form>
                </sec:authorize>
            </nav>
        </div>
    </header>

    <main role="main" class="inner cover">
        <h1 class="cover-heading">Cover your page.</h1>
        <p class="lead">
    </main>


</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>