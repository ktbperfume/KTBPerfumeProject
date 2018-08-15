<%@page import="entity.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Login Page</title>
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

        <script type="text/javascript" src = "https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js" ></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

    </head>
    <body>     

        <%@include file="header.jsp" %>

        <section id="form"><!--form-->
            <div class="container">
                <div class="row">
                    <div class="col-sm-4 col-sm-offset-1">
                        <div class="login-form"><!--login form-->
                            <h2>Login to your account</h2>
                            <form action="loginCustomerServlet" method="post">
                                <input name="email" type="email" placeholder="Email Address" />
                                <input name="pass" type="password" placeholder="Password" />
                                <h4 style="color: red">${err}<a href="register.jsp">Register</a></h4>

                                <button type="submit" class="btn btn-default" style="margin:0 40% 0 40% ">Login</button>                                
                            </form>


                        </div><!--/login form-->

                    </div>

                </div>
            </div>
        </section><!--/form-->

        <%@include file="footer.jsp" %>
    </body>
</html>
