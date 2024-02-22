import { AbstractSession } from "@zowe/imperative";
import { IZosFilesResponse } from "../../doc/IZosFilesResponse";
import { CreateDataSetTypeEnum } from "./CreateDataSetType.enum";
import { ICreateDataSetOptions } from "./doc/ICreateDataSetOptions";
import { ICreateVsamOptions } from "./doc/ICreateVsamOptions";
import { ICreateZfsOptions } from "./doc/ICreateZfsOptions";
import { IZosFilesOptions } from "../../doc/IZosFilesOptions";
/**
 * Class to handle creation of data sets
 */
export declare class Create {
    /**
     * Create a data set
     * @param {AbstractSession} session                     - z/OSMF connection info
     * @param {CreateDataSetTypeEnum} dataSetType           - the type of data set we are going to create
     * @param {string} dataSetName                          - the name of the data set to create
     * @param {Partial<ICreateDataSetOptions>} [options={}] - overrides the default options provided by dataSetType
     * @returns {Promise<IZosFilesResponse>}
     */
    static dataSet(session: AbstractSession, dataSetType: CreateDataSetTypeEnum, dataSetName: string, options?: Partial<ICreateDataSetOptions>): Promise<IZosFilesResponse>;
    static dataSetLike(session: AbstractSession, dataSetName: string, likeDataSetName: string, options?: Partial<ICreateDataSetOptions>): Promise<IZosFilesResponse>;
    /**
     * Validate supplied parameters
     * @static
     * @param options - additional options for the creation of the data set
     */
    static dataSetValidateOptions(options: ICreateDataSetOptions): void;
    /**
     * Create a VSAM cluster
     * @param {AbstractSession} session - An established z/OSMF session
     * @param {string} dataSetName - the name of the dataset for the created cluster
     * @param {Partial<ICreateVsamOptions>} options - options for the creation of the cluster
     * @example
     * ```typescript
     *
     *     sessCfg: ISession = yourFunctionToCreateSessCfgFromArgs(commandParameters.arguments);
     *     sessCfgWithCreds = await ConnectionPropsForSessCfg.addPropsOrPrompt<ISession>(
     *         sessCfg, commandParameters.arguments
     *     );
     *     session = new Session(sessCfgWithCreds);
     *
     *     // The option keys are defined in ZosFilesCreateOptions,
     *     // ZosFilesCreateExtraOptions and VsamCreateOptions.
     *     //
     *     const createVsamOptions: Partial<ICreateVsamOptions> = {
     *         dsorg: "INDEXED",
     *         size: "640KB",
     *         secondary: 64
     *         showAttributes: true
     *     }));
     *
     *     try {
     *         createResponse = await Create.vsam(
     *             session, "SOME.DATASET.NAME", createVsamOptions
     *         );
     *     }
     *     catch (impErr) {
     *         // handle any error
     *     }
     *
     *     // use the results in createResponse.commandResponse
     * ```
     * @returns {Promise<IZosFilesResponse>}
     */
    static vsam(session: AbstractSession, dataSetName: string, options?: Partial<ICreateVsamOptions>): Promise<IZosFilesResponse>;
    /**
     * Create a uss file or folder
     * @param {AbstractSession} session              - z/OSMF connection info
     * @param {string} ussPath                       - USS path to create file or directory
     * @param {string} type                          - the request type "file" or "directory"
     * @param {string} mode                          - the characters to describe permissions
     * @returns {Promise<IZosFilesResponse>}
     */
    static uss(session: AbstractSession, ussPath: string, type: string, mode?: string, options?: IZosFilesOptions): Promise<IZosFilesResponse>;
    static zfs(session: AbstractSession, fileSystemName: string, options?: Partial<ICreateZfsOptions>): Promise<IZosFilesResponse>;
    /**
     * Convert the options received from the CLI into options that we supply to IDCAMS.
     * @param {ICreateVsamOptions} cliOptions - The set of options from our CLI
     * @returns {ICreateVsamOptions} - Options to provide to IDCAMS.
     */
    private static vsamConvertToIdcamsOptions;
    /**
     * Form the IDCAMS command to create a VSAM cluster
     * @param {string} dataSetName - the name of the dataset for the created cluster
     * @param options - options for the creation of the cluster
     * @returns {string} - The IDCAMS command to be invoked.
     */
    private static vsamFormIdcamsCreateCmd;
    /**
     * Validate the options for the command to create a VSAM cluster
     * @param options - options for the creation of the cluster
     */
    private static vsamValidateOptions;
    /**
     * Validate the options for the command to create a z/OS file system
     * @param options - options for the creation of the file system
     */
    private static zfsValidateOptions;
}
