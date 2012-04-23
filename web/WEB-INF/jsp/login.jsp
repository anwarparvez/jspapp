<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title><fmt:message key="login.title"/></title></head>
<body>
  <form action="login" method="post">
    <span> User Name</span> <input name="userName"/> <br/>
    <span> Password</span> <input name="password"/> <br/>
    <input type="submit" value="Login"/>
</form>
</body>
</html>
