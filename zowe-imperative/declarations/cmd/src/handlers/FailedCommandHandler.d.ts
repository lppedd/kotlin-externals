import { ICommandHandler } from "../doc/handler/ICommandHandler";
import { IHandlerParameters } from "../doc/handler/IHandlerParameters";
/**
 * Handler used to respond to unexpected errors
 */
export default class FailedCommandHandler implements ICommandHandler {
    process(params: IHandlerParameters): Promise<void>;
}
