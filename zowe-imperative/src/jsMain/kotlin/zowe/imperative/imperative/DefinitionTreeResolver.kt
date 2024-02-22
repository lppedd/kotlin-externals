@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative

import zowe.imperative.cmd.doc.ICommandDefinition
import zowe.imperative.logger.Logger

/**
 * Combines a root command definition with an array of command definition trees into a full tree
 * with the command definitions as children of the root command For Imperative internal use
 */
external class DefinitionTreeResolver {
  companion object {
    /**
     * Get a fully constructed tree of command definitions from everything the CLI developer has
     * specified
     *
     * @param rootCommandDescription Description to use for the root command (when
     * @param displayName the display name for the product/CLI
     * @param callerDir the directory that any childrenModuleGlobs are relative to
     * @param errorLogger a logger instance to be used (e.g. a console logger) for errors
     * @param childrenDefinitions already loaded definitions that have been passed by the user
     * @param childrenModuleGlobs list of globs that match definition files
     * @param addBaseProfile Specifies whether to add optional base profile to command definitions
     * @return the complete command tree
     */
    fun resolve(
      rootCommandDescription: String,
      displayName: String,
      callerDir: String,
      errorLogger: Logger,
      childrenDefinitions: Array<ICommandDefinition> = definedExternally,
      childrenModuleGlobs: Array<String> = definedExternally,
      addBaseProfile: Boolean = definedExternally,
    ): ICommandDefinition

    /**
     * Combine all of the command definitions supplied explicitly in the cmdDefs parameter and those
     * command definitions discovered by resolving the supplied cmdModuleGlobs.
     *
     * @param callerDir the directory that any childrenModuleGlobs are relative to
     * @param cmdDefs An array of already-resolved definitions
     * @param cmdModuleGlobs list of globs that match definition files
     * @param addBaseProfile Specifies whether to add optional base profile to command definitions
     * @return An array of all resolved command definitions
     */
    fun combineAllCmdDefs(
      callerDir: String,
      cmdDefs: Array<ICommandDefinition> = definedExternally,
      cmdModuleGlobs: Array<String> = definedExternally,
      addBaseProfile: Boolean = definedExternally,
    ): Array<ICommandDefinition>
  }
}
