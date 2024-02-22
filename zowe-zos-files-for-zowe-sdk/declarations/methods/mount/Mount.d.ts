import { AbstractSession } from "@zowe/imperative";
import { IMountFsOptions } from "./doc/IMountFsOptions";
import { IZosFilesResponse } from "../../doc/IZosFilesResponse";
/**
 * This class holds helper functions that are used to mount file systems through the z/OS MF APIs
 */
export declare class Mount {
    /**
     * Mount a Unix file system
     *
     * @param {AbstractSession}  session         - z/OS MF connection info
     * @param {string}           fileSystemName  - contains the file system name
     * @param {string}           mountPoint      - contains the mount point
     * @param {IListOptions}     [options={}]    - contains the options to be sent
     *
     * @returns {Promise<IZosFilesResponse>} A response indicating the outcome of the API
     *
     * @throws {ImperativeError} file system name must be set
     * @throws {Error} When the {@link ZosmfRestClient} throws an error
     *
     * @see https://www.ibm.com/support/knowledgecenter/SSLTBW_2.1.0/com.ibm.zos.v2r1.izua700/IZUHPINFO_API_MountUnixFile.htm
     */
    static fs(session: AbstractSession, fileSystemName: string, mountPoint: string, options?: Partial<IMountFsOptions>): Promise<IZosFilesResponse>;
    /**
     * Validate the options for the command to mount a z/OS file system
     * @param options - options for the mounting of the file system
     */
    private static fsValidateOptions;
}
