import { AbstractSession } from "@zowe/imperative";
import { IZosFilesResponse } from "../../doc/IZosFilesResponse";
import { IZosFilesOptions } from "../../doc/IZosFilesOptions";
/**
 * This class holds helper functions that are used to execute AMS control statements through the z/OS MF APIs
 */
export declare class Invoke {
    /**
     * Send the AMS request to z/OS MF
     *
     * @param {AbstractSession}   session           - z/OS MF connection info
     * @param {string | string[]} controlStatements - contains the statements or the file path to them
     *
     * @returns {Promise<IZosFilesResponse>} A response indicating the outcome of the API
     *
     * @throws {ImperativeError} controlStatements must be set
     * @throws {Error} When the {@link ZosmfRestClient} throws an error
     *
     * @see https://www.ibm.com/support/knowledgecenter/en/SSLTBW_2.3.0/com.ibm.zos.v2r3.izua700/IZUHPINFO_API_PUTIDCAMSAccessMethodsServices.htm
     */
    static ams(session: AbstractSession, controlStatements: string | string[], options?: IZosFilesOptions): Promise<IZosFilesResponse>;
}
