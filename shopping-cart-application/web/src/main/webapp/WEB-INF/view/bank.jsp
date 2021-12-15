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
            <input type="text" name="bankurl" value="${bankUrl}">
            <input type="text" name="accname" value="${admin_username}">
            <input type="text" name="enddate" value="${admin_enddate}"> 
            <input type="text" name="cardnumber" value="${admin_cardnumber}">
            <input type="text" name="cvv" value="${admin_cvv}">
            <input type="text" name="issuenumber" value="${admin_issuenumber}">
            <input type="hidden" name="action" value="saveproperties">
            <input type="submit" value="Save Properties">
        </form>
    
</main>
<jsp:include page="footer.jsp" />
