<%
    if (session.getAttribute("login") != "OK") {
        response.sendRedirect("login.jsp");
    }
%>
<!DOCTYPE html>
<html lang="es">
    <head >
        <meta charset="UTF-8">
        <title>Geolocalizacion</title>
        <style>
            #map{
                margin: 20px;
            }
        </style>
    </head>
    <body >
    <CENTER><h1>UBICACION ACTUAL </h1>

        <button onclick="findMe()">Mostrar ubicación actual</button>
        <div id="map"></div>

        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCFLwwcZvcDF9J81GFtnoJXfJflg_NzGEs"></script>
        <script>

            function findMe() {
                var output = document.getElementById('map');
                // Verificar si soporta geolocalizacion
                if (navigator.geolocation) {
                    output.innerHTML = "<p>Tu navegador soporta Geolocalizacion</p>";
                } else {
                    output.innerHTML = "<p>Tu navegador no soporta Geolocalizacion</p>";
                }
                //Obtenemos latitud y longitud
                function localizacion(posicion) {
                    var latitude = posicion.coords.latitude;
                    var longitude = posicion.coords.longitude;
                    output.innerHTML = "<p>LATITUD:. " + latitude + "<br>LONGITUD:. " + longitude + "</p>";
                }
                function error() {
                    output.innerHTML = "<p>No se pudo obtener tu ubicación</p>";
                }
                navigator.geolocation.getCurrentPosition(localizacion, error);
            }
        </script>
        <div class="text-center">
            <img src=""https://www.google.com/imgres?imgurl=https%3A%2F%2Fd500.epimg.net%2Fcincodias%2Fimagenes%2F2015%2F10%2F29%2Flifestyle%2F1446136907_063470_1446137018_noticia_normal.jpg&imgrefurl=https%3A%2F%2Fcincodias.elpais.com%2Fcincodias%2F2015%2F10%2F29%2Flifestyle%2F1446136907_063470.html&tbnid=U0XYEyhcIy2BJM&vet=12ahUKEwjk5eim5pL4AhWTuZUCHUWoBQYQMygEegUIARDhAQ..i&docid=jwNkJZLoTSM17M&w=664&h=373&q=imagen%20de%20google%20maps&ved=2ahUKEwjk5eim5pL4AhWTuZUCHUWoBQYQMygEegUIARDhAQ" class="rounded" alt="" width="100" height="100">
        </div><br>
        <li>
            <a href="https://www.google.com.bo/maps/">ENTRA A GOOGLE MAPS I PON TU UBICACION 
            </a>
        </li>
        <br>
    </CENTER>
</body>
</html>
