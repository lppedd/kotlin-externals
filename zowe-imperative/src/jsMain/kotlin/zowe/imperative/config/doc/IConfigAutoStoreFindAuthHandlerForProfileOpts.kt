package zowe.imperative.config.doc

import zowe.imperative.cmd.doc.args.ICommandArguments
import zowe.imperative.config.Config

/**
 * Defines the options used by the ConfigAutoStore._findAuthHandlerForProfile function
 */
external interface IConfigAutoStoreFindAuthHandlerForProfileOpts : IConfigAutoStoreFindActiveProfileOpts {
  /**
   * JSON path of profile
   */
  var profilePath: String?

  /**
   * CLI arguments which may specify a profile
   */
  var cmdArguments: ICommandArguments?

  /**
   * Default base profile name Used if cmdArguments == null
   */
  var defaultBaseProfileName: String?

  /**
   * Team configuration properties Overrides `ImperativeConfig.instance.config`
   */
  var config: Config?
}
