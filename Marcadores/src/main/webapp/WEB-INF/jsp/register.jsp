<%-- 
    Document   : register
    Created on : Oct 9, 2017, 3:57:48 PM
    Author     : luka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Signup / Registration form using Material Design - Demo by W3lessons</title>
  <!-- CORE CSS-->
  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/css/materialize.min.css">

<style type="text/css">
html,
body {
    height: 100%;
}
html {
    display: table;
    margin: auto;
}
body {
    display: table-cell;
    vertical-align: middle;
}
.margin {
  margin: 0 !important;
}
</style>
  
</head>

<body class="blue">


  <div id="login-page" class="row">
    <div class="col s12 z-depth-6 card-panel">
        <div class="row">
          <div class="input-field col s12 center">
            <p class="center login-form-text">Ingresa tus datos</p>
          </div>
        </div>
         <form action="/Marcadores/guardaUsuario" method="GET">
        <div class="row margin">
          <div class="input-field col s12">
            <i class="mdi-social-person-outline prefix"></i>
            <input name="nick" id="nick" type="text" class="validate">
            <label for="nick" class="center-align">Nick</label>
          </div>
        </div>
        <div class="row margin">
          <div class="input-field col s12">
            <i class="mdi-communication-email prefix"></i>
            <input name="email" id="email" type="email" class="validate">
            <label for="email" class="center-align">E-mail</label>
          </div>
        </div>
        <div class="row margin">
          <div class="input-field col s12">
            <i class="mdi-action-lock-outline prefix"></i>
            <input name="password" id="password" type="password" class="validate">
            <label for="password">Contrasena</label>
          </div>
        </div>
        <div class="row margin">
          <div class="input-field col s12">
            <i class="mdi-action-lock-outline prefix"></i>
            <input name="password-conf" id="password-conf" type="password">
            <label for="password-conf">Confirma Contraseña</label>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s12">
            <button type="submit" class="btn btn-primary btn-lg active">¡Registrate!</button>
          </div>
            </form>
            <form action="/Marcadores/" >
            <div class="input-field col s12">
                <p class="margin center medium-small sign-up">¿Ya tienes una cuenta? <button type="submit" class="btn btn-primary btn-lg active">Login</button></p>
            </div>
            </form>
        </div>
    </div>
  </div>


  <center>
<!-- Post Page - Responsive -->
<ins class="adsbygoogle"
     style="display:inline-block;width:300px;height:250px"
     data-ad-client="ca-pub-5104998679826243"
     data-ad-slot="3470684978"></ins>
<script>
(adsbygoogle = window.adsbygoogle || []).push({});
</script>
</center>

  <!-- ================================================
    Scripts
    ================================================ -->

  <!-- jQuery Library -->
 <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <!--materialize js-->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/js/materialize.min.js"></script>



  <script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-27820211-3', 'auto');
  ga('send', 'pageview');

</script>

   <footer class="page-footer">
          <div class="footer-copyright">
            <div class="container">
            © Luka Schnauzer
            <a class="grey-text text-lighten-4 right">Juan Carlos Montero Santiago</a>
            </div>
          </div>
  </footer>
</body>

</html>