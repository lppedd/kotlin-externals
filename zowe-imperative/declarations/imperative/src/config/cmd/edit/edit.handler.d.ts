import { ICommandHandler, IHandlerParameters } from "../../../../../cmd";
/**
 * Edit config
 */
export default class EditHandler implements ICommandHandler {
    /**
     * Process the command and input.
     *
     * @param {IHandlerParameters} params Parameters supplied by yargs
     *
     * @throws {ImperativeError}
     */
    process(params: IHandlerParameters): Promise<void>;
}
