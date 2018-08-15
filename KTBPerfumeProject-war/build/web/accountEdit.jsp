<%@page import="java.util.Date"%>
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
        <title>Edit Account Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
        <link href="css/changepass.css" rel="stylesheet">

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

        <script type="text/javascript" src = "https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js" ></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
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
                        <h2 class="title text-center">Edit Account</h2>
                        <div class="col-sm-5">
                            <div class="view-product">
                                <img src="<%=cus.getAvatar()%>" alt="" />
                            </div>

                        </div>
                        <div class="col-sm-7">
                            <div class="product-information" style="padding-left: 0px;"><!--/product-information-->
                                <form action="AccountEditServlet" method="POST" enctype="multipart/form-data">
                                    <table style="width: 65%;">
                                        <tr>
                                            <td style="width: 200px"><h2>Name</h2></td>
                                            <td><input type="text" value="<%=cus.getFullName()%>" disabled=""/></td>
                                        </tr>
                                        <tr>
                                            <td><h2>Password</h2></td>
                                            <td><input style="height: 10px" name="pass" type="password" value="<%=cus.getPassword()%>" /></td>

                                        </tr>                                            
                                        <tr>
                                            <td><h2>Gender</h2></td>
                                            <td>
                                                <span>
                                                    <label class="radio-inline" >
                                                        <input value="male" type="radio" name="optradio" style="height: 20px;" <%if (cus.getGender().equalsIgnoreCase("male")) {%>checked<%}%>><div style="margin-left: 20px">Male</div>
                                                    </label>
                                                    <label class="radio-inline">
                                                        <input value="female" type="radio" name="optradio" style="height: 20px" <%if (cus.getGender().equalsIgnoreCase("female")) {%>checked<%}%>><div style="margin-left: 20px">Female</div>
                                                    </label>
                                                </span>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td><h2>Date of birth</h2></td>
                                            <td><input class="form-control" style="width: 200px" id="date" name="date" type="text"
                                                       <%SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                                                           String strDate = formatter.format(cus.getDateOfBirth());%> value="<%=strDate%>" /></td>
                                        </tr>                                            
                                        <tr>
                                            <td><h2>Email</h2></td>
                                            <td><input type="email" name="email" value="<%=cus.getEmail()%>" disabled=""/></td>
                                        </tr>
                                        <tr>
                                            <td><h2>Phone number</h2></td>
                                            <td><input type="text" name="mobile" value="<%=cus.getMobile()%>"/></td>
                                        </tr>
                                        <tr>
                                            <td><input class="btn btn-fefault" type="file" name="file"/></td>
                                            <td><button type="submit" class="btn btn-fefault cart">Edit</button>
                                                <button class="btn btn-fefault cart"><a href="" style="color: white">Back</a></button></td>
                                        </tr>
                                    </table> 
                                </form>

                            </div><!--/product-information-->
                        </div>
                    </div>

                    </form>
                </div>
            </div><!--/category-tab-->
        </div>            
    </section>
    <script>
        $(document).ready(function() {
            var date_input = $('input[name="date"]'); //our date input has the name "date"
            var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
            var options = {
                format: 'dd/mm/yyyy',
                container: container,
                todayHighlight: true,
                autoclose: true
            };
            date_input.datepicker(options);
        });
    </script>        
    <%@include file="footer.jsp" %>
</body>
</html>
