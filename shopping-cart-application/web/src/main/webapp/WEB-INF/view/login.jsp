<%-- 
    Document   : content
    Created on : Jan 4, 2020, 11:19:47 AM
    Author     : cgallen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
// request set in controller
//    request.setAttribute("selectedPage","contact");
%>
<jsp:include page="header.jsp" />
<!-- Begin page content -->
<main role="main" class="container">
    <H1>Login</H1>
    <div id="error" class="alert alert-danger">${errorMessage}</div>
    <div class="alert alert-success">${message}</div>

    <form action="./login" method="post">
        <fieldset>
            <input type="hidden" name="action" value="login" />
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" type="text" name="username" class="form-control" />
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" type="password" name="password" class="form-control" />
            </div>
            <button type="submit" class="btn btn-primary">Log In</button>
        </fieldset>
    </form> 
    <hr>
    <a href="./register" class="btn btn-success">Create a new account</a>
</main>


<jsp:include page="footer.jsp" />
