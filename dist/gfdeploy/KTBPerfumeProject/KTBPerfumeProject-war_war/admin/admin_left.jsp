<div class="navbar-default sidebar" role="navigation">
    <div class="sidebar-nav slimscrollsidebar">
        <div class="sidebar-head">
            <h3><span class="fa-fw open-close"><i class="ti-close ti-menu"></i></span> <span class="hide-menu">Navigation</span></h3>
        </div>
        <ul class="nav" id="side-menu">
            <li style="padding: 70px 0 0;">
                <a href="admin_home.jsp" class="waves-effect"><i class="fa fa-clock-o fa-fw" aria-hidden="true"></i>Dashboard</a>
            </li>
            <%if (userA.getRole().equalsIgnoreCase("admin")) {%>
            <li>
                <a href="#" class="waves-effect"><i class="fa fa-user fa-fw" aria-hidden="true"></i>Insert<span class="fa arrow"></span></a>
                <ul class="nav" id="side-menu" >
                    <li>
                        <a href="insert_account.jsp" class="waves-effect">&emsp;&emsp; Insert Account</a>
                    </li>
                    <li>
                        <a href="insert_brand.jsp" class="waves-effect ">&emsp;&emsp; Insert Brand</a>
                    </li>
                    <li>
                        <a href="insert_product.jsp" class="waves-effect ">&emsp;&emsp; Insert Product</a>
                    </li>
                </ul>
            </li>
            <%}%>
            <li>
                <a href="#" class="waves-effect"><i class="fa fa-table fa-fw" aria-hidden="true"></i>Manage<span class="fa arrow"></span></a>
                <ul class="nav" id="side-menu" >

                    <%if (userA.getRole().equalsIgnoreCase("admin")) {%>
                    <li>
                        <a href="showUserAdminServlet" class="waves-effect">&emsp;&emsp; Manage Account</a>
                    </li> 
                    <li>
                        <a href="showCustomerAdminServlet" class="waves-effect ">&emsp;&emsp; Manage Customer</a>
                    </li>
                    <%}%>
                    <li>
                        <a href="showBrandAdminServlet" class="waves-effect ">&emsp;&emsp; Manage Brand</a>
                    </li>

                    <li>
                        <a href="showProductServlet" class="waves-effect ">&emsp;&emsp; Manage Product</a>
                    </li>
                    <li>
                        <a href="showFeedbackAdminServlet" class="waves-effect ">&emsp;&emsp;Manage Feedback</a>
                    </li>                    
                    <li>
                        <a href="showOrderServlet" class="waves-effect ">&emsp;&emsp;Manage Order</a>
                    </li>
                </ul>
            </li>
            <!-- /.nav-second-level -->
        </ul>

    </div>
</div>
<!-- ============================================================== -->
<!-- End Left Sidebar -->
<!-- Page Content -->
<!-- ============================================================== -->
<div id="page-wrapper">
    <div class="container-fluid">
        <div class="row bg-title">
            <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="white-box">
