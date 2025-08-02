#!/bin/bash

echo "🚀 FlowUs API Java Demo 运行脚本"
echo "==============================="

# 检查SDK JAR文件
SDK_JAR="../sdk/java/target/openapi-java-client-1.0.0.jar"
if [ ! -f "$SDK_JAR" ]; then
    echo "❌ 找不到SDK JAR文件: $SDK_JAR"
    echo "正在构建SDK..."
    cd ../sdk/java
    mvn clean package -DskipTests
    cd ../../demo
fi

echo "✅ SDK JAR文件已准备就绪"

# 编译demo项目
echo "📦 编译demo项目..."
mvn clean compile
if [ $? -ne 0 ]; then
    echo "❌ 编译失败"
    exit 1
fi

echo "✅ 编译成功"

# 运行demo
echo "🎯 运行SimpleBlockDemo..."
echo "=========================="
java -cp "target/classes:$SDK_JAR" cn.flowus.demo.SimpleBlockDemo

echo ""
echo "🎯 运行SdkApiDemo..."
echo "==================="
java -cp "target/classes:$SDK_JAR" cn.flowus.demo.SdkApiDemo

echo ""
echo "✅ Demo运行完成！" 