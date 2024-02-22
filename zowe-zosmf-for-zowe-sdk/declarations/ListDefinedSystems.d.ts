import { AbstractSession } from "@zowe/imperative";
import { IZosmfListDefinedSystemsResponse } from "./doc/IZosmfListDefinedSystemsResponse";
/**
 * This class is used to list the systems defined to z/OSMF throgh the
 * z/OSMF APIs.
 */
export declare class ListDefinedSystems {
    /**
     * List systems defined to z/OSMF
     * @param {AbstractSession} session z/OSMF connection info.
     * @returns {promise<IZosmfListDefinedSystemsResponse>} A response contains information from API call.
     * @throws {ImperativeError} session must not be null or undefined. Any error threw by
     *                           the REST API call.
     */
    static listDefinedSystems(session: AbstractSession): Promise<IZosmfListDefinedSystemsResponse>;
}
