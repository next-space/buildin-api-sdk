package ai.buildin.demo;

import ai.buildin.demo.config.ApiConfig;
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.model.*;
import org.openapitools.client.api.DefaultApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 简化的FlowUs API演示 - 添加块内容
 * 基于用户提供的示例代码
 */
public class BlockAddChildrenDemo {
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
        CreatePageRequest createPageRequest = new CreatePageRequest();
        Cover cover = new Cover().type(Cover.TypeEnum.EXTERNAL)
                .external(new CoverExternal().url("https://cdn2.buildin.ai/assets/_next/static/media/flowers.a6e6c984.svg"));

        createPageRequest.setCover(cover);
        Icon icon = new Icon(new IconEmoji().emoji("📄"));
        createPageRequest.setIcon(icon);
        Map<String, CreatePagePropertyValue> properties = new HashMap<>();
        RichTextItem item = new RichTextItem().type(RichTextItem.TypeEnum.TEXT).text(new RichTextItemText().content("我的新页面"));
        CreatePagePropertyValue titleProperty = new CreatePagePropertyValue(new CreatePagePropertyValueTitle().type("title").addTitleItem(item));
        properties.put("title", titleProperty);
        createPageRequest.setProperties(properties);
        CreatePageResponse response = apiInstance.createPage(createPageRequest);
        UUID newPageId = response.getId();
        System.out.println("新创建页面id: " + newPageId);
        
        // 创建AppendBlockChildrenRequest对象
        AppendBlockChildrenRequest appendBlockChildrenRequest = new AppendBlockChildrenRequest();
        List<AppendBlockChildrenRequestChildrenInner> children = new ArrayList<>();
        
        // 创建标题1块
        AppendBlockChildrenRequestChildrenInner heading1Block = new AppendBlockChildrenRequestChildrenInner();
        heading1Block.setType(AppendBlockChildrenRequestChildrenInner.TypeEnum.HEADING_1);
        BlockData heading1Data = new BlockData();
        List<RichTextItem> heading1RichText = new ArrayList<>();
        RichTextItem heading1TextItem = new RichTextItem();
        heading1TextItem.setType(RichTextItem.TypeEnum.TEXT);
        RichTextItemText heading1Text = new RichTextItemText();
        heading1Text.setContent("📋 项目开发计划");
        heading1Text.setLink(null);
        heading1TextItem.setText(heading1Text);
        RichTextItemAnnotations heading1Annotations = new RichTextItemAnnotations();
        heading1Annotations.setBold(true);
        heading1Annotations.setColor(RichTextItemAnnotations.ColorEnum.BLUE);
        heading1TextItem.setAnnotations(heading1Annotations);
        heading1RichText.add(heading1TextItem);
        heading1Data.setRichText(heading1RichText);
        heading1Data.setTextColor(BlockData.TextColorEnum.BLUE);
        heading1Data.setBackgroundColor(BlockData.BackgroundColorEnum.DEFAULT);
        heading1Block.setData(heading1Data);
        children.add(heading1Block);
        
        // 创建标注块
        AppendBlockChildrenRequestChildrenInner calloutBlock = new AppendBlockChildrenRequestChildrenInner();
        calloutBlock.setType(AppendBlockChildrenRequestChildrenInner.TypeEnum.CALLOUT);
        BlockData calloutData = new BlockData();
        List<RichTextItem> calloutRichText = new ArrayList<>();
        
        // 创建标注块的第一个文本项
        RichTextItem calloutTextItem1 = new RichTextItem();
        calloutTextItem1.setType(RichTextItem.TypeEnum.TEXT);
        RichTextItemText calloutText1 = new RichTextItemText();
        calloutText1.setContent("项目状态：进行中 | 优先级：高 | 预计完成：");
        calloutText1.setLink(null);
        calloutTextItem1.setText(calloutText1);
        calloutRichText.add(calloutTextItem1);
        
        // 创建标注块的日期提及项
        RichTextItem calloutMentionItem = new RichTextItem();
        calloutMentionItem.setType(RichTextItem.TypeEnum.MENTION);
        RichTextItemMention mention = new RichTextItemMention();
        mention.setType(RichTextItemMention.TypeEnum.DATE);
        RichTextItemMentionDate mentionDate = new RichTextItemMentionDate();
        mentionDate.setStart("2023-12-31");
        mentionDate.setEnd(null);
        mentionDate.setTimeZone(null);
        mention.setDate(mentionDate);
        calloutMentionItem.setMention(mention);
        calloutRichText.add(calloutMentionItem);
        
        // 设置标注块图标和颜色
        calloutData.setRichText(calloutRichText);
        Icon calloutIcon = new Icon(new IconEmoji().emoji("📅"));
        calloutData.setIcon(calloutIcon);
        calloutData.setTextColor(BlockData.TextColorEnum.DEFAULT);
        calloutData.setBackgroundColor(BlockData.BackgroundColorEnum.BLUE);
        calloutBlock.setData(calloutData);
        children.add(calloutBlock);
        
        // 创建标题2 - 项目团队
        AppendBlockChildrenRequestChildrenInner heading2Block1 = new AppendBlockChildrenRequestChildrenInner();
        heading2Block1.setType(AppendBlockChildrenRequestChildrenInner.TypeEnum.HEADING_2);
        BlockData heading2Data1 = new BlockData();
        List<RichTextItem> heading2RichText1 = new ArrayList<>();
        RichTextItem heading2TextItem1 = new RichTextItem();
        heading2TextItem1.setType(RichTextItem.TypeEnum.TEXT);
        RichTextItemText heading2Text1 = new RichTextItemText();
        heading2Text1.setContent("项目团队");
        heading2Text1.setLink(null);
        heading2TextItem1.setText(heading2Text1);
        heading2RichText1.add(heading2TextItem1);
        heading2Data1.setRichText(heading2RichText1);
        heading2Block1.setData(heading2Data1);
        children.add(heading2Block1);
        
        // 创建段落 - 项目经理
        AppendBlockChildrenRequestChildrenInner paragraphBlock = new AppendBlockChildrenRequestChildrenInner();
        paragraphBlock.setType(AppendBlockChildrenRequestChildrenInner.TypeEnum.PARAGRAPH);
        BlockData paragraphData = new BlockData();
        List<RichTextItem> paragraphRichText = new ArrayList<>();
        
        // 第一部分文本
        RichTextItem paragraphTextItem1 = new RichTextItem();
        paragraphTextItem1.setType(RichTextItem.TypeEnum.TEXT);
        RichTextItemText paragraphText1 = new RichTextItemText();
        paragraphText1.setContent("项目经理：");
        paragraphText1.setLink(null);
        paragraphTextItem1.setText(paragraphText1);
        paragraphRichText.add(paragraphTextItem1);
        
        // 用户提及
        RichTextItem paragraphMentionItem1 = new RichTextItem();
        paragraphMentionItem1.setType(RichTextItem.TypeEnum.MENTION);
        RichTextItemMention userMention1 = new RichTextItemMention();
        userMention1.setType(RichTextItemMention.TypeEnum.USER);
        RichTextItemMentionUser mentionUser1 = new RichTextItemMentionUser();
        mentionUser1.setId(UUID.fromString("4e104bb5-c32f-49c1-b7b7-3f83b9395c21"));
        userMention1.setUser(mentionUser1);
        paragraphMentionItem1.setMention(userMention1);
        paragraphRichText.add(paragraphMentionItem1);
        
        // 第二部分文本
        RichTextItem paragraphTextItem2 = new RichTextItem();
        paragraphTextItem2.setType(RichTextItem.TypeEnum.TEXT);
        RichTextItemText paragraphText2 = new RichTextItemText();
        paragraphText2.setContent(" | 技术负责人：");
        paragraphText2.setLink(null);
        paragraphTextItem2.setText(paragraphText2);
        paragraphRichText.add(paragraphTextItem2);
        
        // 用户提及2
        RichTextItem paragraphMentionItem2 = new RichTextItem();
        paragraphMentionItem2.setType(RichTextItem.TypeEnum.MENTION);
        RichTextItemMention userMention2 = new RichTextItemMention();
        userMention2.setType(RichTextItemMention.TypeEnum.USER);
        RichTextItemMentionUser mentionUser2 = new RichTextItemMentionUser();
        mentionUser2.setId(UUID.fromString("4e104bb5-c32f-49c1-b7b7-3f83b9395c21"));
        userMention2.setUser(mentionUser2);
        paragraphMentionItem2.setMention(userMention2);
        paragraphRichText.add(paragraphMentionItem2);
        
        paragraphData.setRichText(paragraphRichText);
        paragraphBlock.setData(paragraphData);
        children.add(paragraphBlock);
        
        // 创建标题2 - 任务清单
        AppendBlockChildrenRequestChildrenInner heading2Block2 = new AppendBlockChildrenRequestChildrenInner();
        heading2Block2.setType(AppendBlockChildrenRequestChildrenInner.TypeEnum.HEADING_2);
        BlockData heading2Data2 = new BlockData();
        List<RichTextItem> heading2RichText2 = new ArrayList<>();
        RichTextItem heading2TextItem2 = new RichTextItem();
        heading2TextItem2.setType(RichTextItem.TypeEnum.TEXT);
        RichTextItemText heading2Text2 = new RichTextItemText();
        heading2Text2.setContent("任务清单");
        heading2Text2.setLink(null);
        heading2TextItem2.setText(heading2Text2);
        heading2RichText2.add(heading2TextItem2);
        heading2Data2.setRichText(heading2RichText2);
        heading2Block2.setData(heading2Data2);
        children.add(heading2Block2);
        
        // 创建待办事项1 - 已完成
        AppendBlockChildrenRequestChildrenInner todoBlock1 = new AppendBlockChildrenRequestChildrenInner();
        todoBlock1.setType(AppendBlockChildrenRequestChildrenInner.TypeEnum.TO_DO);
        BlockData todoData1 = new BlockData();
        List<RichTextItem> todoRichText1 = new ArrayList<>();
        RichTextItem todoTextItem1 = new RichTextItem();
        todoTextItem1.setType(RichTextItem.TypeEnum.TEXT);
        RichTextItemText todoText1 = new RichTextItemText();
        todoText1.setContent("需求分析和设计");
        todoText1.setLink(null);
        todoTextItem1.setText(todoText1);
        todoRichText1.add(todoTextItem1);
        todoData1.setRichText(todoRichText1);
        todoData1.setChecked(true);
        todoData1.setTextColor(BlockData.TextColorEnum.GREEN);
        todoData1.setBackgroundColor(BlockData.BackgroundColorEnum.DEFAULT);
        todoBlock1.setData(todoData1);
        children.add(todoBlock1);
        
        // 创建待办事项2
        AppendBlockChildrenRequestChildrenInner todoBlock2 = new AppendBlockChildrenRequestChildrenInner();
        todoBlock2.setType(AppendBlockChildrenRequestChildrenInner.TypeEnum.TO_DO);
        BlockData todoData2 = new BlockData();
        List<RichTextItem> todoRichText2 = new ArrayList<>();
        RichTextItem todoTextItem2 = new RichTextItem();
        todoTextItem2.setType(RichTextItem.TypeEnum.TEXT);
        RichTextItemText todoText2 = new RichTextItemText();
        todoText2.setContent("前端开发");
        todoText2.setLink(null);
        todoTextItem2.setText(todoText2);
        todoRichText2.add(todoTextItem2);
        todoData2.setRichText(todoRichText2);
        todoData2.setChecked(false);
        todoData2.setTextColor(BlockData.TextColorEnum.ORANGE);
        todoData2.setBackgroundColor(BlockData.BackgroundColorEnum.DEFAULT);
        todoBlock2.setData(todoData2);
        children.add(todoBlock2);
        
        // 创建待办事项3
        AppendBlockChildrenRequestChildrenInner todoBlock3 = new AppendBlockChildrenRequestChildrenInner();
        todoBlock3.setType(AppendBlockChildrenRequestChildrenInner.TypeEnum.TO_DO);
        BlockData todoData3 = new BlockData();
        List<RichTextItem> todoRichText3 = new ArrayList<>();
        RichTextItem todoTextItem3 = new RichTextItem();
        todoTextItem3.setType(RichTextItem.TypeEnum.TEXT);
        RichTextItemText todoText3 = new RichTextItemText();
        todoText3.setContent("后端API开发");
        todoText3.setLink(null);
        todoTextItem3.setText(todoText3);
        todoRichText3.add(todoTextItem3);
        todoData3.setRichText(todoRichText3);
        todoData3.setChecked(false);
        todoData3.setTextColor(BlockData.TextColorEnum.RED);
        todoData3.setBackgroundColor(BlockData.BackgroundColorEnum.DEFAULT);
        todoBlock3.setData(todoData3);
        children.add(todoBlock3);
        
        // 创建待办事项4
        AppendBlockChildrenRequestChildrenInner todoBlock4 = new AppendBlockChildrenRequestChildrenInner();
        todoBlock4.setType(AppendBlockChildrenRequestChildrenInner.TypeEnum.TO_DO);
        BlockData todoData4 = new BlockData();
        List<RichTextItem> todoRichText4 = new ArrayList<>();
        RichTextItem todoTextItem4 = new RichTextItem();
        todoTextItem4.setType(RichTextItem.TypeEnum.TEXT);
        RichTextItemText todoText4 = new RichTextItemText();
        todoText4.setContent("测试和部署");
        todoText4.setLink(null);
        todoTextItem4.setText(todoText4);
        todoRichText4.add(todoTextItem4);
        todoData4.setRichText(todoRichText4);
        todoData4.setChecked(false);
        todoData4.setTextColor(BlockData.TextColorEnum.DEFAULT);
        todoData4.setBackgroundColor(BlockData.BackgroundColorEnum.DEFAULT);
        todoBlock4.setData(todoData4);
        children.add(todoBlock4);
        
        // 创建分割线
        AppendBlockChildrenRequestChildrenInner dividerBlock = new AppendBlockChildrenRequestChildrenInner();
        dividerBlock.setType(AppendBlockChildrenRequestChildrenInner.TypeEnum.DIVIDER);
        dividerBlock.setData(new BlockData());
        children.add(dividerBlock);
        
        // 创建标题2 - 技术栈
        AppendBlockChildrenRequestChildrenInner heading2Block3 = new AppendBlockChildrenRequestChildrenInner();
        heading2Block3.setType(AppendBlockChildrenRequestChildrenInner.TypeEnum.HEADING_2);
        BlockData heading2Data3 = new BlockData();
        List<RichTextItem> heading2RichText3 = new ArrayList<>();
        RichTextItem heading2TextItem3 = new RichTextItem();
        heading2TextItem3.setType(RichTextItem.TypeEnum.TEXT);
        RichTextItemText heading2Text3 = new RichTextItemText();
        heading2Text3.setContent("技术栈");
        heading2Text3.setLink(null);
        heading2TextItem3.setText(heading2Text3);
        heading2RichText3.add(heading2TextItem3);
        heading2Data3.setRichText(heading2RichText3);
        heading2Block3.setData(heading2Data3);
        children.add(heading2Block3);
        
        // 创建项目符号列表1
        AppendBlockChildrenRequestChildrenInner bulletBlock1 = new AppendBlockChildrenRequestChildrenInner();
        bulletBlock1.setType(AppendBlockChildrenRequestChildrenInner.TypeEnum.BULLETED_LIST_ITEM);
        BlockData bulletData1 = new BlockData();
        List<RichTextItem> bulletRichText1 = new ArrayList<>();
        RichTextItem bulletTextItem1 = new RichTextItem();
        bulletTextItem1.setType(RichTextItem.TypeEnum.TEXT);
        RichTextItemText bulletText1 = new RichTextItemText();
        bulletText1.setContent("前端：React + TypeScript");
        bulletText1.setLink(null);
        bulletTextItem1.setText(bulletText1);
        RichTextItemAnnotations bulletAnnotations1 = new RichTextItemAnnotations();
        bulletAnnotations1.setCode(true);
        bulletTextItem1.setAnnotations(bulletAnnotations1);
        bulletRichText1.add(bulletTextItem1);
        bulletData1.setRichText(bulletRichText1);
        bulletBlock1.setData(bulletData1);
        children.add(bulletBlock1);
        
        // 创建项目符号列表2
        AppendBlockChildrenRequestChildrenInner bulletBlock2 = new AppendBlockChildrenRequestChildrenInner();
        bulletBlock2.setType(AppendBlockChildrenRequestChildrenInner.TypeEnum.BULLETED_LIST_ITEM);
        BlockData bulletData2 = new BlockData();
        List<RichTextItem> bulletRichText2 = new ArrayList<>();
        RichTextItem bulletTextItem2 = new RichTextItem();
        bulletTextItem2.setType(RichTextItem.TypeEnum.TEXT);
        RichTextItemText bulletText2 = new RichTextItemText();
        bulletText2.setContent("后端：Node.js + Express");
        bulletText2.setLink(null);
        bulletTextItem2.setText(bulletText2);
        RichTextItemAnnotations bulletAnnotations2 = new RichTextItemAnnotations();
        bulletAnnotations2.setCode(true);
        bulletTextItem2.setAnnotations(bulletAnnotations2);
        bulletRichText2.add(bulletTextItem2);
        bulletData2.setRichText(bulletRichText2);
        bulletBlock2.setData(bulletData2);
        children.add(bulletBlock2);
        
        // 创建项目符号列表3
        AppendBlockChildrenRequestChildrenInner bulletBlock3 = new AppendBlockChildrenRequestChildrenInner();
        bulletBlock3.setType(AppendBlockChildrenRequestChildrenInner.TypeEnum.BULLETED_LIST_ITEM);
        BlockData bulletData3 = new BlockData();
        List<RichTextItem> bulletRichText3 = new ArrayList<>();
        RichTextItem bulletTextItem3 = new RichTextItem();
        bulletTextItem3.setType(RichTextItem.TypeEnum.TEXT);
        RichTextItemText bulletText3 = new RichTextItemText();
        bulletText3.setContent("数据库：PostgreSQL");
        bulletText3.setLink(null);
        bulletTextItem3.setText(bulletText3);
        RichTextItemAnnotations bulletAnnotations3 = new RichTextItemAnnotations();
        bulletAnnotations3.setCode(true);
        bulletTextItem3.setAnnotations(bulletAnnotations3);
        bulletRichText3.add(bulletTextItem3);
        bulletData3.setRichText(bulletRichText3);
        bulletBlock3.setData(bulletData3);
        children.add(bulletBlock3);
        
        // 创建表格
        AppendBlockChildrenRequestChildrenInner tableBlock = new AppendBlockChildrenRequestChildrenInner();
        tableBlock.setType(AppendBlockChildrenRequestChildrenInner.TypeEnum.TABLE);
        BlockData tableData = new BlockData();
        tableData.setTableWidth(3);
        tableData.setHasColumnHeader(false);
        tableData.setHasRowHeader(true);
        tableBlock.setData(tableData);
        children.add(tableBlock);
        
        // 设置请求的子块列表
        appendBlockChildrenRequest.setChildren(children);

        try {
            // 调用API添加子块
            AppendBlockChildrenResponse result = apiInstance.appendBlockChildren(newPageId, appendBlockChildrenRequest);

            System.out.println("✅ 成功添加子块！");
            System.out.println("结果: " + result);
            System.out.println("添加的块数量: " + result.getResults().size());

            // 打印新添加的块信息
            for (Block block : result.getResults()) {
                System.out.println("新块ID: " + block.getId());
                System.out.println("块类型: " + block.getType());
                System.out.println("创建时间: " + block.getCreatedTime());
            }

        } catch (ApiException e) {
            System.err.println("❌ 调用API失败");
            System.err.println("状态码: " + e.getCode());
            System.err.println("错误信息: " + e.getResponseBody());
            System.err.println("响应头: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}