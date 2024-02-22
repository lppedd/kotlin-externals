@file:JsModule("@zowe/zos-files-for-zowe-sdk")

package zowe.sdk.zos.files.methods.list

import js.errors.JsError
import js.promise.Promise
import zowe.imperative.error.ImperativeError
import zowe.imperative.rest.session.AbstractSession
import zowe.sdk.core.rest.ZosmfRestClient
import zowe.sdk.zos.files.doc.IZosFilesResponse
import zowe.sdk.zos.files.methods.list.doc.IDsmListOptions
import zowe.sdk.zos.files.methods.list.doc.IFsOptions
import zowe.sdk.zos.files.methods.list.doc.IListOptions
import zowe.sdk.zos.files.methods.list.doc.IUSSListOptions

/**
 * This class holds helper functions that are used to list data sets and its members through the z/OS MF APIs
 */
external class List {
  companion object {
    /**
     * Retrieve all members from a PDS
     *
     * See https://www.ibm.com/support/knowledgecenter/en/SSLTBW_2.3.0/com.ibm.zos.v2r3.izua700/IZUHPINFO_API_GetListDataSetMembers.htm
     *
     * @param session z/OS MF connection info
     * @param dataSetName contains the data set name
     * @param options contains the options to be sent. Default: {}
     *
     * @return A response indicating the outcome of the API
     *
     * @throws ImperativeError data set name must be set
     * @throws JsError When the [ZosmfRestClient] throws an error
     */
    fun allMembers(
      session: AbstractSession,
      dataSetName: String,
      options: IListOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Retrieve all members from a data set name
     *
     * @param session z/OS MF connection info
     * @param dataSetName contains the data set name
     * @param options contains the options to be sent. Default: {}
     *
     * @return A response indicating the outcome of the API
     *
     * @throws ImperativeError data set name must be set
     * @throws Error When the [ZosmfRestClient] throws an error
     */
    fun dataSet(
      session: AbstractSession,
      dataSetName: String,
      options: IListOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Retrieve a list of all files from a path name
     *
     * @param session z/OS MF connection info
     * @param path contains the uss path name
     * @param options contains the options to be sent. Default: {}
     *
     * @return A response indicating the outcome of the API
     *
     * @throws ImperativeError data set name must be set
     * @throws JsError When the [ZosmfRestClient] throws an error
     */
    fun fileList(
      session: AbstractSession,
      path: String,
      options: IUSSListOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Retrieve zfs files
     *
     * @param session z/OS MF connection info
     * @param options contains the options to be sent. Default: {}
     *
     * @return A response indicating the outcome of the API
     *
     * @throws ImperativeError data set name must be set
     * @throws JsError When the [ZosmfRestClient] throws an error
     */
    fun fs(
      session: AbstractSession,
      options: IFsOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Retrieve zfs files if indicated path
     *
     * @param session z/OS MF connection info
     * @param options contains the options to be sent. Default: {}
     *
     * @return A response indicating the outcome of the API
     *
     * @throws ImperativeError data set name must be set
     * @throws JsError When the [ZosmfRestClient] throws an error
     */
    fun fsWithPath(
      session: AbstractSession,
      options: IFsOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * List data sets that match a DSLEVEL pattern
     *
     * Example:
     * ```typescript
     * // List all "PS" and "PO" datasets that match the pattern "USER.**.DATASET"
     * await List.dataSetsMatchingPattern(session, "USER.**.DATASET");
     * ```
     *
     * @param session z/OSMF connection info
     * @param patterns Data set patterns to include
     * @param options Contains options for the z/OSMF request
     * @return List of z/OSMF list responses for each data set
     */
    fun dataSetsMatchingPattern(
      session: AbstractSession,
      patterns: Array<String>,
      options: IDsmListOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>
  }
}
