package zowe.imperative.config.doc

import kotlin.js.plain.JsPlainObject

/**
 * Required options to update known properties from the ProfileInfo class.
 */
@JsPlainObject
external interface IProfInfoUpdateKnownPropOpts : IProfInfoUpdatePropCommonOpts {
  /**
   * Merged arguments object describing the location of the property to update
   */
  var mergedArgs: IProfMergedArg

  /**
   * Optional osLoc information.
   * This will allow the updateKnownProperty function to switch active layer if needed
   */
  var osLocInfo: IProfLocOsLoc?
}
