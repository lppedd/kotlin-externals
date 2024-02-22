import { ICommandResponse } from "../../../src/doc/response/response/ICommandResponse";
/**
 * Indicates the action performed.
 */
export declare type ImperativeYargsCommandAction = "syntax validation" | "command handler invoked" | "help invoked";
/**
 * The Yargs response is provided on the callback for a command definition defined through the Brightside
 * Yargs definer - when an execution of that command is complete - this response will be given to the callback.
 */
export interface IYargsResponse {
    success: boolean;
    /**
     * Requested exit code for the process
     */
    exitCode: number;
    message: string;
    actionPerformed: ImperativeYargsCommandAction;
    commandResponses?: ICommandResponse[];
    causeErrors?: Error;
}
