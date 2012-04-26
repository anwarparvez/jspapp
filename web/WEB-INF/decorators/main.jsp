<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html>

<head>
    <title><decorator:title default="INTRANET"/></title>
    <decorator:head/>
    <link href="css/style.css" rel="stylesheet" type="text/css">

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
<div class="main">
    <div class="page">
        <div class="header">
            <div class="header-img"><img src="images/header3.jpg" alt="" height="220"
                                         width="800"></div>
            <div class="topmenu">
                <ul>
                    <li><a href="user">Home</a></li>
                    <li><a href="vote">Vote</a></li>
                    <li><a href="result">Result</a></li>
                    <%--<li><a href="#">About Us</a></li>
                    <li><a href="#">Email Us</a></li>--%>
                    <c:choose>
                        <c:when test="${user==null}">
                            <li><a href="login">Log In</a></li>
                        </c:when>
                        <c:when test="${user!=null}">
                            <li><a href="login">Log out</a></li>
                        </c:when>
                    </c:choose>
                </ul>
            </div>
        </div>
        <div class="content">
            <div class="leftpanel">
                <h2>Main Menu</h2>
                <ul>
                    <li><a href="user">Home</a></li>
                    <c:if test="${user!=null}">
                        <li><a href="vote">Vote</a></li>
                        <c:if test="${user.admin==true}">
                            <li><a href="result">Result</a></li>
                        </c:if>
                    </c:if>
                </ul>
            </div>
            <div class="rightpanel">
                <div class="rightbody">
                    <h1 class="title">Welcome to our website</h1>
                    <decorator:body/>

                </div>
            </div>
        </div>
        <%@ include file="footer.jsp" %>
    </div>
</div>
</body>
</html>
