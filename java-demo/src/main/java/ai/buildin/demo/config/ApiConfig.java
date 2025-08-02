package ai.buildin.demo.config;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * API配置类，用于管理API的BasePath和Bearer Token
 */
public class ApiConfig {
    private static final String DEFAULT_BASE_PATH = "https://api.buildin.ai";
    private static final String DEFAULT_BEARER_TOKEN = "your-api-token-here";
    
    private final String basePath;
    private final String bearerToken;
    
    private static ApiConfig instance;
    
    private ApiConfig() {
        // 尝试从.env文件加载配置
        Dotenv dotenv = null;
        try {
            dotenv = Dotenv.configure()
                .directory(".")  // 从项目根目录查找.env文件
                .ignoreIfMissing()  // 如果文件不存在，不抛出异常
                .load();
        } catch (Exception e) {
            System.out.println("⚠️ 未找到.env文件，将使用默认配置或环境变量");
        }
        
        // 优先级：环境变量 > .env文件 > 默认值
        String envBasePath = System.getenv("BUILDIN_API_BASE_PATH");
        String envBearerToken = System.getenv("BUILDIN_API_BEARER_TOKEN");
        
        if (envBasePath != null) {
            this.basePath = envBasePath;
        } else if (dotenv != null && dotenv.get("BUILDIN_API_BASE_PATH") != null) {
            this.basePath = dotenv.get("BUILDIN_API_BASE_PATH");
        } else {
            this.basePath = DEFAULT_BASE_PATH;
        }
        
        if (envBearerToken != null) {
            this.bearerToken = envBearerToken;
        } else if (dotenv != null && dotenv.get("BUILDIN_API_BEARER_TOKEN") != null) {
            this.bearerToken = dotenv.get("BUILDIN_API_BEARER_TOKEN");
        } else {
            this.bearerToken = DEFAULT_BEARER_TOKEN;
        }
        
        // 输出配置信息（隐藏敏感信息）
        System.out.println("🔧 API配置加载完成:");
        System.out.println("   BasePath: " + this.basePath);
        System.out.println("   BearerToken: " + maskToken(this.bearerToken));
    }
    
    /**
     * 获取ApiConfig单例实例
     */
    public static synchronized ApiConfig getInstance() {
        if (instance == null) {
            instance = new ApiConfig();
        }
        return instance;
    }
    
    /**
     * 获取API基础路径
     */
    public String getBasePath() {
        return basePath;
    }
    
    /**
     * 获取Bearer Token
     */
    public String getBearerToken() {
        return bearerToken;
    }
    
    /**
     * 掩码Token，用于日志输出时隐藏敏感信息
     */
    private String maskToken(String token) {
        if (token == null || token.length() <= 8) {
            return "****";
        }
        return token.substring(0, 4) + "****" + token.substring(token.length() - 4);
    }
    
    /**
     * 验证配置是否有效
     */
    public boolean isValid() {
        return basePath != null && !basePath.trim().isEmpty() 
            && bearerToken != null && !bearerToken.trim().isEmpty()
            && !bearerToken.equals(DEFAULT_BEARER_TOKEN);
    }
    
    /**
     * 打印配置验证结果
     */
    public void validateAndPrint() {
        if (isValid()) {
            System.out.println("✅ API配置验证通过");
        } else {
            System.out.println("❌ API配置验证失败：请检查.env文件或环境变量中的BUILDIN_API_BEARER_TOKEN配置");
            System.out.println("💡 提示：请复制.env.example文件为.env并填入正确的配置");
        }
    }
}
