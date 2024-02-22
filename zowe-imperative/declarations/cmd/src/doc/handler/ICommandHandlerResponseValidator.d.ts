import { ICommandResponse } from "../../../src/doc/response/response/ICommandResponse";
import { CommandResponse } from "../../response/CommandResponse";
export interface ICommandHandlerResponseValidator {
    validate(response: CommandResponse): Promise<ICommandResponse>;
}
