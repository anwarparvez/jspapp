<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Simple jsp page</title></head>
<body>
<link
        href="star/rating_simple.css"
        rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="star/rating_simple.js"></script>
<form method="post" action="vote">
    <fieldset>
        <legend><h2>Food Voting </h2></legend>

        <table border="1" >
            <tbody>
            <tr>
                <td>Food Name</td>
                <td>Vote</td>
            </tr>
            <c:forEach var="food" items="${foodList}">
                <tr>
                    <td>${food.foodName}</td>
                    <td><input name="food_vote" value="" id="rating_${food.foodName}" type="hidden"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <option value="${food.foodId}"><c:out value="${food.foodName}"/></option>
        <br>
        <input type="submit" value="vote">
    </fieldset>

</form>
<script language="javascript" type="text/javascript">
    function test(value) {
        alert("This rating's value is " + value);
    }

    $(function() {
        <c:forEach var="food" items="${foodList}">
        $("#rating_${food.foodName}").webwidget_rating_simple({
            rating_star_length: '5',
            rating_initial_value: '3',
            rating_function_name: '',//this is function name for click
            directory: 'star/'
        });
        </c:forEach>

    });
</script>
</body>

</html>