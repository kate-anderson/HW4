<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Family" %>
<% Family fam = (Family) request.getAttribute("family"); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update a Family Member</title>
        <link rel="stylesheet" type="text/css" href="style.css" />
    </head>
    <body>
        <div class="wrap"> <!-- div to hold all other divs -->
            <%@ include file="includes/header.jsp" %>
            <%@ include file="includes/menu.jsp" %>

            <div class="main"> <!-- main div -->
                <div class="addForm">
                    <h1>Update a Family Member Record</h1>
        
                    <form name="updateForm" action="updateFamily" method="get">
                        <label>Family Member's ID:</label>
                        <input type='text' name="id" value="<%= fam.getFamilyID() %>" readonly/>
                        <br>
                        <label>Family Member's Name:</label>
                        <input type='text' name="name" value="<%= fam.getFamMemName() %>"/>
                        <br>
                        <label>Age:</label>
                        <input type='text' name="age" value="<%= fam.getAge() %>"/>
                        <br>
                        <label>Birthday:</label>
                        <input type='text' name="birthday" value="<%= fam.getBirthday() %>"/>
                        <br>
                        <label>Relation to Kate:</label>
                        <input type='text' name="relation" value="<%= fam.getRelation() %>"/>
                        <br>
                        <input type="submit" name='submit' value="Update"/>
                    </form>
                </div>
            </div><!-- close main div -->
            
            <%@ include file="includes/footer.jsp" %>
        </div><!-- close wrap div -->
    </body>
</html>
