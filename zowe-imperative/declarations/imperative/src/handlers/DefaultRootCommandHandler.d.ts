import { ICommandHandler, IHandlerParameters } from "../../../cmd";
/**
 * The default command handler for the top level/root command
 * Allows the user to check the version of the package.
 * If they haven't specified --version, the help prints
 */
export default class DefaultRootCommandHandler implements ICommandHandler {
    process(params: IHandlerParameters): Promise<void>;
}
