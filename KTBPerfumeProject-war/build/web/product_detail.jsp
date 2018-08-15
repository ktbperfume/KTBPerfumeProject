<%@page import="entity.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Product Detail Page</title>
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

        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.scrollUp.min.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>


        <link rel="stylesheet" href="css/StarRating.css">
        <link href="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet">
    </head>
    <body>  
        <%
            Cart cart = (Cart) session.getAttribute("cart");
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
                        <div class="product-details"><!--product-details-->
                            <div class="col-sm-5">
                                <div class="view-product">
                                    <img src="${pro.image}" alt="" />
                                </div>

                            </div>
                            <div class="col-sm-7">
                                <div class="product-information"><!--/product-information-->
                                    <h2>${pro.productName}</h2>

                                    <x-star-rating value="3" number="5" id="rating">
                                    </x-star-rating>
                                    <script src="js/StarRating.js"></script>

                                    <h4 style="color: darkorange">Brand: ${pro.brandId.brandName}</h4>
                                    <h4>For Gender: ${pro.forGender}</h4>
                                    <h4>Size of Bottle: ${pro.sizeOfBottle} </h4>
                                    <h4>Volume of Perfume Oil: <a href="searchByOilServlet?oil=${pro.volumeOfPerfumeOil}&i=0"> ${pro.volumeOfPerfumeOil}</a> </h4>
                                    <h4>Country: ${pro.country}</h4>
                                    <h4>Year Issue: ${pro.yearIssue}</h4>
                                    <span>
                                        <span>US $${pro.price} </span>
                                        
                                        <a href="cartServlet?command=plus&proId=${pro.productId}">
                                            <button type="button" class="btn btn-fefault cart">
                                            <i class="fa fa-shopping-cart"></i>
                                              Add to cart
                                        </button>
                                        </a>
                                    </span>
                                </div><!--/product-information-->
                            </div>
                        </div><!--/product-details-->

                        <div class="category-tab shop-details-tab"><!--category-tab-->
                            <div class="col-sm-12">
                                <ul class="nav nav-tabs">
                                    <li><a href="#Description" data-toggle="tab" class="active">Description</a></li>                                    
                                </ul>
                            </div>
                            <div class="tab-content">
                                <div class="tab-pane fade" id="Description" >
                                    <p style="font-weight: bold">
                                        ${pro.description}
                                    </p>
                                </div>                                

                            </div>
                        </div><!--/category-tab-->

                        <%@include file="recommend.jsp" %>
                    </div>
                </div>
            </div>
        </section>

        <%@include file="footer.jsp" %>
    </body>
</html>
