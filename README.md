# Halo-Commons Halo公共组件库

## 版本说明

* Java：11.0.14
* SpringBoot: 2.6.5
* Maven: 3.8.1

## 打包说明

* #### 打包至本地maven仓库：

```mvn clean install -s /Users/leiming/local/apache-maven-3.8.1/conf/settings.xml -Dmaven.test.skip=true```

* #### 打包至远程maven仓库：

```mvn clean deploy -s /Users/leiming/local/apache-maven-3.8.1/conf/settings.xml -Dmaven.test.skip=true```

## 引用说明

各个子模块相互独立，可以直接单独引用。

* #### halo-lock

```xml

<dependency>
    <groupId>com.halo</groupId>
    <artifactId>halo-lock</artifactId>
    <version>1.0.0-RELEASE</version>
</dependency>
```

## 模块说明

* #### halo-lock

基于注解的分布式锁，通过Aspectjweaver和Redisson（3.17.0）实现。

引入对应依赖后，需确保配置文件中Redis的相关配置正确，否则项目启动时Redisson无法完成初始化。

```yaml
spring:
  redis:
    host: 127.0.0.1
    port: 6379
    database: 0
    password: 123456
```  

在需要加分布式锁的业务方法上加上```@Lock(spels = {"#id"})```注解即可，spels表示需要加锁的key，以数组形式传入，waitTime表示等待加锁的超时时间，单位为秒，默认为10秒，超时后加锁失败，会抛出异常。

```java
    /**
     * 下单扣减库存
     *
     * @param sku      商品编码
     * @param quantity 购买数量
     */
    @Lock(spels = {"#sku"}, waiteTime = 5)
    @Override
    public void deductInventory(String sku, int quantity) {
        System.out.println("deductInventory: " + sku + " " + quantity);
    }
```

SpEL也支持从pojo对象中获取某个成员变量。
```java
    /**
     * 下单扣减库存
     *
     * @param request pojo
     */
    @Lock(spels = {"#request.getSku()"}, waiteTime = 5)
    @Override
    public void deductInventory(DeductInventoryRequest request) {
        System.out.println("deductInventory: " + request.getSku() + " " + request.getQuantity());
    }
```

