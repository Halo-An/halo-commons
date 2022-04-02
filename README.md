# Halo-Commons Halo公共组件库

## 版本说明

* Java：11.0.14
* SpringBoot: 2.6.5
* Maven: 3.8.1

## 打包说明

* #### 打包至本地maven仓库：

```mvn clean install -s /Users/halo/local/apache-maven-3.8.1/conf/settings.xml -Dmaven.test.skip=true```

* #### 打包至远程maven仓库：

```mvn clean deploy -s /Users/halo/local/apache-maven-3.8.1/conf/settings.xml -Dmaven.test.skip=true```

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

* #### halo-lock - 基于注解的分布式锁 [详情](halo-lock/README.md)



