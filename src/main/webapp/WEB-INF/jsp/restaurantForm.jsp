<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Restaurant</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">
</head>
<body>
<%--<section>--%>
<%--    <h3><a href="index">Home</a></h3>--%>
<%--    <hr>--%>
<%--    <h2>Create restaurant</h2>--%>
<%--    <jsp:useBean id="restaurant" type="by.chernyavski.model.Restaurant" scope="request"/>--%>
<%--    <form method="post" action="${pageContext.request.contextPath}/restaurants">--%>
<%--        <input type="hidden" name="id" value="${restaurant.id}">--%>
<%--        <dl>--%>
<%--            <dt>Name:</dt>--%>
<%--            <dd><input type="text" value="${restaurant.name}" name="name" required></dd>--%>

<%--            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
<%--        </dl>--%>
<%--        <button type="submit">Save</button>--%>
<%--        <button onclick="window.history.back()" type="button">Cancel</button>--%>
<%--    </form>--%>
<%--</section>--%>
<div class="container">

    <div class="row">
        <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
            <div class="card card-signin my-5">
                <div class="card-body">
                    <h5 class="card-title text-center">Create restaurant</h5>
                    <jsp:useBean id="restaurant" type="by.chernyavski.model.Restaurant" scope="request"/>
                    <form class="form-signin" method="POST" action="${pageContext.request.contextPath}/restaurants">
                        <input type="hidden" name="id" value="${restaurant.id}">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                        <div class="form-label-group">
                            <input name="name" value="${restaurant.name}" type="text" id="name" class="form-control" placeholder="Restaurant name" required autofocus>
                            <label for="name">Restaurant name</label>
                        </div>

                        <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Save</button>
                        <button class="btn btn-lg btn-primary btn-block text-uppercase" onclick="window.history.back()" type="button">Cancel</button>
                        <hr class="my-4">
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>