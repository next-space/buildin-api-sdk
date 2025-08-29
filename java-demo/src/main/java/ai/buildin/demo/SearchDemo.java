package ai.buildin.demo;

import ai.buildin.demo.config.ApiConfig;
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.api.DefaultApi;
import org.openapitools.client.auth.HttpBearerAuth;
import org.openapitools.client.model.V1SearchRequest;
import org.openapitools.client.model.V1SearchResponse;
import org.openapitools.client.model.V1SearchPageResult;
import org.openapitools.client.model.RichTextItem;

import java.util.Scanner;

/**
 * 搜索页面示例
 * 演示如何使用 /v1/search 接口在机器人授权的页面范围内搜索相关内容
 */
public class SearchDemo {
    public static void main(String[] args) throws Exception {
        System.out.println("🔍 开始搜索页面演示...\n");
        
        // 获取API配置
        ApiConfig apiConfig = ApiConfig.getInstance();
        apiConfig.validateAndPrint();
        
        if (!apiConfig.isValid()) {
            System.out.println("❌ API配置无效，请检查配置后重试");
            return;
        }
        
        // 配置API客户端
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath(apiConfig.getBasePath());

        // 配置Bearer认证
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken(apiConfig.getBearerToken());

        DefaultApi apiInstance = new DefaultApi(defaultClient);

        // 创建搜索请求
        Scanner scanner = new Scanner(System.in);
        
        try {
            // 演示不同类型的搜索
            demonstrateSearch(apiInstance);
            
            // 交互式搜索
            System.out.println("\n🎯 交互式搜索演示");
            System.out.println("输入搜索关键词（输入 'quit' 退出）：");
            
            while (true) {
                System.out.print("🔍 搜索: ");
                String query = scanner.nextLine().trim();
                
                if ("quit".equalsIgnoreCase(query)) {
                    System.out.println("👋 退出搜索演示");
                    break;
                }
                
                if (query.isEmpty()) {
                    System.out.println("⚠️ 请输入搜索关键词");
                    continue;
                }
                
                performSearch(apiInstance, query, 10, null);
                System.out.println();
            }
            
        } catch (Exception e) {
            System.err.println("❌ 搜索演示过程中发生错误: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
    
    /**
     * 演示不同类型的搜索
     */
    private static void demonstrateSearch(DefaultApi apiInstance) {
        System.out.println("📋 搜索演示案例：\n");
        
        // 案例1：带关键词搜索
        System.out.println("📌 案例1：搜索包含'项目'的页面");
        performSearch(apiInstance, "项目", 5, null);
        
        System.out.println("\n" + "─".repeat(50) + "\n");
        
        // 案例2：搜索会议相关内容
        System.out.println("📌 案例2：搜索包含'会议'的页面");
        performSearch(apiInstance, "会议", 5, null);
        
        System.out.println("\n" + "─".repeat(50) + "\n");
        
        // 案例3：列出所有授权页面（空查询）
        System.out.println("📌 案例3：列出所有授权页面（前5个）");
        performSearch(apiInstance, "", 5, null);
        
        System.out.println("\n" + "─".repeat(50));
    }
    
    /**
     * 执行搜索操作
     */
    private static void performSearch(DefaultApi apiInstance, String query, Integer pageSize, String startCursor) {
        try {
            System.out.println("📡 正在搜索: \"" + (query.isEmpty() ? "所有页面" : query) + "\"...");
            
            // 创建搜索请求
            V1SearchRequest searchRequest = new V1SearchRequest()
                .query(query);
            
            if (pageSize != null) {
                searchRequest.pageSize(pageSize);
            }
            
            if (startCursor != null) {
                searchRequest.startCursor(startCursor);
            }
            
            // 执行搜索
            V1SearchResponse searchResponse = apiInstance.v1Search(searchRequest);
            
            // 显示搜索结果
            System.out.println("✅ 搜索完成：");
            System.out.println("┌─────────────────────────────────────────");
            System.out.println("│ 搜索结果");
            System.out.println("├─────────────────────────────────────────");
            System.out.println("│ 结果数量: " + (searchResponse.getResults() != null ? searchResponse.getResults().size() : 0));
            System.out.println("│ 是否有更多: " + searchResponse.getHasMore());
            
            if (searchResponse.getNextCursor() != null) {
                System.out.println("│ 下一页游标: " + searchResponse.getNextCursor().substring(0, Math.min(20, searchResponse.getNextCursor().length())) + "...");
            }
            
            if (searchResponse.getResults() != null && !searchResponse.getResults().isEmpty()) {
                System.out.println("├─────────────────────────────────────────");
                
                for (int i = 0; i < searchResponse.getResults().size(); i++) {
                    V1SearchPageResult page = searchResponse.getResults().get(i);
                    System.out.println("│ [" + (i + 1) + "] 页面信息:");
                    System.out.println("│     ID: " + page.getId());
                    System.out.println("│     对象类型: " + page.getObject());
                    System.out.println("│     创建时间: " + page.getCreatedTime());
                    System.out.println("│     最后编辑: " + page.getLastEditedTime());
                    System.out.println("│     是否归档: " + page.getArchived());
                    
                    // 显示标题
                    if (page.getProperties() != null && 
                        page.getProperties().getTitle() != null && 
                        page.getProperties().getTitle().getTitle() != null) {
                        
                        StringBuilder titleBuilder = new StringBuilder();
                        for (RichTextItem item : page.getProperties().getTitle().getTitle()) {
                            if (item.getPlainText() != null) {
                                titleBuilder.append(item.getPlainText());
                            }
                        }
                        
                        if (titleBuilder.length() > 0) {
                            System.out.println("│     标题: " + titleBuilder.toString());
                        }
                    }
                    
                    // 显示父级信息
                    if (page.getParent() != null) {
                        if (page.getParent().getSchemaType() != null) {
                            System.out.println("│     父级类型: " + page.getParent().getSchemaType());
                        }
                    }
                    
                    if (i < searchResponse.getResults().size() - 1) {
                        System.out.println("│     " + "─".repeat(30));
                    }
                }
            } else {
                System.out.println("│ 暂无搜索结果");
            }
            
            System.out.println("└─────────────────────────────────────────");
            
            // 如果有更多结果，提示用户
            if (searchResponse.getHasMore()) {
                System.out.println("💡 提示：还有更多结果，可以使用 next_cursor 进行分页查询");
            }
            
        } catch (ApiException e) {
            System.err.println("❌ 搜索失败：");
            System.err.println("   HTTP状态码: " + e.getCode());
            System.err.println("   错误信息: " + e.getMessage());
            System.err.println("   响应体: " + e.getResponseBody());
            
            // 根据不同的错误码给出具体的提示
            switch (e.getCode()) {
                case 400:
                    System.err.println("💡 提示：请检查搜索参数是否正确");
                    break;
                case 401:
                    System.err.println("💡 提示：请检查Bearer Token是否正确配置");
                    break;
                case 403:
                    System.err.println("💡 提示：权限不足，请检查机器人权限配置");
                    break;
                case 429:
                    System.err.println("💡 提示：请求频率超过限制，请稍后重试");
                    break;
                case 500:
                    System.err.println("💡 提示：服务器内部错误，请稍后重试");
                    break;
                default:
                    System.err.println("💡 提示：请检查网络连接和API配置");
                    break;
            }
        } catch (Exception e) {
            System.err.println("❌ 发生未知错误: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
