import { ICommandHandler, IHandlerParameters } from "../../../../cmd";
/**
 * Handler for the auto-generated list profiles command.
 */
export default class ListProfilesHandler implements ICommandHandler {
    /**
     * The process command handler for the "list profiles" command.
     * @return {Promise<ICommandResponse>}: The promise to fulfill when complete.
     */
    process(params: IHandlerParameters): Promise<void>;
}
