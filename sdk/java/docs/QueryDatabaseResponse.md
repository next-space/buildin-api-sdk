

# QueryDatabaseResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**_object** | [**ObjectEnum**](#ObjectEnum) |  |  [optional] |
|**results** | [**List&lt;Page&gt;**](Page.md) |  |  [optional] |
|**nextCursor** | **String** | 下一页游标，使用最后一个项目的ID作为游标值 |  [optional] |
|**hasMore** | **Boolean** |  |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) |  |  [optional] |
|**page** | **Object** |  |  [optional] |



## Enum: ObjectEnum

| Name | Value |
|---- | -----|
| LIST | &quot;list&quot; |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| PAGE | &quot;page&quot; |



