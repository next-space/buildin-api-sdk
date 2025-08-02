# FlowUs Java SDK 快速开始

## 安装

### Maven

在你的 `pom.xml` 中添加依赖：

```xml
<dependency>
    <groupId>cn.flowus</groupId>
    <artifactId>flowus-api-client</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Gradle

在你的 `build.gradle` 中添加依赖：

```groovy
implementation 'cn.flowus:flowus-api-client:1.0.0'
```

## 基本用法

### 1. 初始化客户端

```java
import org.openapitools.client.ApiClient;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.HttpBearerAuth;
import org.openapitools.client.api.DefaultApi;

public class FlowUsExample {
    public static void main(String[] args) {
        // 配置 API 客户端
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.flowus.cn");
        
        // 设置认证令牌
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("你的API令牌");

        // 创建 API 实例
        DefaultApi apiInstance = new DefaultApi(defaultClient);
    }
}
```

### 2. 创建数据库

```java
import org.openapitools.client.model.*;
import java.util.*;

// 创建数据库请求
CreateDatabaseRequest request = new CreateDatabaseRequest();
request.setTitle("我的新数据库");

// 添加属性
Map<String, PropertySchema> properties = new HashMap<>();

// 添加标题属性
PropertySchema titleProperty = new PropertySchemaTitle();
titleProperty.setType("title");
properties.put("标题", titleProperty);

// 添加文本属性
PropertySchema textProperty = new PropertySchemaRichText();
textProperty.setType("rich_text");
properties.put("描述", textProperty);

request.setProperties(properties);

try {
    Database result = apiInstance.createDatabase(request);
    System.out.println("创建的数据库ID: " + result.getId());
} catch (ApiException e) {
    System.err.println("创建数据库失败: " + e.getResponseBody());
}
```

### 3. 创建页面

```java
import java.util.UUID;

// 创建页面请求
CreatePageRequest pageRequest = new CreatePageRequest();

// 设置父页面或数据库
ParentDatabaseId parent = new ParentDatabaseId();
parent.setDatabaseId(UUID.fromString("数据库ID"));
pageRequest.setParent(parent);

// 设置页面属性
Map<String, CreatePagePropertyValue> properties = new HashMap<>();

// 设置标题
CreatePagePropertyValueTitle title = new CreatePagePropertyValueTitle();
title.setType("title");
// ... 设置标题内容
properties.put("标题", title);

pageRequest.setProperties(properties);

try {
    CreatePageResponse result = apiInstance.createPage(pageRequest);
    System.out.println("创建的页面ID: " + result.getId());
} catch (ApiException e) {
    System.err.println("创建页面失败: " + e.getResponseBody());
}
```

### 4. 查询数据库

```java
// 查询数据库
QueryDatabaseRequest queryRequest = new QueryDatabaseRequest();
// 可以添加过滤器、排序等

try {
    QueryDatabaseResponse result = apiInstance.queryDatabase(
        UUID.fromString("数据库ID"), 
        queryRequest
    );
    
    System.out.println("查询结果数量: " + result.getResults().size());
    for (Page page : result.getResults()) {
        System.out.println("页面ID: " + page.getId());
    }
} catch (ApiException e) {
    System.err.println("查询数据库失败: " + e.getResponseBody());
}
```

## 错误处理

```java
try {
    // API 调用
} catch (ApiException e) {
    System.err.println("API错误:");
    System.err.println("状态码: " + e.getCode());
    System.err.println("错误信息: " + e.getResponseBody());
    System.err.println("响应头: " + e.getResponseHeaders());
}
```

## 更多示例

查看 [java-demo](../../java-demo/) 目录获取更多完整示例：

- [CreateDatabaseDemo.java](../../java-demo/src/main/java/cn/flowus/demo/CreateDatabaseDemo.java) - 创建数据库示例
- [CreateDatabaseRecordDemo.java](../../java-demo/src/main/java/cn/flowus/demo/CreateDatabaseRecordDemo.java) - 创建数据库记录示例
- [BlockAddChildrenDemo.java](../../java-demo/src/main/java/cn/flowus/demo/BlockAddChildrenDemo.java) - 添加子块示例

## API 文档

完整的 API 文档请参考 [docs](docs/) 目录。
