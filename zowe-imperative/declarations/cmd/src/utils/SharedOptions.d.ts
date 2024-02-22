/// <reference types="node" />
import { Arguments } from "yargs";
import { ICommandNodeType } from "../doc/ICommandDefinition";
import { CommandResponse } from "../response/CommandResponse";
/**
 * Options which can be reused between different Brightside commands
 */
export declare class SharedOptions {
    /**
     * Promise based API for reading the standard in if the arguments dictate to do so. The response is placed in the
     * arguments to be passed on the the command handlers.
     * @param {Arguments} args - The yargs style command line arguments supplied by the user
     * @param {CommandResponse} response - The command response object (for messages, etc.)
     * @param {ICommandNodeType} commandType - The type of the command
     * @returns {Promise<boolean>} - The promise to be fulfilled (or rejected with an imperative error) - false if
     *                               stdin was read and false if it wasn't
     * @memberof SharedOptions
     */
    static readStdinIfRequested(args: Arguments, response: CommandResponse, commandType: ICommandNodeType, stream?: NodeJS.ReadStream & {
        fd: 0;
    }): Promise<boolean>;
    /**
     * Read from standard in until EOF (if the option was specified)
     * @param {Arguments} args - arguments for the command
     * @param {CommandResponse} response - the response object to write to / log to if necessary
     * @param {ICommandNodeType} commandType what type of command might have the --stdin option? If it's not "command"
     *                              this method will return immediately
     * @param {() => void} done - callback for when stdin reading is done. attemptedStdinRead: whether we tried to read standard in
     *                            based on the arguments and command definition
     */
    private static readStdin;
}
