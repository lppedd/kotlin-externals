import { ICommandHandler, IHandlerParameters } from "../../../../../cmd";
/**
 * The install command handler for cli plugin install.
 *
 * @see {installDefinition}
 */
export default class ListHandler implements ICommandHandler {
    /**
     * A logger for this class
     *
     * @private
     * @type {Logger}
     */
    private log;
    /**
     * Process the command and input.
     *
     * @param {IHandlerParameters} params Parameters supplied by yargs
     *
     * @returns {Promise<ICommandResponse>} The command response
     *
     * @throws {ImperativeError}
     */
    process(params: IHandlerParameters): Promise<void>;
}
