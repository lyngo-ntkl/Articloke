<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class = "custom-big-container" style = "height: 150%">
            <jsp:include page="Navigation.jsp" /> 
            <!-- Section 1 -->
            <form action="CreatePaperServlet" id = "CreatePaperServlet"> </form>
            <div class ="position-absolute custom-center p-3 shadow" style = "top:45%; width: 600px; height: 800px; border: 1px solid" >
                <div class ="position-relative d-inline-block h2 custom-horizontal-center"> Create Paper</div> <br>
                <div class ="row mt-3"> 
                    <div class ="col-6">   
                        <div class = "mt-1"> 
                            Title*
                        
                        <input form = "CreatePaperServlet" placeholder = "Title" type = "text" name = "title" class ="form-control d-inline-block"> <br>
                        </div>
                        <div class = "mt-1"> 
                            Topic*
                            <br>
                            <select name = "topic"  form = "CreatePaperServlet"  name = "" class ="form-control d-inline-block">
                                <option value = "All"> All </option>
                            </select>
                        </div>
                    </div>

                    <div class ="col-6"> 
                        <script>
    function previewImage() {
        var file = document.getElementById("file").files;
        if (file.length > 0) {
            var fileReader = new FileReader();
 
            fileReader.onload = function (event) {
                document.getElementById("preview").setAttribute("src", event.target.result);
            };
 
            fileReader.readAsDataURL(file[0]);
        }
    }
</script>
 
<form method="POST" action="/" enctype="multipart/form-data">
    <input type="file" name="file" id="file" accept="image/*" onchange="previewImage();">
 
    <img id="preview">
</form>

                        
                        
                        
                        
                    
                   </div>
                        <div class = "mt-3"> 
                            Content (Less than 1000 Characters)
                            <br>

                            <textarea form = "CreatePaperServlet" class="form-control position-relative" style = "height: 260px"></textarea>
                            <button  form = "CreatePaperServlet" class ="btn btn-light border-dark float-right mt-3"> Create</button>  
                            <button class ="btn btn-light border-dark float-right mr-2 mt-3"> Reset</button>  

                        </div>
                    </div>

                </div>


            </div>

            <!-- End Section 1 -->

            <jsp:include page="Footer.jsp" />   
        </div>
    </body>
</html>
