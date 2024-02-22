import { ICommandHandler, IHandlerParameters } from "../../../../cmd";
/**
 * Handler that allows creation of a profile from command line arguments. Intended for usage with the automatically
 * generated profile create commands, but can be used otherwise.
 * @export
 * @class CreateProfilesHandler
 * @implements {ICommandHandler}
 */
export default class CreateProfilesHandler implements ICommandHandler {
    /**
     * Create a profile from command line arguments.
     * @param {IHandlerParameters} commandParameters - Standard Imperative command handler parameters - see the
     * interface for full details
     * @memberof CreateProfilesHandler
     */
    process(commandParameters: IHandlerParameters): Promise<void>;
}
