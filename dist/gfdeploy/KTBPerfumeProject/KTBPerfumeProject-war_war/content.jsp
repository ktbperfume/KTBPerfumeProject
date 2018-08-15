<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Content Page</title>
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
        <div class="content">
            <section id="slider"><!--slider-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-12">
                            <div id="slider-carousel" class="carousel slide" data-ride="carousel">
                                <ol class="carousel-indicators">
                                    <li data-target="#slider-carousel" data-slide-to="0" class="active"></li>
                                    <li data-target="#slider-carousel" data-slide-to="1"></li>
                                    <li data-target="#slider-carousel" data-slide-to="2"></li>
                                </ol>

                                <div class="carousel-inner">
                                    <div class="item active">
                                        <div class="col-sm-6">
                                            <h1><span>KTB</span>-Perfume</h1>
                                            <h2>Calvin Klein Eternity 25th Anniversary Edition </h2>
                                            <button type="button" class="btn btn-default get">Get it now</button>
                                        </div>
                                        <div class="col-sm-6">
                                            <img src="images/home/t3.png" class="girl img-responsive" alt="" />
                                            <img src="images/home/bigsale.png"  class="pricing" alt="" />
                                        </div>
                                    </div>
                                    <div class="item">
                                        <div class="col-sm-6">
                                            <h1><span>KTB</span>-Perfume</h1>
                                            <h2>Bvlgari Aqva Amara</h2>
                                            <button type="button" class="btn btn-default get">Get it now</button>
                                        </div>
                                        <div class="col-sm-6">
                                            <img src="images/home/m1.png" class="girl img-responsive" alt="" />
                                            <img src="images/home/bigsale.png"  class="pricing" alt="" />
                                        </div>
                                    </div>

                                    <div class="item">
                                        <div class="col-sm-6">
                                            <h1><span>KTB</span>-Perfume</h1>
                                            <h2>Gucci Premiere for Women EDT</h2>
                                            <button type="button" class="btn btn-default get">Get it now</button>
                                        </div>
                                        <div class="col-sm-6">
                                            <img src="images/home/w1.png" class="girl img-responsive" alt="" />
                                            <img src="images/home/bigsale.png" class="pricing" alt="" />
                                        </div>
                                    </div>

                                </div>

                                <a href="#slider-carousel" class="left control-carousel hidden-xs" data-slide="prev">
                                    <i class="fa fa-angle-left"></i>
                                </a>
                                <a href="#slider-carousel" class="right control-carousel hidden-xs" data-slide="next">
                                    <i class="fa fa-angle-right"></i>
                                </a>
                            </div>

                        </div>
                    </div>
                </div>
            </section><!--/slider-->

            <section>
                <div class="container">
                    <div class="row">

                        <%@include file="leftMenu.jsp" %>

                        <div class="col-sm-9 padding-right">
                        <div class="features_items"><!--features_items-->

                            <div style="text-align: center">
                                <img src="${brand.logo}" alt="" style="width: 300px;height: 300px; " /></div>
                            <h2 class="title text-center">${brand.brandName}</h2>
                            <div>${brand.description}</div>

                            <h2 class="title text-center">Features Items</h2>


                            <c:forEach items="${result}" var="p">
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


                            

                    </div>

                </div>
            </div>
        </section>

</body>
</html>
