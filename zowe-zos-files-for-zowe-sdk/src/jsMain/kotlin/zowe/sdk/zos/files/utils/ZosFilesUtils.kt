@file:JsModule("@zowe/zos-files-for-zowe-sdk")

package zowe.sdk.zos.files.utils

import js.promise.Promise
import node.buffer.Buffer
import zowe.imperative.rest.client.doc.IHeaderContent
import zowe.imperative.rest.session.AbstractSession
import zowe.sdk.zos.files.doc.IDataSet
import zowe.sdk.zos.files.doc.IOptions
import zowe.sdk.zos.files.doc.IZosFilesResponse
import zowe.sdk.zos.files.methods.hDelete.doc.IDeleteOptions
import kotlin.ts.Partial

/**
 * Common IO utilities
 */
external class ZosFilesUtils {
  companion object {
    /**
     * Data set name qualifier separator
     */
    val DSN_SEP: String

    /**
     * Default file extension
     */
    val DEFAULT_FILE_EXTENSION: String
    val MAX_MEMBER_LENGTH: Int

    /**
     * Break up a dataset name of either:
     * ```
     * USER.WORK.JCL(TEMPLATE) to user/work/jcl/template
     * ```
     * Or:
     * ```
     * USER.WORK.PS to user/work/ps
     * ```
     * @param dataSet data set to break up into folders
     */
    fun getDirsFromDataSet(dataSet: String): String

    /**
     * Get fullpath name from input path.
     * @param inputPath input path
     * @return full path version of the input path
     */
    fun getFullPath(inputPath: String): String

    /**
     * Return an array contain the list of all files in the input path. It does not trevor to
     * directory in the input path.
     * @param inputPath input path to gather file list
     * @param inFullPathFormat is the return file path in full path mode flag. Default: true
     * @param isIgnoreHidden is listing hidden files flag. Default: true
     * @return Array of all files finds in path
     */
    fun getFileListFromPath(
      inputPath: String,
      inFullPathFormat: Boolean = definedExternally,
      isIgnoreHidden: Boolean = definedExternally,
    ): Array<String>

    /**
     * Common method to build headers given input options object
     * @param options various options
     */
    fun generateHeadersBasedOnOptions(options: IOptions): Array<IHeaderContent>

    /**
     * Generate member name from input string base on IBM specification
     * @param fileName input name used to generate member name with
     * @return generated member name
     */
    fun generateMemberName(fileName: String): String

    /**
     * Check if the input data set name contain masking characters
     * @param dataSetName input data set name to be checked
     * @return status if data set name contain masking characters
     */
    fun isDataSetNameContainMasking(dataSetName: String): Boolean

    /**
     * Normalize all Windows newline to Unix newline
     * @param buffer data to convert
     * @return converted data
     */
    fun normalizeNewline(buffer: Buffer): Buffer

    /**
     * Normanize and URL-encode a USS path to be passed to z/OSMF
     * @param ussPath path to sanitize
     */
    fun sanitizeUssPathForRestCall(ussPath: String): String

    /**
     * Format USS filepaths in the way that the APIs expect (no leading /)
     * @param usspath the path to format
     */
    fun formatUnixFilepath(usspath: String): String

    /**
     * @param session z/OSMF connection info
     * @param dataSetName The name of the data set to recall|migrate|delete
     * @param returnMessage Message to return based upon command request
     * @param hsmCommand HsmCommand requested
     * @param options
     *   If true then the function waits for completion of the request.
     *   If false (default) the request is queued.
     */
    fun dfsmsHsmCommand(
      session: AbstractSession,
      dataSetName: String,
      returnMessage: String,
      hsmCommand: Any?,
      options: @Partial IDeleteOptions = definedExternally,
    ): Promise<IZosFilesResponse<Any?>>

    /**
     * Converts the name of a data set to an IDataSet
     * @param name the name in the form USER.DATA.SET | USER.DATA.SET(mem1)
     */
    fun getDataSetFromName(name: String): IDataSet
  }
}
