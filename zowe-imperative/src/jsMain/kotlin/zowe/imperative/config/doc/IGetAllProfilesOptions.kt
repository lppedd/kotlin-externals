package zowe.imperative.config.doc

import kotlin.js.plain.JsPlainObject

/**
 * Options that will affect the behavior of the ProfileInfo class. They are supplied on the
 * ProfileInfo getAllProfiles method.
 */
@JsPlainObject
external interface IGetAllProfilesOptions {
  /**
   * Indicates if the home directory should be excluded The default is false.
   */
  var excludeHomeDir: Boolean?
}
