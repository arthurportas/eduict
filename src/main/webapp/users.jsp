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

 <c:out value="${demoQuiz.description}">
    <!--<h4><c:out value="${quiz.description}"/></h4>-->
    <c:forEach items="${demoQuiz.levels}" var="level" varStatus="levelIndex">
        <div class="level level-${level.id}-wrapper ${not levelIndex.first ? 'hidden' : ''}">
            <div class="alert alert-info level-${level.id}">
            <h4><c:out value="Nível ${level.id} - ${level.description}"/></h4>
        </div>
    </c:forEach>
</c:out>
</body>
</html>
