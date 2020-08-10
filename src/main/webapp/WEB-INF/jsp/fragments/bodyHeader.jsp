<%@page contentType="text/html" pageEncoding="UTF-8" %>

<header class="masthead">
<%--    <div class="navbar navbar-masthead navbar-fixed-top">--%>
<%--        <h3 class="masthead-brand">Cover</h3>--%>
<%--        <nav class="nav nav-masthead justify-content-center">--%>
<%--            <a class="nav-link active" href="#">Home</a>--%>
<%--            <a class="nav-link" href="#">Features</a>--%>
<%--            <a class="nav-link" href="#">Contact</a>--%>
<%--        </nav>--%>
<%--    </div>--%>
    <div class="container">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">Navbar</a>
            <form id="logoutForm" method="POST" action="${pageContext.request.contextPath}/logout">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Log Out</button>
            </form>
        </nav>
    </div>
</header>