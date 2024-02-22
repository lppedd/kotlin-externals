@file:JsModule("@zowe/imperative")

package zowe.imperative.cmd.builders

import zowe.imperative.cmd.doc.ICommandDefinition

/**
 * profile.schema Command Builder - used in the module loaders to build and append additional
 * profile.schemaside commands as requested by the module definition.
 */
abstract external class AbstractCommandBuilder {
  /**
   * Gets the "action" that this command builder is building.
   *
   * @return The action command group string.
   */
  open fun getAction(): String

  /**
   * Build the full command - includes action group and object command.
   *
   * @return The command definition.
   */
  open fun buildFull(): ICommandDefinition

  /**
   * Only constructs the object command.
   *
   * @return The object command definition.
   */
  open fun build(): ICommandDefinition

  companion object {
    /**
     * Accepts an instance of this class and builds the definition and appends it to the command
     * definition document.
     *
     * @param builder The builder that constructs the definition.
     * @param definition The definition to append to.
     *   Command will be appended to the existing group.
     */
    fun appendToDocument(
      builder: AbstractCommandBuilder,
      definition: ICommandDefinition,
    )
  }
}
