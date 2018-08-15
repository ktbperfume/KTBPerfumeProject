<%@include file="admin_header.jsp" %>
<%@include file="admin_left.jsp" %>
<div class="row">
    <div class="col-md-8 col-xs-12">
        <center>
            <h3 class="box-title">Insert Account</h3>
        </center>
        <code><a href="admin_manage_account.jsp">List Account</a></code>
        <div class="white-box">     
            <form class="form-horizontal form-material" action="insertUserServlet" method="post">
                <div class="form-group">
                    <label class="col-md-12">User Name</label>
                    <div class="col-md-12">
                        <input name="username" type="text" placeholder="Johnathan123" class="form-control form-control-line"> </div>
                </div>
                <div class="form-group">
                    <label class="col-md-12">Password</label>
                    <div class="col-md-12">
                        <input name="password" type="password" placeholder="123456Joh" class="form-control form-control-line"> </div>
                </div>
                <div class="form-group">
                    <label class="col-md-12">FullName</label>
                    <div class="col-md-12">
                        <input name="fullName"type="fullname" placeholder="Johnathan" class="form-control form-control-line"> </div>
                </div>
                <div class="form-group">
                    <label class="col-md-12">Avatar</label>
                    <input name="file" type="file" style="margin-left: 12px"/>
                </div><br/>
                <div class="form-group">
                    <label for="example-email" class="col-md-12">Email</label>
                    <div class="col-md-12">
                        <input name="email" type="email" placeholder="johnathan@gmail.com" class="form-control form-control-line" id="example-email"> </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-12">Role</label>
                    &emsp;<label class="radio-inline">
                        <input type="radio" name="role" id="optionsRadiosInline1" value="Admin" checked=""/>
                        Admin
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="role" id="optionsRadiosInline2" value="SalePerson"/>
                        Sale Person
                    </label>
                </div>
                <div class="form-group">
                    <div class="col-sm-12">
                        <button class="btn btn-success" type="submit">Insert</button>&emsp;
                        <button class="btn btn-danger">Reset</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<%@include file="admin_fooder.jsp" %>
