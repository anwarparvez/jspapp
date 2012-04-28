<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="en"/>
<fmt:setBundle basename="messages" />

<html>
<head><title><fmt:message key="login.title"/></title></head>
<body>
<form action="login" method="post">
    <fieldset>
        <legend>Log In</legend>
        <span> User Name</span> <input name="userName" type="text"/> <br/>
        <span> Password</span> <input name="password" type="password"/> <br/>
        <input type="submit" value="Login"/>
    </fieldset>
</form>
</body>
</html>
