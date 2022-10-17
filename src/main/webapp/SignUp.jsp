<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Up</title>
        <link rel="stylesheet" href="CSS/Custom.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    </head>
    <body>
        <!-- Div Surround -->
        <div class = "custom-big-container" style = "min-height: 150%">
            <jsp:include page="Navigation.jsp" /> 
            <!-- Section 1 -->
            <div class ="position-absolute p-3 custom-center" style ="border: 1px solid; width: 400px; top: 45%">
                <div class = "text-center h3">
                    Sign Up
                </div>

                <form action = "SignUpServlet" id = "SignUpServlet" method = "get">                 
                </form>

                <div class = "h5 text-center mt-3"> 
                    Create an Articloke account
                </div>
                <div class = "mt-3"> 
                    <div class = "mt-1">
                        Username*
                    </div>
                    <input form = "SignUpServlet" type="text" class="form-control mt-1"  placeholder="Username" name = "username" value = "${requestScope.username}">   
                    <span style = "color:red">${requestScope.usernameError}</span>

                    <div class = "mt-1"> 
                        Password*
                    </div> 
                    <input form = "SignUpServlet" type="password" class="form-control mt-1" placeholder="Password" name = "password" value = "">
                    <span style = "color:red">${requestScope.passwordError} </span>

                    <div class = "mt-1">
                        Confirm Password*
                    </div>
                    <input form = "SignUpServlet" type="password" class="form-control mt-1"  placeholder="Confirm Password" name = "confirm" value = "">   
                    <span style = "color:red">${requestScope.confirmError} </span>

                    <div class = "mt-1">
                        Name*
                    </div> 
                    <div class = "d-flex">
                        <div class = "pr-3">
                            <input form = "SignUpServlet" type ="text" class="form-control mt-1" placeholder="First Name" name = "firstName" value = "${requestScope.firstName}">
                        </div>
                        <div class = "pl-3">
                            <input form ="SignUpServlet" type="text" class="form-control mt-1" placeholder="Last Name" name = "lastName" value = "${requestScope.lastName}">
                        </div> 
                    </div>
                    <c:if test = "${not empty requestScope.firstNameError}">
                        <span style = "color:red">
                            ${requestScope.firstNameError} 
                        </span> 
                        <br> 
                    </c:if>  
                    <span style = "color:red">
                        ${requestScope.lastNameError} 
                        </span>
                    <div class = "custom-horizontal-center position-relative d-flex mt-3">
                        <input form ="SignUpServlet" name ="term" form ="SignUp" class = "vertical-center mr-3" type = "checkbox" value = "checked">

                        <div class = "vertical-center" style="text-align:justify; left: 30px;"> 
                            I have read and understood the Registered User Agreement and agree to be bound by all of its terms.
                        </div>
                    </div> 
                        <c:if test = "${not empty requestScope.termError}"> 
                    <span style = "color:red">
                        ${requestScope.termError} <br>
                    </span> 
                    </c:if>
                    <input form ="SignUpServlet" type ="submit" class ="position-relative custom-horizontal-center mt-3 btn btn-light border-dark" value = "Sign Up">
                    <div class = "mt-3 text-center">
                        Already have an account? 
                        <a href = "SignIn.jsp" style ="color: black">
                            Sign In
                        </a>   
                    </div>
                </div>

            </div>  
            <!-- End Section 1 -->
            <jsp:include page="Footer.jsp" /> 
        </div>
        <!-- End Div Surround -->
    </body>
</html>
