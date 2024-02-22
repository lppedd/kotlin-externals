/// <reference types="node" />
import { AbstractSession } from "@zowe/imperative";
import { IGetOptions } from "./doc/IGetOptions";
/**
 * This class holds helper functions that are used to get the content of data sets or USS files through the z/OSMF APIs
 * @export
 * @class Get
 */
export declare class Get {
    /**
     * Retrieve data sets content
     *
     * @param {AbstractSession}  session      - z/OSMF connection info
     * @param {string}           dataSetName  - contains the data set name
     * @param {IGetOptions} [options={}] - contains the options to be sent
     *
     * @returns {Promise<Buffer>} Promise that resolves to the content of the data set
     *
     * @throws {ImperativeError}
     */
    static dataSet(session: AbstractSession, dataSetName: string, options?: IGetOptions): Promise<Buffer>;
    /**
     * Retrieve USS file content
     *
     * @param {AbstractSession}  session      - z/OSMF connection info
     * @param {string}           USSFileName  - contains the data set name
     * @param {IGetOptions} [options={}] - contains the options to be sent
     *
     * @returns {Promise<Buffer>} Promise that resolves to the content of the uss file
     *
     * @throws {ImperativeError}
     */
    static USSFile(session: AbstractSession, USSFileName: string, options?: IGetOptions): Promise<Buffer>;
}
