package ai.buildin.demo;

import ai.buildin.demo.config.ApiConfig;
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.api.DefaultApi;
import org.openapitools.client.auth.HttpBearerAuth;
import org.openapitools.client.model.*;

import java.util.*;

public class CreateDatabaseDemo {
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

        // 创建数据库请求对象
        CreateDatabaseRequest createDatabaseRequest = new CreateDatabaseRequest();
        
        // 设置标题
        List<RichTextItem> title = new ArrayList<>();
        RichTextItem titleItem = new RichTextItem()
            .type(RichTextItem.TypeEnum.TEXT)
            .text(new RichTextItemText().content("影视剧数据库"));
        title.add(titleItem);
        createDatabaseRequest.setTitle(title);
        
        // 设置图标
        IconEmoji icon = new IconEmoji()
            .type(IconEmoji.TypeEnum.EMOJI)
            .emoji("🎬");
        createDatabaseRequest.setIcon(new Icon(icon));
        
        // 创建属性
        Map<String, PropertySchema> properties = new HashMap<>();
        
        // 添加关联属性
        PropertySchemaRelation relationProperty = new PropertySchemaRelation()
            .name("我的关联")
            .type("relation")
            .relation(new PropertySchemaRelationRelation().databaseId(UUID.fromString("b42115de-ac8e-4e2c-92cc-7c1cb54d0dc6")));
        properties.put("我的关联", new PropertySchema(relationProperty));
        
        // 添加网址属性
        PropertySchemaUrl urlProperty = new PropertySchemaUrl()
            .name("网址")
            .type("url");
        properties.put("网址", new PropertySchema(urlProperty));
        
        // 添加人员属性
        PropertySchemaPeople peopleProperty = new PropertySchemaPeople()
            .name("人员")
            .type("people");
        properties.put("人员", new PropertySchema(peopleProperty));
        
        // 添加已看属性（数字类型）
        PropertySchemaNumber numberProperty1 = new PropertySchemaNumber()
            .name("已看")
            .type("number");
        properties.put("已看", new PropertySchema(numberProperty1));
        
        // 添加公式属性
        PropertySchemaFormula formulaProperty = new PropertySchemaFormula()
            .name("我的公式")
            .type("formula")
            .formula(new PropertySchemaFormulaFormula().expression("prop(\"我的邮箱\") + \"-\" + prop(\"我的电话\")"));
        properties.put("我的公式", new PropertySchema(formulaProperty));
        
        // 添加电话属性
        PropertySchemaPhoneNumber phoneProperty = new PropertySchemaPhoneNumber()
            .name("我的电话")
            .type("phone_number");
        properties.put("我的电话", new PropertySchema(phoneProperty));
        
        // 添加评分属性（数字类型）
        PropertySchemaNumber numberProperty2 = new PropertySchemaNumber()
            .name("评分")
            .type("number");
        properties.put("评分", new PropertySchema(numberProperty2));
        
        // 添加国家属性（选择类型）
        PropertySchemaSelect selectProperty = new PropertySchemaSelect()
            .name("国家")
            .type("select");
        
        PropertySchemaSelectSelect select = new PropertySchemaSelectSelect();
        List<PropertySchemaSelectOption> options = new ArrayList<>();
        
        options.add(new PropertySchemaSelectOption().name("日本").color(PropertySchemaSelectOption.ColorEnum.YELLOW));
        options.add(new PropertySchemaSelectOption().name("中国").color(PropertySchemaSelectOption.ColorEnum.BROWN));
        options.add(new PropertySchemaSelectOption().name("韩国").color(PropertySchemaSelectOption.ColorEnum.ORANGE));
        options.add(new PropertySchemaSelectOption().name("美国").color(PropertySchemaSelectOption.ColorEnum.GRAY));
        options.add(new PropertySchemaSelectOption().name("法国").color(PropertySchemaSelectOption.ColorEnum.PINK));
        options.add(new PropertySchemaSelectOption().name("印度").color(PropertySchemaSelectOption.ColorEnum.PURPLE));
        options.add(new PropertySchemaSelectOption().name("英国").color(PropertySchemaSelectOption.ColorEnum.PURPLE));
        options.add(new PropertySchemaSelectOption().name("德国").color(PropertySchemaSelectOption.ColorEnum.RED));
        options.add(new PropertySchemaSelectOption().name("丹麦").color(PropertySchemaSelectOption.ColorEnum.ORANGE));
        options.add(new PropertySchemaSelectOption().name("意大利").color(PropertySchemaSelectOption.ColorEnum.YELLOW));
        options.add(new PropertySchemaSelectOption().name("泰国").color(PropertySchemaSelectOption.ColorEnum.PURPLE));
        
        select.setOptions(options);
        selectProperty.setSelect(select);
        properties.put("国家", new PropertySchema(selectProperty));
        
        // 添加观看属性（日期类型）
        PropertySchemaDate dateProperty = new PropertySchemaDate()
            .name("观看")
            .type("date");
        properties.put("观看", new PropertySchema(dateProperty));
        
        // 添加邮箱属性
        PropertySchemaEmail emailProperty = new PropertySchemaEmail()
            .name("我的邮箱")
            .type("email");
        properties.put("我的邮箱", new PropertySchema(emailProperty));
        
        // 添加完成属性（复选框类型）
        PropertySchemaCheckbox checkboxProperty = new PropertySchemaCheckbox()
            .name("完成")
            .type("checkbox");
        properties.put("完成", new PropertySchema(checkboxProperty));
        
        // 添加文件媒体属性
        PropertySchemaFiles filesProperty = new PropertySchemaFiles()
            .name("文件媒体")
            .type("files");
        properties.put("文件媒体", new PropertySchema(filesProperty));
        
        // 添加分类属性（多选类型）
        PropertySchemaMultiSelect multiSelectProperty = new PropertySchemaMultiSelect()
            .name("分类")
            .type("multi_select");
        
        PropertySchemaSelectSelect multiSelect = new PropertySchemaSelectSelect();
        List<PropertySchemaSelectOption> multiOptions = new ArrayList<>();
        
        multiOptions.add(new PropertySchemaSelectOption().name("动漫").color(PropertySchemaSelectOption.ColorEnum.GRAY));
        multiOptions.add(new PropertySchemaSelectOption().name("魔幻").color(PropertySchemaSelectOption.ColorEnum.BROWN));
        multiOptions.add(new PropertySchemaSelectOption().name("历史").color(PropertySchemaSelectOption.ColorEnum.ORANGE));
        multiOptions.add(new PropertySchemaSelectOption().name("悬疑").color(PropertySchemaSelectOption.ColorEnum.YELLOW));
        multiOptions.add(new PropertySchemaSelectOption().name("轻松").color(PropertySchemaSelectOption.ColorEnum.BLUE));
        multiOptions.add(new PropertySchemaSelectOption().name("朝堂").color(PropertySchemaSelectOption.ColorEnum.BLUE));
        multiOptions.add(new PropertySchemaSelectOption().name("喜剧").color(PropertySchemaSelectOption.ColorEnum.PURPLE));
        multiOptions.add(new PropertySchemaSelectOption().name("剧情").color(PropertySchemaSelectOption.ColorEnum.PINK));
        multiOptions.add(new PropertySchemaSelectOption().name("现代").color(PropertySchemaSelectOption.ColorEnum.GRAY));
        multiOptions.add(new PropertySchemaSelectOption().name("穿越").color(PropertySchemaSelectOption.ColorEnum.BROWN));
        multiOptions.add(new PropertySchemaSelectOption().name("武侠").color(PropertySchemaSelectOption.ColorEnum.ORANGE));
        multiOptions.add(new PropertySchemaSelectOption().name("仙侠").color(PropertySchemaSelectOption.ColorEnum.YELLOW));
        multiOptions.add(new PropertySchemaSelectOption().name("科幻").color(PropertySchemaSelectOption.ColorEnum.BLUE));
        multiOptions.add(new PropertySchemaSelectOption().name("情感").color(PropertySchemaSelectOption.ColorEnum.BLUE));
        multiOptions.add(new PropertySchemaSelectOption().name("抗战").color(PropertySchemaSelectOption.ColorEnum.PURPLE));
        
        multiSelect.setOptions(multiOptions);
        multiSelectProperty.setMultiSelect(multiSelect);
        properties.put("分类", new PropertySchema(multiSelectProperty));
        
        // 添加进度条属性（数字类型）
        PropertySchemaNumber numberProperty3 = new PropertySchemaNumber()
            .name("进度条")
            .type("number");
        properties.put("进度条", new PropertySchema(numberProperty3));
        
        // 设置属性
        createDatabaseRequest.setProperties(properties);
        
        // 设置是否为内联数据库
        createDatabaseRequest.setIsInline(false);

        try {
            Database result = apiInstance.createDatabase(createDatabaseRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#createDatabase");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
