import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface IApimlServiceApiInfo {
  var apiId: String
  var gatewayUrl: String
  var swaggerUrl: String
  var documentationUrl: String
  var baseUrl: String
  var basePath: String
  var defaultApi: Boolean
}
