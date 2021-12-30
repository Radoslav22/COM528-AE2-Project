<%-- 
    Document   : content
    Created on : Jan 4, 2020, 11:19:47 AM
    Author     : cgallen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
// request set in controller
//request.setAttribute("selectedPage", "home");
%>
<jsp:include page="header.jsp" />
<!-- Begin page content -->
<main role="main" class="container">
    <H1>Home</H1>
    <div style="color:red;">${errorMessage}</div>
    <div style="color:green;">${message}</div>

    <H1>Available Items</H1>
    <table class="table">

        <tr>
            <th>Item Name</th>
            <th>Price</th>
            <th>Stock</th>
        </tr>

        <c:forEach var="item" items="${availableItems}">

            <tr>
                <td>${item.name}</td>
                <td>${item.price}</td>
                <td>${item.stock}</td>

                <td></td>
                <td>
                    <!-- post avoids url encoded parameters -->
                    <form method="POST">
                        <fieldset>
                            <div class="form-group">
                                <input type="hidden" name="itemName" value="${item.name}" class="form-control">
                                <input type="hidden" name="action" value="changestock">
                                <input type="text" name="stock" value="${item.stock}" class="form-control">
                                <input type="submit" value="changestock" class="btn btn-primary" >
                            </div>
                        </fieldset>
                    </form>    
                </td>
            </tr>
        </c:forEach>

    </table>
    <form method="POST">
        <input type="hidden" name="action" value="append">
        <input type="submit" value="Additem" class="btn btn-primary">
    </form>



</main>
<jsp:include page="footer.jsp" />
