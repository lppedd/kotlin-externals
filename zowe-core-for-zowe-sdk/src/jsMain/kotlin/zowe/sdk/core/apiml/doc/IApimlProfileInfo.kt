package zowe.sdk.core.apiml.doc

import js.collections.JsSet
import js.objects.Record
import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface IApimlProfileInfo {
  var profName: String
  var profType: String
  var basePaths: Array<String>
  var pluginConfigs: JsSet<IApimlSvcAttrsLoaded>
  var gatewayUrlConflicts: Record<String, Array<String>>
}
