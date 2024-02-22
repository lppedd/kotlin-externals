package zowe.imperative.config.doc

import kotlin.js.plain.JsPlainObject

/**
 * The attributes used to identify the location of a given property
 */
@JsPlainObject
external interface IProfLoc {
  /**
   * The type of location for this property
   */
  var locType: ProfLocType

  /**
   * For OLD_PROFILE and TEAM_CONFIG, this is the path to the file on disk which contains the
   * argument. For ENV, this is the name of the environment variable. This is not used for DEFAULT.
   */
  var osLoc: Array<String>?

  /**
   * For SOURCE_TEAM_CONFIG, this is the dotted path into the JSON configuration object for the
   * profile. This property is not used (undefined) for SOURCE_OLD_PROFILE, because the old-school
   * profiles use a simple name/value pair like:
   *    ArgumentName: value
   * This property is also not used for ENV or DEFAULT.
   */
  var jsonLoc: String?
}
