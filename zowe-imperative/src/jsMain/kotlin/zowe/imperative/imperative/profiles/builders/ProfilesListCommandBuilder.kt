@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.profiles.builders

import zowe.imperative.cmd.doc.ICommandDefinition
import zowe.imperative.cmd.doc.profiles.definition.ICommandProfileTypeConfiguration
import zowe.imperative.logger.Logger

/**
 * Used to build profile update command definitions.
 * Used automatically if you allow the "profiles" command group to be generated
 */
external class ProfilesListCommandBuilder : ProfilesCommandBuilder {
  /**
   * Construct the builder based on the schema.
   *
   * @param profileType the profile type to generate the command definition for
   * @param logger logger instance to use for the builder class
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
