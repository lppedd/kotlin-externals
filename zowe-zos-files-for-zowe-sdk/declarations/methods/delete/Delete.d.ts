import { AbstractSession } from "@zowe/imperative";
import { IZosFilesResponse } from "../../doc/IZosFilesResponse";
import { IDeleteDatasetOptions } from "./doc/IDeleteDatasetOptions";
import { IDeleteVsamOptions } from "./doc/IDeleteVsamOptions";
import { IDeleteVsamResponse } from "./doc/IDeleteVsamResponse";
import { IZosFilesOptions } from "../../doc/IZosFilesOptions";
/**
 * This class holds helper functions that are used to delete files through the
 * z/OSMF APIs.
 */
export declare class Delete {
    /**
     * Deletes a non-VSAM data set
     *
     * @param {AbstractSession}       session      z/OSMF connection info
     * @param {string}                dataSetName  The name of the data set to delete
     * @param {IDeleteDatasetOptions} [options={}] Additional options for deletion of the data set
     *
     * @returns {Promise<IZosFilesResponse>} A response indicating the status of the deletion
     *
     * @throws {ImperativeError} Data set name must be specified as a non-empty string
     * @throws {Error} When the {@link ZosmfRestClient} throws an error
     *
     * @see https://www.ibm.com/support/knowledgecenter/en/SSLTBW_2.3.0/com.ibm.zos.v2r3.izua700/IZUHPINFO_API_DeleteDataSet.htm
     */
    static dataSet(session: AbstractSession, dataSetName: string, options?: IDeleteDatasetOptions): Promise<IZosFilesResponse>;
    /**
     * Deletes a VSAM data set
     *
     * @param {AbstractSession}           session      z/OSMF connection info
     * @param {string}                    dataSetName  The name of the VSAM data set to delete
     * @param {IDeleteVsamOptions} [options={}] Additional options for deletion of the data set
     *
     * @returns {Promise<IDeleteVsamResponse>} A response indicating the status of the deletion
     *
     * @throws {ImperativeError} Data set name must be specified as a non-empty string
     *
     * @see https://www.ibm.com/support/knowledgecenter/SSLTBW_2.1.0/com.ibm.zos.v2r1.idai200/delet.htm
     */
    static vsam(session: AbstractSession, dataSetName: string, options?: IDeleteVsamOptions): Promise<IDeleteVsamResponse>;
    /**
     * Deletes a USS file or directory
     *
     * @param {AbstractSession}           session      z/OSMF connection info
     * @param {string}                    fileName     The name of the file or directory to delete
     * @param {boolean}                   recursive    The indicator to delete directory recursively
     * @returns {Promise<IDeleteVsamResponse>} A response indicating the status of the deletion
     *
     * @throws {ImperativeError} Data set name must be specified as a non-empty string
     *
     * @see https://www.ibm.com/support/knowledgecenter/en/SSLTBW_2.3.0/com.ibm.zos.v2r3.izua700/IZUHPINFO_API_DeleteUnixFile.htm
     */
    static ussFile(session: AbstractSession, fileName: string, recursive?: boolean, options?: IZosFilesOptions): Promise<IZosFilesResponse>;
    /**
     * Deletes a z/OS file system
     *
     * @param {AbstractSession}           session      z/OSMF connection info
     * @param {string}                    fileSystemName     The name of the ZFS to delete
     *
     * @throws {ImperativeError} File system name must be specified as a non-empty string
     *
     * @see https://www.ibm.com/support/knowledgecenter/SSLTBW_2.1.0/com.ibm.zos.v2r1.izua700/IZUHPINFO_API_DeleteUnixzFsFilesystem.htm
     */
    static zfs(session: AbstractSession, fileSystemName: string, options?: IZosFilesOptions): Promise<IZosFilesResponse>;
}
