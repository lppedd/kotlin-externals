@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.auth.builders

import zowe.imperative.cmd.builders.AbstractCommandBuilder
import zowe.imperative.cmd.doc.ICommandDefinition
import zowe.imperative.cmd.doc.profiles.definition.ICommandProfileAuthConfig
import zowe.imperative.logger.Logger

/**
 * Abstract class for generating auth-related commands
 */
abstract external class AuthCommandBuilder : AbstractCommandBuilder {
  /**
   * Construct the builder based on the auth config.
   *
   * @param mProfileType the profile name of the profile type e.g. banana
   * @param mLogger logger instance to use for the builder class
   * @param mAuthConfig the config for the auth type
   */
  constructor(mProfileType: String, mLogger: Logger, mAuthConfig: ICommandProfileAuthConfig)

  var mProfileType: String
  var mLogger: Logger
  var mAuthConfig: ICommandProfileAuthConfig

  /**
   * Auth config for the command.
   */
  var mConfig: ICommandProfileAuthConfig

  /**
   * Build the full command - includes action group and object command.
   *
   * @return The command definition.
   */
  override fun buildFull(): ICommandDefinition

  /**
   * Gets the "action" that this command builder is building.
   *
   * @return The auth action string
   */
  override fun getAction(): String

  /**
   * Only constructs the "group" command segment for the document. Use this if the command
   * definition document already includes an auth verb.
   */
  override fun build(): ICommandDefinition

  /**
   * Builds only the "auth" segment from the auth config.
   */
  open fun buildAuthSegmentFromConfig(): ICommandDefinition
}
