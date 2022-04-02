# Halo-Lock
#### 基于注解的分布式锁，通过Aspectjweaver和Redisson(3.17.0)实现。

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