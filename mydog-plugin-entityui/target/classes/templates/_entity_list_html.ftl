<#assign l_ent_name=entity.entityName?lower_case/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
    <!--  bootstrap-table -->
    <script src="js/bootstrap-table.min.js"></script>
    <script src="js/bootstrap-table-locale-all.min.js"></script>
    <#--<script src="js/fileinput.js"></script>-->
    <#--<link  href="css/fileinput.min.css" rel="stylesheet">-->
</head>
<body>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
            <!-- MyDogDemo Project</small> -->
        </h1>
        <ol class="breadcrumb">
            <li class="active"><i class="fa fa-dashboard"></i>
                <button class="btn btn-info" id="create_${l_ent_name}_btn"><span class="glyphicon glyphicon-plus"/>&nbsp;新建${entity.label}</button>
            </li>
            <li class="active"><i class="fa fa-dashboard"></i>
                <button class="btn btn-info" id="search_${l_ent_name}_btn"><span class="glyphicon glyphicon-plus"/>&nbsp;查询</button>
            </li>
        </ol>
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


<div>
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

</body>
<script src="${l_ent_name}-list.js"></script>

</html>