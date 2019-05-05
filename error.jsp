<%--
  Created by IntelliJ IDEA.
  User: pandi
  Date: 5/2/2019
  Time: 8:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<html>
<head>
    <title>Error Page</title>
</head>
<body>

<h2>In error page</h2>

<p> Caused By</p>

<%=  exception.getMessage() %>

</body>
</html>
