<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entity.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Account Page</title>
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
        <%@include file="header.jsp" %>

        <section>
            <div class="container">
                <div class="row">
                    <div class="col-sm-3">
                        <div class="left-sidebar">
                            <div class="panel-group category-products" id="accordian"><!--category-productsr-->							
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#accordian" href="#mens">
                                                Action
                                            </a>
                                        </h4>
                                    </div>
                                    <div class="panel-body">
                                        <ul>
                                            <li><a href="#">Account Detail</a></li>
                                            <li><a href="#">Purchase History</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>


                    <div class="product-details"><!--product-details-->
                        
                <h2 class="title text-center">Account detail</h2>
                        <div class="col-sm-5">
                                <img src="<%=cus.getAvatar()%>" height="300px" width="300px" alt="" />

                        </div>
                        <div class="col-sm-7">
                            <div class="product-information"><!--/product-information-->
                                <table style="width: 80%; margin-left: 10%">
                                    <tr>
                                        <td><h2>Name</h2></td>
                                        <td><h2><%=cus.getFullName()%></h2></td>
                                    </tr>
                                    <tr>
                                        <td><h2>Gender</h2></td>
                                        <td><h2><%=cus.getGender()%></h2></td>
                                    </tr>
                                    <tr>
                                        <td><h2>Date of Birth</h2></td>
                                        <td><h2><%SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = formatter.format(cus.getDateOfBirth());  %><%=strDate%> </h2></td>
                                    </tr>
                                    <tr>
                                        <td><h2>Email</h2></td>
                                        <td><h2><%=cus.getEmail()%></h2></td>
                                    </tr>
                                    <tr>
                                        <td><h2>Phone number</h2></td>
                                        <td><h2><%=cus.getMobile()%></h2></td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td><button type="button" class="btn btn-fefault cart"><a href="accountEdit.jsp">
                                                    Edit</a>
                                            </button></td>
                                    </tr>
                                </table>
                            </div><!--/product-information-->
                        </div>
                    </div><!--/product-details-->

                </div>
            </div>
        </section>

        <%@include file="footer.jsp" %>
    </body>
</html>
