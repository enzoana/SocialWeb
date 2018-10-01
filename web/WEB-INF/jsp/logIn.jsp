<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>

    <meta charset="utf-8">
    <!-- Tag para hacer responsive la aplicacion -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/carousel.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/holder.min.js"></script>

    <title>SocialWeb</title>
  </head>
  <body>

    <header>
      <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <img class="first-slide" src="${pageContext.request.contextPath}/img/sw32x32.png" alt="X">
        &nbsp;
        <a class="navbar-brand" href="#">SocialWeb</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="empresas" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Empresas</a>
              <div class="dropdown-menu" aria-labelledby="empresas">
                <a class="dropdown-item" href="#">Empresa 01</a>
                <a class="dropdown-item" href="#">Empresa 02</a>
                <a class="dropdown-item" href="#">Empresa 03</a>
              </div>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Servicios</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Productos</a>
            </li>
          </ul>
          <form class="form-inline mt-2 mt-md-0">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit"><img src="${pageContext.request.contextPath}/img/logIn.png" alt="X"/></button>
          </form>
        </div>
      </nav>
    </header>

    <main role="main">

      <div>
        <br/><br/><br/>
      </div>

      <div class="container marketing">

        <div class="row">
          <div class="col-lg-12">
            <hr class="featurette-divider">
          </div>
        </div>

        <div class="row">
          <div class="col-lg-4">
            &nbsp;
          </div>
          <div class="col-lg-4 text-center">
            <img src="${pageContext.request.contextPath}/img/logIn512.png" alt="X"/>
            <form class="form-signin" action="login.do" method="post">
              <h1 class="h3 mb-3 font-weight-normal">Iniciar sesi&oacute;n</h1>
              <label for="email" class="sr-only">Direcci&oacute; de correo electr&oacute;nico</label>
              <input type="email" id="email" name="email" class="form-control" placeholder="Correo electr&oacute;nico" required autofocus>
              <label for="password" class="sr-only">Contrase&ntilde;a</label>
              <input type="password" id="password" name="password" class="form-control" placeholder="Contrase&ntilde;a" required>
              <div class="checkbox mb-3">
                <label>
                    <input type="checkbox" value="remember-me">&nbsp;Recordarme
                </label>
              </div>
              <button class="btn btn-lg btn-primary btn-block" type="submit"><img class="first-slide" src="${pageContext.request.contextPath}/img/signInWhite.png" alt="Ver detalle"></button>
            </form>
          </div>
          <div class="col-lg-4">
            &nbsp;
          </div>
        </div>

        <div class="row">
          <div class="col-lg-12">
            <hr class="featurette-divider">
          </div>
        </div>

      </div>

    </main>

    <footer class="container">
      <p class="float-right"><a href="#">Ir al comienzo</a></p>
      <p>&copy; 2017-2018 SocialWeb &middot; <a href="#">Privacidad</a> &middot; <a href="#">T&eacute;rminos de uso</a></p>
    </footer>

  </body>
</html>