# FlowUs Java SDK 发布指南

本指南介绍如何将 FlowUs Java SDK 发布到 Maven Central 公共仓库。

## 前提条件

### 1. 注册 Maven Central 账户并认证命名空间

#### 方法A: 使用新的 Maven Central 平台 (推荐)

1. 访问 [Maven Central](https://central.sonatype.com/) 使用 GitHub 或 Google 账户登录
2. 点击右上角用户名 → "View Namespaces" → "Add Namespace"
3. 输入 `cn.flowus` 并提交
4. 点击 "Verify Namespace" 获取验证密钥
5. 在 `flowus.cn` 域名的 DNS 设置中添加 TXT 记录：
   ```
   主机记录: @
   记录类型: TXT  
   记录值: [验证密钥]
   ```
6. 等待 DNS 生效（5-30分钟），然后点击 "Confirm" 验证
7. 验证成功后命名空间状态变为 "Verified"

### 2. 生成 GPG 密钥

```bash
# 生成 GPG 密钥对
gpg --gen-key

# 列出密钥
gpg --list-keys

# 导出公钥到密钥服务器
gpg --keyserver keyserver.ubuntu.com --send-keys YOUR_KEY_ID

# 或者使用其他密钥服务器
gpg --keyserver keys.openpgp.org --send-keys YOUR_KEY_ID
```

### 3. 配置 Maven settings.xml

在 `~/.m2/settings.xml` 中添加以下配置：

```xml
<settings>
  <servers>
    <server>
      <id>ossrh</id>
      <username>你的Sonatype用户名</username>
      <password>你的Sonatype密码</password>
    </server>
  </servers>
  
  <profiles>
    <profile>
      <id>ossrh</id>
      <activation>
        <activeByDefault>true</activeByDefault>
      </activation>
      <properties>
        <gpg.executable>gpg</gpg.executable>
        <gpg.passphrase>你的GPG密钥密码</gpg.passphrase>
      </properties>
    </profile>
  </profiles>
</settings>
```

## 发布步骤

### 1. 准备发布

确保所有代码已提交并且版本号正确：

```bash
cd sdk/java

# 验证项目配置
mvn clean verify

# 运行测试
mvn test
```

### 2. 发布到 Staging 仓库

```bash
# 使用 release profile 部署到 staging
mvn clean deploy -P release

# 或者分步执行
mvn clean compile
mvn package
mvn verify
mvn deploy -P release
```

### 3. 验证和发布

1. 登录 [Sonatype Nexus Repository Manager](https://s01.oss.sonatype.org/)
2. 在 "Staging Repositories" 中找到你的部署
3. 选择你的仓库，点击 "Close" 进行验证
4. 验证通过后，点击 "Release" 发布到 Maven Central

### 4. 自动化发布 (可选)

如果在 pom.xml 中设置了 `autoReleaseAfterClose=true`，则会自动发布。

## 版本管理

### 发布新版本

1. 更新 `pom.xml` 中的版本号
2. 更新 `README.md` 中的版本引用
3. 提交代码并打标签
4. 重复发布步骤

```bash
# 更新版本号示例
mvn versions:set -DnewVersion=1.1.0
mvn versions:commit

# 提交并打标签
git add .
git commit -m "Release version 1.1.0"
git tag v1.1.0
git push origin main --tags
```

### SNAPSHOT 版本

对于开发版本，可以使用 SNAPSHOT 后缀：

```xml
<version>1.1.0-SNAPSHOT</version>
```

SNAPSHOT 版本会自动部署到 snapshot 仓库，不需要手动发布。

## 故障排除

### 常见问题

1. **GPG 签名失败**
   - 确保 GPG 密钥已正确配置
   - 检查 `settings.xml` 中的 GPG 配置

2. **验证失败**
   - 检查 POM 文件是否包含所有必需元素
   - 确保 Javadoc 和源码 JAR 都已生成

3. **权限问题**
   - 确认 Sonatype 账户有权限发布到指定的 groupId

### 验证发布成功

发布后可以在以下地址验证：

- Maven Central: https://search.maven.org/artifact/cn.flowus/flowus-api-client
- Maven Repository: https://mvnrepository.com/artifact/cn.flowus/flowus-api-client

## 自动化脚本

创建发布脚本 `release.sh`:

```bash
#!/bin/bash
set -e

echo "Starting release process..."

# 清理并测试
mvn clean test

# 部署到 staging
mvn deploy -P release

echo "Release deployed to staging. Please check and release manually at:"
echo "https://s01.oss.sonatype.org/"
```

## 参考资料

- [OSSRH Guide](https://central.sonatype.org/publish/publish-guide/)
- [Maven GPG Plugin](https://maven.apache.org/plugins/maven-gpg-plugin/)
- [Nexus Staging Plugin](https://github.com/sonatype/nexus-maven-plugins/tree/main/staging/maven-plugin)
