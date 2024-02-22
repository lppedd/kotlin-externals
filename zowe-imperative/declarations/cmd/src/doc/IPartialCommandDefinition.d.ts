import { ICommandExampleDefinition } from "./ICommandExampleDefinition";
import { ICommandOptionDefinition } from "./option/ICommandOptionDefinition";
/**
 * Interface that allows CLIs to override properties on command definitions.
 */
export interface IPartialCommandDefinition {
    /**
     * The description - keep group descriptions "small" and include lengthier descriptions for "commands".
     * @type {string}
     * @memberof IPartialCommandDefinition
     */
    description?: string;
    /**
     * A shorter (~one line) description of your command
     * @type {string}
     * @memberof IPartialCommandDefinition
     */
    summary?: string;
    /**
     * The set of examples displayed in the help for this command.
     * @type {ICommandExampleDefinition[]}
     * @memberof IPartialCommandDefinition
     */
    examples?: ICommandExampleDefinition[];
    /**
     * The options to be exposed on the command.
     * @type {ICommandOptionDefinition[]}
     * @memberof IPartialCommandDefinition
     */
    options?: ICommandOptionDefinition[];
}
