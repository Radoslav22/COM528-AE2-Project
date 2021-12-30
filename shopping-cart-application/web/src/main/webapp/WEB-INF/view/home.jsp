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
            <th></th>
        </tr>

        <c:forEach var="item" items="${availableItems}">

            <tr>
                <td>${item.name}</td>
                <td>${item.price}</td>
                <td></td>
                <td>
                    <!-- post avoids url encoded parameters -->
                    <form action="./home" method="get">
                        <fieldset>
                            <div class="form-group">
                                <input type="hidden" name="itemName" value="${item.name}">
                                <input type="hidden" name="action" value="addItemToCart">
                                <button type="submit" class="btn btn-primary">Add Item</button>
                            </div>
                        </fieldset>
                    </form> 
                </td>
            </tr>

        </c:forEach>
    </table>

    <H1>Shopping cart</H1>
    <table class="table">

        <tr>
            <th>Item Name</th>
            <th>Price</th>
            <th>Quantity</th>
        </tr>
        <c:forEach var="item" items="${shoppingCartItems}">

            <tr>
                <td>${item.name}</td>
                <td>${item.price}</td>
                <td>${item.quantity}</td>
                <td>
                    <!-- post avoids url encoded parameters -->
                    <form action="./home" method="post">
                        <fieldset>
                            <input type="hidden" name="itemUUID" value="${item.uuid}">
                            <input type="hidden" name="itemName" value="${item.name}">
                            <input type="hidden" name="action" value="removeItemFromCart">
                            <button type="submit" class="btn btn-danger">Remove Item</button>
                        </fieldset>
                    </form> 
                </td>
            </tr>
        </c:forEach>

        <tr>
            <td>TOTAL</td>
            <td>${shoppingcartTotal}</td>
        </tr>
    </table>
    <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalCenterTitle">Basket Content</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <c:forEach var="item" items="${shoppingCartItems}">

                        <tr>
                            <td>${item.name}</td>
                            <td>${item.price}</td>
                            <td>${item.quantity}</td>
                            <td>
                                <!-- post avoids url encoded parameters -->
                                <form action="./home" method="post">
                                    <input type="hidden" name="itemUUID" value="${item.uuid}">
                                    <input type="hidden" name="itemName" value="${item.name}">
                                    <input type="hidden" name="action" value="removeItemFromCart">
                                    <button type="submit" class="btn btn-danger">Remove Item</button>
                                </form> 
                            </td>
                        </tr>
                    </c:forEach>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Checkout</button>
                </div>
            </div>
        </div>
    </div>



</main>
<jsp:include page="footer.jsp" />
