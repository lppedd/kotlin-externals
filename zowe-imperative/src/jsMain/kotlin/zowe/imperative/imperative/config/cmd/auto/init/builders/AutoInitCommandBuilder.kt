@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.config.cmd.auto.init.builders

import zowe.imperative.cmd.builders.AbstractCommandBuilder
import zowe.imperative.cmd.doc.ICommandDefinition
import zowe.imperative.cmd.doc.profiles.definition.ICommandProfileAutoInitConfig
import zowe.imperative.logger.Logger

/**
 * Class for generating auth-related commands
 */
external class AutoInitCommandBuilder : AbstractCommandBuilder {
  /**
   * Construct the builder based on the auth config.
   *
   * @param mLogger logger instance to use for the builder class
   * @param mAutoInitConfig the config for the auth type
   * @param mProfileType the profile name of the profile type e.g. banana
   */
  constructor(
    mLogger: Logger,
    mAutoInitConfig: ICommandProfileAutoInitConfig,
    mProfileType: String = definedExternally,
  )

  var mLogger: Logger
  var mAutoInitConfig: ICommandProfileAutoInitConfig
  var mProfileType: String?

  /**
   * Auth config for the command.
   */
  var mConfig: ICommandProfileAutoInitConfig

  /**
   * Build the command
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
   * Build the command
   */
  override fun build(): ICommandDefinition

  /**
   * Builds only the "auto-init" segment from the auto-init config.
   */
  fun buildAutoInitSegmentFromConfig(): ICommandDefinition
}
