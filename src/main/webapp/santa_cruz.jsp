
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
         <h1>MAPA DE SANTA CRUZ</h1>
         <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d486366.9809721178!2d-63.291835141030084!3d-17.756789844670543!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x93f1e81ca7c01a63%3A0x5c8b0a53a467611b!2sSanta%20Cruz%20de%20la%20Sierra!5e0!3m2!1ses!2sbo!4v1654312693734!5m2!1ses!2sbo" width="800" height="600" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
    </center>
        </body>
</html>
