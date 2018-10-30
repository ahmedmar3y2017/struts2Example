<%--
  Created by IntelliJ IDEA.
  User: ahmed.marey
  Date: 10/25/2018
  Time: 10:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<html>
<head>
    <title>Title</title>


    <STYLE type="text/css">
        .errorMessage {
            color: red;
        }
    </STYLE>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="css.css">

</head>

<body>
<s:actionerror/>

<h3 style="color: blue; align-content: center; alignment: center;"><s:property value="MessageLogin"></s:property>
</h3>
<s:form action="login">

    <s:div cssClass="container center-pill">

        <s:div cssClass="form-group">
            <s:textfield label="Email  " key="user.email" cssClass="form-control" placeholder="Email"></s:textfield>

        </s:div>
        <s:div cssClass="form-group">
            <s:password label="Password  " key="user.password" cssClass="form-control"
                        placeholder="Password"></s:password>
        </s:div>

        <s:div cssClass="form-group">
            <button type="submit" class="btn btn-primary">Login</button>
            <%--<d:submit validate="true" cssClass="btn btn-primary"  type="image" ></d:submit>--%>

        </s:div>


    </s:div>


</s:form>

<a href="signUp.jsp">Create New Account </a>


</body>
</html>
