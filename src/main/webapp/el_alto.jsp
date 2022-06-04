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
         <h1>MAPA DE EL ALTO</h1>
   <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d122386.80560221954!2d-68.2141949!3d-16.54690105!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x915edebe842e2473%3A0x3a1f8a2f17f89d8f!2sEl%20Alto!5e0!3m2!1ses!2sbo!4v1654312494740!5m2!1ses!2sbo" width="800" height="600" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
    
</center>
    

    </body>
</html>
