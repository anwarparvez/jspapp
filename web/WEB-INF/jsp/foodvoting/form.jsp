<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Simple jsp page</title></head>
<body>
<form method="post" action="foodrating">
    <fieldset>
        <legend>
            <label><h1>Select Food</h1></label>
            <select name="food_id">
                <c:forEach var="food" items="${foodList}">
                    <option><c:out value="${food.foodName}"/></option>
                </c:forEach>

            </select>
            <input type="submit" value="vote">
        </legend>
    </fieldset>
</form>
</body>

</html>