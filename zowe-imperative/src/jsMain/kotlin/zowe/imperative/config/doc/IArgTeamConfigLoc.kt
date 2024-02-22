package zowe.imperative.config.doc

import kotlin.js.plain.JsPlainObject

/**
 * Information to identify the arguments corresponding to the team config
 */
@JsPlainObject
external interface IArgTeamConfigLoc {
  /**
   * the profile name
   */
  var profileName: String

  /**
   * the property name
   */
  var propName: String

  /**
   * the config properties
   */
  var configProperties: IConfig?

  /**
   * the osLoc information
   */
  var osLocInfo: IProfLocOsLoc
}
