#!/bin/bash

echo "🚀 Buildin API Java Demo 运行脚本"
echo "================================="

# 检查SDK JAR文件
SDK_JAR="../sdk/java/target/openapi-java-client-1.0.0.jar"
if [ ! -f "$SDK_JAR" ]; then
    echo "❌ 找不到SDK JAR文件: $SDK_JAR"
    echo "正在构建SDK..."
    cd ../sdk/java
    mvn clean package -DskipTests
    cd ../../java-demo
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

# 显示可用的demo选项
echo ""
echo "📋 可用的Demo程序："
echo "=================="
echo "1. GetUserMeDemo - 获取机器人创建者信息"
echo "2. SearchDemo - 搜索页面"
echo "3. SimpleBlockDemo - 简化块操作"
echo "4. BlockAddChildrenDemo - 完整页面和块操作"
echo "5. CreateDatabaseDemo - 创建数据库"
echo "6. CreateDatabaseRecordDemo - 创建数据库记录"
echo "7. DeleteBlockDemo - 删除块"
echo "8. 运行所有demo"
echo ""

read -p "请选择要运行的Demo (1-8): " choice

case $choice in
    1)
        echo "🎯 运行GetUserMeDemo..."
        echo "======================="
        mvn exec:java -Dexec.mainClass="ai.buildin.demo.GetUserMeDemo"
        ;;
    2)
        echo "🎯 运行SearchDemo..."
        echo "==================="
        mvn exec:java -Dexec.mainClass="ai.buildin.demo.SearchDemo"
        ;;
    3)
        echo "🎯 运行SimpleBlockDemo..."
        echo "========================="
        mvn exec:java -Dexec.mainClass="ai.buildin.demo.SimpleBlockDemo"
        ;;
    4)
        echo "🎯 运行BlockAddChildrenDemo..."
        echo "============================="
        mvn exec:java -Dexec.mainClass="ai.buildin.demo.BlockAddChildrenDemo"
        ;;
    5)
        echo "🎯 运行CreateDatabaseDemo..."
        echo "============================"
        mvn exec:java -Dexec.mainClass="ai.buildin.demo.CreateDatabaseDemo"
        ;;
    6)
        echo "🎯 运行CreateDatabaseRecordDemo..."
        echo "=================================="
        mvn exec:java -Dexec.mainClass="ai.buildin.demo.CreateDatabaseRecordDemo"
        ;;
    7)
        echo "🎯 运行DeleteBlockDemo..."
        echo "========================"
        mvn exec:java -Dexec.mainClass="ai.buildin.demo.DeleteBlockDemo"
        ;;
    8)
        echo "🎯 运行所有Demo..."
        echo "=================="
        
        echo "1. GetUserMeDemo..."
        mvn exec:java -Dexec.mainClass="ai.buildin.demo.GetUserMeDemo"
        echo ""
        
        echo "2. SearchDemo..."
        mvn exec:java -Dexec.mainClass="ai.buildin.demo.SearchDemo"
        echo ""
        
        echo "3. SimpleBlockDemo..."
        mvn exec:java -Dexec.mainClass="ai.buildin.demo.SimpleBlockDemo"
        echo ""
        
        echo "4. BlockAddChildrenDemo..."
        mvn exec:java -Dexec.mainClass="ai.buildin.demo.BlockAddChildrenDemo"
        echo ""
        
        echo "5. CreateDatabaseDemo..."
        mvn exec:java -Dexec.mainClass="ai.buildin.demo.CreateDatabaseDemo"
        echo ""
        
        echo "6. CreateDatabaseRecordDemo..."
        mvn exec:java -Dexec.mainClass="ai.buildin.demo.CreateDatabaseRecordDemo"
        echo ""
        
        echo "7. DeleteBlockDemo..."
        mvn exec:java -Dexec.mainClass="ai.buildin.demo.DeleteBlockDemo"
        ;;
    *)
        echo "❌ 无效选择，请输入1-8之间的数字"
        exit 1
        ;;
esac

echo ""
echo "✅ Demo运行完成！" 