package zowe.sdk.core.apiml.doc

import kotlin.js.plain.JsPlainObject

/**
 * As part of the auto-init output report, this structure
 * represents the alternate profiles that were not selected
 * for the profile type.
 */
@JsPlainObject
external interface IAltProfile {
  var altProfName: String
  var altProfType: String
  var altBasePath: String
}
