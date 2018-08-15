<%@include file="admin_fooder_table.jsp" %>
<%@include file="admin_header_table.jsp" %>
<%@include file="admin_header.jsp" %>
<%@include file="admin_left.jsp" %>
<div class="panel-body">
    <div id="dataTables-example_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
        <div class="row">
            <div class="col-sm-12">
                <center>
                    <h3 class="box-title">List Brand</h3>
                </center>
                <code><a href="admin/insert_brand.jsp">Insert Brand</a></code><br/><br/>
                <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                <table>
                    <c:forEach items="${listBrand}" var="b">
                        <div class="col-md-4 col-xs-12">
                            <div class="white-box">
                                <a href="updateBrandServlet?brandId=${b.brandId}" >
                                    <div> 
                                        <img width="300px"height="200px" src="${b.logo}">
                                    </div>
                                </a>
                                
                                <div class="col-md-4 col-sm-4 text-center">
                                    <p class="text-purple"></p>
                                    <h3>${b.brandId}</h3> 
                                </div>
                                 <div class="col-md-4 col-sm-4 text-center">
                                    <a href="deleteBrandServlet?id=${b.brandId}">
                                       <p class="text-purple"></p>
                                       <h3>Delete</h3>         
                                    </a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
    <!-- /.panel-body -->
</div>
<!--end of page -->
<script>

    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
</script>
<%@include file="admin_fooder.jsp" %>
<%@include file="admin_fooder_table.jsp" %>
