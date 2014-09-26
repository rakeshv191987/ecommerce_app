<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Registration Page</title>
</head>
<body>

<form:form method="POST" modelattribute="customer">
<table>
	<tr>
        <td>First Name :</td>
        <td><form:input path="first" /></td>
    </tr>
    <tr>
        <td>Last Name :</td>
        <td><form:input path="last" /></td>
    </tr>
    <tr>
        <td>Gender :</td>
        <td>
        	<form:radiobutton path="gender" value="M" label="M" /> 
            <form:radiobutton path="gender" value="F" label="F" />
        </td>
    </tr>
    <tr>
        <td>E-mail Address :</td>
        <td><form:input path="email" /></td>
    </tr>
    <tr>
        <td>Password :</td>
        <td><form:password path="password" /></td>
    </tr>
    <tr>
        <td>Phone Number :</td>
        <td><form:input path="phone" /></td>
    </tr>
    <tr>
        <td>Address Line 1 :</td>
        <td><form:input path="address1" /></td>
    </tr>
    <tr>
        <td>Address Line 2 :</td>
        <td><form:input path="address2" /></td>
    </tr>
    <tr>
        <td>City :</td>
        <td><form:input path="city" /></td>
    </tr>
    <tr>
        <td>Country :</td>
        <td>
        <form:select path="country">
            <form:option value="0" label="Select" />
            <form:option value="1" label="USA" />
            <form:option value="2" label="UK" />
            <form:option value="3" label="India" />
        </form:select></td>
    </tr>
    <tr>
        <td>Zip Code :</td>
        <td><form:input path="zip" /></td>
    </tr>
    <tr>
        <td>About you :</td>
        <td><form:textarea path="aboutYou" /></td>
    </tr>
    
    <tr>
        <td colspan="2"><input type="submit" value="Submit"></td>
    </tr>
    <tr>
        <td colspan="2"><input type="reset" value="Reset"></td>
    </tr>
</table>
</form:form>

</body>
</html>