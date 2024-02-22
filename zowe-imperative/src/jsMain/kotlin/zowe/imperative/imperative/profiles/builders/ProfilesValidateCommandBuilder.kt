@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.profiles.builders

import zowe.imperative.cmd.doc.ICommandDefinition
import zowe.imperative.cmd.doc.profiles.definition.ICommandProfileTypeConfiguration
import zowe.imperative.logger.Logger

/**
 * Used to build profile validate command definitions.
 * Used automatically if you allow the "profiles" command group to be generated
 */
external class ProfilesValidateCommandBuilder : ProfilesCommandBuilder {
  /**
   * Construct the builder based on the schema.
   *
   * @param profileType the name of the profile type to build the command for
   * @param logger logger to use while building command definition
   * @param profileConfig Imperative profile configuration for this type of profile
   */
  constructor(profileType: String, logger: Logger, profileConfig: ICommandProfileTypeConfiguration)

  /**
   * Gets the "action" that this command builder is building.
   *
   * @return The "create" action string
   */
  override fun getAction(): String

  /**
   * Build the full command - includes action group and object command.
   *
   * @return The command definition.
   */
  override fun buildFull(): ICommandDefinition

  /**
   * Builds only the "profile" segment from the profile schema.
   */
  override fun buildProfileSegmentFromSchema(): ICommandDefinition
}
