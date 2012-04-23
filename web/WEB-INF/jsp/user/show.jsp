<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>
    <fmt:message key="user.show"/></title></head>
<body>
<jsp:useBean id="user" class="net.therap.domain.User" scope="session"/>
<jsp:getProperty name="user" property="userName"/>
</body>
</html>
