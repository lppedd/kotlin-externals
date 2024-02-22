@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.config.cmd.auto.init.builders

import zowe.imperative.cmd.doc.ICommandDefinition
import zowe.imperative.cmd.doc.profiles.definition.ICommandProfileAutoInitConfig
import zowe.imperative.logger.Logger

/**
 * Generate a complete command for automatic initialization of a user configuration
 */
external class CompleteAutoInitCommandBuilder {
  companion object {
    /**
     * Get the complete auth group of commands
     *
     * @param autoInitConfig mapping of profile types to auto init configs
     * @param logger logger to use in the builder classes
     * @return the complete profile group of commands
     */
    fun getAutoInitCommand(
      autoInitConfig: ICommandProfileAutoInitConfig,
      logger: Logger,
    ): ICommandDefinition
  }
}
