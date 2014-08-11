<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>

<c:forEach items="${users}" var="user">
        <c:out value="${user.firstName}"/>
        <c:out value="${user.email}"/>
        <c:out value="${user.lastName}"/>
    </tr>
</c:forEach>

</body>
</html>
