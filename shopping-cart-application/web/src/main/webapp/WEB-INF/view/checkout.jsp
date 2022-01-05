<%-- 
    Document   : checkout
    Created on : Dec 31, 2021, 1:03:45 PM
    Author     : Radoslav
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
// request set in controller
//    request.setAttribute("selectedPage","contact");

    
%>
<jsp:include page="header.jsp" />
<!-- Begin page content -->
<main role="main" class="container">
    <H1>Checkout</H1>
    <h4>The value of your order is: £${shoppingcartTotal}</h4>
    <form action="./checkout" method="POST">
        <fieldset>
            <div class="form-group">
                <label for="name">Name</label>
                <input id="name" type="text" name="Name"  class="form-control" required />
            </div>
            <div class="form-group">
                <label for="enddate">End Date</label>
                <input id="enddate" type="text" name="Enddate"  class="form-control" required />
            </div>
            <div class="form-group">
                <label for="cardnumber">Card Number</label>
                <input id="cardnumber" type="text" name="Cardnumber"  class="form-control" required />
            </div>
            <div class="form-group">
                <label for="cvv">CVV</label>
                <input id="cvv" type="text" name="Cvv"  class="form-control" required />
            </div>
            <div class="form-group">
                <label for="issuenumber">Issue Number</label>
                <input id="issuenumber" type="text" name="Issuenumber"  class="form-control" required />
            </div>
            <input type="hidden" name="action" value="submituserdetails">
            <button type="submit" class="btn btn-primary">Finish Order</button>
        </fieldset>
    </form>
</main>


<jsp:include page="footer.jsp" />
