## 项目业务架构
     craft-parent
     ###########业务层面###########
	 craft-employ 雇主模块
	 craft-worker 被雇佣者模块
	 craft-agent  代理人模块
	 craft-void   手艺人之声论坛
	 craft-chat   闲谈（朋友圈）
	 craft-contract 契约
	 craft-common 公共模块
	 ###########架构层面###########
	 craft-enreka-server 注册中心服务（HA）
	 craft-config-server 配置中心服务
	 craft-zuul-server  网管路由服务
	 craft-zipkin-server 链路追踪服务
     craft-cas-server  统一认证中心服务
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