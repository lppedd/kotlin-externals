package zowe.imperative.config.doc

import zowe.imperative.profiles.doc.definition.IProfileSchema
import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface IExtenderTypeInfo {
  var sourceApp: String
  var schema: IProfileSchema
}
