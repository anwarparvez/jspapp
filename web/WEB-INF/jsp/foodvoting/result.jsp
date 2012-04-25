<%--
  Created by IntelliJ IDEA.
  User: parvez
  Date: 4/25/12
  Time: 3:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Simple jsp page</title></head>
<body>
<c:if test="${user.admin==true}">
    <table border="1">
        <tr>
            <th>Food Name</th>
            <th>Vote</th>
        </tr>
        <c:forEach var="entry" items="${voteMap}">
            <tr>
                <td>${entry.key}</td>
                <td>${entry.value}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>