<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Article</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class = "custom-big-container">
            <jsp:include page="Navigation.jsp" /> 
            <!-- Section 1 -->
            <div class ="container position-relative">
                <div class ="row" style = "margin-top: 5rem; margin-bottom: 5rem">
                    <div class ="col-8">
                        <div class ="row"> 
                            <div class ="col-5 position-relative">
                                <img src ="${requestScope.article.picture}" class = "img-fluid img-thumbnail">
                                <c:if test = "${empty sessionScope.user}">
                                    <div class ="mt-3"> 
                                        <img src = "Image/HeartIcon.png" class = "position-relative mr-2" style = "width: 30px"> 
                                        <span class = "h3 position-relative" style = "top:6px"> ${requestScope.article.totalReaction}</span>
                                    </div>
                                </c:if>
                                <c:if test = "${not empty sessionScope.user}">
                                    <div class ="mt-3 d-flex align-items-center justify-content-between"> 
                                        <div> 
                                            <img src = "Image/HeartIcon.png" class = "position-relative mr-2" style = "width: 30px"> 
                                            <span class = "h3 position-relative" style = "top:6px"> ${requestScope.article.totalReaction}</span>
                                        </div>  
                                        <form action="ReactionInteractServlet">
                                            <input type ="hidden" name ="ID" value ="${requestScope.article.ID}">
                                            <c:if test = "${not requestScope.reactionStatus}">            
                                                <button type = "SUBMIT" class = "btn btn-light border-dark position-relative" style = "top: 4px" name = "action" value = "Love"> <span class ="h4"> Love </span> </button>
                                            </c:if>
                                            <c:if test = "${requestScope.reactionStatus}">               
                                                <button type = "SUBMIT" class = "btn btn-light border-dark position-relative" style = "top: 4px" name = "action" value = "Loved"> <span class ="h4"> Loved </span> </button>
                                            </c:if>
                                        </form>
                                    </div>
                                </c:if>
                            </div>

                            <div class ="col-7" style = "margin-top: -4px">
                                <div class = "h1"> ${requestScope.article.title}</div>
                                <div style = "font-size: 18px"> ID: ${requestScope.article.ID}</div>
                                <div style = "font-size: 18px"> Author: ${requestScope.article.username}</div>
                                <div style = "font-size: 18px"> Topic: ${requestScope.article.topic}</div>

                                <div style = "font-size: 18px"> Permission: ${requestScope.article.permission}</div>
                                <div style = "font-size: 18px"> Organization: ${requestScope.article.organization}</div>
                                <div style = "font-size: 18px"> Published Date: ${requestScope.article.publishedDate}</div>
                            </div>
                        </div>
                        <div class ="position-relative mt-3">
                            <div class ="h1" style = "color: #C6B6C5"> Description</div>
                            <div class ="text-justify">
                                ${requestScope.article.description}
                              
                            </div>
                        </div>
                    </div>

                    <div class ="col-4 position-relative"  >
                        <div class = "shadow px-3 position-absolute custom-horizontal-center" style =" min-height: 600px; top: -35px; background: #C6B6C5; height: calc(100% + 70px); width: 80%"> 
                            <div style ="margin-top: 35px" class ="custom-horizontal-center h1 position-relative d-inline-block"> Purchase </div>
                            <br>
                            <div class ="text-white custom-horizontal-center h1 mt-5 position-relative d-inline-block"> ${requestScope.article.price}$ </div>
                            <br> 
                            <div class ="mt-1 h5 mt-5 position-relative d-inline-block custom-horizontal-center"> Downloaded: ${requestScope.article.totalDownload} </div>  
                            <br>
                            <div class ="mt-1 custom-horizontal-center position-relative d-inline-block"> You only pay for your first download. </div>  
                            <br>
                            <button type = "submit" style = "width: 100%" class = "btn btn-light border-dark position-relative d-inline-block custom-horizontal-center mt-1"> <span class = "h4"> Download  </span> </button>
                            <br>

                            <div class ="text-justify mt-3"> To make a certain decision whether purchases or not, you can take a look on free demo-version <a href = "#" class ="font-italic" style = "color: #000">Click Here </a> </div>
                            
                        </div>
                    </div>  

                </div>

            </div>

            <!-- End Section 1 -->

            <jsp:include page="Footer.jsp" />   
        </div>
    </body>
</html>
