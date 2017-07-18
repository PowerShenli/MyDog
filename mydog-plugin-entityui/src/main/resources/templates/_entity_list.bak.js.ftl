${l_ent_name}Ctl = {

    initTable : function(){
        $("#${l_ent_name}Tb").bootstrapTable({
            columns:[
                <#list entity.fields as field>
                {
                    field: '${field.fieldName}',
                    checkbox: true,
                    rowspan: 2,
                    align: 'center',
                    valign: 'middle'
                },
                </#list>
                {
                    title: '操作',
                    field: '#',
                    align: 'center',
                    valign: 'middle',
                    checkbox: true,
                    rowspan: 2,
                    formatter:${l_ent_name}Ctl.opFormatter
                }
            ]
        });
    },

    initEventHandler : function(){
        //show add dialog
        $("#create_${l_ent_name}_btn").click(function(){
            ${l_ent_name}Ctl.resetForm();
            $('#add${l_ent_name}Div').modal();
        });

        //save entity
        $("#${l_ent_name}SubmitBtn").click(function(){
            var form = $("#${l_ent_name}Form");
            form.bootstrapValidator('validate');
            var flag = form.data("bootstrapValidator").isValid();
            console.log("validate form :"+flag);
            if(flag){
                var id = $("#${l_ent_name}Form")[0]["${entity.id.fieldName}"].value;
                var formData = {
                    <#list entity.fields as f>
                    "${f.fieldName}":$("#${l_ent_name}Form")[0]["${f.fieldName}"].value <#if f_has_next>,</#if>
                    </#list>
                };

                if(id == ""){
                    ${l_ent_name}Ctl.add(formData);
                }
                else{
                    ${l_ent_name}Ctl.update(formData);
                }
            }
        });

        $("#${l_ent_name}Form").bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {        //提示图标
                valid: 'fa fa-check-square-o',
                invalid: 'fa fa-times',
                validating: 'fa fa-exclamation'
            },
            fields:{
            <#list entity.fields as f>
                <#if f["isNull"]==false>
                ${f.fieldName}:{
                    validators:{
                        notEmpty: {
                            message: "${f.label}是必填的,不能为空"
                        }
                    }
                }<#if f_has_next>,</#if>
                </#if>
            </#list>
            }
        });
    },

    loadTableData : function(){
        ${l_ent_name}Ctl.sync2Server("${l_ent_name}","GET",{},
            function(data) {
                if(data["success"] == true) {
                    if(data["data"] != null) {
                        $("#${l_ent_name}Tb").bootstrapTable('load', data["data"]);
                    }
                    else{
                        console.log("data['data'] is null.");
                    }
                }
                else{
                    if(data["handler"] != null) {
                        ${l_ent_name}Ctl.callHandle(data["handler"]);
                    }
                }
            },
            function(er_ary){

                console.log("loadTableData ${l_ent_name}: msg.success = false, reason=" + msg["responseText"]);
            }
        )
    },

    callHandle:function(handlerStr){
        console.log("call handler");
        var handler = eval(handlerStr);
        if(typeof handler == "function") {
            handler.call();
        }
    },

    sync2Server:function(url, method, jsonData, s_call, e_call){
        //alert("type="+typeof(jsonData)+",d="+JSON.stringify(jsonData));
        $.ajax(url,{
            type: method,
            contentType:"application/json",
            dataType: "json",
            data: JSON.stringify(jsonData),
            success: function(data){
                console.log("success.data=" + JSON.stringify(data)+",typeof(data)="+typeof(data));
                if(typeof(data) == "string"){
                    data = eval("(" + data + ")");
                }
                s_call(data);
            },
            error: function(XMLHttpRequest, textStatus, errorThrown){
                //alert('error.XMLHttpRequest='+JSON.stringify(XMLHttpRequest)+",textStatus="+textStatus+",errorThrown="+errorThrown);
                try{
                    if(XMLHttpRequest.responseText){
                        var response = $.parseJSON(XMLHttpRequest.responseText);
                        var er_array = response.errors;
                        //alert("error array length="+er_array.length);
                        e_call(er_array);
                    }
                }catch(e){
                    console.log("parse errorinfo failed, e="+e);
                }
            }
        });
    },

    add:function(formData){
        //${l_ent_name}Ctl.resetForm();
        ${l_ent_name}Ctl.sync2Server("${l_ent_name}","POST", formData,
            function(data){
                console.log("success.data=" + JSON.stringify(data)+",typeof(data)="+typeof(data));
                if(data["success"] == true) {
                    BootstrapDialog.show({
                        type: BootstrapDialog.TYPE_SUCCESS,
                        title: '创建${entity.label}成功',
                        message: '创建${entity.label}成功',
                        buttons: [{
                            label: '关闭',
                            action: function(dialogItself){
                                dialogItself.close();
                            }
                        }]
                    });
                    $("#add${l_ent_name}Div").modal('toggle');
                    ${l_ent_name}Ctl.loadTableData();
                }
            },
            function(er_ary){
                for(e in er_ary){
                    var e_info = er_ary[e];
                    var objectName = e_info.objectName;
                    var fieldName = e_info.field;
                    var e_msg = e_info.defaultMessage;
                    $("#er_"+fieldName).remove();
                    $('<small/>')
                        .css('display', 'block')
                        .attr('data-bv-validator', 'remote')
                        .attr('data-bv-validator-for', fieldName)
                        .attr('id','er_'+fieldName)
                        .html(e_msg)
                        .addClass('help-block')
                        .appendTo($("#${l_ent_name}Form")[0][fieldName].parentNode);
                    //alert('append error elm for '+fieldName);
                    $("#${l_ent_name}Form").data('bootstrapValidator').updateStatus(fieldName,'INVALID','remote');

                    <#--$('#er_'+field).css('display','block');-->
                }
            }
        );
    },

    update:function(formData){
        console.log("== update,formDate="+JSON.stringify(formData)+" ==");
        //${l_ent_name}Ctl.resetForm();
        ${l_ent_name}Ctl.sync2Server("${l_ent_name}","PUT", formData,
            function(data){
                console.log("success.data=" + JSON.stringify(data)+",typeof(data)="+typeof(data));
                if(data["success"] == true) {
                    BootstrapDialog.show({
                        type: BootstrapDialog.TYPE_SUCCESS,
                        title: '更新${entity.label}成功',
                        message: '更新${entity.label}成功',
                        buttons: [{
                            label: '关闭',
                            action: function(dialogItself){
                                dialogItself.close();
                            }
                        }]
                    });
                    $("#add${l_ent_name}Div").modal('toggle');
                    ${l_ent_name}Ctl.loadTableData();
                }
            },
            function(er_ary){
                for(e in er_ary){
                    var e_info = er_ary[e];
                    var objectName = e_info.objectName;
                    var fieldName = e_info.field;
                    var e_msg = e_info.defaultMessage;
                    $("#er_"+fieldName).remove();
                    $('<small/>')
                        .css('display', 'block')
                        .attr('data-bv-validator', 'remote')
                        .attr('data-bv-validator-for', fieldName)
                        .attr('id','er_'+fieldName)
                        .html(e_msg)
                        .addClass('help-block')
                        .appendTo($("#${l_ent_name}Form")[0][fieldName].parentNode);
                    //alert('append error elm for '+fieldName);
                    $("#${l_ent_name}Form").data('bootstrapValidator').updateStatus(fieldName,'INVALID','remote');

                    <#--$('#er_'+field).css('display','block');-->
                }
            }
        );
    },

    opFormatter: function(value, row) {
        console.log("fbFormatter.row="+JSON.stringify(row));
        var detail = "<a href='#' onclick='${l_ent_name}Ctl.detail("+JSON.stringify(row)+")'>详情</a>";
        var edit = "<a href='#' onclick='${l_ent_name}Ctl.edit("+JSON.stringify(row)+")'>编辑</a>";
        var del = "<a href='#' onclick='${l_ent_name}Ctl.del("+JSON.stringify(row)+")'>删除</a>";
        return detail +"&nbsp;"+ edit + "&nbsp;" + del;
    },

    resetForm: function(){
        console.log("==resetForm()==");
        var form = $("#${l_ent_name}Form");
        form.data('bootstrapValidator').resetForm();
        form[0].reset();
    },

    detail: function(row){
        console.log("${l_ent_name}Ctr.detail("+JSON.stringify(row)+")");
    },

    edit: function(row){
        console.log("${l_ent_name}Ctr.edit("+JSON.stringify(row)+")");
        ${l_ent_name}Ctl.resetForm();
        <#list entity.fields as f>
            <#assign t=f["viewProp"].type/><#assign fn=f.fieldName/>
            <#if t=="redio">
            $("input[name='${fn}']").removeAttr("checked");
            //踩坑了,Jquery设置checkbox的checked属性attr改为了prop否则第二次失效
            $("input[name='${fn}'][value='"+row["${fn}"]+"']").prop("checked","true");
            <#else>
            $("#${fn}").val(row["${fn}"]);
            </#if>
        </#list>
        $('#add${l_ent_name}Div').modal();
    },

    del : function(row){
        console.log("${l_ent_name}Ctr.del("+JSON.stringify(row)+")");
        ${l_ent_name}Ctl.sync2Server(
            "${l_ent_name}/"+row["${entity.id.fieldName}"],//url
            "DELETE",  //method
            {},//formData
            function(data){
                console.log("success.data=" + JSON.stringify(data)+",typeof(data)="+typeof(data));
                if(data["success"] == true) {
                    BootstrapDialog.show({
                        type: BootstrapDialog.TYPE_SUCCESS,
                        title: '删除${entity.label}成功',
                        message: '删除${entity.label}成功',
                        buttons: [{
                            label: '关闭',
                            action: function(dialogItself){
                                dialogItself.close();
                            }
                        }]
                    });
                    ${l_ent_name}Ctl.loadTableData();
                }
            },
            function(er_ary){
                for(e in er_ary){
                    var e_info = er_ary[e];
                    var objectName = e_info.objectName;
                    var fieldName = e_info.field;
                    var e_msg = e_info.defaultMessage;
                    $("#er_"+fieldName).remove();
                    $('<small/>')
                        .css('display', 'block')
                        .attr('data-bv-validator', 'remote')
                        .attr('data-bv-validator-for', fieldName)
                        .attr('id','er_'+fieldName)
                        .html(e_msg)
                        .addClass('help-block')
                        .appendTo($("#${l_ent_name}Form")[0][fieldName].parentNode);
                    //alert('append error elm for '+fieldName);
                    $("#${l_ent_name}Form").data('bootstrapValidator').updateStatus(fieldName,'INVALID','remote');

                    <#--$('#er_'+field).css('display','block');-->
                }
            }
        );
    }
};

$(document).ready(function(){
    console.log("${l_ent_name}-list.js on ready.");
    ${l_ent_name}Ctl.initTable();
    ${l_ent_name}Ctl.initEventHandler();
    ${l_ent_name}Ctl.loadTableData();
});