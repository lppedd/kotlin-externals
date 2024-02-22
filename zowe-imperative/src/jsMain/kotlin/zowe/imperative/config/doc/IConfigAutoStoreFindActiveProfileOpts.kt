package zowe.imperative.config.doc

import zowe.imperative.cmd.doc.handler.IHandlerParameters

/**
 * Defines the options used by the ConfigAutoStore._findActiveProfile function
 */
external interface IConfigAutoStoreFindActiveProfileOpts {
  /**
   * CLI Handler Parameters to use when searching for the active profile
   */
  var params: IHandlerParameters?

  /**
   * List of properties required in the profile schema
   */
  var profileProps: Array<String>?

  /**
   * Optional profile types to look for Used if params == null
   */
  var profileTypes: Array<String>?

  /**
   * Default profile name used if no profiles matched the search for active profiles Used if params
   * == null
   */
  var defaultProfileName: String?
}
