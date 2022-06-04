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
         <h1>MAPA DE SUCRE</h1>
      <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d120703.45301791636!2d-65.32983305828006!3d-19.020474863457014!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x93fbc8bc8187832f%3A0xbd9df259af1bee96!2sSucre!5e0!3m2!1ses!2sbo!4v1654312934404!5m2!1ses!2sbo" width="800" height="600" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
    </center>
        
    </body>
</html>
