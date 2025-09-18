/**
 * Buildin API TypeScript Demo - 创建数据库记录演示
 * 基于JavaScript版本的CreateDatabaseRecordDemo转换而来
 */
import { BuildinClient } from './utils/BuildinClient';
import { config, validateConfig } from './config/apiConfig';
import createDatabaseDemo from "./CreateDatabaseDemo";

async function createDatabaseRecordDemo() {
  console.log('📄 Buildin API TypeScript Demo - 创建数据库记录演示');
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
    // 临时创建一个新多维表用于测试记录添加
    const newDatabase = await createDatabaseDemo();
    
    // 构建页面数据 - 与JavaScript版本保持一致
    const pageData = {
      properties: {
        title: {
          type: 'title',
          title: [
            {
              type: 'text',
              text: {
                content: '复活的鲁路修V3'
              }
            }
          ]
        },
        '我的关联': {
          type: 'relation',
          relation: [
            {
              id: 'bcf00100-d7c9-4c5e-b755-7212bc34c26a'
            }
          ]
        },
        '网址': {
          type: 'url',
          url: 'google.com'
        },
        '人员': {
          type: 'people',
          people: [
            {
              object: 'user',
              id: 'e37e54a2-0278-48bd-a01f-ca3ed32f22bf'
            }
          ]
        },
        '已看': {
          type: 'number',
          number: 12
        },
        '我的电话': {
          type: 'phone_number',
          phone_number: '13683236049'
        },
        '评分': {
          type: 'number',
          number: '67'
        },
        '国家': {
          type: 'select',
          select: {
            name: '日本',
            color: 'yellow'
          }
        },
        '观看': {
          type: 'date',
          date: {
            start: '2025/07/03T15:16:00',
            end: '2025/07/04T15:16:00',
            time_zone: null
          }
        },
        '我的邮箱': {
          type: 'email',
          email: 'caokeji@gmail.com'
        },
        '完成': {
          type: 'checkbox',
          checkbox: true
        },
        '分类': {
          type: 'multi_select',
          multi_select: [
            {
              name: '动漫',
              color: 'grey'
            },
            {
              name: '魔幻',
              color: 'brown'
            }
          ]
        },
        '进度条': {
          type: 'number',
          number: '12'
        }
      },
      parent: {
        type: 'database_id',
        database_id: newDatabase.id
      },
      icon: {
        type: 'emoji',
        emoji: '😁'
      }
    };
    
    
    // 显示属性详情
    console.log('\n📝 页面属性详情:');
    Object.entries(pageData.properties).forEach(([key, prop]: [string, any]) => {
      let value = '';
      switch (prop.type) {
        case 'title':
          value = prop.title[0].text.content;
          break;
        case 'number':
          value = prop.number;
          break;
        case 'url':
          value = prop.url;
          break;
        case 'email':
          value = prop.email;
          break;
        case 'phone_number':
          value = prop.phone_number;
          break;
        case 'checkbox':
          value = prop.checkbox ? '已选中' : '未选中';
          break;
        case 'select':
          value = prop.select ? `${prop.select.name} (${prop.select.color})` : '无选择';
          break;
        case 'multi_select':
          value = prop.multi_select && prop.multi_select.length > 0 
            ? prop.multi_select.map((item: any) => `${item.name} (${item.color})`).join(', ')
            : '无选择';
          break;
        case 'date':
          value = prop.date.start;
          break;
        case 'people':
          value = prop.people && prop.people.length > 0 ? `${prop.people.length} 个用户` : '无用户';
          break;
        case 'relation':
          value = `${prop.relation.length} 个关联`;
          break;
        case 'files':
          value = prop.files && prop.files.length > 0 ? `${prop.files.length} 个文件` : '无文件';
          break;
        default:
          value = '复杂类型';
      }
      console.log(`  • ${key} (${prop.type}): ${value}`);
    });
    
    console.log('\n🚀 开始创建页面记录...');
    
    // 调用API创建页面
    const result = await client.createPage(pageData);
    
    console.log('✅ 页面记录创建成功！');
    console.log('页面ID:', result.id);
    console.log('页面URL:', result.url || '无');
    console.log('创建时间:', result.createdAt);
    console.log('最后更新时间:', result.updatedAt);
    
    // 显示创建者信息
    if (result.createdBy) {
      console.log('创建者ID:', result.createdBy.id);
    }
    
    // 显示父级信息
    if (result.parent) {
      console.log('父级类型:', result.parent.type);
      if (result.parent.page_id) {
        console.log('所在页面ID:', result.parent.page_id);
      } else if (result.parent.database_id) {
        console.log('所在数据库ID:', result.parent.database_id);
      }
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
    
    console.log('\n🎉 创建数据库记录演示完成！');
    console.log('💡 提示: 您可以在Buildin中查看刚创建的页面记录');
    
    return result;
    
  } catch (error: any) {
    console.error('❌ 创建数据库记录演示失败:', error);
    if (error.response?.data) {
      console.error('详细错误信息:', JSON.stringify(error.response.data, null, 2));
    }
    
    // 提供具体的错误解决建议
    if (error.message.includes('404') || error.message.includes('not found')) {
      console.error('\n💡 可能的解决方案:');
      console.error('1. 检查数据库ID是否正确');
      console.error('2. 确保您有该数据库的写入权限');
      console.error('3. 在.env文件中配置正确的DEMO_DATABASE_ID');
    } else if (error.message.includes('400') || error.message.includes('validation')) {
      console.error('\n💡 可能的解决方案:');
      console.error('1. 检查属性值格式是否正确');
      console.error('2. 确保选择项的ID存在于数据库中');
      console.error('3. 检查日期格式是否正确');
    } else if (error.message.includes('403') || error.message.includes('forbidden')) {
      console.error('\n💡 可能的解决方案:');
      console.error('1. 检查API Token是否有效');
      console.error('2. 确保您有创建页面的权限');
    }
    
    process.exit(1);
  }
}

// 如果直接运行此文件，则执行演示
if (require.main === module) {
  createDatabaseRecordDemo();
}

export default createDatabaseRecordDemo; 