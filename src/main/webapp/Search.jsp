<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>

        <link rel="stylesheet" href="CSS/Custom.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </head>
    <body>
        <div class ="custom-big-container">
            <jsp:include page="Navigation.jsp" /> 
            <div class ="container-fluid position-relative pb-4 pt-1" >  
                <form id = "ShowArticleResultServlet" action = "ShowArticleResultServlet"> 
                </form>
                <div class = "container">
                    <div class = "h5 position-relative mt-4">Just give Articloke a keyword, then all matched results will be displayed </div>
                    <div class ="d-flex">
                        <div class="input-group p-relative mt-2" style ="max-width: 300px" >
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="1">Keyword</span>
                            </div>
                            <input type="text" class="form-control" form ="ShowArticleResultServlet" placeholder="All" aria-label="Keyword" name ="keyword" value ="${requestScope.keyword}" aria-describedby="1">
                        </div>
                        <button class ="btn btn-light  mx-3 mt-1 position-relative border-dark" data-toggle="collapse" data-target="#j1">Advanced Search</button>   

                        <input  type ="hidden" form ="ShowArticleResultServlet" name = "organization" value = "${sessionScope.user.organization}">
                        <form id = "ResetParamsServlet" action = "ResetParamsServlet"> </form>
                        <input form = "ResetParamsServlet" type ="submit" value = "Reset" class = "mt-1 btn btn-light border-dark">

                        <input class ="ml-3 mt-1" form ="ShowArticleResultServlet" type ="image" src = "Image/SearchIcon.png" width = "40" height= "40" >
                    </div>
                    <div id="j1" class="collapse mt-3">
                        <div class = "row">
                            <div class ="col-2">
                                <div class="input-group position-relative"  >
                                    <div class="input-group-prepend">
                                        <span class="input-group-text" id="2">Title</span>
                                    </div>
                                    <input type="text" class="form-control" form ="ShowArticleResultServlet" placeholder="All" aria-label="Title" aria-describedby="2" name = "title" value = "${requestScope.title}">
                                </div>        
                            </div>
                            <div class ="col-2">
                                <div class="input-group position-relative">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text" id="3">Author</span>
                                    </div>
                                    <input type="text" form ="ShowArticleResultServlet" class="form-control" placeholder="All" aria-label="Author" aria-describedby="3" name = "author" value = "${requestScope.author}">
                                </div>        
                            </div>    
                            <div class ="col-2">
                                <div class="input-group position-relative" >
                                    <div class="input-group-prepend">
                                        <span class="input-group-text" id="4">Topic</span>
                                    </div>
                                    <select form ="ShowArticleResultServlet" type="text" class="form-control" placeholder="Topic" aria-label="Topic" aria-describedby="4" name = "topic">
                                        <option <c:if test = "${requestScope.topic == 'All'}"> selected</c:if> value = "All"> All </option>
                                        <c:forEach items = "${sessionScope.topics}" var = "topic">
                                            <option <c:if test = "${requestScope.topic == topic.topic}"> selected</c:if> value = "${topic.topic}"> ${topic.topic}</option>
                                        </c:forEach>

                                    </select>
                                </div>        
                            </div>    

                            <div class ="col-3">
                                <div class="input-group position-relative" >
                                    <div class="input-group-prepend">
                                        <span class="input-group-text" id="5">Permission</span>
                                    </div>
                                    <select form ="ShowArticleResultServlet" name = "permission" type="text" class="form-control" placeholder="Permission" aria-label="Permission" aria-describedby="5">
                                        <option <c:if test = "${requestScope.permission == 'All'}"> selected</c:if> value = "All"> All</option>
                                        <option <c:if test = "${requestScope.permission == 'Public'}"> selected</c:if> value = "Public"> Public</option>
                                        <option <c:if test = "${requestScope.permission == 'For Organization'}"> selected</c:if> value = "For Organization">For Organization</option>
                                        <option <c:if test = "${requestScope.permission == 'Private'}"> selected</c:if> value = "Private">Private</option>
                                        </select>
                                    </div>        
                                </div>     
                                <div class ="col-3">
                                    <div class="input-group position-relative" >
                                        <div class="input-group-prepend">
                                            <span class="input-group-text" id="6">Sorted By</span>
                                        </div>
                                        <select form ="ShowArticleResultServlet" name = "sortedBy" type="text" class="form-control" placeholder="Permission" aria-label="Permission" aria-describedby="5">
                                            <option <c:if test = "${requestScope.sortedBy == 'None'}"> selected </c:if> value = "None"> None</option>
                                        <option <c:if test = "${requestScope.sortedBy == 'Published Date'}"> selected </c:if> value = "Published Date"> Published Date (Oldest - Latest)</option>
                                        <option <c:if test = "${requestScope.sortedBy == 'Alphabet'}"> selected </c:if> value = "Alphabet"> Alphabet (A-Z)</option>

                                        </select>
                                    </div>        
                                </div>    
                            </div>
                        </div>
                    </div>  
                </div>

                <div class ="container mt-3">

                <c:if test = "${not empty requestScope.articles}"> 
                    <span class = "h5"> All Results (${requestScope.articles.size()}) </span>

                    <div class ="custom-horizontal-line"> </div>
                    <div class ="row mt-3"> 
                        <c:forEach begin = "${requestScope.minIndexRow1}" end = "${requestScope.maxIndexRow1}" varStatus = "status" >
                            <div class ="col-3 p-3">
                                <a class = "custom-no-hyperlink-display" href= "DisplayArticleServlet?ID=${requestScope.articles.get(status.index).ID}">
                                    <div style = "border: 1px solid" class = "shadow custom-hover-topic">
                                        <div class = "p-3"> 
                                            <div class = "custom-square-container"> 
                                                <img src="${requestScope.articles.get(status.index).picture}" class = "position-absolute" style = "width: 100%"/>
                                            </div>
                                            <div class ="mt-3 h3"> ${requestScope.articles.get(status.index).title}</div>
                                            <div class ="mt-1"> ID: ${requestScope.articles.get(status.index).ID}</div>
                                            <div class ="mt-1"> Author: ${requestScope.articles.get(status.index).username}</div>
                                            <div class ="mt-1"> Topic: ${requestScope.articles.get(status.index).topic}</div>
             
                                            <div class ="mt-1"> Published Date: ${requestScope.articles.get(status.index).publishedDate}</div>

                                            <div class ="d-flex mt-2 "> 
                                                <div>  
                                                    <img src="Image/HeartIcon.png" class ="position-relative" width="20px" style = "top:-2px">
                                                    ${requestScope.articles.get(status.index).totalReaction}
                                                </div>
                                                <div class = "ml-3">       <img src="Image/DownloadIcon.png" class ="position-relative" width="20px" style = "top:-2px">
                                                    ${requestScope.articles.get(status.index).totalDownload} 

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </a>                
                            </div> 


                        </c:forEach>
                    </div>
                    <c:if test = "${requestScope.existRow2}">
                        <div class ="row mt-3"> 
                            <c:forEach begin = "${requestScope.minIndexRow2}" end = "${requestScope.maxIndexRow2}" varStatus = "status" >
                                <div class ="col-3 p-3">
                                    <a class = "custom-no-hyperlink-display" href= "DisplayArticleServlet?ID=${requestScope.articles.get(status.index).ID}">
                                        <div style = "border: 1px solid" class = "shadow custom-hover-topic">
                                            <div class = "p-3"> 
                                                <div class = "custom-square-container"> 
                                                    <img src="${requestScope.articles.get(status.index).picture}" class = "position-absolute" style = "width: 100%"/>
                                                </div>
                                                <div class ="mt-3 h3"> ${requestScope.articles.get(status.index).title}</div>
                                                <div class ="mt-1"> ID: ${requestScope.articles.get(status.index).ID}</div>
                                                <div class ="mt-1"> Author: ${requestScope.articles.get(status.index).username}</div>
                                                <div class ="mt-1"> Topic: ${requestScope.articles.get(status.index).topic}</div>
                                  
                                                <div class ="mt-1"> Published Date: ${requestScope.articles.get(status.index).publishedDate}</div>

                                                <div class ="d-flex mt-2 "> 
                                                    <div>  <img src="Image/HeartIcon.png" class ="position-relative" width="20px" style = "top:-2px">
                                                        ${requestScope.articles.get(status.index).totalReaction} </div>

                                                    <div class = "ml-3">  <img src="Image/DownloadIcon.png" class ="position-relative" width="20px" style = "top:-2px">
                                                        ${requestScope.articles.get(status.index).totalDownload} 

                                                    </div>
                                                </div>
                                            </div>
                                        </div> 
                                    </a>
                                </div> 

                            </c:forEach>

                        </div>
                    </c:if> 
                </c:if>
                <c:if test = "${empty requestScope.articles && requestScope.searchEmpty}">
                    <span class = "h2">No result found </span>
                    &nbsp; Please edit your search query to find results

                </c:if>
                <c:if test = "${!requestScope.searchEmpty}">
                    <span class = "h2 ">Explore scientific, technical, and medical research</span> 
                    <br>
                    <img src ="Image/Fancy.png" class ="mt-3 position-relative" style = "width: 40%">

                </c:if>
            </div>


            <c:if test = "${not empty requestScope.articles}">
                <div class = "container position-relative mt-3">
                    <form id ="MovePageServlet" action = "MovePageServlet"></form>
                    <input form ="MovePageServlet" type = "hidden" name = "keyword" value = "${requestScope.keyword}">
                    <input form ="MovePageServlet" type = "hidden" name = "title" value = "${requestScope.title}">
                    <input form ="MovePageServlet" type = "hidden" name = "author" value = "${requestScope.author}">
                    <input form ="MovePageServlet" type = "hidden" name = "topic" value = "${requestScope.topic}">
                    <input form ="MovePageServlet" type = "hidden" name = "organization" value = "${sessionScope.user.organization}">
                    <input form ="MovePageServlet" type = "hidden" name = "permission" value = "${requestScope.permission}">
                    <input form ="MovePageServlet" type = "hidden" name = "sortedBy" value = "${requestScope.sortedBy}">
                    <input form ="MovePageServlet" type = "hidden" name = "currentPage" value = "${requestScope.currentPage}">
                    <input form ="MovePageServlet"type = "hidden" name = "minIndexRow1" value = "${requestScope.minIndexRow1}">
                    <input form ="MovePageServlet" type = "hidden" name = "maxIndexRow1" value = "${requestScope.maxIndexRow1}">
                    <input form ="MovePageServlet"type = "hidden" name = "minIndexRow2" value = "${requestScope.minIndexRow2}">
                    <input form ="MovePageServlet" type = "hidden" name = "maxIndexRow2" value = "${requestScope.maxIndexRow2}">
                    <input form ="MovePageServlet" type = "hidden" name = "maxPage" value = "${requestScope.maxPage}">
                    <c:if test="${requestScope.currentPage > 1}" >
                        <input form ="MovePageServlet" type = "submit" class ="d-inline-block btn btn-light border-dark mr-3 position-relative"   name = "action" value = "Previous">
                    </c:if>
                    <div  class = "d-inline-block position-relative h5" style = "top:4px">
                        Page 
                        <c:if test = "${not empty requestScope.currentPage}">
                            ${requestScope.currentPage}     
                        </c:if>
                        <c:if test = "${empty requestScope.currentPage}">
                            1
                        </c:if>
                        of 
                        <c:if test = "${not empty requestScope.maxPage}">
                            ${requestScope.maxPage}    
                        </c:if>
                        <c:if test = "${empty requestScope.maxPage}">
                            1
                        </c:if>

                    </div>
                    <c:if test="${requestScope.currentPage < requestScope.maxPage}" >
                        <input form ="MovePageServlet" type = "submit" name = "action" value = "Next" class = "d-inline-block ml-3 btn btn-light border-dark position-relative">
                    </c:if>
                </div>
            </c:if>
            <jsp:include page="Footer.jsp" /> 
        </div> 


    </body>
</html>
