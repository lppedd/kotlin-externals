import { IZosmfTsoResponse } from "./doc/zosmf/IZosmfTsoResponse";
import { IStartStopResponse } from "./doc/IStartStopResponse";
import { IStartStopResponses } from "./doc/IStartStopResponses";
import { ICollectedResponses } from "./doc/ICollectedResponses";
import { IZosmfPingResponse } from "./doc/zosmf/IZosmfPingResponse";
import { IPingResponse } from "./doc/IPingResponse";
/**
 * Filter responses from z/OSMF
 * @export
 * @class TsoResponseService
 */
export declare class TsoResponseService {
    /**
     * Populates start and stop commands response with z/OSMF response details
     * @param {IZosmfTsoResponse} zosmfResponse -  z/OSMF response object, @see {IZosmfTsoResponse}
     * @returns {IStartStopResponse} populated object with type of IStartStopResponse, @see {IStartStopResponse}
     * @memberof TsoResponseService
     */
    static populateStartAndStop(zosmfResponse: IZosmfTsoResponse): IStartStopResponse;
    /**
     * Populates start and stop commands response with z/OSMF response details
     * @param {IZosmfTsoResponse} zosmfResponse -  z/OSMF response object, @see {IZosmfTsoResponse}
     * @param {ICollectedResponses} collectedResponses -  collected z/OSMF responses object, @see {ICollectedResponses}
     * @returns {IStartStopResponse} populated object with type of IStartStopResponse, @see {IStartStopResponse}
     * @memberof TsoResponseService
     */
    static populateStartAndStopCollectAll(zosmfResponse: IZosmfTsoResponse, collectedResponses?: ICollectedResponses): IStartStopResponses;
    /**
     * Populates ping command response with z/OSMF response details
     * @param {IZosmfPingResponse} zosmfResponse -  z/OSMF response object, @see {IZosmfPingResponse}
     * @returns {PingResponse} populated object with type of IPingResponse
     * @memberof TsoResponseService
     */
    static populatePing(zosmfResponse: IZosmfPingResponse): IPingResponse;
}
