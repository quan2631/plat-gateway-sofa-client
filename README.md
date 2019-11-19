# plat-gateway-sofa-client
```
此工程包括两个部分：
第一对网关发布的sofa服务进行验证，第二对网关提供的sdk进行验证。注：测试代码都在com.example.gateway目录下
```
# A部分：sofa服务验证示例
## 1. 引入相关jar
```
<!--引入sdk包，主要包括封装httpClient、加解密和sofa服务获取-->
<dependency>
  <groupId>com.wish.techmidplat.gateway</groupId>
  <artifactId>techmidplat-gateway-sdk</artifactId>
  <version>${gatewayversion}</version>
</dependency>
```
## 2. main方法调用示例
```
public class SofaServiceTest {
    public static void main(String[] args) {
        ISofa gatewaySofaService = SofaUtil.getGatewaySofaService("127.0.0.1:12300");
        Object o = gatewaySofaService.action("1","2","3");
        System.out.println(o); // you input cityCode is 1

        Map<String, Object>  paramsMap = new HashMap<>();
        paramsMap.put("1", "111");
        Object o1 = gatewaySofaService.action1("1","2",paramsMap);
        System.out.println(o1); // {1=111, key=this is you input map.}
    }
}
```
## 3. 作为web工程的调用示例
```
@RestController
public class SofaServiceController {

    ISofa gatewaySofaService = SofaUtil.getGatewaySofaService("127.0.0.1:12300");

    @RequestMapping("/action")
    private  String action(){
        Object o = gatewaySofaService.action("1","2","3");
        System.out.println(o); // you input cityCode is 1
        return  o.toString();
    }

    @RequestMapping("/action1")
    private  String action1(){
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("1", "111");
        Object o = gatewaySofaService.action1("1","2",paramsMap);
        System.out.println(o); // {1=111, key=this is you input map.}
        return  o.toString();
    }
}
```
## 4. plat-gateway工程发布的sofa服务
```
@Slf4j
@Service
public class GatewaySofaService implements ISofa {

    @Override
    public String action(String cityCode, String eventCode, String body) {
        System.out.println("you input cityCode is " + cityCode);
        return "you input cityCode is " + cityCode;
    }

    @Override
    public Map<String, Object> action1(String cityCode, String eventCode, Map<String, Object> paramsMap) {
        System.out.println("you input eventCode is " + eventCode);
        paramsMap.put("key", "this is you input map.");
        return paramsMap;
    }
}
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
<!--引入sdk包，主要包括封装httpClient、加解密和sofa服务获取-->
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
