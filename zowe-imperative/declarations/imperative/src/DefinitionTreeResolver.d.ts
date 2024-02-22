import { ICommandDefinition } from "../../cmd";
import { Logger } from "../../logger";
/**
 * Combines a root command definition with an array of
 * command definition trees into a full tree with the command definitions
 * as children of the root command
 * For Imperative internal use
 */
export declare class DefinitionTreeResolver {
    /**
     * Get a fully constructed tree of command definitions from everything the  CLI developer has specified
     * @param {string} rootCommandDescription - Description to use for the root command (when
     * @param {string} displayName - the display name for the product/CLI
     * @param {string} callerDir - the directory that any childrenModuleGlobs are relative to
     * @param errorLogger - a logger instance to be used (e.g. a console logger) for errors
     * @param {ICommandDefinition[]} childrenDefinitions - already loaded definitions that have been passed by the user
     * @param {string[]} childrenModuleGlobs - list of globs that match definition files
     * @param {boolean} addBaseProfile - Specifies whether to add optional base profile to command definitions
     * @returns {ICommandDefinition} - the complete command tree
     */
    static resolve(rootCommandDescription: string, displayName: string, callerDir: string, errorLogger: Logger, childrenDefinitions?: ICommandDefinition[], childrenModuleGlobs?: string[], addBaseProfile?: boolean): ICommandDefinition;
    /**
     * Combine all of the command definitions supplied explicitly in the cmdDefs parameter
     * and those command definitions discovered by resolving the supplied cmdModuleGlobs.
     *
     * @param {string} callerDir - the directory that any childrenModuleGlobs are relative to
     *
     * @param {ICommandDefinition[]} cmdDefs - An array of already-resolved definitions
     *
     * @param {string[]} cmdModuleGlobs - list of globs that match definition files
     *
     * @param {boolean} addBaseProfile - Specifies whether to add optional base profile to command definitions
     *
     * @returns {ICommandDefinition[]} - An array of all resolved command definitions
     */
    static combineAllCmdDefs(callerDir: string, cmdDefs?: ICommandDefinition[], cmdModuleGlobs?: string[], addBaseProfile?: boolean): ICommandDefinition[];
    /**
     * Append optional base profile to profile type array for all command definitions that have profiles associated.
     * @param cmdDefs - An array of all resolved command definitions
     * @returns {ICommandDefinition[]} - An array of command definitions with base profile added
     */
    private static addBaseProfile;
    private static get log();
}
