@file:JsModule("@zowe/zos-files-for-zowe-sdk")

package zowe.sdk.zos.files.methods.get

import js.promise.Promise
import node.buffer.Buffer
import zowe.imperative.error.ImperativeError
import zowe.imperative.rest.session.AbstractSession
import zowe.sdk.zos.files.methods.get.doc.IGetOptions

/**
 * This class holds helper functions that are used to get the content of data sets or USS files through the z/OSMF APIs
 */
external class Get {
  companion object {
    /**
     * Retrieve data sets content
     *
     * @param session z/OSMF connection info
     * @param dataSetName contains the data set name
     * @param options contains the options to be sent. Default: {}
     *
     * @return Promise that resolves to the content of the data set
     *
     * @throws ImperativeError
     */
    fun dataSet(
      session: AbstractSession,
      dataSetName: String,
      options: IGetOptions = definedExternally,
    ): Promise<Buffer>

    /**
     * Retrieve USS file content
     *
     * @param session z/OSMF connection info
     * @param USSFileName contains the data set name
     * @param options contains the options to be sent. Default: {}
     *
     * @return Promise that resolves to the content of the uss file
     *
     * @throws ImperativeError
     */
    fun USSFile(
      session: AbstractSession,
      USSFileName: String,
      options: IGetOptions = definedExternally,
    ): Promise<Buffer>
  }
}
