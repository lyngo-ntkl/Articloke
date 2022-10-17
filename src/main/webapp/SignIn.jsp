<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign In</title>
        <link rel="stylesheet" href="CSS/Custom.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class = "custom-big-container">
        <!-- Div Surround -->
            <jsp:include page="Navigation.jsp" />
            <!-- Section 1 -->
            <div class ="position-absolute p-0 custom-center" style ="border: 1px solid;  width: 100%; max-width: 600px; top: 45%">
                <div class = "text-center h3 mt-3"> 
                    Sign In
                </div>
                
                <div class = "row">
                    <!-- SignIn by article account -->
                    <div class = "col-lg-6 pb-3">
                        <form action = "SignInServlet" id = "SignInServlet" method = "post">                          
                        </form>
                        
                        <div class = "h5 text-center mt-3">
                            Articloke Account
                        </div>
                        
                        <div class = "px-4 mt-4"> 
                            <div>
                                Username
                            </div>
                            <input form ="SignInServlet" type="text" class="form-control mt-1" placeholder="Username" name = "username" value = "${requestScope.username}">
                            
                            <div class = "d-flex mt-1" style = "justify-content: space-between; align-items: center"> 
                                <div>
                                    Password
                                </div>
                                
                                <div class = "position-relative float-right" style="right: 0">
                                    Forget Password?
                                </div>
                            </div>   

                            <input form ="SignInServlet" type="password" class="form-control mt-1" placeholder="Password" name = "password" value = "">
                            <c:if test = "${requestScope.signInError}">    
                                <div class = "text-center" style = "color:red">
                                    Incorrect username or password 
                                </div>
                            </c:if>
                        </div>     
                        <input form ="SignInServlet" type ="submit" class ="position-relative custom-horizontal-center mt-4 btn btn-light border-dark" value = "Sign In">
                        
                        <div class = "mt-3 text-center">
                            Do not have an account?
                            <a href = "SignUp.jsp" style ="color: black">
                                Sign Up
                            </a>   
                        </div>
                    </div>
                    <!-- End SignIn by article account -->
                    <!-- SignIn by google account -->
                    <div class ="col-lg-6 pb-3">
                        <div class = "h5 text-center mt-3">
                            Google Account
                        </div> 
                        
                        <a class = "position-absolute custom-horizontal-center" style ="top: 30%" href="https://accounts.google.com/o/oauth2/auth?scope=email profile&redirect_uri=http://localhost:8080/Articloke/GoogleSignInServlet&response_type=code
                           &client_id=52738076021-1bvsa3fq1vg3ktl82ghicqd9c8k3vet9.apps.googleusercontent.com&approval_prompt=force">
                            <div class = "horizontal-center hover-white-image" style = "top: 80px; width: 80px; height: 80px;"> 
                                <img style ="width: 100%; height: 100%" src = "Image/GoogleIcon.png"> 
                            </div>
                        </a>
                        
                        <div class = "position-absolute" style = "bottom: 15px"> By Continuing with Google , you are agreeing to our Terms
                            & Conditions.</div>
                    </div>
                    <!-- End SignIn by google account -->
                </div>

            </div>           
            <!-- End Section 1 -->
            <jsp:include page="Footer.jsp" />
        <!-- End Div Surround -->
        </div>
    </body>
</html>
