#!/bin/bash

# Buildin Java SDK 发布脚本
set -e

echo "🚀 Buildin Java SDK 发布脚本"
echo "================================"

# 检查当前目录
if [ ! -f "pom.xml" ]; then
    echo "❌ 错误: 请在 sdk/java 目录下运行此脚本"
    exit 1
fi

# 检查版本号
VERSION=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout)
echo "📋 当前版本: $VERSION"

# 确认发布
read -p "是否要发布版本 $VERSION 到 Maven Central? (y/n): " -n 1 -r
echo
if [[ ! $REPLY =~ ^[Yy]$ ]]; then
    echo "❌ 发布已取消"
    exit 1
fi

echo
echo "🧹 清理项目..."
mvn clean

echo
echo "🔧 编译和测试..."
mvn compile test

echo
echo "📦 打包项目..."
mvn package

echo
echo "✅ 验证项目..."
mvn verify

echo
echo "🚀 部署到 Maven Central Staging..."
mvn deploy -P release

echo
echo "🎉 发布完成!"
echo "请访问以下链接手动验证和发布:"
echo "https://s01.oss.sonatype.org/"
echo
echo "发布后，您的包将在以下地址可用:"
echo "https://search.maven.org/artifact/ai.buildin/buildin-api-client/$VERSION"
