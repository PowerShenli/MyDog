# MyDog

![MyDog logo](https://raw.githubusercontent.com/PowerShenli/MyDog/master/mydog-doc/src/main/resources/mydog.ico)

MyDog - 开发者最忠实的朋友.

主人，有什么吩咐？生成代码？好的。让我帮你做更多的事, 汪汪！

MyDog的HTML界面请看[这里](./mydog-web/Readme.md)

## 介绍
**MyDog** 是一个自动代码生成工具。

最初版支持一键生成一个基于Spring Boot的web工程。包括项目骨架和实体的CRUD功能以及web界面。

  * 有别于其他代码生成器的特点
  
由于所有功能均是通过**插件**实现的. 所以理论上讲,只要扩展更多的插件,功能的扩展也将是无限的.


## 快速开始

#### 1. 克隆项目到本地（比如 /tmp/mydog/目录）：

```
~$> cd /tmp/mydog
~$> git clone https://github.com/PowerShenli/MyDog.git
```

#### 2. 编译源代码

首先确保运行环境下已经有maven环境，如果没有，请参考 [install apache maven](http://maven.apache.org/install.html)

另外JDK需要8+

```
~$> cd /tmp/mydog/MyDog
~$> mvn install -Dmaven.test.skip=true
```
编译成功将看到 ``BUILD SUCCESS`` 


#### 如果你不希望编译源代码,也可以直接下载已经编译好的文件:
 
  *  [mydog-shell.jar](https://github.com/PowerShenli/MyDog/releases/download/0.01/mydog-shell-1.0-SNAPSHOT.jar)
  *  [demo.json](https://github.com/PowerShenli/MyDog/releases/download/0.01/demo.json)


#### 3. 修改配置

* 配置文件说明
  
用任何编辑器打开 ``/tmp/mydog/Mydog/mydog-shell/demo.json``
这是一个纯JSON格式文件，请小心编辑，不要破坏格式。

其实demo.json 即元数据定义,更灵活的配置是结合mydog-web进行生成的. 
这里使用固化的文件仅仅为了演示流程.
<br/>

  * 修改输出文件位置

找到关键字 ``outputPath``
可以将默认的 ``/tmp/myDog_1/output/, `` 修改为系统已存在的目录，这个目录即最终生成代码的目录。（本Demo中不做修改）
<br/>

  * 修改服务端口

找到配置文件里的 `` "server.port":"8082"，`` 这一行进行修改，默认是8082

<br/>


#### 4. 创建数据库,修改配置
  * 创建数据库

```
mysql> create database mydog default charset utf8;
```

  * 修改数据库相关信息
  
找到关键字 ``driverJarPath`` , 修改驱动路径确认与数据库匹配，且路径有效<br/>
找到关键字 ``spring.datasource.url`` 修改为正确的连接信息，如ip端口等<br/>
找到关键子 ``spring.datasource.username`` 和 ``spring.datasource.password`` 修改为正确的用户名和密码<br/>


#### 5. 执行代码生成

```
~$> cd /tmp/mydog/MyDog/mydog-shell/target
~$> java -Dfile.encoding=utf-8 -jar mydog-shell-1.0-SNAPSHOT.jar ../demo.json
```

 ``-Dfile.encoding=utf-8`` 是针对windows cmd这种环境编码可能有问题而加上的.

#### 6. 查看输出

```
~$> cd /tmp/myDog_1/output/
~$> ls -l
```
应该可以看到如下目录

<img src="https://raw.githubusercontent.com/PowerShenli/MyDog/master/mydog-doc/src/main/resources/mydog-shell_1.png" width="500" height="800"/>

#### 7. 运行生成后的项目

```
~$> cd /tmp/mydog_1/output
~$> mvn package
~$> java -jar target/MyDogPrj-1.0.0-SNAPSHOT.jar
```

#### 8. 测试

访问网页 [http://localhost:8082/index.html](http://localhost:8082/index.html)

进行CRUD验证。
