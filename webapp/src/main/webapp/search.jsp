<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Ventes globales - WebAppALDA</title>
	
	<link rel="stylesheet" type="text/css" href="http://normalize-css.googlecode.com/svn/trunk/normalize.css" />
	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="./css/app.css"/>
	
</head>
<body>
	<div class="container">
		<h1 class="title-form">Ventes globales</h1>
		
		<form method="POST" id="search-form" class="form-inline" action="/SearchWithCriteriaServlet">
		    <div class="form-group">
				<label for="selectPrice">Prix : </label>
				<select class="form-control" id="selectPrice" name="selectPrice">
				  <c:forEach var="i" begin="0" end="49">
				    <c:set var="j" value="${i + 1}"></c:set>
				    <option value="${i}"><c:out value="${i * 25000}"></c:out> à <c:out value="${j * 25000}"></c:out></option>
				  </c:forEach>
				  <option value="50">+ de 1250000</option>
				</select>
			</div>
			<div class="form-group">
				<label for="selectType">Type : </label>
				<select class="form-control" id="selectType" name="selectType">
					<option value="villa">Villa</option>
				    <option value="maison">Maison</option>
				    <option value="studio">Studio</option>
				    <option value="t2">T2</option>
				    <option value="t3">T3</option>
				    <option value="t4">T4</option>
				    <option value="t5">T5</option>
				</select>
			</div>
			<div class="form-group">
				<label for="selectSurface">Surface : </label>
				<select class="form-control" id="selectSurface" name="selectSurface">
				  <c:forEach var="i" begin="0" end="49">
				    <c:set var="j" value="${i + 1}"></c:set>
				    <option value="${i}"><c:out value="${i * 5}"></c:out> à <c:out value="${j * 5}"></c:out>m²</option>
				  </c:forEach>
				  <option value="50">+ de 250m²</option>
				</select>
			</div>
			<div class="form-group">
				<label for="inputCity">Ville : </label>
				<input type="text" class="form-control" id="inputCity" placeholder="Ville">
			</div>
			<button type="submit" class="btn btn-primary">Rechercher</button>
		</form>
		
		<c:choose>
			<c:when test="${empty recentSales}">
				<h3 align="center">Aucune vente ne correspond actuellement à vos critères de recherche</h3>
			</c:when>
			<c:otherwise>
				<div class="hidden-xs hidden-sm col-md-5 no-pad" id="left-side">
	   				<c:forEach var="sale" items="${recentSales}" varStatus="loopStatus">
						<c:if test="${loopStatus.index % 2 == 0}">
						    <div class="row">
							    <div class="thumbnail">
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
										      <img src="/assets/${photo.name}" alt="Photo">
										    </div>
										  </c:if>
										  <c:if test="${loopStatus.index > 0}">
										    <div class="item">
										      <img src="assets/${photo.name}" alt="Photo">
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
							      <div class="caption">
							        <h3>Prix : ${sale.price}</h3>
									<h3>Type : ${sale.type}</h3>
									<h3>Surface : ${sale.surface}</h3>
									<h3>Adresse : ${sale.address}</h3>
									<h3>Ville : ${sale.city}</h3>
							      </div>
							    </div>
							</div>
						</c:if>
					</c:forEach>
				</div>
				
				<div class="col-md-5 no-pad" id="right-side">
					<c:forEach var="sale" items="${recentSales}" varStatus="loopStatus">
						<c:if test="${loopStatus.index % 2 != 0}">
						    <div class="row">
							    <div class="thumbnail">
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
										      <img src="/assets/${photo.name}" alt="Photo">
										    </div>
										  </c:if>
										  <c:if test="${loopStatus.index > 0}">
										    <div class="item">
										      <img src="assets/${photo.name}" alt="Photo">
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
							      <div class="caption">
							        <h3>Prix : ${sale.price}</h3>
									<h3>Type : ${sale.type}</h3>
									<h3>Surface : ${sale.surface}</h3>
									<h3>Adresse : ${sale.address}</h3>
									<h3>Ville : ${sale.city}</h3>
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