<%-- 
    Document   : perfil
    Created on : Oct 9, 2017, 6:53:21 PM
    Author     : luka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/iniciocss.css"/> ">
        <title>Perfil</title>
    </head>
    <body>
        
        <div class="contenedor">
            <header>
                <form action ="/Marcadores/inicio" style="display:inline"> 
                    <button id="btnIni" class="btn btn-primary btn-lg" >Inicio</button>
                </form>
                <form action="/Marcadores/agregaMarcador" style="display:inline"> 
                    <button id="btnAgr" class="btn btn-primary btn-lg" >Agrega un marcador</button>
                </form>
                <form action ="/Marcadores/logout" style="display:inline"> 
                    <button id="btnCer" class="btn btn-primary btn-lg" >Cerrar Sesión</button>
                </form> 
            </header>
            <section class="main">
                <div class="row"> 
                    <div class="col-md-12">
                        <hr>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <h1 class="mb-5">
                            Perfil
                        </h1>                        
                    </div>
                </div>
                <div class="row"> 
                    <div class="col-md-12">
                        <hr>
                    </div>
                </div>
                <div class="row" style="background-color: #2aa52c; height: 50px; margin: 15px;">
                    <div class="col-md-6">
                        <div class="mw-100">
                            Nombre
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="mw-100">
                            ${nombre}
                        </div>
                    </div>
                </div>
                <div class="row" style="background-color: #2aa52c; height: 50px; margin: 15px;">
                    <div class="col-md-6">
                        <div class="mw-100">
                            Correo
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="mw-100">
                            ${correo}
                        </div>
                    </div>
                </div>
            </section>
            
            <aside>
                <h1>
                    Tus marcadores
                </h1>
                <table class="table">
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Latitud</th>
                            <th>Longitud</th>
                            <th>Actualiza</th>
                        </tr>
                    </thead>
                    <c:forEach var="m" items="${marcadores}">
                        <tbody>
                            <th>${m.getVarNombreM()}</th>
                            <th>${m.getVarLatitud()}</th>
                            <th>${m.getVarLongitud()}</th>
                            <th>
                                <form action="/Marcadores/actualizaM" method="GET">
                                    <input id="latitud" name="latitud" hidden="true" value="${m.varLatitud}">
                                    <input id="longitud" name="longitud" hidden="true" value="${m.varLongitud}">
                                    <button type="submit" class="btn btn-primary btn-lg active">Actualiza</button>
                                </form> 
                            </th>
                       </tbody>

                    </c:forEach>
                </table>
            
            </aside>
         </div>
        
        <!-- Latest compiled and minified JavaScript -->
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/perfil.js"></script>
        
    </body>
</html>
