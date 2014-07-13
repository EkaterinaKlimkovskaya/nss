<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Numbers Saving System</title>
    <meta charset="utf-8">
	<link rel="shortcut icon" href="http://www.2develop.ru/favicon.ico">
    <link rel="stylesheet" href="styles/main.css" type="text/css" media="screen">
    <script type="text/javascript" src="scripts/jquery-1.6.min.js"></script>
    <script type="text/javascript" src="scripts/jquery.validate.min.js"></script>
    <script type="text/javascript" src="scripts/main.js"></script>
</head>
<body>
<div class="mainDiv" align="center">
    <form:form modelAttribute="addNumberForm" action="add_number" method="POST">
        <h3 class="inputNumber">Input number:</h3>
        <form:errors path="numberValue" cssClass="serverSideError"/>
        <form:input path="numberValue" class="numberValue"/>
        <input type="submit" value="Submit" class="submitButton"/>
    </form:form>
    <c:if test="${not empty numbersList}">
        <div align="center" class="valuesDiv">Values</div>
        <div align="center" class="tableDiv">
            <table>
                <c:forEach var="listValue" items="${numbersList}">
                    <tr>
                        <td>${listValue}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </c:if>
</div>
</body>
</html>
