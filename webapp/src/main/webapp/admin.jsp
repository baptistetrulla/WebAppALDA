<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Administration - WebAppALDA</title>
	
	<link rel="stylesheet" type="text/css" href="http://normalize-css.googlecode.com/svn/trunk/normalize.css" />
	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="./css/app.css"/>
	
</head>
<body>

	<jsp:include page="./topbar.jsp"></jsp:include>

	<div class="container">
		<h1 class="title-form">Tableau de d'administration</h1>
		
		<div class="col-sm-12 col-md-12" id="admin-wall-users">
			<h3 class="forum-entry">Statistiques</h3>
			
			<div class="panel panel-primary left-floaters">
				<div class="panel-heading">
					<h3 class="panel-title">Utilisateurs</h3>
				</div>
				<div class="panel-body">
					${nbUsers}
				</div>
			</div>
			
			<div class="panel panel-primary left-floaters">
				<div class="panel-heading">
					<h3 class="panel-title">Ventes en cours</h3>
				</div>
				<div class="panel-body">
					${nbSales}
				</div>
			</div>
			
			<div class="panel panel-primary left-floaters">
				<div class="panel-heading">
					<h3 class="panel-title">Ventes termin�es</h3>
				</div>
				<div class="panel-body">
					${nbSalesExpired}
				</div>
			</div>
		</div>
		
		<div class="col-sm-12 col-md-12" id="admin-wall-sales">
			<h3 class="sales-entry">
				Ventes
			</h3>

			<div class="table-responsive" id="admin-panel-sale">
				<table class="table table-condensed table-hover">
					<thead>
						<tr>
							<th>Vendeur</th>
							<th>Prix</th>
							<th>Type</th>
							<th>Surface</th>
							<th>Adresse</th>
							<th>Description</th>
							<th>Voir la vente</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="sale" items="${sales}">
						<tr>
							<td>
								<a href="#" onclick="showProfile(${sale.userId})">
							    	<c:out value="${sale.userFirstname} ${sale.userLastname}"/>
							    </a>
							</td>
							<td>${sale.price}</td>
							<td>${sale.type}</td>
							<td>${sale.surface}</td>
							<td><c:out value="${sale.address}, ${sale.city}"/></td>
							<td>${sale.description}</td>
							<td><a href="#" onclick="showSale(${sale.id})">Acc�der</a></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		
		<div class="col-sm-12 col-md-12" id="admin-wall-users">
			<h3 class="users-entry">
				Utilisateurs
			</h3>

			<div class="table-responsive" id="admin-panel-user">
				<table class="table table-condensed table-hover">
					<thead>
						<tr>
							<th>Pr�nom Nom</th>
							<th>Pseudo</th>
							<th>Adresse</th>
							<th>T�l�phone</th>
							<th>E-mail</th>
							<th>Est Admin ?</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="user" items="${users}">
						<tr>
							<td>
								<a href="#" onclick="showProfile(${user.id})">
							    	<c:out value="${user.firstname} ${user.lastname}"/>
							    </a>
							</td>
							<td>${user.username}</td>
							<td><c:out value="${user.address}, ${user.city}"/></td>
							<td>${user.cellnumber}</td>
							<td>${user.email}</td>
							<td>${user.isAdmin}</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
   	<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
   	<script type="text/javascript" src="./js/app.js"></script>
   	
</body>