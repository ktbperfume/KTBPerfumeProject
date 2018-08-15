<tr class="gradeA even" role="row">
    <td class="sorting_1">
        <!-- Button trigger modal -->
        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-content">
                <div class="panel-body">
                    <div id="dataTables-example_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                        <div class="row">
                            <br/>
                            <!--nút print-->
                            <div style="margin-left: 1200px" class="btn-group">
                                &emsp;
                                <button type="button" class="btn btn-default"
                                        onclick="In_Content('Content_ID')">
                                    <i class="glyphicon glyphicon-print"></i> Print
                                </button>
                                &emsp;
                                <span class="glyphicon glyphicon-indent-right"></span> 
                                <a href="salesperson_manage_order.jsp" type="button" class="btn btn-default btn-sm">
                                    Back
                                </a>

                            </div>

                            <!--article th? ch?n vùng ???c print -->
                            <div>
                                <article class="content" id="Content_ID"> 


                                    <center>
                                        <div class="col-sm-12">
                                            <h1 class="box-title">Order</h1>
                                        </div>
                                    </center>
                                    <div class="top-left-part">
                                        <!-- Logo -->

                                        <b>&emsp;
                                            <img src="/KTBPerfumeProject-war/admin/admin_pages/plugins/images/logo-ktb.png"/>
                                        </b>
                                    </div><br/>
                                    <table width="100%" class="table table-striped table-bordered table-hover dataTable no-footer dtr-inline"
                                           border="1" style="width: 100%;">
                                        <tr role="row">
                                            <th style="width: 170px;">Order Code</th>
                                            <th style="width: 170px;">Date</th>
                                            <th style="width: 170px;">Total</th>
                                            <th style="width: 170px;">Payment Method</th>
                                            <th style="width: 170px;">Status</th>
                                            <th style="width: 200px;">Delivery To</th>
                                            <th style="width: 170px;">Customer Id</th>
                                        </tr>
                                        <tbody>
                                        <td class="center">OD012FD</td>
                                        <td class="center">10-01-2018</td>
                                        <td class="center">200000</td>
                                        <td class="center">Visa</td>
                                        <td class="center">1</td>
                                        <td class="center">245 DBL P26 Q.Binh Thanh</td>
                                        <td class="center">CTM45DA</td>
                                        </tbody>
                                        <tbody>
                                        <td class="center">OD012FD</td>
                                        <td class="center">10-01-2018</td>
                                        <td class="center">200000</td>
                                        <td class="center">Visa</td>
                                        <td class="center">1</td>
                                        <td class="center">245 DBL P26 Q.Binh Thanh</td>
                                        <td class="center">CTM45DA</td>
                                        </tbody>
                                    </table>
                                </article>
                            </div>
                        </div>

                        <!------------------end article-------------------->
                    </div>
                </div>
                <!-- /.panel-body -->
            </div>

        </div>
    </div>
<td>
</tr>

<!--------------script print--------------->
<script>
    function In_Content(strid) {
        var prtContent = document.getElementById(strid);
        var WinPrint = window.open();
        WinPrint.document.write(prtContent.innerHTML);
        WinPrint.document.close();
        WinPrint.focus();
        WinPrint.print();
    }
</script>