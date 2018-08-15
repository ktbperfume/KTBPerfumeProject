<%@include file="admin_header.jsp" %>
<%@include file="admin_left.jsp" %>
<div class="row">
    <div class="col-md-8 col-xs-12">
        <center>
            <h3 class="box-title">Insert Product</h3>
        </center>
        <code><a href="insert_product.jsp">List Product</a></code>
        <div class="white-box">     
            <form class="form-horizontal form-material" action="./insertProductServlet" method="post"  enctype="multipart/form-data">
                <div class="form-group">
                    <label class="col-md-12">Product ID</label>
                    <div class="col-md-12">
                        <input type="text" class="form-control form-control-line" id="Productid" name="Productid"> </div>
                </div>
                <div class="form-group">
                    <label class="col-md-12">Product Name</label>
                    <div class="col-md-12">
                        <input type="text" class="form-control form-control-line" id="Productname" name="Productname"> </div>
                </div>
                <div class="form-group">
                    <label class="col-md-12">Brand ID</label>
                    <div class="col-md-12">
                        <select class="form-control form-control-line" name="PBrandid" id="PBrandid">
                            <c:forEach var="z" items="${listBrand}">

                                <option value="${z.brandId}">${z.brandName}</option>
                            </c:forEach>
                        </select> </div>
                </div>
                <div class="form-group">
                    <label class="col-md-12">Description</label>
                    <textarea class="form-control" rows="3" style="margin-left: 12px" name="PDescription" id="PDescription"></textarea>
                </div>
                <div class="form-group">
                    <label class="col-sm-12">Gender</label>
                    &emsp;<label class="radio-inline">
                        <input type="radio" name="optionsRadiosInline" id="optionsRadiosInline1" value="Male" checked="">
                        Male
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="optionsRadiosInline" id="optionsRadiosInline2" value="Female">
                        FeMale
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="optionsRadiosInline" id="optionsRadiosInline3" value="Unisex">
                        Unisex
                    </label>
                </div><br/>
                <div class="form-group">
                    <label class="col-md-12">Price</label>
                    <div class="col-md-12">
                        <input type="text" class="form-control form-control-line" id="Productprice" name="Productprice" > </div>
                </div>
                <div class="form-group">
                    <label class="col-md-12">Image</label>
                    <input type="file" style="margin-left: 12px" name="file" id="file">
                </div><br/>
                <div class="form-group">
                    <label class="col-md-12">Size</label>
                    <div class="col-md-12">
                        <input type="text" class="form-control form-control-line" name="Productsize" id="Productsize"> </div>
                </div>
                <div class="form-group">
                    <label class="col-md-12">Country</label>
                    <div class="col-md-12">
                        <input type="text" class="form-control form-control-line" name="Productcountry" id="Productcountry"> </div>
                </div>
                <div class="form-group">
                    <label class="col-md-12">Type</label>
                    <div class="col-md-12">
                        <input type="text" class="form-control form-control-line" name="Producttype" id="Producttype"> </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-12">Year</label>
                    <div class="col-sm-12">
                        <select class="form-control form-control-line" name="year" id="year">
                            <option value="2012">2012</option>
                            <option value="2013">2013</option>
                            <option value="2014">2014</option>
                            <option value="2015">2015</option>
                            <option value="2016">2016</option>
                            <option value="2017">2017</option>
                            <option value="2018">2018</option>
                        </select>
                    </div>
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
