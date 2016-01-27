<%@page contentType="text/html" pageEncoding="UTF-16"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="fr">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Créer un compte - WebAppALDA</title>
	
	<link rel="stylesheet" src="//normalize-css.googlecode.com/svn/trunk/normalize.css" />
	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/app.css"/>
	
</head>
<body>
	<h1 class="title-form">Création d'un compte</h1>
	
	<form method="POST" id="login-form" class="form-signin" action="/LoginValidationServlet">
		<h2 class="form-signin-heading">Identifiez vous</h2>
		
		<input type="text" class="form-control" name="email" id="email" placeholder="Email" required autofocus/>
		<input type="password" class="form-control" name="password" id="password" placeholder="Mot de passe" required/>
		
		<button class="btn btn-lg btn-primary btn-block" type="submit">Se connecter</button>

		<div>
			<b>Pas encore membre ? </b> <a href="/RegisterServlet">Créez votre profil</a>
		</div>
	</form>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
   	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>