# plat-gateway-sofa-client
```
此工程包括两个部分：
第一针对网关发布的sofa服务进行验证；第二网关提供的SDK进行验证
```
# A部分：sofa服务验证示例
## 1. 引入相关jar
```
<!--sofa 客户端调用-->
<dependency>
  <groupId>com.alipay.sofa</groupId>
  <artifactId>sofa-rpc-all</artifactId>
  <version>5.6.0</version>
</dependency>
<!--引入api包，进行sofa调用-->
<dependency>
  <groupId>com.wish.techmidplat.gataway.inter</groupId>
  <artifactId>techmidplat-gataway-interface</artifactId>
  <version>${gatewayversion}</version>
</dependency>
```
## 2. 执行ClientTest类的main方法
```

```
# B部分：sdk相关验证
## 1. 功能描述
```
Get调用：入参做签名、返回值加解密
Post调用：入参做签名、入参加密、返回值加密
文件上传：入参做签名、返回值不加密
文件下载：入参做签名、返回值不加密
```
## 2. 引入相关jar
```
<!--引入sdk包，主要包括封装httpClient和加解密等-->
<dependency>
  <groupId>com.wish.techmidplat.gateway</groupId>
  <artifactId>techmidplat-gateway-sdk</artifactId>
  <version>${gatewayversion}</version>
</dependency>
```
## 3. 示例代码位置，执行main方法
```
Get调用：com.example.gateway.GatewayGet
Post调用：com.example.gateway.GatewayPost
文件上传：com.example.gateway.GatewayFileUpload
文件下载：com.example.gateway.GatewayFileDownload
```
