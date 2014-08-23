<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
---

 <c:out value="${demoQuiz.description}"/>
 <c:out value="Nível ${demoQuiz.levels[0].id} - ${demoQuiz.levels[0].description}">
</c:out>
</body>
</html>
