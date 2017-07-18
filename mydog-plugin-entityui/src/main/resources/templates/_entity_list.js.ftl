<#assign l_ent_name=entity.entityName?lower_case/>
;(function (global) {
    'use strict';

    var ${l_ent_name}Table = $('#${l_ent_name}Tb');
    var tpl = '<tr><#list entity.fields as field><td>{{ ${field.fieldName} }}</td></#list><td><button class="btn btn-sm btn-${l_ent_name}-edit" data-toggle="modal" data-target="#${l_ent_name}Modal" data-whatever="{{ id }}"><i class="fa fa-edit"></i></button><button class="btn btn-sm btn-${l_ent_name}-del" data-toggle="modal" data-target="#${l_ent_name}DelModal" data-whatever="{{ id }}"><i class="fa fa-trash"</button></td></tr>';
    var lists = [];
    var editModal = $('#${l_ent_name}Modal');
    var delModal = $('#${l_ent_name}DelModal');

    function init() {

        getAll();

        // 新增 ｜ 编辑
        editModal.on('show.bs.modal', function (e) {
            var button = $(e.relatedTarget);
            var id = button.data('whatever');
            var modal = $(this);

            if(id && id!=''){
                modal.find('input[name=id]').val(id);
                modal.find('.modal-title em').html('新建');
                $_ajax.get('/${l_ent_name}/'+id).then(function (res) {
                    if(res && res.success){
                        var d = res.data || {};
                        modal.find('#${l_ent_name}').val(d.name || '');
                        modal.find('#${l_ent_name}_'+d.available).prop('checked',true);
                    }
                });
            } else {
                modal.find('.modal-title em').html('编辑');
            }
        });
        $(".${l_ent_name}Box").on('click','.btn-${l_ent_name}-save',function(e){
            // save data
            var id = editModal.find('input[name=id]').val();
            var flag = $("#${l_ent_name}Form").data("bootstrapValidator").isValid();
            if(flag){
                var param = {
                    <#list entity.fields as f>
                    <#assign t=f["viewProp"].type/><#assign fn=f.fieldName/>
                    <#if t=="radio">
                    '${fn}':$("input[name='${fn}']").prop("checked")
                    <#else>
                    '${fn}':$("#${fn}").val()
                    </#if>
                    <#if f_has_next>,</#if>
                    </#list>
                };
                if(id && id!=''){
                    edit(param);
                } else {
                    add(param);
                }
            }
        });
        // 初始化校验
        $("#${l_ent_name}Form").bootstrapValidator({
            message: '校验不通过',
            feedbackIcons: {        //提示图标
                valid: 'fa fa-check-square-o',
                invalid: 'fa fa-times',
                validating: 'fa fa-exclamation'
            },
            fields:{
                <#list entity.fields as f>
                ${f.fieldName}:{
                <#if f.validates??>
                    <#assign valids = f.validates />
                    validators:{
                    <#list valids as v>
                        <#--"${v}" ---->
                        <#--<#assign  res = v?matches(r"(NotNull)[\(]")>-->
                        <#assign  res = v?matches(r"(^@\S+)[(]") />
                        <#list res as m>
                        <#if m?groups[1] == "@NotNull">
                        notEmpty: {
                            message: "${f.label}是必填的,不能为空"
                        }
                        </#if>
                        <#if m?groups[1] =="@Size">
                        stringLength: {
                            min: 6,
                            max: 18,
                            message: "${f.label}长度为{6}-{18}个字符"
                        }
                        </#if>
                        <#if m?groups[1] == "@Pattern">
                        regexp: {
                            regexp: /^[A-Za-z0-9]+$/,
                            message: "${f.label}格式不正确"
                        }
                        </#if>
                        <#if m?groups[1] == "@DecimalMax">
                        <#assign hasAge = true />
                        ages: {
                            lessThan: {
                                value: 99,
                                inclusive: true,
                                message: "${f.label}数值不能大于{99}"
                            }
                        }
                        </#if>
                        <#if m?groups[1] == "@DecimalMin">
                        ages2: {
                            greaterThan: {
                                value: 18,
                                inclusive: true,
                                message: "${f.label}数值不能小于{18}"
                            }
                        }
                        </#if><#if v_has_next>,</#if>
                        </#list>

                        <#--<#if res>-->
                        <#--<#if res?groups[1] == "@NotNull">-->
                        <#--notEmpty: {-->
                            <#--message: "${f.label}是必填的,不能为空"-->
                        <#--}-->
                        <#--</#if>-->

                        <#--</#if>-->
                    </#list>
                    }
                </#if>
                }
                <#if f_has_next>,</#if>
                </#list>
            }
        });

        delModal.on('show.bs.modal', function (e) {
            var button = $(e.relatedTarget);
            var id = button.data('whatever');
            var modal = $(this);

            if(id && id!=''){
                modal.find('input[name=id]').val(id);
            }
        });
        $(".${l_ent_name}Box").on('click','.btn-${l_ent_name}-del',function(e){
            // delete
            var id = delModal.find('input[name=id]').val();
            if(id && id!=''){
                del(id);
            }else{
                //delModal.modal('hide');
            }
        });

    }


    function getAll() {
        $_ajax.get('/${l_ent_name}').then(function (res) {
            if(res.success && res.data){
                var d = res.data;
                var lists = [];
                if(Utils.isArray(d) && d.length>0){
                    for(var i=0,l=d.length;i<l;i++){
                        lists.push(Utils.parseTemplate(tpl,d[i]));
                    }

                    ${l_ent_name}Table.find('tbody').html(lists.join(''));
                }
            }
        });
    }
    function getDataOfPage(limit) {
        $_ajax.get('/${l_ent_name}/limit-'+limit).then(function (res) {
            if(res && res.success){
                // 刷新数据
                getAll();
            }
        });
    }
    function add(obj) {
        if(!Utils.isObject(obj)){
            return;
        }
        $_ajax.post('/${l_ent_name}',obj).then(function (res) {
            if(res && res.success){
                // 刷新数据
                getAll();
                editModal.find('input').val('');
                editModal.modal('hide');
            }
        });
    }
    function edit(obj) {
        if(!Utils.isObject(obj)){
            return;
        }
        $_ajax.put('/${l_ent_name}/'+obj.id,obj).then(function (res) {
            if(res && res.success){
                // 刷新数据
                getAll();
                editModal.find('input').val('');
                editModal.modal('hide');
            }
        });
    }
    function del(id) {
        $_ajax.del('/${l_ent_name}/'+id).then(function (res) {
            if(res && res.success){
                // 刷新数据
                getAll();
                delModal.modal('hide');
            }
        });
    }

    $(document).ready(function() {
        init();
    });

}(window,undefined))

