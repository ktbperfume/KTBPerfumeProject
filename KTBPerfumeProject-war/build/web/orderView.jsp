<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order View Page</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">


        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.scrollUp.min.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
    </head>
    <body>        
        <%@include file="header.jsp" %>        
        <section id="cart_items">
            <div class="container">
                <div class="breadcrumbs">
                    <ol class="breadcrumb">
                        <li><a href="#">Home</a></li>
                        <li class="active">Order Information</li>
                    </ol>
                </div>
                <div class="">
                    <div class="alert alert-success fade in">
                        <i class="fa-fw fa fa-check"></i>
                        <strong>Success!</strong>
                        <span>Your order Completed!</span>
                    </div>
                </div>
                <article class="content" id="Content_ID"> 

                    <div class="table-responsive cart_info">
                        <h3>Your Order Code: ${orderI.getOrderCode()}<b></b></h3>
                        <p>
                            <b>Date Order: </b>
                            <i>${orderI.getDate()}</i>
                        </p>
                        <p>
                            <b>Payment Method: </b>
                            <i>${orderI.getPaymentMethod()}</i>
                        </p>
                        <table class="table table-condensed">
                            <thead>
                                <tr class="cart_menu">
                                    <td class="image">Item</td>
                                    <td class="description">Description</td>
                                    <td class="price">Price</td>
                                    <td class="quantity">Quantity</td>
                                    <td class="total">Total</td>                                
                                </tr>
                            </thead>
                            <tbody>  
                                <c:forEach items="${listD}" var="d">
                                    <tr>
                                        <td class="cart_product">
                                            <a href="">${d.productId.getProductName()}<img src="${d.productId.getImage()}" alt="" style="height: 80px;width: 80px"></a>
                                        </td>   
                                        <td class="cart_description">
                                            <p>${d.productId.getDescription()}</p>
                                        </td>
                                        <td class="cart_price">
                                            <p>${d.productId.getPrice()}</p>
                                        </td>
                                        <td class="cart_quantity">
                                            <p>${d.getQuantity()}</p>
                                        </td>                                                              
                                        <td class="cart_total">
                                            <p class="cart_total_price">
                                                $${d.productId.getPrice() * d.getQuantity()}                                        
                                            </p>
                                        </td>                                
                                    </tr>
                                </c:forEach>

                            </tbody>
                            <tfoot>
                                <tr>
                                    <td colspan="4" class="text-right">
                                        <h3 style="color: darkorange"><b>Grand Total: $${orderI.getTotal()}</b></h3>
                                    </td>
                                    <td></td>
                                </tr>
                            </tfoot>
                        </table>
                </article>
                <div class="clearfix col-md-12">
                    <div class="button-box text-right" style="padding-top: 15px">
                        <a class="btn btn-danger" href="cancelOrderServlet?orderId=${orderI.getOrderCode()}">Cancel Order</a>
                        <a class="btn btn-success" href="getProductByBrandServlet?i=0">Shop More</a>
                        <button type="button" class="btn btn-default"
                                onclick="In_Content('Content_ID')">
                            <i class="glyphicon glyphicon-print"></i> Print
                        </button>
                    </div>

                </div>
            </div>
        </section> <!--/#cart_items-->
        <%@include file="footer.jsp" %>
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
    </body>
</html>
