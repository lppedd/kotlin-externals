package zowe.sdk.core.apiml.doc

import zowe.imperative.config.doc.IConfigLayer
import kotlin.js.plain.JsPlainObject

/**
 * This structure is used to form the auto-init output report.
 */
@JsPlainObject
external interface IAutoInitRpt {
  var configFileNm: String
  var changeForConfig: String
  var startingConfig: IConfigLayer
  var endingConfig: IConfigLayer
  var profileRpts: Array<IProfileRpt>
}
