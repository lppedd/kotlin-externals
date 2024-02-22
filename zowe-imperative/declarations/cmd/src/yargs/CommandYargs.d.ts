import { Argv } from "yargs";
import { AbstractCommandYargs, YargsCommandCompleted } from "./AbstractCommandYargs";
import { ICommandOptionDefinition } from "../../src/doc/option/ICommandOptionDefinition";
/**
 * Define an Imperative Command to Yargs. A command implies that an implementation is present (differs from a "group")
 * and it does not have children.
 */
export declare class CommandYargs extends AbstractCommandYargs {
    /**
     * Define the options to Yargs.
     * @param {yargs.Argv} yargsInstance: The instance of yargs to define the options.
     * @param {ICommandOptionDefinition[]} brightOptions: The option definition document array.
     */
    static defineOptionsToYargs(yargsInstance: Argv, brightOptions: ICommandOptionDefinition[]): void;
    /**
     * Define the Imperative JSON command definition to Yargs. Once the command is defined, Yargs will parse and
     * invoke its 'handler' (below). The handler can then invoke the potential "chain" of handlers in sequence and
     * is notified when they complete via a promise.
     * @param {YargsCommandCompleted} commandExecuted - Callback invoked when a command execution is complete.
     */
    defineCommandToYargs(commandExecuted: YargsCommandCompleted): void;
    /**
     * Construct the positional argument string for Yargs. The positional arguments are always constructed as
     * "optional" to yargs. This prevents yargs from "throwing errors" if the user requests --help and the positional
     * parameters are not specified.
     * @return {string}: The positional argument string used in the Yargs command definition.
     */
    private buildPositionalString;
    /**
     * Invoke the "chain" of command handlers provided for this definition.
     * @param {ICommandDefinition[]} handlers: The array of handlers to invoke.
     * @param {number} index: The current index in the handler array.
     * @param {yargs.Argv} argsForHandler: The arguments passed on the command line for the handler.
     * @param {ICommandResponse[]} responses: The collection of responses from each handler.
     * @return {Promise<ICommandResponse[]>}: The promise to be fulfilled when all handlers are complete.
     */
    private invokeHandlers;
}
