import { AbstractSession } from "@zowe/imperative";
import { IZosFilesResponse } from "../../doc/IZosFilesResponse";
import { IDeleteOptions } from "./doc/IDeleteOptions";
/**
 * This class holds helper functions that are used to delete data sets through the
 * z/OSMF APIs.
 */
export declare class HDelete {
    /**
     *
     * @param {AbstractSession}       session      z/OSMF connection info
     * @param {string}                dataSetName  The name of the data set to recall
     * @param {boolean}               wait If true then the function waits for completion of the request. If false (default) the request is queued.
     *
     * @returns {Promise<IZosFilesResponse>} A response indicating the status of the deletion
     *
     * @throws {ImperativeError} Data set name must be specified as a non-empty string
     * @throws {Error} When the {@link ZosmfRestClient} throws an error
     *
     * @see https://www.ibm.com/support/knowledgecenter/SSLTBW_2.4.0/com.ibm.zos.v2r4.izua700/IZUHPINFO_API_PutDataSetMemberUtilities.htm
     */
    static dataSet(session: AbstractSession, dataSetName: string, options?: Partial<IDeleteOptions>): Promise<IZosFilesResponse>;
}
