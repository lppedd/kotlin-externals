import { ICommandOutputFormat } from "../../../../../src/doc/response/response/ICommandOutputFormat";
export interface IHandlerFormatOutputApi {
    output: (format: ICommandOutputFormat) => void;
}
