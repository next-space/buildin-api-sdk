# Buildin API SDK

Official TypeScript/JavaScript SDK for the Buildin API. Create, manage, and interact with Buildin pages, databases, and blocks programmatically.

## Installation

```bash
npm install buildin-api-sdk
```

## Quick Start

```typescript
import { DefaultApi, Configuration } from 'buildin-api-sdk';

// Initialize the API client
const config = new Configuration({
  basePath: 'https://api.buildin.ai',
  headers: {
    'Authorization': 'Bearer YOUR_API_TOKEN'
  }
});

const api = new DefaultApi(config);

// Create a new page
const newPage = await api.createPage({
  parent: {
    type: 'page_id',
    page_id: 'parent-page-id'
  },
  properties: {
    title: {
      type: 'title',
      title: [{
        type: 'text',
        text: { content: 'My New Page' }
      }]
    }
  }
});

console.log('Created page:', newPage.id);
```

## Authentication

To use the Buildin API, you need to obtain an API token:

1. Log in to your Buildin account
2. Go to Settings → Integrations
3. Create a new integration and copy the token
4. Use the token in your API requests

## Available Methods

### Pages
- `createPage()` - Create a new page
- `updatePage()` - Update an existing page
- `queryDatabase()` - Query a database

### Blocks
- `getBlockChildren()` - Get child blocks of a page/block
- `appendBlockChildren()` - Add child blocks to a page/block
- `updateBlock()` - Update a block
- `deleteBlock()` - Delete a block

### Databases
- `createDatabase()` - Create a new database
- `updateDatabase()` - Update database properties

### Search
- `search()` - Search for pages and databases

## TypeScript Support

This SDK is written in TypeScript and includes full type definitions for all API methods and response objects.

```typescript
import { Block, Page, Database } from 'buildin-api-sdk';

// All types are fully typed
const page: Page = await api.getPage('page-id');
const blocks: Block[] = await api.getBlockChildren('block-id');
```

## Error Handling

```typescript
try {
  const page = await api.createPage(pageData);
  console.log('Page created successfully');
} catch (error) {
  if (error.status === 401) {
    console.error('Invalid API token');
  } else if (error.status === 404) {
    console.error('Resource not found');
  } else {
    console.error('API error:', error.message);
  }
}
```

## Examples

Check out the [examples directory](../../typescript-demo) for complete usage examples including:

- Creating and managing pages
- Working with databases
- Adding and updating blocks
- Searching content

## API Reference

For detailed API documentation, visit: [Buildin API Documentation](https://buildin.ai/share/480fea3b-bf25-478c-8c33-111c002defdc)

## Contributing

We welcome contributions! Please see our [Contributing Guide](../../CONTRIBUTING.md) for details.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Support

- 📧 Email: support@buildin.ai
- 📚 Documentation: https://buildin.ai/share/480fea3b-bf25-478c-8c33-111c002defdc
- 🐛 Issues: https://github.com/next-space/buildin-api-sdk/issues
