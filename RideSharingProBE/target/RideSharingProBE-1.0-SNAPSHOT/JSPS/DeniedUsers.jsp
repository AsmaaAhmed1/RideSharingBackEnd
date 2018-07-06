<%-- 
    Document   : PendingUsers
    Created on : Apr 28, 2018, 6:33:13 PM
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
        <title>Denied users Page</title>
    </head>

    <body style="text-align: center; align-content: center; background-color: azure">

        <h1> Denied Users <h1>
                <br>
                <h3 style="text-align: center;align-content: center">
                    <c:if test="${!empty User}">
                        
                            <table style="width: 100%">
                                <tr>
                                    <th>user Name </th> 
                                    <th>National ID</th>
                                    
                                    <th style="width: fit-content">Accept Users</th>
                                </tr>
                                <c:forEach var="i" begin="0" end="${DenyUsers.size()-1}">
                                    <tr>
                                        <td>${DenyUsers[i].userName}</td>
                                        <td>${DenyUsers[i].nationalid}</td>
                                        
                                        <td>
                                            <form action="Accept.htm" method="GET">
                                                <input type="hidden" name="id" value="${DenyUsers[i].idUser}"/>
                                                <input type="submit" value="Accept request"/>
                                            </form>

                                        </td>
                                    </tr>




                                </c:forEach>
                            </table>
                        <br>
                        <br>

                        <br>

                        <form action="SignOut.htm" method="GET" style="text-align: center">
                            <input type="submit" value="Sign Out" style="background-color: red; width: 50%"/>
                        </form>
                    </c:if>
                    <!--        <form action="login.htm" method="GET">
                                <input type="submit" value="SignIn"/>
                            </form>-->
                </h3>
                </body>
                <style>
                    table, th, td {
                        border: 1px solid black;
                    }
                    td{
                        width: 30%
                    }
                    h1 {
                        font-weight: bold;
                        color: red;
                        font-size: 50px;
                    }

                    input[type=submit] {

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
