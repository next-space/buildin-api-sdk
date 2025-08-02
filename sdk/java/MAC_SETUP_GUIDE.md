# Mac 系统发布设置指南

在完成 `cn.flowus` 命名空间验证后，按照以下步骤在 Mac 上完成发布设置。

## 🔐 第一步：生成和配置 GPG 密钥

### 1.1 安装 GPG

```bash
# 使用 Homebrew 安装 GPG
brew install gnupg

# 验证安装
gpg --version
```

### 1.2 生成 GPG 密钥

```bash
# 生成新密钥
gpg --full-generate-key
```

选择以下配置：
- 密钥类型：选择 `(1) RSA and RSA` 
- 密钥长度：输入 `4096`
- 有效期：输入 `0` (永不过期) 或 `1y` (1年)
- 确认：输入 `y`
- 姓名：输入你的姓名（如：FlowUs Team）
- 邮箱：输入你的邮箱（如：dev@flowus.cn）
- 注释：可留空或输入描述
- 密码：设置一个强密码并记住

### 1.3 查看和导出密钥

```bash
# 列出密钥
gpg --list-secret-keys --keyid-format LONG

# 输出示例：
# sec   rsa4096/ABC123DEF456 2024-01-01 [SC]
# uid                 [ultimate] FlowUs Team <dev@flowus.cn>
# ssb   rsa4096/XYZ789 2024-01-01 [E]

# 记下密钥ID (例如: ABC123DEF456)
export GPG_KEY_ID="ABC123DEF456"  # 替换为你的实际密钥ID
```

### 1.4 上传公钥到密钥服务器

```bash
# 上传到 Ubuntu 密钥服务器
gpg --keyserver keyserver.ubuntu.com --send-keys $GPG_KEY_ID

# 上传到 OpenPGP 密钥服务器
gpg --keyserver keys.openpgp.org --send-keys $GPG_KEY_ID

# 验证上传成功
gpg --keyserver keyserver.ubuntu.com --recv-keys $GPG_KEY_ID
```

## 📁 第二步：配置 Maven 设置

### 2.1 创建 Maven 设置目录

```bash
# 创建 .m2 目录（如果不存在）
mkdir -p ~/.m2
```

### 2.2 配置 settings.xml

创建或编辑 Maven 配置文件：

```bash
# 使用你喜欢的编辑器打开
nano ~/.m2/settings.xml
# 或者
vim ~/.m2/settings.xml
# 或者
code ~/.m2/settings.xml
```

添加以下内容：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
          http://maven.apache.org/xsd/settings-1.0.0.xsd">
  
  <servers>
    <!-- Maven Central 发布凭据 -->
    <server>
      <id>ossrh</id>
      <username>你的Maven Central用户名</username>
      <password>你的Maven Central密码</password>
    </server>
  </servers>
  
  <profiles>
    <profile>
      <id>ossrh</id>
      <activation>
        <activeByDefault>true</activeByDefault>
      </activation>
      <properties>
        <!-- GPG 配置 -->
        <gpg.executable>gpg</gpg.executable>
        <gpg.keyname>你的GPG密钥ID</gpg.keyname>
        <!-- 可选：如果不想每次输入密码，可以配置这里 -->
        <!-- <gpg.passphrase>你的GPG密钥密码</gpg.passphrase> -->
      </properties>
    </profile>
  </profiles>
</settings>
```

### 2.3 设置文件权限

```bash
# 确保 settings.xml 文件权限安全
chmod 600 ~/.m2/settings.xml
```

## 🚀 第三步：测试发布设置

### 3.1 进入 Java SDK 目录

```bash
cd /Users/caokeji/code/flowus-api/sdk/java
```

### 3.2 清理和测试构建

```bash
# 清理项目
mvn clean

# 验证项目配置
mvn verify

# 测试编译和打包
mvn clean compile package
```

### 3.3 测试 GPG 签名

```bash
# 测试 GPG 签名功能
mvn clean verify -P sign-artifacts

# 如果成功，应该看到类似输出：
# [INFO] --- maven-gpg-plugin:3.2.1:sign (sign-artifacts) @ flowus-api-client ---
```

## 📦 第四步：执行发布

### 4.1 使用自动化脚本发布

```bash
# 使用我们创建的发布脚本
./release.sh
```

### 4.2 手动发布

```bash
# 完整发布到 Maven Central Staging
mvn clean deploy -P release

# 分步执行（如果需要调试）
mvn clean
mvn compile
mvn test
mvn package
mvn verify
mvn deploy -P release
```

## 🔍 第五步：验证发布

### 5.1 在 Maven Central 中验证

1. 访问 https://central.sonatype.com/
2. 登录你的账户
3. 查看 "Deployments" 或 "Published Components"
4. 确认 `cn.flowus:flowus-api-client:1.0.0` 已成功发布

### 5.2 测试包的可用性

```bash
# 创建测试项目验证包是否可用
mkdir -p /tmp/test-flowus-sdk
cd /tmp/test-flowus-sdk

# 创建简单的 pom.xml 测试依赖
cat > pom.xml << 'EOF'
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
         http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>test</groupId>
    <artifactId>test-flowus</artifactId>
    <version>1.0.0</version>
    <packaging>jar</packaging>
    
    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>
    
    <dependencies>
        <dependency>
            <groupId>cn.flowus</groupId>
            <artifactId>flowus-api-client</artifactId>
            <version>1.0.0</version>
        </dependency>
    </dependencies>
</project>
EOF

# 测试依赖解析
mvn dependency:resolve

# 清理测试目录
cd /Users/caokeji/code/flowus-api
rm -rf /tmp/test-flowus-sdk
```

## 🔧 故障排除

### 常见问题和解决方案

#### 问题1: GPG 签名失败
```bash
# 检查 GPG 密钥
gpg --list-secret-keys

# 重新导出密钥
gpg --armor --export-secret-keys $GPG_KEY_ID > private-key.asc

# 重新导入（如果需要）
gpg --import private-key.asc
rm private-key.asc  # 删除临时文件
```

#### 问题2: Maven 认证失败
```bash
# 检查 settings.xml 配置
cat ~/.m2/settings.xml

# 验证凭据是否正确
mvn help:effective-settings
```

#### 问题3: 网络连接问题
```bash
# 测试连接到 Maven Central
curl -I https://s01.oss.sonatype.org/

# 如果有代理，配置 Maven 代理设置
```

#### 问题4: 权限问题
```bash
# 确保有权限写入 .m2 目录
ls -la ~/.m2/

# 修复权限
chmod 755 ~/.m2
chmod 600 ~/.m2/settings.xml
```

## 📋 检查清单

发布前确认以下项目：

- [ ] 命名空间 `cn.flowus` 已验证
- [ ] GPG 密钥已生成并上传到密钥服务器
- [ ] `~/.m2/settings.xml` 已正确配置
- [ ] Maven Central 凭据已设置
- [ ] 项目可以成功构建 (`mvn clean verify`)
- [ ] GPG 签名功能正常 (`mvn verify -P sign-artifacts`)
- [ ] 版本号正确且未重复发布

完成以上步骤后，你就可以成功将 FlowUs Java SDK 发布到 Maven Central 了！

## 🎉 发布成功后

发布成功后，用户可以通过以下方式使用你的 SDK：

```xml
<dependency>
    <groupId>cn.flowus</groupId>
    <artifactId>flowus-api-client</artifactId>
    <version>1.0.0</version>
</dependency>
```

你的包将在以下地址可见：
- https://search.maven.org/artifact/cn.flowus/flowus-api-client
- https://mvnrepository.com/artifact/cn.flowus/flowus-api-client
