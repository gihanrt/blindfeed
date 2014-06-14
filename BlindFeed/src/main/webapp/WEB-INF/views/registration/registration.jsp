<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>
    <div align="center">
        <form:form action="regProcess" method="post"  commandName="form">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>BlindFeed - Registration</h2></td>
                </tr>
                <tr>
                    <td>First Name:</td>
                    <td><form:input path="FName" /></td>
                </tr>
                <tr>
                
                <tr>
                    <td>Last Name:</td>
                    <td><form:input path="LName" /></td>
                </tr>
                
                <tr>
                    <td>Age:</td>
                    <td><form:input path="Age" /></td>
                </tr>
                <tr>
                    <td>E-Mail:</td>
                    <td><form:input path="EMail" /></td>
                </tr>
                <tr> 
                    <td>Country:</td>
                    <td><form:input path="Country" /></td>
                </tr>
                <tr>
                    <td>Language:</td>
                    <td><form:input path="Language" /></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><form:password path="Password" /></td>
                </tr>
                <tr>
                	<td><input type="submit" value="Register" /></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>