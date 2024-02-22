/**
 * Brightside command handlers must implement this interface.
 *
 * !!!Note: Handlers must "export" the module name via "module.exports=<module name>" for the handler to be
 * instantiated correctly by the bright command processor.
 */
import { IHandlerParameters } from "./IHandlerParameters";
export interface ICommandHandler {
    /**
     * Process method - the handler for this command invocation - processes the command and populates the response
     * object as needed. Returns a promise that is expected to be fulfilled (never manually rejected).
     * @param {IHandlerParameters} commandParameters: The parameter object to the handler.
     * @return {Promise}: The promise to be fulfilled when the command processing is complete.
     */
    process(commandParameters: IHandlerParameters): Promise<void>;
}
