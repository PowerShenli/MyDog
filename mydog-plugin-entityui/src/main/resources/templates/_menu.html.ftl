
    <#--<!-- Navigation &ndash;&gt;-->
    <#--<nav class="navbar-default navbar-static-side" role="navigation">-->
        <#--<div class="sidebar-collapse" id="menu-box">-->
            <#--<ul class="nav metismenu" id="side-menu">-->
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

            <#--</ul>-->
        <#--</div>-->
    <#--</nav>-->


