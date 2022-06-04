<%
if(session.getAttribute("login")!="OK"){
    response.sendRedirect("login.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GEOLOCALIZACION</title>
    </head>
    <body>
    <center>
        <h1>MAPA DE LA PAZ</h1>
        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d122403.52463584201!2d-68.19411841161217!3d-16.52053609685929!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x915edf0a04f5a40f%3A0x57dbfc76b4458ab3!2sLa%20Paz!5e0!3m2!1ses!2sbo!4v1654307216174!5m2!1ses!2sbo" width="800" height="600" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
</center>    
</body>
</html>
