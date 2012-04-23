<%--
  Created by IntelliJ IDEA.
  User: parvez
  Date: 4/23/12
  Time: 4:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Simple jsp page</title></head>
<body>Successfully Voted
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