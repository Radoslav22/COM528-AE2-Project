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
    <H1>Create a New Account</H1>
    <div id="error" class="alert alert-danger">${errorMessage}</div>
    <div class="alert alert-success">${message}</div>
    

    <p>Username must be unique and password must be at least 8 characters</p>
    <form action="./register" method="POST">
        <fieldset>
            <div class="form-group">
                <label for="Username">Username</label>
                <input id="Username" type="text" name="username" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="Password">Password</label>
                <input id="Password" type="password" name="password2" class="form-control" />
            </div>
            <div class="form-group">
                <label for="Re-enter">Re Enter Password</label>
                <input id="Re-enter" type="password" name="password2" class="form-control" />
            </div>
            <input type="hidden" name="action" value="createNewAccount">
            <button type="submit" class="btn btn-success">Create New Account</button>
        </fieldset>
    </form> 

</main>


<jsp:include page="footer.jsp" />
