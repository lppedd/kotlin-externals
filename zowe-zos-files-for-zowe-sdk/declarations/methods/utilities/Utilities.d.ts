/// <reference types="node" />
import { IOptions } from "../../doc/IOptions";
import { IZosFilesResponse } from "../../doc/IZosFilesResponse";
import { AbstractSession } from "@zowe/imperative";
import { Tag } from "./doc/Tag";
export declare class Utilities {
    /**
     * Retrieve various details from USS file functions
     *
     * This function uses a JSON payload to retrieve information via zosmf utilities function
     *
     * @param {AbstractSession} session     - z/OSMF connection info
     * @param {string}          USSFileName - contains the file name
     * @param {JSON}            payload     - contains the options to be sent
     *
     * @returns {Promise<Buffer>} Promise that resolves to json information
     *
     * @throws {ImperativeError}
     */
    static putUSSPayload(session: AbstractSession, USSFileName: string, payload: any): Promise<Buffer>;
    /**
     * Changes the tag attributes associate with a file using function chtag
     *
     * This function uses a JSON payload to set the  information via zosmf utilities function
     *
     * @param {AbstractSession} session     - z/OSMF connection info
     * @param {Tag}             type - enum of chtag type of Test, Binary or Mixed
     * @param {string}          codeset - optional string describing codeset e.g. IBM-1047
     *
     * @returns {Promise<IZosFilesResponse>} Promise that resolves to response object
     *
     * @throws {ImperativeError}
     */
    static chtag(session: AbstractSession, ussFileName: string, type: Tag, codeset?: string): Promise<IZosFilesResponse>;
    /**
     * Based upon the files chtag value. Identify how the tagging should be interpretted when transferring the contents
     * For example an EBCDIC file would always be converted from it's EBCDIC value to the ASCII
     *
     * An ASCII file value or binary should not be converted.
     *
     * The default value if the tag is not set or in an invalid state correctly is to convert.
     *
     * @param {AbstractSession}  session      - z/OSMF connection info
     * @param {string}           USSFileName  - contains the file name
     *
     * @returns {Promise<boolean>} Promise that resolves to true if the file is binary or ASCII text or false if file
     * should likely be converted to text. Default is false which aligns with the zosmf default behavior converting
     *
     * @throws {ImperativeError}
     */
    static isFileTagBinOrAscii(session: AbstractSession, USSFileName: string): Promise<boolean>;
    /**
     * Check the tags on an existing USS file and update binary and encoding
     * properties on the options object.
     * @param session z/OSMF connection info
     * @param USSFileName Path to USS file
     * @param options Options for downloading a USS file
     */
    static applyTaggedEncoding(session: AbstractSession, USSFileName: string, options: IOptions): Promise<void>;
    /**
     * Re-name USS file or directory
     *
     * @param {AbstractSession} session     - z/OSMF connection info
     * @param {string}          USSFilePath - contains the current filepath
     * @param {string}          newFilePath - contains the new filepath
     *
     * @returns {Promise<Buffer>} Promise that resolves to json information
     *
     * @throws {ImperativeError}
     */
    static renameUSSFile(session: AbstractSession, USSFilePath: string, newFilePath: string): Promise<Buffer>;
}
