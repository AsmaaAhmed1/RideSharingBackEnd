<%-- 
    Document   : hello
    Created on : Mar 29, 2018, 6:14:10 PM
    Author     : TECHNOLOGY CITY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="text-align: center; align-content: center; background-color: azure">
        <c:if test="${!empty User}">

            <br>
            <br>
            <h1 style="color: red; ">Hello ${User.userName}</h1>
            <br>
            <br>
            <br>
            <form action="pending.htm" method="GET">
                <input type="submit" value="Pending Users" style="appearance: button;"/>
                <p style="color: red">${noUsers} </p>
            </form>

            <br>
            <form action="DeniedUsers.htm" method="GET">
                <input type="submit" value="Denied Users"/>
                <p style="color: red">${noDeniedUsers} </p>
            </form>
            <br>
            <br>
            <br>
             <form action="SignOut.htm" method="GET">
                 <input type="submit" value="Sign Out" style="background-color: red"/>
            </form>

        </c:if>
            
    </body>
    <style>
        h1 {
  font-weight: bold;
  color: #fff;
  font-size: 50px;
}

input[type=submit] {
    width: 50%;
    background-color: #4CAF50;
    color: white;
    padding: 16px 20px;
    margin: 9px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #45a049;
}

    </style>
</html>
