@file:JsModule("@zowe/zos-files-for-zowe-sdk")

package zowe.sdk.zos.files.methods.invoke

import js.promise.Promise
import zowe.imperative.error.ImperativeError
import zowe.imperative.rest.session.AbstractSession
import zowe.sdk.core.rest.ZosmfRestClient
import zowe.sdk.zos.files.doc.IZosFilesOptions
import zowe.sdk.zos.files.doc.IZosFilesResponse

/**
 * This class holds helper functions that are used to execute AMS control statements through the z/OS MF APIs
 */
external class Invoke {
  companion object {
    /**
     * Send the AMS request to z/OS MF
     *
     * See https://www.ibm.com/support/knowledgecenter/en/SSLTBW_2.3.0/com.ibm.zos.v2r3.izua700/IZUHPINFO_API_PUTIDCAMSAccessMethodsServices.htm
     *
     * @param session z/OS MF connection info
     * @param controlStatements contains the statements or the file path to them
     *
     * @return A response indicating the outcome of the API
     *
     * @throws ImperativeError controlStatements must be set
     * @throws Error When the [ZosmfRestClient] throws an error
     */
    fun ams(
      session: AbstractSession,
      controlStatements: String,
      options: IZosFilesOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>

    fun ams(
      session: AbstractSession,
      controlStatements: Array<String>,
      options: IZosFilesOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>
  }
}
