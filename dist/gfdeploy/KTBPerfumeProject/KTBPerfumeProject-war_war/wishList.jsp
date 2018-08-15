<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Map"%>
<%@page import="entity.Item"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Wishlist Page</title>
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
            if (cus == null) {
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
                                <td></td>
                                <td></td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="w" items="${listW}">
                                <tr>
                                <td class="cart_product">
                                    <a href=""><img src="${w.productId.image}" alt="" style="height: 80px;width: 80px"></a>
                                </td>
                                <td class="cart_description">
                                    <h4  style="margin-left: 20px"><a href="${w.productId.description}"></a></h4>
                                    <p></p>
                                </td>
                                <td class="cart_price">
                                    <p>${w.productId.price}</p>
                                </td>                             
                                <a href="cartServlet?command=plus&proId=${w.productId.productId}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                <td class="cart_delete">
                                    <a class="cart_quantity_delete" href="">
                                        <i class="fa fa-times"></i></a>
                                </td>
                            </tr>
                            </c:forEach>
                                                  
                        </tbody>
                    </table>
                </div>
            </div>
        </section> <!--/#cart_items-->



        <%@include file="footer.jsp" %>
    </body>
</html>
