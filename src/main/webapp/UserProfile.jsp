<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>USER PROFILE</title>
          <link rel="stylesheet" href="CSS/Utils.css" />
          <link rel="stylesheet" href="CSS/DivCustom.css" />
    </head>
    <body>
        <div style ="width: 100%; height: 1210px; top:0;left:0">
            <div style = "width: 350px; height: 800px; top: 160px; left: 100px; border: 2px black solid"> 
                <img class = "horizontal-center" style = "height: 180px; width: 180px; top: 50px; border-radius: 90px" src = "${sessionScope.user.picture}">
                  <div class = "horizontal-center" style = "height: 60px; top: 250px; font-size: 20px">
                    @${requestScope.user.username}
                </div>
             
                <div  class = "horizontal-center" style = "height: 40px;  top: 320px; font-size: 32px">
                 fsdf  ${requestScope.user.firstName} ${requestScope.user.lastName}
                </div>
            
                  <div class = "horizontal-center no-break" style = "height: 40px; top: 370px; font-size: 20px">
                    Articloke Pendals : ${requestScope.artichoke} <img style ="display:inline; width: 28px; height: 28px; margin-left: 10px" src = "Image/HeartIcon.png">
                </div>
                  <div  class = "horizontal-center" style = "height: 40px;  top: 580px; font-size: 20px">
                 DOB : ${requestScope.user.DOB}
                </div>
                <div  class = "horizontal-center" style = "height: 40px;  top: 620px; font-size: 20px">
                 Address : ${requestScope.user.address} ${requestScope.user.lastName}
                </div> 
                <div  class = "horizontal-center" style = "height: 40px;  top: 660px; font-size: 20px">
                 Organization : ${requestScope.user.organization} ${requestScope.user.lastName}
                </div>
                 <div  class = "horizontal-center" style = "height: 40px;  top: 700px; font-size: 20px">
                 Phone Number : ${requestScope.user.phoneNumber} ${requestScope.user.lastName}
                </div>
                 <div  class = "horizontal-center" style = "height: 40px;  top: 740px; font-size: 20px">
                 Role : ${requestScope.user.role} ${requestScope.user.lastName}
                </div>
                
            </div>
              
            
            
            <div style = "width: 850px; height: 700px; top: 210px; right: 100px; border: 2px black solid">
                <div style = "width: 800px; height: 400px; top: 25px; right: 25px">
                    <div style = "top: 0; font-size: 32px;font-weight: bold" class = "horizontal-center"> INFLUENCE </div>
                    <div   style = "top: 100px; font-size: 20px; left: 80px"> Total Published Articles: 999 ${requestScope.numAr}</div>
                     <div style = "top: 100px; font-size: 20px; left: calc(50% + 80px)"> Total Downloaded: 9999 </div>
                    
                </div>
                <div style = "width: 800px; height: 325px; bottom: 25px; right: 25px"> 
                    <div class = "horizontal-center" style = "font-size: 32px; font-weight: bold; top: 15px"> Comments </div>
                    
                </div>
            </div>  
            
            <jsp:include page="Footer.jsp" />
              <jsp:include page="Navigation.jsp" />
            </div>
            
    </body>
</html>
