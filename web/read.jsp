<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>The family</title>
    </head>
    <% String table = (String) request.getAttribute("table");%>
    <body>
        <h1>Kate's Family</h1>
        <%= table %>
    </body>
</html>
