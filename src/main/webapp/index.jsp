<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Index</title>

    <style>
        table{
            font-family: Arial, sans-serif;
            border-collapse: collapse;
            width: 50%;
        }

        td, th{
            border: 1px solid #ddd;
            text-align: left;
            padding: 8px;
        }

        tr:last-child(even){
            background: #fff;
        }
    </style>
</head>


<body>

<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Category</th>
    </tr>
    <c:forEach var="item" items="${products}">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.price}</td>
            <td>${item.quantity}</td>
            <td>${item.category}</td>
        </tr>
    </c:forEach>

    ${requestScope.message}
</table>
</body>
</html>