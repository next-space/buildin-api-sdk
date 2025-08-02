package ai.buildin.demo;

import ai.buildin.demo.config.ApiConfig;
import org.openapitools.client.ApiClient;
import org.openapitools.client.Configuration;
import org.openapitools.client.api.DefaultApi;
import org.openapitools.client.auth.HttpBearerAuth;
import org.openapitools.client.model.DeleteBlockResponse;

import java.util.UUID;

public class DeleteBlockDemo {
    public static void main(String[] args) throws Exception {
        // 获取API配置
        ApiConfig apiConfig = ApiConfig.getInstance();
        apiConfig.validateAndPrint();
        
        // 配置API客户端
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath(apiConfig.getBasePath());

        // 配置Bearer认证
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken(apiConfig.getBearerToken());

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        DeleteBlockResponse result = apiInstance.deleteBlock(UUID.fromString("80a45e5e-3712-416d-a765-bd1674b68bcd"));
        System.out.println(result);
    }
}
