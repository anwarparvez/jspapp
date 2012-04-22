<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head><title><fmt:message key="user.create"/></title></head>
  <body>
  <h1><fmt:message key="user.create"/></h1>

<s:hasBindErrors name="command">
        <div id="div_global_error" align="center">
            <h1>
                <%--<fmt:message key="error.title"/>--%>
            </h1>
            <div id="global_errors">
                <s:bind path="command">
                    <ul class="header-list">
                        <c:forEach items="${status.errorMessages}" var="err">
                            <li>
                                <c:out value='${err}'/>
                            </li>
                        </c:forEach>
                    </ul>
                </s:bind>
            </div>
        </div>
    </s:hasBindErrors>


  <form:form action="save">

      <table>
          <tr>
              <th><fmt:message key="user.userName"/></th>
              <td>
                  <form:input path="userName" maxlength="35"/>
                  <form:errors path="userName"/>
              </td>
          </tr>

          <tr>
              <th><fmt:message key="user.password"/></th>
              <td>
                  <form:password path="password" maxlength="35"/>
                  <form:errors path="password"/>
              </td>
          </tr>

          <tr>
              <th><fmt:message key="user.confirmPassword"/></th>
              <td>
                  <form:password path="confirmPassword" maxlength="35"/>
                  <form:errors path="confirmPassword"/>
              </td>
          </tr>

          <tr>
              <th><fmt:message key="user.fullName"/></th>
              <td>
                  <form:input path="fullName" maxlength="35"/>
                  <form:errors path="fullName"/>
              </td>
          </tr>

          <tr>
              <th><fmt:message key="common.submit"/></th>
              <td>
                  <input type="submit" name="create" value="<fmt:message key="common.submit"/> ">
                  <form:errors path="fullName"/>
              </td>
          </tr>



      </table>
  </form:form>

  </body>
</html>
