package zowe.sdk.core.apiml.doc

import IApimlServiceApiInfo
import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface IApimlServiceApiml {
  var apiInfo: Array<IApimlServiceApiInfo>
  var service: IApimlServiceInfo
  var authentication: Array<IApimlServiceAuthentication>
}
