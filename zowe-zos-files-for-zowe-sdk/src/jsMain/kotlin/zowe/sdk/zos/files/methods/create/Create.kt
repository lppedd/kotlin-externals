@file:JsModule("@zowe/zos-files-for-zowe-sdk")

package zowe.sdk.zos.files.methods.create

import js.promise.Promise
import zowe.imperative.rest.session.AbstractSession
import zowe.sdk.zos.files.doc.IZosFilesOptions
import zowe.sdk.zos.files.doc.IZosFilesResponse
import zowe.sdk.zos.files.methods.create.doc.ICreateDataSetOptions
import zowe.sdk.zos.files.methods.create.doc.ICreateVsamOptions
import zowe.sdk.zos.files.methods.create.doc.ICreateZfsOptions

/**
 * Class to handle creation of data sets
 */
external class Create {
  companion object {
    /**
     * Create a data set
     * @param session z/OSMF connection info
     * @param dataSetType the type of data set we are going to create
     * @param dataSetName the name of the data set to create
     * @param options overrides the default options provided by dataSetType. Default: {}
     */
    fun dataSet(
      session: AbstractSession,
      dataSetType: CreateDataSetTypeEnum,
      dataSetName: String,
      options: ICreateDataSetOptions = definedExternally, // Note(Edoardo): should be Partial<ICreateDataSetOptions>
    ): Promise<IZosFilesResponse<Any?>>

    fun dataSetLike(
      session: AbstractSession,
      dataSetName: String,
      likeDataSetName: String,
      options: ICreateDataSetOptions = definedExternally, // Note(Edoardo): should be Partial<ICreateDataSetOptions>
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Validate supplied parameters
     * @param options additional options for the creation of the data set
     */
    fun dataSetValidateOptions(options: ICreateDataSetOptions)

    /**
     * Create a VSAM cluster
     *
     * Example
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
     *
     * @param session An established z/OSMF session
     * @param dataSetName the name of the dataset for the created cluster
     * @param options options for the creation of the cluster
     */
    fun vsam(
      session: AbstractSession,
      dataSetName: String,
      options: ICreateVsamOptions = definedExternally, // Note(Edoardo): should be Partial<ICreateVsamOptions>
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Create a uss file or folder
     * @param session z/OSMF connection info
     * @param ussPath USS path to create file or directory
     * @param type the request type "file" or "directory"
     * @param mode the characters to describe permissions
     */
    fun uss(
      session: AbstractSession,
      ussPath: String,
      type: String,
      mode: String = definedExternally,
      options: IZosFilesOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>

    fun zfs(
      session: AbstractSession,
      fileSystemName: String,
      options: ICreateZfsOptions = definedExternally, // Note(Edoardo): should be Partial<ICreateZfsOptions>
    ): Promise<IZosFilesResponse<Any?>>
  }
}
