<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:forEach items="${region.school}" var="school">
    <c:out value="<option value=${school.id}>${school.schoolName}</option>" escapeXml="false"/>
</c:forEach>
