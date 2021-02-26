# spring-security-auth-example


## 项目目标

    这个项目是spring boot集成spring security的工程示例，
为了学习security在前后端分离模式下的用户认证授权问题，利用jwt进行鉴权

## 项目环境搭建
    将sql文件导入到数据库中，并且自己创建几条用户和角色，这里建议角色添加USER和ADMIN

## 如何使用

登陆成功后，将服务器返回给的token,加入到Header中的Authorization中，即可完成鉴权

访问userController的需要User用户，访问AdminController下的需要ADMIN用户

## 开放测试接口

登录接口：/loginUsr 

开放接口： /AuthTest

用户接口： /user/**

管理员接口: /admin/**




