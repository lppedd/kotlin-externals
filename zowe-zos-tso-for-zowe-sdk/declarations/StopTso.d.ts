import { AbstractSession } from "@zowe/imperative";
import { IStopTsoParms } from "./doc/input/IStopTsoParms";
import { IZosmfTsoResponse } from "./doc/zosmf/IZosmfTsoResponse";
import { IStartStopResponse } from "./doc/IStartStopResponse";
/**
 * Stop active TSO address space using servlet key
 * @export
 * @class StopTso
 */
export declare class StopTso {
    /**
     * Sends REST call to z/OSMF for stoping active TSO address space
     * @param {AbstractSession} session - z/OSMF connection info
     * @param {IStopTsoParms} commandParms - object with required parameters, @see {IStopTsoParms}
     * @returns {Promise<IZosmfTsoResponse>} z/OSMF response object, @see {IZosmfTsoResponse}
     * @memberof StopTso
     */
    static stopCommon(session: AbstractSession, commandParms: IStopTsoParms): Promise<IZosmfTsoResponse>;
    /**
     * Stop TSO address space and populates response with IStartStopResponse, @see {IStartStopResponse}
     * @param {AbstractSession} session
     * @param {string} servKey - unique servlet entry identifier
     * @returns {Promise<IStartStopResponse>} populated response, @see {IStartStopResponse}
     * @memberof StopTso
     */
    static stop(session: AbstractSession, servKey: string): Promise<IStartStopResponse>;
    /**
     * Generates query parameter needed for z/OSMF REST call
     * @param {string} servletKey - unique servlet entry identifier
     * @returns {string} generated resources query
     * @memberof StopTso
     */
    static getResources(servletKey: string): string;
}
