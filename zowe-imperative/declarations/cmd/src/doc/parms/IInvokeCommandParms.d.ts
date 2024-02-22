import { Arguments } from "yargs";
import { COMMAND_RESPONSE_FORMAT } from "../../doc/response/api/processor/ICommandResponseApi";
/**
 * Parameters to the command processor invoke method.
 * @export
 * @interface IInvokeCommandParms
 */
export interface IInvokeCommandParms {
    /**
     * The Yargs style arguments for the command processor.
     * @type {Arguments}
     * @memberof IInvokeCommandParms
     */
    arguments: Arguments;
    /**
     * Indicates that the command should be totally silent (no output to the console).
     * @type {boolean}
     * @memberof IInvokeCommandParms
     */
    silent?: boolean;
    /**
     * Indicates that the response format to the command should be written in JSON. If silent mode is enabled, then
     * nothing is written (regardless of this setting)
     * @type {boolean}
     * @memberof IInvokeCommandParms
     */
    responseFormat?: COMMAND_RESPONSE_FORMAT;
}
