<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Meal</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row">
        <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
            <div class="card card-signin my-5">
                <div class="card-body">
                    <h5 class="card-title text-center">Create meal</h5>
                    <jsp:useBean id="meal" type="by.chernyavski.model.Meal" scope="request"/>
                    <form class="form-signin" method="POST" action="${pageContext.request.contextPath}/${meal.restaurant.id}/meals">
                        <input type="hidden" name="id" value="${meal.id}">
                        <input type="hidden" name="restId" value="${meal.restaurant.id}">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                        <div class="form-label-group">
                            <input name="dishName" value="${meal.dishName}" type="text" id="dishName" class="form-control" placeholder="Dish name" required autofocus>
                            <label for="dishName">Dish name</label>
                        </div>
                        <div class="form-label-group">
                            <input name="price" value="${meal.price}" type="number" id="price" class="form-control" placeholder="Price" required autofocus>
                            <label for="price">Price</label>
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