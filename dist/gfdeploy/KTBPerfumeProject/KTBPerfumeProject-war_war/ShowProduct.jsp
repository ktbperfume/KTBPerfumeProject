<%@page import="entity.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Show All Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">

        <link rel="shortcut icon" href="images/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
    </head>
    <body>
        <%            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
                session.setAttribute("cart", cart);
            }
        %>
        <%@include file="header.jsp" %>
        <section>
            <div class="container">
                <div class="row">
                    <%@include file="leftMenu.jsp" %>

                    <div class="col-sm-9 padding-right">
                        <div class="features_items"><!--features_items-->


                            <h2 class="title text-center">Features Items</h2>

                            <c:forEach items="${result}" var="p" begin="${i}" step="1" end="${i+5}">
                                <div class="col-sm-4" style="height:500px">
                                    <div class="product-image-wrapper">
                                        <div class="single-products">
                                            <div class="productinfo text-center">
                                                <img src="${p.image}" alt="" />
                                                <h2>$${p.price}</h2>
                                                <div style="height: 50px">
                                                    <p>${p.productName}</p>
                                                </div>
                                                <a href="detailProductServlet?proId=${p.productId}" class="btn btn-default add-to-cart"><i class="fa fa-info" aria-hidden="true"></i>Detail</a>
                                                <a href="cartServlet?command=plus&proId=${p.productId}" class="btn btn-default add-to-cart" ><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                            </div>
                                            <div class="product-overlay">
                                                <div class="overlay-content">
                                                    <h2>$${p.price}</h2>
                                                    <p>${p.productName}</p>
                                                    <a href="detailProductServlet?proId=${p.productId}" class="btn btn-default add-to-cart"><i class="fa fa-info" aria-hidden="true"></i>Detail</a>
                                                    <a href="cartServlet?command=plus&proId=${p.productId}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="choose">
                                            <ul class="nav nav-pills nav-justified">
                                                <li><a href="#"><i class="fa fa-plus-square"></i>Add to wishlist</a></li>
                                                <li><a href="#"><i class="fa fa-plus-square"></i>Add to compare</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>

                        </div><!--features_items-->
                        <c:choose>
                            <c:when test="${noresult}">
                                <h2>
                                    No result
                                </h2>
                            </c:when>
                            <c:when test="${i==0}">
                                <c:if test="${end==false}">
                                <button style="float: right"><a href="getProductByBrandServlet?i=${i+3}&searchName=${Searchname}" >Next</a></button>
                                </c:if>
                            </c:when>
                            <c:when test="${end}">
                                <button style="float: right"><a href="getProductByBrandServlet?i=${i-3}&searchName=${Searchname}" >Back</a></button>
                            </c:when>
                            <c:otherwise>   
                                <div style="float: right">
                                    <button ><a href="getProductByBrandServlet?i=${i-3}&searchName=${Searchname}" >Back</a></button>
                                    <button ><a href="getProductByBrandServlet?i=${i+3}&searchName=${Searchname}" >Next</a></button>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </div>

                </div>
            </div>
        </section>

        <%@include file="footer.jsp" %>

    </body>
</html>
