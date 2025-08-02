openapi-generator-cli generate -i openapi.json -g typescript-fetch -o sdk/typescript --additional-properties=modelPropertyNaming=original
cd sdk/typescript
npm install
npm run build