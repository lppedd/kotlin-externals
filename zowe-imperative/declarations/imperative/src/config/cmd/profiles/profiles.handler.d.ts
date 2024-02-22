import { ICommandHandler, IHandlerParameters } from "../../../../../cmd";
/**
 * The get command group handler for cli configuration settings.
 */
export default class ProfilesHandler implements ICommandHandler {
    /**
     * Process the command and input.
     *
     * @param {IHandlerParameters} params Parameters supplied by yargs
     *
     * @throws {ImperativeError}
     */
    process(params: IHandlerParameters): Promise<void>;
    private build;
}
