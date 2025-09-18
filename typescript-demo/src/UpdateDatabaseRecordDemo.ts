/**
 * Buildin API TypeScript Demo - 创建数据库记录演示
 * 基于JavaScript版本的CreateDatabaseRecordDemo转换而来
 */
import { BuildinClient } from './utils/BuildinClient';
import { config, validateConfig } from './config/apiConfig';

async function updateDatabaseRecordDemo() { 
  console.log('📄 Buildin API TypeScript Demo - 更新数据库记录演示');
  console.log('================================================');
  
  try {
    // 验证配置
    validateConfig();
    
    // 创建API客户端
    const client = new BuildinClient({
      baseURL: config.baseURL,
      apiToken: config.apiToken,
      timeout: config.timeout
    });
    const pageId = "09e1e2a8-3678-42e5-b5b5-800940599ec4";
    const pageData = {
      properties: {
        '完成': {
          type: 'checkbox',
          checkbox: false
        },
        '观看': {
          type: 'date',
          date: {
            start: '2025/07/03T15:16:00',
            end: '2025/07/20T06:16:00',
          }
        }
      }
    };
  
    // 调用API创建页面
    const result = await client.updatePage(pageId,pageData);
    
    console.log('✅ 页面记录更新成功！');
    console.log('页面ID:', result.id);
    console.log('页面URL:', result.url || '无');
    console.log('创建时间:', result.createdAt);
    console.log('最后更新时间:', result.updatedAt);
    
    // 显示创建者信息
    if (result.createdBy) {
      console.log('创建者ID:', result.createdBy.id);
    }
    
    // 显示图标信息
    if (result.icon) {
      console.log('页面图标:', result.icon.emoji || (result.icon.external?.url || '无'));
    }
    
    // 显示属性信息
    if (result.properties) {
      console.log('\n📋 已设置的属性:');
      Object.entries(result.properties).forEach(([key, prop]: [string, any]) => {
        console.log(`  • ${key}: ${prop.type}`);
      });
    }
    
    console.log('\n🎉 更新数据库记录演示完成！');
    console.log('💡 提示: 您可以在Buildin中查看刚更新的页面记录');
    
    return result;
    
  } catch (error: any) {
    console.error('❌ 更新记录演示失败:', error);
    if (error.response?.data) {
      console.error('详细错误信息:', JSON.stringify(error.response.data, null, 2));
    }
    
    process.exit(1);
  }
}

// 如果直接运行此文件，则执行演示
if (require.main === module) {
  updateDatabaseRecordDemo();
}

export default updateDatabaseRecordDemo; 