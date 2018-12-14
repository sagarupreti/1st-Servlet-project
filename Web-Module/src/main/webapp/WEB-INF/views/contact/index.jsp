<%@include  file="../shared/header.jsp" %>
<div class="page-header">
    <h1>Contact</h1>
</div>
<form action="${SITE_URL}/contact" method="post">
    <div class="row">
        <div class="col-md-5">
            <div class="form-group">
                <label>Name</label>
                <input type="text" name="name" class="form-control" required="required"/>
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <label>Email</label>
                <input type="email" name="email" class="form-control" required="required"/>
            </div>
        </div>
    </div>
        <div class="row">
            <div class="col-md-10">
                <div class="form-group">
                    <label>Subject</label>
                    <input type="text" name="subject" class="form-control" required="required"/>
                </div>
            </div> 
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="form-group">
                    <label>Message</label>
                    <textarea name="message" style="height:150px" class="form-control" required="reqired"></textarea>
                </div>
            </div>
        </div>
    <button type="submit" class="btn- btn-success">
        <span class="glyphicon glyphicon-envelope"></span> send</button>
</form>
<%@include  file="../shared/footer.jsp" %>