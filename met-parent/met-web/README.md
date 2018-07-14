## 待办项目

### 快速运行
 1. 由svn导入工程项目
    <p>https://192.168.0.50/svn/BigDataDev/02DevelopmentArea/04 编码实现/met-parent<p>
 
 2. 配置数据库
    <p>连接mysql数据库执行hello-test.sql 文件（db/hello-test.sql）<br>
                     修改classpath:application.yml 数据库datasource配置项
    </p>
 3. 运行项目
    <p>
    com.example.demo.app.DemoApplication.java 'run as'->'Java Application' 
    <br>http://localhost:8080/show/UserManager.html
    </p>
    
### 项目架构模块 
   - met-parent
   - met-web
   - met-common
   - met-module-core
   
### 应用技术
  -  应用框架：springboot1.5.9
  -  数据源：druid1.1.9  
  -  持久程：mybatis 3.x
  -  数据库：mysql5.6
  -  分页插件 pagehelp 5.0.1
  -  项目对象模型POM:maven3.3.9
  -  定时组件：quartz2.2.3
  -  js页面:bootstrap AdminELT-2.3.5
  -  日志：logback1.1.11

   
   