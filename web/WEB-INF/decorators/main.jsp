<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html>

<head>
    <title><decorator:title default="INTRANET"/></title>
    <decorator:head/>


    <style type="text/css">
        div.foot {
            align: center;
            background-color: #ffffcc;
            width: 100%;
            height: 60px;

        }
    </style>

</head>

<body bgcolor="#F5FFFF">

<decorator:body/>

<%@ include file="footer.jsp" %>

</body>

</html>
