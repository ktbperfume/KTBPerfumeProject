<%@include file="admin_header.jsp" %>
<%@include file="admin_left.jsp" %>
<div class="row">
    <div class="col-md-8 col-xs-12">
        <center>
            <h3 class="box-title">Update Brand</h3>
        </center>
        <code><a href="admin_manage_brand.jsp">List Brand</a></code>

        <form class="form-horizontal form-material" action="./updateBrandServlet" method="post" enctype="multipart/form-data">
            <input value="${b.brandId}" type="hidden" class="form-control form-control-line" name="Brandid" />
             <div class="form-group">
                <label class="col-md-12">Brand Name</label>
                <div class="col-md-12">
                    <input value="${b.brandId}" class="form-control form-control-line" disabled=""/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-12">Brand Name</label>
                <div class="col-md-12">
                    <input value="${b.brandName}" type="brandname" class="form-control form-control-line" name="name">
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-12">Logo</label>
                <input type="file" style="margin-left: 12px" name="file"/>
            </div>
            <div class="form-group">
                <label class="col-md-12">Description</label>
                <textarea class="form-control" rows="4" style="margin-left: 12px"  name="des">${b.description}</textarea>
            </div>
            <div class="form-group">
                <div class="col-sm-12">
                    <button class="btn btn-success" type="submit">Update</button>&emsp;
                    <button class="btn btn-danger">Reset</button>
                </div>
            </div>
        </form>
    </div>
</div>
<%@include file="admin_fooder.jsp" %>
