import { ICommandHandler, IHandlerParameters } from "../../../../cmd";
/**
 * Handler for the auto-generated update profile commands
 * Allows the user to simply update an existing configuration profile
 */
export default class UpdateProfilesHandler implements ICommandHandler {
    /**
     * The process command handler for the "update profile" command.
     * @return {Promise<ICommandResponse>}: The promise to fulfill when complete.
     */
    process(commandParameters: IHandlerParameters): Promise<void>;
}
