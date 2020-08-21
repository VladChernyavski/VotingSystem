<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--<header class="masthead">--%>
<%--    <div class="container">--%>
<%--        <nav class="navbar navbar-expand-lg navbar-light bg-light">--%>
<%--            <a class="navbar-brand" href="${pageContext.request.contextPath}/">Voting System</a>--%>
<%--            <sec:authorize access="!isAuthenticated()">--%>
<%--                <a class="nav-link" href="login">Log in</a>--%>
<%--                <a class="nav-link" href="registration">Register</a>--%>
<%--            </sec:authorize>--%>
<%--            <sec:authorize access="isAuthenticated()">--%>
<%--                <form id="logoutForm" method="POST" action="${pageContext.request.contextPath}/logout">--%>
<%--                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
<%--                    <button class="btn btn-lg btn-primary btn-block" type="submit">Log Out</button>--%>
<%--                </form>--%>
<%--            </sec:authorize>--%>
<%--            <sec:authorize url="/users">--%>
<%--                <a class="nav-link" href="users">Manage Users</a>--%>
<%--            </sec:authorize>--%>
<%--        </nav>--%>
<%--    </div>--%>
<%--</header>--%>

<header class="masthead mb-auto">
    <div class="inner">
        <h3 class="masthead-brand" ><a class="nav-link" href="${pageContext.request.contextPath}/">Restaurant voting system</a></h3>
        <nav class="nav nav-masthead justify-content-center">
            <a class="nav-link active" href="${pageContext.request.contextPath}/">Home</a>
            <sec:authorize access="!isAuthenticated()">
                <a class="nav-link" href="login">Log in</a>
                <a class="nav-link" href="registration">Register</a>
            </sec:authorize>
            <sec:authorize url="/users">
                <a class="nav-link" href="${pageContext.request.contextPath}/users">Manage Users</a>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <form id="logoutForm" method="POST" action="${pageContext.request.contextPath}/logout">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button id="btnLogOut" class="btn btn-outline-secondary" type="submit">Log Out</button>
                </form>
            </sec:authorize>
        </nav>
    </div>
</header>
