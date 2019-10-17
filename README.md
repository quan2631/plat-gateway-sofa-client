# plat-gateway-sofa-client
```
此工程针对网关发布的sofa服务进行验证
```
# 1. 引入相关jar
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
# 2. 执行ClientTest类的main方法
```
/**
 * 1、生成代理类
 */
ConsumerConfig<ISofa> consumerConfig = new ConsumerConfig<ISofa>()
        .setInterfaceId(ISofa.class.getName()) // 指定接口
        .setProtocol("bolt") // 指定协议
        .setDirectUrl("bolt://127.0.0.1:12300"); // 指定直连地址
ISofa gatewaySofaService = consumerConfig.refer();
/**
 * 2、构造登录需要的参数
 */
String cityCode = "04320"; //城市码
String chnnelCode = "07"; //渠道码
String tranCode = "B70001"; // 交易码/事件码，对应为登录的事件码
String body = "{\n" +
        "\"data\":{\n" +
        " \"common\": {\n" +
        "  \"retimestamp\": 1567593358964,\n" +
        "  \"channelseq\": \"\",\n" +
        "  \"eventCode\": \"B70001\",\n" +
        "  \"businessCode\": \"B70001\"\n" +
        " },\n" +
        " \"plat\": {\n" +
        "  \"login\": {\n" +
        "   \"loginId\": \"001\",\n" +
        "   \"password\": \"HX01123\",\n" +
        "   \"loginType\": 0\n" +
        "  }\n" +
        " }\n" +
        " }\n" +
        "}"; //表单体
String[] params = new String[]{"gateway","04320","07","B70001",
        "arrange", "newBusiness", "1233333"};
/**
 * 3、发起主调用并打印
 */
System.out.println(gatewaySofaService.action(cityCode,chnnelCode,tranCode,body,params));
```
