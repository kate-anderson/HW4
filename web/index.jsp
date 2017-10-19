<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kate's Family</title>
        <link rel="stylesheet" type="text/css" href="style.css" />
    </head>
    <body>
        <div class="wrap"> <!-- div to hold all other divs -->
            <%@ include file="includes/header.jsp" %>
            <%@ include file="includes/menu.jsp" %>

            <div class="main"> <!-- main div -->
                <h1>Kate's Family Database</h1>
        
                <a href="read" class='link'>Meet the family!</a>
                <br>
                <a href="search" class='link'>Search the family!</a>
                <br><br>
            </div><!-- close main div -->
            
            <%@ include file="includes/footer.jsp" %>
        </div><!-- close wrap div -->
    </body>
</html>
