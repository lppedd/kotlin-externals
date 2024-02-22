import { AbstractSession } from "@zowe/imperative";
import { IZosFilesResponse } from "../../doc/IZosFilesResponse";
import { IZosFilesOptions } from "../../doc/IZosFilesOptions";
/**
 * This class holds helper functions that are used to unmount file systems through the z/OS MF APIs
 */
export declare class Unmount {
    /**
     * Unmount a Unix file system
     *
     * @param {AbstractSession}  session         - z/OS MF connection info
     * @param {string}           fileSystemName  - contains the file system name
     * @param {IZosFilesOptions} options         - contains the options to use
     *
     * @returns {Promise<IZosFilesResponse>} A response indicating the outcome of the API
     *
     * @throws {ImperativeError} file system name must be set
     * @throws {Error} When the {@link ZosmfRestClient} throws an error
     *
     * @see https://www.ibm.com/support/knowledgecenter/SSLTBW_2.1.0/com.ibm.zos.v2r1.izua700/IZUHPINFO_API_UnmountUnixFile.htm
     */
    static fs(session: AbstractSession, fileSystemName: string, options?: IZosFilesOptions): Promise<IZosFilesResponse>;
}
