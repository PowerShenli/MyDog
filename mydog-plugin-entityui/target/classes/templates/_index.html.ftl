
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
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/bootstrap-table.min.css" rel="stylesheet">
    <link href="css/bootstrap-dialog.min.css" rel="stylesheet">
    <style>
        body {
            padding-top: 70px;
            /* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
        }
    </style>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!-- jQuery Version 1.11.1 -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.js"></script>

    <!--  bootstrap-table -->
    <script src="js/bootstrap-table.min.js"></script>
    <script src="js/bootstrap-table-locale-all.min.js"></script>
    <script src="js/handlebars-v4.0.5.js"></script>
    <script src="js/main.js"></script>
    <script src="js/index.js"></script>
    <script src="/js/bootstrapValidator.js"></script>
    <script src="/js/bootstrap-dialog.js"></script>
</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">${project["mydogProj"]["name"]}后台</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <#list entity?keys as ent>
                    <#assign ev=entity[ent]/>
                    <li data-page="${ent?lower_case}-list.html">
                        <a href="#">${ev.label}管理</a>
                    </li>
                </#list>
                <li data-page="login.html" id="logoutBtn">
                    <a href="#">退出登录</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<!-- Page Content -->
<div class="container" id="bodymain">

    <div class="row">
        <div class="col-lg-12 text-center">
            <h1>A Bootstrap Starter Template</h1>
            <p class="lead">Complete with pre-defined file paths that you won't have to change!!</p>
            <ul class="list-unstyled">
                <li>Bootstrap v3.3.7</li>
                <li>jQuery v1.11.1</li>
            </ul>
        </div>
    </div>
    <table class="table">
        <caption>Table 学员姓名</caption>
        <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>User Name</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>aehyok</td>
            <td>leo</td>
            <td>@aehyok</td>
        </tr>
        <tr>
            <td>lynn</td>
            <td>thl</td>
            <td>@lynn</td>
        </tr>
        </tbody>
    </table>
    <!-- /.row -->

    <table data-toggle="table">
        <thead>
        <tr>
            <th>Item ID</th>
            <th>Item Name</th>
            <th>Item Price</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>1</td>
            <td>Item 1</td>
            <td>$1</td>
        </tr>
        <tr>
            <td>2</td>
            <td>Item 2</td>
            <td>$2</td>
        </tr>
        </tbody>
    </table>

</div>
<!-- /.container -->

</body>

</html>
