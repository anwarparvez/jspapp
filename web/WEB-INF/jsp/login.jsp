<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title><fmt:message key="login.title"/></title></head>
<body>
<form:form>
    <table>
        <tr>
            <th><fmt:message key="user.userName"/>:</th>
            <td>
                <form:input path="userName"/>
                <form:errors path="userName"/>
            </td>
        </tr>
        <tr>
            <th><fmt:message key="user.password"/>:</th>
            <td>
                <form:password path="password"/>
                <form:errors path="password"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="<fmt:message key="login.btn.label"/>"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
