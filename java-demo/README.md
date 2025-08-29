# Buildin API Java Demo

这个项目演示了如何使用Buildin API的Java SDK进行各种操作。

## 项目结构

```
java-demo/
├── src/main/java/ai/buildin/demo/
│   ├── config/
│   │   └── ApiConfig.java           # API配置管理类
│   ├── BlockAddChildrenDemo.java    # 块操作演示
│   ├── SimpleBlockDemo.java         # 简化的块操作演示
│   ├── CreateDatabaseDemo.java      # 创建数据库演示
│   ├── CreateDatabaseRecordDemo.java # 创建数据库记录演示
│   ├── DeleteBlockDemo.java         # 删除块演示
│   ├── GetUserMeDemo.java           # 获取机器人创建者信息演示
│   └── SearchDemo.java              # 搜索页面演示
├── .env.example                     # 环境变量配置示例
├── .gitignore                       # Git忽略文件配置
├── pom.xml                          # Maven项目配置
└── README.md                        # 项目说明
```

## 功能演示

### BlockAddChildrenDemo.java
完整的页面创建和块操作演示，包括：
- 创建新页面
- 添加各种类型的块（标题、段落、待办事项、标注、分割线等）
- 设置富文本格式和颜色
- 创建复杂的页面结构

### CreateDatabaseDemo.java
数据库创建演示，包括：
- 创建数据库
- 配置各种属性类型（文本、数字、选择、多选、日期等）
- 设置数据库图标和标题

### CreateDatabaseRecordDemo.java
数据库记录创建演示，包括：
- 在数据库中创建记录
- 设置各种属性值
- 处理关联、人员、文件等复杂属性类型

### SimpleBlockDemo.java
简化的块操作演示，专注于：
- 向指定块添加段落子块
- 设置富文本格式和颜色

### DeleteBlockDemo.java
块删除操作演示：
- 删除指定的块

### GetUserMeDemo.java
获取机器人创建者信息演示，包括：
- 调用 /v1/users/me 接口
- 获取机器人创建者的用户信息
- 显示用户ID、名称、邮箱、头像等详细信息
- 错误处理和提示

### SearchDemo.java
搜索页面演示，包括：
- 调用 /v1/search 接口进行页面搜索
- 支持关键词搜索和列出所有授权页面
- 分页查询和结果展示
- 交互式搜索功能
- 详细的搜索结果显示（页面信息、标题、父级等）

## 环境要求

- Java 8 或更高版本
- Maven 3.6 或更高版本
- Buildin API Token

## 快速开始

### 1. 构建Buildin SDK

首先需要构建Buildin API SDK：

```bash
cd ../sdk/java
mvn clean install -DskipTests
```

### 2. 配置环境变量

**方式一：使用.env文件（推荐）**

```bash
# 复制配置文件模板
cp .env.example .env

# 编辑.env文件，填入您的实际配置
# 至少需要设置BUILDIN_API_BEARER_TOKEN
```

`.env` 文件内容示例：
```bash
BUILDIN_API_BASE_PATH=https://api.buildin.ai
BUILDIN_API_BEARER_TOKEN=your-actual-api-token-here
```

**方式二：使用系统环境变量**

```bash
export BUILDIN_API_BASE_PATH=https://api.buildin.ai
export BUILDIN_API_BEARER_TOKEN=your-actual-api-token-here
```

### 3. 配置特定ID（可选）

根据您的实际情况，在代码中替换演示用的ID：
- 数据库ID（CreateDatabaseRecordDemo.java）
- 块ID（SimpleBlockDemo.java, DeleteBlockDemo.java）

### 4. 编译和运行

```bash
# 编译项目
mvn clean compile

# 运行各种演示程序
mvn exec:java -Dexec.mainClass="ai.buildin.demo.SimpleBlockDemo"           # 简化块操作演示
mvn exec:java -Dexec.mainClass="ai.buildin.demo.BlockAddChildrenDemo"      # 完整页面和块操作演示
mvn exec:java -Dexec.mainClass="ai.buildin.demo.CreateDatabaseDemo"        # 创建数据库演示
mvn exec:java -Dexec.mainClass="ai.buildin.demo.CreateDatabaseRecordDemo"  # 创建数据库记录演示
mvn exec:java -Dexec.mainClass="ai.buildin.demo.DeleteBlockDemo"           # 删除块演示
mvn exec:java -Dexec.mainClass="ai.buildin.demo.GetUserMeDemo"             # 获取机器人创建者信息演示
mvn exec:java -Dexec.mainClass="ai.buildin.demo.SearchDemo"                # 搜索页面演示

# 或者构建可执行JAR后运行
mvn clean package
java -jar target/buildin-api-demo-1.0.0-shaded.jar
```

## API 使用示例

### 创建段落块

```java
// 创建段落块
AppendBlockChildrenRequestChildrenInner child = new AppendBlockChildrenRequestChildrenInner();
child.setType(AppendBlockChildrenRequestChildrenInner.TypeEnum.PARAGRAPH);

// 创建块数据
BlockData blockData = new BlockData();

// 创建富文本内容
List<RichTextItem> richTextItems = new ArrayList<>();
RichTextItem richTextItem = new RichTextItem();
richTextItem.setType(RichTextItem.TypeEnum.TEXT);

// 设置文本内容
RichTextItemText textContent = new RichTextItemText();
textContent.setContent("这是一个新添加的段落块");
richTextItem.setText(textContent);

// 设置文本格式
RichTextItemAnnotations annotations = new RichTextItemAnnotations();
annotations.setBold(true);
annotations.setColor(RichTextItemAnnotations.ColorEnum.BLUE);
richTextItem.setAnnotations(annotations);

richTextItems.add(richTextItem);
blockData.setRichText(richTextItems);
child.setData(blockData);
```

### 使用配置管理

```java
// 获取API配置（自动从.env文件或环境变量加载）
ApiConfig apiConfig = ApiConfig.getInstance();
apiConfig.validateAndPrint();

// 初始化API客户端
ApiClient defaultClient = Configuration.getDefaultApiClient();
defaultClient.setBasePath(apiConfig.getBasePath());

// 配置认证
HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
bearerAuth.setBearerToken(apiConfig.getBearerToken());

DefaultApi apiInstance = new DefaultApi(defaultClient);

// 调用API
AppendBlockChildrenResponse result = apiInstance.appendBlockChildren(blockId, request);
```

## 配置说明

### 配置优先级
配置加载的优先级如下（从高到低）：
1. 系统环境变量
2. .env文件
3. 默认值

### 配置项说明
- `BUILDIN_API_BASE_PATH`: API基础路径，默认为 `https://api.buildin.ai`
- `BUILDIN_API_BEARER_TOKEN`: Bearer Token（必须配置）

### 配置验证
程序启动时会自动验证配置是否正确：
- ✅ 配置验证通过
- ❌ 配置验证失败，会提示错误信息

## 常见问题

### 1. 编译错误

如果遇到编译错误，请确保：
- 已正确构建Buildin SDK
- Maven版本兼容
- Java版本为8或更高

### 2. 配置问题

如果遇到配置相关错误：
- 确保已创建.env文件并正确填写BUILDIN_API_BEARER_TOKEN
- 检查环境变量是否正确设置
- 确认Token格式正确且未过期

### 3. 运行时错误

如果遇到运行时错误，请检查：
- Token是否正确配置
- ID是否为有效的UUID格式
- 网络连接是否正常
- API基础路径是否正确

### 4. API调用失败

常见的API调用失败原因：
- Token无效或过期
- 权限不足
- 请求参数错误
- 目标资源不存在

## 许可证

本项目仅用于演示目的，请遵循Buildin的服务条款。 