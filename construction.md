## MyDog 结构概述

### 模块及功能介绍

##### mydog-core <br/>
  
* 包含生成代码的核心类，以及相关定义类

##### mydog-web <br/>
* 使用者的入口web项目，用户用过mydog-web界面选择和定制自己要生成的代码，最后一件生成。

##### mydog-shell <br/>
* 一个全功能的命令行操作入口，不喜欢web的用户可以通过该入口进行代码生成。

##### mydog-plugin-xxx

* ``xxx`` 代表插件的名字，一个插件就是一个功能的定义，在插件中可以定义本功能相关的信息。
* 初版里的插件有: 
  1. **project**    --> 生成项目的工程相关文件
  2. **datasource** --> 生成项目的数据源相关文件
  3. **entity**     --> 生成实体，实体相关的后台文件
  4. **entityui**   --> 生成实体对应的前端文件

### 特点

##### MyDog的``插件化``是最大的特点。

 1. 通过mydog-web，让用户自己选择自己需要的功能（插件）
 2. 插件是按照功能进行隔离的，一个功能只在插件内封装，而不会向外扩散。这样对后期的开发和维护都提供了便利。
 3. 在代码生成的过程，mydog-core的执行器不关注具体功能，插件化使得添加或去除功能对生成的过程无感知。即生成的过程与生成的内容解耦。

##### 插件接口定义



### 代码生成过程

关键类在子项目 ``mydog-core`` 的 ``org.huangpu.mydog.core.flow.FlowController``这个类中。


##### 生成代码过程示意图

![代码生成流程图](https://raw.githubusercontent.com/PowerShenli/MyDog/master/mydog-doc/src/main/resources/mydog_gen_flow.png)

##### 生成代码的步骤如下：
1. 启动系统后初始化插件。这一步系统初始化所有已知的插件定义，并加载插件相关的配置到内存。
2. 用户通过mydog-web选择所需要的插件，按照需要进行配置（填写元数据）。这里一是选择要什么功能，不要什么功能。二是填写选择过的插件的具体定义，这里可以做的很强大，比如数据源插件可以支持业界大部分数据源类型，并当用户选择其中一种后，继续让用户填写此种数据源需要填写的元数据，或给出默认配置等等。三是选择最终生成的格式。<br/> 用户选择好后，点击“一键生成”，mydog-web会将生成好的元数据发送给FlowController。
3. FlowController 首先检测元数据对应插件的依赖关系，比如datasource依赖Project，那么选择datasource则必须选中project，校验不通过则提示用户。
4. FlowController 解析``元数据``列表. 这里的元数据可以理解为一系列用户选择的插件生成的功能定义。可以参考 demo.json
5. 合并元数据属性。这是为了应对新添加的插件对已有插件进行扩展的情况. 比如app.properties 是由 mydog-plugin-project 负责生成的，而mydog-plugin-datasource 插件也需要向 app.properties 中添加属性，则在这一步骤中将需要添加的属性合并到 project插件对应的属性中，最终一并生成。 （这里引入了两个问题：插件的依赖问题 与 属性的可见性问题。后面会说明）
6. 迭代元数据列表，找到每个元数据对应的功能插件，通过插件定义找到生成器、输出项，然后调用生成器执行代码生成动作，这一步输出的代码以字符串存储在内存中。
7. 将生成好的代码按照持久化配置方式进行持久化（目前是简单的写文件，未来可能扩展为war包、jar包、docker 镜像、甚至直接部署至云平台并启动运行  等等）



### 一个插件都包含哪些内容
* 依赖哪些插件（属性）
* 对哪些插件产生影响
* 最终会输出些什么（file？sql？）
* 用什么生成器生成，怎么生成。
* 用户都有哪些选择？（对应mydog-web改如何展现）

**这也正是插件接口的定义** ：

```java
public interface MyDogPlugin {

    /**
     * 初始化
     */
    void init();

    /**
     * 获取元数据类型
     * @return 元数据类型
     */
    String getMetadataType();

    /**
     * 获取本插件依赖的其它插件的属性
     * @return 依赖的属性
     */
    JSONObject getDependencyProps();

    /**
     * 获取元数据属性解析器
     * @return 元数据的属性解析器
     */
    MetaDataPropResolver getPropResolver();

    /**
     * 获取该插件输出定义
     * @return 输出定义
     */
    OutputDef getOutputDef();

    /**
     * 获取该插件的元数据相关的装饰器
     * 该方法是为了让插件可以扩展默认生成器的行为
     * @return 返回对应装饰器
     */
    GeneratorDecorator getGeneratorDecorator(Generator generator);


    /**
     * 获取该插件在mydog-web展现的内容
     *
     * @return
     * 返回JSON中应该包含可选的实例,以及每个实例对应的属性列表.
     * 属性列表中,应该明确每个属性的类型和对应的UI元素类型,及取值范围.
     * 比如Entity User 的 sex 属性, 类型是int,对应的UI元素类型是 select
     * 取值范围是 {"男":1,"女":2}
     *
     * mydog-web 会读取所有插件，并获取展示属性(通过本方法)，
     * mydog-web 会根据通用逻辑进行页面渲染.而不用根据不同插件的属性
     * 进行定制化的UI开发.
     *
     */
    JSONObject getViewProps();

}
```

**下面举个例子**

比如mydog-plugin-entityui 这个插件

我们先看它的代码结构：

<img src="https://raw.githubusercontent.com/PowerShenli/MyDog/master/mydog-doc/src/main/resources/mydog-entityui/mydog-plugin-entityui_codes.png" width="400px"/>

 * src/main/resources/templates 
    这里可能会有三种文件
    1. 准备直接copy到输出目录的文件（各种后缀）
    2. 输出文件的模板文件(.ftl）
    3. 插件依赖定义、输出项的定义文件（.json)
    
 * src/main/resource/META-INF/
    1. SPI 相关配置
    
 * src/main/java/
    1. 插件相关的类，这里至少应该包含一个MyDogPlugin接口实现类

    
#### 插件依赖定义
依赖定义文件名默认为 ``${插件名}_dependency_def.json`` <br/>
默认路径在 src/main/resources/templates 下<br/>
比如``mydog-plugin-datasource``这个插件，依赖定义文件为<br/> <b>``datasource_dependency_def.json``</b>:

```json
{
  "pluginName":"datasource",
  "dependency":[
    {
      "meta":"project",
      "props": ["basePath","outputPath","basePackage"]
    }
  ]
}
```

meta 的属性是 的project 即为依赖的插件，
props 是依赖的project 中的属性，当project插件的这些属性未定义时，
应该提示用户必须指定这些属性，否则datasource 插件则不能使用。

#### 插件输出项定义

输出项定义文件名默认为 ``${插件名}_output_def.json`` <br/>
默认路径在 src/main/resources/templates 下<br/> 
比如 ``mydog-plugin-entityui`` 这个插件，输出项定义文件为：<br/>
<b>``entityui_output_def.json``</b>:

```ftl
<#assign prj=project["mydogProj"]/>
{
  "pluginName":"entityui",
  "outItemsDef": {
<#list entity?keys as ent>
<#assign ev=entity[ent]/>
        "${ent}":[
            {
              "itemName": "${ev.entityName?lower_case}-list.html",
              "outputPath": "${prj.outputPath}src/main/resources/static/",
              "genType": "byTemplate",
              "tmpFilePath": "templates/_entity_list_html.ftl"
            },
            {
              "itemName": "${ev.entityName?lower_case}-list.js",
              "outputPath": "${prj.outputPath}src/main/resources/static/",
              "genType": "byTemplate",
              "tmpFilePath": "templates/_entity_list_js.ftl"
            }
        ]
<#if ent_has_next>      ,</#if>
</#list>
        ,
      //下面的只用生成一次
        "Common":[
            {
                "itemName": "bootstrap.directory", //可以由itemName后缀决定文件类型
                "outputPath": "${prj.outputPath}src/main/resources/static/",
                "genType": "byCopy",
                "cpFilePath": "templates/bootstrap/"
            }
            {
                "itemName":"index.html",
                "outputPath":"${prj.outputPath}src/main/resources/static/",
                "genType":"byTemplate",
                "tmpFilePath":"templates/_index.html.ftl"
            }
        ]
  }
}
```

可以看到定义文件本身其实是一个半成品，它也是一个ftl的模板文件。
原因是，输出项可能和元数据相关，类似的输出项可能不是直接能定义出来的，
所以需要模板。

我们单独拿一个输出项出来看看：

```json
{
    "itemName":"index.html",
    "outputPath":"${prj.outputPath}src/main/resources/static/",
    "genType":"byTemplate",
    "tmpFilePath":"templates/_index.html.ftl"
}
```
 * **itemName**      ---> 是输出文件的名称
 * **outputPath**    ---> 是输出文件相对于项目的位置
 * **genType**       ---> 使用哪种方式产生输出
 * **tmpFilePath**   ---> 如果输出使用了模板，指定模板的位置和名称

##### 目前生成输出文件的方式有 4种:
 
 1. **byTemplate**  --->用模板方式生成
 2. **byCopy**  --->直接copy文件到输出的目录（还需要指定``cpFilePath``属性）
 3. **byCode**  --->通过指定一个类的全限定名，用这个类来产生输出(還要指定 ``generator`` 属性，属性值即自定义生成器）
 4. **byGrammar** --->支持用itemName的后缀名得到对应语言的抽象语法树，通过语法树来生成代码（这个模式还没有用好，最灵活，但也最复杂）
 
#### 生成器扩展点
1. byCode方式可以指定一个实现了Generator接口的自定义代码生成器。
2. 可以在本插件对应的MydogPlugin实现类中指定一个生成器的装饰器实现类。<br/>装饰器可以对指定的所有生成器进行装饰，这个装饰器一般针对该插件的所有输出项公共的逻辑。
比如entity插件的装饰器``EntityGeneratorDecorator`` 就在模板渲染前对属性进行了修改。





