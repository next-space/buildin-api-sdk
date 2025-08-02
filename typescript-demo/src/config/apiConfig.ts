/**
 * Buildin API 配置
 */
import dotenv from 'dotenv';
dotenv.config();

const config = {
  // API基础配置
  baseURL: process.env.BUILDIN_API_BASE_URL || 'https://api.buildin.ai',
  apiToken: process.env.BUILDIN_API_TOKEN || '',
  
  // 超时配置（毫秒）
  timeout: 30000,
  
  // 请求头配置
  headers: {
    'Content-Type': 'application/json',
    'User-Agent': 'Buildin-TypeScript-Demo/1.0.0'
  }
};

// 验证必要配置
function validateConfig(): void {
  if (!config.apiToken || config.apiToken === '') {
    throw new Error('❌ BUILDIN_API_TOKEN 未配置，请在 .env 文件中设置您的API Token');
  }
  
  if (!config.baseURL) {
    throw new Error('❌ BUILDIN_API_BASE_URL 未配置');
  }
}

export {
  config,
  validateConfig
}; 