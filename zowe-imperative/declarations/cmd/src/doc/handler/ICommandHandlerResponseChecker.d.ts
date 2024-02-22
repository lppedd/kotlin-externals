import { CommandResponse } from "../../response/CommandResponse";
export interface ICommandHandlerResponseChecker {
    process(response: CommandResponse): Promise<boolean>;
}
