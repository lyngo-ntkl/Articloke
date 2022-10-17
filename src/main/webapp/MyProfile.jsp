<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Profile</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class = "custom-big-container">
            <jsp:include page="Navigation.jsp" /> 
            <!--Section 1-->
            <div class ="container-fluid p-0 position-relative" style = "height: 220px">
                <div class ="container-fluid position-relative p-0" style ="height: 160px; border-bottom: 2px solid; overflow: hidden">

                    <img  style = "width: 100%" src ="Image/Background.jpg">
                </div>
                <img src ="${sessionScope.user.picture}" style = "width: 120px; height: 120px; top: 100px;" class = " custom-horizontal-center position-absolute rounded-circle" >       
            </div>

            <!-- End Section 1 -->
            <!-- Section 2 -->
            <div class ="container p-0 position-relative mt-3">             
                <span class ="position-relative d-inline-block custom-horizontal-center h2" >
                    ${sessionScope.user.firstName} ${sessionScope.user.lastName}

                </span>
                <br>
                <span class ="position-relative d-inline-block custom-horizontal-center">
                    @${sessionScope.user.username}
                </span> <br>
            </div>
            <!-- End Section 2 -->
            <!-- Section 3 -->
            <div class ="container position-relative">
                <div class = "row mt-5">
                    <div class ="col-6">
                        <span class ="position-relative d-inline-block h3 mb-3" >
                            General & Statistic
                        </span>    
                        <br>
                        <div> 
                            Date of Birth: ${sessionScope.user.DOB} <br>
                            Email: ${sessionScope.user.email} <br>
                            Address: ${sessionScope.user.address} <br>
                            Role: ${sessionScope.user.role} <br>
                            Organization: ${sessionScope.user.organization} <br>
                            Phone Number: ${sessionScope.user.organization} <br>
                            <span class ="d-inline-block position-relative h5 mt-2"> Artichoke Flowers: ${requestScope.totalCount}  <img src ="Image/FlowerIcon.jpg" class ="d-inline-block position-relative mt-2" style ="width: 30px;top:-7px"> 
                            </span>
                        </div>  
                    </div>
                    <div class ="col-6">
                        <span class ="position-relative d-inline-block h3" style ="margin-bottom:15px" >
                            Setting & Security 
                        </span> <br>
                        <div class ="container" style = "border: 2px solid"> 
                            <div class = "container-fluid p-0 custom-hover-topic" style = "height: 60px">
                                <span class = "d-inline-block h5 position-relative custom-center ">
                                    Edit Information &nbsp; <img src = "Image/EditInf.png" class ="position-relative" style = "width: 36px; top: -2px">

                                </span>

                            </div>
                            <div class = "container-fluid p-0 custom-hover-topic" style = "height: 60px">
                                <span class = "d-inline-block h5 position-relative custom-center "> 
                                    Change Password &nbsp; <img src = "Image/ChangePassword.png" class ="position-relative" style = "width: 36px; top: -2px">
                                </span>

                            </div>
                            <div class = "container-fluid p-0 custom-hover-topic" style = "height: 60px">
                                <span class = "d-inline-block h5 position-relative custom-center "> 
                                    Authenticate Email &nbsp; <img src = "Image/EmailS.png" class ="position-relative" style = "width: 36px; top: -2px">
                                </span>

                            </div>
                        </div>
                    </div> 
                </div> 
            </div> 
            <!-- End Section 3 -->
            <!-- Section 4 -->
            <div class ="container pt-5 position-relative">
                <span class ="position-relative d-inline-block h3" >
                    Respiratory
                </span>
                <a href="ShowMyRespiratoryServlet" class ="position-relative d-inline-block ml-5" style="color: #000">           
                        Show More 
                </a>
                <div class = " row mt-3">
                    <div class ="col-6"> 
                        <div class = "">
                            <span class = "position-relative d-inline-block h4" style ="color:#C6B6C5" > My Papers  </span>

                        </div>
                        <c:if test = "${empty requestScope.papers}">
                            <br>    <span class = "h4"> You have not created any paper. </span>
                        </c:if>

                        <c:if test = "${not empty requestScope.papers}"> 
                            <c:forEach items = "${requestScope.papers}" var = "paper" begin = "0" end = "4">
                                <div class ="position-relative mt-2">
                                    <div class ="row">
                                        <div class ="col-8">
                                            <span class ="h4">${paper.title}</span> 
                                            <br>
                                            Date Modified: ${paper.modifiedDate}
                                            <br>
                                            Description: ${paper.description} <br>
                                            Published Status: ${paper.publishedStatus}

                                        </div>

                                        <div class ="col-4">
                                            <button type ="text" class = "btn btn-light border-dark position-relative custom-center"> Edit</button>
                                        </div>
                                    </div>
                                </div>

                            </c:forEach>

                        </c:if>


                    </div>     
                    <div class ="col-6"> 

                        <span class = "position-relative d-inline-block h4" style ="color:#C6B6C5" > My Articles </span>

                        <c:if test = "${empty requestScope.articles}">
                            <br> <span class = "h4"> You have no published article. </span>
                        </c:if>

                        <c:if test = "${not empty requestScope.articles}"> 
                            <c:forEach var = "article" items = "${requestScope.articles}" begin = "0" end = "4" >
                                <div class ="position-relative mt-3">
                                    <div class ="row">

                                        <div class ="col-3">
                                            <img class = "d-inline-block p-relative img-fluid img-thumbnail" src ="${article.picture}"> 

                                            <br>

                                        </div>
                                        <div class ="col-6">
                                            <span class ="h4">${article.title}</span> <br>
                                            Published Date: ${article.publishedDate} <br>
                                            Permission: ${article.permission} <br>
                                            <div class ="d-flex">
                                                <div class = "mr-3"> 
                                                    <img src="Image/HeartIcon.png" style = "width: 20px" class = "mr-2">${article.totalReaction} 
                                                </div>
                                                <div> 
                                                    <img src="Image/DownloadIcon.png" style = "width: 20px" class = "mr-2">${article.totalDownload}
                                                </div>
                                            </div>
                                        </div>  
                                        <div class ="col-3">
                                            <button type ="text" class = "btn btn-light border-dark position-relative custom-center"> Edit</button>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>

                        </c:if>



                    </div>  
                </div>          

            </div>     
            <!-- End Section 4 -->
            <jsp:include page="Footer.jsp" />   
        </div>
    </body>
</html>
