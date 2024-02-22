@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.auth.builders

import zowe.imperative.cmd.doc.ICommandDefinition

/**
 * Used to build auth logout command definitions.
 * Used automatically if you allow the "auth" command group to be generated
 */
external class AuthLogoutCommandBuilder : AuthCommandBuilder {
  /**
   * Gets the "action" that this command builder is building.
   *
   * @return The "logout" action string
   */
  override fun getAction(): String

  /**
   * Build the full command - includes action group and object command.
   *
   * @return The command definition.
   */
  override fun buildFull(): ICommandDefinition

  /**
   * Builds only the "auth" segment from the auth config.
   */
  override fun buildAuthSegmentFromConfig(): ICommandDefinition
}
