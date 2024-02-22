@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.profiles.builders

import zowe.imperative.cmd.doc.ICommandDefinition

/**
 * Used to build "set default profile" command definitions.
 * Used automatically if you allow the "profiles" command group to be generated
 */
external class ProfilesSetCommandBuilder : ProfilesCommandBuilder {
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
