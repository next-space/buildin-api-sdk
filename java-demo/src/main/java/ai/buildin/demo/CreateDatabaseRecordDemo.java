package ai.buildin.demo;

import ai.buildin.demo.config.ApiConfig;
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.api.DefaultApi;
import org.openapitools.client.model.*;

import java.math.BigDecimal;
import java.net.URI;
import java.util.*;


public class CreateDatabaseRecordDemo {
    public static void main(String[] args) throws Exception{
        // 获取API配置
        ApiConfig apiConfig = ApiConfig.getInstance();
        apiConfig.validateAndPrint();
        
        // 配置API客户端
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath(apiConfig.getBasePath());
        
        // 可以是从 CreateDatabaseDemo中创建的多维表
        String databaseId = "c9090054-0204-40dc-ae9f-7392979c6a3d";
        
        // 配置Bearer认证
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken(apiConfig.getBearerToken());

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        
        // 创建页面请求对象
        CreatePageRequest createRecordRequest = new CreatePageRequest();
        
        // 创建属性映射
        Map<String, CreatePagePropertyValue> properties = new HashMap<>();
        
        // 添加标题属性
        CreatePagePropertyValueTitle titleProperty = new CreatePagePropertyValueTitle();
        titleProperty.setType("title");
        List<RichTextItem> titleText = new ArrayList<>();
        RichTextItem titleItem = new RichTextItem()
            .type(RichTextItem.TypeEnum.TEXT)
            .text(new RichTextItemText().content("复活的鲁路修V3"));
        titleText.add(titleItem);
        titleProperty.setTitle(titleText);
        properties.put("title", new CreatePagePropertyValue(titleProperty));
        
        // 添加关联属性
        CreatePagePropertyValueRelation relationProperty = new CreatePagePropertyValueRelation();
        relationProperty.setType("relation");
        List<CreatePagePropertyValueRelationRelationInner> relationList = new ArrayList<>();
        CreatePagePropertyValueRelationRelationInner relation = new CreatePagePropertyValueRelationRelationInner();
        relation.setId(UUID.fromString("bcf00100-d7c9-4c5e-b755-7212bc34c26a"));
        relationList.add(relation);
        relationProperty.setRelation(relationList);
        properties.put("我的关联", new CreatePagePropertyValue(relationProperty));
        
        // 添加网址属性
        CreatePagePropertyValueUrl urlProperty = new CreatePagePropertyValueUrl();
        urlProperty.setType("url");
        urlProperty.setUrl(URI.create("google.com"));
        properties.put("网址", new CreatePagePropertyValue(urlProperty));
        
        // 添加人员属性
        CreatePagePropertyValuePeople peopleProperty = new CreatePagePropertyValuePeople();
        peopleProperty.setType("people");
        List<CreatePagePropertyValuePeoplePeopleInner> peopleList = new ArrayList<>();
        CreatePagePropertyValuePeoplePeopleInner person = new CreatePagePropertyValuePeoplePeopleInner();
        person.setObject(CreatePagePropertyValuePeoplePeopleInner.ObjectEnum.USER);
        person.setId(UUID.fromString("e37e54a2-0278-48bd-a01f-ca3ed32f22bf"));
        peopleList.add(person);
        peopleProperty.setPeople(peopleList);
        properties.put("人员", new CreatePagePropertyValue(peopleProperty));
        
        // 添加已看属性（数字）
        CreatePagePropertyValueNumber numberProperty1 = new CreatePagePropertyValueNumber();
        numberProperty1.setType("number");
        numberProperty1.setNumber(new BigDecimal(12));
        properties.put("已看", new CreatePagePropertyValue(numberProperty1));
        
        // 添加电话属性
        CreatePagePropertyValuePhoneNumber phoneProperty = new CreatePagePropertyValuePhoneNumber();
        phoneProperty.setType("phone_number");
        phoneProperty.setPhoneNumber("13683236049");
        properties.put("我的电话", new CreatePagePropertyValue(phoneProperty));
        
        // 添加评分属性（数字）
        CreatePagePropertyValueNumber numberProperty2 = new CreatePagePropertyValueNumber();
        numberProperty2.setType("number");
        numberProperty2.setNumber(new BigDecimal(67));
        properties.put("评分", new CreatePagePropertyValue(numberProperty2));
        
        // 添加国家属性（选择）
        CreatePagePropertyValueSelect selectProperty = new CreatePagePropertyValueSelect();
        selectProperty.setType("select");
        CreatePagePropertyValueSelectSelect select = new CreatePagePropertyValueSelectSelect();
        select.setId("63214291-be18-403c-9e47-6da9e24e5d91");
        select.setName("日本");
        select.setColor("yellow");
        selectProperty.setSelect(select);
        properties.put("国家", new CreatePagePropertyValue(selectProperty));
        
        // 添加观看属性（日期）
        CreatePagePropertyValueDate dateProperty = new CreatePagePropertyValueDate();
        dateProperty.setType("date");
        CreatePagePropertyValueDateDate date = new CreatePagePropertyValueDateDate();
        date.setStart("2025/07/03T15:16:00");
        date.setEnd(null);
        date.setTimeZone(null);
        dateProperty.setDate(date);
        properties.put("观看", new CreatePagePropertyValue(dateProperty));
        
        // 添加邮箱属性
        CreatePagePropertyValueEmail emailProperty = new CreatePagePropertyValueEmail();
        emailProperty.setType("email");
        emailProperty.setEmail("caokeji@gmail.com");
        properties.put("我的邮箱", new CreatePagePropertyValue(emailProperty));
        
        // 添加完成属性（复选框）
        CreatePagePropertyValueCheckbox checkboxProperty = new CreatePagePropertyValueCheckbox();
        checkboxProperty.setType("checkbox");
        checkboxProperty.setCheckbox(false);
        properties.put("完成", new CreatePagePropertyValue(checkboxProperty));
        
        // 添加分类属性（多选）
        CreatePagePropertyValueMultiSelect multiSelectProperty = new CreatePagePropertyValueMultiSelect();
        multiSelectProperty.setType("multi_select");
        List<CreatePagePropertyValueSelectSelect> multiSelectList = new ArrayList<>();
        
        CreatePagePropertyValueSelectSelect option1 = new CreatePagePropertyValueSelectSelect();
        option1.setId("9d5ca623-36dc-4fbe-bd67-45d0df2c3dbc");
        option1.setName("动漫");
        option1.setColor("grey");
        multiSelectList.add(option1);
        
        CreatePagePropertyValueSelectSelect option2 = new CreatePagePropertyValueSelectSelect();
        option2.setId("c3f86e01-6a64-4bdd-8a09-db8e77f2d489");
        option2.setName("魔幻");
        option2.setColor("brown");
        multiSelectList.add(option2);
        
        multiSelectProperty.setMultiSelect(multiSelectList);
        properties.put("分类", new CreatePagePropertyValue(multiSelectProperty));
        
        // 添加进度条属性（数字）
        CreatePagePropertyValueNumber numberProperty3 = new CreatePagePropertyValueNumber();
        numberProperty3.setType("number");
        numberProperty3.setNumber(new BigDecimal(12));
        properties.put("进度条", new CreatePagePropertyValue(numberProperty3));
        
        // 设置属性
        createRecordRequest.setProperties(properties);
        
        // 设置父级（数据库ID）
        ParentDatabaseId parent = new ParentDatabaseId();
        parent.setType(ParentDatabaseId.TypeEnum.DATABASE_ID);
        parent.setDatabaseId(UUID.fromString(databaseId));
        createRecordRequest.setParent(new Parent(parent));
        
        // 设置图标
        IconEmoji icon = new IconEmoji();
        icon.setType(IconEmoji.TypeEnum.EMOJI);
        icon.setEmoji("😁");
        createRecordRequest.setIcon(new Icon(icon));

        try {
            CreatePageResponse result = apiInstance.createPage(createRecordRequest);
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
