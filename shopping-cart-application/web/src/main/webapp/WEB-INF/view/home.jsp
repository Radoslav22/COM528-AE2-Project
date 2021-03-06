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

    
    <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h3 class="modal-title" id="exampleModalCenterTitle">Basket Content</h3>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body"> 
                    <c:forEach var="item" items="${shoppingCartItems}">
                        <div class="col-sm">
                            <div class="row no-gutters">
                                <div class="col-8 col-sm-4 col-md-3"><h4>${item.name}</h4></div>
                                <div class="col-8 col-sm-4 col-md-3"><h4>??${item.price}</h4></div>
                                <div class="col-8 col-sm-4 col-md-3"><h4>${item.quantity}</h4></div>
                                <div class="col-4 col-md-2 col-md-offset-0">
                                <form action="./home" method="post">
                                    <input type="hidden" name="itemUUID" value="${item.uuid}">
                                    <input type="hidden" name="itemName" value="${item.name}">
                                    <input type="hidden" name="action" value="removeItemFromCart">
                                    <button type="submit" class="btn btn-danger" >Remove Item</button>
                                </form>
                            </div>
                        </div>
                    </div>
                    <hr/>
                </c:forEach>
            </div>

            <div class="modal-footer">
                <div class="col-4 col-sm-4 col-md-4 col-md-pull-1 "><h4>Total: ??${shoppingcartTotal}</h4></div>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button onclick="window.location.href = './checkout'" type="button" class="btn btn-primary">Checkout</button>
            </div>
        </div>
    </div>
</div>

</main>
<jsp:include page="footer.jsp" />
