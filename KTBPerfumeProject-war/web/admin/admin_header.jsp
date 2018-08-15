
<%@page import="entity.UserAdmin"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" type="image/png" sizes="16x16" href="/KTBPerfumeProject-war/admin/admin_pages/plugins/images/favicon.png">
        <title>Admin KTBPerfume</title>
        <!-- Bootstrap Core CSS -->
        <link href="/KTBPerfumeProject-war/admin/admin_pages/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Menu CSS -->
        <link href="/KTBPerfumeProject-war/admin/admin_pages/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css" rel="stylesheet">
        <!-- animation CSS -->
        <link href="/KTBPerfumeProject-war/admin/admin_pages/css/animate.css" rel="stylesheet">
        <!-- Custom CSS -->
        <link href="/KTBPerfumeProject-war/admin/admin_pages/css/style.css" rel="stylesheet">
        <!-- color CSS -->
        <link href="/KTBPerfumeProject-war/admin/admin_pages/css/colors/default.css" id="theme" rel="stylesheet">
        <!-- toast CSS -->
        <link href="/KTBPerfumeProject-war/admin/admin_pages/plugins/bower_components/toast-master/css/jquery.toast.css" rel="stylesheet">
        <!-- morris CSS -->
        <link href="/KTBPerfumeProject-war/admin/admin_pages/plugins/bower_components/morrisjs/morris.css" rel="stylesheet">
        <!-- chartist CSS -->
        <link href="/KTBPerfumeProject-war/admin/admin_pages/plugins/bower_components/chartist-js/dist/chartist.min.css" rel="stylesheet">
        <link href="/KTBPerfumeProject-war/admin/admin_pages/plugins/bower_components/chartist-plugin-tooltip-master/dist/chartist-plugin-tooltip.css" rel="stylesheet">
    </head>
    <body class="fix-header">
        <%
            //UserAdmin userA = (UserAdmin)session.getAttribute("userA");
            UserAdmin userA = null;
            if (session.getAttribute("userA") != null) {
                userA = (UserAdmin) session.getAttribute("userA");

            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        %>
        <!-- ============================================================== -->
        <!-- Preloader -->
        <!-- ============================================================== -->
        <div class="preloader">
            <svg class="circular" viewBox="25 25 50 50">
            <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="2" stroke-miterlimit="10" />
            </svg>
        </div>
        <!-- ============================================================== -->
        <!-- Wrapper -->
        <!-- ============================================================== -->
        <div id="wrapper">
            <!-- ============================================================== -->
            <!-- Topbar header - style you can find in pages.scss -->
            <!-- ============================================================== -->
            <nav class="navbar navbar-default navbar-static-top m-b-0" style="height: 0px">
                <div class="navbar-header">
                    <div class="top-left-part">
                        <!-- Logo -->
                        <a class="logo" href="admin_home.jsp">
                            <b>&emsp;
                                <img src="/KTBPerfumeProject-war/admin/admin_pages/plugins/images/logo-ktb.png"/>
                            </b>
                        </a>
                    </div>
                    <!-- /Logo -->

                    <ul class="nav navbar-top-links navbar-right">                        
                        <!-- /.dropdown -->
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                                <%if (userA != null) {%>
                                <i class="fa fa-user fa-fw"></i>Welcome <%=userA.getUsername()%> <i class="fa fa-caret-down"></i>
                                <%}%>

                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="./updateUserAdminServlet?Id=${userA.getUsername()}"><i class="fa fa-user fa-fw"></i> User Profile</a>
                                </li>
                                <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                                </li>
                                <li class="divider"></li>
                                <li><a href="logoutAdmin.jsp"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                                </li>
                            </ul>
                            <!-- /.dropdown-user -->
                        </li>
                        <!-- /.dropdown -->

                    </ul>

                </div>
                <!-- /.navbar-header -->
                <!-- /.navbar-top-links -->
                <!-- /.navbar-static-side -->
            </nav>
            <!-- End Top Navigation -->
