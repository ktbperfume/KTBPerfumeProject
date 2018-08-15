<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="entity.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Register Page</title>
        <script src="js/jquery.validate.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


        <link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" /> <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">      
        <meta name="google-signin-client_id" content="624833056251-pu07gqi2l7argqcipoermqckgdn570l3.apps.googleusercontent.com">


        <script src="js/jquery.validate.min.js"></script>
        <script type="text/javascript" src = "https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js" ></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

    </head>

    <body>        
        <%@include file="header.jsp" %>

        <section id="form"><!--form-->
            <div class="container">
                <div class="row">
                    <div class="col-sm-4 col-sm-offset-1">
                        <div class="col-sm-12">
                            <div class="signup-form" ><!--sign up form-->
                                <h2 style="font-weight: bolder">New User Sign up!</h2>
                                <form id="reg" action="customerServlet" method="post">
                                    <input type="text"  placeholder="Name" name="fullName"  required="" min="3" max="30"/>
                                    <div>
                                        <input type="email"  placeholder="Email Address" name="email" id="email" required=""/>
                                        <!--                                         <span id="user-result"></span>-->
                                    </div>

                                    <input type="password" placeholder="Password" name="pass" id="pass" required="" min="6" max="30"/>
                                    <input type="password"  placeholder="Confirm Password" 
                                           name="re_pass" id="re_pass" required="" min="6" max="30"/>
                                    <!--                                    <span id="pass-result"></span>-->
                                    <p style="color: red">${error}</p>
                                    <span>
                                        <label class="radio-inline" >
                                            <input type="radio" name="gender" style="height: 20px;" value="Male">Male
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="gender" style="height: 20px" value="Female">Female
                                        </label>
                                    </span>

                                        <input type="text" placeholder="Phone" name="phone"/>
                                    <label class="control-label" for="date">Date of birth</label>
                                    <input class="form-control"  id="date" name="date" placeholder="MM/DD/YYY" type="text"/>
                                    <script>
                                        $(document).ready(function() {
                                            var date_input = $('input[name="date"]'); //our date input has the name "date"
                                            var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
                                            var options = {
                                                format: 'mm/dd/yyyy',
                                                container: container,
                                                todayHighlight: true,
                                                autoclose: true,
                                            };
                                            date_input.datepicker(options);
                                        });
                                    </script>

                                    <button type="submit" name="command" value="signup" class="btn btn-default" style="margin:0 40% 0 40% ">Sign up</button>
                                </form>
                            </div><!--/sign up form-->
                        </div>
                    </div>
                </div>
        </section><!--/form-->

        <%@include file="footer.jsp" %>    

    </body>
</html>
