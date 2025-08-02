/**
 * Buildin API TypeScript Demo - 添加块子元素演示
 * 基于JavaScript版本的BlockAddChildrenDemo转换而来
 */
import { BuildinClient } from './utils/BuildinClient';
import { config, validateConfig } from './config/apiConfig';

async function blockAddChildrenDemo() {
  console.log('📝 Buildin API TypeScript Demo - 添加块子元素演示');
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
    // 创建临时页面用于测试添加子块
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
    const newPageId = newPage.id;
    
    // 使用配置中的块ID，如果未配置则使用默认值
    let blockId = newPageId;
    
    console.log('🎯 在此新创建的页面上添加子块:', `https://buildin.ai/${newPageId}`);
    
    // 构建子块数据 - 与JavaScript版本保持一致
    const childrenData = {
      children: [
        {
          type: 'heading_1',
          data: {
            rich_text: [
              {
                type: 'text',
                text: {
                  content: '📋 项目开发计划',
                  link: null
                },
                annotations: {
                  bold: true,
                  color: 'blue'
                }
              }
            ],
            text_color: 'blue',
            background_color: 'default'
          }
        },
        {
          type: 'callout',
          data: {
            rich_text: [
              {
                type: 'text',
                text: {
                  content: '项目状态：进行中 | 优先级：高 | 预计完成：',
                  link: null
                }
              },
              {
                type: 'mention',
                mention: {
                  type: 'date',
                  date: {
                    start: '2023-12-31',
                    end: null,
                    time_zone: null
                  }
                }
              }
            ],
            icon: {
              type: 'emoji',
              emoji: '🚀'
            },
            color: 'yellow_background'
          }
        },
        {
          type: 'paragraph',
          data: {
            rich_text: [
              {
                type: 'text',
                text: {
                  content: '这是一个使用 Buildin API 创建的示例页面，展示了如何通过API添加各种类型的块。',
                  link: null
                }
              }
            ]
          }
        },
        {
          type: 'heading_2',
          data: {
            rich_text: [
              {
                type: 'text',
                text: {
                  content: '📌 任务列表',
                  link: null
                }
              }
            ]
          }
        },
        {
          type: 'to_do',
          data: {
            rich_text: [
              {
                type: 'text',
                text: {
                  content: '完成API接口开发',
                  link: null
                }
              }
            ],
            checked: true
          }
        },
        {
          type: 'to_do',
          data: {
            rich_text: [
              {
                type: 'text',
                text: {
                  content: '编写API文档',
                  link: null
                }
              }
            ],
            checked: false
          }
        },
        {
          type: 'to_do',
          data: {
            rich_text: [
              {
                type: 'text',
                text: {
                  content: '开发SDK示例',
                  link: null
                }
              }
            ],
            checked: false
          }
        },
        {
          type: 'heading_2',
          data: {
            rich_text: [
              {
                type: 'text',
                text: {
                  content: '📊 项目进度',
                  link: null
                }
              }
            ]
          }
        },
        {
          type: 'bulleted_list_item',
          data: {
            rich_text: [
              {
                type: 'text',
                text: {
                  content: '需求分析：',
                  link: null
                },
                annotations: {
                  bold: true
                }
              },
              {
                type: 'text',
                text: {
                  content: '100%',
                  link: null
                }
              }
            ]
          }
        },
        {
          type: 'bulleted_list_item',
          data: {
            rich_text: [
              {
                type: 'text',
                text: {
                  content: '设计阶段：',
                  link: null
                },
                annotations: {
                  bold: true
                }
              },
              {
                type: 'text',
                text: {
                  content: '80%',
                  link: null
                }
              }
            ]
          }
        },
        {
          type: 'bulleted_list_item',
          data: {
            rich_text: [
              {
                type: 'text',
                text: {
                  content: '开发阶段：',
                  link: null
                },
                annotations: {
                  bold: true
                }
              },
              {
                type: 'text',
                text: {
                  content: '50%',
                  link: null
                }
              }
            ]
          }
        },
        {
          type: 'bulleted_list_item',
          data: {
            rich_text: [
              {
                type: 'text',
                text: {
                  content: '测试阶段：',
                  link: null
                },
                annotations: {
                  bold: true
                }
              },
              {
                type: 'text',
                text: {
                  content: '20%',
                  link: null
                }
              }
            ]
          }
        },
        {
          type: 'heading_2',
          data: {
            rich_text: [
              {
                type: 'text',
                text: {
                  content: '📝 会议记录',
                  link: null
                }
              }
            ]
          }
        },
        {
          type: 'numbered_list_item',
          data: {
            rich_text: [
              {
                type: 'text',
                text: {
                  content: '讨论了API设计方案，确定了RESTful风格',
                  link: null
                }
              }
            ]
          }
        },
        {
          type: 'numbered_list_item',
          data: {
            rich_text: [
              {
                type: 'text',
                text: {
                  content: '确定了权限控制策略',
                  link: null
                }
              }
            ]
          }
        },
        {
          type: 'numbered_list_item',
          data: {
            rich_text: [
              {
                type: 'text',
                text: {
                  content: '计划下周开始进行性能测试',
                  link: null
                }
              }
            ]
          }
        },
        {
          type: 'divider',
          data: {}
        },
        {
          type: 'quote',
          data: {
            rich_text: [
              {
                type: 'text',
                text: {
                  content: '好的开始是成功的一半。',
                  link: null
                },
                annotations: {
                  italic: true
                }
              }
            ]
          }
        },
        {
          type: 'code',
          data: {
            rich_text: [
              {
                type: 'text',
                text: {
                  content: 'const api = new BuildinApi();\nconst result = await api.createPage(pageData);\nconsole.log("Page created:", result.id);',
                  link: null
                }
              }
            ],
            language: 'javascript'
          }
        },
        {
          type: 'table',
          data: {
            table_width: 3,
            has_column_header: true,
            has_row_header: false,
            children: [
              {
                type: 'table_row',
                data: {
                  cells: [
                    [
                      {
                        type: 'text',
                        text: {
                          content: '功能',
                          link: null
                        },
                        annotations: {
                          bold: true
                        }
                      }
                    ],
                    [
                      {
                        type: 'text',
                        text: {
                          content: '状态',
                          link: null
                        },
                        annotations: {
                          bold: true
                        }
                      }
                    ],
                    [
                      {
                        type: 'text',
                        text: {
                          content: '负责人',
                          link: null
                        },
                        annotations: {
                          bold: true
                        }
                      }
                    ]
                  ]
                }
              },
              {
                type: 'table_row',
                data: {
                  cells: [
                    [
                      {
                        type: 'text',
                        text: {
                          content: '用户认证',
                          link: null
                        }
                      }
                    ],
                    [
                      {
                        type: 'text',
                        text: {
                          content: '完成',
                          link: null
                        }
                      }
                    ],
                    [
                      {
                        type: 'text',
                        text: {
                          content: '张三',
                          link: null
                        }
                      }
                    ]
                  ]
                }
              },
              {
                type: 'table_row',
                data: {
                  cells: [
                    [
                      {
                        type: 'text',
                        text: {
                          content: '数据同步',
                          link: null
                        }
                      }
                    ],
                    [
                      {
                        type: 'text',
                        text: {
                          content: '进行中',
                          link: null
                        }
                      }
                    ],
                    [
                      {
                        type: 'text',
                        text: {
                          content: '李四',
                          link: null
                        }
                      }
                    ]
                  ]
                }
              },
              {
                type: 'table_row',
                data: {
                  cells: [
                    [
                      {
                        type: 'text',
                        text: {
                          content: '性能优化',
                          link: null
                        }
                      }
                    ],
                    [
                      {
                        type: 'text',
                        text: {
                          content: '计划中',
                          link: null
                        }
                      }
                    ],
                    [
                      {
                        type: 'text',
                        text: {
                          content: '王五',
                          link: null
                        }
                      }
                    ]
                  ]
                }
              }
            ]
          }
        }
      ]
    };
    
    console.log('📦 开始添加子块...');
    console.log('子块数量:', childrenData.children.length);
    
    // 调用API添加子块
    const result = await client.appendBlockChildren(blockId, childrenData);
    
    console.log('✅ 子块添加成功！');
    console.log('添加结果:', result);
    
    console.log('\n🎉 添加块子元素演示完成！');
    return result;
    
  } catch (error: any) {
    console.error('❌ 添加块子元素演示失败:', error);
    if (error.response?.data) {
      console.error('详细错误信息:', JSON.stringify(error.response.data, null, 2));
    }
    process.exit(1);
  }
}

// 如果直接运行此文件，则执行演示
if (require.main === module) {
  blockAddChildrenDemo();
}

export default blockAddChildrenDemo; 