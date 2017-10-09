<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a New Family Member</title>
    </head>
    <body>
        <h1>Add a New Family Member</h1>
        
        <form name="addForm" action="addFamily" method="get">
            <label>Family Member's Name:</label>
            <input type='text' name="name" value=""/>
            <br>
            <label>Age:</label>
            <input type='text' name="age" value=""/>
            <br>
            <label>Birthday:</label>
            <input type='text' name="birthday" value=""/>
            <br>
            <label>Relation to Kate:</label>
            <input type='text' name="relation" value=""/>
            <br>
            <input type="submit" name='submit' value="Submit"/>
        </form>
    </body>
</html>
