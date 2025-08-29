# Buildin API - 多语言 SDK 和演示项目

Buildin API 的多语言客户端 SDK，包含完整的演示项目。

## 🌐 支持的语言

- ✅ **Java** - 使用 Gson 序列化，支持 Java 8+（已生成）
- ✅ **TypeScript/JavaScript** - 基于 Fetch API（已生成）
- 🔄 **Python** - 原生 Python 客户端（可生成）
- 🔄 **Go** - 原生 Go 客户端（可生成）
- 🔄 **C#** - .NET 客户端（可生成）
- 🔄 **PHP** - PHP 客户端（可生成）

## 📁 项目结构

```
buildin-api-sdk/
├── openapi.json              # OpenAPI 规范
├── openapitools.json         # 生成器配置
├── .gitignore               # Git 忽略规则（包含安全防护）
├── README.md                # 本文件
├── java-demo/               # Java 演示项目
│   ├── src/main/java/cn/flowus/demo/
│   │   ├── SimpleBlockDemo.java          # 简单块操作演示
│   │   ├── BlockAddChildrenDemo.java     # 复杂块添加演示
│   │   ├── CreateDatabaseDemo.java       # 数据库创建演示
│   │   ├── CreateDatabaseRecordDemo.java # 数据库记录创建演示
│   │   └── DeleteBlockDemo.java          # 块删除演示
│   ├── pom.xml              # Maven 配置
│   ├── run-demo.sh          # 一键运行脚本
│   └── README.md            # Java 演示说明
├── typescript-demo/         # TypeScript 演示项目
│   ├── src/
│   │   ├── BlockAddChildrenDemo.ts       # 块添加演示
│   │   ├── CreateDatabaseDemo.ts         # 数据库创建演示
│   │   ├── CreateDatabaseRecordDemo.ts   # 数据库记录创建演示
│   │   ├── DeleteBlockDemo.ts            # 块删除演示
│   │   ├── PageSearchDemo.ts             # 页面搜索演示
│   │   ├── UpdateDatabaseRecordDemo.ts   # 数据库记录更新演示
│   │   ├── config/apiConfig.ts           # API 配置
│   │   └── utils/flowusClient.ts         # 客户端工具类
│   ├── package.json         # NPM 配置
│   ├── .env.example         # 环境变量模板
│   └── README.md            # TypeScript 演示说明
└── sdk/                     # 生成的 SDK
    ├── java/                # Java SDK
    │   ├── src/main/java/   # Java SDK 源码
    │   ├── docs/            # API 文档
    │   ├── pom.xml          # Maven 配置
    │   └── README.md        # Java SDK 说明
    └── typescript/          # TypeScript SDK
        ├── apis/            # API 接口
        ├── models/          # 数据模型
        ├── package.json     # NPM 配置
        └── README.md        # TypeScript SDK 说明
```

## 🚀 快速开始

### 环境要求

#### Java 开发
- Java 8 或更高版本
- Maven 3.6 或更高版本
- Buildin API Token

#### TypeScript 开发
- Node.js 16 或更高版本
- npm 或 yarn
- Buildin API Token

### 获取 Buildin API Token

1. 登录 Buildin
2. 进入设置 → 集成
3. 创建新的机器人集成
4. 复制生成的 API Token

## 📋 演示项目

### Java 演示项目

位置：`java-demo/`

包含以下演示：
- **SimpleBlockDemo** - 基础块操作
- **BlockAddChildrenDemo** - 复杂块结构创建
- **CreateDatabaseDemo** - 数据库创建
- **CreateDatabaseRecordDemo** - 数据库记录操作
- **DeleteBlockDemo** - 块删除操作

#### 运行 Java 演示

```bash
cd java-demo

# 方法1：使用一键脚本（推荐）
chmod +x run-demo.sh
./run-demo.sh

# 方法2：手动运行
mvn clean compile
java -cp "target/classes:../sdk/java/target/lib/*:../sdk/java/target/flowus-api-client-1.0.0.jar" cn.flowus.demo.SimpleBlockDemo
```

### TypeScript SDK


位置：`typescript-demo/`

包含以下演示：
- **BlockAddChildrenDemo** - 块添加操作
- **CreateDatabaseDemo** - 数据库创建
- **CreateDatabaseRecordDemo** - 数据库记录创建
- **DeleteBlockDemo** - 块删除操作
- **PageSearchDemo** - 页面搜索
- **UpdateDatabaseRecordDemo** - 数据库记录更新

#### 运行 TypeScript 演示

```bash
cd typescript-demo

# 安装依赖
npm install

# 配置环境变量
cp .env.example .env
# 编辑 .env 文件，填入您的 API Token

# 运行演示
npm run demo:create-database
npm run demo:create-record
npm run demo:search
npm run demo:update-record
npm run demo:delete-block
npm run demo:add-children
```

## 🔧 SDK 使用

### Java SDK

```java
import org.openapitools.client.ApiClient;
import org.openapitools.client.Configuration;
import org.openapitools.client.api.DefaultApi;
import org.openapitools.client.auth.HttpBearerAuth;

// 初始化客户端
ApiClient defaultClient = Configuration.getDefaultApiClient();
defaultClient.setBasePath("https://api.buildin.ai");

// 配置认证
HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
bearerAuth.setBearerToken("你的API令牌");

// 创建API实例
DefaultApi apiInstance = new DefaultApi(defaultClient);

// 使用API
// ... 具体API调用
```

### TypeScript SDK

```typescript
import { Configuration, DefaultApi } from 'buildin-api-sdk';

// 初始化配置
const config = new Configuration({
  basePath: 'https://api.buildin.ai',
  accessToken: '你的API令牌'
});

// 创建API实例
const api = new DefaultApi(config);

// 使用API
// ... 具体API调用
```


### 使用 OpenAPI Generator

```bash
# 生成 Java SDK
openapi-generator-cli generate \
  -i openapi.json \
  -g java \
  -o sdk/java \
  --additional-properties=disallowAdditionalPropertiesIfNotPresent=false,serializationLibrary=gson,dateLibrary=java8

# 生成 TypeScript SDK
openapi-generator-cli generate \
  -i openapi.json \
  -g typescript-fetch \
  -o sdk/typescript \
  --additional-properties=disallowAdditionalPropertiesIfNotPresent=false,npmName=flowus-api-client

# 生成 Python SDK
openapi-generator-cli generate \
  -i openapi.json \
  -g python \
  -o sdk/python \
  --additional-properties=disallowAdditionalPropertiesIfNotPresent=false,packageName=flowus_api_client

# 生成其他语言 SDK
openapi-generator-cli generate -i openapi.json -g go -o sdk/go
openapi-generator-cli generate -i openapi.json -g csharp -o sdk/csharp
openapi-generator-cli generate -i openapi.json -g php -o sdk/php
```

### 关键配置说明

- **`disallowAdditionalPropertiesIfNotPresent=false`** - 允许额外属性，提高API兼容性
- **Java**: 使用 Gson 序列化和 Java 8 日期库
- **TypeScript**: 基于 Fetch API，包含完整类型定义

## 📚 API 功能

### 页面管理
- 创建页面
- 更新页面属性
- 搜索页面

### 数据库操作
- 创建数据库
- 更新数据库结构
- 查询数据库记录
- 创建和更新记录

### 块操作
- 获取子块
- 添加子块
- 更新块内容
- 删除块

### 支持的块类型
- 段落 (paragraph)
- 标题 (heading_1, heading_2, heading_3)
- 列表 (bulleted_list_item, numbered_list_item)
- 待办事项 (to_do)
- 引用 (callout)
- 分割线 (divider)
- 表格 (table)

## 🔒 安全注意事项

1. **API Token 安全**
   - 永远不要在代码中硬编码 API Token
   - 使用环境变量或配置文件
   - 不要将包含真实 Token 的文件提交到版本控制

2. **敏感文件防护**
   - 项目已配置完善的 `.gitignore` 规则
   - 自动忽略 Maven/NPM 发布凭据
   - 排除 GPG 密钥和发布配置

3. **最佳实践**
   - 定期轮换 API Token
   - 限制 Token 权限范围
   - 监控 API 使用情况

## 🛠️ 故障排除

### 常见问题

#### 1. API 调用失败
- **401 Unauthorized**: 检查 API Token 是否正确
- **403 Forbidden**: 检查权限配置
- **404 Not Found**: 确认资源 ID 正确
- **400 Bad Request**: 检查请求参数格式

#### 2. 编译/构建错误
- **Java**: 确保 Maven 版本兼容，SDK 已正确构建
- **TypeScript**: 确保 Node.js 版本兼容，依赖已安装

#### 3. 网络问题
- 检查网络连接
- 确认 API 端点可访问
- 检查防火墙设置

### 获取帮助

如果遇到问题，请检查：
1. [Java 演示项目文档](./java-demo/README.md)
2. [TypeScript 演示项目文档](./typescript-demo/README.md)
3. [Java SDK 文档](./sdk/java/README.md)
4. [TypeScript SDK 文档](./sdk/typescript/README.md)

## 📄 许可证

本项目仅用于演示目的，请遵循 Buildin 的服务条款。

## 🤝 贡献

欢迎提交 Issue 和 Pull Request 来改进项目。

## 📞 联系

- Buildin 官方网站：https://buildin.ai
- API 文档：https://buildin.ai/share/480fea3b-bf25-478c-8c33-111c002defdc
- 技术支持：请通过 Buildin 官方渠道联系
