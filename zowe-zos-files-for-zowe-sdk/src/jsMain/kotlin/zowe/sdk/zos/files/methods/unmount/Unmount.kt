@file:JsModule("@zowe/zos-files-for-zowe-sdk")

package zowe.sdk.zos.files.methods.unmount

import js.errors.JsError
import js.promise.Promise
import zowe.imperative.error.ImperativeError
import zowe.imperative.rest.session.AbstractSession
import zowe.sdk.core.rest.ZosmfRestClient
import zowe.sdk.zos.files.doc.IZosFilesOptions
import zowe.sdk.zos.files.doc.IZosFilesResponse

/**
 * This class holds helper functions that are used to unmount file systems through the z/OS MF APIs
 */
external class Unmount {
  companion object {
    /**
     * Unmount a Unix file system
     *
     * See https://www.ibm.com/support/knowledgecenter/SSLTBW_2.1.0/com.ibm.zos.v2r1.izua700/IZUHPINFO_API_UnmountUnixFile.htm
     *
     * @param session z/OS MF connection info
     * @param fileSystemName contains the file system name
     * @param options contains the options to use
     *
     * @return A response indicating the outcome of the API
     *
     * @throws ImperativeError file system name must be set
     * @throws JsError When the [ZosmfRestClient] throws an error
     */
    fun fs(
      session: AbstractSession,
      fileSystemName: String,
      options: IZosFilesOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>
  }
}
