<%-- 
    Document   : editnote
    Created on : 14-Jan-2023, 8:58:19 PM
    Author     : ericr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Note - Edit</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        
        <form method="post" action="note?page=view">
            Title: 
            <input type="text" name="title" value="${note.title}"><br>
            Contents: 
            <textarea rows="5" cols="25" value="${note.content}"></textarea><br>
            <input type="submit" value="Save">
        </form>

    </body>
</html>
