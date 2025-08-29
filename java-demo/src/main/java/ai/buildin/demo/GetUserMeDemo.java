package ai.buildin.demo;

import ai.buildin.demo.config.ApiConfig;
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.api.DefaultApi;
import org.openapitools.client.auth.HttpBearerAuth;
import org.openapitools.client.model.UserMe;

/**
 * 获取机器人创建者信息示例
 * 演示如何使用 /v1/users/me 接口获取当前机器人的创建者用户信息
 */
public class GetUserMeDemo {
    public static void main(String[] args) throws Exception {
        System.out.println("🚀 开始获取机器人创建者信息演示...\n");
        
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

        try {
            System.out.println("📡 正在获取机器人创建者信息...");
            
            // 调用 /v1/users/me 接口
            UserMe userMe = apiInstance.getMe();
            
            System.out.println("✅ 成功获取机器人创建者信息：");
            System.out.println("┌─────────────────────────────────────────");
            System.out.println("│ 用户信息详情");
            System.out.println("├─────────────────────────────────────────");
            System.out.println("│ 对象类型: " + userMe.getObject());
            System.out.println("│ 用户ID: " + userMe.getId());
            System.out.println("│ 用户类型: " + userMe.getType());
            
            if (userMe.getName() != null) {
                System.out.println("│ 显示名称: " + userMe.getName());
            } else {
                System.out.println("│ 显示名称: 未设置");
            }
            
            if (userMe.getAvatarUrl() != null) {
                System.out.println("│ 头像URL: " + userMe.getAvatarUrl());
            } else {
                System.out.println("│ 头像URL: 未设置");
            }
            
            // 显示个人信息
            if (userMe.getPerson() != null && userMe.getPerson().getEmail() != null) {
                System.out.println("│ 邮箱地址: " + userMe.getPerson().getEmail());
            } else {
                System.out.println("│ 邮箱地址: 未设置");
            }
            
            System.out.println("└─────────────────────────────────────────");
            
            System.out.println("\n🎉 机器人创建者信息获取演示完成！");
            
        } catch (ApiException e) {
            System.err.println("❌ 获取机器人创建者信息失败：");
            System.err.println("   HTTP状态码: " + e.getCode());
            System.err.println("   错误信息: " + e.getMessage());
            System.err.println("   响应体: " + e.getResponseBody());
            
            // 根据不同的错误码给出具体的提示
            switch (e.getCode()) {
                case 401:
                    System.err.println("💡 提示：请检查Bearer Token是否正确配置");
                    break;
                case 404:
                    System.err.println("💡 提示：机器人创建者信息不存在");
                    break;
                case 403:
                    System.err.println("💡 提示：权限不足，请检查机器人权限配置");
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
