import { AbstractSession } from "@zowe/imperative";
import { ISendTsoParms } from "./doc/input/ISendTsoParms";
import { IZosmfTsoResponse } from "./doc/zosmf/IZosmfTsoResponse";
import { ICollectedResponses } from "./doc/ICollectedResponses";
import { ISendResponse } from "./doc/ISendResponse";
/**
 * Class to handle sending data to TSO
 * @class SendTso
 */
export declare class SendTso {
    /**
     * API method to send data to already started TSO address space, but will read TSO data until a PROMPT is reached.
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {string} servletKey - servlet key returned from a successful start
     * @param {string} data - data to send to the TSO address space.
     * @returns {Promise<ISendResponse>} SendTso response object, @see {ISendResponse}
     * @memberof SendTso
     */
    static sendDataToTSOCollect(session: AbstractSession, servletKey: string, data: string): Promise<ISendResponse>;
    /**
     * API method to send data to already started TSO address space
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {IStartTsoParms} commandParams - object with required parameters, @see {ISendTsoParms}
     * @returns {Promise<IZosmfTsoResponse>} - z/OSMF response object, @see {IZosmfTsoResponse}
     * @memberof SendTso
     */
    static sendDataToTSOCommon(session: AbstractSession, commandParams: ISendTsoParms): Promise<IZosmfTsoResponse>;
    /**
     * API method is used to get response data from a TSO address space.
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {String} servletKey - servlet key of address space
     * @returns {Promise<IZosmfTsoResponse>} - z/OSMF response object, @see {IZosmfTsoResponse}
     * @memberof SendTso
     */
    static getDataFromTSO(session: AbstractSession, servletKey: string): Promise<IZosmfTsoResponse>;
    /**
     * Collects responses from address space until it reaches prompt
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {IZosmfTsoResponse} tso - object from first API call from witch responses are needed
     * @returns {Promise<ICollectedResponses>} - CollectedResponses response object, @see {ICollectedResponses}
     * @memberof SendTso
     */
    static getAllResponses(session: AbstractSession, tso: IZosmfTsoResponse): Promise<ICollectedResponses>;
    /**
     * Creates ISendResponse object and fills with data
     * @param {IZosmfTsoResponse[]} allResponses - array of all collected responses
     * @param {string} messages - concatenated messages from responses
     * @returns {ISendResponse} - SendTso response object, @see {ISendResponse}
     * @memberof SendTso
     */
    private static createResponse;
}
