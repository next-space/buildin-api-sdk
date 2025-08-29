## 🛠️ 生成新的 SDK
### typescript
``` bash
./buildJavascriptSdk.sh
cd sdk/typescript && npm run build
npm whoami
npm publish
npm view buildin-api-sdk
```
### Java
``` bash
./buildJavaSdk.sh
cd sdk/java
mvn clean deploy -P central
```