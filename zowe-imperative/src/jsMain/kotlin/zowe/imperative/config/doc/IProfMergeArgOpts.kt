package zowe.imperative.config.doc

import kotlin.js.plain.JsPlainObject

/**
 * Options that will affect the behavior of the ProfileInfo class.
 * They are supplied on the ProfileInfo constructor.
 */
@JsPlainObject
external interface IProfMergeArgOpts {
  /**
   * Indicates whether secure values should be loaded when ProfileInfo.mergeArgsForXXX functions are
   * called. When true, the secure values are contained in the result of the function. When false,
   * placeholders are returned in the result and the calling function must call loadSecureArg() for
   * each such placeholder to get the actual value. The false option is considered more secure
   * because actual secure values will not reside in memory until the calling app explicitly asks
   * for an actual value. The default is false.
   */
  var getSecureVals: Boolean?
}
