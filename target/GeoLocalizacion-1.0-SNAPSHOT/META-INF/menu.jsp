<%
    String opcion = request.getParameter("opcion");
%>
    <header>
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="#">GEOLOCALIZACION</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarCollapse">
                    <ul class="navbar-nav me-auto mb-2 mb-md-0">
                        <li class="nav-item">
                            <a class="nav-link <%=  (opcion.equals("Desaparecido")) ? "active" : "" %>" aria-current="page" href="DesaparecidoControlador">Desaparecido</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link <%=  (opcion.equals("Informacion")) ? "active" : "" %>" href="InformacionControlador">Informacion</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link <%=  (opcion.equals("Usuario")) ? "active" : "" %>" href="UsuarioControlador">Usuarios</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link <%=  (opcion.equals("Mi Ubicacion")) ? "active" : "" %>" href="mapa.jsp">Mapa</a>
                        </li>
                         <li class="nav-item">
                            <a class="nav-link <%=  (opcion.equals("La Paz")) ? "active" : "" %>" href="la_paz.jsp">La Paz</a>
                        </li>
                         <li class="nav-item">
                            <a class="nav-link <%=  (opcion.equals("El Alto")) ? "active" : "" %>" href="el_alto.jsp">El Alto</a>
                        </li>
                         <li class="nav-item">
                            <a class="nav-link <%=  (opcion.equals("Cochabamba")) ? "active" : "" %>" href="cochabamba.jsp">Cochabamba</a>
                        </li>
                         <li class="nav-item">
                            <a class="nav-link <%=  (opcion.equals("Santa Cruz")) ? "active" : "" %>" href="santa_cruz.jsp">Santa Cruz</a>
                        </li>
                         <li class="nav-item">
                            <a class="nav-link <%=  (opcion.equals("Sucre")) ? "active" : "" %>" href="sucre.jsp">Sucre</a>
                        </li>
                    </ul>
                    <a href="LoginControlador?action=logout" class="btn btn-outline-success">Cerrar sesión</a>
                </div>
            </div>
        </nav>
    </header>

