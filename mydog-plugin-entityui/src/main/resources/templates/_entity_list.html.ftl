<#assign l_ent_name=entity.entityName?lower_case/>
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

    <!-- Plugin CSS -->
    <link href="css/plugins/footable/footable.core.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="assets/css/style.css" rel="stylesheet">


    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]--><meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />

</head>
<body>

<div id="wrapper">
    <!-- Navigation -->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="sidebar-collapse" id="menu-box">
            <ul class="nav metismenu" id="side-menu">
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
                    <li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                            <i class="fa fa-envelope"></i>  <span class="label label-warning">16</span>
                        </a>
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
        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>FooTable with row toggler, sorting and pagination</h5>

                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                    <i class="fa fa-wrench"></i>
                                </a>
                                <ul class="dropdown-menu dropdown-user">
                                    <li><a href="#">Config option 1</a>
                                    </li>
                                    <li><a href="#">Config option 2</a>
                                    </li>
                                </ul>
                                <a class="close-link">
                                    <i class="fa fa-times"></i>
                                </a>
                            </div>
                        </div>
                        <div class="ibox-content">

                            <table class="footable table table-stripped toggle-arrow-tiny tablet breakpoint footable-loaded">
                                <thead>
                                <tr>

                                    <th data-toggle="true" class="footable-visible footable-first-column footable-sortable">Project<span class="footable-sort-indicator"></span></th>
                                    <th class="footable-visible footable-sortable">Name<span class="footable-sort-indicator"></span></th>
                                    <th class="footable-visible footable-sortable">Phone<span class="footable-sort-indicator"></span></th>
                                    <th data-hide="all" class="footable-sortable" style="display: none;">Company<span class="footable-sort-indicator"></span></th>
                                    <th data-hide="all" class="footable-sortable" style="display: none;">Completed<span class="footable-sort-indicator"></span></th>
                                    <th data-hide="all" class="footable-sortable" style="display: none;">Task<span class="footable-sort-indicator"></span></th>
                                    <th data-hide="all" class="footable-sortable" style="display: none;">Date<span class="footable-sort-indicator"></span></th>
                                    <th class="footable-visible footable-last-column footable-sortable">Action<span class="footable-sort-indicator"></span></th>
                                </tr>
                                </thead>

                                <tbody>
                                <tr class="footable-even" style="">
                                    <td class="footable-visible footable-first-column"><span class="footable-toggle"></span>Project - This is example of project</td>
                                    <td class="footable-visible">Patrick Smith</td>
                                    <td class="footable-visible">0800 051213</td>
                                    <td style="display: none;">Inceptos Hymenaeos Ltd</td>
                                    <td style="display: none;"><span class="pie">0.52/1.561</span></td>
                                    <td style="display: none;">20%</td>
                                    <td style="display: none;">Jul 14, 2013</td>
                                    <td class="footable-visible footable-last-column"><a href="#"><i class="fa fa-check text-navy"></i></a></td>
                                </tr>

                                </tbody>
                                <tfoot>
                                <tr>
                                    <td colspan="5" class="footable-visible">
                                        <ul class="pagination pull-right"><li class="footable-page-arrow disabled"><a data-page="first" href="#first">«</a></li><li class="footable-page-arrow disabled"><a data-page="prev" href="#prev">‹</a></li><li class="footable-page active"><a data-page="0" href="#">1</a></li><li class="footable-page"><a data-page="1" href="#">2</a></li><li class="footable-page-arrow"><a data-page="next" href="#next">›</a></li><li class="footable-page-arrow"><a data-page="last" href="#last">»</a></li></ul>
                                    </td>
                                </tr>
                                </tfoot>
                            </table>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- main content end... -->

        <!-- old... -->
        <div class="row">
            <div class="col-lg-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>FooTable with row toggler, sorting and pagination</h5>

                        <div class="ibox-tools">
                            <button class="btn btn-info" id="create_${l_ent_name}_btn"><span class="glyphicon glyphicon-plus"/>&nbsp;新建${entity.label}</button>
                            <button class="btn btn-info" id="search_${l_ent_name}_btn"><span class="glyphicon glyphicon-plus"/>&nbsp;查询</button>
                        </div>
                    </div>

                    <table data-toggle="table" id="${l_ent_name}Tb">
                        <thead>
                        <tr>
                        <#list entity.fields as field>
                            <th data-field="${field.fieldName}">${field.label}</th>
                        </#list>
                            <th data-formatter="${l_ent_name}Ctl.opFormatter">操作</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>

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
<div class="modal fade" id="add${l_ent_name}Div" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">新建${entity.label}</h4>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <div class="row-fluid">
                        <div class="span12">
                            <fieldset>
                                <form method="POST" id="${l_ent_name}Form" role="form" class="form-horizontal" data-toggle="validator">
                                    <#list entity.fields as field>
                                    <#assign field_name=field.fieldName/>
                                    <#assign vprop=field.viewProp/>
                                        <#if vprop.type=="select">
                                        <div class="form-group">
                                            <label for="${field_name}">${field.label}:</label>
                                            <select name="${field_name}" class="form-control" id="#{field_name}" <#if field["null"]!=true>required</#if>>
                                                <#if vprop.enum??>
                                                    <#assign options=vprop.enum?eval/>
                                                    <#list options?keys as v>
                                                        <option value="${v}">${options[v]}</option>
                                                    </#list>
                                                    <#--<div id="ermsg_${field_name}" class="help-block with-errors"></div>-->
                                                </#if>
                                            </select>
                                        </div>
                                        <#elseif vprop.type=="redio">
                                        <div class="form-group">
                                            <label class="control-label" for="${field_name}">${field.label}:</label>
                                            <div class="controls" >
                                                <#if vprop.enum??><#assign rmap=vprop.enum?eval/>
                                                    <#list rmap?keys as v>
                                                <label class="radio-inline">
                                                    <input type="radio" name="${field_name}" id="${field_name}_${v}" value="${v}" > ${rmap[v]}
                                                </label>
                                                    </#list>
                                                    <#--<div id="ermsg_${field_name}" class="help-block with-errors"></div>-->
                                                </#if>
                                            </div>
                                        </div>

                                        <#elseif vprop.type=="text">
                                        <div class="form-group">
                                            <label class="control-label" for="${field_name}">${field.label}:</label>
                                            <input type="text" name="${field_name}" id="${field_name}" class="form-control" value="<#if vprop.dft??>${vprop.dft}</#if>" <#if field["null"]!=true>required</#if>/>
                                            <#--<div id="ermsg_${field_name}" class="help-block with-errors"></div>-->
                                        </div>
                                        <#elseif vprop.type=="number">
                                        <div class="form-group">
                                            <label class="control-label" for="${field_name}">${field.label}:</label>
                                            <input type="number" name="${field_name}" id="${field_name}" class="form-control" value="<#if vprop.dft??>${vprop.dft}</#if>" <#if field["null"]!=true>required</#if>/>
                                            <#--<div id="ermsg_${field_name}" class="help-block with-errors"></div>-->
                                        </div>
                                        <#elseif vprop.type=="hidden">
                                        <div class="form-group">
                                            <input type="hidden" name="${field_name}" id="${field_name}" class="form-control" value="<#if vprop.dft??>${vprop.dft}</#if>" <#if field["null"]!=true>required</#if>/>
                                        </div>
                                        <#elseif vprop.type=="password">
                                        <div class="form-group">
                                            <label class="control-label" for="${field_name}">${field.label}:</label>
                                            <input type="password" name="${field_name}" id="${field_name}" class="form-control">
                                            <#--<div id="ermsg_${field_name}" class="help-block with-errors"></div>-->
                                        </div>
                                    </#if>
                                    </#list>

                                </form>
                            </fieldset>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success" id="${l_ent_name}SubmitBtn">提交</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>

    </div>
</div>




<!-- vendor lib -->
<script src="assets/js/lib/jquery-3.1.1.min.js"></script>
<script src="assets/js/lib/bootstrap.min.js"></script>

<!-- common plugins -->
<script src="assets/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="assets/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="assets/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

<!--  customer javascript -->
<script src="assets/js/main.js"></script>

<!--  CUSTOMER JAVASCRIPT -->
<script src="assets/js/${l_ent_name}_list.js"></script>

</body>
</html>