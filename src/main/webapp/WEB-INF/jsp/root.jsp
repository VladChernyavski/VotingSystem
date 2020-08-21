<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="post" modelAttribute="voteForm" action="">
    <spring:bind path="date">
            <input hidden type="date" value="${pageContext.}" >
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