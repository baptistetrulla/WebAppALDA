<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Ventes vous intéressant - WebAppALDA</title>
	
	<link rel="stylesheet" type="text/css" href="http://normalize-css.googlecode.com/svn/trunk/normalize.css" />
	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="./css/app.css"/>
	
</head>
<body>
	<div class="container">
		<h1 class="title-form">Ventes selon vos critères de recherche enregistrés</h1>
		
		<c:choose>
			<c:when test="${empty recentSales}">
				<script type="text/javascript">
					$('#filter-row').addClass('hide');
				</script>
				<h3 align="center">Aucune vente ne correspond actuellement vos critères de recherche.</h3>
				<h3 align="center"><a href="/Sales">Voir toutes les autres ?</a></h3>
			</c:when>
			<c:otherwise>
				<script type="text/javascript">
					$('#filter-row').removeClass('hide');
				</script>
				
				<div class="hidden-xs hidden-sm col-md-5 no-pad" id="left-side">
	   				<c:forEach var="sale" items="${recentSales}" varStatus="loopStatus">
						<c:if test="${loopStatus.index % 2 == 0}">
						</c:if>
					</c:forEach>
				</div>
				<div class="hidden-xs hidden-sm col-md-5 no-pad" id="right-side">
					<c:forEach var="sale" items="${recentSales}" varStatus="loopStatus">
						<c:if test="${loopStatus.index % 2 != 0}">
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