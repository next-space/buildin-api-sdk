/**
 * Buildin API TypeScript Demo - 删除块演示
 * 基于JavaScript版本的DeleteBlockDemo转换而来
 */
import { BuildinClient } from './utils/BuildinClient';
import { config, validateConfig } from './config/apiConfig';

async function deleteBlockDemo() {
  console.log('🗑️  Buildin API TypeScript Demo - 删除块演示');
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
    
        // 创建临时页面用于测试删除
        const newPage = await client.createPage({
          icon: {
            type: 'emoji',
            emoji: "📄"
          },
          cover: {
            type: "external",
            external: {
              url: "https://cdn2.buildin.ai/assets/_next/static/media/flowers.a6e6c984.svg"
            }
          },
          properties: {
            title: {
              type: "title",
              title: [
                {
                  text: {
                    content: "我的新页面"
                  }
                }
              ]
            }
          }
        });
        const blockId = newPage.id;
    
    console.log('🎯 目标块ID:', blockId);
    
    // 验证块ID格式
    if (!client.isValidUUID(blockId) && blockId !== 'example-block-id-for-demo') {
      throw new Error(`无效的块ID格式: ${blockId}`);
    }
    
    console.log('\n📋 删除前的准备工作:');
    
    // 可选：先获取块信息（如果块存在的话）
    try {
      console.log('🔍 正在获取块信息...');
      const blockInfo = await client.getBlock(blockId);
      
      console.log('✅ 找到目标块:');
      console.log('块类型:', blockInfo.type);
      console.log('创建时间:', blockInfo.created_time);
      console.log('最后更新时间:', blockInfo.last_edited_time);
      
      // 显示块的父级信息
      if (blockInfo.parent) {
        console.log('父级类型:', blockInfo.parent.type);
        if (blockInfo.parent.pageId) {
          console.log('所在页面ID:', blockInfo.parent.pageId);
        } else if (blockInfo.parent.blockId) {
          console.log('父块ID:', blockInfo.parent.blockId);
        }
      }
      
      // 显示块的内容（如果有的话）
      if (blockInfo.data && blockInfo.data.rich_text) {
        const textContent = blockInfo.data.rich_text
          .filter((item: any) => item.type === 'text')
          .map((item: any) => item.text.content)
          .join('');
        if (textContent) {
          console.log('块内容预览:', textContent.substring(0, 100) + (textContent.length > 100 ? '...' : ''));
        }
      }
      
    } catch (error: any) {
      if (error.message.includes('404')) {
        console.log('⚠️  未找到指定的块，可能已被删除或ID不正确');
      } else {
        console.log('⚠️  获取块信息失败:', error.message);
      }
      console.log('继续执行删除操作...');
    }
    
    // 确认删除操作
    console.log('\n⚠️  警告: 此操作将永久删除指定的块及其所有子块！');
    console.log('🗑️  准备删除块:', blockId);
    
    // 执行删除操作
    console.log('\n🚀 开始删除块...');
    const result = await client.deleteBlock(blockId);
    
    console.log('✅ 块删除成功！');
    
    // 显示删除结果信息
    if (result) {
      console.log('删除结果:', JSON.stringify(result, null, 2));
      
      // 如果返回结果包含对象信息
      if (result.object) {
        console.log('对象类型:', result.object);
      }
      
      if (result.id) {
        console.log('已删除的块ID:', result.id);
      }
      
      if (result.deleted !== undefined) {
        console.log('删除状态:', result.deleted ? '已删除' : '未删除');
      }
    }
    
    console.log('\n🎉 删除块演示完成！');
    console.log('💡 提示: 被删除的块将无法恢复，请谨慎操作');
    
    return result;
    
  } catch (error: any) {
    console.error('❌ 删除块演示失败:', error.message);
    
    process.exit(1);
  }
}

// 如果直接运行此文件，则执行演示
if (require.main === module) {
  deleteBlockDemo();
}

export default deleteBlockDemo; 