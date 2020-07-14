<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Restaurant</title>
</head>
<body>
<section>

        <c:forEach items="${restaurant}" var="rs">
            <p>${rs.name}</p>
        </c:forEach>

</section>
</body>
</html>