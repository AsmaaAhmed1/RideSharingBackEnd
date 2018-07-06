<%-- 
    Document   : newjsp
    Created on : Apr 28, 2018, 5:22:01 PM
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
        <title>Login Page</title>
    </head>
    <body style="background: azure; text-align: center; align-content: center">
        <br>
        <h1 style="color: red">Login</h1>
        <br>
        <br>
        <h1>${error}</h1>
        
        <br>
        <br>
        <form:form method="post" commandName="user">
                   <!--action="j_spring_security_check">-->
            
            UserName <form:input path="userName"/>
            
            <form:errors path="userName"/>
            <br>
            <br>
            
            Password <form:password path="password"  />
            <form:errors path="password"/>
            <br>
            <br>
            <input type="submit" value="Login" class="btn-default" />
            <!--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->
        </form:form>
    </body>
    <style>
        .error {
	color: #ff0000;
}

.errorblock{
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding:8px;
	margin:16px;
}
input[type=text], select {
    width: 50%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
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


input[type=password], select {
    width: 50%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

div {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
}
</style>
</html>
