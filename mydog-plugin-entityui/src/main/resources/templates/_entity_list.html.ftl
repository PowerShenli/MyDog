<#assign l_ent_name=entity.entityName?lower_case/>
<#assign pagination=entity.pagination/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${project["mydogProj"]["name"]}-list</title>

    <!-- Bootstrap Core CSS -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="assets/css/animate.css" rel="stylesheet">

    <link href="assets/vendor/bootstrapvalidator/css/bootstrapValidator.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="assets/css/style.css" rel="stylesheet">


    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body class="${l_ent_name}Box">

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
                <li>
                    <a href="index.html">
                        <i class="fa fa-th-large"></i>
                        <span class="nav-label">Dashboards</span>
                        <!--<span class="fa arrow"></span>-->
                    </a>
                </li>

                <!-- Entity menu start -->
            <#--<#list entity?keys as ent>-->
                <#--<#assign ev=entity[ent]/>-->
                <#--<li>-->
                    <#--<a href="${ent?lower_case}_list.html">-->
                        <#--<i class="fa fa-table"></i>-->
                        <#--<span class="nav-label">${ev.label}管理</span>-->
                    <#--</a>-->
                <#--</li>-->
            <#--</#list>-->

            </ul>
        </div>
    </nav>

    <div id="page-wrapper" class="gray-bg">
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

        <!-- bread crumbs start... -->
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-9">
                <h2>Applications</h2>
                <ol class="breadcrumb">
                    <li>
                        <a href="index.html">Home</a>
                    </li>
                    <li class="active">
                        <strong>List</strong>
                    </li>
                </ol>
            </div>
        </div>
        <!-- bread crumbs end... -->

        <!-- main content start... -->
        <div class="wrapper wrapper-content" id="${l_ent_name}List">
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>${entity.label}列表</h5>

                            <div class="ibox-tools">
                                <button class="btn btn-info btn-${l_ent_name}-add" id="btn-${l_ent_name}-add" data-toggle="modal" data-target="#${l_ent_name}Modal">
                                    <span class="fa fa-plus"/>&nbsp;新建${entity.label}
                                </button>
                                <button class="btn btn-info btn-${l_ent_name}-query" id="btn-${l_ent_name}-query">
                                    <span class="fa fa-search"/>&nbsp;查询
                                </button>
                            </div>
                        </div>
                        <div class="ibox-content">

                            <table id="${l_ent_name}Tb" class="table" data-paging="true">
                                <thead>
                                    <tr>
                                    <#list entity.fields as field>
                                        <th data-field="${field.fieldName}">${field.label}</th>
                                    </#list>
                                        <th data-formatter="${l_ent_name}Ctl.opFormatter">操作</th>
                                    </tr>
                                </thead>
                                <tbody>

                                </tbody>
                            </table>

                            <#if pagination.enabled >
                                <ul class="pagination" id="pagination">

                                </ul>
                            </#if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- main content end... -->


        <!-- footer start... -->
        <div class="footer">
            <div>
                <strong>Copyright</strong> Example Company &copy; 2014-2017
            </div>
        </div>
        <!-- footer end... -->
    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="${l_ent_name}Modal" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title"><em></em>${entity.label}</h4>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <fieldset>
                        <form method="POST" id="${l_ent_name}Form" role="form" class="form-horizontal" data-toggle="validator">
                            <#--<input type="hidden" name="id" id="id" />-->
                            <#list entity.fields as field>
                                <#assign field_name=field.fieldName/>
                                <#assign vprop=field.viewProp/>

                                <#if vprop.type=="select">
                                    <div class="form-group">
                                        <label class="col-xs-3 control-label" for="${field_name}">${field.label}:</label>
                                        <div class="col-xs-9 selectContainer">
                                            <select name="${field_name}" class="form-control" id="#{field_name}" <#if field["isNull"]!=true>required</#if>>
                                                <#if vprop.enum??>
                                                    <#assign options=vprop.enum?eval/>
                                                    <#list options?keys as v>
                                                        <option value="${v}">${options[v]}</option>
                                                    </#list>
                                                </#if>
                                            </select>
                                        </div>
                                    </div>

                                <#elseif vprop.type=="radio">
                                    <div class="form-group">
                                        <label class="col-xs-3 control-label" for="${field_name}">${field.label}:</label>
                                        <div class="col-xs-9 radioContainer" >
                                            <#if vprop.enum??>
                                                <#assign rmap=vprop.enum?eval/>
                                                <#list rmap?keys as v>
                                                    <label class="radio-inline">
                                                        <input type="radio" name="${field_name}" id="${field_name}_${v}" value="${v}" > ${rmap[v]}
                                                    </label>
                                                </#list>
                                            </#if>
                                        </div>
                                    </div>
                                <#elseif vprop.type=="text">
                                    <div class="form-group">
                                        <label class="col-xs-3 control-label" for="${field_name}">${field.label}:</label>
                                        <div class="col-xs-9 inputContainer">
                                            <input type="text" name="${field_name}" id="${field_name}" class="form-control" value="<#if vprop.dft??>${vprop.dft}</#if>" <#if field["isNull"]!=true>required</#if>/>
                                        </div>
                                    </div>

                                <#elseif vprop.type=="number">
                                    <div class="form-group">
                                        <label class="col-xs-3 control-label" for="${field_name}">${field.label}:</label>
                                        <div class="col-xs-9 inputContainer">
                                            <input type="number" name="${field_name}" id="${field_name}" class="form-control" value="<#if vprop.dft??>${vprop.dft}</#if>" <#if field["isNull"]!=true>required</#if>/>
                                        </div>
                                    </div>

                                <#elseif vprop.type=="hidden">
                                    <div class="form-group">
                                        <input type="hidden" name="${field_name}" id="<#if field.isId>id_${l_ent_name}_edit<#else>${field_name}</#if>" class="form-control" value="<#if vprop.dft??>${vprop.dft}</#if>" <#if field["isNull"]!=true>required</#if>/>
                                    </div>

                                <#elseif vprop.type=="password">
                                    <div class="form-group">
                                        <label class="col-xs-3 control-label" for="${field_name}">${field.label}:</label>
                                        <div class="col-xs-9 inputContainer">
                                            <input type="password" name="${field_name}" id="${field_name}" class="form-control">
                                        </div>
                                    </div>
                                </#if>
                            </#list>
                        </form>
                    </fieldset>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success btn-${l_ent_name}-save">提交</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>

    </div>
</div>
<!-- Modal -->
<div class="modal fade" id="${l_ent_name}DelModal" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">提示消息</h4>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <input type="hidden" name="id_${l_ent_name}_del" id="id_${l_ent_name}_del" />
                    确定要删除${entity.label}？
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success btn-${l_ent_name}-delete">删除</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
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

<!-- orther plugins -->
<script src="assets/vendor/bootstrapvalidator/js/bootstrapValidator.min.js"></script>

<!--  customer javascript -->
<script src="assets/js/main.js"></script>

<!--  CUSTOMER JAVASCRIPT -->
<script src="assets/js/${l_ent_name}_list.js"></script>

</body>
</html>