## 项目业务架构
    craft-parent
     ###########业务层面###########
	 craft-module-employ 雇主模块
	 craft-module-worker 被雇佣者模块
	 craft-module-agent  代理人模块
	 craft-module-voice  手艺人之声论坛
	 craft-module-chat   闲谈（朋友圈）
	 craft-module-contract 契约
	 
	 ###########core#############
	 craft-module-common 公共模块
	 craft-module-core 数据库durid配置
	 
	 craft-module-yipay 易支付
	 craft-module-order 订单模块
	 craft-module-ad 广告模块
	 
	 ############view#############
	 craft-module-admin 后端管理-用户角色分配、角色管理、广告维护...
	 craft-module-web   前端管理  
	 
	 
	 
	 ###########架构层面###########
	 craft-enreka-server 注册中心服务（HA）
	 craft-config-server 配置中心服务
	 craft-zuul-server  网管路由服务
	 craft-zipkin-server 链路追踪服务
	 
     craft-cas-server  统一认证中心服务
     craft-mq-server 消息服务
     craft-search-server 搜索服务
	 craft-dfs-server  文件服务
	 craft-job-server  分布式任务服务
     
## 部署说明

     
## 项目技术架构
   springcloud 
       应用组件：
    springboot1.5.9
    mybatis3
    maven3+
    jdk8
    rabbitmq
    github
    mysql5.6+
## 业务模块功能
  3.1 craft-employ 雇主模块
      注册/登录认证
      我的需求
             未发布
             已接单
             已完结
     
      账号设置
      反馈
      帮助
     退出  
    个人中心
            我的论坛
            我的关系
            
            
Spring Cloud + Spring Boot + Mybatis + shiro + RestFul + 微服务 技术分享
##.   介绍

Commonservice-system是一个大型分布式、微服务、面向企业的JavaEE体系快速研发平台，基于模块化、服务化、原子化、热插拔的设计思想，使用成熟领先的无商业限制的主流开源技术构建。采用服务化的组件开发模式，可实现复杂的业务功能。提供驱动式开发模式，整合内置的代码生成器，将JavaEE开发效率提高5倍以上，减少50%的代码开发量，解决80%的重复工作，让开发者更关注业务逻辑。使用Maven进行项目的构建管理，采用Jenkins进行持续集成，主要定位于大型分布式企业系统或大型分布式互联网产品的架构。

##.   使用技术

SOA服务框架：SpringCloud 、SpringBoot、RestFul等

分布式缓存：Redis

模块化管理：Maven

数据库连接池：Alibaba Druid

核心框架：Spring framework、SpringBoot

持久层框架：MyBatis

安全框架：Apache Shiro

服务端验证：Hibernate Validator

任务调度：quartz

日志管理：SLF4J 1.7、Log4j

客户端验证：JQuery Validation

动态页签：easyuitab

前端框架：Bootstrap、Vue

##.   设计思想

分布式、微服务、云架构

JAVA语言开发、跨平台、高性能、高可用、安全、服务化、模块化、组件化、驱动式开发模式

##.   技术架构
##.   平台基础功能

 用户管理：用户是系统操作者，该功能主要完成系统用户配置。

 角色管理：角色菜单权限分配、设置角色按机构进行数据范围权限划分。

 权限管理：对系统中经常使用的一些较为固定的数据进行维护等。

 菜单管理：配置系统菜单，操作权限，按钮权限标识等。

 部门管理：配置系统组织机构，树结构展现，可随意调整上下级。

 日志管理：系统正常操作日志记录和查询；系统异常信息日志记录和查询。

 连接池监视：监视当期系统数据库连接池状态，可进行分析SQL找出系统性能瓶颈。

 完整项目的源码来源 技术支持1791743380

##.    源码结构