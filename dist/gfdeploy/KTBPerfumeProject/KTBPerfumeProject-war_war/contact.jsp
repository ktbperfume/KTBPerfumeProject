<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Contact Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
        <script>
            function myMap() {

                var mapProp = {
                    center: new google.maps.LatLng(10.7869446, 106.66649430000001),
                    zoom: 18,
                };

                var map = new google.maps.Map(document.getElementById("gmap"), mapProp);
                var marker = new google.maps.Marker({
                    position: new google.maps.LatLng(10.7869446, 106.66649430000001),
                    title: 'KTBPerfume Shop'
                });
                marker.setMap(map);
            }
        </script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA5fLaKzSC2sxm27bu1fDdExSftM5cEJDk&callback=myMap"></script>
    </head>
    <body onload="myMap()">

        <%@include file="header.jsp" %>
        <%
            if(cus == null){
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        %>
        <div id="contact-page" class="container">
            <div class="bg">
                <h2 class="title text-center">Contact Info</h2>

                <div class="row">  	
                    <div class="col-sm-4">
                        <div class="contact-form">
                            <address >
                                <h3 style="color: darkorange">KTB Perfume Ltd</h3>
                                <p><span class="glyphicon glyphicon-map-marker"></span>CMT8 District 3, HCM City</p>
                                <p><span class="glyphicon glyphicon-phone"></span>Mobile: 0909 931 677</p>
                                <p><span class="glyphicon glyphicon-print"></span>Fax: (028) 5413 8889</p>
                                <p><span class="glyphicon glyphicon-envelope"></span>Email: ktbperfume@gmail.com</p>
                            </address>	

                        </div>
                    </div>  
                    <div class="col-sm-8">
                        <div class="contact-info">
                            <div id="gmap" class="contact-map"></div>

                        </div>
                    </div>      			
                </div>  

                <div class="row" style="text-align: center; width: 80%; margin-left: 10%">  	
                        <h2 class="title text-center">Feedback</h2>
                        <div class="status alert alert-success" style="display: none"></div>
                        <form id="main-contact-form" class="contact-form row" name="contact-form" method="post" action="insertFeedbackServlet">
                            <div class="form-group col-md-12">
                                <input type="text" name="subject" class="form-control" required="required" placeholder="Subject">
                            </div>
                            <div class="form-group col-md-12">
                                <textarea name="message" id="message" required="required" class="form-control" rows="8" placeholder="Your Message Here"></textarea>
                            </div>                        
                            <div class="form-group col-md-12">
                                <input type="submit" name="submit" class="btn btn-primary pull-right" value="Submit">
                            </div>
                        </form>	
                </div>  
            </div>	
        </div><!--/#contact-page-->
        <%@include file="footer.jsp" %>
    </body>
</html>
