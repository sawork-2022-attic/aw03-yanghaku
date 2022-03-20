# My understanding

分层使问题变的更简单, 解决方案变的更灵活
对于MVC架构, 控制器使视图与模型分离, 让问题的每一部分都针对性的解决, 并且在变更视图/业务需求/数据源的时候, 能用最小的代码改动实现.

在这个Spring-MVC架构里, 分成了以下几层:
1. View: 由html + thymeleaf 实现了界面的展示, 并且与控制层交互, 获取必要的展示信息
2. Controller 控制层, 返回视图, 同时与应用逻辑层交互, 处理购物车的添加,计算总和等逻辑业务
3. Service 业务层, 接收控制层的调用, 处理必要的业务, 并且与数据层交互, 把数据持久化存储
4. Dao 数据层, 这里是用的mysql数据库, 主要是要设计好给业务层调用的接口, 以便更换数据源的时候, 有最小的代码改动.

# 访问网址:  <a href="http://8.136.0.10:121/webpos/" target="_blank"> http://8.136.0.10:121/webpos/ </a>


# WebPOS

The demo shows a simple POS system in MVC architecture, which replaces the shell interface in aw02 with a pos web ui (https://github.com/bshbsh404/simple-pos-ui
).

![](screenshot.png)

To run

```shell
mvn clean spring-boot:run
```

Currently, it just lists the products for sale with a cart with one item (just for demonstration). 

Please read the tutorial at  https://www.baeldung.com/spring-boot-crud-thymeleaf and make the POS system robust and fully functional. You can also refer to other articles, for instance https://www.baeldung.com/tag/thymeleaf/ .



And please elaborate your understanding in MVC architecture via this homework in your README.md.

