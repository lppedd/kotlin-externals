package zowe.sdk.core.apiml.doc

import js.objects.Record
import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface IApimlService {
  var serviceId: String
  var status: IApimlServiceStatus
  var apiml: IApimlServiceApiml
  var instances: Array<Record<String, Any>>
}
