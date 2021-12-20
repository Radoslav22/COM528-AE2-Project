<%-- 
    Document   : bank
    Created on : Dec 3, 2021, 2:53:41 PM
    Author     : Radoslav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />
<main role="main" class="container">
   <h1>Bank properties</h1>
   <div style="color:red;">${errorMessage}</div>
   <div style="color:green;">${message}</div>
      
        <form method="POST"> 
            <div class ="form-group">
                
                <div class="col-lg-10">    <input class="form-control" type="text" name="bankurl" value="${bankUrl}" placeholder="Bank URL input here..." readonly></div>
                <div class="col-lg-10">    <input class="form-control" type="text" name="accname" value="${admin_username}" placeholder="Bank Username input here..." readonly></div>
                <div class="col-lg-10">    <input class="form-control" type="text" name="enddate" value="${admin_enddate}" placeholder="Card End Date input here..." readonly> </div>
                <div class="col-lg-10">    <input class="form-control" type="text" name="cardnumber" value="${admin_cardnumber}" placeholder="Card Number input here..." readonly></div>
                <div class="col-lg-10">    <input class="form-control" type="text" name="cvv" value="${admin_cvv}" placeholder="Card Cvv input here..." readonly></div>
                <div class="col-lg-10">    <input class="form-control" type="text" name="issuenumber" value="${admin_issuenumber}" placeholder="Card Issue Number input here..." readonly></div>
                <input class="form-control" type="hidden" name="action" value="saveproperties">
                <input class="btn btn-outline-primary" type="submit" value="Save Properties">
            </div>
            
        </form>
    
</main>
<jsp:include page="footer.jsp" />
