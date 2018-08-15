<%@include file="admin_fooder_table.jsp" %>
<%@include file="admin_header_table.jsp" %>
<%@include file="admin_header.jsp" %>
<%@include file="admin_left.jsp" %>
<div class="panel-body">
    <div id="dataTables-example_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
        <div class="row">
            <div class="col-sm-12">
                <center>
                    <h3 class="box-title">List Product</h3>
                </center>
                <code><a href="insert_brand.jsp">Insert Product</a></code><br/><br/>
                <table width="100%" class="table table-striped table-bordered table-hover dataTable no-footer dtr-inline"
                       id="dataTables-example"
                       role="grid" aria-describedby="dataTables-example_info"
                       style="width: 100%;">
                    <thead>
                        <tr role="row">
                            <th class="sorting_asc" tabindex="0" aria-controls="dataTables-example"
                                rowspan="1"
                                colspan="1"
                                aria-sort="ascending"
                                aria-label="Rendering engine: activate to sort column descending"
                                style="width: 200px;">Product ID</th>
                            <th class="sorting" tabindex="0" aria-controls="dataTables-example"
                                rowspan="1"
                                colspan="1"
                                aria-label="Platform(s): activate to sort column ascending"
                                style="width: 250px;">Product Name</th>
                            <th class="sorting" tabindex="0" aria-controls="dataTables-example"
                                rowspan="1"
                                colspan="1"
                                aria-label="Engine version: activate to sort column ascending"
                                style="width: 250px;">Price</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                        <c:forEach items="${listPro}" var="p">
                            <tr class="gradeA even" role="row">
                                <td class="sorting_1">
                                    <!-- Button trigger modal -->
                                    <a href="updateProductServlet?ProductId=${p.productId}">
                                        <i class="glyphicon glyphicon-plus-sign"></i>
                                    </a>&emsp;
                                        ${p.productId}
                                </td>
                                <td class="center">${p.productName}</td>
                                <td class="center">${p.price}</td>

                            </tr>
                        </c:forEach>
                    </tbody>
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