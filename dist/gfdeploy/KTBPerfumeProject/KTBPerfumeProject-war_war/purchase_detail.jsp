<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>
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
                        <li class="active">Shopping Cart</li>
                    </ol>
                </div>
                <div class="table-responsive cart_info">
                    <table class="table table-condensed">
                        <thead>
                            <tr class="cart_menu">
                                <td class="image">Item</td>
                                <td class="description"></td>
                                <td>Price</td>
                                <td class="price">Quantity</td>

                                <td>Total</td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="cart_product">
                                    <a href=""><img src="images/product/BLACK XS.png" alt="" style="height: 80px;width: 80px"></a>
                                </td>
                                <td class="cart_description">
                                    <h4  style="margin-left: 20px"><a href="">BLACK XS</a></h4>
                                </td>
                                <td class="cart_price">
                                    <p>$59</p>
                                </td>
                                <td class="cart_quantity">
                                    <div class="cart_quantity_button">
                                        <input class="cart_quantity_input" type="text" name="quantity" value="1" autocomplete="off" size="2" readonly>
                                    </div>
                                </td>
                                <td class="cart_price">
                                    <p>$59</p>
                                </td>
                            </tr>

                            <tr>
                                <td class="cart_product">
                                    <a href=""><img src="images/product/VERA WANG PRINCESS.png" alt=""  style="height: 80px;width: 80px"></a>
                                </td>
                                <td class="cart_description">
                                    <h4  style="margin-left: 20px"><a href="">VERA WANG PRINCESS</a></h4>
                                </td>
                                <td class="cart_price">
                                    <p>$59</p>
                                </td>
                                <td class="cart_quantity">
                                    <div class="cart_quantity_button">
                                        <input class="cart_quantity_input" type="text" name="quantity" value="1" autocomplete="off" size="2" readonly>
                                    </div>
                                </td>
                                <td class="cart_price">
                                    <p>$59</p>
                                </td>
                            </tr>
                            <tr>
                                <td class="cart_product">
                                    <a href=""><img src="images/product/CALVIN KLEIN ETERNITY 25TH ANNIVERSARY EDITION.png" alt=""  style="height: 80px;width: 80px"></a>
                                </td>
                                <td class="cart_description">
                                    <h4 style="margin-left: 20px"><a href="">CALVIN KLEIN ETERNITY 25TH ANNIVERSARY EDITION</a></h4>
                                </td>
                                <td class="cart_price">
                                    <p>$59</p>
                                </td>
                                <td class="cart_quantity">
                                    <div class="cart_quantity_button">
                                        <input class="cart_quantity_input" type="text" name="quantity" value="1" autocomplete="off" size="2" readonly>
                                    </div>
                                </td>
                                <td class="cart_price">
                                    <p>$59</p>
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td><h3>Total</h3></td>
                                <td></td>
                                <td><h3>$177</h3></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <section id="do_action">
                    <div class="container">
                        
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="chose_area">
                                    <ul class="user_option" style=" width:100%; ">
                                        <li style="margin-top: 10px; display: inline-block; width: 100%">
                                            <label style="width: 30%">Delivery to</label>
                                            <textarea rows="3" name="comment" form="usrform" style="width: 60%;" readonly>Enter text here...</textarea>
                                        </li>
                                        <li style="margin-top: 10px; width: 100%">
                                            <label style="width: 150px">Phone number</label>
                                            <input type="text" readonly/>
                                        </li>
                                        <li style="margin-top: 10px; width: 100%" class="single_field">
                                            <label style="width: 150px">Payment method</label>
                                            <span>
                                                <label class="radio-inline" >
                                                    <input type="radio" name="optradio" style="height: 20px;" checked disabled><div>COD</div>
                                                </label>
                                                <label class="radio-inline">
                                                    <input type="radio" name="optradio" style="height: 20px" disabled><div>Visa</div>
                                                </label>
                                            </span>
                                        </li>
                                    </ul>

                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="total_area">
                                    <ul>
                                        <li>Cart Sub Total <span>$177</span></li>
                                        <li>Event Discount <span>10%</span></li>
                                        <li>Eco Tax <span>10%</span></li>
                                        <li>Total <span>$177</span></li>
                                    </ul>
                                    <a class="btn btn-default update" href="">Back</a>
                                </div>
                            </div>
                        </div>
                    </div>

                </section> <!--/#cart_items-->

            </div>
            <%@include file="footer.jsp" %>
    </body>
</html>
