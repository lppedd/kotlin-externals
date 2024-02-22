@file:JsModule("@zowe/imperative")

package zowe.imperative.cmd

import zowe.imperative.cmd.doc.ICommandDefinition
import zowe.imperative.cmd.doc.profiles.definition.ICommandProfileTypeConfiguration

/**
 * Command preparer provides static utilities to ensure that command definitions are suitable for
 * Imperative definition.
 */
external class CommandPreparer {
  companion object {
    /**
     * Prepare the command definition and apply any pass on traits to children. After a definition
     * has been prepared, it should be considered final.
     *
     * @param original The original command definition tree to "prepare"
     * @param baseProfile An optional base profile to add to
     *   command definitions
     * @return A copy of the original that has been prepared
     */
    fun prepare(
      original: ICommandDefinition,
      baseProfile: ICommandProfileTypeConfiguration = definedExternally,
    ): ICommandDefinition

    /**
     * Perform preliminary (or post-preparation) basic validation of the command definition tree.
     * Checks to ensure that absoultely necessary fields are populated and invalid combos are not
     * present.
     *
     * @param definitionTree full tree of command definitions to validate
     */
    fun validateDefinitionTree(definitionTree: ICommandDefinition)
  }
}
