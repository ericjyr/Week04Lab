<%-- 
    Document   : viewnote
    Created on : 14-Jan-2023, 8:57:50 PM
    Author     : ericr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Note - View</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <p><strong>Title:</strong> ${note.title}</p>
        <p><strong>Contents:</strong> ${note.content}</p>
        <a href="note?page=edit">Edit</a>
    </body>
</html>
