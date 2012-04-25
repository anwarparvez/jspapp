<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Simple jsp page</title></head>
<body>
<form method="post" action="vote">
    <fieldset>
        <legend><h2>Food Voting </h2></legend>

        <label>Select Food</label>
        <select name="food_id">
            <c:forEach var="food" items="${foodList}">
                <option value="${food.foodId}"><c:out value="${food.foodName}"/></option>
            </c:forEach>

        </select>
        <br>
        <input type="submit" value="vote">

    </fieldset>
</form>
</body>

</html>