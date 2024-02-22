import { IZosmfTsoResponse } from "./zosmf/IZosmfTsoResponse";
/**
 * The TsoSend API response.
 * @export
 * @interface ISendResponse
 */
export interface ISendResponse {
    /**
     * True if the command was issued and the responses were collected.
     * @type {boolean}
     * @memberof ISendResponse
     */
    success: boolean;
    /**
     * The list of zOSMF send API responses. May issue multiple requests or
     * to ensure that all messages are collected. Each individual response is placed here.
     * @type {IZosmfTsoResponse[]}
     * @memberof ISendResponse
     */
    zosmfResponse: IZosmfTsoResponse[];
    /**
     * The command response text.
     * @type {string}
     * @memberof ISendResponse
     */
    commandResponse: string;
}
