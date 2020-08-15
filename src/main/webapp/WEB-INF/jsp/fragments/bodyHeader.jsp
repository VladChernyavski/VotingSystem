<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<header class="masthead">
    <div class="container">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">Voting System</a>
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
            <sec:authorize url="/users">
                <a class="nav-link" href="users">Manage Users</a>
            </sec:authorize>
        </nav>
    </div>
</header>
