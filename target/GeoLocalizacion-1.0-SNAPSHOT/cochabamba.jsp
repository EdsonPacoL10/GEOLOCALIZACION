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
         <h1>MAPA DE COCHABAMBA</h1>
         <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d121835.93283388905!2d-66.23391644365567!3d-17.393883068570975!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x93e373e0d9e4ab27%3A0xa2719ae9532c3e65!2sCochabamba!5e0!3m2!1ses!2sbo!4v1654312565260!5m2!1ses!2sbo" width="800" height="600" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
    </center>
    

    </body>
</html>
