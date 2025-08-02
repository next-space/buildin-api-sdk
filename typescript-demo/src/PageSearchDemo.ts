/**
 * Buildin API TypeScript Demo - 添加块子元素演示
 * 基于JavaScript版本的BlockAddChildrenDemo转换而来
 */
import { BuildinClient } from './utils/BuildinClient';
import { config, validateConfig } from './config/apiConfig';

async function pageSearchDemo() {
  console.log('📝 Buildin API TypeScript Demo - 搜索页面演示');
  console.log('================================================');
  
  try {
    // 验证配置
    validateConfig();
    
    // 创建API客户端
    const client = new BuildinClient({
      baseURL: "https://api.buildin.ai",
      apiToken: config.apiToken,
      timeout: config.timeout
    });
    // 创建临时页面用于测试添加子块
    const results = await client.searchPage("如何创建多维表");
    console.log(results);
  } catch (error: any) {
    console.error('❌ 搜索页面演示失败:', error);
    if (error.response?.data) {
      console.error('详细错误信息:', JSON.stringify(error.response.data, null, 2));
    }
    process.exit(1);
  }
}

// 如果直接运行此文件，则执行演示
if (require.main === module) {
  pageSearchDemo();
}

export default pageSearchDemo; 