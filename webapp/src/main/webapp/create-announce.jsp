<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Créer une annonce - WebAppALDA</title>
	
	<link rel="stylesheet" type="text/css" href="http://normalize-css.googlecode.com/svn/trunk/normalize.css" />
	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="./css/app.css"/>
	
</head>
<body>

	<jsp:include page="./topbar.jsp"></jsp:include>

	<div class="container">
		<h1 class="title-form">Création d'une annonce</h1>
		
		<form method="POST" id="create-announce-form" class="form-signin" action="/CreateAnnounceValidationServlet">
		    <input type="hidden" name="uploadedPhotoPath1" id="uploadedPhotoPath1" value="${photoUploadedpath1}" />
            <input type="hidden" name="uploadedImageName1" id="uploadedImageName1" value="${uploadedImageName1}" />
            <input type="hidden" name="edit1" value="true" />
            <input type="hidden" name="uploadedPhotoPath2" id="uploadedPhotoPath2" value="${photoUploadedpath2}" />
            <input type="hidden" name="uploadedImageName2" id="uploadedImageName2" value="${uploadedImageName2}" />
            <input type="hidden" name="edit2" value="true" />
			
			<div class="form-group">
				<label for="price" class="col-xs-6 col-sm-6 col-lg-5 control-label">Prix</label>
				<div class="col-xs-6 col-sm-6 col-lg-7">
					<input type="text" value="${validParams.price}" maxlength="250"
						   class="form-control" id="price" name="price"
						   placeholder="Prix">
				</div>
			</div>
			
			<div class="form-group">
				<label for="type" class="col-xs-6 col-sm-6 col-lg-5 control-label">Type (Studio, T1, T2, ...)</label>
				<div class="col-xs-6 col-sm-6 col-lg-7">
					<input type="text" value="${validParams.type}" maxlength="250"
						   class="form-control" id="type" name="type"
						   placeholder="Studio, Maison, T1, T2, etc...">
				</div>
			</div>
	
			<div class="form-group">
				<label for="surface" class="col-xs-6 col-sm-6 col-lg-5 control-label">Surface en m²</label>
				<div class="col-xs-6 col-sm-6 col-lg-7">
					<input type="text" value="${validParams.surface}" maxlength="250"
						   class="form-control" id="surface" name="surface"
						   placeholder="Surface en m²">
				</div>
			</div>
			
			<div class="form-group">
				<label for="address" class="col-xs-6 col-sm-6 col-lg-5 control-label">Adresse</label>
				<div class="col-xs-6 col-sm-6 col-lg-7">
					<input type="text" value="${validParams.address}" maxlength="250"
						   class="form-control" id="address" name="address"
						   placeholder="Adresse" required>
				</div>
			</div>
			
			<div class="form-group">
				<label for="city" class="col-xs-6 col-sm-6 col-lg-5 control-label">Ville</label>
				<div class="col-xs-6 col-sm-6 col-lg-7">
					<input type="text" value="${validParams.city}" maxlength="250"
						   class="form-control" id="city" name="city"
						   placeholder="Ville" required>
				</div>
			</div>
			
			<div class="form-group">
				<label for="description" class="col-xs-6 col-sm-6 col-lg-5 control-label">Description (max 1000 caractères)</label>
				<div class="col-xs-6 col-sm-6 col-lg-7">
					<input type="text" value="${validParams.description}" maxlength="10"
						   class="form-control" id="description" name="description"
						   placeholder="Description" required>
				</div>
			</div>
			
			<div id="entry-left" class="col-xs-12 col-sm-12 col-md-6 col-lg-6 form-group">
	          <div class="entry-block thumbnail wall" style="height: 451px;">
	
	            <h3>Photo pour la vente</h3>
	
	            <div id="photoPreviewContainer1">
	            	<img src="./assets/default.png" id="photoPreview1" width="200" />
	            </div>
	            
	            <span class="btn-file glyphicon glyphicon-folder-open" aria-hidden="true"
	                  data-toggle="tooltip" data-placement="bottom" title="Choisissez votre fichier">
	              <input type="file" name="photoPath1" id="photoPath1" accept="image/*"/>
	            </span>
				
				<span class="btn-file glyphicon glyphicon-remove-circle" aria-hidden="true"
	                  data-toggle="tooltip" name="removePhoto1" id="removePhoto1"
	                  data-placement="bottom" title="Retirer l'image">
	            </span>
				
	            <span class="btn-file glyphicon glyphicon-zoom-in" name="zoomIn1" id="zoomIn1">
	            </span>
	
	            <span class="btn-file glyphicon glyphicon-zoom-out" name="zoomOut1" id="zoomOut1">
	            </span>
	          </div>
	        </div>
			
			<div id="entry-left" class="col-xs-12 col-sm-12 col-md-6 col-lg-6 form-group">
	          <div class="entry-block thumbnail wall" style="height: 451px;">
	
	            <h3>Photo pour la vente</h3>
	
	            <div id="photoPreviewContainer2">
                  <img src="./assets/default.png" id="photoPreview2" width="200" />
	            </div>
	            
	            <span class="btn-file glyphicon glyphicon-folder-open" aria-hidden="true"
	                  data-toggle="tooltip" data-placement="bottom" title="Choisissez votre fichier">
	              <input type="file" name="photoPath2" id="photoPath2" accept="image/*"/>
	            </span>
				
				<span class="btn-file glyphicon glyphicon-remove-circle" aria-hidden="true"
	                  data-toggle="tooltip" name="removePhoto2" id="removePhoto2"
	                  data-placement="bottom" title="Retirer l'image">
	            </span>
				
	            <span class="btn-file glyphicon glyphicon-zoom-in" name="zoomIn2" id="zoomIn2">
	            </span>
	
	            <span class="btn-file glyphicon glyphicon-zoom-out" name="zoomOut2" id="zoomOut2">
	            </span>
	          </div>
	        </div>
			
			<button class="btn btn-lg btn-primary" type="submit">Valider</button>
		</form>
	</div>
	
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
   	<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
   	<script type="text/javascript" src="./lib/cropper.min.js"></script>
   	<script type="text/javascript" src="./js/app.js"></script>
   	<script type="text/javascript" src="./js/crop-photo.js"></script>
</body>