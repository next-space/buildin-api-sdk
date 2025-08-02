

# Database


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**_object** | [**ObjectEnum**](#ObjectEnum) |  |  [optional] |
|**id** | **UUID** |  |  [optional] |
|**createdTime** | **OffsetDateTime** |  |  [optional] |
|**createdBy** | [**User**](User.md) |  |  [optional] |
|**lastEditedTime** | **OffsetDateTime** |  |  [optional] |
|**lastEditedBy** | [**User**](User.md) |  |  [optional] |
|**title** | [**List&lt;RichTextItem&gt;**](RichTextItem.md) |  |  [optional] |
|**icon** | [**Icon**](Icon.md) |  |  [optional] |
|**cover** | [**Cover**](Cover.md) |  |  [optional] |
|**properties** | [**Map&lt;String, PropertySchema&gt;**](PropertySchema.md) |  |  [optional] |
|**parent** | [**Parent**](Parent.md) |  |  [optional] |
|**url** | **String** |  |  [optional] |
|**archived** | **Boolean** |  |  [optional] |
|**isInline** | **Boolean** |  |  [optional] |



## Enum: ObjectEnum

| Name | Value |
|---- | -----|
| DATABASE | &quot;database&quot; |



