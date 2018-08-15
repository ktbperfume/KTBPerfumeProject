<%@include file="admin_header.jsp" %>
<%@include file="admin_left.jsp" %>
<div class="row">
    <div class="col-md-8 col-xs-12">
        <center>
            <h3 class="box-title">Update Product</h3>
        </center>
        <code><a href="insert_product.jsp">List Product</a></code>
        <div class="white-box">     
            <form class="form-horizontal form-material" action="./updateProductServlet" method="post"  enctype="multipart/form-data">
                <div class="form-group">
                    <label class="col-md-12">Product ID</label>
                    <div class="col-md-12">
                        <input value="${p.productId}" type="text" class="form-control form-control-line" name="Productid"> </div>
                </div>
                <div class="form-group">
                    <label class="col-md-12">Product Name</label>
                    <div class="col-md-12">
                        <input value="${p.productName}" type="text" class="form-control form-control-line" name="Productname"> </div>
                </div>
                <div class="form-group">
                    <label class="col-md-12">Brand ID</label>
                    <div class="col-md-12">
                        <select class="form-control form-control-line" name="PBrandid" >
                            <c:forEach var="z" items="${listBrand}">

                                <option value="${z.brandId}" <c:if test="${p.brandId.brandId ==z.brandId}">selected</c:if>>${z.brandName}</option>
                            </c:forEach>
                        </select> </div>
                </div>
                <div class="form-group">
                    <label class="col-md-12">Description</label>
                    <textarea class="form-control" rows="3" style="margin-left: 12px" name="PDescription" >${p.description}</textarea>
                </div>
                <div class="form-group">
                    <label class="col-sm-12">Gender</label>
                    &emsp;<label class="radio-inline">
                        <input type="radio" name="optionsRadiosInline"  value="Male" <c:if test="${p.forGender.equalsIgnoreCase('male')}">checked</c:if> >
                        Male
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="optionsRadiosInline"  value="Female" <c:if test="${p.forGender.equalsIgnoreCase('female')}">checked</c:if>>
                        FeMale
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="optionsRadiosInline" value="Unisex" <c:if test="${p.forGender.equalsIgnoreCase('unisex')}">checked</c:if>>
                        Unisex
                    </label>
                </div><br/>
                <div class="form-group">
                    <label class="col-md-12">Price</label>
                    <div class="col-md-12">
                        <input  value="${p.price}" type="number" class="form-control form-control-line"  name="Productprice" > </div>
                </div>
                <div class="form-group">
                    <label class="col-md-12">Image</label>
                    <input type="file" style="margin-left: 12px" name="file" id="file">
                </div><br/>
                <div class="form-group">
                    <label class="col-md-12">Size</label>
                    <div class="col-md-12">
                        <input value="${p.sizeOfBottle}" type="text" class="form-control form-control-line" name="Productsize" > </div>
                </div>
                <div class="form-group">
                    <label class="col-md-12">Country</label>
                    <div class="col-md-12">
                        <input value="${p.country}" type="text" class="form-control form-control-line" name="Productcountry" > </div>
                </div>
                <div class="form-group">
                    <label class="col-md-12">AverageRating</label>
                    <div class="col-md-12">
                        <input value="${p.averageRating}" type="text" class="form-control form-control-line"> </div>
                </div>
                <div class="form-group">
                    <label class="col-md-12">Type</label>
                    <div class="col-md-12">
                        <input value="${p.volumeOfPerfumeOil}" type="text" class="form-control form-control-line" name="Producttype" > </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-12">Year</label>
                    <div class="col-sm-12">
                        <select class="form-control form-control-line" name="year">
                            <c:forEach begin="2000" end="2018" var="y">

                                <option value="${y}"<c:if test="${p.yearIssue == y}">selected</c:if> >${y}</option>

                            </c:forEach>

                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-12">Date Add Product</label>
                    <div class="col-md-12">
                        <input value="${p.dateAddProduct}" type="text" class="form-control form-control-line" name="Add"  readonly> </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-12">
                        <button class="btn btn-success">Update</button>&emsp;
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<%@include file="admin_fooder.jsp" %>
