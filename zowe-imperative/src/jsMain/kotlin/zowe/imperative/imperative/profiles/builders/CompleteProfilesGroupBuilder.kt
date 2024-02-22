@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.profiles.builders

import zowe.imperative.cmd.doc.ICommandDefinition
import zowe.imperative.logger.Logger
import zowe.imperative.profiles.doc.config.IProfileTypeConfiguration

/**
 * Generate a complete group of commands for maintaining configuration profiles based on provided
 * profile definitions.
 */
external class CompleteProfilesGroupBuilder {
  companion object {
    /**
     * Get the complete profile group of commands
     *
     * @param profiles the profile configurations to convert to commands
     * @param logger logger to use in the builder classes
     * @return the complete profile group of commands
     */
    fun getProfileGroup(
      profiles: Array<IProfileTypeConfiguration>,
      logger: Logger,
    ): ICommandDefinition
  }
}
