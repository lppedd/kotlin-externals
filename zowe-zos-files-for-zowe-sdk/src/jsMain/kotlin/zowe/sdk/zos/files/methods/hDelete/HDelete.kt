@file:JsModule("@zowe/zos-files-for-zowe-sdk")

package zowe.sdk.zos.files.methods.hDelete

import js.promise.Promise
import zowe.imperative.error.ImperativeError
import zowe.imperative.rest.session.AbstractSession
import zowe.sdk.core.rest.ZosmfRestClient
import zowe.sdk.zos.files.doc.IZosFilesResponse
import zowe.sdk.zos.files.methods.hDelete.doc.IDeleteOptions
import kotlin.ts.Partial

/**
 * This class holds helper functions that are used to delete data sets through the
 * z/OSMF APIs.
 */
external class HDelete {
  companion object {
    /**
     * See https://www.ibm.com/support/knowledgecenter/SSLTBW_2.4.0/com.ibm.zos.v2r4.izua700/IZUHPINFO_API_PutDataSetMemberUtilities.htm
     *
     * @param session z/OSMF connection info
     * @param dataSetName The name of the data set to recall
     * @param wait If true then the function waits for completion of the request. If false (default) the request is queued.
     *
     * @return A response indicating the status of the deletion
     *
     * @throws ImperativeError Data set name must be specified as a non-empty string
     * @throws Error When the [ZosmfRestClient] throws an error
     */
    fun dataSet(
      session: AbstractSession,
      dataSetName: String,
      options: @Partial IDeleteOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>
  }
}
