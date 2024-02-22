import { AbstractSession } from "@zowe/imperative";
import { IZosFilesResponse } from "../../doc/IZosFilesResponse";
import { IZosFilesOptions } from "../../doc/IZosFilesOptions";
/**
 * Class to handle renaming data sets
 */
export declare class Rename {
    /**
     * Rename a data set
     * @param {AbstractSession}     session                 - z/OSMF connection info
     * @param {string}              beforeDataSetName       - the name of the data set to rename
     * @param {string}              fterDataSetName         - the new name of the data set
     * @returns {Promise<IZosFilesResponse>}
     */
    static dataSet(session: AbstractSession, beforeDataSetName: string, afterDataSetName: string, options?: IZosFilesOptions): Promise<IZosFilesResponse>;
    /**
     * Rename a data set member
     * @param {AbstractSession}     session             - z/OSMF connection info
     * @param {string}              dataSetName         - the name of the data set the member belongs to
     * @param {string}              beforeMemberName    - the current name of the member
     * @param {string}              afterMemberName     - the new name of the member
     * @returns {Promise<IZosFilesResponse>}
     */
    static dataSetMember(session: AbstractSession, dataSetName: string, beforeMemberName: string, afterMemberName: string, options?: IZosFilesOptions): Promise<IZosFilesResponse>;
    /**
     *
     * @param {AbstractSession}     session             - z/OSMF connection info
     * @param {string}              afterDataSetName    - The new name of the data set in the form 'dataset(member)'
     * @param {IDataSet}            beforeDataSet       - The data set you are renaming
     */
    private static rename;
}
