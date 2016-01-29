<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Détails d'une annonce - WebAppALDA</title>
	
	<link rel="stylesheet" type="text/css" href="http://normalize-css.googlecode.com/svn/trunk/normalize.css" />
	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="./css/app.css"/>
	
</head>
<body>
	<div class="container">
		<h1 class="title-form">Détails de l'annonce</h1>
		
<!-- 		<h3> -->
<%-- 		    <a href="#" onclick="showProfile(${sale.userId})"> --%>
<%-- 	    	    <c:out value="${sale.userFirstname} ${sale.userLastname}"/> --%>
<!-- 	        </a> -->
<!-- 	    </h3> -->
		
<!-- 		<h3> -->
<%-- 		    <a href="#" onclick="showProfile(${sale.userId})">${sale.username}</a> --%>
<!-- 	    </h3> -->
		<h3>Prix : ${sale.price}</h3>
		
		<h3>Type : ${sale.type}</h3>
		
		<h3>Surface : ${sale.surface}</h3>
		
		<h3>Adresse : ${sale.address}</h3>
		
		<h3>Ville : ${sale.city}</h3>
		
		<h3>Description : ${sale.description}</h3>
		
		<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
		  <ol class="carousel-indicators">
		    <c:forEach var="photo" items="${sale.photos}" varStatus="loopStatus">
		      <c:if test="${loopStatus.index == 0}">
		        <li data-target="#carousel-example-generic" data-slide-to="loopStatus.index" class="active"></li>
		      </c:if>
		      <c:if test="${loopStatus.index > 0}">
		        <li data-target="#carousel-example-generic" data-slide-to="loopStatus.index"></li>
		      </c:if>
		    </c:forEach>
		  </ol>

		  <div class="carousel-inner" role="listbox">
		    <c:forEach var="photo" items="${sale.photos}" varStatus="loopStatus">
			  <c:if test="${loopStatus.index == 0}">  
			    <div class="item active">
			      <img src="/assets/${photo.dir}" alt="Photo">
			    </div>
			  </c:if>
			  <c:if test="${loopStatus.index > 0}">
			    <div class="item">
			      <img src="/assets/${photo.dir}" alt="Photo">
			    </div>
			  </c:if>
		    </c:forEach>
		  </div>
		
		  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
		    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
		    <span class="sr-only">Précédente</span>
		  </a>
		  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
		    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
		    <span class="sr-only">Suivante</span>
		  </a>
		</div>
		
		<button class="btn btn-lg btn-primary" type="button" onclick="buy(${sale.id})">J'achète !</button>
	</div>
	
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
   	<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
   	<script type="text/javascript" src="./lib/cropper.min.js"></script>
   	<script type="text/javascript" src="./js/app.js"></script>
   	
   	<script type="text/javascript">
   	  var buy = function(saleId){
   		  //GET avec l'id en paramètre sur la servlet BuyStepOne. Va sur login si non-connecté
   	  }
   	  var showProfile = function(userId){
 		  //GET avec l'id en paramètre sur la servlet Profile. Va sur login si non-connecté
 	  }
   	</script>
</body>