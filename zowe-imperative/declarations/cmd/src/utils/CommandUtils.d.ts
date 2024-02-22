import { Arguments } from "yargs";
import { ICommandDefinition } from "../doc/ICommandDefinition";
import { ICommandOptionDefinition } from "../doc/option/ICommandOptionDefinition";
import { ICommandArguments } from "../doc/args/ICommandArguments";
/**
 * Command tree entry describes an entry of a command in the full command tree - used when flattening the command
 * tree to build fully qualified commands for searching and display purposes
 */
export interface ICommandTreeEntry {
    command: ICommandDefinition;
    fullName: string;
    tree: ICommandDefinition;
}
/**
 * The command segment represents the "level" you are at in the command (for help generation)
 */
export declare type CommandSegment = "group" | "command";
/**
 * Command utility class. Place static utils for command processing here.
 */
export declare class CommandUtils {
    /**
     * Get a representation of the original command as issued by the user .with all canonical forms of options specified.
     * You only need to supply the "command" segement of your command. The "full command" (including previous groups, etc.)
     * is extracted from the yargs arguments object "_" property.
     * TODO: Replace "maincommand" below with the name of the bin - This is new to Imperative.
     * @param {yargs.Arguments} commandArguments - The Yargs style argument object. Requires the "_" (input argv)
     * @param {ICommandDefinition} commandDefinition - The command definition document
     * @returns {string} - The reconstructed command (as would have been issued on the console).
     */
    static reconstructCommand(commandArguments: Arguments, commandDefinition: ICommandDefinition): string;
    /**
     * Check if an option was specified by the user.
     * @param optionName - the option to check for.
     * @param {ICommandArguments["args"]} args: The arguments specified by the user.
     * @param {ICommandDefinition} commandDefinition - the definition for the command
     * @returns {boolean} true: the option was specified by the user.
     *                    false: the option was omitted/set to false
     */
    static optionWasSpecified(optionName: string, commandDefinition: ICommandDefinition, args: ICommandArguments["args"]): boolean;
    /**
     * Find the option definition from the .options field of the command definition
     * @param {string} optionName
     * @param {ICommandDefinition} commandDefinition - the definition for the command
     * @returns {ICommandOptionDefinition} - if the optionName is an option,
     *                                             the definition of the option, otherwise undefined
     */
    static getOptionDefinitionFromName(optionName: string, commandDefinition: ICommandDefinition): ICommandOptionDefinition;
    /**
     * Helper recursive function for flattening a given tree definition
     * @param prefix Previous command objects to prepend to the given child name
     * @param child Tree definition to use when searching for descendants
     * @param includeAliases Indicates whether or not we should include aliases in the recursion
     * @param _result (recursion) resulting list of flattened descendants
     * @param _tree (recursion) Initial tree definition
     * @returns Concatenated list of flattened descendants
     */
    private static addChildAndDescendantsToSearch;
    /**
     * Accepts the command definition document tree and flattens to a single level. This is used to make searching
     * commands and others easily.
     * @param {ICommandDefinition} tree - The command document tree
     * @param includeAliases Indicates whether or not we should include aliases in the flattened command tree
     * @return {ICommandTreeEntry[]} - The flattened document tree
     */
    static flattenCommandTree(tree: ICommandDefinition, includeAliases?: boolean): ICommandTreeEntry[];
    /**
     * Accepts the command definition document tree and flattens to a single level, including aliases. This is used to make searching
     * commands and others easily.
     * @param {ICommandDefinition} tree - The command document tree
     * @deprecated Use CommandUtils.flattenCommandTree instead
     * @return {ICommandTreeEntry[]} - The flattened document tree
     */
    static flattenCommandTreeWithAliases(tree: ICommandDefinition): ICommandTreeEntry[];
    /**
     * TODO - This needs to be well tested
     * TODO - There is a situation where two groups could have the same child command
     * TODO - It appears to choose the last in the list
     * @static
     * @param {ICommandDefinition} commandDef
     * @param {ICommandDefinition} commandTree
     * @returns {string}
     * @memberof CommandUtils
     */
    static getFullCommandName(commandDef: ICommandDefinition, commandTree: ICommandDefinition): string;
}
