import { ICommandHandler, IHandlerParameters } from "../../../../cmd";
/**
 * Handler for the auto generated commands to set the default profile for a type
 * The default profile is loaded when no specific profile name is specified
 */
export default class SetDefaultProfilesHandler implements ICommandHandler {
    /**
     * process the set default profile command arguments
     * @return {Promise<ICommandResponse>}: The promise to fulfill when complete.
     */
    process(commandParameters: IHandlerParameters): Promise<void>;
}
