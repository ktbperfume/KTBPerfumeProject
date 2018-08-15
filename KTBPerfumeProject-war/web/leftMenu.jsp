<%@page import="entity.Brand"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Left Menu Page</title>   
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>        
    </head>
    <body>
        <%
            List<Brand> FemaleBrand = (List<Brand>) session.getAttribute("FemaleBrand");
            List<Brand> MaleBrand = (List<Brand>) session.getAttribute("MaleBrand");
            List<Brand> UniBrand = (List<Brand>) session.getAttribute("UniBrand");
            List<Brand> listBrand = (List<Brand>) session.getAttribute("listBrand");
            int[] countB = (int[]) session.getAttribute("countB");
            int[] MaleCount = (int[]) session.getAttribute("MaleCount");
            int[] FemaleCount = (int[]) session.getAttribute("FemaleCount");
            int[] UniCount = (int[]) session.getAttribute("UniCount");
        %>
        <div class="col-sm-3">
            <div class="left-sidebar">
                <h2>Category</h2>
                <div class="panel-group category-products" id="accordian"><!--category-productsr-->							
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordian" href="#mens">
                                    <span class="badge pull-right"><i class="fa fa-plus"></i></span>
                                    Mens
                                </a>
                            </h4>
                        </div>
                        <div id="mens" class="panel-collapse collapse">
                            <div class="panel-body">
                                <ul>                                    

                                    <c:forEach varStatus="loop" items="${MaleBrand}" var="b">
                                        <li><a href="getProductByBrandServlet?id=${b.getBrandId()}&gen=Male&i=0"> <span class="pull-right">(${MaleCount[loop.index]})</span>${b.getBrandName()}</a></li>
                                        </c:forEach>                          
                                </ul>
                            </div>
                        </div>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordian" href="#womens">
                                    <span class="badge pull-right"><i class="fa fa-plus"></i></span>
                                    Womens
                                </a>
                            </h4>
                        </div>
                        <div id="womens" class="panel-collapse collapse">
                            <div class="panel-body">
                                <ul>

                                    <c:forEach varStatus="loop" items="${FemaleBrand}" var="b">
                                        <li><a href="getProductByBrandServlet?id=${b.getBrandId()}&gen=Female&i=0"> <span class="pull-right">(${FemaleCount[loop.index]})</span>${b.getBrandName()}</a></li>
                                        </c:forEach>                             
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordian" href="#unisex">
                                    <span class="badge pull-right"><i class="fa fa-plus"></i></span>
                                    Unisex
                                </a>
                            </h4>
                        </div>
                        <div id="unisex" class="panel-collapse collapse">
                            <div class="panel-body">
                                <ul>
                                    <c:forEach varStatus="loop" items="${UniBrand}" var="b">
                                        <li><a href="getProductByBrandServlet?id=${b.getBrandId()}&gen=Unisex&i=0"> <span class="pull-right">(${UniCount[loop.index]})</span>${b.getBrandName()}</a></li>
                                        </c:forEach>                                                               
                                </ul>
                            </div>
                        </div>
                    </div>
                </div><!--/category-products-->

                <div class="brands_products"><!--brands_products-->
                    <h2>Brands</h2>
                    <div class="brands-name">
                        <ul class="nav nav-pills nav-stacked">
                            <c:forEach varStatus="loop" items="${listBrand}" var="b">
                                <li><a href="getProductByBrandServlet?id=${b.getBrandId()}&i=0"> <span class="pull-right">(${countB[loop.index]})</span>${b.getBrandName()}</a></li>
                                </c:forEach>                            

                        </ul>
                    </div>
                </div><!--/brands_products-->

                <div class="brands_products"><!--price-range-->
                    <h2>Price Filter</h2>
                    <div class="brands_name">
                        <form action="productByPriceServlet?i=0" method="post">
                            <select name="rangePrice" onchange="this.form.submit()">
                                <option value="p20_50">From 20$ - 50$</option>
                                <option value="p50_100">From 50$ - 100$</option>
                                <option value="p100_150">From 100$ - 150$</option>
                                <option value="p150">Over 150$</option>
                            </select>
<!--                            <input type="submit" value="Search"/>-->
                        </form>
                    </div>
                </div><!--/price-range-->
            </div>
        </div>
    </body>
</html>
