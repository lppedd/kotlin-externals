@file:JsModule("@zowe/imperative")

package zowe.imperative.cmd.utils

import zowe.imperative.cmd.doc.ICommandDefinition
import zowe.imperative.cmd.doc.args.ICommandArguments
import zowe.imperative.cmd.doc.option.ICommandOptionDefinition

/**
 * Command utility class. Place static utils for command processing here.
 */
external class CommandUtils {
  companion object {
    /**
     * Get a representation of the original command as issued by the user .with all canonical forms
     * of options specified. You only need to supply the "command" segement of your command. The
     * "full command" (including previous groups, etc.) is extracted from the yargs arguments object
     * "_" property.
     *
     * @param commandArguments The Yargs style argument object. Requires the "_" (input argv)
     * @param commandDefinition The command definition document
     * @return The reconstructed command (as would have been issued on the console).
     *
     * TODO: Replace "maincommand" below with the name of the bin - This is new to Imperative.
     */
    fun reconstructCommand(
      commandArguments: ICommandArguments, // TODO(Edoardo): replace with Arguments from yargs
      commandDefinition: ICommandDefinition,
    ): String

    /**
     * Check if an option was specified by the user.
     *
     * @param optionName the option to check for.
     * @param args The arguments specified by the user.
     * @param commandDefinition the definition for the command
     * @return true: the option was specified by the user.
     *   false: the option was omitted/set to false
     */
    fun optionWasSpecified(
      optionName: String,
      commandDefinition: ICommandDefinition,
      args: Any?,
    ): Boolean

    /**
     * Find the option definition from the .options field of the command definition
     *
     * @param optionName
     * @param commandDefinition the definition for the command
     * @return if the optionName is an option, the definition of the option, otherwise undefined
     */
    fun getOptionDefinitionFromName(
      optionName: String,
      commandDefinition: ICommandDefinition,
    ): ICommandOptionDefinition

    /**
     * Accepts the command definition document tree and flattens to a single level. This is used to
     * make searching commands and others easily.
     *
     * @param tree The command document tree
     * @param includeAliases Indicates whether or not we should include aliases in the flattened command tree
     * @return The flattened document tree
     */
    fun flattenCommandTree(
      tree: ICommandDefinition,
      includeAliases: Boolean = definedExternally,
    ): Array<ICommandTreeEntry>

    /**
     * Accepts the command definition document tree and flattens to a single level, including
     * aliases. This is used to make searching commands and others easily.
     *
     * @param tree The command document tree
     * @return The flattened document tree
     */
    @Deprecated("Use CommandUtils.flattenCommandTree instead")
    fun flattenCommandTreeWithAliases(tree: ICommandDefinition): Array<ICommandTreeEntry>

    /**
     * TODO - This needs to be well tested
     * TODO - There is a situation where two groups could have the same child command
     * TODO - It appears to choose the last in the list
     *
     * @param commandDef
     * @param commandTree
     */
    fun getFullCommandName(
      commandDef: ICommandDefinition,
      commandTree: ICommandDefinition,
    ): String
  }
}
