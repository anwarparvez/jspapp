<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title><fmt:message key="user.show"/></title></head>
<body>
    <table>
        <tr>
            <td>
                <fmt:message key="user.userName"/>
            </td>
            <td>
                <c:out value="${x}"/>
                <c:out value="${user.userName}"/>
            </td>
        </tr>

        <tr>
            <td>
                <fmt:message key="user.fullName"/>
            </td>
            <td>
                <c:out value="${user.fullName}"/>
            </td>
        </tr>

        <tr>
            <td>
                <fmt:message key="user.userName"/>
            </td>
            <td>
                <c:out value="userName"/>
            </td>
        </tr>

        <tr>
            <td>
                <fmt:message key="user.userName"/>
            </td>
            <td>
                <c:out value="userName"/>
            </td>
        </tr>


    </table>

</body>
</html>
