

# Block


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**_object** | [**ObjectEnum**](#ObjectEnum) |  |  [optional] |
|**id** | **UUID** |  |  [optional] |
|**parent** | [**Parent**](Parent.md) |  |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) |  |  [optional] |
|**createdTime** | **OffsetDateTime** |  |  [optional] |
|**createdBy** | [**User**](User.md) |  |  [optional] |
|**lastEditedTime** | **OffsetDateTime** |  |  [optional] |
|**lastEditedBy** | [**User**](User.md) |  |  [optional] |
|**archived** | **Boolean** |  |  [optional] |
|**hasChildren** | **Boolean** |  |  [optional] |
|**data** | [**BlockData**](BlockData.md) |  |  [optional] |



## Enum: ObjectEnum

| Name | Value |
|---- | -----|
| BLOCK | &quot;block&quot; |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| PARAGRAPH | &quot;paragraph&quot; |
| HEADING_1 | &quot;heading_1&quot; |
| HEADING_2 | &quot;heading_2&quot; |
| HEADING_3 | &quot;heading_3&quot; |
| BULLETED_LIST_ITEM | &quot;bulleted_list_item&quot; |
| NUMBERED_LIST_ITEM | &quot;numbered_list_item&quot; |
| TO_DO | &quot;to_do&quot; |
| QUOTE | &quot;quote&quot; |
| TOGGLE | &quot;toggle&quot; |
| CODE | &quot;code&quot; |
| IMAGE | &quot;image&quot; |
| FILE | &quot;file&quot; |
| BOOKMARK | &quot;bookmark&quot; |
| EMBED | &quot;embed&quot; |
| CALLOUT | &quot;callout&quot; |
| EQUATION | &quot;equation&quot; |
| LINK_TO_PAGE | &quot;link_to_page&quot; |
| TEMPLATE | &quot;template&quot; |
| SYNCED_BLOCK | &quot;synced_block&quot; |
| DIVIDER | &quot;divider&quot; |
| COLUMN_LIST | &quot;column_list&quot; |
| COLUMN | &quot;column&quot; |
| TABLE | &quot;table&quot; |
| TABLE_ROW | &quot;table_row&quot; |
| CHILD_PAGE | &quot;child_page&quot; |
| CHILD_DATABASE | &quot;child_database&quot; |



