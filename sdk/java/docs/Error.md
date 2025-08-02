

# Error


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**_object** | [**ObjectEnum**](#ObjectEnum) |  |  [optional] |
|**status** | **Integer** |  |  [optional] |
|**code** | [**CodeEnum**](#CodeEnum) |  |  [optional] |
|**message** | **String** |  |  [optional] |



## Enum: ObjectEnum

| Name | Value |
|---- | -----|
| ERROR | &quot;error&quot; |



## Enum: CodeEnum

| Name | Value |
|---- | -----|
| VALIDATION_ERROR | &quot;validation_error&quot; |
| UNAUTHORIZED | &quot;unauthorized&quot; |
| FORBIDDEN | &quot;forbidden&quot; |
| NOT_FOUND | &quot;not_found&quot; |
| RATE_LIMIT | &quot;rate_limit&quot; |
| INTERNAL_ERROR | &quot;internal_error&quot; |



