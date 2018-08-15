<%@page import="java.util.Map"%>
<%@page import="entity.Item"%>
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
        <%
            if(cus == null){
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
                session.setAttribute("cart", cart);
            }
            
        %>
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
                                <td class="price">Price</td>
                                <td class="quantity">Quantity</td>
                                <td class="total">Total</td>
                                <td></td>
                            </tr>
                        </thead>
                        <tbody>
                            <% int o=0;%>
                            <% for (Map.Entry<String, Item> list : cart.getCartItems().entrySet()) {%>
                            <tr>
                                <td class="cart_product">
                                    <a href=""><img src="<%=list.getValue().getProduct().getImage()%>" alt="" style="height: 80px;width: 80px"></a>
                                </td>
                                <td class="cart_description">
                                    <h4  style="margin-left: 20px"><a href=""><%=list.getValue().getProduct().getProductName()%></a></h4>
                                    <p><%= list.getValue().getProduct().getDescription()%></p>
                                </td>
                                <td class="cart_price">
                                    <p>$<%=list.getValue().getProduct().getPrice()%></p>
                                </td>
                                <td class="cart_quantity">
                                    <div class="cart_quantity_button">
                                        <a class="cart_quantity_up" href="#" 
                                           onclick="jsIncreaseValue('<%=list.getKey()%>')"> + </a>
                                        <input class="cart_quantity_input" type="text" name="<%=list.getKey()%>" id="<%=list.getKey()%>"
                                               value="<%=list.getValue().getQuantity()%>" autocomplete="off" size="2">
                                        <a class="cart_quantity_down" href="#"
                                           onclick="jsDecreaseValue('<%=list.getKey()%>')"> - </a>

                                    </div>
                                </td>
                                <td class="cart_total">
                                    <p class="cart_total_price">
                                        $<%=list.getValue().getProduct().getPrice() * list.getValue().getQuantity()%></p>
                                </td>
                                <td class="cart_delete">
                                    <a class="cart_quantity_delete" href="cartServlet?command=remove&proId=<%=list.getValue().getProduct().getProductId()%>">
                                        <i class="fa fa-times"></i></a>
                                </td>
                            </tr>
                            <% o++; %>
                            <%}%>                            
                        </tbody>
                    </table>
                </div>
            </div>
        </section> <!--/#cart_items-->

        <section id="do_action">
            <div class="container">                
                <div class="row">                    
                    <div class="col-sm-6">
                        <div class="chose_area">
                            <div class="heading">
                                <h3>Please fill out this form to complete your order</h3>
                            </div>
                            <form action="checkOutServlet" method="POST">
                                <ul class="user_option" style=" width:100%; ">
                                    <li style="margin-top: 10px; display: inline-block; width: 100%">
                                        <label style="width: 30%">Delivery to</label>
                                        <input    name="address" 
                                                  placeholder="Enter text here..."/>
                                    </li>
                                    <li style="margin-top: 10px; width: 100%">
                                        <label style="width: 150px">Phone Number</label>
                                        <input type="text" name="phone"/>
                                    </li>
                                    <li style="margin-top: 10px; width: 100%" class="single_field">
                                        <label style="width: 150px">Payment Method</label>
                                        <select name="payment">
                                            <option value="COD">COD</option>
                                            <option value="Bank">Bank Transfer</option>
                                        </select>   
                                    </li>
                                </ul>
                                <button class="btn btn-default check_out" type="submit" 
                                        <% if(o==0){%> disabled="" style="background: #2a3035;"<%}%>>Check Out</button>
                            </form>

                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="total_area">
                            <ul>
                                <li>Cart Sub Total <span>$<%=cart.subTotalCart()%></span></li>                                
                                <li>Tax (10%) <span>$<%=cart.subTotalCart() * 0.1%></span></li>
                                <li>Grand Total <span>$<%=cart.GrandTotalCart()%></span></li>
                            </ul>
                            <a class="btn btn-default update" href="getProductByBrandServlet?i=0">Shop More</a>                            
                        </div>
                    </div>
                </div>
            </div>
        </section><!--/#do_action-->
        <%@include file="footer.jsp" %>
        <script>
            function jsIncreaseValue(field) {
                var nr = parseInt(document.getElementById(field).value);
                document.getElementById(field).value = nr + 1;
                return false;
            }

            function jsDecreaseValue(field) {
                var nr = parseInt(document.getElementById(field).value);
                if (nr > 1) {
                    document.getElementById(field).value = nr - 1;
                } else
                {
                    document.getElementById(field).value = 0;
                }
                return false;
            }
        </script>
    </body>
</html>
