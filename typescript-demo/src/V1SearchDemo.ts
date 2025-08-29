/**
 * Buildin API TypeScript Demo - V1 搜索演示
 * 演示如何使用 /v1/search 接口在机器人授权的页面范围内搜索相关内容
 */
import { BuildinClient } from './utils/BuildinClient';
import { config, validateConfig } from './config/apiConfig';

async function v1SearchDemo() {
  console.log('🔍 Buildin API TypeScript Demo - V1 搜索演示');
  console.log('===============================================');
  
  try {
    // 验证配置
    validateConfig();
    
    // 创建API客户端
    const client = new BuildinClient({
      baseURL: "https://api.buildin.ai",
      apiToken: config.apiToken,
      timeout: config.timeout
    });

    // 演示1: 带关键词的搜索
    console.log('📋 演示1: 搜索包含"项目计划"的页面');
    console.log('==============================');
    
    const searchResult1 = await client.v1Search('项目计划', {
      pageSize: 10
    });
    
    console.log('搜索结果对象类型:', searchResult1.object);
    console.log('结果数量:', searchResult1.results.length);
    console.log('是否有更多结果:', searchResult1.has_more);
    console.log('下一页游标:', searchResult1.next_cursor || '无');
    
    if (searchResult1.results.length > 0) {
      console.log('\n找到的页面:');
      searchResult1.results.forEach((page: any, index: number) => {
        console.log(`${index + 1}. 页面ID: ${page.id}`);
        console.log(`   创建时间: ${page.created_time}`);
        console.log(`   最后编辑时间: ${page.last_edited_time}`);
        console.log(`   是否归档: ${page.archived}`);
        
        // 显示页面标题
        if (page.properties?.title?.title) {
          const titleText = page.properties.title.title
            .map((item: any) => item.text?.content || item.plain_text || '')
            .join('');
          console.log(`   标题: ${titleText}`);
        }
        
        // 显示父级信息
        if (page.parent) {
          console.log(`   父级类型: ${page.parent.type}`);
          if (page.parent.database_id) {
            console.log(`   所属数据库: ${page.parent.database_id}`);
          } else if (page.parent.page_id) {
            console.log(`   所属页面: ${page.parent.page_id}`);
          } else if (page.parent.space_id) {
            console.log(`   所属空间: ${page.parent.space_id}`);
          }
        }
        console.log('');
      });
    } else {
      console.log('未找到匹配的页面');
    }

    // 演示2: 列出所有授权页面（空查询）
    console.log('\n📋 演示2: 列出所有授权页面（使用空查询）');
    console.log('=====================================');
    
    const searchResult2 = await client.v1Search('', {
      pageSize: 5
    });
    
    console.log('总页面数量:', searchResult2.results.length);
    console.log('是否有更多页面:', searchResult2.has_more);
    
    if (searchResult2.results.length > 0) {
      console.log('\n授权页面列表:');
      searchResult2.results.forEach((page: any, index: number) => {
        const titleText = page.properties?.title?.title
          ?.map((item: any) => item.text?.content || item.plain_text || '')
          .join('') || '无标题';
        console.log(`${index + 1}. ${titleText} (${page.id})`);
      });
    }

    // 演示3: 分页搜索
    if (searchResult2.has_more && searchResult2.next_cursor) {
      console.log('\n📋 演示3: 分页搜索演示');
      console.log('====================');
      
      const searchResult3 = await client.v1Search('', {
        startCursor: searchResult2.next_cursor,
        pageSize: 3
      });
      
      console.log('第二页结果数量:', searchResult3.results.length);
      console.log('第二页是否还有更多:', searchResult3.has_more);
      
      if (searchResult3.results.length > 0) {
        console.log('\n第二页页面:');
        searchResult3.results.forEach((page: any, index: number) => {
          const titleText = page.properties?.title?.title
            ?.map((item: any) => item.text?.content || item.plain_text || '')
            .join('') || '无标题';
          console.log(`${index + 1}. ${titleText} (${page.id})`);
        });
      }
    }

    console.log('\n📄 完整搜索结果示例:');
    console.log(JSON.stringify(searchResult1, null, 2));
    
    console.log('\n🎉 V1 搜索演示完成!');
    
    return {
      keywordSearch: searchResult1,
      allPages: searchResult2
    };
    
  } catch (error: any) {
    console.error('❌ V1 搜索演示失败:', error.message);
    if (error.response?.data) {
      console.error('详细错误信息:', JSON.stringify(error.response.data, null, 2));
    }
    
    // 提供一些常见错误的解决建议
    if (error.message?.includes('401') || error.message?.includes('unauthorized')) {
      console.error('\n💡 解决建议: 请检查 API Token 是否正确配置');
    } else if (error.message?.includes('403') || error.message?.includes('forbidden')) {
      console.error('\n💡 解决建议: 机器人可能没有搜索权限，请检查授权范围');
    } else if (error.message?.includes('429')) {
      console.error('\n💡 解决建议: 请求频率过高，请稍后再试');
    } else if (error.message?.includes('网络连接失败')) {
      console.error('\n💡 解决建议: 请检查网络连接是否正常');
    }
    
    process.exit(1);
  }
}

// 如果直接运行此文件，则执行演示
if (require.main === module) {
  v1SearchDemo();
}

export default v1SearchDemo;
