<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Votre compte - WebAppALDA</title>
	
	<link rel="stylesheet" type="text/css" href="http://normalize-css.googlecode.com/svn/trunk/normalize.css" />
	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="./css/app.css"/>
	
</head>
<body>

	<jsp:include page="./topbar.jsp"></jsp:include>
	
	<div class="container">
		<h1 class="title-form">Informations sur votre compte</h1>
		<a class="btn btn-lg btn-warning" href="/DeleteAccount">Supprimer votre compte</a>
		
		<form method="POST" id="account-form" class="form-signin" action="/AccountValidation">
			<h3>Seuls l'e-mail et le mot de passe sont obligatoires</h3>
			
			<div class="form-group">
				<label for="username" class="col-xs-6 col-sm-6 col-lg-5 control-label">Identifiant</label>
				<div class="col-xs-6 col-sm-6 col-lg-7">
					<input type="text" value="${user.username}" maxlength="250"
						   class="form-control" id="username" name="username"
						   placeholder="Identifiant">
				</div>
			</div>
			
			<div class="form-group">
				<label for="firstname" class="col-xs-6 col-sm-6 col-lg-5 control-label">Prénom</label>
				<div class="col-xs-6 col-sm-6 col-lg-7">
					<input type="text" value="${user.firstname}" maxlength="250"
						   class="form-control" id="firstname" name="firstname"
						   placeholder="Prénom">
				</div>
			</div>
	
			<div class="form-group">
				<label for="lastname" class="col-xs-6 col-sm-6 col-lg-5 control-label">Nom</label>
				<div class="col-xs-6 col-sm-6 col-lg-7">
					<input type="text" value="${user.lastname}" maxlength="32"
						   class="form-control" id="lastname" name="lastname"
						   placeholder="Nom">
				</div>
			</div>
			
			<div class="form-group">
				<label for="address" class="col-xs-6 col-sm-6 col-lg-5 control-label">Adresse</label>
				<div class="col-xs-6 col-sm-6 col-lg-7">
					<input type="text" value="${user.address}" maxlength="250"
						   class="form-control" id="address" name="address"
						   placeholder="Adresse">
				</div>
			</div>
			
			<div class="form-group">
				<label for="city" class="col-xs-6 col-sm-6 col-lg-5 control-label">Ville</label>
				<div class="col-xs-6 col-sm-6 col-lg-7">
					<input type="text" value="${user.city}" maxlength="250"
						   class="form-control" id="city" name="city"
						   placeholder="Ville">
				</div>
			</div>
			
			<div class="form-group">
				<label for="cellnumber" class="col-xs-6 col-sm-6 col-lg-5 control-label">Téléphone :</label>
				<div class="col-xs-6 col-sm-6 col-lg-7">
					<input type="text" value="${user.cellnumber}" maxlength="10"
						   class="form-control" id="cellnumber" name="cellnumber"
						   placeholder="Téléphone">
				</div>
			</div>
			
			<div class="form-group">
				<label for="email" class="col-xs-6 col-sm-6 col-lg-5 control-label">E-mail</label>
				<div class="col-xs-6 col-sm-6 col-lg-7">
					<input type="text" value="${user.email}" maxlength="250"
						   class="form-control" id="email" name="email"
						   placeholder="E-mail">
				</div>
			</div>
			
			<div class="form-group">
				<label for="passwd_repeated" class="col-xs-6 col-sm-6 col-lg-5 control-label">Confirmer mot de passe</label>
				<div class="col-xs-6 col-sm-6 col-lg-7">
					<input type="password" maxlength="32"
						   class="form-control" id="passwd_repeated" name="passwd_repeated"
						   placeholder="Mot de passe" required>
				</div>
			</div>
			
			<hr/>
			
			<div class="form-group">
				<label for="password" class="col-xs-6 col-sm-6 col-lg-5 control-label">Mot de passe actuel pour sauvegarder vos changements</label>
				<div class="col-xs-6 col-sm-6 col-lg-7">
					<input type="password" maxlength="32"
						   class="form-control" id="password" name="password"
						   placeholder="Mot de passe actuel" required>
				</div>
			</div>
	
			<button class="btn btn-lg btn-primary" type="submit">Valider</button>
			
		</form>
	</div>
	
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
   	<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
   	<script type="text/javascript" src="./js/app.js"></script>
</body>