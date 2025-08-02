

# BlockData

块类型特定的数据内容

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**richText** | [**List&lt;RichTextItem&gt;**](RichTextItem.md) | 富文本内容 |  [optional] |
|**textColor** | [**TextColorEnum**](#TextColorEnum) | 文本颜色 |  [optional] |
|**backgroundColor** | [**BackgroundColorEnum**](#BackgroundColorEnum) | 背景颜色 |  [optional] |
|**checked** | **Boolean** | 待办事项是否完成 |  [optional] |
|**language** | **String** | 代码块语言 |  [optional] |
|**url** | **String** | 链接地址 |  [optional] |
|**caption** | [**List&lt;RichTextItem&gt;**](RichTextItem.md) | 说明文字 |  [optional] |
|**icon** | [**Icon**](Icon.md) | 图标 |  [optional] |
|**expression** | **String** | 数学公式表达式 |  [optional] |
|**pageId** | **UUID** | 页面引用ID |  [optional] |
|**tableWidth** | **Integer** | 表格列数 |  [optional] |
|**hasColumnHeader** | **Boolean** | 是否有列标题 |  [optional] |
|**hasRowHeader** | **Boolean** | 是否有行标题 |  [optional] |
|**cells** | **List&lt;List&lt;RichTextItem&gt;&gt;** | 表格单元格内容 |  [optional] |
|**title** | **String** | 子页面或子数据库标题 |  [optional] |
|**syncedFrom** | [**BlockDataSyncedFrom**](BlockDataSyncedFrom.md) |  |  [optional] |
|**_file** | [**BlockDataFile**](BlockDataFile.md) |  |  [optional] |
|**external** | [**BlockDataExternal**](BlockDataExternal.md) |  |  [optional] |



## Enum: TextColorEnum

| Name | Value |
|---- | -----|
| DEFAULT | &quot;default&quot; |
| GRAY | &quot;gray&quot; |
| BROWN | &quot;brown&quot; |
| ORANGE | &quot;orange&quot; |
| YELLOW | &quot;yellow&quot; |
| GREEN | &quot;green&quot; |
| BLUE | &quot;blue&quot; |
| PURPLE | &quot;purple&quot; |
| PINK | &quot;pink&quot; |
| RED | &quot;red&quot; |



## Enum: BackgroundColorEnum

| Name | Value |
|---- | -----|
| DEFAULT | &quot;default&quot; |
| GRAY | &quot;gray&quot; |
| BROWN | &quot;brown&quot; |
| ORANGE | &quot;orange&quot; |
| YELLOW | &quot;yellow&quot; |
| GREEN | &quot;green&quot; |
| BLUE | &quot;blue&quot; |
| PURPLE | &quot;purple&quot; |
| PINK | &quot;pink&quot; |
| RED | &quot;red&quot; |



