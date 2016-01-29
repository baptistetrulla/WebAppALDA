<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Se connecter - WebAppALDA</title>
	
	<link rel="stylesheet" type="text/css" href="http://normalize-css.googlecode.com/svn/trunk/normalize.css" />
	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="./css/app.css"/>
	
</head>
<body>
	<div class="container">
		<h1 class="title-form">Authentification</h1>
		
		<form method="POST" id="login-form" class="form-signin" action="/LoginValidation">
			<h3 class="form-signin-heading">Identifiez vous</h3>
			
			<input type="text" class="form-control" name="email" id="email" placeholder="Email" required autofocus/>
			<input type="password" class="form-control" name="password" id="password" placeholder="Mot de passe" required/>
			<i><a href="#" onclick="sendNewPassword">Mot de passe oublié ?</a></i>
			
			<hr/>
			
			<button class="btn btn-lg btn-primary" type="submit">Se connecter</button>
	
			<hr/>
			
			<h3><b>Pas encore membre ? </b> <a href="/register.jsp">Créez votre profil</a></h3>
		</form>
	</div>
	
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
   	<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
   	<script type="text/javascript" src="./js/app.js"></script>
</body>