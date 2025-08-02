# DefaultApi

All URIs are relative to *https://api.buildin.ai*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**appendBlockChildren**](DefaultApi.md#appendBlockChildren) | **PATCH** /v1/blocks/{block_id}/children | 追加子块 |
| [**createDatabase**](DefaultApi.md#createDatabase) | **POST** /v1/databases | 创建数据库 |
| [**createPage**](DefaultApi.md#createPage) | **POST** /v1/pages | 创建页面 |
| [**deleteBlock**](DefaultApi.md#deleteBlock) | **DELETE** /v1/blocks/{block_id} | 删除块 |
| [**getBlock**](DefaultApi.md#getBlock) | **GET** /v1/blocks/{block_id} | 获取块 |
| [**getBlockChildren**](DefaultApi.md#getBlockChildren) | **GET** /v1/blocks/{block_id}/children | 获取子块 |
| [**getDatabase**](DefaultApi.md#getDatabase) | **GET** /v1/databases/{database_id} | 获取数据库 |
| [**getPage**](DefaultApi.md#getPage) | **GET** /v1/pages/{page_id} | 获取页面 |
| [**queryDatabase**](DefaultApi.md#queryDatabase) | **POST** /v1/databases/{database_id}/query | 查询数据库 |
| [**searchPages**](DefaultApi.md#searchPages) | **POST** /v1/pages/search | 搜索页面 |
| [**updateBlock**](DefaultApi.md#updateBlock) | **PATCH** /v1/blocks/{block_id} | 更新块 |
| [**updateDatabase**](DefaultApi.md#updateDatabase) | **PATCH** /v1/databases/{database_id} | 更新数据库 |
| [**updatePage**](DefaultApi.md#updatePage) | **PATCH** /v1/pages/{page_id} | 更新页面属性 |


<a id="appendBlockChildren"></a>
# **appendBlockChildren**
> AppendBlockChildrenResponse appendBlockChildren(blockId, appendBlockChildrenRequest)

追加子块

向指定块追加一个或多个子块

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.buildin.ai");
    
    // Configure HTTP bearer authorization: bearerAuth
    HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
    bearerAuth.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    UUID blockId = UUID.randomUUID(); // UUID | 父块ID
    AppendBlockChildrenRequest appendBlockChildrenRequest = new AppendBlockChildrenRequest(); // AppendBlockChildrenRequest | 
    try {
      AppendBlockChildrenResponse result = apiInstance.appendBlockChildren(blockId, appendBlockChildrenRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#appendBlockChildren");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **blockId** | **UUID**| 父块ID | |
| **appendBlockChildrenRequest** | [**AppendBlockChildrenRequest**](AppendBlockChildrenRequest.md)|  | |

### Return type

[**AppendBlockChildrenResponse**](AppendBlockChildrenResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 子块创建成功 |  -  |

<a id="createDatabase"></a>
# **createDatabase**
> Database createDatabase(createDatabaseRequest)

创建数据库

在现有页面下创建一个新的数据库

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.buildin.ai");
    
    // Configure HTTP bearer authorization: bearerAuth
    HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
    bearerAuth.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    CreateDatabaseRequest createDatabaseRequest = new CreateDatabaseRequest(); // CreateDatabaseRequest | 
    try {
      Database result = apiInstance.createDatabase(createDatabaseRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#createDatabase");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **createDatabaseRequest** | [**CreateDatabaseRequest**](CreateDatabaseRequest.md)|  | |

### Return type

[**Database**](Database.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 数据库创建成功 |  -  |
| **400** | 请求参数错误 |  -  |
| **401** | 未授权 |  -  |
| **403** | 权限不足 |  -  |

<a id="createPage"></a>
# **createPage**
> CreatePageResponse createPage(createPageRequest)

创建页面

在页面或数据库中创建新页面

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.buildin.ai");
    
    // Configure HTTP bearer authorization: bearerAuth
    HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
    bearerAuth.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    CreatePageRequest createPageRequest = new CreatePageRequest(); // CreatePageRequest | 
    try {
      CreatePageResponse result = apiInstance.createPage(createPageRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#createPage");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **createPageRequest** | [**CreatePageRequest**](CreatePageRequest.md)|  | |

### Return type

[**CreatePageResponse**](CreatePageResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 页面创建成功 |  -  |
| **400** | 请求参数错误 |  -  |
| **401** | 未授权 |  -  |
| **403** | 权限不足 |  -  |
| **500** | 内部服务器错误 |  -  |

<a id="deleteBlock"></a>
# **deleteBlock**
> DeleteBlockResponse deleteBlock(blockId)

删除块

删除指定块及其所有子块

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.buildin.ai");
    
    // Configure HTTP bearer authorization: bearerAuth
    HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
    bearerAuth.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    UUID blockId = UUID.randomUUID(); // UUID | 块ID
    try {
      DeleteBlockResponse result = apiInstance.deleteBlock(blockId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#deleteBlock");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **blockId** | **UUID**| 块ID | |

### Return type

[**DeleteBlockResponse**](DeleteBlockResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 块删除成功 |  -  |

<a id="getBlock"></a>
# **getBlock**
> Block getBlock(blockId)

获取块

根据ID获取块对象

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.buildin.ai");
    
    // Configure HTTP bearer authorization: bearerAuth
    HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
    bearerAuth.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    UUID blockId = UUID.randomUUID(); // UUID | 块ID
    try {
      Block result = apiInstance.getBlock(blockId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getBlock");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **blockId** | **UUID**| 块ID | |

### Return type

[**Block**](Block.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 成功获取块 |  -  |

<a id="getBlockChildren"></a>
# **getBlockChildren**
> GetBlockChildrenResponse getBlockChildren(blockId, startCursor, pageSize)

获取子块

获取指定块的子块列表

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.buildin.ai");
    
    // Configure HTTP bearer authorization: bearerAuth
    HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
    bearerAuth.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    UUID blockId = UUID.randomUUID(); // UUID | 父块ID
    String startCursor = "startCursor_example"; // String | 分页游标，使用子块的ID作为游标值
    Integer pageSize = 50; // Integer | 每页记录数
    try {
      GetBlockChildrenResponse result = apiInstance.getBlockChildren(blockId, startCursor, pageSize);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getBlockChildren");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **blockId** | **UUID**| 父块ID | |
| **startCursor** | **String**| 分页游标，使用子块的ID作为游标值 | [optional] |
| **pageSize** | **Integer**| 每页记录数 | [optional] [default to 50] |

### Return type

[**GetBlockChildrenResponse**](GetBlockChildrenResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 成功获取子块列表 |  -  |

<a id="getDatabase"></a>
# **getDatabase**
> Database getDatabase(databaseId)

获取数据库

根据ID获取数据库对象

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.buildin.ai");
    
    // Configure HTTP bearer authorization: bearerAuth
    HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
    bearerAuth.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    UUID databaseId = UUID.randomUUID(); // UUID | 数据库ID
    try {
      Database result = apiInstance.getDatabase(databaseId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getDatabase");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **databaseId** | **UUID**| 数据库ID | |

### Return type

[**Database**](Database.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 成功获取数据库 |  -  |
| **404** | 数据库不存在 |  -  |

<a id="getPage"></a>
# **getPage**
> Page getPage(pageId)

获取页面

根据ID获取页面对象

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.buildin.ai");
    
    // Configure HTTP bearer authorization: bearerAuth
    HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
    bearerAuth.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    UUID pageId = UUID.randomUUID(); // UUID | 页面ID
    try {
      Page result = apiInstance.getPage(pageId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getPage");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **pageId** | **UUID**| 页面ID | |

### Return type

[**Page**](Page.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 成功获取页面 |  -  |
| **404** | 页面不存在 |  -  |

<a id="queryDatabase"></a>
# **queryDatabase**
> QueryDatabaseResponse queryDatabase(databaseId, queryDatabaseRequest)

查询数据库

获取数据库中的页面列表，支持分页

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.buildin.ai");
    
    // Configure HTTP bearer authorization: bearerAuth
    HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
    bearerAuth.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    UUID databaseId = UUID.randomUUID(); // UUID | 数据库ID
    QueryDatabaseRequest queryDatabaseRequest = new QueryDatabaseRequest(); // QueryDatabaseRequest | 
    try {
      QueryDatabaseResponse result = apiInstance.queryDatabase(databaseId, queryDatabaseRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#queryDatabase");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **databaseId** | **UUID**| 数据库ID | |
| **queryDatabaseRequest** | [**QueryDatabaseRequest**](QueryDatabaseRequest.md)|  | [optional] |

### Return type

[**QueryDatabaseResponse**](QueryDatabaseResponse.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 查询成功 |  -  |

<a id="searchPages"></a>
# **searchPages**
> SearchResult searchPages(searchRequest)

搜索页面

通过向量搜索在空间中查找相关页面和内容

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.buildin.ai");
    
    // Configure HTTP bearer authorization: bearerAuth
    HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
    bearerAuth.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    SearchRequest searchRequest = new SearchRequest(); // SearchRequest | 
    try {
      SearchResult result = apiInstance.searchPages(searchRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#searchPages");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **searchRequest** | [**SearchRequest**](SearchRequest.md)|  | |

### Return type

[**SearchResult**](SearchResult.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 搜索成功 |  -  |
| **400** | 请求参数错误 |  -  |
| **401** | 未授权 |  -  |
| **403** | 权限不足 |  -  |
| **500** | 内部服务器错误 |  -  |

<a id="updateBlock"></a>
# **updateBlock**
> Block updateBlock(blockId, updateBlockRequest)

更新块

更新指定块的内容或属性

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.buildin.ai");
    
    // Configure HTTP bearer authorization: bearerAuth
    HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
    bearerAuth.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    UUID blockId = UUID.randomUUID(); // UUID | 块ID
    UpdateBlockRequest updateBlockRequest = new UpdateBlockRequest(); // UpdateBlockRequest | 
    try {
      Block result = apiInstance.updateBlock(blockId, updateBlockRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#updateBlock");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **blockId** | **UUID**| 块ID | |
| **updateBlockRequest** | [**UpdateBlockRequest**](UpdateBlockRequest.md)|  | |

### Return type

[**Block**](Block.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 块更新成功 |  -  |

<a id="updateDatabase"></a>
# **updateDatabase**
> Database updateDatabase(databaseId, updateDatabaseRequest)

更新数据库

更新数据库的属性

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.buildin.ai");
    
    // Configure HTTP bearer authorization: bearerAuth
    HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
    bearerAuth.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    UUID databaseId = UUID.randomUUID(); // UUID | 数据库ID
    UpdateDatabaseRequest updateDatabaseRequest = new UpdateDatabaseRequest(); // UpdateDatabaseRequest | 
    try {
      Database result = apiInstance.updateDatabase(databaseId, updateDatabaseRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#updateDatabase");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **databaseId** | **UUID**| 数据库ID | |
| **updateDatabaseRequest** | [**UpdateDatabaseRequest**](UpdateDatabaseRequest.md)|  | |

### Return type

[**Database**](Database.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 数据库更新成功 |  -  |

<a id="updatePage"></a>
# **updatePage**
> Page updatePage(pageId, updatePageRequest)

更新页面属性

更新页面的属性

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.buildin.ai");
    
    // Configure HTTP bearer authorization: bearerAuth
    HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
    bearerAuth.setBearerToken("BEARER TOKEN");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    UUID pageId = UUID.randomUUID(); // UUID | 页面ID
    UpdatePageRequest updatePageRequest = new UpdatePageRequest(); // UpdatePageRequest | 
    try {
      Page result = apiInstance.updatePage(pageId, updatePageRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#updatePage");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **pageId** | **UUID**| 页面ID | |
| **updatePageRequest** | [**UpdatePageRequest**](UpdatePageRequest.md)|  | |

### Return type

[**Page**](Page.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 页面更新成功 |  -  |

