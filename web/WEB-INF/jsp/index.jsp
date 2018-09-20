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
            <li class="nav-item active">
              <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item">
              <a class="nav-link disabled" href="#">Disabled</a>
            </li>
          </ul>
          <form class="form-inline mt-2 mt-md-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Buscar" aria-label="Buscar">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
          </form>
        </div>
      </nav>
    </header>

    <main role="main">

      <div id="SocialWebCarousel" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#SocialWebCarousel" data-slide-to="0" class="active"></li>
          <li data-target="#SocialWebCarousel" data-slide-to="1"></li>
          <li data-target="#SocialWebCarousel" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img class="first-slide" src="${pageContext.request.contextPath}/img/carousel01.jpeg" alt="X">
            <div class="container">
              <div class="carousel-caption text-left">
                <h1>T&iacute;tulo de art&iacute;culo</h1>
                <p>Resumen del contenido del art&iacute;culo</p>
                <p><a class="btn btn-lg btn-primary" href="#" role="button">Ver detalle de art&iacute;culo &raquo</a></p>
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <img class="second-slide" src="${pageContext.request.contextPath}/img/carousel02.jpeg" alt="X">
            <div class="container">
              <div class="carousel-caption">
                <h1>T&iacute;tulo de art&iacute;culo</h1>
                <p>Resumen del contenido del art&iacute;culo</p>
                <p><a class="btn btn-lg btn-primary" href="#" role="button">Ver detalle de art&iacute;culo &raquo</a></p>
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <img class="third-slide" src="${pageContext.request.contextPath}/img/carousel03.jpeg" alt="X">
            <div class="container">
              <div class="carousel-caption text-right">
                <h1>T&iacute;tulo de art&iacute;culo</h1>
                <p>Resumen del contenido del art&iacute;culo</p>
                <p><a class="btn btn-lg btn-primary" href="#" role="button">Ver detalle de art&iacute;culo &raquo</a></p>
              </div>
            </div>
          </div>
        </div>
        <a class="carousel-control-prev" href="#SocialWebCarousel" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#SocialWebCarousel" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>

      <div class="container marketing">

        <hr class="featurette-divider">

        <div class="row">
          <div class="col-lg-4">
            <img class="rounded-left rounded-right" src="${pageContext.request.contextPath}/img/featurette01.jpeg" alt="X" width="140" height="140">
            <h2>T&iacute;tulo de art&iacute;culo</h2>
            <p>Resumen del contenido del art&iacute;culo. Aqu&iacute; se deber&iacute;a colocar un <b>resumen del art&iacute;culo</b> que no lleve mas de <b>trescientos caracteres</b>. Con el objetivo de hacer una introducci&oacute;n al mismo y lograr un buen estructurado del contenido del sitio Web.</p>
            <p><a class="btn btn-secondary" href="#" role="button">Ver detalles &raquo;</a></p>
          </div>
          <div class="col-lg-4">
            <img class="rounded-circle" src="${pageContext.request.contextPath}/img/featurette02.jpeg" alt="X" width="140" height="140">
            <h2>T&iacute;tulo de art&iacute;culo</h2>
            <p>Resumen del contenido del art&iacute;culo. Aqu&iacute; se deber&iacute;a colocar un <b>resumen del art&iacute;culo</b> que no lleve mas de <b>trescientos caracteres</b>. Con el objetivo de hacer una introducci&oacute;n al mismo y lograr un buen estructurado del contenido del sitio Web.</p>
            <p><a class="btn btn-secondary" href="#" role="button">Ver detalles &raquo;</a></p>
          </div>
          <div class="col-lg-4">
            <img class="rounded-left rounded-right" src="${pageContext.request.contextPath}/img/featurette03.jpeg" alt="X" width="140" height="140">
            <h2>T&iacute;tulo de art&iacute;culo</h2>
            <p>Resumen del contenido del art&iacute;culo. Aqu&iacute; se deber&iacute;a colocar un <b>resumen del art&iacute;culo</b> que no lleve mas de <b>trescientos caracteres</b>. Con el objetivo de hacer una introducci&oacute;n al mismo y lograr un buen estructurado del contenido del sitio Web.</p>
            <p><a class="btn btn-secondary" href="#" role="button">Ver detalles &raquo;</a></p>
          </div>
        </div><

        <hr class="featurette-divider">

        <div class="row featurette">
          <div class="col-md-7">
            <h2 class="featurette-heading">T&iacute;tulo de art&iacute;culo. <span class="text-muted">Subt&iacute;tulo.</span></h2>
            <p class="lead">Detalle del contenido del art&iacute;culo. Aqu&iacute; se deber&iacute;a colocar <b>el art&iacute;culo</b>, siendo el mismo de no mas de <b>cinco mil</b>. Con el objetivo de desarrollar el un tema brevemente y lograr un buen estructurado del contenido del sitio Web.</p>
          </div>
          <div class="col-md-5">
            <iframe width="500" height="500" src="https://www.youtube.com/embed/GOUXDZM1oeg" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
          </div>
        </div>

        <hr class="featurette-divider">

        <div class="row featurette">
          <div class="col-md-7 order-md-2">
            <h2 class="featurette-heading">T&iacute;tulo de art&iacute;culo. <span class="text-muted">Subt&iacute;tulo.</span></h2>
            <p class="lead">Detalle del contenido del art&iacute;culo. Aqu&iacute; se deber&iacute;a colocar <b>el art&iacute;culo</b>, siendo el mismo de no mas de <b>cinco mil</b>. Con el objetivo de desarrollar el un tema brevemente y lograr un buen estructurado del contenido del sitio Web.</p>
          </div>
          <div class="col-md-5 order-md-1">
            <img class="featurette-image img-fluid mx-auto" src="${pageContext.request.contextPath}/img/sw.png" alt="X">
          </div>
        </div>

        <hr class="featurette-divider">

        <div class="row featurette">
          <div class="col-md-7">
            <h2 class="featurette-heading">T&iacute;tulo de art&iacute;culo. <span class="text-muted">Subt&iacute;tulo.</span></h2>
            <p class="lead">Detalle del contenido del art&iacute;culo. Aqu&iacute; se deber&iacute;a colocar <b>el art&iacute;culo</b>, siendo el mismo de no mas de <b>cinco mil</b>. Con el objetivo de desarrollar el un tema brevemente y lograr un buen estructurado del contenido del sitio Web.</p>
          </div>
          <div class="col-md-5">
            <iframe width="500" height="500" src="https://www.youtube.com/embed/qR48DCXYFRI" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
          </div>
        </div>

        <hr class="featurette-divider">

      </div>

      <footer class="container">
        <p class="float-right"><a href="#">Ir al comienzo</a></p>
        <p>&copy; 2017-2018 SocialWeb &middot; <a href="#">Privacidad</a> &middot; <a href="#">T&eacute;rminos de uso</a></p>
      </footer>

    </main>

  </body>
</html>