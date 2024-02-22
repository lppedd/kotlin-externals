package zowe.sdk.core.apiml.doc

import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface IApimlServiceInfo {
  var title: String
  var description: String
  var homePageUrl: String
}
