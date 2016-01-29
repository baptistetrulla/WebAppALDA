
$(function(){
	
	$('#removePhoto1').hide();
	$('#zoomIn1').hide();
    $('#zoomOut1').hide();
    $('#removePhoto2').hide();
    $('#zoomIn2').hide();
    $('#zoomOut2').hide();
	
	if($('#uploadedImagePath1').val()){
        $('#photoPreview1').attr('src', $('#uploadedPhotoPath1').val());
        $('#photoPreview1').cropper('destroy');
        $('#photoPreview1').hide();
        $('#removePhoto1').show();
        $('#zoomIn1').show();
        $('#zoomOut1').show();
        $('#photoPreview1').cropper({
            minCropBoxWidth: 256,
            minCropBoxHeight: 256,
            guides: false,
            highlight: false,
            dragCrop: false,
            movable: false,
            resizable: false,
            built: function(param){
                $('#cropper-container1').width(456);
            }
        });
    }

    //Detects when the profile image is changed
    $("#photoPath1").change(function(){
        $('#photoPreview1').hide();
        $('#photoPreview1').cropper('destroy');
        var ext = $('#photoPath1').val().split('.').pop().toLowerCase();
        var validExtensions = ['gif','png','jpg','jpeg','bmp'];
        if($.inArray(ext,validExtensions) == -1) {
            $('#photoPath1').val("");
            addError("Le fichier doit être au format image");
        }else{
            readURL1(this);
        }
    });

    $('#zoomIn1').click(function(){
        $('#photoPreview1').cropper('zoom', 0.1);
    });

    $('#zoomOut1').click(function(){
        $('#photoPreview1').cropper('zoom', -0.1);
    });

    
    //Removes the chosen photo
    $('#removePhoto1').click(function(){
    	$('#removePhoto1').hide();
        $('#uploadedImageName1').val("delete");
        $('#zoomIn1').hide();
        $('#zoomOut1').hide();
        $('#photoPath1').val("");
        $('#uploadedPhotoPath1').val("");
        $('#photoPreview1').cropper('destroy');
        $('#photoPreview1').hide();
        $('#photoPreview1').val("");
    });
    
    if($('#uploadedImagePath2').val()){
        $('#photoPreview2').attr('src', $('#uploadedPhotoPath2').val());
        $('#photoPreview2').cropper('destroy');
        $('#photoPreview2').hide();
        $('#removePhoto2').show();
        $('#zoomIn2').show();
        $('#zoomOut2').show();
        $('#photoPreview2').cropper({
            minCropBoxWidth: 256,
            minCropBoxHeight: 256,
            guides: false,
            highlight: false,
            dragCrop: false,
            movable: false,
            resizable: false,
            built: function(param){
                $('#cropper-container2').width(456);
            }
        });
    }

    //Detects when the profile image is changed
    $("#photoPath2").change(function(){
        $('#photoPreview2').hide();
        $('#photoPreview2').cropper('destroy');
        var ext = $('#photoPath2').val().split('.').pop().toLowerCase();
        var validExtensions = ['gif','png','jpg','jpeg','bmp'];
        if($.inArray(ext,validExtensions) == -1) {
            $('#photoPath2').val("");
            addError("Le fichier doit être au format image");
        }else{
            readURL2(this);
        }
    });

    $('#zoomIn2').click(function(){
        $('#photoPreview2').cropper('zoom', 0.1);
    });

    $('#zoomOut2').click(function(){
        $('#photoPreview2').cropper('zoom', -0.1);
    });

    
    //Removes the chosen photo
    $('#removePhoto2').click(function(){
    	$('#removePhoto2').hide();
        $('#uploadedImageName2').val("delete");
        $('#zoomIn2').hide();
        $('#zoomOut2').hide();
        $('#photoPath2').val("");
        $('#uploadedPhotoPath2').val("");
        $('#photoPreview2').cropper('destroy');
        $('#photoPreview2').hide();
        $('#photoPreview2').val("");
    });

    $('#Valid').click(function(event){
        event.preventDefault();
        validCrop();
        if($('#uploadedImageName1').val() == null || $('#uploadedImageName1').val() == '') {
        	 $('#removePhoto1').hide();
            var filename = $('input[type=file]').val().replace(/.*(\/|\\)/, '');
            $('#uploadedImageName1').val(filename);
        }
        var $hiddenInput = $('<input/>',{type:'hidden',name:'Valid',value:'Valid'});
        if($('#uploadedImageName2').val() == null || $('#uploadedImageName2').val() == '') {
       	 $('#removePhoto2').hide();
           var filename = $('input[type=file]').val().replace(/.*(\/|\\)/, '');
           $('#uploadedImageName2').val(filename);
       }
       var $hiddenInput = $('<input/>',{type:'hidden',name:'Valid',value:'Valid'});
        $("#create-announce-form").append($hiddenInput);
        $("#create-announce-form").submit();
    });
});

var validCrop = function(){
    var cropBox = $('#photoPreview1').cropper('getCropBoxData');
    var dt = $('#photoPreview1').cropper('getDataURL', {
        width: cropBox.width,
        height: cropBox.height
    });

    $('#photoPreview1').attr('src', dt);
    $('#uploadedPhotoPath1').val(dt);
    //$('#photoPreview').cropper('destroy');
    
    var cropBox = $('#photoPreview2').cropper('getCropBoxData');
    var dt = $('#photoPreview2').cropper('getDataURL', {
        width: cropBox.width,
        height: cropBox.height
    });

    $('#photoPreview2').attr('src', dt);
    $('#uploadedPhotoPath2').val(dt);
    //$('#photoPreview').cropper('destroy');
};

//Adds the profile image preview
function readURL1(input) {

    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#photoPreview1').attr('src', e.target.result);
            //$('#photoPreview').show();
            $('#removePhoto1').show();
            $('#zoomIn1').show();
            $('#zoomOut1').show();
            $('#uploadedPhotoPath1').val(e.target.result);
           
            $('#photoPreview1').cropper({
                minCropBoxWidth: 256,
                minCropBoxHeight: 256,
                guides: false,
                highlight: false,
                dragCrop: false,
                movable: false,
                resizable: false,
                built: function(param){
                    $('#cropper-container1').width(456);
                }
            });
        }

        reader.readAsDataURL(input.files[0]);
    }
};

//Adds the profile image preview
function readURL2(input) {

    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#photoPreview2').attr('src', e.target.result);
            //$('#photoPreview').show();
            $('#removePhoto2').show();
            $('#zoomIn2').show();
            $('#zoomOut2').show();
            $('#uploadedPhotoPath2').val(e.target.result);
           
            $('#photoPreview2').cropper({
                minCropBoxWidth: 256,
                minCropBoxHeight: 256,
                guides: false,
                highlight: false,
                dragCrop: false,
                movable: false,
                resizable: false,
                built: function(param){
                    $('#cropper-container2').width(456);
                }
            });
        }

        reader.readAsDataURL(input.files[0]);
    }
};