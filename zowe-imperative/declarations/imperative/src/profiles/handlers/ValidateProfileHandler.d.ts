import { ICommandHandler, IHandlerParameters } from "../../../../cmd";
/**
 * Generic handler for validating a profile and printing a report in response
 */
export default class ValidateProfileHandler implements ICommandHandler {
    /**
     * Get an instance of the imperative logger.
     * @private
     * @type {Logger}
     * @memberof ValidateProfileHandler
     */
    private mLogger;
    process(params: IHandlerParameters): Promise<void>;
}
