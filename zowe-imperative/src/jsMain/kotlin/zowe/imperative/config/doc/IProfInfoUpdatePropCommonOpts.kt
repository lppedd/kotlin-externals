package zowe.imperative.config.doc

import kotlin.js.plain.JsPlainObject

@JsPlainObject
external interface IProfInfoUpdatePropCommonOpts {
  /**
   * roperty to update
   */
  var property: String

  /**
   * alue to use when updating the given property
   */
  var value: IProfArgValue?

  /**
   * pecifies if the property should be stored securely or not
   */
  var setSecure: Boolean?
}
