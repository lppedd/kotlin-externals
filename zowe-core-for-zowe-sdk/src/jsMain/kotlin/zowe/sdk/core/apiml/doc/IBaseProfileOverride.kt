package zowe.sdk.core.apiml.doc

import kotlin.js.plain.JsPlainObject

/**
 * As part of the auto-init output report, this structure
 * represents profile properties that override properties
 * defined in the base profile.
 */
@JsPlainObject
external interface IBaseProfileOverride {
  var propName: String
  var secure: Boolean
  var priorityValue: Any?
  var baseValue: Any?
}
