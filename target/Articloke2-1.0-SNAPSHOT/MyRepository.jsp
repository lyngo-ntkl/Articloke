<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Respiratory</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class = "custom-big-container">
            <jsp:include page="Navigation.jsp" /> 
            <!--Section 1-->

            <div class ="container mt-5"> 
                <a href ="SwitchPaperArticleServlet?action=Paper" class = "custom-no-hyperlink-display">
                    <div class ="h2 d-inline-block position-relative p-1  " style = "left: 8px; <c:if test = "${requestScope.currentPaper}"> border-bottom: 4px solid #C6B6C5; </c:if>">
                            Papers
                        </div> 
                    </a>
                    <a href ="SwitchPaperArticleServlet?action=Article" class = "custom-no-hyperlink-display">
                        <div class ="h2 d-inline-block position-relative ml-3 p-1" style = "<c:if test = "${not requestScope.currentPaper}"> border-bottom: 4px solid #C6B6C5; </c:if>">
                            Articles
                        </div> 
                    </a>   <c:if test = "${requestScope.currentPaper}"> 
                            <div class ="d-inline-block float-right position-relative" style = "top: 3.75rem; right: 1.25rem"> 
                                <button class = "btn btn-light border-dark position-relative"> <span class = "h5 mr-2"> Create </span> <img class = "position-relative" style = "width: 20px; height: 20px;top:-2px" src = "Image/Add.jpg"> </button>    
                            </div>
                             </c:if>
                <c:if test = "${requestScope.currentPaper}">
                    <div class ="row" style = "margin-top: 3.5rem">
                        <div class ="col-3">
                            <div class ="h4 d-inline-block position-relative" style = "margin-top: 6px; left: 12px; color: #C6B6C5">
                                Search 
                            </div>  
                            <form action="SearchRepositoryPaperServlet">
                                <input type ="hidden" name ="currentTopic" value ="${requestScope.currentTopic}">
                                <div class ="d-flex">  
                                    <input style = "width: 60%" placeholder = "Keyword" class = "form-control" type = "text" name = "keyword" value = "${requestScope.keyword}">
                                    <input type ="image" src ="Image/SearchIcon.png" style = "width: 40px; height: 40px" class = "position-relative ml-2"> 
                                </div>   
                            </form>                                   
                            <div class ="h4 d-inline-block position-relative mt-5" style = "color: #C6B6C5 ;left: 12px">
                                Topic 
                            </div> 
                            <br>
                            <a href = "ClassifyTopicPaperServlet?keyword=${requestScope.keyword}&currentTopic=All" class = "custom-no-hyperlink-display">  
                                <div class = "h5 d-inline-block p-3 position-relative" style ="width: 100%;<c:if test = "${requestScope.currentTopic == 'All'}"> background: #C6B6C5</c:if>">
                                        All        
                                    </div>
                                </a>  
                            <c:forEach items = "${requestScope.topics}" var = "topic">

                                <a href = "ClassifyTopicPaperServlet?keyword=${requestScope.keyword}&currentTopic=${topic.key}" class = "custom-no-hyperlink-display">  
                                    <div class = "h5 d-inline-block p-3" style ="width: 100%; <c:if test = "${topic.key == requestScope.currentTopic}"> background: #C6B6C5</c:if>">
                                        ${topic.key} (${topic.value})         
                                    </div>
                                </a>   
                            </c:forEach>

                        </div>

                        <div class ="col-9">

                            <c:if test = "${not empty requestScope.papers}">

                                <div style = "width: 100%; height: 600px; overflow: auto; border-left: 2px solid #C6B6C5; border-top: 2px solid #C6B6C5" class = "shadow position-relative">
                                    <div style = "width: 100%; height: 50px" class = "position-relative row">
                                        <div class ="col-3 h4 position-relative" style = "color:#C6B6C5"> 
                                            <span class ="position-absolute custom-vertical-center p-3"> 
                                                Title
                                            </span>
                                        </div>
                                          <div class ="col-4 h4 position-relative" style = "color:#C6B6C5"> 
                                            <span class ="position-absolute custom-vertical-center p-3"> 
                                               General
                                            </span>
                                        </div>
                                         <div class ="col-3 h4 position-relative" style = "color:#C6B6C5"> 
                                            <span class ="position-absolute custom-vertical-center p-3"> 
                                               Description
                                            </span>
                                        </div>
                                        <div class ="col-2 h4 position-relative" style = "color:#C6B6C5"> 
                                            <span class ="position-absolute custom-vertical-center p-3"> 
                                               Status
                                            </span>
                                        </div>
                                    </div>
                                    <c:forEach items = "${requestScope.papers}" var = "paper">

                                        <div class ="row custom-hover-topic" style ="height: 150px; width: 100%">
                                            <div class ="col-3 position-relative">
                                                <div class = "h4 position-absolute custom-vertical-center p-3"> ${paper.title} </div>
                                            </div>
                                            <div class ="col-4 position-relative">
                                                <div class ="position-absolute custom-vertical-center p-3"> 
                                                    ID: ${paper.ID} 
                                                    <br>
                                                    Topic: ${paper.topic} 
                                                    <br>
                                                    Created Date: ${paper.createdDate}
                                                    <br>
                                                    Modified Date: ${paper.modifiedDate}
                                                    
                                                </div>
                                            </div>
                                            <div class ="col-3 position-relative">
                                                <div class ="position-absolute custom-vertical-center p-3"> 
                                                    
                                                    ${paper.description}
                                               
                                                </div>
                                            </div>
                                            <div class ="col-2 position-relative"> 
                                              <div class ="position-absolute custom-vertical-center p-3"> 
                                                    ${paper.publishedStatus}
                                                </div>
                                            </div>
                                        </div>

                                    </c:forEach>
                                </div>
                            </c:if>

                        </div>
                    </div>
                </c:if>
                <c:if test = "${not requestScope.currentPaper}">
                    <div class ="row" style = "margin-top: 3.5rem">
                        <div class ="col-3">
                            <div class ="h4 d-inline-block position-relative" style = "margin-top: 6px; left: 12px; color: #C6B6C5">
                                Search 
                            </div>  
                            <form action="SearchRepositoryArticleServlet">
                                <input type ="hidden" name ="currentTopic" value ="${requestScope.currentTopic}">
                                <div class ="d-flex">  
                                    <input style = "width: 60%" placeholder = "Keyword" class = "form-control" type = "text" name = "keyword" value = "${requestScope.keyword}">
                                    <input type ="image" src ="Image/SearchIcon.png" style = "width: 40px; height: 40px" class = "position-relative ml-2"> 
                                </div>   
                            </form>                                   
                            <div class ="h4 d-inline-block position-relative mt-5" style = "color: #C6B6C5 ;left: 12px">
                                Topic 
                            </div> 
                            <br>
                            <a href = "ClassifyTopicArticleServlet?keyword=${requestScope.keyword}&currentTopic=All" class = "custom-no-hyperlink-display">  
                                <div class = "h5 d-inline-block p-3 position-relative" style ="width: 100%;<c:if test = "${requestScope.currentTopic == 'All'}"> background: #C6B6C5</c:if>">
                                        All        
                                    </div>
                                </a>  
                            <c:forEach items = "${requestScope.topics}" var = "topic">

                                <a href = "ClassifyTopicArticleServlet?keyword=${requestScope.keyword}&currentTopic=${topic.key}" class = "custom-no-hyperlink-display">  
                                    <div class = "h5 d-inline-block p-3" style ="width: 100%; <c:if test = "${topic.key == requestScope.currentTopic}"> background: #C6B6C5</c:if>">
                                        ${topic.key} (${topic.value})         
                                    </div>
                                </a>   
                            </c:forEach>

                        </div>

                        <div class ="col-9">

                            <c:if test = "${not empty requestScope.articles}">

                                <div style = "width: 100%; height: 600px; overflow: auto;  border-left: 2px solid #C6B6C5; border-top: 2px solid #C6B6C5" class = "shadow position-relative">
                                    <div style = "width: 100%; height: 50px" class = "position-relative row">
                                        <div class ="col-4 h4 position-relative" style = "color:#C6B6C5"> 
                                            <span class ="position-absolute custom-vertical-center p-3"> 
                                                Title & General
                                            </span>
                                        </div>
                                        <div class ="col-3 h4 position-relative" style = "color:#C6B6C5"> 
                                            <span class ="position-absolute custom-vertical-center p-3"> 
                                                Picture
                                            </span>
                                        </div>
                                        <div class ="col-3 h4 position-relative" style = "color:#C6B6C5"> 
                                            <span class ="position-absolute custom-vertical-center p-3"> 
                                                Description
                                            </span>
                                        </div>
                                        <div class ="col-2 h4 position-relative" style = "color:#C6B6C5"> 
                                            <span class ="position-absolute custom-vertical-center p-3"> 
                                                Reaction
                                            </span>
                                        </div>
                                    </div>
                                    <c:forEach items = "${requestScope.articles}" var = "article">

                                        <div class ="row custom-hover-topic" style ="height: 175px; width: 100%">
                                            <div class ="col-4 position-relative">
                                                <div class ="position-absolute custom-vertical-center p-3"> 
                                                    <div class ="h4"> ${article.title} </div>
                                                    ID: ${article.ID} <br>
                                                    Topic: ${article.topic} <br>
                                                    Published Date: ${article.publishedDate} <br>
                                                    Permission: ${article.permission} <br>
                                                    Price: ${article.price}$
                                                </div>
                                            </div>
                                            <div class ="col-3 position-relative">
                                                <img src ="${article.picture}" class = "position-absolute img-thumbnail custom-center" style = "width: 85%">
                                            </div>
                                            <div class ="col-3  position-relative">
                                                <div class = "p-3 custom-vertical-center position-absolute"> 
                                                    ${article.description}
                                                </div>
                                            </div>
                                            <div class ="col-2 position-relative">
                                                <div class ="d-flex p-3 position-absolute custom-vertical-center d-inline-block" style = "width: 120px"> 
                                                    <div>  
                                                        <img src="Image/HeartIcon.png" class ="position-relative" width="20px" style = "top:-2px">
                                                        ${article.totalReaction}
                                                    </div>
                                                    <div class = "ml-3">       <img src="Image/DownloadIcon.png" class ="position-relative" width="20px" style = "top:-2px">
                                                        ${article.totalDownload} 

                                                    </div>
                                                </div>
                                            </div>

                                        </div>

                                    </c:forEach>
                                </div>
                            </c:if>

                        </div>
                    </div>                   
                </c:if>
            </div>
            <!-- End Section 1 -->
            <jsp:include page="Footer.jsp" />   
        </div>

    </body>
</html>
