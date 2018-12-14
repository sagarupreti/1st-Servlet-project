<%@include  file="../shared/header.jsp" %>
<div class="page-header">
    <h1>Login</h1>
</div>
<c:if test="${param.error != null}">
    <div class="alert alert-danger" role="alert">
        Invalid UserName/Password please try again !!!
</div>
</c:if>
    <form action="${SITE_URL}/login" method="post">
        <div class="row">
            <div class="col-md-10">
                <div class="form-group">
                    <label>User Name</label>
                    <input type="text" name="username" class="form-control" required="required"/>
                </div>
            </div>
            <div class="col-md-10">
                <div class="form-group">
                    <label>Password</label>
                    <input type="password" name="password" class="form-control" required="required"/>
                </div>
            </div>
        </div>
            <button type="submit" class="btn btn-success">
        <span class="glyphicon glyphicon-user"></span> Login</button>
    </form>
<%@include  file="../shared/footer.jsp" %>