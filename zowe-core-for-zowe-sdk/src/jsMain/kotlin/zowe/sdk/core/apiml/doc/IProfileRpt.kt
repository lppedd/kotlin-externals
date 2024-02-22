package zowe.sdk.core.apiml.doc

import kotlin.js.plain.JsPlainObject

/**
 * As part of the auto-init output report, this structure
 * represents the set of profiles created or modified by
 * the auto-init command.
 */
@JsPlainObject
external interface IProfileRpt {
  var changeForProf: String
  var profName: String
  var profType: String
  var basePath: String
  var pluginNms: Array<String>
  var altProfiles: Array<IAltProfile>
  var baseOverrides: Array<IBaseProfileOverride>
}
