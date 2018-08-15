<%@include file="admin_header.jsp" %>
<%@include file="admin_left.jsp" %>
       
<div class="row">
    <div class="col-md-8 col-xs-12">
        <center>
               <h3 class="box-title">Insert Brand</h3>
        </center>
        <code><a href="admin_manage_brand.jsp">List Brand</a></code>
        <div class="white-box">     
            <form class="form-horizontal form-material" action="../insertBrandServlet" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label class="col-md-12">Brand ID</label>
                    <div class="col-md-12">
                        <input type="brandid" placeholder="" class="form-control form-control-line" name="id" required=""
                               min="6" max="30"> </div>
                </div>
                <div class="form-group">
                    <label class="col-md-12">Brand Name</label>
                    <div class="col-md-12">
                        <input type="brandname" placeholder="Chanel" class="form-control form-control-line" name="name"
                               required="" min="6" max="50"> </div>
                </div>
                   <div class="form-group">
                    <label class="col-md-12">Logo</label>
                    <input type="file" style="margin-left: 12px" name="file"/>
                </div><br/>
                <div class="form-group">
                    <label class="col-md-12">Description</label>
                    <textarea class="form-control" rows="3" style="margin-left: 12px" placeholder="This is a seductive perfume ............" name="des"></textarea>
                </div>
                <div class="form-group">
                    <div class="col-sm-12">
                        <button class="btn btn-success">Insert</button>&emsp;
                        <button class="btn btn-danger">Reset</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<%@include file="admin_fooder.jsp" %>
