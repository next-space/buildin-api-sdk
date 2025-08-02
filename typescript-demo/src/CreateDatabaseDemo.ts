/**
 * Buildin API TypeScript Demo - 创建数据库演示
 * 基于JavaScript版本的CreateDatabaseDemo转换而来
 */
import { BuildinClient } from './utils/BuildinClient';
import { config, validateConfig } from './config/apiConfig';

export async function createDatabaseDemo() {
  console.log('🎬 Buildin API TypeScript Demo - 创建数据库演示');
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
    
    // 构建数据库数据 - 与JavaScript版本保持一致
    const databaseData = {
      title: [
        {
          type: 'text',
          text: {
            content: '影视剧数据库'
          }
        }
      ],
      icon: {
        type: 'emoji',
        emoji: '🎬'
      },
      properties: {
        '我的关联': {
          name: '我的关联',
          type: 'relation',
          relation: {
            database_id: 'b42115de-ac8e-4e2c-92cc-7c1cb54d0dc6'
          }
        },
        '网址': {
          name: '网址',
          type: 'url'
        },
        '人员': {
          name: '人员',
          type: 'people'
        },
        '已看': {
          name: '已看',
          type: 'number'
        },
        '我的公式': {
          name: '我的公式',
          type: 'formula',
          formula: {
            expression: 'prop("我的邮箱") + "-" + prop("我的电话")'
          }
        },
        '我的电话': {
          name: '我的电话',
          type: 'phone_number'
        },
        '评分': {
          name: '评分',
          type: 'number'
        },
        '国家': {
          name: '国家',
          type: 'select',
          select: {
            options: [
              { name: '日本', color: 'yellow' },
              { name: '中国', color: 'brown' },
              { name: '韩国', color: 'orange' },
              { name: '美国', color: 'gray' },
              { name: '法国', color: 'pink' },
              { name: '印度', color: 'purple' },
              { name: '英国', color: 'purple' },
              { name: '德国', color: 'red' },
              { name: '丹麦', color: 'orange' },
              { name: '意大利', color: 'yellow' },
              { name: '泰国', color: 'purple' }
            ]
          }
        },
        '观看': {
          name: '观看',
          type: 'date'
        },
        '我的邮箱': {
          name: '我的邮箱',
          type: 'email'
        },
        '完成': {
          name: '完成',
          type: 'checkbox'
        },
        '文件媒体': {
          name: '文件媒体',
          type: 'files'
        },
        '分类': {
          name: '分类',
          type: 'multi_select',
          multi_select: {
            options: [
              { name: '动漫', color: 'gray' },
              { name: '魔幻', color: 'brown' },
              { name: '历史', color: 'orange' },
              { name: '悬疑', color: 'yellow' },
              { name: '轻松', color: 'blue' },
              { name: '朝堂', color: 'blue' },
            ]
          }
        },
        '进度条': {
          name: '进度条',
          type: 'number'
        }
      },
      is_inline: false
    };
    
    console.log('📊 开始创建数据库...');
    console.log('数据库标题:', databaseData.title[0].text.content);
    console.log('数据库图标:', databaseData.icon.emoji);
    console.log('属性数量:', Object.keys(databaseData.properties).length);
    
    // 调用API创建数据库
    const result = await client.createDatabase(databaseData);
    
    console.log('✅ 数据库创建成功！');
    console.log('数据库ID:', result.id);
    console.log('创建时间:', result.created_time);
    console.log('最后更新时间:', result.last_edited_time);
    console.log('数据库URL:', result.url || '无');
    
    // 打印属性信息
    if (result.properties) {
      console.log('\n📋 数据库属性列表:');
      Object.entries(result.properties).forEach(([key, prop]: [string, any]) => {
        console.log(`  • ${key}: ${prop.type}`);
      });
    }
    
    console.log('\n🎉 创建数据库演示完成！');
    return result;
    
  } catch (error: any) {
    console.error('❌ 创建数据库演示失败:', error);
    if (error.response?.data) {
      console.error('详细错误信息:', JSON.stringify(error.response.data, null, 2));
    }
    process.exit(1);
  }
}

// 如果直接运行此文件，则执行演示
if (require.main === module) {
  createDatabaseDemo();
}

export default createDatabaseDemo; 