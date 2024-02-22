@file:JsModule("@zowe/zos-files-for-zowe-sdk")

package zowe.sdk.zos.files.methods.utilities

import js.promise.Promise
import node.buffer.Buffer
import zowe.imperative.error.ImperativeError
import zowe.imperative.rest.session.AbstractSession
import zowe.sdk.zos.files.doc.IOptions
import zowe.sdk.zos.files.doc.IZosFilesResponse
import zowe.sdk.zos.files.methods.utilities.doc.Tag

external class Utilities {
  companion object {
    /**
     * Retrieve various details from USS file functions
     *
     * This function uses a JSON payload to retrieve information via zosmf utilities function
     *
     * @param session z/OSMF connection info
     * @param USSFileName contains the file name
     * @param payload contains the options to be sent
     *
     * @return Promise that resolves to json information
     *
     * @throws ImperativeError
     */
    fun putUSSPayload(
      session: AbstractSession,
      USSFileName: String,
      payload: Any?,
    ): Promise<Buffer>

    /**
     * Changes the tag attributes associate with a file using function chtag
     *
     * This function uses a JSON payload to set the  information via zosmf utilities function
     *
     * @param session z/OSMF connection info
     * @param type enum of chtag type of Test, Binary or Mixed
     * @param codeset optional string describing codeset e.g. IBM-1047
     *
     * @return Promise that resolves to response object
     *
     * @throws ImperativeError
     */
    fun chtag(
      session: AbstractSession,
      ussFileName: String,
      type: Tag,
      codeset: String = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Based upon the files chtag value. Identify how the tagging should be interpretted when transferring the contents
     * For example an EBCDIC file would always be converted from it's EBCDIC value to the ASCII
     *
     * An ASCII file value or binary should not be converted.
     *
     * The default value if the tag is not set or in an invalid state correctly is to convert.
     *
     * @param session z/OSMF connection info
     * @param USSFileName contains the file name
     *
     * @return Promise that resolves to true if the file is binary or ASCII text or false if file
     *   should likely be converted to text. Default is false which aligns with the zosmf default behavior converting
     *
     * @throws ImperativeError
     */
    fun isFileTagBinOrAscii(
      session: AbstractSession,
      USSFileName: String,
    ): Promise<Boolean>

    /**
     * Check the tags on an existing USS file and update binary and encoding
     * properties on the options object.
     * @param session z/OSMF connection info
     * @param USSFileName Path to USS file
     * @param options Options for downloading a USS file
     */
    fun applyTaggedEncoding(
      session: AbstractSession,
      USSFileName: String,
      options: IOptions,
    ): Promise<Unit>

    /**
     * Re-name USS file or directory
     *
     * @param session z/OSMF connection info
     * @param USSFilePath contains the current filepath
     * @param newFilePath contains the new filepath
     *
     * @return Promise that resolves to json information
     *
     * @throws ImperativeError
     */
    fun renameUSSFile(
      session: AbstractSession,
      USSFilePath: String,
      newFilePath: String,
    ): Promise<Buffer>
  }
}
