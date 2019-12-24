# Selenium Grid的原理、配置与使用：Hub & Node，含Docker上部署
## Selenium Grid介绍
### Selenium组件
- **Selenium集成开发环境(IDE)**
> Selenium IDE实现为Firefox扩展，在测试脚本上提供记录和回放功能。 它允许测试人员以HTML，Java，Ruby，RSpec，Python， C# ，JUnit和TestNG等多种语言导出录制的脚本。 可以在Selenium RC或Webdriver中使用这些导出的脚本。
>
> Selenium IDE的范围有限，生成的测试脚本不是非常健壮和可移植。
- **Selenium远程控制器(Selenium RC 现已弃用)**
- **Selenium WebDriver**
> Selenium WebDriver(Selenium 2)是Selenium RC的继承者，也是Selenium Suite最重要的组件。 SeleniumWebDriver提供了一个编程接口来创建和执行测试用例。 编写测试脚本是为了识别网页上的Web元素，然后对这些元素执行所需的操作。
>
> 与Selenium RC相比，Selenium WebDriver执行速度更快，因为它可以直接调用Web浏览器。 另一方面，RC需要RC服务器与Web浏览器进行交互。
>
> 因为，WebDriver直接调用不同浏览器的方法，因此每个浏览器都有单独的驱动程序。
- **Selenium Grid**
> Selenium Grid也是Selenium Suite的一个重要组件，它允许在不同的机器上并行运行不同浏览器的测试。 简单来说，可以在运行不同浏览器和操作系统的不同机器上同时运行测试。
>
> Selenium Grid遵循Hub-Node架构来实现测试脚本的并行执行。Hub被视为网络的主设备，另一个将是节点。 Hub控制在网络的各个节点上执行测试脚本。
>
> Selenium Grid实际它是基于Selenium RC的，而所谓的分布式结构就是由一个hub节点和若干个node代理节点组成。Hub用来管理各个代理节点的注册信息和状态信息，并且接受远程客户端代码的请求调用，然后把请求的命令转发给代理节点来执行。下面结合环境部署来理解Hub与node节点的关系。

![hub-node](https://aichenwei.oss-ap-southeast-1.aliyuncs.com/github/test-com.selenium-grid/hub_and_nodes.jpg)

### Selenium Grid使用场景
比如当自动化测试用例达到一定数量的时候，比如上万，一台机器执行全部测试用例耗时5个小时(只是举例，真正的耗时是需要根据测试用例场景的复杂度决定的)，而如果需要覆盖主流浏览器比如Chrome、Firefox，加起来就是10个小时；这时候领导跟你说有什么办法可以解决这个执行速度？当然最笨的办法就是另外拿台机器，然后部署环境，把测试用例分开去执行然后合并结果即可。而Selenium也想到了这点，所以有了Selenium Grid的出现，它就是解决分布式执行测试的痛点。

## 一般环境部署方法（非docker）
下面通过一般方式部署来演示Selenium Grid的使用方法和使用场景。

Selenium Grid 包含一个Hub 和至少一个 Node，两者都可由 com.selenium-server-standalone.jar 文件启动

Selenium Grid 的部署

1.安装Selenium Grid ：从Selenium 官网下载 com.selenium-server-standalone.jar 文件即可。Java 可执行文件的路径必须正确，这样才能从命令行运行文件，如果运行出错，检查系统的路径变量看其是否依据包括Java 可执行文件的路径

2.启动Selenium Grid ：一般而言，运行Selenium Grid 需要先启动Hub，因为 Node 的调用依赖于 Hub

### 下载selenium-server-standalone-4.0.0-alpha-2.jar
- [下载地址](http://com.selenium-release.storage.googleapis.com/index.html)

- [百度网盘](https://pan.baidu.com/s/1JNSDM9JqH83gs4jY0jUN7w)，密码：qkgx

### 启动Hub
```shell script
java -jar selenium-server-standalone-4.0.0-alpha-2.jar -role hub
```
![output](https://aichenwei.oss-ap-southeast-1.aliyuncs.com/github/test-selenium-grid/2.png)
所有可支持操作系统都能调用该命令。需要注意的是根据selenium-server-standalone 版本的不同，jar 文件名里的版本号需要有相应改动。Hub 启动的默认端口号为4444，用户可通过 -port 参数来定义其启动端口
```shell script
java -jar com.seleniumnium -role hub -port 8888
```
可通过浏览器中输入如下地址来检查 Hub 是否启动成功：

http://localhost:4444/grid/console

![output](https://aichenwei.oss-ap-southeast-1.aliyuncs.com/github/test-selenium-grid/3.png)

### 启动Nodecom.seleniuml 
```shell script
java -jar selenium-server-standalone-4.0.0-alpha-2.jar -role node
```
![out](https://aichenwei.oss-ap-southeast-1.aliyuncs.com/github/test-selenium-grid/4.png)
这里假设默认设置的 Hcom.selenium。Hub 用来监听新请求的默认端口是4444，所以定位 Hub 的URL 中使用了4444这个端口。使用本地主机是假定 Node 和 Hub 在同一台机器上运行。

如果在不同机器上运行 Node 和 Hub，则需要将本地主机名替换成运行Hub 的机器的主机名。在这种情况下，Node 会将本机操作系统所能支持的浏览器信息全部注册到 Hub 上。

如果将参数-roal node 替换成 -role webdriver，则表示该 Node只兼容WebDriver 的执行模式。相应的，如果替换成 -role rc，则表示该Node 只兼容 Remote Control 的执行模式

我这里的Node随机监听了一个端口是3714，所以可以通过http://localhost:3714进行访问：
![image](https://aichenwei.oss-ap-southeast-1.aliyuncs.com/github/test-selenium-grid/5.png)

### 测试用例

```shell script

```

## 启动容器

## 测试服务