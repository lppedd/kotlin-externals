import { ICommandHandler, IHandlerParameters } from "../../../../../cmd";
/**
 * The update command handler for cli plugin install.
 *
 * @see {updateDefinition}
 */
export default class UpdateHandler implements ICommandHandler {
    /**
     * A logger for this class
     *
     * @private
     * @type {Logger}
     */
    private console;
    /**
     * Process the command and input.
     *
     * @param {IHandlerParameters} params Parameters supplied by yargs
     *
     * @param {string[]} [params.arguments.plugin] This is the plugin to update.
     *
     * @returns {Promise<ICommandResponse>} The command response
     *
     * @throws {ImperativeError}
     */
    process(params: IHandlerParameters): Promise<void>;
}
