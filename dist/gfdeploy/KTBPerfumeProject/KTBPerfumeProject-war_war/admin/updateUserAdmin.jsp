<%@include file="admin_header.jsp" %>
<%@include file="admin_left.jsp" %>
<div class="row">
    <div class="col-md-8 col-xs-12">
        <center>
            <h3 class="box-title">Update user</h3>
        </center>
        <div class="white-box">     
            <form class="form-horizontal form-material" action="./updateUserAdminServlet" method="post" enctype="multipart/form-data" >
                <div class="form-group">
                    <label class="col-md-12">User Name</label>
                    <div class="col-md-12">
                        <input value="${p.username}" type="hidden" name="UserId" >
                        <input value="${p.username}" type="text" class="form-control form-control-line" readonly> </div>
                </div>
                <div class="form-group">
                    <label class="col-md-12">Full Name</label>
                    <div class="col-md-12">
                        <input value="${p.fullName}" type="text" class="form-control form-control-line" name="UserName" > </div>
                </div>
                <div class="form-group">
                    <label class="col-md-12">Password</label>
                    <div class="col-md-12">
                        <input value="${p.password}" type="password" class="form-control form-control-line" name="UserPass" > 
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-12">email</label>
                    <div class="col-md-12">
                        <input  value="${p.email}" type="text" class="form-control form-control-line"  name="UserEmail"  > </div>
                </div>
                <div class="form-group">
                    <label class="col-md-12">avatar</label>
                    <input type="file" style="margin-left: 12px" name="file" id="file">
                </div><br/>
                <div class="form-group">
                    <label class="col-md-12">role</label>
                    <div class="col-md-12">
                        <input value="${p.role}" type="text" class="form-control form-control-line" name="role" readonly> </div>
                </div>
                <div class="form-group">
                    <label class="col-md-12">status</label>
                    <div class="col-md-12">

                        <input type="radio" name="Status" value="true" <c:if test="${p.status}">checked</c:if>> active<br>
                        <input type="radio" name="Status" value="false" <c:if test="${!p.status}">checked</c:if>> inactive<br>

                    </div>
                </div>
                <div class="form-group">
                    <div class="form-group">
                        <div class="col-sm-12">
                            <button class="btn btn-success">Update</button>&emsp;
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<%@include file="admin_fooder.jsp" %>

