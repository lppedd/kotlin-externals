@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.profiles.builders

import zowe.imperative.cmd.builders.AbstractCommandBuilder
import zowe.imperative.cmd.doc.ICommandDefinition
import zowe.imperative.cmd.doc.option.ICommandOptionDefinition
import zowe.imperative.cmd.doc.profiles.definition.ICommandProfileTypeConfiguration
import zowe.imperative.logger.Logger
import zowe.imperative.profiles.doc.definition.IProfileSchema

/**
 * Abstract class for generating profile-related commands
 */
abstract external class ProfilesCommandBuilder : AbstractCommandBuilder {
  /**
   * Construct the builder based on the schema.
   *
   * @param mProfileType the name of the profile type e.g. banana
   * @param mLogger logger instance to use for the builder class
   * @param mProfileConfig The schema that describes the profile
   */
  constructor(
    mProfileType: String,
    mLogger: Logger,
    mProfileConfig: ICommandProfileTypeConfiguration,
  )

  var mProfileType: String
  var mLogger: Logger
  var mProfileConfig: ICommandProfileTypeConfiguration

  /**
   * Schema for the command.
   */
  var mSchema: IProfileSchema

  /**
   * Build the full command - includes action group and object command.
   *
   * @return The command definition.
   */
  override fun buildFull(): ICommandDefinition

  /**
   * Gets the "action" that this command builder is building.
   *
   * @return The "create" action string
   */
  override fun getAction(): String

  /**
   * Only constructs the "group" command segment for the document. Use this if the command
   * definition document already includes a "create" verb.
   */
  override fun build(): ICommandDefinition

  /**
   * Builds only the "profile" segment from the profile schema.
   */
  open fun buildProfileSegmentFromSchema(): ICommandDefinition

  /**
   * Construct the operands from the Bright Profile Schema.
   *
   * @param properties The properties set to iterate over looking for operands to add
   * @param options The final option definitions to add.
   * @return The set of returned option definitions
   */
  open fun buildOptionsFromProfileSchema(
    properties: Any?,
    options: Array<ICommandOptionDefinition>,
  ): Array<ICommandOptionDefinition>
}
