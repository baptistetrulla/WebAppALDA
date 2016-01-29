<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-default navbar-static-top">
  <div class="container" style="background-color: #f8f8f8;">
    <div class="navbar-header">
      <a class="navbar-brand" href="/Index">
        <img class="home-icon" alt="Accueil" src="./assets/home.svg">
      </a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Application<span class="caret"></span></a>
          <c:choose>
            <c:when test="${not empty userID}">
	          <ul class="dropdown-menu" id="connected-user">
	            <li><a href="CreateAnnounceServlet">Créer une annonce</a></li>
	            <li><a href="#" onclick="showProfile(${user.id})">Mes annonces</a></li>
	            <li><a href="#" onclick="showFavorites(${user.id})">Mes favoris</a></li>
	            <li><a href="#" onclick="showMessages()">Mes messages</a></li>
	            <li><a href="#" onclick="showNotifications()">Mes notifications</a></li>
	            <li><a href="/Account">Mon compte</a></li>
	            <li role="separator" class="divider"></li>
	            <li><a href="/Logout">Se déconnecter</a></li>
	          </ul>
	        </c:when>
	        <c:otherwise>
	          <ul class="dropdown-menu" id="non-connected-user">
	            <li><a href="/Login">Se connecter</a></li>
	          </ul>
	        </c:otherwise>
          </c:choose>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div>
</nav>