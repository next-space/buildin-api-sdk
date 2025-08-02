

# CreatePageResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**_object** | [**ObjectEnum**](#ObjectEnum) |  |  [optional] |
|**id** | **UUID** | 页面ID |  [optional] |
|**createdAt** | **OffsetDateTime** | 创建时间 |  [optional] |
|**createdBy** | [**CreatePageResponseCreatedBy**](CreatePageResponseCreatedBy.md) |  |  [optional] |
|**updatedAt** | **OffsetDateTime** | 更新时间 |  [optional] |
|**updatedBy** | [**CreatePageResponseUpdatedBy**](CreatePageResponseUpdatedBy.md) |  |  [optional] |
|**archived** | **Boolean** | 是否已归档 |  [optional] |
|**properties** | [**Map&lt;String, PropertyValue&gt;**](PropertyValue.md) | 页面属性值 |  [optional] |
|**parent** | [**CreatePageResponseParent**](CreatePageResponseParent.md) |  |  [optional] |
|**url** | **URI** | 页面访问URL |  [optional] |



## Enum: ObjectEnum

| Name | Value |
|---- | -----|
| PAGE | &quot;page&quot; |



