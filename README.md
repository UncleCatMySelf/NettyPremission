# NettyPermission

## 简介
基于SpringBoot-WebSocket通用框架,运用Netty为主进行权限消息分发的组件，两种权限机制（Circle圈子模式，同等级的一个社交圈、Grade等级模式，每一个等级可以消费到比自己低等级的消息），以聊天社交为Demo进行测试

## 特点
Netty权限消息分发，等级机制（金字塔），圈子模式（同级消费），实时消息通信，WebSocket

## 功能

    实时聊天
    金字塔等级聊天模式
    圈子同级聊天模式
    金字塔消费分发
    圈子同级消费分发

## 相关项目

你可能还想了解的项目：

* ssmnetty： https://github.com/UncleCatMySelf/ssmnetty

基于SSM与Netty结合实现软硬件通信（TCP）、API向指定链接发送消息

* SBToNettyChat： https://github.com/UncleCatMySelf/SBToNettyChat

基于SpringBoot-WebSocket通用框架,结合Netty进行聊天社交，并记录聊天日志，异步数据库存储，记录聊天历史等

* NettyPremission： https://github.com/UncleCatMySelf/NettyPremission

运用Netty为主进行权限消息分发的组件，两种权限机制（Circle圈子模式，同等级的一个社交圈、Grade等级模式，每一个等级可以消费到比自己低等级的消息）

## 项目思路

本次我选择SpringBoot2.0.2还有Netty4.1.28这两个版本来结合使用。

圈子模式：同一等级的消息之后发送（群发）给对应的等级，类似低等级-低等级、中等级-中等级、高等级-高等级

金字塔模式：消息可以发送给自己同级与所有比自己低等级的消费，即高等级的消息会发给高、中、低看到，但是低等级的只有低等级的才看到


## 配置

    com.myself.nettypermiss.TextWebSocketFrameHandler 
    自选切换模式 

## 效果图

![Image text](https://raw.githubusercontent.com/UncleCatMySelf/img-myself/master/img/nettychat/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20180815130110.png)
![Image text](https://raw.githubusercontent.com/UncleCatMySelf/img-myself/master/img/nettychat/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20180815130127.png)

## 下载地址

下载地址：https://github.com/UncleCatMySelf/NettyPremission/releases

## 交流与提问

提问与Bug上报：https://github.com/UncleCatMySelf/NettyPremission/issues

QQ群：628793702（仅供交流，不提供问题解答）

## 关于作者

博客园：https://www.cnblogs.com/UncleCatMySelf/

个人公众号：UncleCatMySelf

![Image text](https://raw.githubusercontent.com/UncleCatMySelf/img-myself/master/img/%E5%85%AC%E4%BC%97%E5%8F%B7.png)

个人开发，感谢支持！

![Image text](https://raw.githubusercontent.com/UncleCatMySelf/img-myself/master/img/%E4%BB%98%E6%AC%BE.png)
