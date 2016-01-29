<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Annonces suivies - WebAppALDA</title>
	
	<link rel="stylesheet" type="text/css" href="http://normalize-css.googlecode.com/svn/trunk/normalize.css" />
	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="./css/app.css"/>
	
</head>
<body>

	<jsp:include page="./topbar.jsp"></jsp:include>
	
	<div class="container">
		<h1 class="title-form">Annonces suivies</h1>
		
		<c:choose>
			<c:when test="${empty favoritesSales}">
				<h3 align="center">Vous ne suivez aucune annonce</h3>
				<h3 align="center"><a href="/">Voir toutes les annonces en ligne ?</a></h3>
			</c:when>
			<c:otherwise>
				<div class="col-xs-12 col-md-6" id="left-side">
	   				<c:forEach var="sale" items="${favoritesSales}" varStatus="loopStatusSale">
						<c:if test="${loopStatusSale.index % 2 == 0}">
						    <div class="row">
							    <div class="thumbnail">
							      <div id="carousel-example-generic-${loopStatusSale.index}" class="carousel slide" data-ride="carousel">
									  <ol class="carousel-indicators">
									    <c:forEach var="photo" items="${sale.photos}" varStatus="loopStatus">
									      <c:if test="${loopStatus.index == 0}">
									        <li data-target="#carousel-example-generic-${loopStatusSale.index}" data-slide-to="loopStatus.index" class="active"></li>
									      </c:if>
									      <c:if test="${loopStatus.index > 0}">
									        <li data-target="#carousel-example-generic-${loopStatusSale.index}" data-slide-to="loopStatus.index"></li>
									      </c:if>
									    </c:forEach>
									  </ol>
							
									  <div class="carousel-inner" role="listbox">
									    <c:forEach var="photo" items="${sale.photos}" varStatus="loopStatus">
										  <c:if test="${loopStatus.index == 0}">  
										    <div class="item active">
										      <img class="carousel-photo" src="/assets/${photo.dir}" alt="Photo">
										    </div>
										  </c:if>
										  <c:if test="${loopStatus.index > 0}">
										    <div class="item">
										      <img class="carousel-photo" src="assets/${photo.dir}" alt="Photo">
										    </div>
										  </c:if>
									    </c:forEach>
									  </div>
									
									  <a class="left carousel-control" href="#carousel-example-generic-${loopStatusSale.index}" role="button" data-slide="prev">
									    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
									    <span class="sr-only">Précédente</span>
									  </a>
									  <a class="right carousel-control" href="#carousel-example-generic-${loopStatusSale.index}" role="button" data-slide="next">
									    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
									    <span class="sr-only">Suivante</span>
									  </a>
								  </div>
							      <div class="caption">
							        <h3>Prix : ${sale.price}</h3>
									<h3>Type : ${sale.type}</h3>
									<h3>Surface : ${sale.surface}</h3>
									<h3>Adresse : ${sale.address}</h3>
									<h3>Ville : ${sale.city}</h3>
									<a type="button" class="btn btn-primary" href="DetailsAnnounce?saleid=${sale.id}">Voir en détails</a>
							      </div>
							    </div>
							</div>
						</c:if>
					</c:forEach>
				</div>
				
				<div class="col-xs-12 col-md-6" id="right-side">
					<c:forEach var="sale" items="${favoritesSales}" varStatus="loopStatusSale">
						<c:if test="${loopStatusSale.index % 2 != 0}">
						    <div class="row">
							    <div class="thumbnail">
							      <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
									  <ol class="carousel-indicators">
									    <c:forEach var="photo" items="${sale.photos}" varStatus="loopStatus">
									      <c:if test="${loopStatus.index == 0}">
									        <li data-target="#carousel-example-generic-${loopStatusSale.index}" data-slide-to="loopStatus.index" class="active"></li>
									      </c:if>
									      <c:if test="${loopStatus.index > 0}">
									        <li data-target="#carousel-example-generic-${loopStatusSale.index}" data-slide-to="loopStatus.index"></li>
									      </c:if>
									    </c:forEach>
									  </ol>
							
									  <div class="carousel-inner" role="listbox">
									    <c:forEach var="photo" items="${sale.photos}" varStatus="loopStatus">
										  <c:if test="${loopStatus.index == 0}">  
										    <div class="item active">
										      <img class="carousel-photo" src="/assets/${photo.dir}" alt="Photo">
										    </div>
										  </c:if>
										  <c:if test="${loopStatus.index > 0}">
										    <div class="item">
										      <img class="carousel-photo" src="assets/${photo.dir}" alt="Photo">
										    </div>
										  </c:if>
									    </c:forEach>
									  </div>
									
									  <a class="left carousel-control" href="#carousel-example-generic-${loopStatusSale.index}" role="button" data-slide="prev">
									    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
									    <span class="sr-only">Précédente</span>
									  </a>
									  <a class="right carousel-control" href="#carousel-example-generic-${loopStatusSale.index}" role="button" data-slide="next">
									    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
									    <span class="sr-only">Suivante</span>
									  </a>
								  </div>
							      <div class="caption">
							        <h3>Prix : ${sale.price}</h3>
									<h3>Type : ${sale.type}</h3>
									<h3>Surface : ${sale.surface}</h3>
									<h3>Adresse : ${sale.address}</h3>
									<h3>Ville : ${sale.city}</h3>
									<a type="button" class="btn btn-primary" href="DetailsAnnounce?saleid=${sale.id}">Voir en détails</a>
							      </div>
							    </div>
							</div>
						</c:if>
					</c:forEach>
				</div>
			</c:otherwise>
		</c:choose>	
	</div>
	
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
   	<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
   	<script type="text/javascript" src="./js/app.js"></script>
</body>