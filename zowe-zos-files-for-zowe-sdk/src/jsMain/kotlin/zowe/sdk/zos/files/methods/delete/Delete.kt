@file:JsModule("@zowe/zos-files-for-zowe-sdk")

package zowe.sdk.zos.files.methods.delete

import js.errors.JsError
import js.promise.Promise
import zowe.imperative.error.ImperativeError
import zowe.imperative.rest.session.AbstractSession
import zowe.sdk.core.rest.ZosmfRestClient
import zowe.sdk.zos.files.doc.IZosFilesOptions
import zowe.sdk.zos.files.doc.IZosFilesResponse
import zowe.sdk.zos.files.methods.delete.doc.IDeleteDatasetOptions
import zowe.sdk.zos.files.methods.delete.doc.IDeleteVsamOptions
import zowe.sdk.zos.files.methods.delete.doc.IDeleteVsamResponse

/**
 * This class holds helper functions that are used to delete files through the
 * z/OSMF APIs.
 */
external class Delete {
  companion object {
    /**
     * Deletes a non-VSAM data set
     *
     * See https://www.ibm.com/support/knowledgecenter/en/SSLTBW_2.3.0/com.ibm.zos.v2r3.izua700/IZUHPINFO_API_DeleteDataSet.htm
     *
     * @param session z/OSMF connection info
     * @param dataSetName The name of the data set to delete
     * @param options Additional options for deletion of the data set. Default: {}
     *
     * @return A response indicating the status of the deletion
     *
     * @throws ImperativeError Data set name must be specified as a non-empty string
     * @throws JsError When the [ZosmfRestClient] throws an error
     */
    fun dataSet(
      session: AbstractSession,
      dataSetName: String,
      options: IDeleteDatasetOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Deletes a VSAM data set
     *
     * See https://www.ibm.com/support/knowledgecenter/SSLTBW_2.1.0/com.ibm.zos.v2r1.idai200/delet.htm
     *
     * @param session z/OSMF connection info
     * @param dataSetName The name of the VSAM data set to delete
     * @param options Additional options for deletion of the data set. Default: {}
     *
     * @return A response indicating the status of the deletion
     *
     * @throws ImperativeError Data set name must be specified as a non-empty string
     */
    fun vsam(
      session: AbstractSession,
      dataSetName: String,
      options: IDeleteVsamOptions = definedExternally,
    ): Promise<IDeleteVsamResponse>

    /**
     * Deletes a USS file or directory
     *
     * See https://www.ibm.com/support/knowledgecenter/en/SSLTBW_2.3.0/com.ibm.zos.v2r3.izua700/IZUHPINFO_API_DeleteUnixFile.htm
     *
     * @param session z/OSMF connection info
     * @param fileName The name of the file or directory to delete
     * @param recursive The indicator to delete directory recursively
     * @return A response indicating the status of the deletion
     *
     * @throws ImperativeError Data set name must be specified as a non-empty string
     */
    fun ussFile(
      session: AbstractSession,
      fileName: String,
      recursive: Boolean = definedExternally,
      options: IZosFilesOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Deletes a z/OS file system
     *
     * See https://www.ibm.com/support/knowledgecenter/SSLTBW_2.1.0/com.ibm.zos.v2r1.izua700/IZUHPINFO_API_DeleteUnixzFsFilesystem.htm
     *
     * @param session z/OSMF connection info
     * @param fileSystemName The name of the ZFS to delete
     *
     * @throws ImperativeError File system name must be specified as a non-empty string
     */
    fun zfs(
      session: AbstractSession,
      fileSystemName: String,
      options: IZosFilesOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>
  }
}
