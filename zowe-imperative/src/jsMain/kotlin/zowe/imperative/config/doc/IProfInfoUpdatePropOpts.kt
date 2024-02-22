package zowe.imperative.config.doc

import kotlin.js.plain.JsPlainObject

/**
 * Required options to update any property from the ProfileInfo class.
 */
@JsPlainObject
external interface IProfInfoUpdatePropOpts : IProfInfoUpdatePropCommonOpts {
  /**
   * Type of the active profile
   */
  var profileType: String

  /**
   * Name of the active profile
   */
  var profileName: String

  /**
   * Force the update to the profile specified even if the property comes from somehwere else
   *
   * Example: token Value could be in the base profile (not in the service profile specified) and
   *   the programmer has the intention of storing the token in the service profile
   *
   * By default `false` when the property is not specified, the updateProperty method follows current
   *   procedure of updating the property in the known jsonLoc (e.g. base profile). Otherwise, the
   *   updateProperty method updates the specified profile name-type combination.
   */
  var forceUpdate: Boolean?
}
