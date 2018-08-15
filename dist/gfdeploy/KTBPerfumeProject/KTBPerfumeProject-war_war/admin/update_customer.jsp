<%@include file="admin_header.jsp" %>
<%@include file="admin_left.jsp" %>
<div class="row">
    <div class="col-md-8 col-xs-12">
        <center>
            <h3 class="box-title">Update Customer</h3>
        </center>
        <div class="white-box">     
            <form class="form-horizontal form-material" action="./updateCustomerAdminServlet" method="post" >
                <div class="form-group">
                    <label class="col-md-12">Customer ID</label>
                    <div class="col-md-12">
                        <input value="${p.customerId}" type="hidden" name="CustomerId" >
                        <input value="${p.customerId}" type="text" class="form-control form-control-line" readonly> </div>
                </div>
                <div class="form-group">
                    <label class="col-md-12">Customer Name</label>
                    <div class="col-md-12">
                        <input value="${p.fullName}" type="text" class="form-control form-control-line" name="CustomerName" readonly> </div>
                </div>
                <div class="form-group">
                    <label class="col-md-12">Password</label>
                    <div class="col-md-12">
                        <input value="${p.password}" type="password" class="form-control form-control-line" name="CustomerPass" > 
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-12">gender</label>
                    <div class="col-md-12">
                        <input value="${p.gender}" type="text" class="form-control form-control-line" name="CustomerGender" readonly> 
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-12">dateOfBirth</label>

                    <input value="${p.dateOfBirth}" type="text" class="form-control form-control-line" name="CustomerDob" readonly>
                </div>
                <div class="form-group">
                    <label class="col-md-12">email</label>
                    <div class="col-md-12">
                        <input  value="${p.email}" type="text" class="form-control form-control-line"  name="CustomerEmail" readonly > </div>
                </div>
                <div class="form-group">
                    <label class="col-md-12">avatar</label>
                    <img src="${p.avatar}" alt="" style="width: 150px;height: 150px; " />
                </div><br/>
                <div class="form-group">
                    <label class="col-md-12">mobile</label>
                    <div class="col-md-12">
                        <input value="${p.mobile}" type="text" class="form-control form-control-line" name="CustomerMobile" readonly> </div>
                </div>
                <div class="form-group">
                    <label class="col-md-12">status</label>
                    <div class="col-md-12">

                        <input type="radio" name="CustomerStatus" value="true" <c:if test="${p.status}">checked</c:if>> active<br>
                        <input type="radio" name="CustomerStatus" value="false" <c:if test="${!p.status}">checked</c:if>> inactive<br>

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
