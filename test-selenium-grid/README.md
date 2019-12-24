# 在Docker上安装Selenium Grid分布式测试
## Selenium Grid介绍
### Selenium组件
- Selenium集成开发环境(IDE)
> Selenium IDE实现为Firefox扩展，在测试脚本上提供记录和回放功能。 它允许测试人员以HTML，Java，Ruby，RSpec，Python， C# ，JUnit和TestNG等多种语言导出录制的脚本。 可以在Selenium RC或Webdriver中使用这些导出的脚本。
> Selenium IDE的范围有限，生成的测试脚本不是非常健壮和可移植。
- Selenium远程控制器(Selenium RC 现已弃用)
- Selenium WebDriver
> Selenium WebDriver(Selenium 2)是Selenium RC的继承者，也是Selenium Suite最重要的组件。 SeleniumWebDriver提供了一个编程接口来创建和执行测试用例。 编写测试脚本是为了识别网页上的Web元素，然后对这些元素执行所需的操作。
> 与Selenium RC相比，Selenium WebDriver执行速度更快，因为它可以直接调用Web浏览器。 另一方面，RC需要RC服务器与Web浏览器进行交互。
> 因为，WebDriver直接调用不同浏览器的方法，因此每个浏览器都有单独的驱动程序。
- Selenium Grid
> Selenium Grid也是Selenium Suite的一个重要组件，它允许在不同的机器上并行运行不同浏览器的测试。 简单来说，可以在运行不同浏览器和操作系统的不同机器上同时运行测试。
> Selenium Grid遵循Hub-Node架构来实现测试脚本的并行执行。Hub被视为网络的主设备，另一个将是节点。 Hub控制在网络的各个节点上执行测试脚本。

## 获取镜像

## 启动容器

## 测试服务