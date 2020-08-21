<%--<%@ page contentType="text/html;charset=UTF-8" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Voting System</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="container">--%>
<%--    <div class="row">--%>
<%--        <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">--%>
<%--            <div class="card card-signin my-5">--%>
<%--                <div class="card-body">--%>
<%--                    <h5 class="card-title text-center">Register Form</h5>--%>
<%--                    <form class="form-signin" method="post" action="${pageContext.request.contextPath}/registration">--%>
<%--                        <div class="form-label-group">--%>
<%--                            <input type="text" id="name" name="name" class="form-control" placeholder="User name" required autofocus>--%>
<%--                            <label for="name">User name</label>--%>
<%--                        </div>--%>

<%--                        <div class="form-label-group">--%>
<%--                            <input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email address" required autofocus>--%>
<%--                            <label for="inputEmail">Email address</label>--%>
<%--                        </div>--%>

<%--                        <div class="form-label-group">--%>
<%--                            <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>--%>
<%--                            <label for="inputPassword">Password</label>--%>
<%--                        </div>--%>

<%--                        <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Register</button>--%>
<%--                        <hr class="my-4">--%>

<%--                    </form>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Create an account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">


    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</head>

<body class="loginBody">

<div class="container">
    <div class="row">
        <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
            <div class="card card-signin my-5">
                <div class="card-body">
                    <h5 class="card-title text-center">Registration</h5>

                        <form:form method="POST" modelAttribute="userForm" class="form-signin">
                            <spring:bind path="name">
                                <div class="form-label-group ${status.error ? 'has-error' : ''}">
                                    <form:input id="name" type="text" path="name" class="form-control" placeholder="Name"
                                                autofocus="true"></form:input>
                                    <form:errors path="name"></form:errors>
                                    <label for="name">Name</label>
                                </div>
                            </spring:bind>

                            <spring:bind path="email">
                                <div class="form-label-group ${status.error ? 'has-error' : ''}">
                                    <form:input id="email" type="email" path="email" class="form-control" placeholder="Email"
                                                autofocus="true"></form:input>
                                    <form:errors path="email"></form:errors>
                                    <label for="email">Email address</label>
                                </div>
                            </spring:bind>

                            <spring:bind path="password">
                                <div class="form-label-group ${status.error ? 'has-error' : ''}">
                                    <form:input id="password" type="password" path="password" class="form-control" placeholder="Password"></form:input>
                                    <form:errors path="password"></form:errors>
                                    <label for="password">Password</label>
                                </div>
                            </spring:bind>

                            <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Register</button>
                            <hr class="my-4">
                        </form:form>
                    <a class="nav-link" href="${contextPath}/">Home page</a>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>