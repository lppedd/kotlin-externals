import { AbstractSession } from "@zowe/imperative";
import { IGetOptions } from "../get/doc/IGetOptions";
import { IZosFilesResponse } from "../../doc/IZosFilesResponse";
import { IDataSet } from "../../doc/IDataSet";
import { ICopyDatasetOptions } from "./doc/ICopyDatasetOptions";
import { ICrossLparCopyDatasetOptions } from "./doc/ICrossLparCopyDatasetOptions";
/**
 * This class holds helper functions that are used to copy the contents of datasets through the
 * z/OSMF APIs.
 */
export declare class Copy {
    /**
     * Copy the contents of a dataset
     *
     * @param {AbstractSession}   session        - z/OSMF connection info
     * @param {IDataSet}          toDataSet      - The data set to copy to
     * @param {IDataSetOptions}   options        - Options
     *
     * @returns {Promise<IZosFilesResponse>} A response indicating the status of the copying
     *
     * @throws {ImperativeError} Data set name must be specified as a non-empty string
     * @throws {Error} When the {@link ZosmfRestClient} throws an error
     *
     * @see https://www.ibm.com/support/knowledgecenter/en/SSLTBW_2.1.0/com.ibm.zos.v2r1.izua700/IZUHPINFO_API_PutDataSetMemberUtilities.htm
     */
    static dataSet(session: AbstractSession, { dsn: toDataSetName, member: toMemberName }: IDataSet, options: ICopyDatasetOptions): Promise<IZosFilesResponse>;
    /**
     * Copy the contents of a dataset from one LPAR to another LPAR
     *
     * @param {AbstractSession}                 sourceSession  - Source z/OSMF connection info
     * @param {IDataSet}                        toDataSet      - The data set to copy to
     * @param {ICrossLparCopyDatasetOptions}    targetOptions  - Options for target file and connection
     * @param {IGetOptions}                     sourceOptions  - Options for source file
     * @param {IDataSetOptions}                 options        - Common options
     * @param {IHandlerResponseConsoleApi}      console        - Command console object
     *
     * @returns {Promise<IZosFilesResponse>} A response indicating the status of the copying
     *o
     * @throws {ImperativeError} Data set name must be specified as a non-empty string
     * @throws {Error} When the {@link ZosmfRestClient} throws an error
     *
     */
    static dataSetCrossLPAR(sourceSession: AbstractSession, { dsn: toDataSetName, member: toMemberName }: IDataSet, options: ICrossLparCopyDatasetOptions, sourceOptions: IGetOptions, targetSession: AbstractSession): Promise<IZosFilesResponse>;
    /**
     *  Private function to convert the dataset options from the format returned by the Get() call in to the format used by the Create() call
     */
    private static generateDatasetOptions;
    /**
     *  Private function to convert the ALC value from the format returned by the Get() call in to the format used by the Create() call
     */
    private static convertAlcTozOSMF;
}
