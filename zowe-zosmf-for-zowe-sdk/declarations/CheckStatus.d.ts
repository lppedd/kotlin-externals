import { AbstractSession } from "@zowe/imperative";
import { IZosmfInfoResponse } from "./doc/IZosmfInfoResponse";
/**
 * This class holds the helper functions that are used to gather zosmf information throgh the
 * z/OSMF APIs.
 */
export declare class CheckStatus {
    /**
     * Get z/OSMF information
     * @param {AbstractSession} session z/OSMF connection info.
     * @returns {promise<IZosmfInfoResponse>} A response contains information from API call.
     * @throws {ImperativeError} session must not be null or undefined. Any error threw by
     *                           the REST API call.
     */
    static getZosmfInfo(session: AbstractSession): Promise<IZosmfInfoResponse>;
    /**
     * Get Log
     * @returns {Logger} applicationLogger.
     */
    private static get log();
}
