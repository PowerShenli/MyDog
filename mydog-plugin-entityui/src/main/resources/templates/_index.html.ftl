<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${project["mydogProj"]["name"]}</title>

    <!-- Bootstrap Core CSS -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="assets/css/animate.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="assets/css/style.css" rel="stylesheet">


    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<div id="wrapper">
    <!-- Navigation -->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="sidebar-collapse" id="menu-box">
            <ul class="nav metismenu" id="side-menu">
                <!-- 顶图 -->
                <li class="nav-header">
                    <div class="dropdown profile-element">
                        <span>
                            <img class="img-circle" src="assets/img/mydog-s.png" alt="MyDog logo">
                        </span>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="clear">
                                <span class="block m-t-xs">
                                    <strong class="font-bold">许思涵</strong>
                                </span>
                                <span class="text-muted text-xs block">Full-Stack Engineer <b class="caret"></b></span>
                            </span>
                        </a>
                        <ul class="dropdown-menu animated fadeInRight m-t-xs">
                            <li><a href="contacts.html">Contacts</a></li>
                            <li class="divider"></li>
                            <li><a href="login.html">Logout</a></li>
                        </ul>
                    </div>
                    <div class="logo-element">
                        MyDog
                    </div>
                </li>

                <!-- Side menu start -->
                <li class="active">
                    <a href="index.html">
                        <i class="fa fa-th-large"></i>
                        <span class="nav-label">Dashboards</span>
                        <!--<span class="fa arrow"></span>-->
                    </a>
                </li>

                <!-- Entity menu start -->
                <#list entity?keys as ent>
                    <#assign ev=entity[ent]/>
                <li>
                    <a href="${ent?lower_case}_list.html">
                        <i class="fa fa-table"></i>
                        <span class="nav-label">${ev.label}管理</span>
                    </a>
                </li>
                </#list>

            </ul>
        </div>
    </nav>

    <div id="page-wrapper" class="gray-bg dashbard-1">
        <!-- Top Bar -->
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <a class="navbar-minimalize minimalize-styl-2" href="#"><i class="fa fa-bars"></i> </a>
                    <form role="search" class="navbar-form-custom" action="search_results.html">
                        <div class="form-group">
                            <input type="text" placeholder="Search for something..." class="form-control" name="top-search" id="top-search">
                        </div>
                    </form>
                </div>
                <ul class="nav navbar-top-links navbar-right">
                    <li>
                        <span class="m-r-sm text-muted welcome-message">Welcome to MyDog.</span>
                    </li>

                    <li>
                        <a href="login.html">
                            <i class="fa fa-sign-out"></i> Log out
                        </a>
                    </li>
                    <li>
                        <a class="right-sidebar-toggle">
                            <i class="fa fa-tasks"></i>
                        </a>
                    </li>
                </ul>

            </nav>
        </div>

        <!-- Page Head -->
        <div class="row  border-bottom white-bg dashboard-header">

            <div class="col-sm-12">
                <h2>Welcome to MyDog</h2>
                <div class="media">
                    <div class="media-left">
                        <img src="assets/img/mydog-m.png" alt="MyDog logo">
                    </div>
                    <div class="media-body">
                        <h5>MyDog - 开发者最忠实的朋友.</h5>
                        <p>主人，有什么吩咐？生成代码？好的。让我帮你做更多的事, 汪汪！</p>
                        <small>
                            了解我更多? 请访问:&nbsp; <a href="https://github.com/PowerShenli/MyDog/wiki">MyDog WIKI</a>
                        </small>
                    </div>
                </div>
            </div>

        </div>

        <!-- Content start from here -->
        <div class="row">
            <div class="col-lg-12">
                <div class="wrapper wrapper-content">

                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>MyDog maven plugins</h5>
                            <div class="ibox-tools">

                            </div>
                        </div>
                        <div class="ibox-content no-padding">
                            <table class="table table-stripped small">

                                <tbody>
                                <#list entity?keys as ent>
                                    <#assign ev=entity[ent]/>
                                <tr data-page="${ent?lower_case}_list.html">
                                    <td>
                                        <i class="fa fa-circle text-danger"></i>
                                    </td>
                                    <td>
                                        <a href="${ent?lower_case}_list.html">${ev.label}管理</a>
                                    </td>
                                    <td>
                                        <a href="${ent?lower_case}_list.html" class="btn btn-white btn-sm"><i class="fa fa-folder"></i> View </a>
                                    </td>
                                </tr>
                                </#list>
                                </tbody>
                            </table>
                        </div>
                    </div>

                </div>

                <!-- Page Foot -->
                <div class="footer">
                    <div class="pull-right">
                        10GB of <strong>250GB</strong> Free.
                    </div>
                    <div>
                        <strong>Copyright</strong> Example Company &copy; 2014-2017
                    </div>
                </div>

            </div>
        </div>


    </div>
</div>



    <!-- vendor lib -->
    <script src="assets/vendor/jquery/jquery-3.1.1.min.js"></script>
    <script src="assets/vendor/bootstrap/bootstrap.min.js"></script>

    <!-- common plugins -->
    <script src="assets/vendor/metisMenu/jquery.metisMenu.js"></script>
    <script src="assets/vendor/slimscroll/jquery.slimscroll.min.js"></script>

    <!--  customer javascript -->
    <script src="assets/js/main.js"></script>

</body>

</html>
