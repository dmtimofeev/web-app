<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <title>Какая-то таблица данных</title>
        <meta http-equiv="Content-Type" content="text/html">
        <link rel="stylesheet" href="../css/table2.css" media="screen" type="text/css"/>
    </head>
    <body>
        <c:if test="${empty username}">
            <h1>Привет, аноним</h1>
        </c:if>
        <c:if test="${not empty username}">
            <h1>Привет, ${username}</h1>
        </c:if>
        <table>
            <caption>
                Заголовок какой-то таблицы
            </caption>
            <tr>
                <th>Наименование</th>
                <th>Кол-во шт.</th>
                <th>Цена, руб.</th>
                <th>Сумма, руб.</th>
            </tr>
            <c:forEach var="entry" items="${data}">
                <tr>
                    <td>${entry.name}</td>
                    <td>${entry.count}</td>
                    <td><fmt:formatNumber value = "${entry.price}" type = "currency"/></td>
                    <td><fmt:formatNumber value = "${entry.count * entry.price}" type = "currency"/></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
