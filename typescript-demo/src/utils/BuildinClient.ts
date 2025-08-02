/**
 * Buildin API 客户端封装 - 使用官方TypeScript SDK
 */
import { DefaultApi, Configuration } from 'buildin-api-sdk';
import { v4 as uuidv4 } from 'uuid';

// 客户端配置接口
interface BuildinClientOptions {
  baseURL: string;
  apiToken: string;
  timeout?: number;
}

/**
 * BuildinClient类 - 封装便捷的API接口
 */
class BuildinClient {
  private baseURL: string;
  private apiToken: string;
  private timeout: number;
  private api: DefaultApi;

  constructor(options: BuildinClientOptions) {
    this.baseURL = options.baseURL || 'https://api.buildin.ai';
    this.apiToken = options.apiToken || '';
    this.timeout = options.timeout || 30000;
    
    // 创建API客户端配置
    const configuration = new Configuration({
      basePath: this.baseURL,
      accessToken: this.apiToken,
      headers: {
        'User-Agent': 'Buildin-TypeScript-Demo/1.0.0'
      }
    });
    
    // 创建API客户端实例
    this.api = new DefaultApi(configuration);
    
    console.log('🔧 Buildin 官方SDK客户端已初始化');
    console.log('API地址:', this.baseURL);
    console.log('Token状态:', this.apiToken ? '已配置' : '未配置');
  }
  
  /**
   * 创建数据库
   * @param databaseData 数据库数据
   * @returns 创建结果
   */
  async createDatabase(databaseData: any): Promise<any> {
    try {
      return await this.api.createDatabase({
        createDatabaseRequest: databaseData
      });
    } catch (error) {
      throw this.handleApiError(error, '创建数据库');
    }
  }
  
  /**
   * 查询数据库
   * @param databaseId 数据库ID
   * @param queryData 查询条件
   * @returns 查询结果
   */
  async queryDatabase(databaseId: string, queryData: any = {}): Promise<any> {
    try {
      return await this.api.queryDatabase({
        databaseId,
        queryDatabaseRequest: queryData
      });
    } catch (error) {
      throw this.handleApiError(error, '查询数据库');
    }
  }
  
  /**
   * 更新数据库
   * @param databaseId 数据库ID
   * @param updateData 更新数据
   * @returns 更新结果
   */
  async updateDatabase(databaseId: string, updateData: any): Promise<any> {
    try {
      return await this.api.updateDatabase({
        databaseId,
        updateDatabaseRequest: updateData
      });
    } catch (error) {
      throw this.handleApiError(error, '更新数据库');
    }
  }
  
  /**
   * 获取数据库
   * @param databaseId 数据库ID
   * @returns 数据库信息
   */
  async getDatabase(databaseId: string): Promise<any> {
    try {
      return await this.api.getDatabase({
        databaseId
      });
    } catch (error) {
      throw this.handleApiError(error, '获取数据库');
    }
  }
  
  /**
   * 创建页面
   * @param pageData 页面数据
   * @returns 创建结果
   */
  async createPage(pageData: any): Promise<any> {
    try {
      return await this.api.createPage({
        createPageRequest: pageData
      });
    } catch (error) {
      throw this.handleApiError(error, '创建页面');
    }
  }
  
  /**
   * 获取页面信息
   * @param pageId 页面ID
   * @returns 页面信息
   */
  async getPage(pageId: string): Promise<any> {
    try {
      return await this.api.getPage({
        pageId
      });
    } catch (error) {
      throw this.handleApiError(error, '获取页面信息');
    }
  }
  
  /**
   * 更新页面
   * @param pageId 页面ID
   * @param updateData 更新数据
   * @returns 更新结果
   */
  async updatePage(pageId: string, updateData: any): Promise<any> {
    try {
      return await this.api.updatePage({
        pageId,
        updatePageRequest: updateData
      });
    } catch (error) {
      throw this.handleApiError(error, '更新页面');
    }
  }
  
  /**
   * 获取块信息
   * @param blockId 块ID
   * @returns 块信息
   */
  async getBlock(blockId: string): Promise<any> {
    try {
      return await this.api.getBlock({
        blockId
      });
    } catch (error) {
      throw this.handleApiError(error, '获取块信息');
    }
  }
  
  /**
   * 更新块
   * @param blockId 块ID
   * @param updateData 更新数据
   * @returns 更新结果
   */
  async updateBlock(blockId: string, updateData: any): Promise<any> {
    try {
      return await this.api.updateBlock({
        blockId,
        updateBlockRequest: updateData
      });
    } catch (error) {
      throw this.handleApiError(error, '更新块');
    }
  }
  
  /**
   * 删除块
   * @param blockId 块ID
   * @returns 删除结果
   */
  async deleteBlock(blockId: string): Promise<any> {
    try {
      return await this.api.deleteBlock({
        blockId
      });
    } catch (error) {
      throw this.handleApiError(error, '删除块');
    }
  }

  async searchPage(query: string): Promise<any> {
    try {
      return await this.api.searchPages({
        searchRequest: {
          query: query
        }
      });
    } catch (error) {
      throw this.handleApiError(error, '搜索页面');
    }
  }
  
  /**
   * 获取块的子块
   * @param blockId 父块ID
   * @param options 选项
   * @returns 子块列表
   */
  async getBlockChildren(blockId: string, options: { startCursor?: string, pageSize?: number } = {}): Promise<any> {
    try {
      return await this.api.getBlockChildren({
        blockId,
        startCursor: options.startCursor,
        pageSize: options.pageSize
      });
    } catch (error) {
      throw this.handleApiError(error, '获取块的子块');
    }
  }
  
  /**
   * 向块添加子块
   * @param blockId 父块ID
   * @param childrenData 子块数据
   * @returns 添加结果
   */
  async appendBlockChildren(blockId: string, childrenData: any): Promise<any> {
    try {
      return await this.api.appendBlockChildren({
        blockId,
        appendBlockChildrenRequest: childrenData
      });
    } catch (error) {
      throw this.handleApiError(error, '添加子块');
    }
  }

  /**
   * 处理API错误
   * @param error 错误对象
   * @param operation 操作名称
   * @returns 格式化的错误
   */
  private handleApiError(error: any, operation: string): Error {
    const errorMessage = `${operation}失败`;
    
    if (error.response) {
      // 服务器返回错误响应
      const status = error.response.status;
      const data = error.response.data;
      
      let message = `${errorMessage}: HTTP ${status}`;
      if (data && data.message) {
        message += ` - ${data.message}`;
      }
      
      const apiError = new Error(message);
      (apiError as any).status = status;
      (apiError as any).response = error.response;
      return apiError;
    } else if (error.request) {
      // 请求发出但没有收到响应
      return new Error(`${errorMessage}: 网络连接失败`);
    } else {
      // 其他错误
      return new Error(`${errorMessage}: ${error.message || String(error)}`);
    }
  }
  
  /**
   * 生成UUID
   * @returns UUID字符串
   */
  generateUUID(): string {
    return uuidv4();
  }
  
  /**
   * 验证UUID格式
   * @param uuid UUID字符串
   * @returns 是否为有效UUID
   */
  isValidUUID(uuid: string): boolean {
    const uuidRegex = /^[0-9a-f]{8}-[0-9a-f]{4}-4[0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$/i;
    return uuidRegex.test(uuid);
  }
}

// 导出SDK风格的API和便捷的客户端
export {
  BuildinClient,
  DefaultApi,
  Configuration
}; 