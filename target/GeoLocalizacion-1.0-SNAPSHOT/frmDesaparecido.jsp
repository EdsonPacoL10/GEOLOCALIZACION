<%
    if (session.getAttribute("login") != "OK") {
        response.sendRedirect("login.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet">
        <title>GEOLOCALIZACION</title>
    </head>
    <body>
        <jsp:include page="META-INF/menu.jsp">
            <jsp:param name="opcion" value="Desaparecido"/>
        </jsp:include>        
        <div class="container" >
            <h1>Formulario De Personas Desaparecidas</h1><br>
            <form action="DesaparecidoControlador" method="post" >
                <input type="hidden" name="id" value="${desaparecido.id}" >
                <div class="mb-3">
                    <label for="nombre" class="form-label">Nombre</label>
                    <input type="text"  name="nombre" value="${desaparecido.nombre}" class="form-control" id="nombre" placeholder="Escriba el nombre">                    
                </div>
                <div class="mb-3">
                    <label for="apellido" class="form-label">Apellido</label>
                    <input type="text"  name="apellido" value="${desaparecido.apellido}" class="form-control" id="apellido" placeholder="Escriba el apellido">                    
                </div>
                <div class="mb-3">
                    <label for="edad" class="form-label">Edad</label>
                    <input type="number" name="edad" value="${desaparecido.edad}" class="form-control" id="edad" placeholder="Escriba la edad">
                </div>
                <div class="mb-3">
                    <label for="sexo" class="form-label">Sexo</label>
                    <input type="text" class="form-control" name="sexo" value ="${participante.sexo}"placeholder="Masculino - Femenino">
                </div>

                <div class="mb-3">
                    <label for="descripcion" class="form-label">Descripción</label>
                    <input type="text" name="descripcion" value="${desaparecido.descripcion}" class="form-control" id="descripcion" placeholder="Dar una descripcion de la persona">
                </div>
                <div class="mb-3">
                    <label for="fecha" class="form-label">Fecha</label>
                    <input type="text" name="fecha" value="${desaparecido.fecha}" class="form-control" id="fecha" placeholder="Dar fecha que desaparecio">
                </div>
                <button type="submit" class="btn btn-primary">Procesar</button>
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
