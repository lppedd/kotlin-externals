import { ICommandHandler, IHandlerParameters } from "../../../../cmd";
/**
 * Handler for the auto-generated show dependencies command
 */
export default class ShowDependenciesProfilesHandler implements ICommandHandler {
    /**
     * The process command handler for the "show dependencies" command.
     * @return {Promise<ICommandResponse>}: The promise to fulfill when complete.
     */
    process(commandParameters: IHandlerParameters): Promise<void>;
}
