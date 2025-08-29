/**
 * Buildin API TypeScript Demo - 获取用户信息演示
 * 演示如何使用 /v1/users/me 接口获取机器人创建者的用户信息
 */
import { BuildinClient } from './utils/BuildinClient';
import { config, validateConfig } from './config/apiConfig';

async function getUserMeDemo() {
  console.log('👤 Buildin API TypeScript Demo - 获取用户信息演示');
  console.log('====================================================');
  
  try {
    // 验证配置
    validateConfig();
    
    // 创建API客户端
    const client = new BuildinClient({
      baseURL: "https://api.buildin.ai",
      apiToken: config.apiToken,
      timeout: config.timeout
    });

    console.log('🔍 正在获取当前机器人创建者信息...');
    
    // 获取用户信息
    const userInfo = await client.getMe();
    
    console.log('✅ 成功获取用户信息:');
    console.log('用户对象类型:', userInfo.object);
    console.log('用户ID:', userInfo.id);
    console.log('用户类型:', userInfo.type);
    console.log('用户名称:', userInfo.name || '未设置');
    console.log('用户邮箱:', userInfo.person?.email || '未设置');
    console.log('头像链接:', userInfo.avatar_url || '未设置');
    
    console.log('\n📄 完整用户信息:');
    console.log(JSON.stringify(userInfo, null, 2));
    
    console.log('\n🎉 获取用户信息演示完成!');
    
    return userInfo;
    
  } catch (error: any) {
    console.error('❌ 获取用户信息演示失败:', error.message);
    if (error.response?.data) {
      console.error('详细错误信息:', JSON.stringify(error.response.data, null, 2));
    }
    
    // 提供一些常见错误的解决建议
    if (error.message?.includes('401') || error.message?.includes('unauthorized')) {
      console.error('\n💡 解决建议: 请检查 API Token 是否正确配置');
    } else if (error.message?.includes('404')) {
      console.error('\n💡 解决建议: 机器人创建者信息可能不存在，请联系管理员');
    } else if (error.message?.includes('网络连接失败')) {
      console.error('\n💡 解决建议: 请检查网络连接是否正常');
    }
    
    process.exit(1);
  }
}

// 如果直接运行此文件，则执行演示
if (require.main === module) {
  getUserMeDemo();
}

export default getUserMeDemo;
