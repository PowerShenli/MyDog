# MyDog

![MyDog logo](https://raw.githubusercontent.com/PowerShenli/MyDog/master/mydog-doc/src/main/resources/mydog.ico)

MyDog - 开发者最忠实的朋友.

主人，有什么吩咐？生成代码？好的。让我帮你做更多的事, 汪汪！

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

#### 3. 修改配置
用任何编辑器打开 ``/tmp/mydog/Mydog/mydog-shell/demo.json``
这是一个纯JSON格式文件，请小心编辑，不要破坏格式。

  * 修改输出文件位置

找到关键字 ``outputPath``
可以将默认的 ``/tmp/myDog_1/output/, `` 修改为系统已存在的目录，这个目录即最终生成代码的目录。（本Demo中不做修改）

  * 修改服务端口

找到配置文件里的 `` "server.port":"8082"，`` 这一行进行修改，默认是8082

  * 修改jdbc驱动路径

找到关键字 ``driverJarPath`` ,确认与与数据库匹配，且路径有效

#### 4. 创建数据库
参照第第三步的配置文件中的 ``spring.datasource.url`` 参数，创建数据库。
使用localhost:3306端口，默认数据库mydog,IP 端口和 数据库名均可修改，但
数据库目前仅仅支持mysql，后续会支持多种数据库。


```
mysql> create database mydog default charset utf8;
```

#### 5. 执行代码生成

```
~$> cd /tmp/mydog/MyDog/mydog-shell/target
~$> java -jar mydog-shell-1.0-SNAPSHOT.jar ../demo.json
```

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
