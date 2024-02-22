@file:JsModule("@zowe/zos-files-for-zowe-sdk")

package zowe.sdk.zos.files.methods.download

import js.promise.Promise
import zowe.imperative.rest.session.AbstractSession
import zowe.sdk.zos.files.doc.IZosFilesResponse
import zowe.sdk.zos.files.methods.download.doc.IDownloadOptions
import zowe.sdk.zos.files.methods.download.doc.IDownloadSingleOptions
import zowe.sdk.zos.files.methods.list.doc.IUSSListOptions
import zowe.sdk.zos.files.methods.list.doc.IZosmfListResponse

/**
 * This class holds helper functions that are used to download data sets, members and more through the z/OS MF APIs
 */
external class Download {
  companion object {
    /**
     * Retrieve data sets and/or members contents and save them in your local workspace
     *
     * @param session z/OS MF connection info
     * @param dataSetName contains the data set name
     * @param [options={}] - contains the options to be sent
     *
     * @return {Promise<IZosFilesResponse>} A response indicating the outcome of the API
     *
     * @throws {ImperativeError} data set name must be set
     * @throws {Error} When the {@link ZosmfRestClient} throws an error
     *
     * @example
     * ```typescript
     *
     * // Download "USER.DATA.SET.PS" to "user/data/set/ps.txt"
     * await Download.dataSet(session, "USER.DATA.SET.PS");
     *
     * // Download "USER.DATA.SET.PDS(MEMBER)" to "user/data/set/pds/member.txt"
     * await Download.dataSet(session, "USER.DATA.SET.PDS(MEMBER)");
     *
     * // Download "USER.DATA.SET" to "./path/to/file.txt"
     * await Download.dataSet(session, "USER.DATA.SET", {file: "./path/to/file.txt"});
     * ```
     *
     * @see https://www.ibm.com/support/knowledgecenter/en/SSLTBW_2.3.0/com.ibm.zos.v2r3.izua700/IZUHPINFO_API_GetReadDataSet.htm
     */
    fun dataSet(
      session: AbstractSession,
      dataSetName: String,
      options: IDownloadSingleOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Retrieve all members from a PDS and save them in your local workspace
     *
     * @param session z/OS MF connection info
     * @param dataSetName contains the data set name
     * @param [options={}] - contains the options to be sent
     *
     * @return {Promise<IZosFilesResponse>} A response indicating the outcome of the API
     *
     * @throws {ImperativeError} data set name must be set
     * @throws {Error} When the {@link ZosmfRestClient} throws an error
     *
     * @example
     * ```typescript
     *
     * // Download all members of "USER.DATA.SET.PDS" to "user/data/set/pds/"
     * await Download.allMembers(session, "USER.DATA.SET.PDS");
     *
     * // Download all members of "USER.DATA.SET.PDS" to "./path/to/dir/"
     * await Download.allMembers(session, "USER.DATA.SET.PDS", {directory: "./path/to/dir/"});
     * ```
     *
     * @see https://www.ibm.com/support/knowledgecenter/en/SSLTBW_2.3.0/com.ibm.zos.v2r3.izua700/IZUHPINFO_API_GetReadDataSet.htm
     */
    fun allMembers(
      session: AbstractSession,
      dataSetName: String,
      options: IDownloadOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Download a list of data sets to local files
     *
     * @param session z/OS MF connection info
     * @param dataSetObjs contains data set objects returned by z/OSMF List API
     * @param [options={}]    - contains the options to be sent
     *
     * @return {Promise<IZosFilesResponse>} A response indicating the outcome of the API
     *
     * @throws {ImperativeError} data set name must be set
     * @throws {Error} When the {@link ZosmfRestClient} throws an error
     *
     * @example
     * ```typescript
     *
     * // Download a list of "PS" and "PO" datasets to the directory "./path/to/dir/"
     * await Download.allDataSets(session, [
     *    { dsname: "USER.DATA.SET.PS", dsorg: "PS" },
     *    { dsname: "USER.DATA.SET.PDS", dsorg: "PO" }
     * ], {directory: "./path/to/dir/"});
     * ```
     *
     * @see https://www.ibm.com/support/knowledgecenter/SSLTBW_2.2.0/com.ibm.zos.v2r2.izua700/IZUHPINFO_API_GetReadDataSet.htm
     */
    fun allDataSets(
      session: AbstractSession,
      dataSetObjs: Array<IZosmfListResponse>,
      options: IDownloadOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Retrieve USS file content and save it in your local workspace.
     *
     * @param session z/OS MF connection info
     * @param ussFileName contains the USS file name
     * @param [options={}] - contains the options to be sent
     *
     * @return {Promise<IZosFilesResponse>} A response indicating the outcome of the API
     *
     * @throws {ImperativeError} USS file name must be set
     * @throws {Error} When the {@link ZosmfRestClient} throws an error
     */
    fun ussFile(
      session: AbstractSession,
      ussFileName: String,
      options: IDownloadSingleOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Retrieve USS file content and save it in your local workspace.
     *
     * @param session z/OS MF connection info
     * @param ussDirName contains the USS file name
     * @param [fileOptions={}] - contains the file options to be sent
     * @param [listOptions={}] - contains the uss list options to be sent
     *
     * @return {Promise<IZosFilesResponse>} A response indicating the outcome of the API
     *
     * @throws {ImperativeError} USS file name must be set
     * @throws {Error} When the {@link ZosmfRestClient} throws an error
     */
    fun ussDir(
      session: AbstractSession,
      ussDirName: String,
      fileOptions: IDownloadOptions = definedExternally,
      listOptions: IUSSListOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>
  }
}
